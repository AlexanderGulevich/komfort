package basisFx.domainModel.targets;

import basisFx.appCore.controls.KindOfColumn;
import basisFx.appCore.elements.AppNode;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.panels.Target;
import basisFx.appCore.utils.Coordinate;
import basisFx.domainModel.domaine.RatePerHour;
import basisFx.appCore.settings.CSSID;
import basisFx.appCore.settings.FontsStore;

public class RatePerHourPanel extends Target {

    private TableWrapper tableWrapper;



    @Override
    @SuppressWarnings("unchecked")
    public void createElement() {


        tableWrapper = tableFabric.table(
                panel,0.7d,new Coordinate(50d, null, 0d, 0d),
                dataMapper.ratePerHourTemplatesDataMapper(),
                        columnFabric.createColumn(KindOfColumn.DOUBLE,
                                "\"Тариф ( бел. руб/час. )\"","name",1d,true,
                                 (obj,val)->((RatePerHour)obj).setName((String) val)
                        )


                );



        AppNode.NodeBuilder.create()
                .setId(CSSID.PANELS_BUTTON)
                .setCoordinate(panel, 80d,50d, null, null)
                .setText("ДОБАВИТЬ").setFont(FontsStore.ROBOTO_LIGHT, 15)
                .setWidth(170d).setHeight(20d)
                .setEvent(eventFactory.
                        rowAdd(
                                tableWrapper,
                                (l)->{l.add(new RatePerHour());}))
                .createNButton();

        AppNode.NodeBuilder.create()
                .setId(CSSID.PANELS_BUTTON)
                .setCoordinate(panel, 120d,50d, null, null)
                .setText("УДАЛИТЬ").setFont(FontsStore.ROBOTO_LIGHT, 15)
                .setWidth(170d).setHeight(20d)
                .setEvent(eventFactory.rowDeleteFromTable(tableWrapper))
                .createNButton();











    }

}
