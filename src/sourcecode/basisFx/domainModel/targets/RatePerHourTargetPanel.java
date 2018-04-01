package basisFx.domainModel.targets;

import basisFx.appCore.controlPolicy.ColumnWrapper;
import basisFx.appCore.elements.AppNode;
import basisFx.appCore.elements.TableViewWrapper;
import basisFx.appCore.panels.Target;
import basisFx.domainModel.pojo.RatePerHour;
import basisFx.domainModel.settings.CSSID;
import basisFx.domainModel.settings.FontsStore;

public class RatePerHourTargetPanel  extends Target {

    private TableViewWrapper tableViewWrapper;



    @Override
    @SuppressWarnings("unchecked")
    public void createElement() {


        tableViewWrapper = AppNode.NodeBuilder.create()
                .setId(CSSID.TABLE).setCoordinate(panel,50d, null, 0d, 0d)
                .<RatePerHour>createTableViewWrapper().setTablesWidthProperty(0.7, panel.widthProperty())
                .setDataMapper(this.dataMapperFabric.getRatePerHourDataMapper())
                .setDbTableName("RatePerHour").refresh()
                .setColums(

                        columnFabric.<RatePerHour,Double>createDoubleColumn(ColumnWrapper.Bulder.create()
                                .setColumnName("Тариф ( бел. руб/час. )")
                                .setPropertyName("ratePerHour")
//                                .setValueChecking(check.createNumCheck())
                                .setColumnSize(1)
                                .setDomainChangeAction((obj,val)->{((RatePerHour)obj).setRatePerHour((Double)val); } )
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
