package basisFx.domainModel.targets;

import basisFx.appCore.elements.AppNode;
import basisFx.appCore.elements.TableViewWrapper;
import basisFx.appCore.panels.Target;
import basisFx.domainModel.domaine.RatePerHour;
import basisFx.domainModel.settings.CSSID;
import basisFx.domainModel.settings.FontsStore;

public class RatePerHourPanel extends Target {

    private TableViewWrapper tableViewWrapper;



    @Override
    @SuppressWarnings("unchecked")
    public void createElement() {


        tableViewWrapper = AppNode.NodeBuilder.create()
                .setId(CSSID.TABLE).setCoordinate(panel,50d, null, 0d, 0d)
                .createTableViewWrapper().setTablesWidthProperty(0.7, panel.widthProperty())
                .setDataMapper(this.dataMapperFabric.getRatePerHourTemplatesDataMapper()).refresh()
                .setColums(
                        columnFabric.createStringColumn(
                                "\"Тариф ( бел. руб/час. )\"","stringValue",1d,
                                 (obj,val)->((RatePerHour)obj).setStringValue((String) val)
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
                                (l)->{l.add(new RatePerHour());}))
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
