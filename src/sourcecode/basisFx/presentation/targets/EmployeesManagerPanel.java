package basisFx.presentation.targets;
import basisFx.appCore.mediators.MediatorTwoLinkedTable;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.grid.GridOrganizationButtonTopRightLittleSingleTable;
import basisFx.appCore.grid.GridOrganizationInnerTwoGridsTwoTables;
import basisFx.appCore.grid.GridPaneWrapper;
import basisFx.appCore.table.ColumnWrapperComboBox;
import basisFx.appCore.table.ColumnWrapperDate;
import basisFx.appCore.table.ColumnWrapperDouble;
import basisFx.appCore.table.ColumnWrapperString;
import basisFx.appCore.utils.Coordinate;
import basisFx.domain.EmployeesRatePerHour;
import basisFx.domain.Employer;
import basisFx.presentation.TargetPanel;

public class EmployeesManagerPanel extends TargetPanel {
    private boolean gridVisibility=false;
    private MediatorTwoLinkedTable mediatorTwoLinkedTable =new MediatorTwoLinkedTable();
    private GridOrganizationInnerTwoGridsTwoTables gridOrganization =new GridOrganizationInnerTwoGridsTwoTables();

    @Override
    public void init() {

        TableWrapper labelTableWrapper = TableWrapper.newBuilder()
                .setActiveRecordClass(Employer.class)
                .setUnitOfWork(unitOfWork)
                .setIsEditable(true)
                .setIsSortableColums(false)
                .setMediator(mediatorTwoLinkedTable)
                .setColumnWrappers(
                        ColumnWrapperString.newBuilder()
                                .setColumnName("ФИО")
                                .setColumnSize(0.8d)
                                .setIsEditeble(true)
                                .setPropertyName("name")
                                .build(),
                        ColumnWrapperDouble.newBuilder()
                                .setColumnName("Тариф")
                                .setColumnSize(0.2d)
                                .setIsEditeble(true)
                                .setPropertyName("actualRate")
                                .build()
                )
                .build();

        GridPaneWrapper labelGridPaneWrapper = GridPaneWrapper.newBuilder()
                .setGridLinesVisibility(gridVisibility)
                .setName("Текущий список сотрудников ")
                .setColumnComputerWidth()
                .setColumnFixed(40d)
                .setColumnFixed(40d)
                .setGridOrganization(new GridOrganizationButtonTopRightLittleSingleTable(labelTableWrapper))
                .build();

        TableWrapper labelPriceTableWrapper = TableWrapper.newBuilder()
                .setActiveRecordClass(EmployeesRatePerHour.class)
                .setUnitOfWork(unitOfWork)
                .setIsEditable(true)
                .setIsSortableColums(false)
                .setMediator(mediatorTwoLinkedTable)
                .setColumnWrappers(
                        ColumnWrapperDouble.newBuilder()
                                .setColumnName("Тариф")
                                .setColumnSize(0.4d)
                                .setIsEditeble(true)
                                .setPropertyName("exchangeRate")
                                .build(),
                        ColumnWrapperDate.newBuilder()
                                .setColumnName("Дата начала действия тарифа")
                                .setColumnSize(0.6d)
                                .setIsEditeble(true)
                                .setPropertyName("startingDate")
                                .build()
                )
                .build();

        GridPaneWrapper labelPriceGridPaneWrapper = GridPaneWrapper.newBuilder()
                .setGridLinesVisibility(gridVisibility)
                .setName("Реестр тарифных ставок")
                .setColumnComputerWidth()
                .setColumnFixed(40d)
                .setColumnFixed(40d)
                .setGridOrganization(new GridOrganizationButtonTopRightLittleSingleTable(labelPriceTableWrapper))
                .build();

        GridPaneWrapper commonGridPaneWrapper = GridPaneWrapper.newBuilder()
                .setColumnVsPercent(70)
                .setColumnVsPercent(30)
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



}
