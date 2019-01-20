package basisFx.presentation.dynamicContents;
import basisFx.appCore.elements.ComboBoxWrapper;
import basisFx.appCore.grid.CtrlPosTop;
import basisFx.appCore.grid.ButSizeLittle;
import basisFx.appCore.settings.CSSclasses;
import basisFx.appCore.utils.Range;
import basisFx.presentation.DynamicContentPanel;
import basisFx.service.ServiceTablesTwoLinked;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.grid.SingleTable;
import basisFx.appCore.grid.TwoHorisontalBondGrids;
import basisFx.appCore.elements.GridPaneWrapper;
import basisFx.appCore.table.ColWrapperDate;
import basisFx.appCore.table.ColWrapperDouble;
import basisFx.appCore.table.ColWrapperString;
import basisFx.appCore.utils.Coordinate;
import basisFx.domain.EmployeesRatePerHour;
import basisFx.domain.Employer;

public class EmployeesPanel extends DynamicContentPanel {
    private ServiceTablesTwoLinked mediatorServiceTwoLinkedTable;
    private TableWrapper leftTableWrapper ;
    private TableWrapper rightTableWrapper ;

    @Override
    public void createServices() {
        mediatorServiceTwoLinkedTable =new ServiceTablesTwoLinked();
    }

    @Override
    public void customDynamicElementsInit() {

          leftTableWrapper = TableWrapper.newBuilder()
                .setGridName("Текущий список сотрудников ")
                .setOrganization(new SingleTable(new ButSizeLittle(),new CtrlPosTop()))
                .setActiveRecordClass(Employer.class)
                .setUnitOfWork(unitOfWork)
                .setIsEditable(true)
                .setIsSortableColums(false)
                .setServiceTables(mediatorServiceTwoLinkedTable)
                .setColWrappers(
                        ColWrapperString.newBuilder()
                                .setColumnName("ФИО")
                                .setColumnSize(1d)
                                .setIsEditeble(true)
                                .setPropertyName("name")
                                .build()
                )
                .build();

          rightTableWrapper = TableWrapper.newBuilder()
                .setGridName("Реестр тарифных ставок ")
                .setOrganization(new SingleTable(new ButSizeLittle(),new CtrlPosTop()))
                .setActiveRecordClass(EmployeesRatePerHour.class)
                .setUnitOfWork(unitOfWork)
                .setIsEditable(true)
                .setIsSortableColums(false)
                .setServiceTables(mediatorServiceTwoLinkedTable)
                .setColWrappers(
                        ColWrapperDouble.newBuilder()
                                .setColumnName("Тариф")
                                .setColumnSize(0.3d)
                                .setIsEditeble(true)
                                .setPropertyName("rate")
                                .build(),
                        ColWrapperDate.newBuilder()
                                .setColumnName("Действует с")
                                .setColumnSize(0.7d)
                                .setIsEditeble(true)
                                .setPropertyName("startDate")
                                .build()
                )
                .build();


        GridPaneWrapper commonGridPaneWrapper = GridPaneWrapper.newBuilder()
                .setColumnVsPercent(60)
                .setColumnVsPercent(40)
                .setGridName("Управление сотрудниками и тарифными ставками")
                .setParentAnchor(dynamicContentAnchorHolder)
                .setCoordinate(new Coordinate(0d, 10d, 10d, 0d))
                .setGridLinesVisibility(gridVisibility)
                .setOrganization(
                        new TwoHorisontalBondGrids(
                                leftTableWrapper.getGridPaneWrapper(),
                                rightTableWrapper.getGridPaneWrapper()
                        )
                )
                .build();




        ComboBoxWrapper.newBuilder()
                .setCoordinate(new Coordinate(0d, 15d, null, null))
                .setCssClasses(CSSclasses.COMBOBOX_BFx)
                .setParentAnchor(dynamicContentAnchorHolder)
                .setStartRange(Range.DAY30)
                .setServiceTables(mediatorServiceTwoLinkedTable)
                .setComboboxValues(Range.getParticular(
                        Range.DAY30,
                        Range.DAY60,
                        Range.DAY30,
                        Range.DAY90,
                        Range.ACTUAL
                        )
                )

                .build();
    }

    @Override
    public void initServices() {
        mediatorServiceTwoLinkedTable.setAccessoryTableWrapper(rightTableWrapper);
        mediatorServiceTwoLinkedTable.setPrimaryTableWrapper(leftTableWrapper);
        mediatorServiceTwoLinkedTable.initElements();
    }


}
