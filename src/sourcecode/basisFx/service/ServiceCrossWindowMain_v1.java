package basisFx.service;

import basisFx.appCore.events.StageDragging;
import basisFx.appCore.settings.FontsStore;
import basisFx.appCore.utils.FontLogic;
import basisFx.appCore.utils.Registry;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ServiceCrossWindowMain_v1 extends ServiceCrossWindow   {

    @FXML private AnchorPane verticalMenuAnchor;
    @FXML private AnchorPane leftButAnchor;
    @FXML private AnchorPane iconAnchor;
    @FXML private AnchorPane mainContentAnchor;
    @FXML private AnchorPane titleAnchor;
    @FXML private Label companyNameText;
    @FXML private Label commonMenuLabel;
    @FXML private FlowPane horisontalMenuButHolderFlowPane;
    @FXML private HBox horisontalMenuButHolder;
    @FXML private VBox vButHolder;

    public ServiceCrossWindowMain_v1() {
        Registry.crossWindowMediators.put("Main_v1",this);
    }

    @Override
    public void init() {

        Registry.mainWindow.setNodeToMap(horisontalMenuButHolder,"horisontalMenuButHolder");
        Registry.mainWindow.setNodeToMap(vButHolder,"vButHolder");
        Registry.mainWindow.setNodeToMap(leftButAnchor,"leftButAnchor");
        Registry.mainWindow.setNodeToMap(verticalMenuAnchor,"verticalMenuAnchor");
        Registry.mainWindow.setNodeToMap(iconAnchor,"iconAnchor");
        Registry.mainWindow.setNodeToMap(mainContentAnchor,"mainContentAnchor");
        Registry.mainWindow.setNodeToMap(titleAnchor,"titleAnchor");
        Registry.mainWindow.setNodeToMap(companyNameText,"companyNameText");
        Registry.mainWindow.setNodeToMap(commonMenuLabel,"commonMenuLabel");
        Registry.mainWindow.setNodeToMap(horisontalMenuButHolderFlowPane,"horisontalMenuButHolderFlowPane");

        new StageDragging().setEventToElement(titleAnchor);
        companyNameText.setFont(FontLogic.loadFont(FontsStore.ROBOTO_BOLD,35));


    }

    @Override
    public void inform(Object node) {

    }
}