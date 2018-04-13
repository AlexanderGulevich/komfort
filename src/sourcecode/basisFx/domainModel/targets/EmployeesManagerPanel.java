package basisFx.domainModel.targets;

import basisFx.appCore.controlPolicy.ColumnWrapper;
import basisFx.appCore.domainScetch.StringValueDomainObject;
import basisFx.appCore.elements.AppNode;
import basisFx.appCore.elements.TableViewWrapper;
import basisFx.appCore.panels.Target;
import basisFx.appCore.utils.Coordinate;
import basisFx.domainModel.pojo.Employer;
import basisFx.domainModel.pojo.RatePerHour;
import basisFx.domainModel.settings.CSSID;
import basisFx.domainModel.settings.FontsStore;
import javafx.geometry.Pos;
import javafx.scene.layout.AnchorPane;

import java.time.LocalDate;

public class EmployeesManagerPanel extends Target {
    private TableViewWrapper employerTable;
    private TableViewWrapper rateTable;
    private AnchorPane employerSide;
    private AnchorPane rateSide;

    @Override
    protected void createElement() {


        employerSide=innerPanelsFabric.createInnerPanels(panel,0.54d,new Coordinate(0d,null,0d,0d));

        textFabric.createLabel("Сотрудники", FontsStore.ROBOTO_LIGHT,  Pos.BASELINE_CENTER,25d,
                employerSide, new Coordinate(10d,0d,null,0d));


        employerTable =tableFabric.createStandartTable(
                panel,0.54d,new Coordinate(50d, null, 70d, 0d),
                dataMapperFabric.getEmployeesActualRateDataMapper(),
                columnFabric.createStringColumn("ФИО","stringValue",1d,
                        (obj,val)->{((Employer)obj).setStringValue((String)val);})
        );

        buttonFactory.createStandartAddButton(
                employerSide,new Coordinate(null,0d, 10d, null), employerTable,Employer.class);
        buttonFactory.createStandartDeleteButton(
                employerSide,new Coordinate(null,180d, 10d, null), employerTable);


///////////////////////////////////////////////////

        rateSide=innerPanelsFabric.createInnerPanels(panel,0.45,new Coordinate(0d,0d,0d,null));


        textFabric.createLabel("Реестр тарифных ставок ", FontsStore.ROBOTO_LIGHT,  Pos.BASELINE_CENTER,25d,
                rateSide, new Coordinate(10d,0d,null,0d));


        rateTable =tableFabric.createStandartTable(
                panel,0.45d,new Coordinate(50d, 0d, 70d, null),
                dataMapperFabric.getEmployeesActualRateDataMapper(),

                columnFabric.createColumnStringComboBox("Тариф","rate",0.3d,
                        (obj,val)->{((Employer)obj).setRate((StringValueDomainObject) val);},
                        () -> dataMapperFabric.getEmployeesActualRateDataMapper().getRateTemplateList()
                ),
                columnFabric.createLocalDateColumn(ColumnWrapper.Bulder.create()
                        .setColumnName("Дата начала действия тарифа") .setPropertyName("startingRateDate").setColumnSize(0.7d)
                        .setDomainChangeAction((obj,val)->{((Employer)obj).setStartingRateDate((LocalDate) val); } )
                )
        );




        buttonFactory.createStandartAddButton(
                rateSide,new Coordinate(null,0d, 10d, null), rateTable,RatePerHour.class);
        buttonFactory.createStandartDeleteButton(
                rateSide,new Coordinate(null,180d, 10d, null), rateTable);





    }



}
