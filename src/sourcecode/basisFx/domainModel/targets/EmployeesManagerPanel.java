package basisFx.domainModel.targets;

import basisFx.appCore.controls.KindOfColumn;
import basisFx.appCore.domainScetch.ComboBoxStringValue;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.panels.Target;
import basisFx.appCore.utils.Coordinate;
import basisFx.domainModel.domaine.Employer;
import basisFx.domainModel.domaine.RatePerHour;
import basisFx.appCore.settings.FontsStore;
import javafx.geometry.Pos;
import javafx.scene.layout.AnchorPane;

import java.time.LocalDate;

public class EmployeesManagerPanel extends Target {
    private TableWrapper employerTable;
    private TableWrapper rateTable;
    private AnchorPane employerSide;
    private AnchorPane rateSide;

    @Override
    protected void createElement() {

        rateSide=innerPanelsFabric.createInnerPanels(panel,0.45,new Coordinate(0d,0d,0d,null));


        textFabric.createLabel("Реестр тарифных ставок ", FontsStore.ROBOTO_LIGHT,  Pos.BASELINE_CENTER,25d,
                rateSide, new Coordinate(10d,0d,null,0d));


        rateTable =tableFabric.table(
                panel,0.45d,new Coordinate(50d, 0d, 70d, null),
                dataMapper.ratePerHourDataMapper(),

                columnFabric.comboBoxColumn(KindOfColumn.INT,"Тариф","rate",0.3d,true,
                        (obj,val)->{((RatePerHour)obj).setRate((ComboBoxStringValue) val);},
                        () -> dataMapper.employerDataMapper().getRateTemplateList()
                ),
                columnFabric.dateColumn(KindOfColumn.DATE,"Дата начала действия тарифа","startingRateDate",0.7d,true,
                        (obj, val)->{((RatePerHour)obj).setStartingRateDate((LocalDate) val); }
                )
        );

//////////////////////////////////////////////////////////////////


        buttonFactory.addRowButton(
                rateSide,new Coordinate(null,0d, 10d, null), rateTable,RatePerHour.class);
        buttonFactory.deleteRowButton(
                rateSide,new Coordinate(null,180d, 10d, null), rateTable);





        employerSide=innerPanelsFabric.createInnerPanels(panel,0.54d,new Coordinate(0d,null,0d,0d));

        textFabric.createLabel("Текущий список сотрудников", FontsStore.ROBOTO_LIGHT,  Pos.BASELINE_CENTER,25d,
                employerSide, new Coordinate(10d,0d,null,0d));


        employerTable =tableFabric.observedTable(
                rateTable,
                panel,0.54d,new Coordinate(50d, null, 70d, 0d),
                dataMapper.employerDataMapper(),
                columnFabric.stringColumn(KindOfColumn.STRING,"ФИО","name",1d,true,
                        (obj,val)->{((Employer)obj).setName((String)val);})
        );

        buttonFactory.addRowButton(
                panel,new Coordinate(null,0d, 10d, null), employerTable,Employer.class);
        buttonFactory.deleteRowButton(
                panel,new Coordinate(null,180d, 10d, null), employerTable);


///////////////////////////////////////////////////




    }



}
