package basisFx.presentation.targets;

import basisFx.appCore.MediatorTwoLinkedTable;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.grid.GridOrganizationButtonTopRightLittleSingleTable;
import basisFx.appCore.grid.GridOrganizationInnerTwoGridsTwoTables;
import basisFx.appCore.grid.GridPaneWrapper;
import basisFx.appCore.table.ColumnWrapperComboBoxVal;
import basisFx.appCore.table.ColumnWrapperDate;
import basisFx.appCore.table.ColumnWrapperDouble;
import basisFx.appCore.table.ColumnWrapperString;
import basisFx.appCore.utils.Coordinate;
import basisFx.domain.Counterparty;
import basisFx.domain.Currency;
import basisFx.domain.ExchangeRates;
import basisFx.domain.Label;
import basisFx.presentation.TargetPanel;

import java.time.LocalDate;

public class LabelPanel  extends TargetPanel {

    private boolean gridVisibility=false;
    private MediatorTwoLinkedTable mediatorTwoLinkedTable =new MediatorTwoLinkedTable();
    private GridOrganizationInnerTwoGridsTwoTables gridOrganization =new GridOrganizationInnerTwoGridsTwoTables();

    @Override
    public void init() {

        TableWrapper labelTableWrapper = TableWrapper.newBuilder()
                .setActiveRecordClass(Label.class)
                .setUnitOfWork(unitOfWork)
                .setIsEditable(true)
                .setIsSortableColums(false)
                .setMediator(mediatorTwoLinkedTable)
                .setColumnWrappers(
                        ColumnWrapperString.newBuilder()
                                .setColumnName("Наименование")
                                .setColumnSize(0.6d)
                                .setIsEditeble(true)
                                .setPropertyName("name")
                                .build(),
                        ColumnWrapperComboBoxVal.newBuilder(Counterparty.class)
                                .setColumnName("Поставщик")
                                .setColumnSize(0.4d)
                                .setIsEditeble(true)
                                .setPropertyName("name")
                                .build())
                .build();

        GridPaneWrapper labelGridPaneWrapper = GridPaneWrapper.newBuilder()
                .setGridLinesVisibility(gridVisibility)
                .setName("Этикетки")
                .setColumnComputerWidth()
                .setColumnFixed(40d)
                .setColumnFixed(40d)
                .setGridOrganization(new GridOrganizationButtonTopRightLittleSingleTable(labelTableWrapper))
                .build();

        TableWrapper labelPriceTableWrapper = TableWrapper.newBuilder()
                .setActiveRecordClass(ExchangeRates.class)
                .setUnitOfWork(unitOfWork)
                .setIsEditable(true)
                .setIsSortableColums(false)
                .setMediator(mediatorTwoLinkedTable)
                .setColumnWrappers(
                        ColumnWrapperDouble.newBuilder()
                                .setColumnName("Курс")
                                .setColumnSize(0.6d)
                                .setIsEditeble(true)
                                .setPropertyName("exchangeRate")
                                .build(),
                        ColumnWrapperDate.newBuilder()
                                .setColumnName("Дата")
                                .setColumnSize(0.4d)
                                .setIsEditeble(true)
                                .setPropertyName("startingDate")
                                .build()
                )
                .build();

        GridPaneWrapper labelPriceGridPaneWrapper = GridPaneWrapper.newBuilder()
                .setGridLinesVisibility(gridVisibility)
                .setName("Курсы")
                .setColumnComputerWidth()
                .setColumnFixed(40d)
                .setColumnFixed(40d)
                .setGridOrganization(new GridOrganizationButtonTopRightLittleSingleTable(labelPriceTableWrapper))
                .build();

        GridPaneWrapper commonGridPaneWrapper = GridPaneWrapper.newBuilder()
                .setColumnVsPercent(60)
                .setColumnVsPercent(40)
                .setName("Управление валютами и динамика курсов")
                .setParentAnchor(innerAnchorPane)
                .setCoordinate(new Coordinate(0d, 10d, 10d, 0d))
                .setGridLinesVisibility(gridVisibility)
                .setGridOrganization(gridOrganization.setGridWrappers(labelGridPaneWrapper,labelPriceGridPaneWrapper))
                .build();


        mediatorTwoLinkedTable.setAccessoryTableWrapper(labelPriceTableWrapper);
        mediatorTwoLinkedTable.setPrimaryTableWrapper(labelTableWrapper);
        mediatorTwoLinkedTable.initElements();
    }


//        GridTablesBuilder observer=new GridTablesBuilder();
//        observer.setGridColWidth(new GridColWidth(KindOfGridCol.percent,40d));
//        observer.setTitle("Архив цен");
//        observer.setTablesButtonKind(TablesButtonKind.Bottom_right);
//        observer.setDomainClass(ProductPrice.class);
//        observer.setActiveRecord(dataMapperFabric.labelPriceMapper());
//        observer.setColumnWidthByContent(  columnFabric.string(KindOfColumn.DOUBLE,"Цена","price",0.3d,true,
//                (obj,val)->{((ProductPrice)obj).setPrice( (String ) val);})
//        );
//        observer.setColumnWidthByContent(  columnFabric.dateColumn(KindOfColumn.DATE,"Дата начала действия ","startingDate",0.7d,true,
//                (obj, val)->{((ProductPrice)obj).setStartingDate((LocalDate) val); })
//        );
//
//
//        BoundTablesGrid boundTablesGrid = gridFabric.boundTables(
//                observed,
//                observer,
//                new Coordinate(10d, 10d, 10d, 10d),
//                panel
//        );
//
//
//
//
//
//    }

}