package basisFx.presentation.dynamicContents;

import basisFx.appCore.elements.GridPaneWrapper;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.grid.ButPosTop;
import basisFx.appCore.grid.ButSizeBig;
import basisFx.appCore.grid.SingleTable;
import basisFx.appCore.table.ColumnWrapperInt;
import basisFx.appCore.utils.Coordinate;
import basisFx.domain.Jumbo;
import basisFx.presentation.DynamicContentPanel;
import basisFx.service.ServiceSingleTable;

public class JumboPanel extends DynamicContentPanel {
    @Override
    public void customeInit() {
        ServiceSingleTable mediatorSingleTable = new ServiceSingleTable();

        TableWrapper tableWrapper = TableWrapper.newBuilder()
                .setActiveRecordClass(Jumbo.class)
                .setUnitOfWork(unitOfWork)
                .setIsEditable(true)
                .setIsSortableColums(false)
                .setServiceMediator(mediatorSingleTable)
                .setColumnWrappers(
                        ColumnWrapperInt.newBuilder()
                                .setColumnName("Ширина")
                                .setColumnSize(0.6d)
                                .setIsEditeble(true)
                                .setPropertyName("width")
                                .build(),
                        ColumnWrapperInt.newBuilder()
                                .setColumnName("Кол-во продукции на выходе ")
                                .setIsEditeble(true)
                                .setColumnSize(0.4d)
                                .setPropertyName("numberOfProduct")
                                .build()

                )
                .build();

        GridPaneWrapper.newBuilder()
                .setOrganization(new SingleTable(tableWrapper,new ButSizeBig(),new ButPosTop()))
                .setGridName("Ширины джамбо ролей и выход продукции по ширине")
                .setParentAnchor(dynamicContentAnchorHolder)
                .setCoordinate(new Coordinate(0d,10d,10d,0d))
                .setGridLinesVisibility(false)
                .build();

        mediatorSingleTable.setTableWrapper(tableWrapper);
        mediatorSingleTable.initElements();
    }






}
