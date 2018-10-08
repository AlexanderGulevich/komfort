package basisFx.presentation;

import basisFx.appCore.elements.AnchorWrapper;
import basisFx.appCore.grid.GridPaneWrapper;
import basisFx.appCore.settings.CSSID;
import basisFx.appCore.utils.Coordinate;
import basisFx.appCore.windows.MainWindow;
import basisFx.dataSource.UnitOfWork;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public abstract class TargetPanel {

    protected AnchorPane innerAnchorPane;
    protected AnchorPane commonAnchorPane;
    protected UnitOfWork unitOfWork=new UnitOfWork();


    public TargetPanel() {
        createPanels();
    }

    public abstract void init();

    protected void createPanels(){
        createCommonPane();
        createInnerLevelPane();
    }

    private void createInnerLevelPane() {
        innerAnchorPane= AnchorWrapper.newBuilder()
                .setCoordinate(new Coordinate(0d, 0d, 0d, 0d))
                .setParentAnchor(commonAnchorPane)
                .build().getElement();

    }

    private void createCommonPane() {
        AnchorPane  mainContentAnchor = ((AnchorPane ) MainWindow.getInstance()
                .getWindowNode("contentAnchorPane").getElement());

        commonAnchorPane = AnchorWrapper.newBuilder()
                .setCSSid(CSSID.TARGET_PANEL)
                .setCoordinate(new Coordinate(10d, 10d, 10d, 10d))
                .setParentAnchor(mainContentAnchor)
                .build().getElement();



    }


}
