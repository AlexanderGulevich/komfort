package basisFx.service;

import basisFx.appCore.events.CloseMainWindow;
import basisFx.appCore.events.StageDragging;
import basisFx.appCore.utils.Registry;
import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class WindowServiceMain_v2 extends WindowService {

    @FXML private AnchorPane verticalMenuAnchor;
    @FXML private AnchorPane leftButAnchor;
    @FXML private AnchorPane mainContentAnchor;
    @FXML private AnchorPane titleAnchor;
    @FXML private Label commonMenuLabel;
    @FXML private VBox vButHolder;
    @FXML private JFXButton cls_but;

    public WindowServiceMain_v2() {
        Registry.crossWindowMediators.put("Main_v2",this);
    }

    @Override
    public void init() {

        Registry.mainWindow.setNodeToMap(vButHolder,"vButHolder");
        Registry.mainWindow.setNodeToMap(leftButAnchor,"leftButAnchor");
        Registry.mainWindow.setNodeToMap(verticalMenuAnchor,"verticalMenuAnchor");
        Registry.mainWindow.setNodeToMap(mainContentAnchor,"mainContentAnchor");
        Registry.mainWindow.setNodeToMap(titleAnchor,"titleAnchor");
        Registry.mainWindow.setNodeToMap(commonMenuLabel,"commonMenuLabel");

        new StageDragging().setEventToElement(titleAnchor);
        new CloseMainWindow().setEventToElement(cls_but,Registry.mainWindow.getStage());
//        companyNameText.setFont(FontLogic.loadFont(FontsStore.ROBOTO_BOLD,35));


    }

    @Override
    public void inform(Object node) {

    }
}