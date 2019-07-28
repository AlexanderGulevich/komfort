package basisFx.service;

import basisFx.appCore.events.FileChooser;
import basisFx.appCore.utils.OfficeExtensions;
import basisFx.appCore.utils.Registry;
import basisFx.domain.price.Price;
import basisFx.domain.price.PriceReader;
import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class ServicePanelLoadPrice extends ServicePanels {
    @FXML
    private JFXButton load;
    @FXML
    private Label commonLabelName;
    @FXML
    private TextField textfield;
    @FXML
    private TextArea textarea;

    FileChooser fileChooser;

    @FXML
    private AnchorPane panelAnchor;



    @Override
    public void init() {
        fileChooser = new FileChooser(new OfficeExtensions());
        fileChooser.setEventToElement( load);
        fileChooser.setMediator(this);
    }



    @Override
    public void commonLabelName(String name) {
        commonLabelName.setText(name);
    }


    public ServicePanelLoadPrice() {
        Registry.dataExchanger.put("priceLoader", this);
    }


    @Override
    public void inform(Object node) {
        if (node==load) {
            textarea.clear();
            List<File> files = fileChooser.getFiles();
            PriceReader priceReader = new PriceReader(files.get(0));
            Price price = priceReader.getPrice();

            Registry.dataExchanger.put("price",price);



            ArrayList<String> priceMessage = (ArrayList<String>) Registry.dataExchanger.get("PriceMessage");
            if ( priceMessage.toArray().length>0) {
                textarea.setWrapText(true);
                Optional<String> reduce = priceMessage.stream().distinct().reduce((s, s2) -> s + "\n\n" + s2);
                textarea.setText(reduce.get());
            }





        }


    }

}