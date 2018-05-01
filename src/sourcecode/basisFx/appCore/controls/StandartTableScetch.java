package basisFx.appCore.controls;

import basisFx.appCore.elements.AppNode;
import basisFx.appCore.elements.LabelWrapper;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.settings.CSSID;
import basisFx.appCore.settings.FontsStore;
import basisFx.appCore.utils.Coordinate;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class StandartTableScetch extends ScretchedTable {


    public StandartTableScetch(AnchorPane anchorPane,Coordinate coordinate) {
        this.parentAnchorPane=anchorPane;
        this.coordinate=coordinate;
    }
    public StandartTableScetch(GridPane gridPane) {
        this.parentGridPane=gridPane;
    }
    public StandartTableScetch() {

    }

    @Override
    public void init() {
        Coordinate overallAnchorCoordinate=coordinate;


        LabelWrapper label = textFabric.createLabel(title, FontsStore.ROBOTO_LIGHT, Pos.BASELINE_LEFT, 25d);

        TableWrapper tableWrapper= AppNode.NodeBuilder.create()
                .setId(CSSID.TABLE)
                .setEditCreater(()-> {return editFabric.createDefaultEditCommit();})
                .createTableViewWrapper()
                .setDataMapper(dataMapper)
                .setEditable(true)
                .setColums(columnWrappers)
                .refresh();


        Button buttonAdd = buttonFactory.addRowButton(tableWrapper, domainClass);
        Button buttonDel =buttonFactory.deleteRowButton(tableWrapper);
        Button buttonAddLittle = buttonFactory.littleRowAddButton(tableWrapper,domainClass );
        Button buttonDelLittle =buttonFactory.littleRowDeleteButton(tableWrapper ) ;

        gridPaneWrapper = AppNode.NodeBuilder.create()
                .setCoordinate(coordinate)
                .setParent(parentAnchorPane)
                .createGridPaneWrapper();



        switch (tablesButtonKind){
            case Right_little:
                gridPaneWrapper.setColumn();
                gridPaneWrapper.setColumnAndWidth(40d);
                gridPaneWrapper.addSpanNode(label.getElement(),0,0,1,1);
                gridPaneWrapper.addNode(buttonAddLittle,1,1);
                gridPaneWrapper.addNode(buttonDelLittle,1,2);
                gridPaneWrapper.addNode(tableWrapper.getElement(),0,1);

            case TOP_right_little:

            case Bottom_right_little:

            case Bottom_right:

            case TOP_right:


            case Right:

        }









    }
}
