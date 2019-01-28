package basisFx.presentation.dynamicContents;
import basisFx.appCore.events.SubWindowCreater;
import basisFx.appCore.grid.ButSizeBig;
import basisFx.appCore.grid.CtrlPosTop;
import basisFx.appCore.grid.ButSizeLittle;
import basisFx.appCore.table.*;
import basisFx.appCore.utils.Registry;
import basisFx.appCore.windows.WindowAbstraction;
import basisFx.appCore.windows.WindowBuilder;
import basisFx.domain.ActualEmployersRate;
import basisFx.domain.Equipment;
import basisFx.presentation.DynamicContentPanel;
import basisFx.service.ServiceTablesSingle;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.grid.SingleTable;
import basisFx.appCore.elements.GridPaneWrapper;
import basisFx.appCore.utils.Coordinate;
import basisFx.domain.Employer;

public class EmployeesPanel extends DynamicContentPanel {
//    private ServiceTablesTwoLinked mediator;
    private ServiceTablesSingle mediator;
    private TableWrapper leftTableWrapper ;
    private TableWrapper rightTableWrapper ;
    private WindowBuilder dateResearchWindowBuilder;
    private WindowBuilder hiringWindowBuilder;

    @Override
    public void createServices() {
        mediator =new ServiceTablesSingle();
    }

    @Override
    public void customDynamicElementsInit() {

        dateResearchWindowBuilder = WindowBuilder.newBuilder()
                .setGUIStructura(null)
                .setButtonsForStage(null)
                .setDynamicContentPanelCreator(EmployeesPanel::new)
                .setTitle(null)
                .setMessage(null)
                .setFxmlFileName("ByDateResearchWindow")
                .setParentAnchorNameForFXML(WindowAbstraction.DefaultPanelsNames.topVisibleAnchor.name())
                .setWidth(900d)
                .setHeight(600d)
                .setClosingCallBack(
                        () -> {
                            TableWrapper tableWrapper = (TableWrapper) currentDynamicContent.get("tableWrapper");
                            tableWrapper.getMediator().refresh(tableWrapper);
                        })
                .build();


        hiringWindowBuilder = WindowBuilder.newBuilder()
                .setGUIStructura(null)
                .setButtonsForStage(null)
                .setDynamicContentPanelCreator(EmployeesPanel::new)
                .setTitle(null)
                .setMessage(null)
                .setFxmlFileName("EmployerHire")
                .setParentAnchorNameForFXML(WindowAbstraction.DefaultPanelsNames.topVisibleAnchor.name())
                .setWidth(530d)
                .setHeight(350d)
                .setClosingCallBack(
                        () -> {
                            TableWrapper tableWrapper = (TableWrapper) currentDynamicContent.get("tableWrapper");
                            tableWrapper.getMediator().refresh(tableWrapper);
                        })
                .build();


        leftTableWrapper = TableWrapper.newBuilder()
                .setGridName("Сотрудники ")
                .setActiveRecordClass(ActualEmployersRate.class)
                .setUnitOfWork(unitOfWork)
                .setIsEditable(true)
                .setIsSortableColums(false)
                .setServiceTables(mediator)
                .setColWrappers(
                        ColWrapperComboBox.newBuilder(Employer.class)
                                .setColumnName("Работник")
                                .setColumnSize(0.5d)
                                .setIsEditeble(false)
                                .setPropertyName("EMPLOYER")
                                .build(),
                        ColWrapperDouble.newBuilder()
                                .setColumnName("Тариф/ч. ")
                                .setColumnSize(0.1d)
                                .setIsEditeble(true)
                                .setPropertyName("RATE")
                                .build(),
                        ColWrapperDate.newBuilder()
                                .setColumnName("Действует с")
                                .setColumnSize(0.2d)
                                .setIsEditeble(true)
                                .setPropertyName("STARTDATE")
                                .build(),
                        ColWrapperPopupViaBtn.newBuilder()
                                .setBtnName("Показать")
                                .setColumnName("Архив")
                                .setColumnSize(0.2d)
                                .setWindowBuilder(dateResearchWindowBuilder)
                                .build()
                )
                .build();

        currentDynamicContent.put("tableWrapper",leftTableWrapper);

//
//          rightTableWrapper = TableWrapper.newBuilder()
//                .setGridName("Реестр тарифных ставок ")
//                .setOrganization(new SingleTable(new ButSizeLittle(),new CtrlPosTop()))
//                .setActiveRecordClass(EmployeesRatePerHour.class)
//                .setUnitOfWork(unitOfWork)
//                .setIsEditable(true)
//                .setIsSortableColums(false)
//                .setServiceTables(mediator)
//                .setColWrappers(
//                        ColWrapperDouble.newBuilder()
//                                .setColumnName("Тариф")
//                                .setColumnSize(0.3d)
//                                .setIsEditeble(true)
//                                .setPropertyName("rate")
//                                .build(),
//                        ColWrapperDate.newBuilder()
//                                .setColumnName("Действует с")
//                                .setColumnSize(0.7d)
//                                .setIsEditeble(true)
//                                .setPropertyName("startDate")
//                                .build()
//                )
//                .build();


        Registry.mainWindow.setNodeToMap(leftTableWrapper,"outer_table_wrapper_for_ByDateResearchWindow");



         GridPaneWrapper.newBuilder()
                .setGridName("Текущий список сотрудников и актуальные тарифные ставки")
                .setParentAnchor(dynamicContentAnchorHolder)
                .setCoordinate(new Coordinate(0d, 0d, 10d, 0d))
                .setGridLinesVisibility(gridVisibility)
                .setOrganization(
                        new SingleTable(
                                leftTableWrapper,
                                new ButSizeBig(
                                        null,
                                        new SubWindowCreater(hiringWindowBuilder)
                                ),
                                new CtrlPosTop()
                        ))
                .build();





    }

    @Override
    public void initServices() {
//        mediator.setAccessoryTableWrapper(rightTableWrapper);
//        mediator.setPrimaryTableWrapper(leftTableWrapper);
        mediator.setTableWrapper(leftTableWrapper);
        mediator.initElements();
    }


}
