package basisFx.domainModel.targets;

import basisFx.appCore.controlPolicy.KindOfColumn;
import basisFx.appCore.domainScetch.StringValueDomainObject;
import basisFx.appCore.elements.TableViewWrapper;
import basisFx.appCore.panels.Target;
import basisFx.appCore.utils.Coordinate;
import basisFx.domainModel.domaine.Employer;
import basisFx.appCore.settings.FontsStore;
import javafx.geometry.Pos;

import java.time.LocalDate;

public class EmployeesActualRatePanel extends Target{

    private TableViewWrapper tableViewWrapper;
    @Override
    protected void createElement() {


        textFabric.createLabel("Текущий список сотрудников и актуальных тарифных ставок ", FontsStore.ROBOTO_LIGHT,  Pos.BASELINE_CENTER,25d,
                panel, new Coordinate(10d,0d,null,0d));




        tableViewWrapper = tableFabric.createStandartTable(
            panel,1d,new Coordinate(50d, null, 0d, 0d),
            dataMapper.employerDataMapper(),
                    columnFabric.createColumn(KindOfColumn.STRING,"ФИО","name",0.6d,true,
                            (obj,val)->((Employer)obj).setName((String)val))
,
                    columnFabric.createColumnComboBox(KindOfColumn.COMBOBOX,"Тариф","rate",0.1,true,
                            (obj,val)->{((Employer)obj).setRate((StringValueDomainObject) val);},
                            () -> dataMapper.employerDataMapper().getRateTemplateList()
                    ),
                    columnFabric.createDateColumn(KindOfColumn.DATE,"Дата начала действия тарифа","startingRateDate",0.3d,true,
                            (obj, val)->{((Employer)obj).setStartingRateDate((LocalDate) val); }
                    )
            );



    }

}
