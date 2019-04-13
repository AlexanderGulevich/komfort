package basisFx.presentation;

import basisFx.appCore.activeRecord.ActiveRecord;
import basisFx.appCore.elements.GridPaneWrapper;
import basisFx.appCore.elements.RangeDirector;
import basisFx.appCore.grid.*;
import basisFx.appCore.table.*;
import basisFx.appCore.utils.Range;
import basisFx.domain.*;
import basisFx.service.ServiceTablesTwoLinked;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.utils.Coordinate;
import basisFx.appCore.DynamicContentPanel;
import javafx.scene.control.ComboBox;

public class LabelPanel  extends DynamicContentPanel {

    private ServiceTablesTwoLinked mediator;
    private  TableWrapper leftTableWrapper ;
    private  TableWrapper rightTableWrapper ;
    private RangeDirector rangeDirector;

    @Override
    public void createServices() {
        mediator =new ServiceTablesTwoLinked();
    }

    @Override
    public void customDynamicElementsInit() {
        rangeDirector=new RangeDirector(new ComboBox<>(), mediator, Range.LAST10,Range.getAll());

          leftTableWrapper = TableWrapper.newBuilder()
                .setGridName("Этикетки")
                .setOrganization(new SingleTable(new ButSizeLittle(),new CtrlPosTop()))
                .setActiveRecordClass(Label.class)
                .setUnitOfWork(unitOfWork)
                .setIsEditable(true)
                .setIsSortableColums(false)
                .setServiceTables(mediator)
                .setColWrappers(
                        ColWrapperString.newBuilder()
                                .setColumnName("Наименование")
                                .setColumnSize(0.4d)
                                .setIsEditeble(true)
                                .setPropertyName("name")
                                .build(),
                        ColWrapperComboBox.newBuilder(Counterparty.class)
                                .setColumnName("Поставщик")
                                .setColumnSize(0.4d)
                                .setIsEditeble(true)
                                .setPropertyName("counterparty")
                                .build(),
                        ColWrapperBind.newBuilder()
                                .setColumnName("Валюта")
                                .setColumnSize(0.2d)
                                .setCallBackTypedAndParametrized(
                                        r -> {
                                            Label var = (Label) r;
                                            if (!ActiveRecord.isNewDomane(var)) {
                                               return  var .getCounterparty().currencyProperty();
                                            }
                                            else return null;
                                        }

                                )
                                .build())
                .build();


          rightTableWrapper = TableWrapper.newBuilder()
                .setGridName("Цены")
                .setOrganization( new SingleTable(new ButSizeLittle(),new CtrlPosButAndCombobox(rangeDirector.getComboBox())))
                .setActiveRecordClass(LabelPrice.class)
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

        GridPaneWrapper commonGridPaneWrapper = GridPaneWrapper.newBuilder()
                .setColumnVsPercent(70)
                .setColumnVsPercent(30)
                .setGridName("Управление валютами и динамика курсов")
                .setParentAnchor(dynamicContentAnchorHolder)
                .setCoordinate(new Coordinate(0d, 10d, 10d, 0d))
                .setGridLinesVisibility(gridVisibility)
                .setOrganization(new TwoHorisontalBondGrids(leftTableWrapper,rightTableWrapper))
                .build();




    }

    @Override
    public void initServices() {
        mediator.setAccessoryTableWrapper(rightTableWrapper);
        mediator.setPrimaryTableWrapper(leftTableWrapper);;
        mediator.setRangeDirector(rangeDirector);
        mediator.initElements();

    }


}

