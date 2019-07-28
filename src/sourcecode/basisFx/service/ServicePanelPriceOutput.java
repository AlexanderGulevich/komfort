package basisFx.service;

import basisFx.appCore.events.DirectoryChosserEvent;
import basisFx.appCore.utils.Registry;
import basisFx.domain.price.Price;
import basisFx.domain.price.WritePrice;
import basisFx.presentation.PriceWritter;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;


public class ServicePanelPriceOutput extends ServicePanels {
    @FXML
    private JFXButton output;
    @FXML
    private JFXButton saveTamplate;
    @FXML
    private Label commonLabelName;
    @FXML
    private TextField textfield;
    @FXML
    private FlowPane flowpane;
    @FXML
    private JFXCheckBox checkAll;
    @FXML
    private JFXCheckBox addImage;
    @FXML
    private JFXCheckBox standatrCategory;
    @FXML
    private ComboBox tamplateCombobox;
    @FXML
    private AnchorPane panelAnchor;

    DirectoryChosserEvent directoryChosserEvent;

    @Override
    public void init() {
        directoryChosserEvent = new DirectoryChosserEvent();
        directoryChosserEvent.setEventToElement(output);
        directoryChosserEvent.setMediator(this);
        directoryChosserEvent.setCallBackTyped(() -> {
            Price price = (Price) Registry.dataExchanger.get("price");
            if (price == null) {
                Registry.windowFabric.infoWindow("Для того, чтобы сохранить обработанный прайс, его нужно сначала загрузить из остатков!");
                return false;
            }
            return true;
            }

        );
    }



    @Override
    public void commonLabelName(String name) {
        commonLabelName.setText(name);
    }


    public ServicePanelPriceOutput() {
        Registry.dataExchanger.put("priceWritter", this);
    }


    @Override
    public void inform(Object node) {
        if (node==output) {

            String path = directoryChosserEvent.getPath();
            Price price = (Price) Registry.dataExchanger.get("price");
            new WritePrice(price, path);


        }


    }

}