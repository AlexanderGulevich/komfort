package basisFx.appCore.fabrics;

import basisFx.appCore.SubmitElement;
import basisFx.appCore.controls.ColumnWrapper;
import basisFx.appCore.controls.ScretchedTableGrid;
import basisFx.appCore.scretchedGrid.SingleTableGridScetch;
import basisFx.appCore.controls.TablesButtonKind;
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
    protected InnerPanelsFabric innerPanelsFabric=new InnerPanelsFabric();

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


    public TableWrapper submitTable(SubmitElement mark, AnchorPane panel, double width, Coordinate coordinate,
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

    public TableWrapper observedGridTables(AnchorPane panel, double width, Coordinate coordinate,
                                      DataMapper dataMapper,
                                      ColumnWrapper...columnWrappers){




    }


//создает связаные таблицы
    public TableWrapper observedTable(TableWrapper observer, AnchorPane panel, double width,
                                      DataMapper dataMapper,
                                      ColumnWrapper...columnWrappers){

        return AppNode.NodeBuilder.create()
                .setId(CSSID.TABLE)
                .setEditCreater(()-> {return editFabric.createDefaultEditCommit();})
                .createTableViewWrapper().setTablesWidthProperty(width, panel.widthProperty())
                .setDataMapper(dataMapper)
                .setEditable(true)
                .setColums(columnWrappers)
                .setBoundTable(observer)
                .refresh();


    }






    public ScretchedTableGrid scretchedGridTable(String title, TablesButtonKind tablesButtonKind, Class cl,
                                                 DataMapper dataMapper, AnchorPane anchorPane, Coordinate coordinate,
                                                 ColumnWrapper...columnWrappers){

        SingleTableGridScetch singleTableGridScetch = new SingleTableGridScetch();
        singleTableGridScetch.setTitle(title);
        singleTableGridScetch.setParentAchorPane(anchorPane);
        singleTableGridScetch.setTablesButtonKind(tablesButtonKind);
        singleTableGridScetch.setCoordinate(coordinate);
        singleTableGridScetch.setDataMapper(dataMapper);
        singleTableGridScetch.setDomainClass(cl);
        singleTableGridScetch.setColumnWrappers(columnWrappers);
        singleTableGridScetch.init();
        return singleTableGridScetch;
    }


//таблица с gridpane, которую можно добавлять в gridpane
    public ScretchedTableGrid scretchedGridTable(String title, TablesButtonKind tablesButtonKind, Class cl,
                                                 DataMapper dataMapper,
                                                 ColumnWrapper...columnWrappers){

        SingleTableGridScetch singleTableGridScetch = new SingleTableGridScetch();
        singleTableGridScetch.setTitle(title);
        singleTableGridScetch.setTablesButtonKind(tablesButtonKind);
        singleTableGridScetch.setDataMapper(dataMapper);
        singleTableGridScetch.setDomainClass(cl);
        singleTableGridScetch.setColumnWrappers(columnWrappers);
        singleTableGridScetch.init();
        return singleTableGridScetch;
    }


}
