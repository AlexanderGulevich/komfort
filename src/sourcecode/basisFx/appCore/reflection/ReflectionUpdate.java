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
            pstmt.setInt(counter, activeRecord.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
