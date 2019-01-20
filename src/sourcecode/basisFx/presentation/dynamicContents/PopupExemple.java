package basisFx.presentation.dynamicContents;

import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.settings.CSSclasses;
import basisFx.appCore.table.ColWrapperString;
import basisFx.appCore.utils.Coordinate;
import basisFx.domain.Equipment;
import basisFx.presentation.DynamicContentPanel;
import basisFx.service.ServiceTablesSingle;

public class PopupExemple extends DynamicContentPanel {
    private ServiceTablesSingle mediatorSingleTable;
    private TableWrapper tableWrapper;
    @Override
    public void createServices() {
        mediatorSingleTable = new ServiceTablesSingle();
    }

    @Override
    public void customDynamicElementsInit() {

        tableWrapper = TableWrapper.newBuilder()
                .setActiveRecordClass(Equipment.class)
                .setUnitOfWork(unitOfWork)
                .setIsEditable(true)
                .setParentAnchor(dynamicContentAnchorHolder)
                .setCoordinate(new Coordinate(0d,0d,0d,0d))
                .setCssClasses(CSSclasses.wrappedHeaderColumn)
                .setIsSortableColums(false)
                .setServiceTables(mediatorSingleTable)
                .setColWrappers(
                        ColWrapperString.newBuilder()
                                .setColumnName("Наименование")
                                .setColumnSize(1d)
                                .setIsEditeble(true)
                                .setPropertyName("name")
                                .build()
                ).build();

        window.setNodeToMap(tableWrapper,"TABLE_wrapper_ByDateResearchWindow");
    }

    @Override
    public void initServices() {
        mediatorSingleTable.setTableWrapper(tableWrapper);
        mediatorSingleTable.initElements();
    }

}
