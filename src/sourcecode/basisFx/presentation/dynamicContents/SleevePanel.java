package basisFx.presentation.dynamicContents;

import basisFx.appCore.elements.ButtonWrapper;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.events.SubWindowCreater;
import basisFx.appCore.grid.ButPosTop;
import basisFx.appCore.grid.ButSizeLittle;
import basisFx.appCore.grid.SingleTable;
import basisFx.appCore.grid.TwoHorisontalBondGrids;
import basisFx.appCore.elements.GridPaneWrapper;
import basisFx.appCore.settings.CSSclasses;
import basisFx.appCore.windows.WindowAbstraction;
import basisFx.appCore.windows.WindowBuilder;
import basisFx.presentation.DynamicContentPanel;
import basisFx.service.ServiceTablesTwoLinkedTable;
import basisFx.appCore.table.ColumnWrapperComboBox;
import basisFx.appCore.table.ColumnWrapperDate;
import basisFx.appCore.table.ColumnWrapperDouble;
import basisFx.appCore.utils.Coordinate;
import basisFx.domain.*;

public class SleevePanel  extends DynamicContentPanel {
    private ServiceTablesTwoLinkedTable mediatorServiceTwoLinkedTable;
    private TableWrapper leftTableWrapper ;
    private TableWrapper rightTableWrapper ;

    @Override
    public void createServices() {
        mediatorServiceTwoLinkedTable =new ServiceTablesTwoLinkedTable();
    }

    @Override
    public void customDynamicElementsInit() {


          leftTableWrapper = TableWrapper.newBuilder()
                .setGridName("Втулка ")
                .setOrganization(new SingleTable(new ButSizeLittle(),new ButPosTop()))
                .setActiveRecordClass(Sleeve.class)
                .setUnitOfWork(unitOfWork)
                .setIsEditable(true)
                .setIsSortableColums(false)
                .setServiceTables(mediatorServiceTwoLinkedTable)
                .setColumnWrappers(
                        ColumnWrapperComboBox.newBuilder(Counterparty.class)
                                .setColumnName("Поставщик")
                                .setColumnSize(1d)
                                .setIsEditeble(true)
                                .setPropertyName("counterparty")
                                .build()
                )
                .build();


          rightTableWrapper = TableWrapper.newBuilder()
                .setGridName("Архив цен ")
                .setOrganization(new SingleTable(new ButSizeLittle(),new ButPosTop()))
                .setActiveRecordClass(SleevePrice.class)
                .setUnitOfWork(unitOfWork)
                .setIsEditable(true)
                .setIsSortableColums(false)
                .setServiceTables(mediatorServiceTwoLinkedTable)
                .setColumnWrappers(
                        ColumnWrapperDouble.newBuilder()
                                .setColumnName("Цена")
                                .setColumnSize(0.3d)
                                .setIsEditeble(true)
                                .setPropertyName("price")
                                .build(),
                        ColumnWrapperDate.newBuilder()
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
                .setGridName("Поставщики втулок и цены")
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

        ButtonWrapper.newBuilder()
                .setParentAnchor(dynamicContentAnchorHolder)
                .setCoordinate(new Coordinate(10d,20d,null,null))
                .setText("РЕЕСТР ЦЕН")
                .setCssClasses(CSSclasses.REGISTRY_BUTTONS_BFx)
                .setEvents(
                        new SubWindowCreater(
                                WindowBuilder.newBuilder()
                                        .setClosingCallBack(()->leftTableWrapper.getServiceTables().refresh(leftTableWrapper))
                                        .setGUIStructura(null)
                                        .setButtonsForStage(null)
                                        .setFxmlFileName("ByDateResearchWindow")
                                        .setParentAnchorNameForFXML(WindowAbstraction.DefaultPanelsNames.topVisibleAnchor.name())
                                        .setWidth(900d)
                                        .setHeight(600d)
                                        .setDynamicContentPanelCreator(PopupExemple::new)
                                        .setTitle("ОБОРУДОВАНИЕ")
                                        .setMessage(null)
                                        .build()
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
