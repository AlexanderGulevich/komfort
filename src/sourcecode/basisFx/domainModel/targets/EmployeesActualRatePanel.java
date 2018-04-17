package basisFx.domainModel.targets;

import basisFx.appCore.controlPolicy.ColumnWrapper;
import basisFx.appCore.domainScetch.StringValueDomainObject;
import basisFx.appCore.elements.AppNode;
import basisFx.appCore.elements.TableViewWrapper;
import basisFx.appCore.panels.Target;
import basisFx.appCore.utils.Coordinate;
import basisFx.domainModel.domaine.Employer;
import basisFx.domainModel.settings.CSSID;
import basisFx.domainModel.settings.FontsStore;
import javafx.geometry.Pos;

import java.time.LocalDate;

public class EmployeesActualRatePanel extends Target{

    private TableViewWrapper tableViewWrapper;
    @Override
    protected void createElement() {


        textFabric.createLabel("Текущий список сотрудников и актуальных тарифных ставок ", FontsStore.ROBOTO_LIGHT,  Pos.BASELINE_CENTER,25d,
                panel, new Coordinate(10d,0d,null,0d));




        tableViewWrapper = AppNode.NodeBuilder.create()
            .setId(CSSID.TABLE).setCoordinate(panel,50d, null, 0d, 0d)
            .createTableViewWrapper().setTablesWidthProperty(1, panel.widthProperty())
            .setEditable(false)
            .setDataMapper(this.dataMapperFabric.getEmployerDataMapper()).refresh()
            .setColums(
                    columnFabric.createStringColumn("ФИО","stringValue",0.6d,
                            (obj,val)->((Employer)obj).setStringValue((String)val))
,
                    columnFabric.createColumnStringComboBox("Тариф","rate",0.1,
                            (obj,val)->{((Employer)obj).setRate((StringValueDomainObject) val);},
                            () -> dataMapperFabric.getEmployerDataMapper().getRateTemplateList()
                    ),
                    columnFabric.createLocalDateColumn(ColumnWrapper.Bulder.create()
                            .setColumnName("Дата начала действия тарифа") .setPropertyName("startingRateDate").setColumnSize(0.3d)
                            .setDomainChangeAction((obj,val)->{((Employer)obj).setStartingRateDate((LocalDate) val); } )
                    )
            );



    }

}
