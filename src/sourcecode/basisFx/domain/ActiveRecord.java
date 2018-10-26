package basisFx.domain;

import java.lang.reflect.Field;
import java.sql.*;
import java.time.LocalDate;

import basisFx.appCore.interfaces.DateGetter;
import basisFx.dataSource.Db;
import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public abstract class ActiveRecord {
    public String entityName;
    public int outerId;
    public ObjectProperty<Integer> id =new SimpleObjectProperty<>(this, "id", null);
    public  abstract ComboBoxValue toComboBoxValue();
    public abstract ObservableList <ActiveRecord>  getAll();
    public abstract void update();
    public abstract ActiveRecord find(int id);
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
    public  static ActiveRecord getInstance(){return  null;};
    public  ObservableList<ActiveRecord>  createNewActiveRecordList() {
        return FXCollections.<ActiveRecord>observableArrayList();
    }
    public static boolean isNewDomane(ActiveRecord record) {
        if (record != null && record.getId() !=null) {
            return false;
        }
        return true;
    }
    public boolean isReadyToTransaction(){
        boolean isReady=false;
        Class<? extends ActiveRecord> aClass = this.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            if (java.lang.reflect.Modifier.isStatic(declaredField.getModifiers())) {
                continue;
            }
            SimpleObjectProperty property= getPropertyFromClass(declaredField,this);
            Object obj = property.get();
            if (obj!= null ) {
                isReady=true;
            }else {
                return false;
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
    public ObservableList<ComboBoxValue> toComboBoxValueList(){
        ObservableList<ActiveRecord> list = getAll();
        ObservableList<ComboBoxValue> comboBoxValueList= FXCollections.observableArrayList();
        for (ActiveRecord domainObject : list) {
            comboBoxValueList.add(domainObject.toComboBoxValue());
        }
        return comboBoxValueList;

    }

//    public void deleteForBoundTables(ActiveRecord domainObject, String observedtableName,String observertableName){
//
//        if (domainObject != null) {
//            try {
//                String expression_1="delete from " +observedtableName+" where id=? ";
//                PreparedStatement pstmt_1 =  Db.connection.prepareStatement(expression_1);
//                pstmt_1.setInt(1, domainObject.getId());
//                pstmt_1.executeUpdate();
//
//
//                String expression_2="delete from " +observertableName+" where id=? ";
//                PreparedStatement pstmt_2 =  Db.connection.prepareStatement(expression_2);
//                pstmt_2.setInt(1, domainObject.getId());
//                pstmt_2.executeUpdate();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        else {
//            System.out.println("ActiveRecord.deleteForBoundTables - domainObject is NULL");
//        }
//    }




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
    public boolean isUniquenessDate( ObservableList<ActiveRecord>  records, DateGetter dateGetter , LocalDate testedDate ){

        long count = records.stream().filter(
                activeRecord -> dateGetter.getDate(activeRecord).isEqual(testedDate)).count();

        if (count>0) {
            return false;

        }
        return true;
    }



//
//                Platform.runLater(() -> {
//
//
//                    String message="В Базе Данных уже есть значение на дату: "
//                            + date.toString()+
//                            ". Создать новую запись с такой же датой нельзя." +
//                            " Вы можете изменить старую, либо удалить ее.";
//                });
//







//    private EmployeesRatePerHour getNewest(Integer id){}




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


//
//    SELECT * FROM PRODUCTPRICESTORE
//    WHERE PRODUCTID=2
//    AND STARTDATE=(
//            SELECT MAX(STARTDATE) FROM PRODUCTPRICESTORE
//    WHERE PRODUCTID=2
//	)

    private SimpleObjectProperty getPropertyFromClass(Field declaredField, ActiveRecord record) {
        try {
            return (SimpleObjectProperty) declaredField.get(record);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;

    }

}


