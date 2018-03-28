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
                .<Country>createTableViewWrapper().setTablesWidthProperty(0.7, panel.widthProperty())
                .setDataMapper(this.dataMapperFabric.getCountryDataMapper())
                .setDbTableName("Country").refresh()
                .setColums(
                        columnFabric.<NamedDomainObject,String>createStringColumn(ColumnWrapper.Bulder.create()
                                .setColumnName("Наименование")
                                .setPropertyName("name")
                                .setValueChecking(check.createTextCheck())
                                .setColumnSize(1)
                                .setDomainChangeAction(
                                        (obj,val)->{((Country)obj).setName((String)val);}
                                )
                        )
                );


        AppNode.NodeBuilder.create()
                .setId(CSSID.PANELS_BUTTON)
                .setCoordinate(panel, 80d,50d, null, null)
                .setText("ДОБАВИТЬ").setFont(FontsStore.ROBOTO_LIGHT, 15)
                .setWidth(170d).setHeight(20d)
                .setEvent(eventFactory.
                        createRowAdd(
                                tableViewWrapper,
                                (l)->{l.add(new Country());}))
                .createNButton();

        AppNode.NodeBuilder.create()
                .setId(CSSID.PANELS_BUTTON)
                .setCoordinate(panel, 120d,50d, null, null)
                .setText("УДАЛИТЬ").setFont(FontsStore.ROBOTO_LIGHT, 15)
                .setWidth(170d).setHeight(20d)
                .setEvent(eventFactory.createRowDeleteFromTable(tableViewWrapper))
                .createNButton();














    }

}
