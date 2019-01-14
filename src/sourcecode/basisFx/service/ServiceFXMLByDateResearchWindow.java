package basisFx.service;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;


public class ServiceFXMLByDateResearchWindow {
    @FXML
    private AnchorPane tableHolderAnchor;
    @FXML
    private Button addBut;
    @FXML
    private Button delBut;
    @FXML
    private Label title;
    @FXML
    private DatePicker dateStart;
    @FXML
    private DatePicker dateEnd;
    @FXML
    private ComboBox combobox;


    public ServiceFXMLByDateResearchWindow() {
        System.out.println("first");
    }
    @FXML
    public void initialize() {
        System.out.println("second");
//        new StageDragging().setEventToElement(left);
    }

}
