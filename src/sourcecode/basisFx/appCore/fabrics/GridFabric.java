package basisFx.appCore.fabrics;

import basisFx.appCore.controls.ColumnWrapper;
import basisFx.appCore.controls.ScretchedTableGrid;
import basisFx.appCore.dataTransfers.GridDataTransfer;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.scretchedGrid.SingleTableGridScetch;


public class GridFabric {


    public ScretchedTableGrid singleAnchorGridTable(GridDataTransfer tr){

        SingleTableGridScetch t = new SingleTableGridScetch();
        t.setTitle(tr.getTitle());
        t.setParentAchorPane(tr.getPanel());
        t.setTablesButtonKind(tr.getTablesButtonKind());
        t.setCoordinate(tr.getCoordinate());
        t.setDataMapper(tr.getDataMapper());
        t.setDomainClass(tr.getClass());
        t.setColumnWrappers(tr.getColumnWrappers());
        t.set
        t.init();
        return t;
    }


    //таблица с gridpane, которую можно добавлять в gridpane
    public ScretchedTableGrid singleGridTable(GridDataTransfer tr) {

        SingleTableGridScetch t = new SingleTableGridScetch();
        t.setTitle(tr.getTitle());
        t.setParentAchorPane(tr.getPanel());
        t.setTablesButtonKind(tr.getTablesButtonKind());
        t.setCoordinate(tr.getCoordinate());
        t.setDataMapper(tr.getDataMapper());
        t.setDomainClass(tr.getClass());
        t.setColumnWrappers(tr.getColumnWrappers());
        t.init();

        return t;
    }



     public TableWrapper boundTables(GridDataTransfer t1,GridDataTransfer t2){



            return null;
        }


    }
