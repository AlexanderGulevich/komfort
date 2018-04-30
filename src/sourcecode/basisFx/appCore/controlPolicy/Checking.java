package basisFx.appCore.controlPolicy;

import basisFx.appCore.fabrics.WindowFabric;
import basisFx.appCore.windows.KindOfPopup;
import basisFx.appCore.windows.PopupUndecorated;
import javafx.scene.control.TableColumn;

import java.time.DateTimeException;
import java.time.LocalDate;

public class Checking {

    protected static PopupUndecorated popupUndecorated;
    protected static WindowFabric windowFabric= new WindowFabric();
    protected static String message=   "\n"+
            "   Произошла ошибка. В поле\n" +
            "   было  введено   неправильное\n" +
            "   значение.";


    public  static <T, K> boolean check(KindOfColumn kindOfColumn,TableColumn.CellEditEvent<T, K> event){



        switch (kindOfColumn) {

            case BOOL:
                return true;


            case COMBOBOX:
                return true;


            case DATE:
                try {
                    LocalDate newValue = (LocalDate) event.getNewValue();
                    return true;
                }catch (DateTimeException e){
                    popupUndecorated =windowFabric.popupUndecorated(KindOfPopup.ERROR);
                    popupUndecorated.setMessage(message);
                    return false;
                }


            case INT:
                try {
                    Integer newValue = Integer.valueOf((String) event.getNewValue());
                    return true;

                }catch (NumberFormatException  e){
                    popupUndecorated =windowFabric.popupUndecorated(KindOfPopup.ERROR);
                    popupUndecorated.setMessage(message);
                    return false;
                }

            case DOUBLE:
                try {

                    String string=(String) event.getNewValue();

                    if(string.contains(",")){
                        string=string.replace(',','.');
                    }

                    Double newValue = Double.parseDouble(string);

                    return true;

                }catch (NumberFormatException   e){

                    popupUndecorated =windowFabric.popupUndecorated(KindOfPopup.ERROR);
                    popupUndecorated.setMessage(message);

                    return false;
                }


            case STRING:
                    return true;


            default:
                return  false;




        }

    }

    private class CastException extends Exception{



    }


}
