package basisFx.appCore.reflection;

import basisFx.domain.ActiveRecord;
import basisFx.domain.BoolComboBox;
import javafx.beans.property.SimpleObjectProperty;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;

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

    public static Method getMethod(String propertyName, Class activeRecordClass){
        String name = propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1);
        Method method = null;
        try {
            method = activeRecordClass.getDeclaredMethod("get" + name);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return method;
    }



    public static Boolean invokeBooleanGetter(ActiveRecord activeRecord, Method method) {
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
    public static ActiveRecord invokeDomainGetter(ActiveRecord activeRecord, Method method) {
        ActiveRecord value=null;
        try {
            value = (ActiveRecord) method.invoke(activeRecord);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return value;
    }
    public static String invokeStringGetter(ActiveRecord activeRecord, Method method) {
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
    public static Integer invokeIntegerGetter(ActiveRecord activeRecord, Method method) {
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
    public static Double invokeDoubleGetter(ActiveRecord activeRecord, Method method) {
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

    public static LocalDate invokeLocalDateGetter(ActiveRecord activeRecord, Method method) {
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


}
