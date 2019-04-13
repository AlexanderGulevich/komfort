package basisFx.presentation;

import basisFx.appCore.elements.GridPaneWrapper;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.events.RowDeleteFromTable;
import basisFx.appCore.events.SubWindowCreaterByBut;
import basisFx.appCore.events.YNWindowCreaterForTable;
import basisFx.appCore.grid.*;
import basisFx.appCore.table.ColWrapperString;
import basisFx.appCore.utils.Coordinate;
import basisFx.appCore.utils.Registry;
import basisFx.appCore.windows.WindowBuilder;
import basisFx.domain.Fired;
import basisFx.appCore.DynamicContentPanel;
import basisFx.service.ServiceTablesSingle;

public class FiredEmployeesPanel extends DynamicContentPanel {
    private ServiceTablesSingle mediator;
    private TableWrapper outer_table_wrapper;
    private WindowBuilder hiringWindowBuilder;

    @Override
    public void createServices() {
        mediator =new ServiceTablesSingle();
    }

    @Override
    public void customDynamicElementsInit() {

        outer_table_wrapper = TableWrapper.newBuilder()
                .setGridName("Сотрудники ")
                .setActiveRecordClass(Fired.class)
                .setUnitOfWork(unitOfWork)
                .setIsEditable(true)
                .setIsSortableColums(false)
                .setServiceTables(mediator)
                .setColWrappers(
                        ColWrapperString.newBuilder()
                                .setColumnName("Фамилия / Имя / Отчество")
                                .setColumnSize(1d)
                                .setIsEditeble(true)
                                .setPropertyName("name")
                                .build()
                )
                .build();


        Registry.mainWindow.setNodeToMap(outer_table_wrapper,"outer_table_wrapper");


         GridPaneWrapper.newBuilder()
                .setGridName("Уволенные сотрудники")
                .setParentAnchor(dynamicContentAnchorHolder)
                .setCoordinate(new Coordinate(0d, 10d, 10d, 0d))
                .setGridLinesVisibility(gridVisibility)
                .setOrganization(
                        new SingleTable(
                                outer_table_wrapper,
                                new ButSizeBig(
                                        new YNWindowCreaterForTable(
                                                new RowDeleteFromTable(outer_table_wrapper),
                                                "Вы уверены, что хотите восстановить на работе сотрудника"
                                        ) ,
                                        new SubWindowCreaterByBut(hiringWindowBuilder)
                                ),
                                new CtrlPosDelBut()
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
