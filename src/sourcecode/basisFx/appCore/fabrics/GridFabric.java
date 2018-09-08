package basisFx.appCore.fabrics;

import basisFx.appCore.controls.GridTable;
import basisFx.appCore.grid.*;
import basisFx.appCore.utils.Coordinate;
import javafx.scene.layout.AnchorPane;


public class GridFabric {


    public GridTable singleGridTable(GridTablesBuilder b){

        SingleGridTable gr = new SingleGridTable();
        gr.setTitle(b.getTitle());
        gr.setParentAchorPane(b.getPanel());
        gr.setTablesButtonKind(b.getTablesButtonKind());
        gr.setCoordinate(b.getCoordinate());
        gr.setActiveRecord(b.getActiveRecord());
        gr.setDomainClass(b.getDomainClass());
        gr.setGridColWidth(b.getGridColWidth());
        gr.setColumnWrappers(b.getColumnWrappers());
        gr.setKindOfTable(KindOfTable.SIMPLE);


        gr.init();
        return gr;
    }


    public GridTable submitGridTable(GridTablesBuilder b){

        SingleGridTable gr = new SingleGridTable();
        gr.setTitle(b.getTitle());
        gr.setParentAchorPane(b.getPanel());
        gr.setTablesButtonKind(b.getTablesButtonKind());
        gr.setCoordinate(b.getCoordinate());
        gr.setActiveRecord(b.getActiveRecord());
        gr.setDomainClass(b.getDomainClass());
        gr.setColumnWrappers(b.getColumnWrappers());
        gr.setKindOfTable(KindOfTable.SUBMIT);

        gr.init();
        return gr;
    }


    public BoundTablesGrid boundTables(GridTablesBuilder observed, GridTablesBuilder observer, Coordinate c, AnchorPane p){


         SingleGridTable gr_observer = new SingleGridTable();

         gr_observer.setTitle(observer.getTitle());
         gr_observer.setParentAchorPane(observer.getPanel());
         gr_observer.setTablesButtonKind(observer.getTablesButtonKind());
         gr_observer.setCoordinate(observer.getCoordinate());
         gr_observer.setActiveRecord(observer.getActiveRecord());
         gr_observer.setDomainClass(observer.getDomainClass());
         gr_observer.setColumnWrappers(observer.getColumnWrappers());
         gr_observer.init();


         SingleGridTable gr_observed = new SingleGridTable();

         gr_observed.setTitle(observed.getTitle());
         gr_observed.setParentAchorPane(observed.getPanel());
         gr_observed.setTablesButtonKind(observed.getTablesButtonKind());
         gr_observed.setCoordinate(observed.getCoordinate());
         gr_observed.setActiveRecord(observed.getActiveRecord());
         gr_observed.setDomainClass(observed.getDomainClass());
         gr_observed.setColumnWrappers(observed.getColumnWrappers());
         gr_observed.setObserver(gr_observer.getTableWrapper());
         gr_observed.setKindOfTable(KindOfTable.OBSERVED);
         gr_observed.init();



         BoundTablesGrid boundTablesGrid=new BoundTablesGrid();
         boundTablesGrid.setObserverGrid(gr_observer);
         boundTablesGrid.setObservedGrid(gr_observed);
         boundTablesGrid.setColWh_1(observed.getGridColWidth());
         boundTablesGrid.setColWh_2(observer.getGridColWidth());
         boundTablesGrid.setCoordinate(c);
         boundTablesGrid.setParent(p);
         boundTablesGrid.init();








         return boundTablesGrid;
        }


    public void boundWithSecondRaw(BoundTablesGrid boundTablesGrid,
                                   double firstRawPercentHeight,
                                   double secondRawPercentHeight,
                                   AnchorPane p,
                                   GridTablesBuilder ...secondRawTables
                                   ) {


        BoundWithSecondRawGrid boundWithSecondRawGrid=new BoundWithSecondRawGrid();

        boundWithSecondRawGrid.setBoundTableGrid(boundTablesGrid.getGridPane());
        boundWithSecondRawGrid.setRawPercentHeight(firstRawPercentHeight,secondRawPercentHeight);
        boundWithSecondRawGrid.setParent(p);

        for (GridTablesBuilder secondRawTable : secondRawTables) {
            GridTable gridTable = singleGridTable(secondRawTable);
            boundWithSecondRawGrid.setSecondRawTables(gridTable);
        }

        boundWithSecondRawGrid.init();
    }








    }
