package basisFx.appCore.reflection;

import basisFx.appCore.DomainPropertiesMetaInfo;
import basisFx.dataSource.Db;
import basisFx.domain.ActiveRecord;
import basisFx.domain.BoolComboBox;
import javafx.collections.ObservableList;

import java.lang.reflect.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

    public static ActiveRecord findDomain(int id, ActiveRecord activeRecord, ArrayList<DomainPropertiesMetaInfo> domainPropertiesMetaInfoList, String expression) {
        try {
            PreparedStatement pstmt = Db.connection.prepareStatement(expression);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {

                ReflectionGet.setIdToDomain(activeRecord,rs);

                for (DomainPropertiesMetaInfo propertiesMetaInfo : domainPropertiesMetaInfoList) {

                    if(propertiesMetaInfo.getGenericClass().getSuperclass()  == ActiveRecord.class){
                        if(propertiesMetaInfo.getGenericClass()==BoolComboBox.class){
                            ReflectionGet.setPropertyValueBollComboBox(rs,propertiesMetaInfo,activeRecord);
                        }else{
                            ReflectionGet.setPropertyValueWithDomainType(rs,propertiesMetaInfo,activeRecord);
                        }
                    }else{
                        ReflectionGet.setPropertyValueWithSimpleType(rs,propertiesMetaInfo,activeRecord);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return activeRecord;
    }

    public static ObservableList<ActiveRecord> getAllDomains(
            ActiveRecord record,
            ObservableList<ActiveRecord> list,
            ArrayList<DomainPropertiesMetaInfo> domainPropertiesMetaInfoList,
            ResultSet rs) {
        try {
            while (rs.next()) {
                ActiveRecord activeRecord = Reflection.createNewInstance(record);
                ReflectionGet.setIdToDomain(activeRecord,rs);

                for (DomainPropertiesMetaInfo propertiesMetaInfo : domainPropertiesMetaInfoList) {

                    if(propertiesMetaInfo.getGenericClass().getSuperclass()  == ActiveRecord.class){
                        if(propertiesMetaInfo.getGenericClass()==BoolComboBox.class){
                            ReflectionGet.setPropertyValueBollComboBox(rs,propertiesMetaInfo,activeRecord);
                        }else{
                            ReflectionGet.setPropertyValueWithDomainType(rs,propertiesMetaInfo,activeRecord);
                        }
                    }else{
                        ReflectionGet.setPropertyValueWithSimpleType(rs,propertiesMetaInfo,activeRecord);
                    }
                }
                list.add(activeRecord);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }






}
