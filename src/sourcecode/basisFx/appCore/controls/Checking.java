package basisFx.appCore.controls;

import javafx.scene.control.TableColumn;

import java.time.DateTimeException;
import java.time.LocalDate;

public class Checking {

//    protected static PopupUndecorated popupUndecorated;
    protected static String message=   "Произошла ошибка.\nВ поле было введено неправильное значение.";


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


                    return false;
                }


            case INT:
                try {
                    Integer newValue = Integer.valueOf((String) event.getNewValue());
                    return true;

                }catch (NumberFormatException  e){


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
