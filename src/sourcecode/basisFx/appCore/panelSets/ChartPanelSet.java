package basisFx.appCore.panelSets;

import basisFx.appCore.utils.Coordinate;
import basisFx.appCore.utils.FXMLLoader;
import basisFx.appCore.utils.Registry;
import basisFx.appCore.windows.WindowAbstraction;
import basisFx.service.ServiceChartPanels;
import javafx.scene.layout.AnchorPane;
import lombok.Builder;
import lombok.Setter;

@Builder
public class ChartPanelSet implements PanelSets {
    @Setter private ServiceChartPanels service;
    @Setter private WindowAbstraction currentWindow;
    @Setter private String fxmlFileName;
    @Setter private AnchorPane parent;
    @Setter private Coordinate coordinate;


    @Override
    public void configure() {


        service = (ServiceChartPanels) Registry.dataExchanger.get("fxmlFileName");

        AnchorPane anchorPaneFromFXML = FXMLLoader.loadAnchorPane(this.fxmlFileName);
        coordinate.setChildNode(anchorPaneFromFXML);
        coordinate.setParentAnchorPane(parent);
        coordinate.bonding();


    }

}
