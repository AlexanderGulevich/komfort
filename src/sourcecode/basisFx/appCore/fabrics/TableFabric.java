package basisFx.appCore.fabrics;

import basisFx.appCore.SubmitElement;
import basisFx.appCore.controlPolicy.TablesButtonKind;
import basisFx.appCore.controlPolicy.ColumnWrapper;
import basisFx.appCore.dataSource.DataMapper;
import basisFx.appCore.elements.AnchorWrapper;
import basisFx.appCore.elements.AppNode;
import basisFx.appCore.elements.LabelWrapper;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.settings.FontsStore;
import basisFx.appCore.utils.Coordinate;
import basisFx.appCore.settings.CSSID;
import basisFx.domainModel.domaine.RatePerHour;
import javafx.geometry.Pos;
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


//создает связаные таблицы
    public TableWrapper boundTable(TableWrapper observer, AnchorPane panel, double width, Coordinate coordinate,
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


//создает таблицу вместе с кнопками
    public TableWrapper grouppedTable(String title, Class domainClass,TablesButtonKind tablesButtonKind, AnchorPane panel, double width, Coordinate coordinate,
                                      DataMapper dataMapper,
                                      ColumnWrapper...columnWrappers){

                Coordinate overallAnchorCoordinate=coordinate;
                Coordinate tableCoordinate=null;
                Coordinate buttonAddCoordinate=null;
                Coordinate buttonDeleteCoordinate=null;


        AnchorPane innerPanel = innerPanelsFabric.createInnerPanels(panel, width, overallAnchorCoordinate);

        LabelWrapper label = textFabric.createLabel(title, FontsStore.ROBOTO_LIGHT, Pos.BASELINE_LEFT, 25d,
                innerPanel, new Coordinate(5d, 0d, null, 0d));


        switch (tablesButtonKind){
                    case Right_little:
                         tableCoordinate=new Coordinate(30d,40d,10d,0d);
                         buttonAddCoordinate=new Coordinate(30d,2d,null,null );
                         buttonDeleteCoordinate=new Coordinate(70d,2d,null,null );


                    case TOP_right_little:
                        tableCoordinate=new Coordinate(30d,0d,10d,0d);
                        buttonAddCoordinate=new Coordinate(0d,0d,null,null);
                        buttonDeleteCoordinate=new Coordinate(0d,50d,null,null);



//                    case Bottom_right_little:
//                        tableCoordinate=new Coordinate(null,0d,10d,0d);
//                        buttonAddCoordinate=new Coordinate(0d,0d,null,null);
//                        buttonDeleteCoordinate=new Coordinate(0d,50d,null,null);
//
//
//
//
//                    case Bottom_right:
//                        tableCoordinate=new Coordinate();
//                        buttonAddCoordinate=new Coordinate();
//                        buttonDeleteCoordinate=new Coordinate();
//
//
//
//                    case TOP_right:
//                        tableCoordinate=new Coordinate();
//                        buttonAddCoordinate=new Coordinate();
//                        buttonDeleteCoordinate=new Coordinate();
//
//
//
//                    case Right:
//                        tableCoordinate=new Coordinate();
//                        buttonAddCoordinate=new Coordinate();
//                        buttonDeleteCoordinate=new Coordinate();
                }



        TableWrapper tableWrapper=AppNode.NodeBuilder.create()
                .setId(CSSID.TABLE)
                .setEditCreater(()-> {return editFabric.createDefaultEditCommit();})
                .setParent(innerPanel).setCoordinate(coordinate)
                .createTableViewWrapper().setTablesWidthProperty(width, panel.widthProperty())
                .setDataMapper(dataMapper)
                .setEditable(true)
                .setColums(columnWrappers)
                .refresh();


            if (
                    tablesButtonKind==TablesButtonKind.Bottom_right
                    || tablesButtonKind==TablesButtonKind.Right
                    || tablesButtonKind==TablesButtonKind.TOP_right

                    ){

                buttonFactory.addRowButton(
                        innerPanel,buttonAddCoordinate, tableWrapper,domainClass);
                buttonFactory.deleteRowButton(
                        innerPanel,buttonDeleteCoordinate, tableWrapper);
            }else {


                buttonFactory.littleRowDeleteButton(tableWrapper,innerPanel, buttonAddCoordinate );
                buttonFactory.littleRowAddButton(tableWrapper,innerPanel,domainClass, buttonAddCoordinate );



            }




                return tableWrapper;



    }


}
