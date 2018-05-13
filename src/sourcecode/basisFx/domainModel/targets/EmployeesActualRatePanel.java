package basisFx.domainModel.targets;

import basisFx.appCore.controls.KindOfColumn;
import basisFx.appCore.domainScetch.ComboBoxValue;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.panels.Target;
import basisFx.appCore.utils.Coordinate;
import basisFx.domainModel.domaine.Employer;
import basisFx.appCore.settings.FontsStore;
import javafx.geometry.Pos;

import java.time.LocalDate;

public class EmployeesActualRatePanel extends Target{

    private TableWrapper tableWrapper;
    @Override
    protected void configurate() {


        textFabric.createLabel("Текущий список сотрудников и актуальных тарифных ставок ", FontsStore.ROBOTO_LIGHT,  Pos.BASELINE_CENTER,25d,
                panel, new Coordinate(10d,0d,null,0d));




        tableWrapper = tableFabric.table(
            panel,1d,new Coordinate(50d, null, 0d, 0d),
            dataMapperFabric.employerDataMapper(),
                    columnFabric.stringColumn(KindOfColumn.STRING,"ФИО","name",0.6d,true,
                            (obj,val)->((Employer)obj).setName((String)val))
,
                    columnFabric.comboBoxColumn(KindOfColumn.COMBOBOX,"Тариф","rate",0.1,true,
                            (obj,val)->{((Employer)obj).setRate((ComboBoxValue) val);},
                            () -> dataMapperFabric.employerDataMapper().getRateTemplateList()
                    ),
                    columnFabric.dateColumn(KindOfColumn.DATE,"Дата начала действия тарифа","startingRateDate",0.3d,true,
                            (obj, val)->{((Employer)obj).setStartingRateDate((LocalDate) val); }
                    )
            );



    }

}
