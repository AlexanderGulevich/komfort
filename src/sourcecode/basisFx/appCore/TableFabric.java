package basisFx.appCore;

import basisFx.appCore.controlPolicy.ColumnWrapper;
import basisFx.appCore.controlPolicy.EditFabric;
import basisFx.appCore.dataSource.DataMapper;
import basisFx.appCore.elements.AppNode;
import basisFx.appCore.elements.TableViewWrapper;
import basisFx.appCore.utils.Coordinate;
import basisFx.domainModel.settings.CSSID;
import javafx.scene.layout.AnchorPane;

public class TableFabric {

    protected EditFabric editFabric=new EditFabric();

    public TableViewWrapper createStandartTable(AnchorPane panel, double width, Coordinate coordinate,
                                                DataMapper dataMapper,
                                                ColumnWrapper...columnWrappers){

        return AppNode.NodeBuilder.create()
                .setId(CSSID.TABLE)
                .setEditPoliticy(editFabric.createDefaultEditCommit())
                .setParent(panel).setCoordinate(coordinate)
                .createTableViewWrapper().setTablesWidthProperty(width, panel.widthProperty())
                .setDataMapper(dataMapper)
                .setEditable(true)
                .setColums(columnWrappers)
                .refresh();


    }



    public TableViewWrapper createSubmitTable(AnchorPane panel, double width, Coordinate coordinate,
                                                DataMapper dataMapper,
                                                ColumnWrapper...columnWrappers){

        return AppNode.NodeBuilder.create()
                .setId(CSSID.TABLE)
                .setEditPoliticy(editFabric.createMultipleSubmitEditCommit())
                .setParent(panel).setCoordinate(coordinate)
                .createTableViewWrapper().setTablesWidthProperty(width, panel.widthProperty())
                .setDataMapper(dataMapper)
                .setEditable(true)
                .setColums(columnWrappers)
                .refresh();


    }



    public TableViewWrapper createBoundTable(TableViewWrapper observer,AnchorPane panel, double width, Coordinate coordinate,
                                                DataMapper dataMapper,
                                                ColumnWrapper...columnWrappers){

        return AppNode.NodeBuilder.create()
                .setId(CSSID.TABLE)
                .setEditPoliticy(editFabric.createDefaultEditCommit())
                .setParent(panel).setCoordinate(coordinate)
                .createTableViewWrapper().setTablesWidthProperty(width, panel.widthProperty())
                .setDataMapper(dataMapper)
                .setEditable(true)
                .setColums(columnWrappers)
                .setBoundTable(observer)
                .refresh();


    }


}
