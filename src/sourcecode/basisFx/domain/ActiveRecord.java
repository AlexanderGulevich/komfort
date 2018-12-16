package basisFx.domain;

import java.lang.reflect.Field;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

import basisFx.appCore.DomainPropertiesMetaInfo;
import basisFx.appCore.interfaces.DateGetter;
import basisFx.appCore.reflection.ActiveRecordReflection;
import basisFx.dataSource.Db;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public abstract class ActiveRecord {
    public String entityName;
    public int outerId;
    public ObjectProperty<Integer> id =new SimpleObjectProperty<>(this, "id", null);
    public abstract void update();
//    public abstract ActiveRecord find(int id);
    public abstract String toString();
    public abstract void insert();
    public abstract ObservableList<ActiveRecord> findAllByOuterId(int id);
    public ActiveRecord( ) {
        String name = this.getClass().getName();
        String[] arr = name.split("\\.");
        name= arr[arr.length - 1];
        this.entityName =name;

    }
    public Integer getId() {
        return id.get();
    }
    public void setId(int value) {
        this.id.set(value);
    }
    public  ObservableList <ActiveRecord>  getAllByDate(LocalDate date){return null;};
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
    public  ObservableList <ActiveRecord>  getAll() {
        ObservableList <ActiveRecord> list= FXCollections.observableArrayList();
        ArrayList<DomainPropertiesMetaInfo> domainPropertiesMetaInfoList = ActiveRecordReflection.inspectDomainProperties(this);
        ResultSet rs = executeQuery("Select * from " + this.entityName + " order by id ");
        try {
            while (rs.next()) {
                ActiveRecord activeRecord = ActiveRecordReflection.createNewInstance(this);
                ActiveRecordReflection.setIdToDomain(activeRecord,rs);

                for (DomainPropertiesMetaInfo propertiesMetaInfo : domainPropertiesMetaInfoList) {

                    if(propertiesMetaInfo.getGenericClass().getSuperclass()  == ActiveRecord.class){
                        if(propertiesMetaInfo.getGenericClass()==BoolComboBox.class){
                            ActiveRecordReflection.setPropertyValueBollComboBox(rs,propertiesMetaInfo,activeRecord);
                        }else{
                            ActiveRecordReflection.setPropertyValueWithDomainType(rs,propertiesMetaInfo,activeRecord);
                        }
                    }else{
                        ActiveRecordReflection.setPropertyValueWithSimpleType(rs,propertiesMetaInfo,activeRecord);
                    }
                }
                list.add(activeRecord);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }


    public ActiveRecord find(int id) {
        ActiveRecord activeRecord = ActiveRecordReflection.createNewInstance(this);
        ArrayList<DomainPropertiesMetaInfo> domainPropertiesMetaInfoList = ActiveRecordReflection.inspectDomainProperties(this);
        String expression="SELECT  * FROM " +this.entityName+" WHERE ID=?";

        try {
            PreparedStatement pstmt = Db.connection.prepareStatement(expression);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {

                ActiveRecordReflection.setIdToDomain(activeRecord,rs);

                for (DomainPropertiesMetaInfo propertiesMetaInfo : domainPropertiesMetaInfoList) {

                    if(propertiesMetaInfo.getGenericClass().getSuperclass()  == ActiveRecord.class){
                        if(propertiesMetaInfo.getGenericClass()==BoolComboBox.class){
                            ActiveRecordReflection.setPropertyValueBollComboBox(rs,propertiesMetaInfo,activeRecord);
                        }else{
                            ActiveRecordReflection.setPropertyValueWithDomainType(rs,propertiesMetaInfo,activeRecord);
                        }
                    }else{
                        ActiveRecordReflection.setPropertyValueWithSimpleType(rs,propertiesMetaInfo,activeRecord);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return activeRecord;
    }

    private ResultSet executeQuery(String expression)   {
        try (
                Statement stmt = Db.connection.createStatement()) {
                ResultSet resultSet;
            try {
                resultSet = stmt.executeQuery(expression);
                return resultSet;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public boolean isReadyToTransaction(){
        boolean isReady=false;
        Field[] declaredFields = ActiveRecordReflection.getDeclaredFields(this);
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            if (ActiveRecordReflection.isaStaticField(declaredField)) continue;
            SimpleObjectProperty property= ActiveRecordReflection.getPropertyFromClass(declaredField,this);
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




}


