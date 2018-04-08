package basisFx.domainModel.targets;

import basisFx.appCore.controlPolicy.ColumnWrapper;
import basisFx.appCore.elements.AppNode;
import basisFx.appCore.elements.TableViewWrapper;
import basisFx.appCore.panels.Target;
import basisFx.domainModel.pojo.Employees;
import basisFx.domainModel.pojo.RatePerHour;
import basisFx.domainModel.settings.CSSID;
import basisFx.domainModel.settings.FontsStore;

import java.time.LocalDate;

public class EmployeesTargetPanel extends Target{

    private TableViewWrapper tableViewWrapper;
    @Override
    protected void createElement() {    tableViewWrapper = AppNode.NodeBuilder.create()
            .setId(CSSID.TABLE).setCoordinate(panel,50d, null, 0d, 0d)
            .<Employees>createTableViewWrapper().setTablesWidthProperty(0.8, panel.widthProperty())
            .setDataMapper(this.dataMapperFabric.getEmployeesDataMapper())
            .setDbTableName("Employees").refresh()
            .setColums(
                    columnFabric.createStringColumn(ColumnWrapper.Bulder.create()
                            .setColumnName("ФИО").setPropertyName("name").setColumnSize(0.4d)
                            .setDomainChangeAction(
                                    (obj,val)->{((Employees)obj).setName((String)val);}
                            )
                    ),
                    columnFabric.createColumnDoubleComboBox(ColumnWrapper.Bulder.create()
                            .setColumnName("Тариф").setColumnSize(0.2).setPropertyName("rate")
                            .setDomainObjectListGetter(() -> dataMapperFabric.getEmployeesDataMapper().getRateTemplateList())
                            .setDomainChangeAction(
                                    (obj,val)->{((Employees)obj).setRate((RatePerHour) val);}
                            )
                    ),
                    columnFabric.createLocalDateColumn(ColumnWrapper.Bulder.create()
                            .setColumnName("Дата начала действия тарифа") .setPropertyName("startingRateDate").setColumnSize(0.4d)
//                            .setDateCellValueInitLogic((domainObject)->{
//                                return ((Employees)domainObject).startingRateDateProperty();})
                            .sgit etDomainChangeAction((obj,val)->{((Employees)obj).setStartingRateDate((LocalDate) val); } )
                    )
            );



        AppNode.NodeBuilder.create()
                .setId(CSSID.PANELS_BUTTON)
                .setCoordinate(panel, 80d,0d, null, null)
                .setText("ДОБАВИТЬ").setFont(FontsStore.ROBOTO_LIGHT, 15)
                .setWidth(170d).setHeight(20d)
                .setEvent(eventFactory.
                        createRowAdd(
                                tableViewWrapper,
                                (l)->{l.add(new Employees());}))
                .createNButton();

        AppNode.NodeBuilder.create()
                .setId(CSSID.PANELS_BUTTON)
                .setCoordinate(panel, 120d,0d, null, null)
                .setText("УДАЛИТЬ").setFont(FontsStore.ROBOTO_LIGHT, 15)
                .setWidth(170d).setHeight(20d)
                .setEvent(eventFactory.createRowDeleteFromTable(tableViewWrapper))
                .createNButton();






    }

}
