package basisFx.service;

import basisFx.appCore.elements.DatePickerHandler;
import basisFx.appCore.elements.DatePickerWrapper;
import basisFx.appCore.events.CallBackEvent;
import basisFx.appCore.events.ClosePopupAndSubWindow;
import basisFx.appCore.events.StageDragging;
import basisFx.appCore.utils.Registry;
import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.time.LocalDate;

public class WindowServiceDatePicker extends WindowService {
    @FXML private JFXButton okBut;
    @FXML private Label title;
    @FXML private Label dateLsabel;
    @FXML private AnchorPane titleAnchor;
    @FXML private DatePicker datePicker;
    DatePickerHandler datePickerHandler;
    @FXML public void initialize() {
    }
    public WindowServiceDatePicker() {
        Registry.crossWindowMediators.put("SelectDate",this);
    }
    @Override
    public void init() {
        new StageDragging().setEventToElement(titleAnchor);
        datePickerHandler=new DatePickerHandler(datePicker,this);
        new  ClosePopupAndSubWindow().setEventToElement(okBut);
        dateLsabel.setText("Дата для проводок");
    }
    @Override
    public void inform(Object node) {
        if (node==datePickerHandler){
            LocalDate localDate = datePicker.getValue();
//            dateLsabel.setText(
//                    localDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
//            );
            Registry.dataExchanger.put("SelectedDateFromPopup",localDate);
        }
        }


}
