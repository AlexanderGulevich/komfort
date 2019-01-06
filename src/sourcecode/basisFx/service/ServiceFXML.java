package basisFx.service;
import basisFx.appCore.events.StageDragging;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class ServiceFXML {
//    @FXML
//    private AnchorPane left;
//    @FXML
//    private void leftclick(ActionEvent event) {
//    }


    public ServiceFXML() {
        System.out.println("first");
    }
    @FXML
    public void initialize() {
        System.out.println("second");
//        new StageDragging().setEventToElement(left);
    }




}
