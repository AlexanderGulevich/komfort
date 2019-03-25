package basisFx.presentation.dynamicContents;

import basisFx.appCore.elements.GridPaneWrapper;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.grid.ButSizeBig;
import basisFx.appCore.grid.CtrlPosTop;
import basisFx.appCore.grid.SingleTable;
import basisFx.appCore.table.ColWrapperComboBox;
import basisFx.appCore.table.ColWrapperString;
import basisFx.appCore.utils.Coordinate;
import basisFx.domain.Counterparty;
import basisFx.domain.Currency;
import basisFx.presentation.DynamicContentPanel;
import basisFx.service.ServiceTablesSingle;

public class CounterpartyPanelPopup extends DynamicContentPanel {
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
                .setColWrappers(
                        ColWrapperString.newBuilder()
                                .setColumnName("Наименование")
                                .setColumnSize(0.6d)
                                .setIsEditeble(true)
                                .setPropertyName("name")
                                .build(),
                        ColWrapperComboBox.newBuilder(Currency.class)
                                .setColumnName("Валюта ")
                                .setIsEditeble(true)
                                .setColumnSize(0.4d)
                                .setPropertyName("currency")
                                .build()

                )
                .build();

        GridPaneWrapper.newBuilder()
                .setOrganization(new SingleTable(tableWrapper,new ButSizeBig(),new CtrlPosTop()))
                .setGridName("Список контрагентов")
                .setParentAnchor(dynamicContentAnchorHolder)
                .setCoordinate(new Coordinate(0d,0d,10d,0d))
                .setGridLinesVisibility(false)
                .build();


        window.setNodeToMap(tableWrapper,"tableWrapper");
    }

    @Override
    public void initServices() {
        mediatorSingleTable.setTableWrapper(tableWrapper);
        mediatorSingleTable.initElements();
    }


}
