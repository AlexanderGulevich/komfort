package basisFx.service;

import basisFx.appCore.utils.FXMLLoader;
import basisFx.appCore.utils.Registry;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class ServiceChartPanelRightControls extends ServiceChartPanels {
    @FXML private AnchorPane filtrerTitle;
    @FXML private VBox rightVbox;
    @FXML private DatePicker dateStart;
    @FXML private DatePicker dateEnd;
    @FXML private ComboBox combobox;
    @FXML private FontAwesomeIcon questionSighn;
    @FXML private AnchorPane labelAnchor;
    @FXML private Label commonLabelName;
    @FXML private AnchorPane chartAnchor;


    public ServiceChartPanelRightControls() {
        Registry.dataExchanger.put("ServiceChartPanelRightControls",this);
    }


    @Override
    public void inform(Object node) {
    }



}
