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
            .setDataMapper(this.dataMapper.employerDataMapper()).refresh()
            .setColums(
                    columnFabric.createColumn("ФИО","stringValue",0.6d,true,
                            (obj,val)->((Employer)obj).setStringValue((String)val))
,
                    columnFabric.createColumnComboBox("Тариф","rate",0.1,true,
                            (obj,val)->{((Employer)obj).setRate((StringValueDomainObject) val);},
                            () -> dataMapper.employerDataMapper().getRateTemplateList()
                    ),
                    columnFabric.createDateColumn("Дата начала действия тарифа","startingRateDate",0.3d,true,
                            (obj, val)->{((Employer)obj).setStartingRateDate((LocalDate) val); }
                    )
            );



    }

}
