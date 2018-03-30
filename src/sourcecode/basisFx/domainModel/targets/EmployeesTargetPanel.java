package basisFx.domainModel.targets;

import basisFx.appCore.controlPolicy.ColumnWrapper;
import basisFx.appCore.domainScetch.NamedDomainObject;
import basisFx.appCore.elements.AppNode;
import basisFx.appCore.elements.TableViewWrapper;
import basisFx.appCore.panels.Target;
import basisFx.domainModel.settings.CSSID;
import basisFx.domainModel.settings.FontsStore;

public class EmployeesTargetPanel extends Target{

    private TableViewWrapper tableViewWrapper;
    @Override
    protected void createElement() {
//todo


        tableViewWrapper = AppNode.NodeBuilder.create()
                .setId(CSSID.TABLE).setCoordinate(panel,50d, null, 0d, 0d)
                .<Equipment>createTableViewWrapper().setTablesWidthProperty(0.7, panel.widthProperty())
                .setDataMapper(this.dataMapperFabric.getEquipmentDataMapper())
                .setDbTableName("Equipment").refresh()
                .setColums(
                        columnFabric.<Equipment,String>createStringColumn(ColumnWrapper.Bulder.create()
                                .setColumnName("Наименование")
                                .setPropertyName("name")
                                .setValueChecking(check.createTextCheck())
                                .setColumnSize(0.6)
                                .setDomainChangeAction(
                                        (obj,val)->{((Equipment)obj).setName((String)val);}
                                )
                        ),
                        columnFabric.<Equipment,Integer>createIntegerColumn(ColumnWrapper.Bulder.create()
                                .setColumnName("Ширина стержня")
                                .setPropertyName("rodWidth")
                                .setValueChecking(check.createNumCheck())
                                .setColumnSize(0.4)
                                .setDomainChangeAction(
                                        (obj,val)->{((Equipment)obj).setRodWidth((Integer)val);}
                                )
                        )
                );




    }

}
