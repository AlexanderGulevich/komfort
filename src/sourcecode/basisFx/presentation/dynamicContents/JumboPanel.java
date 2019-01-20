package basisFx.presentation.dynamicContents;

import basisFx.appCore.elements.GridPaneWrapper;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.grid.CtrlPosTop;
import basisFx.appCore.grid.ButSizeBig;
import basisFx.appCore.grid.SingleTable;
import basisFx.appCore.table.ColWrapperInt;
import basisFx.appCore.utils.Coordinate;
import basisFx.domain.Jumbo;
import basisFx.presentation.DynamicContentPanel;
import basisFx.service.ServiceTablesSingle;

public class JumboPanel extends DynamicContentPanel {
    private ServiceTablesSingle mediatorSingleTable;
    private      TableWrapper tableWrapper ;
    @Override
    public void createServices() {
        mediatorSingleTable = new ServiceTablesSingle();
    }

    @Override
    public void customDynamicElementsInit() {
            tableWrapper = TableWrapper.newBuilder()
                .setActiveRecordClass(Jumbo.class)
                .setUnitOfWork(unitOfWork)
                .setIsEditable(true)
                .setIsSortableColums(false)
                .setServiceTables(mediatorSingleTable)
                .setColWrappers(
                        ColWrapperInt.newBuilder()
                                .setColumnName("Ширина")
                                .setColumnSize(0.6d)
                                .setIsEditeble(true)
                                .setPropertyName("width")
                                .build(),
                        ColWrapperInt.newBuilder()
                                .setColumnName("Кол-во продукции на выходе ")
                                .setIsEditeble(true)
                                .setColumnSize(0.4d)
                                .setPropertyName("numberOfProduct")
                                .build()

                )
                .build();

        GridPaneWrapper.newBuilder()
                .setOrganization(new SingleTable(tableWrapper,new ButSizeBig(),new CtrlPosTop()))
                .setGridName("Ширины джамбо ролей и выход продукции по ширине")
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
