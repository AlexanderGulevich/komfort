package basisFx.appCore.reflection;

import basisFx.appCore.utils.DomainPropertiesMetaInfo;
import basisFx.dataSource.Db;
import basisFx.domain.ActiveRecord;
import basisFx.domain.BoolComboBox;

import java.lang.reflect.Method;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ReflectionInsert {
    public static String createInsertExpression(ActiveRecord activeRecord, ArrayList<DomainPropertiesMetaInfo> domainPropertiesMetaInfoList) {
        String expression =" INSERT INTO "  + activeRecord.entityName + " (  ";
        for (DomainPropertiesMetaInfo propertiesMetaInfo : domainPropertiesMetaInfoList) {
            if(propertiesMetaInfo.getGenericClass().getSuperclass()  == ActiveRecord.class){
                if(propertiesMetaInfo.getGenericClass()== BoolComboBox.class){
                    expression+=" "+propertiesMetaInfo.getPropertyName()+",";
                }else{
                    expression+=" "+propertiesMetaInfo.getPropertyName()+"Id"+",";
                }
            }else{
                expression+=" "+propertiesMetaInfo.getPropertyName()+",";
            }
        }
        expression=expression.substring(0,expression.length()-1);
        expression+=" ) VALUES(" ;

        int length = domainPropertiesMetaInfoList.toArray().length;
        for (int i = 0; i < length; i++) {
            expression+="?,";
        }
        expression=expression.substring(0,expression.length()-1);
        expression=expression+")";


        return expression;

    }

    public static void executeInsertStatement(ActiveRecord activeRecord, String insertExpression, ArrayList<DomainPropertiesMetaInfo> domainPropertiesMetaInfoList) {
        PreparedStatement pstmt = null;
        try {
            pstmt = Db.connection.prepareStatement(insertExpression);
            int counter=1;
            for (DomainPropertiesMetaInfo propertiesMetaInfo : domainPropertiesMetaInfoList) {

                String genericShortTypeName = propertiesMetaInfo.getGenericShortTypeName();
                String propertyName = propertiesMetaInfo.getPropertyName();
                Class propertyGenericClass = propertiesMetaInfo.getGenericClass();
                Method method = Reflection.getMethod(propertyName, activeRecord.getClass());

                if(propertyGenericClass.getSuperclass()  == ActiveRecord.class){
                    if(propertiesMetaInfo.getGenericClass()== BoolComboBox.class){
                        Boolean val = Reflection.invokeBooleanGetter(activeRecord, method);
                        pstmt.setBoolean(counter, val);
                    }else{
                        ActiveRecord val = Reflection.invokeDomainGetter(activeRecord, method);
                        pstmt.setInt(counter, val.getId());
                    }
                }else{
                    if (genericShortTypeName.equals("String")) {
                        String val = Reflection.invokeStringGetter(activeRecord, method);
                        pstmt.setString(counter, val);
                    }
                    if (genericShortTypeName.equals("Double")) {
                        Double val = Reflection.invokeDoubleGetter(activeRecord, method);
                        pstmt.setDouble(counter, val);
                    }
                    if (genericShortTypeName.equals("Integer")) {
                        Integer val = Reflection.invokeIntegerGetter(activeRecord, method);
                        pstmt.setInt(counter, val);
                    }
                    if (genericShortTypeName.equals("LocalDate")) {
                        LocalDate val = Reflection.invokeLocalDateGetter(activeRecord, method);
                        pstmt.setDate(counter, Date.valueOf(val));
                    }
                }
                counter++;
            }
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}