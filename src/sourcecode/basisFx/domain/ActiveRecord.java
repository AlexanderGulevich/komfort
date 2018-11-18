package basisFx.domain;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import basisFx.appCore.DomainMetaInfo;
import basisFx.appCore.interfaces.DateGetter;
import basisFx.dataSource.Db;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public abstract class ActiveRecord {
    public String entityName;
    public int outerId;
    public ObjectProperty<Integer> id =new SimpleObjectProperty<>(this, "id", null);
    public abstract ObservableList <ActiveRecord>  getAll();
    public abstract void update();
    public abstract ActiveRecord find(int id);
    public abstract String toString();
    public abstract void insert();
    public abstract ObservableList<ActiveRecord> findAllByOuterId(int id);
    public ActiveRecord(String entityName) {
        this.entityName = entityName;
    }
    public Integer getId() {
        return id.get();
    }
    public void setId(int value) {
        this.id.set(value);
    }
    public  ObservableList<ActiveRecord>  createNewActiveRecordList() {
        return FXCollections.<ActiveRecord>observableArrayList();
    }
    public static boolean isNewDomane(ActiveRecord record) {
        if (record != null) {
            if (record.getId() !=null) {
                return false;
            }else{
                return true;
            }
        }else{
            throw new  NullPointerException();
        }

    }


//    public  ObservableList <ActiveRecord>  getAll(){
//        ArrayList<DomainMetaInfo>  domainMetaInfoList = inspectDomainProperties();
//        String query="Select * from "+ this.entityName+ " ";
//        for (DomainMetaInfo info:domainMetaInfoList) {
//            query=query+info.getTypeName()+ ","
//        }
//
//
//        return null;
//
//
//    }
//
//    private   ArrayList<DomainMetaInfo>   inspectDomainProperties() {
//      ArrayList<DomainMetaInfo>  domainMetaInfoList=new ArrayList<>();
//        Field[] declaredFields = getDeclaredFields();
//        for (Field field : declaredFields) {
//            field.setAccessible(true);
//            if (isaStaticField(field)) continue;
//            Type type = field.getGenericType();
//            if (type instanceof ParameterizedType) {
//                String typeName = retrieveGenericTypeName(field, (ParameterizedType) type);
//                String propertyName = retrievePropertyName(field);
//                domainMetaInfoList.add(new DomainMetaInfo(typeName,propertyName));
//            }
//        }
//        return domainMetaInfoList;
//    }
//
//    private String retrievePropertyName(Field field) {
//        SimpleObjectProperty property= getPropertyFromClass(field,this);
//        return property.getName();
//    }
//
//    private String retrieveGenericTypeName(Field field, ParameterizedType type) {
//        Type parameterizedType = getParameterizedType(type, field);
//        String typeName = parameterizedType.getTypeName();
//        SimpleObjectProperty obj = null;
//        String[] arr = typeName.split("\\.");
//        return arr[arr.length - 1];
//    }
//
    private boolean isaStaticField(Field field) {
        return java.lang.reflect.Modifier.isStatic(field.getModifiers());
    }
//
//    private Type getParameterizedType(ParameterizedType type, Field field) {
//        ParameterizedType pt = type;
//        Type rawType = pt.getRawType();
//        Type ownerType = pt.getOwnerType();
//        Type[] actualTypeArguments = pt.getActualTypeArguments();
//        Type argument = actualTypeArguments[0];
//        SimpleObjectProperty property= getPropertyFromClass(field,this);
//        return argument ;
//    }
//
    private Field[] getDeclaredFields() {
        Class<? extends ActiveRecord> aClass = this.getClass();
        return aClass.getDeclaredFields();
    };



    public boolean isReadyToTransaction(){
        boolean isReady=false;
        Field[] declaredFields = getDeclaredFields();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            if (isaStaticField(declaredField)) continue;
            SimpleObjectProperty property= getPropertyFromClass(declaredField,this);
            Object obj = property.get();
            if (obj!= null ) {
                isReady=true;
            }else {
                isReady=false;
                break;
            }
    }
        return isReady;
    }


    public void delete(){
            try {
                String expression="delete from " +entityName+" where id=? ";
                PreparedStatement pstmt =  Db.connection.prepareStatement(expression);
                pstmt.setInt(1, this.id.get());
                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    // getAll(list) записывает в  list значения ReturnSet БД
    // далее идет преобразование каждой строки БД в HashMap, где ключем является id
//    public HashMap<Integer,ActiveRecord> toHashMapByCommonRawId(ObservableList<ActiveRecord> list){
//        list.clear();
//        getAll();
//
//        HashMap<Integer,ActiveRecord> hm=new HashMap<>();
//
//        for (ActiveRecord domainObject : list) {
//
//            Integer id = domainObject.getId();
//            hm.put(id,domainObject);
//        }
//
//        return hm;
//
//    }


    // getAll(list) записывает в  list значения ReturnSet БД
    // далее идет преобразование каждой строки БД в HashMap, где ключем является id
    // а значение ComboBoxValue для вставки в ComboBox
//    public HashMap<Integer,ComboBoxValue> toComboBoxValHashMap(ObservableList<ActiveRecord> list, StringGetterFromDomain stringGetterFromDomain){
//        list.clear();
//        getAll();
//
//        HashMap<Integer,ComboBoxValue> hm=new HashMap<>();
//
//        for (ActiveRecord domainObject : list) {
//
//            Integer id = domainObject.getId();
//
//            ComboBoxValue comboBoxValue = new ComboBoxValue(
//                    stringGetterFromDomain.get(domainObject),
//                    domainObject.getId()
//            );
//
//            hm.put(id,comboBoxValue);
//
//
//        }
//
//        return hm;
//
//    }



    /**
     * Эта функция неоходима для того, чтобы не допустить в связанных таблицах попадание тарифа или цены или курса в базу данных
     * с одной и той же датой. Дата в разрезе одного конкретного одентификатора, например сотрудника или продукта должна быть уникальной в БД
     * Должна использоваться в insert и update методах отображателей
     * @return Возвращает TRUE если в БД есть значение на данную дату по данной сущности
     */
    public boolean isUniquenessStartingDate(ObservableList<ActiveRecord>  records, DateGetter dateGetter , LocalDate testedDate ){
//todo сделать вывод сцены
        long count = records.stream().filter(activeRecord -> dateGetter.getDate(activeRecord).isEqual(testedDate)).count();

        if (count>0) {
            return false;

        }
        return true;
    }




//
//     todo           Platform.runLater(() -> {
//
//
//                    String message="В Базе Данных уже есть значение на дату: "
//                            + date.toString()+
//                            ". Создать новую запись с такой же датой нельзя." +
//                            " Вы можете изменить старую, либо удалить ее.";
//                });
//





//    private EmployeesRatePerHour getNewest(Integer id){
//
//        EmployeesRatePerHour newestRate=null;
//
//        ArrayList<EmployeesRatePerHour> ratePerHoursList = ratesMapById.get(id);
//
//        if (ratePerHoursList != null) {
//            for (EmployeesRatePerHour rate:ratePerHoursList) {
//
//                if (newestRate == null) {
//
//                    newestRate=rate;
//
//                }
//
//                if (rate.getStartingDate().isAfter(newestRate.getStartingDate())){
//                    newestRate=rate;
//                }
//            }
//        }
//
//
//        return newestRate;
//
//
//
//    }



    private SimpleObjectProperty getPropertyFromClass(Field declaredField, ActiveRecord record) {
        try {
            return (SimpleObjectProperty) declaredField.get(record);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;

    }

}


