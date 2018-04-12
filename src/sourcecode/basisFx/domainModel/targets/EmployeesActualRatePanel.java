package basisFx.domainModel.targets;

import basisFx.appCore.controlPolicy.ColumnWrapper;
import basisFx.appCore.domainScetch.StringValueDomainObject;
import basisFx.appCore.elements.AppNode;
import basisFx.appCore.elements.TableViewWrapper;
import basisFx.appCore.panels.Target;
import basisFx.appCore.utils.Coordinate;
import basisFx.domainModel.pojo.Employer;
import basisFx.domainModel.settings.CSSID;
import basisFx.domainModel.settings.FontsStore;

import java.time.LocalDate;

public class EmployeesActualRatePanel extends Target{

    private TableViewWrapper tableViewWrapper;
    @Override
    protected void createElement() {

        tableViewWrapper = AppNode.NodeBuilder.create()
            .setId(CSSID.TABLE).setCoordinate(panel,50d, null, 0d, 0d)
            .createTableViewWrapper().setTablesWidthProperty(1, panel.widthProperty())
            .setEditable(false)
            .setDataMapper(this.dataMapperFabric.getEmployeesActualRateDataMapper()).refresh()
            .setColums(
                    columnFabric.createStringColumn("ФИО","stringValue",0.6d,
                            (obj,val)->((Employer)obj).setStringValue((String)val))
,
                    columnFabric.createColumnStringComboBox(ColumnWrapper.Bulder.create()
                            .setColumnName("Тариф").setColumnSize(0.1).setPropertyName("rate")
                            .setDomainObjectListGetter(() -> dataMapperFabric.getEmployeesActualRateDataMapper().getRateTemplateList())
                            .setDomainChangeAction(
                                    (obj,val)->{((Employer)obj).setRate((StringValueDomainObject) val);}
                            )
                    ),
                    columnFabric.createLocalDateColumn(ColumnWrapper.Bulder.create()
                            .setColumnName("Дата начала действия тарифа") .setPropertyName("startingRateDate").setColumnSize(0.3d)
                            .setDomainChangeAction((obj,val)->{((Employer)obj).setStartingRateDate((LocalDate) val); } )
                    )
            );



    }

}
