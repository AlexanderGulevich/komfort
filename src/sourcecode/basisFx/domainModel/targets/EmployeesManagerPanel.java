package basisFx.domainModel.targets;

import basisFx.appCore.controlPolicy.ColumnWrapper;
import basisFx.appCore.elements.AppNode;
import basisFx.appCore.elements.TableViewWrapper;
import basisFx.appCore.panels.Target;
import basisFx.domainModel.pojo.Employer;
import basisFx.domainModel.settings.CSSID;
import basisFx.domainModel.settings.FontsStore;

public class EmployeesManagerPanel extends Target {
    private TableViewWrapper tableViewWrapper;
    @Override
    protected void createElement() {

        tableViewWrapper = AppNode.NodeBuilder.create()
                .setId(CSSID.TABLE).setCoordinate(panel,50d, null, 0d, 0d)
                .createTableViewWrapper().setTablesWidthProperty(0.8, panel.widthProperty())
                .setDataMapper(this.dataMapperFabric.getEmployeesActualRateDataMapper()).refresh()
                .setColums(
                        columnFabric.createStringColumn(ColumnWrapper.Bulder.
                                create("ФИО","stringValue",1d)
                                .setDomainChangeAction(
                                        (obj,val)->{((Employer)obj).setStringValue((String)val);}
                                )
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
                                (l)->{l.add(new Employer());}))
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
