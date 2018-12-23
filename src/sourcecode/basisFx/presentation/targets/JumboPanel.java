package basisFx.presentation.targets;

import basisFx.appCore.elements.GridPaneWrapper;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.grid.ButPositionTop;
import basisFx.appCore.grid.ButtonsSizeForGridBig;
import basisFx.appCore.grid.GridSingleTable;
import basisFx.appCore.table.ColumnWrapperInt;
import basisFx.appCore.utils.Coordinate;
import basisFx.domain.Jumbo;
import basisFx.presentation.TargetPanel;
import basisFx.service.ServiceSingleTable;

public class JumboPanel extends TargetPanel {
    @Override
    public void init() {
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
                .setGridOrganization(new GridSingleTable(tableWrapper,new ButtonsSizeForGridBig(),new ButPositionTop()))
                .setGridName("Ширины джамбо ролей и выход продукции по ширине")
                .setParentAnchor(innerAnchorPane)
                .setCoordinate(new Coordinate(0d,10d,10d,0d))
                .setGridLinesVisibility(false)
                .build();

        mediatorSingleTable.setTableWrapper(tableWrapper);
        mediatorSingleTable.initElements();
    }






}
