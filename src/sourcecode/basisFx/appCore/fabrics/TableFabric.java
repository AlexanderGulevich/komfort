package basisFx.appCore.fabrics;

import basisFx.appCore.SubmitElement;
import basisFx.appCore.controlPolicy.ColumnWrapper;
import basisFx.appCore.dataSource.DataMapper;
import basisFx.appCore.elements.AppNode;
import basisFx.appCore.elements.TableViewWrapper;
import basisFx.appCore.utils.Coordinate;
import basisFx.appCore.settings.CSSID;
import javafx.scene.layout.AnchorPane;

public class TableFabric {

    protected EditFabric editFabric=new EditFabric();

    public TableViewWrapper createStandartTable(AnchorPane panel, double width, Coordinate coordinate,
                                                DataMapper dataMapper,
                                                ColumnWrapper...columnWrappers){

        return AppNode.NodeBuilder.create()
                .setId(CSSID.TABLE)
//                .setEditPoliticy(editFabric.createDefaultEditCommit())
                .setEditCreater(()-> {return editFabric.createDefaultEditCommit();})
                .setParent(panel).setCoordinate(coordinate)
                .createTableViewWrapper().setTablesWidthProperty(width, panel.widthProperty())
                .setDataMapper(dataMapper)
                .setEditable(true)
                .setColums(columnWrappers)
                .refresh();


    }



    public TableViewWrapper createSubmitTable(SubmitElement mark, AnchorPane panel, double width, Coordinate coordinate,
                                              DataMapper dataMapper,
                                              ColumnWrapper...columnWrappers){

        return AppNode.NodeBuilder.create()
                .setId(CSSID.TABLE).setMark(mark)
//                .setEditPoliticy(editFabric.createMultipleSubmitEditCommit())
                .setEditCreater(()-> {return editFabric.createMultipleSubmitEditCommit();})
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
                .setEditCreater(()-> {return editFabric.createDefaultEditCommit();})
                .setParent(panel).setCoordinate(coordinate)
                .createTableViewWrapper().setTablesWidthProperty(width, panel.widthProperty())
                .setDataMapper(dataMapper)
                .setEditable(true)
                .setColums(columnWrappers)
                .setBoundTable(observer)
                .refresh();


    }


}
