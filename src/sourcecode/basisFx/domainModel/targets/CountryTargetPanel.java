package basisFx.domainModel.targets;

import basisFx.appCore.controlPolicy.ColumnWrapper;
import basisFx.appCore.domainScetch.StringValueDomainObject;
import basisFx.appCore.elements.AppNode;
import basisFx.appCore.elements.TableViewWrapper;
import basisFx.appCore.panels.Target;
import basisFx.domainModel.pojo.Country;
import basisFx.domainModel.settings.CSSID;
import basisFx.domainModel.settings.FontsStore;

/**
 * Created by AlexanderGulevich on 18.03.2018.
 *
 * @autor AlexanderGulevich
 */
public class CountryTargetPanel extends Target {

    private TableViewWrapper tableViewWrapper;
    @Override
    protected void createElement() {

        tableViewWrapper = AppNode.NodeBuilder.create()
                .setId(CSSID.TABLE).setCoordinate(panel,50d, null, 0d, 0d)
                .<Country>createTableViewWrapper().setTablesWidthProperty(0.7, panel.widthProperty())
                .setDataMapper(this.dataMapperFabric.getCountryDataMapper())
                .setDbTableName("Country").refresh()
                .setColums(
                        columnFabric.<StringValueDomainObject,String>createStringColumn(ColumnWrapper.Bulder.create()
                                        .setColumnName("Наименование")
                                        .setPropertyName("stringValue")
                                        .setValueChecking(check.createTextCheck())
                                        .setColumnSize(1)
                                        .setDomainChangeAction(
                                                (obj,val)->{((Country)obj).setStringValue((String)val);}
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