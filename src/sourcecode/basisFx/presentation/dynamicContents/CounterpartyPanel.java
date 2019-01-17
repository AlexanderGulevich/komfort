package basisFx.presentation.dynamicContents;

import basisFx.appCore.grid.ButPosTop;
import basisFx.appCore.grid.ButSizeBig;
import basisFx.appCore.grid.SingleTable;
import basisFx.service.ServiceTablesSingle;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.elements.GridPaneWrapper;
import basisFx.appCore.table.ColumnWrapperComboBox;
import basisFx.appCore.table.ColumnWrapperString;
import basisFx.appCore.utils.Coordinate;
import basisFx.domain.Counterparty;
import basisFx.domain.Currency;
import basisFx.presentation.DynamicContentPanel;

public class CounterpartyPanel extends DynamicContentPanel {
    private ServiceTablesSingle mediatorSingleTable;
    private   TableWrapper tableWrapper;
    @Override
    public void createServices() {
        mediatorSingleTable = new ServiceTablesSingle();
    }

    @Override
    public void customDynamicElementsInit() {

          tableWrapper = TableWrapper.newBuilder()
                .setActiveRecordClass(Counterparty.class)
                .setUnitOfWork(unitOfWork)
                .setIsEditable(true)
                .setIsSortableColums(false)
                .setServiceTables(mediatorSingleTable)
                .setColumnWrappers(
                        ColumnWrapperString.newBuilder()
                                .setColumnName("Наименование")
                                .setColumnSize(0.6d)
                                .setIsEditeble(true)
                                .setPropertyName("name")
                                .build(),
                        ColumnWrapperComboBox.newBuilder(Currency.class)
                                .setColumnName("Валюта ")
                                .setIsEditeble(true)
                                .setColumnSize(0.4d)
                                .setPropertyName("currency")
                                .build()

                )
                .build();

        GridPaneWrapper.newBuilder()
                .setOrganization(new SingleTable(tableWrapper,new ButSizeBig(),new ButPosTop()))
                .setGridName("Список контрагентов")
                .setParentAnchor(dynamicContentAnchorHolder)
                .setCoordinate(new Coordinate(0d,10d,10d,0d))
                .setGridLinesVisibility(false)
                .build();


    }

    @Override
    public void initServices() {
        mediatorSingleTable.setTableWrapper(tableWrapper);
        mediatorSingleTable.initElements();
    }


}
