package basisFx.appCore.elements;

import basisFx.appCore.interfaces.ObservableVidget;
import basisFx.appCore.domainScetch.DomainObject;
import basisFx.appCore.settings.CSSID;
import javafx.collections.ObservableList;
import javafx.scene.control.DatePicker;
import javafx.util.StringConverter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class DatePickerWrapper  extends AppNode implements ObservableVidget {

    private DatePicker datePicker;
    private ObservableList<DomainObject> list;


    public DatePickerWrapper(NodeBuilder builder) {
        datePicker = new DatePicker();
        element=datePicker;
        init(builder);

           datePicker.setId(CSSID.DATEPICKER_IN_COLUMN.get());

            datePicker.setPrefWidth(width);
           datePicker.setConverter(new CustomStringConverter());
           datePicker.setPromptText("");

           datePicker.setOnAction((e) -> {

               if (valueAddToObservers != null) {
                   for (DomainObject domainObject : list) {

                       System.out.println("DatePickerWrapper------valueAddToObservers  !=NULL");
                       valueAddToObservers.add(domainObject, LocalDate.from(datePicker.getValue()));

                   }
               }else {

                   System.out.println("DatePickerWrapper------valueAddToObservers=NULL");
               }


           System.out.println("Committed: " + datePicker.getValue().toString());

//                commitEdit(LocalDate.from(datePicker.getRate().atStartOfDay(ZoneId.systemDefault()).toInstant()));
//           commitEdit(datePicker.getValue());
           });
//           datePicker.focusedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
//        if (!newValue) {
////                    commitEdit(LocalDate.from(datePicker.getRate().atStartOfDay(ZoneId.systemDefault()).toInstant()));
//        commitEdit(datePicker.getValue());
//        }
//        });
        }


    @Override
    public void insertList(ObservableList<DomainObject> list) {
        this.list=list;

    }


    class CustomStringConverter extends StringConverter<LocalDate> {
    DateTimeFormatter dateFormatter =//DateTimeFormatter.ofPattern("dd-MM-yyyy");
            DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
    @Override
    public String toString(LocalDate date) {
        if (date != null) {
            return dateFormatter.format(date);
        } else {
            return "";
        }
    }

    @Override
    public LocalDate fromString(String string) {
        if (string != null && !string.isEmpty()) {
            return LocalDate.parse(string, dateFormatter);
        } else {
            return null;
        }
    }
}


}
