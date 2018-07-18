package basisFx.appCore.fabrics;

import basisFx.appCore.KindOfSubmitElement;
import basisFx.appCore.controls.ColumnWrapper;
import basisFx.appCore.dataSource.DataMapper;
import basisFx.appCore.elements.AppNode;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.utils.Coordinate;
import basisFx.appCore.settings.CSSID;
import javafx.scene.layout.AnchorPane;

public class TableFabric {
    protected TextFabric textFabric=new TextFabric();
    protected ButtonFactory buttonFactory =new ButtonFactory();
    protected EditFabric editFabric=new EditFabric();


    public TableWrapper table(AnchorPane panel, double width, Coordinate coordinate,
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


    public TableWrapper submitTable(KindOfSubmitElement mark, AnchorPane panel, double width, Coordinate coordinate,
                                    DataMapper dataMapper,
                                    ColumnWrapper...columnWrappers){

        return AppNode.NodeBuilder.create()
                .setId(CSSID.TABLE).setKindOfSubmitElement(mark)
//                .setEditPoliticy(editFabric.createMultipleSubmitEditCommit())
                .setEditCreater(()-> {return editFabric.createMultipleSubmitEditCommit();})
                .setParent(panel).setCoordinate(coordinate)
                .createTableViewWrapper().setTablesWidthProperty(width, panel.widthProperty())
                .setDataMapper(dataMapper)
                .setEditable(true)
                .setColums(columnWrappers)
                .refresh();


    }



//создает связаные таблицы
    public TableWrapper observedTable(TableWrapper observer, AnchorPane panel, double width, Coordinate coordinate,
                                      DataMapper dataMapper,
                                      ColumnWrapper...columnWrappers){

        return AppNode.NodeBuilder.create()
                .setId(CSSID.TABLE)
                .setParent(panel)
                .setCoordinate(coordinate)
                .setEditCreater(()-> {return editFabric.createDefaultEditCommit();})
                .createTableViewWrapper()
                .setTablesWidthProperty(width, panel.widthProperty())
                .setDataMapper(dataMapper)
                .setEditable(true)
                .setColums(columnWrappers)
                .setBoundTable(observer)
                .refresh();






    }





}
