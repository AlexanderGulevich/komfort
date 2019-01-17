package basisFx.appCore.elements;

import basisFx.service.Mediator;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.DatePicker;
import javafx.util.StringConverter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class DatePickerHandler {

    private DatePicker datePicker;
    private LocalDate selectedDate;
    private Mediator mediator;

    public DatePickerHandler(DatePicker datePicker, Mediator mediator) {
        this.datePicker = datePicker;
        this.mediator = mediator;

        datePicker.setOnAction((e) -> {
            this.selectedDate = datePicker.getValue();
            mediator.inform(this);
        });

//        datePicker.valueProperty().addListener(new ChangeListener<LocalDate>() {
//            @Override
//            public void changed(ObservableValue<? extends LocalDate> observable, LocalDate oldValue, LocalDate newValue) {
//                selectedDate = datePicker.getValue();
//                mediator.inform(this);
//            }
//        });

        datePicker.setConverter(new CustomStringConverter());

    }


    public LocalDate getSelectedDate() {
        return selectedDate;
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
