package basisFx.appCore.controlPolicy;

import javafx.scene.control.TableColumn;

import java.time.LocalDate;

public class Checking {

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
                }catch (CastException  e){
                    System.err.println("Checking.check   DATE - NOT CAST"   );
                    return false;
                }


            case INT:
                try {
                    Integer newValue = Integer.valueOf((String) event.getNewValue());
                    return true;

                }catch (CastException  e){
                    System.err.println("Checking.check   Integer - NOT CAST"   );
                    return false;
                }

            case REAL:
                try {

                    String string=(String) event.getNewValue();

                    if(string.contains(",")){
                        string=string.replace(',','.');
                    }

                    Double newValue = Double.valueOf(string);

                    return true;

                }catch (CastException  e){
                    System.err.println("Checking.check   Double - NOT CAST"   );
                    return false;
                }


            case STRING:
                try {
                    String newValue = (String) event.getNewValue();
                    return true;
                }catch (CastException  e){
                    System.err.println("Checking.check   String - NOT CAST"   );
                    return false;
                }


            default:
                return  false;




        }

    }

    private class CastException extends ClassCastException{



    }


}
