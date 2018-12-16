package basisFx.appCore.reflection;

import basisFx.appCore.DomainPropertiesMetaInfo;
import basisFx.domain.ActiveRecord;
import basisFx.domain.BoolComboBox;
import javafx.beans.property.SimpleObjectProperty;

import java.lang.reflect.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ActiveRecordReflection {


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
            ActiveRecord instanceForPropertyObject = getDomainInstanceFromStaticMethod(propertyGenericClass);
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

    private static ActiveRecord getDomainInstanceFromStaticMethod(Class propertyGenericClass) {

        ActiveRecord record =null;
        try {
            Method getINSTANCE = propertyGenericClass.getDeclaredMethod("getINSTANCE");
             record = (ActiveRecord) getINSTANCE.invoke(null);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return record;

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


    public static ActiveRecord createNewInstance(ActiveRecord record){
        Class<? extends ActiveRecord> aClass = record.getClass();
        ActiveRecord activeRecord=null;
        try {
            activeRecord = aClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return  activeRecord;


    }

    public static ArrayList<DomainPropertiesMetaInfo> inspectDomainProperties(ActiveRecord record) {
        ArrayList<DomainPropertiesMetaInfo> domainPropertiesMetaInfoList =new ArrayList<>();
        Field[] declaredFields = getDeclaredFields(record);
        for (Field field : declaredFields) {
            field.setAccessible(true);
            if (isaStaticField(field)) continue;
            Type type = field.getGenericType();
            if (type instanceof ParameterizedType) {

                String shortGenericTypeName = retrieveShortGenericTypeName(record,field, (ParameterizedType) type);
                String fullGenericTypeName = retrieveFullGenericTypeName(record,field, (ParameterizedType) type);
                String propertyName = retrievePropertyName(record,field);
                Class genericClass = retrievGenericClass(record, field,(ParameterizedType) type);

                DomainPropertiesMetaInfo info = new DomainPropertiesMetaInfo();
                info.setGenericFullTypeName(fullGenericTypeName);
                info.setGenericShortTypeName(shortGenericTypeName);
                info.setPropertyName(propertyName);
                info.setGenericClass(genericClass);



                domainPropertiesMetaInfoList.add(info);
            }
        }
        return domainPropertiesMetaInfoList;
    }

    public static String retrievePropertyName(ActiveRecord record, Field field) {
        SimpleObjectProperty property= getPropertyFromClass(field,record);
        String propertyName = property.getName();
        propertyName = propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1);
        return propertyName;
    }

    public static String retrieveShortGenericTypeName(ActiveRecord record, Field field, ParameterizedType type) {
        Type parameterizedType = getParameterizedType(record,type, field);
        String typeName = parameterizedType.getTypeName();
        SimpleObjectProperty obj = null;
        String[] arr = typeName.split("\\.");
        return arr[arr.length - 1];
    }

    public static Class retrievGenericClass(ActiveRecord record, Field field, ParameterizedType type) {
        Type parameterizedType = getParameterizedType(record,type, field);
        String typeName = parameterizedType.getTypeName();
        Class<?> aClass=null;
        try {
            aClass = Class.forName(typeName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return aClass;
    }

    public static String retrieveFullGenericTypeName(ActiveRecord record, Field field, ParameterizedType type) {
        Type parameterizedType = getParameterizedType(record,type, field);
        String typeName = parameterizedType.getTypeName();
        return  typeName;
    }

    public static boolean isaStaticField(Field field) {
        return java.lang.reflect.Modifier.isStatic(field.getModifiers());
    }

    public static Type getParameterizedType(ActiveRecord record,ParameterizedType type, Field field) {
        ParameterizedType pt = type;
        Type rawType = pt.getRawType();
        Type ownerType = pt.getOwnerType();
        Type[] actualTypeArguments = pt.getActualTypeArguments();
        Type argument = actualTypeArguments[0];
        SimpleObjectProperty property= getPropertyFromClass(field,record);
        return argument ;
    }

    public static Field[] getDeclaredFields(ActiveRecord record) {
        Class<? extends ActiveRecord> aClass = record.getClass();
        return aClass.getDeclaredFields();
    };

    public static  SimpleObjectProperty getPropertyFromClass(Field declaredField, ActiveRecord record) {
        try {
            return (SimpleObjectProperty) declaredField.get(record);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;

    }

}
