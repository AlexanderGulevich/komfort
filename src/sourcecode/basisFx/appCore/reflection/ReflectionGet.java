package basisFx.appCore.reflection;

import basisFx.appCore.DomainPropertiesMetaInfo;
import basisFx.domain.ActiveRecord;
import basisFx.domain.BoolComboBox;

import java.lang.reflect.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReflectionGet {

    public static void setPropertyValueWithSimpleType(ResultSet rs ,
                                                      DomainPropertiesMetaInfo propertiesMetaInfo,
                                                      ActiveRecord activeRecord) {

        String genericShortTypeName = propertiesMetaInfo.getGenericShortTypeName();
        String propertyName = propertiesMetaInfo.getPropertyName();
        Class propertyGenericClass = propertiesMetaInfo.getGenericClass();

        Method setMethod = null;
        try {
            setMethod = activeRecord.getClass().getDeclaredMethod("set" + propertyName, propertyGenericClass);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
            try {
                if (genericShortTypeName.equals("String")) {
                    setMethod.invoke(activeRecord, rs.getString(propertyName));
                }
                if (genericShortTypeName.equals("Double")) {
                    setMethod.invoke(activeRecord, rs.getDouble(propertyName));
                }
                if (genericShortTypeName.equals("Integer")) {
                    setMethod.invoke(activeRecord, rs.getInt(propertyName));
                }
                if (genericShortTypeName.equals("LocalDate")) {
                    setMethod.invoke(activeRecord, rs.getDate(propertyName).toLocalDate());
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }

    }

    public static void setPropertyValueWithDomainType(ResultSet rs ,
                                                      DomainPropertiesMetaInfo propertiesMetaInfo,
                                                      ActiveRecord activeRecord) {

        String genericShortTypeName = propertiesMetaInfo.getGenericShortTypeName();
        String propertyName = propertiesMetaInfo.getPropertyName();
        Class propertyGenericClass = propertiesMetaInfo.getGenericClass();

        try {
            Method find = propertyGenericClass.getSuperclass().getDeclaredMethod("find", int.class);
            ActiveRecord instanceForPropertyObject = Reflection.getDomainInstanceFromStaticMethod(propertyGenericClass);
            ActiveRecord InerRecord=null;
            try {
                InerRecord = (ActiveRecord)find.invoke(instanceForPropertyObject,rs.getInt(propertyName+"Id"));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            Method setMethod = activeRecord.getClass().getDeclaredMethod("set" + propertyName, propertyGenericClass);
            try {
                setMethod.invoke(activeRecord,InerRecord);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public static void setPropertyValueBollComboBox(ResultSet rs ,
                                                      DomainPropertiesMetaInfo propertiesMetaInfo,
                                                      ActiveRecord activeRecord) {
     String propertyName = propertiesMetaInfo.getPropertyName();
     Class propertyGenericClass = propertiesMetaInfo.getGenericClass();
     try {
         Method setMethod = activeRecord.getClass().getDeclaredMethod("set" + propertyName, propertyGenericClass);
         setMethod.invoke(activeRecord, new BoolComboBox(rs.getBoolean(propertyName)));
     } catch (NoSuchMethodException e) {
         e.printStackTrace();
     } catch (IllegalAccessException e) {
         e.printStackTrace();
     } catch (InvocationTargetException e) {
         e.printStackTrace();
     } catch (SQLException e) {
         e.printStackTrace();
     }

 }

    public static void setIdToDomain(ActiveRecord activeRecord, ResultSet rs){
        Method methodIdSetter = null;
        try {
            methodIdSetter = activeRecord.getClass().getSuperclass().getDeclaredMethod("setId" , int.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        try {
            try {
                methodIdSetter.invoke(activeRecord,rs.getInt("id"));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }





}
