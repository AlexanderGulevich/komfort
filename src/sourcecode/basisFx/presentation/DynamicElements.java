package basisFx.presentation;

import basisFx.appCore.elements.AnchorWrapper;
import basisFx.appCore.grid.GridPaneWrapper;
import basisFx.appCore.settings.CSSID;
import basisFx.appCore.utils.Coordinate;
import basisFx.appCore.windows.MainWindow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public abstract class DynamicElements {

    protected AnchorPane innerAnchorPane;
    protected AnchorPane commonAnchorPane;
    protected GridPaneWrapper gridPaneWrapper;
    protected GridPane commonGridPane;


    public DynamicElements() {
        createPanel();
    }

    protected abstract void init();

    public AnchorPane getTargetElement() {
       return  this.commonAnchorPane;
    }

    protected void createPanel(){
        createCommonPane();
        createInnerLevelPane();
    }

    private void createInnerLevelPane() {
        innerAnchorPane= AnchorWrapper.newBuilder()
                .setCoordinate(new Coordinate(10d, 10d, 10d, 10d))
                .setParentAnchor(commonAnchorPane)
                .build().getElement();
    }

    private void createCommonPane() {
        commonAnchorPane = AnchorWrapper.newBuilder()
                .setCSSid(CSSID.TARGET_PANEL)
                .setCoordinate(new Coordinate(0d, 0d, 0d, 0d))
                .setParentAnchor(MainWindow.getInstance().getWindow().getTopVisibleAnchor())
                .build().getElement();
    }


}
