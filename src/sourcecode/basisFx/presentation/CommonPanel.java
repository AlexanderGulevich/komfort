package basisFx.presentation;

import basisFx.appCore.DynamicContentPanel;
import basisFx.appCore.grid.ButSizeEnum;
import basisFx.appCore.grid.CtrlPosEnum;
import basisFx.appCore.panelSets.SingleTableSet;
import basisFx.appCore.settings.FontsStore;
import basisFx.appCore.table.ColumnFabric;
import basisFx.appCore.utils.Coordinate;
import basisFx.appCore.utils.FXMLLoader;
import basisFx.appCore.utils.FontLogic;
import basisFx.appCore.utils.Registry;
import basisFx.domain.Counterparty;
import basisFx.domain.Currency;
import basisFx.service.CommonLabel;
import basisFx.service.WindowService;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class CommonPanel extends DynamicContentPanel {
    String fontSymbol;
    FontsStore fontsStore;
    double fontSize;

    private Label commonLabel;

    public CommonPanel(String fontSymbol, FontsStore fontsStore) {
        this.fontSymbol = fontSymbol;
        this.fontsStore = fontsStore;
        this.fontSize = fontSize;
    }

    @Override
    public void customDynamicElementsInit() {
        FXMLLoader.loadAnchorPane("categiriesPanel");
        CommonLabel panel = (CommonLabel) Registry.crossWindowMediators.get("CommonLabel");
        Coordinate coordinate = new Coordinate(0d, 0d, 0d, 0d);
        coordinate.setParentAnchorPane(dynamicContentAnchorHolder);
        coordinate.setChildNode(panel.getAnchor());
        coordinate.bonding();

        commonLabel = panel.getCommonLabel();
        commonLabel.setText(fontSymbol);
        commonLabel.setFont(FontLogic.loadFont(fontsStore,200));
    }
}
