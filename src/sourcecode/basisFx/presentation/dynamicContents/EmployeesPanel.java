package basisFx.presentation.dynamicContents;
import basisFx.appCore.events.RowDeleteFromTable;
import basisFx.appCore.events.SubWindowCreater;
import basisFx.appCore.grid.ButSizeBig;
import basisFx.appCore.grid.CtrlPosBotton;
import basisFx.appCore.grid.CtrlPosTop;
import basisFx.appCore.table.*;
import basisFx.appCore.utils.Registry;
import basisFx.appCore.windows.WindowAbstraction;
import basisFx.appCore.windows.WindowBuilder;
import basisFx.domain.ActualEmployersRate;
import basisFx.presentation.DynamicContentPanel;
import basisFx.service.ServiceTablesSingle;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.grid.SingleTable;
import basisFx.appCore.elements.GridPaneWrapper;
import basisFx.appCore.utils.Coordinate;
import basisFx.domain.Employer;

public class EmployeesPanel extends DynamicContentPanel {
    private ServiceTablesSingle mediator;
    private TableWrapper outer_table_wrapper;
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
//                .setDynamicContentPanelCreator(RatePerHourPanel::new)
                .setDynamicContentPanelCreator(EmployeesPanel::new)
                .setTitle(null)
                .setMessage(null)
                .setFxmlFileName("ByDateResearchWindow")
                .setParentAnchorNameForFXML(WindowAbstraction.DefaultPanelsNames.topVisibleAnchor.name())
                .setWidth(900d)
                .setHeight(600d)
                .setClosingCallBack(
                        () -> {
                            TableWrapper tableWrapper =(TableWrapper)   Registry.mainWindow.getNodeFromMap("outer_table_wrapper");
                            tableWrapper.getMediator().refresh(tableWrapper);
                        })
                .build();


        hiringWindowBuilder = WindowBuilder.newBuilder()
                .setGUIStructura(null)
                .setButtonsForStage(null)
                .setDynamicContentPanelCreator(null)
                .setTitle(null)
                .setMessage(null)
                .setFxmlFileName("EmployerHire")
                .setParentAnchorNameForFXML(WindowAbstraction.DefaultPanelsNames.topVisibleAnchor.name())
                .setWidth(530d)
                .setHeight(350d)
                .setClosingCallBack(
                        () -> {
                            TableWrapper tableWrapper =(TableWrapper)   Registry.mainWindow.getNodeFromMap("outer_table_wrapper");
                            tableWrapper.getMediator().refresh(tableWrapper);
                        })
                .build();


        outer_table_wrapper = TableWrapper.newBuilder()
                .setGridName("Сотрудники ")
                .setActiveRecordClass(ActualEmployersRate.class)
                .setUnitOfWork(unitOfWork)
                .setIsEditable(true)
                .setIsSortableColums(false)
                .setServiceTables(mediator)
                .setColWrappers(
                        ColWrapperComboBox.newBuilder(Employer.class)
                                .setColumnName("Фамилия / Имя / Отчество")
                                .setColumnSize(0.5d)
                                .setIsEditeble(false)
                                .setPropertyName("EMPLOYER")
                                .build(),
                        ColWrapperDouble.newBuilder()
                                .setColumnName("Тариф - руб./ч. ")
                                .setColumnSize(0.15d)
                                .setIsEditeble(true)
                                .setPropertyName("RATE")
                                .build(),
                        ColWrapperDate.newBuilder()
                                .setColumnName("Начало действия")
                                .setColumnSize(0.15d)
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


        Registry.mainWindow.setNodeToMap(outer_table_wrapper,"outer_table_wrapper");


         GridPaneWrapper.newBuilder()
                .setGridName("Текущий список сотрудников и актуальные тарифные ставки")
                .setParentAnchor(dynamicContentAnchorHolder)
                .setCoordinate(new Coordinate(0d, 0d, 10d, 0d))
                .setGridLinesVisibility(gridVisibility)
                .setOrganization(
                        new SingleTable(
                                outer_table_wrapper,
                                new ButSizeBig(
                                        new RowDeleteFromTable(outer_table_wrapper),
                                        new SubWindowCreater(hiringWindowBuilder)
                                ),
                                new CtrlPosBotton()
//                                new CtrlPosTop()
                        ))
                .build();
    }

    @Override
    public void closeDynamicContentPanel() {
        Registry.mainWindow.delNodeFromMap(outer_table_wrapper );

    }

    @Override
    public void initServices() {
        mediator.setTableWrapper(outer_table_wrapper);
        mediator.initElements();
    }




}
