package basisFx.presentation.dynamicContents;
import basisFx.appCore.events.RowDeleteFromTable;
import basisFx.appCore.events.SubWindowCreater;
import basisFx.appCore.grid.*;
import basisFx.appCore.table.*;
import basisFx.appCore.utils.Registry;
import basisFx.appCore.windows.WindowAbstraction;
import basisFx.appCore.windows.WindowBuilder;
import basisFx.domain.ActualEmployersRate;
import basisFx.presentation.DynamicContentPanel;
import basisFx.service.ServiceTablesSingle;
import basisFx.appCore.elements.TableWrapper;
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
                .setDynamicContentPanelCreator(RatePerHourPanel::new)
                .setTitle("Архив тарифов")
                .setMessage(null)
                .setFxmlFileName("ByDateResearchWindow")
                .setParentAnchorNameForFXML(WindowAbstraction.DefaultPanelsNames.topVisibleAnchor.name())
                .setWidth(700d)
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
                        ColWrapperString.newBuilder()
                                .setColumnName("Фамилия / Имя / Отчество")
                                .setColumnSize(0.5d)
                                .setIsEditeble(true)
                                .setPropertyName("NAME")
                                .build(),
                        ColWrapperDouble.newBuilder()
                                .setColumnName("Тариф - руб./ч. ")
                                .setColumnSize(0.15d)
                                .setIsEditeble(false)
                                .setPropertyName("RATE")
                                .build(),
                        ColWrapperDate.newBuilder()
                                .setColumnName("Начало действия")
                                .setColumnSize(0.15d)
                                .setIsEditeble(false)
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
                                new ButSizeLittle(
                                        new RowDeleteFromTable(outer_table_wrapper),
                                        new SubWindowCreater(hiringWindowBuilder)
                                ),
                                new CtrlPosTop()
//                                new CtrlPosBotton()
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
