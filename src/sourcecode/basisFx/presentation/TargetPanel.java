package basisFx.presentation;

import basisFx.appCore.elements.AnchorWrapper;
import basisFx.appCore.settings.CSSID;
import basisFx.appCore.utils.Coordinate;
import basisFx.appCore.windows.WindowImpl;
import basisFx.appCore.windows.WindowImplMain;
import basisFx.dataSource.UnitOfWork;
import javafx.scene.layout.AnchorPane;

public abstract class TargetPanel {

    protected AnchorPane innerAnchorPane;
    protected AnchorPane commonAnchorPane;
    protected UnitOfWork unitOfWork=new UnitOfWork();
    protected AnchorPane  mainContentAnchor;

    public TargetPanel() {
        mainContentAnchor =((AnchorPane ) WindowImplMain.getInstance()
                .getWindowNode("contentAnchorPane_mainWindow").getElement());
        createPanels();

    }
    public TargetPanel(WindowImpl window ) {
        AnchorPane mainContentAnchor = ((AnchorPane) window.getWindowNode("contentAnchorPane").getElement());
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

        commonAnchorPane = AnchorWrapper.newBuilder()
                .setCSSid(CSSID.TARGET_PANEL)
                .setCoordinate(new Coordinate(0d, 10d, 10d, 10d))
                .setParentAnchor(mainContentAnchor)
                .build().getElement();



    }


}
