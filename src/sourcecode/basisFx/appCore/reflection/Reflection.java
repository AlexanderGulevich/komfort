package basisFx.appCore.reflection;

import basisFx.domain.ActiveRecord;
import javafx.beans.property.SimpleObjectProperty;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflection {
    public static ActiveRecord getDomainInstanceFromStaticMethod(Class propertyGenericClass) {

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

    public static boolean isReadyToTransaction(ActiveRecord activeRecord){
        boolean isReady=false;
        Field[] declaredFields = ReflectionInspectDomain.getDeclaredFields(activeRecord);
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            if (ReflectionInspectDomain.isaStaticField(declaredField)) continue;
            SimpleObjectProperty property= ReflectionInspectDomain.getPropertyFromClass(declaredField,activeRecord);
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

}
