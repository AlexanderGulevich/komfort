package basisFx.presentation.dynamicContents;

import basisFx.appCore.elements.*;
import basisFx.appCore.grid.*;
import basisFx.appCore.settings.CSSclasses;
import basisFx.appCore.table.ColWrapperDate;
import basisFx.appCore.table.ColWrapperDouble;
import basisFx.appCore.utils.Range;
import basisFx.presentation.DynamicContentPanel;
import basisFx.service.ServiceTablesTwoLinked;
import basisFx.appCore.table.ColWrapperComboBox;
import basisFx.appCore.utils.Coordinate;
import basisFx.domain.*;
import javafx.scene.control.ComboBox;

public class SleevePanel  extends DynamicContentPanel {
    private ServiceTablesTwoLinked mediatorServiceTwoLinkedTable;
    private TableWrapper leftTableWrapper ;
    private TableWrapper rightTableWrapper ;
    private RangeDirector rangeDirector ;

    @Override
    public void createServices() {
        mediatorServiceTwoLinkedTable =new ServiceTablesTwoLinked();
    }

    @Override
    public void customDynamicElementsInit() {

        rangeDirector=new RangeDirector(
                new ComboBox<>(),
                mediatorServiceTwoLinkedTable,
                Range.DAY30,
                Range.getAll()
        );

          leftTableWrapper = TableWrapper.newBuilder()
                .setGridName("Втулка ")
                .setOrganization(new SingleTable(new ButSizeLittle(),new CtrlPosTop()))
                .setActiveRecordClass(Sleeve.class)
                .setUnitOfWork(unitOfWork)
                .setIsEditable(true)
                .setIsSortableColums(false)
                .setServiceTables(mediatorServiceTwoLinkedTable)
                .setColWrappers(
                        ColWrapperComboBox.newBuilder(Counterparty.class)
                                .setColumnName("Поставщик")
                                .setColumnSize(1d)
                                .setIsEditeble(true)
                                .setPropertyName("counterparty")
                                .build()
                )
                .build();





        rightTableWrapper = TableWrapper.newBuilder()
                .setGridName("Архив цен ")
                .setCssClasses(CSSclasses.first_child_Red)
                .setOrganization( new SingleTable(new ButSizeLittle(),new CtrlPosButAndCombobox(rangeDirector.getComboBox())))
//                .setOrganization( new SingleTable(new ButSizeLittle(),new CtrlPosTop()))
                .setActiveRecordClass(SleevePrice.class)
                .setUnitOfWork(unitOfWork)
                .setIsEditable(true)
                .setIsSortableColums(false)
                .setServiceTables(mediatorServiceTwoLinkedTable)
                .setColWrappers(
                        ColWrapperDouble.newBuilder()
                                .setColumnName("Цена")
                                .setColumnSize(0.4d)
                                .setIsEditeble(true)
                                .setPropertyName("price")
                                .build(),
                        ColWrapperDate.newBuilder()
                                .setColumnName("Действует с")
                                .setColumnSize(0.6d)
                                .setIsEditeble(true)
                                .setPropertyName("startDate")
                                .build()
                )
                .build();


        GridPaneWrapper commonGridPaneWrapper = GridPaneWrapper.newBuilder()
                .setColumnVsPercent(70)
                .setColumnVsPercent(30)
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



//        ComboBox<Range> comboBox = new RangeDirector(
//                new ComboBox<>(),
//                mediatorServiceTwoLinkedTable,
//                Range.ACTUAL,
//                Range.getAll()
//        ).getComboBox();
//
//        Coordinate  coordinate=new Coordinate(0d,20d,null,null);
//        coordinate.setParentAnchorPane(dynamicContentAnchorHolder);
//        coordinate.setChildNode(comboBox);
//        coordinate.bonding();

//        ButtonWrapper.newBuilder()
//                .setParentAnchor(dynamicContentAnchorHolder)
//                .setCoordinate(new Coordinate(10d,20d,null,null))
//                .setText("РЕЕСТР ЦЕН")
//                .setCssClasses(CSSclasses.REGISTRY_BUTTONS_BFx)
//                .setEvents(
//                        new SubWindowCreater(
//                                WindowBuilder.newBuilder()
//                                        .setClosingCallBack(()->leftTableWrapper.getServiceTables().refresh(leftTableWrapper))
//                                        .setGUIStructura(null)
//                                        .setButtonsForStage(null)
//                                        .setFxmlFileName("ByDateResearchWindow")
//                                        .setParentAnchorNameForFXML(WindowAbstraction.DefaultPanelsNames.topVisibleAnchor.name())
//                                        .setWidth(900d)
//                                        .setHeight(600d)
//                                        .setDynamicContentPanelCreator(PopupExemple::new)
//                                        .setTitle("ОБОРУДОВАНИЕ")
//                                        .setMessage(null)
//                                        .build()
//                        )
//                )
//                .build();


    }

    @Override
    public void initServices() {



        mediatorServiceTwoLinkedTable.setAccessoryTableWrapper(rightTableWrapper);
        mediatorServiceTwoLinkedTable.setPrimaryTableWrapper(leftTableWrapper);
        mediatorServiceTwoLinkedTable.setRangeDirector(rangeDirector);
        mediatorServiceTwoLinkedTable.initElements();

    }


}
