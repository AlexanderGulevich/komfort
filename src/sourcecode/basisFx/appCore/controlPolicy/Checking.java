package basisFx.appCore.controlPolicy;

import basisFx.appCore.fabrics.WindowFabric;
import javafx.scene.control.TableColumn;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.zip.DataFormatException;

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
                }catch (DateTimeException e){
                    System.err.println("Checking.check   DATE - NOT CAST"   );
                    return false;
                }


            case INT:
                try {
                    Integer newValue = Integer.valueOf((String) event.getNewValue());
                    return true;

                }catch (NumberFormatException  e){
                    System.err.println("Checking.check   Integer - NOT CAST"   );
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

               new WindowFabric().createPopapUnDecoratedWindow(70d,80d).windowShow();
                    System.err.println("Checking.check   Double - NOT CAST"   );
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
