package basisFx.presentation.dynamicContents;

import basisFx.appCore.elements.*;
import basisFx.appCore.grid.*;
import basisFx.appCore.settings.CSSclasses;
import basisFx.appCore.table.ColWrapperDate;
import basisFx.appCore.table.ColWrapperDouble;
import basisFx.appCore.utils.Range;
import basisFx.presentation.DynamicContentPanel;
import basisFx.service.ServiceTablesSingle;
import basisFx.appCore.utils.Coordinate;
import basisFx.domain.*;
import javafx.scene.control.ComboBox;

public class SleevePanel  extends DynamicContentPanel {
    private ServiceTablesSingle mediator;
    private TableWrapper rightTableWrapper ;
    private RangeDirector rangeDirector;
    @Override
    public void createServices() {
        mediator =new ServiceTablesSingle();
    }

    @Override
    public void customDynamicElementsInit() {
        rangeDirector=new RangeDirector(
                new ComboBox<>(),
                mediator,
                Range.LAST10,
                Range.get(
                        Range.LAST10,
                        Range.LAST30,
                        Range.ALLTIME
                )
        );

        rightTableWrapper = TableWrapper.newBuilder()
                .setGridName("Цены")
                .setCssClasses(CSSclasses.first_child_Red)
                .setOrganization( new SingleTable(new ButSizeLittle(),new CtrlPosButAndCombobox(rangeDirector.getComboBox())))
                .setActiveRecordClass(SleevePrice.class)
                .setUnitOfWork(unitOfWork)
                .setIsEditable(true)
                .setIsSortableColums(false)
                .setServiceTables(mediator)
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


        GridPaneWrapper.newBuilder()
                .setGridName("Цена втулок")
                .setParentAnchor(dynamicContentAnchorHolder)
                .setCoordinate(new Coordinate(0d, 10d, 10d, 0d))
                .setGridLinesVisibility(gridVisibility)
                .setOrganization(
                        new SingleTable(rightTableWrapper, new ButSizeBig(),new CtrlPosButAndCombobox(rangeDirector.getComboBox())
                        ))
                .build();
    }

    @Override
    public void initServices() {
        mediator.setTableWrapper(rightTableWrapper);
        mediator.setRangeDirector(rangeDirector);
        mediator.initElements();
    }


}
