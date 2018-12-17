package basisFx.appCore.reflection;

import basisFx.appCore.DomainPropertiesMetaInfo;
import basisFx.dataSource.Db;
import basisFx.domain.ActiveRecord;
import basisFx.domain.BoolComboBox;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ReflectionUpdate {

    public static String createUpdateExpression(ActiveRecord activeRecord,ArrayList<DomainPropertiesMetaInfo> domainPropertiesMetaInfoList ){
        String expression = "UPDATE " + activeRecord.entityName + " SET  ";
        for (DomainPropertiesMetaInfo propertiesMetaInfo : domainPropertiesMetaInfoList) {
            if(propertiesMetaInfo.getGenericClass().getSuperclass()  == ActiveRecord.class){
                if(propertiesMetaInfo.getGenericClass()== BoolComboBox.class){
                    expression+=" "+propertiesMetaInfo.getPropertyName()+"=?,";
                }else{
                    expression+=" "+propertiesMetaInfo.getPropertyName()+"Id"+"=?,";
                }
            }else{
                expression+=" "+propertiesMetaInfo.getPropertyName()+"=?,";
            }
        }
        expression=expression.substring(0,expression.length()-1);
        expression+=" where id=?";
        return expression;

    }

    public static void executePepareStatement(ActiveRecord activeRecord, String updateExpression,ArrayList<DomainPropertiesMetaInfo> domainPropertiesMetaInfoList ){
        PreparedStatement pstmt = null;
        try {
            pstmt = Db.connection.prepareStatement(updateExpression);
            int counter=1;
            for (DomainPropertiesMetaInfo propertiesMetaInfo : domainPropertiesMetaInfoList) {

                String genericShortTypeName = propertiesMetaInfo.getGenericShortTypeName();
                String propertyName = propertiesMetaInfo.getPropertyName();
                Class propertyGenericClass = propertiesMetaInfo.getGenericClass();
                Method method = getMethod(propertyName, activeRecord.getClass());

                if(propertyGenericClass.getSuperclass()  == ActiveRecord.class){
                    if(propertiesMetaInfo.getGenericClass()== BoolComboBox.class){
                        Boolean val = invokeBooleanGetter(activeRecord, method);
                        pstmt.setBoolean(counter, val);
                    }else{
                        ActiveRecord val = invokeDomainGetter(activeRecord, method);
                        pstmt.setInt(counter, val.getId());
                    }
                }else{
                    if (genericShortTypeName.equals("String")) {
                        String val = invokeStringGetter(activeRecord, method);
                        pstmt.setString(counter, val);
                    }
                    if (genericShortTypeName.equals("Double")) {
                        Double val = invokeDoubleGetter(activeRecord, method);
                        pstmt.setDouble(counter, val);
                    }
                    if (genericShortTypeName.equals("Integer")) {
                        Integer val = invokeIntegerGetter(activeRecord, method);
                        pstmt.setInt(counter, val);
                    }
                    if (genericShortTypeName.equals("LocalDate")) {
                        LocalDate val = invokeLocalDateGetter(activeRecord, method);
                        pstmt.setDate(counter, Date.valueOf(val));
                    }
                }
                counter++;
            }
            pstmt.setInt(counter, activeRecord.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Boolean invokeBooleanGetter(ActiveRecord activeRecord, Method method) {
        BoolComboBox value=null;
        try {
             value = (BoolComboBox) method.invoke(activeRecord);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return value.getBoolean();
    }
    private static ActiveRecord invokeDomainGetter(ActiveRecord activeRecord, Method method) {
        ActiveRecord value=null;
        try {
            value = (BoolComboBox) method.invoke(activeRecord);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return value;
    }
    private static String invokeStringGetter(ActiveRecord activeRecord, Method method) {
        String value=null;
        try {
            value = (String) method.invoke(activeRecord);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return value;
    }
    private static Integer invokeIntegerGetter(ActiveRecord activeRecord, Method method) {
        Integer value=null;
        try {
            value = (Integer) method.invoke(activeRecord);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return value;
    }
    private static Double invokeDoubleGetter(ActiveRecord activeRecord, Method method) {
        Double value=null;
        try {
            value = (Double) method.invoke(activeRecord);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return value;
    }

    private static LocalDate invokeLocalDateGetter(ActiveRecord activeRecord, Method method) {
        LocalDate value=null;
        try {
            value = (LocalDate) method.invoke(activeRecord);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return value;
    }

    private static Method getMethod(String propertyName, Class activeRecordClass){
        String name = propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1);
        Method method = null;
        try {
            method = activeRecordClass.getDeclaredMethod("get" + name);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return method;
    }

}
