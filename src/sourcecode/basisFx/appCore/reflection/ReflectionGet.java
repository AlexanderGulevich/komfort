package basisFx.appCore.reflection;

import basisFx.appCore.annotation.DataStore;
import basisFx.appCore.annotation.Sorting;
import basisFx.appCore.utils.DomainPropertiesMetaInfo;
import basisFx.appCore.utils.Range;
import basisFx.dataSource.Db;
import basisFx.domain.ActiveRecord;
import basisFx.domain.BoolComboBox;
import javafx.collections.ObservableList;

import java.lang.reflect.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static basisFx.appCore.utils.Range.ACTUAL;

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


    public static String createfindAllByOuterIdExpression(ActiveRecord record,
                                                          ArrayList<DomainPropertiesMetaInfo> domainPropertiesMetaInfoList,
                                                          int id) {
        String expression = "Select * from " + record.entityName + " ";
        String sorting=null;
        String where_expr=null;
        for (DomainPropertiesMetaInfo info : domainPropertiesMetaInfoList) {
            DataStore dataStoreAnnotation = info.getDataStoreAnnotation();
            if (dataStoreAnnotation != null) {
                if (dataStoreAnnotation.SORTING()==Sorting.ASK) {
                    sorting=" "+" ORDER BY "  + info.getPropertyName()+" "+"ASK";
                }
                if (dataStoreAnnotation.SORTING()==Sorting.DESC) {
                    sorting=" "+" ORDER BY "  + info.getPropertyName()+" "+"DESC";
                }
                if (dataStoreAnnotation.AS_OUTER_ID()) {
                    where_expr= " "+ "where "+info.getPropertyName()+"="+id;
                }
            }
        }
        return expression =expression +where_expr+sorting;
    }

    public static String createfindAllByOuterIdAndRangeExpression(ActiveRecord record,
                                                          ArrayList<DomainPropertiesMetaInfo> domainPropertiesMetaInfoList,
                                                          int id, Range range) {
        String expression = "Select * from " + record.entityName ;
        String sorting=null;
        String outerIdExp=null;
        String limit=null;
        String analizedDateName=null;
        String year=null;
        String month=null;
        String intervalDays=null;

        for (DomainPropertiesMetaInfo info : domainPropertiesMetaInfoList) {
            DataStore dataStoreAnnotation = info.getDataStoreAnnotation();
            if (dataStoreAnnotation != null) {
                if (dataStoreAnnotation.SORTING()==Sorting.ASK) {
                    sorting=" "+" ORDER BY "  + info.getPropertyName()+" "+"ASK";
                }
                if (dataStoreAnnotation.SORTING()==Sorting.DESC) {
                    sorting=" "+" ORDER BY "  + info.getPropertyName()+" "+"DESC";
                }
                if (dataStoreAnnotation.AS_OUTER_ID()) {
                    outerIdExp = " "+info.getPropertyName()+"="+id;
                }
                if (dataStoreAnnotation.ANALIZED_DATE()) {
                    analizedDateName = info.getPropertyName();
                }
             }
        }

        switch (range) {
            case  ACTUAL: limit=" LIMIT 1 ";
                break;
            case  ALLTIME:
                break;
            case  YEAR:year=" YEAR("+analizedDateName+") =YEAR(CURRENT_DATE) ";
                break;
            case  MONTH:month=" MONTH("+analizedDateName+") =MONTH(CURRENT_DATE) AND  YEAR("+analizedDateName+") =YEAR(CURRENT_DATE) ";
                break;
            case  DAY30: intervalDays=analizedDateName+" >= (NOW() - INTERVAL 30 DAY) AND ("+analizedDateName+" <= NOW()) ";
                break;
            case  DAY60:intervalDays=analizedDateName+" >= (NOW() - INTERVAL 60 DAY) AND ("+analizedDateName+" <= NOW()) ";
                break;
            case  DAY90:intervalDays=analizedDateName+">= (NOW() - INTERVAL 90 DAY) AND ("+analizedDateName+" <= NOW()) ";
                break;
            case  DAY180:intervalDays=analizedDateName+" >= (NOW() - INTERVAL 180 DAY) AND ("+analizedDateName+" <= NOW()) ";
                break;
            case  LAST10: limit=" LIMIT 10 ";
                break;
            case  LAST30: limit=" LIMIT 30 ";
                break;


        }
        String where_EXP=null;
        if (outerIdExp != null)   where_EXP= " where "+ outerIdExp;
        if (year != null) {
            if (where_EXP != null)  {
                where_EXP+=" and "+year;
            } else {
                where_EXP= year;
            }
        }
        if (month != null) {
            if (where_EXP != null)  {
                where_EXP+=" and "+month;
            } else {
                where_EXP= month;
            }
        }
        if (intervalDays != null) {
            if (where_EXP != null)  {
                where_EXP+=" and "+intervalDays;
            } else {
                where_EXP= intervalDays;
            }
        }


        if (sorting == null) sorting=" ";
        if (limit == null) limit=" ";

        return expression =expression +where_EXP +sorting + limit;

    }
}
