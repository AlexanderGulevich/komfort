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
import javafx.scene.layout.AnchorPane;

import java.time.LocalDate;

public class EmployeesManagerPanel extends Target {
    private TableViewWrapper employerTable;
    private TableViewWrapper rateTable;
    private AnchorPane employerSide;
    private AnchorPane rateSide;

    @Override
    protected void createElement() {


        employerSide=innerPanelsFabric.createInnerPanels(panel,0.5d,new Coordinate(0d,null,0d,0d));

        textFabric.createText("Сотрудники",
                FontsStore.ROBOTO_LIGHT,20d, employerSide,new Coordinate(40d,0d,null,30d));

        employerTable =tableFabric.createStandartTable(
                employerSide,0.5d,new Coordinate(80d, null, 70d, 0d),
                dataMapperFabric.getEmployeesActualRateDataMapper(),
                columnFabric.createStringColumn("ФИО","stringValue",1d,
                        (obj,val)->{((Employer)obj).setStringValue((String)val);})
        );
//
        buttonFactory.createStandartAddButton(
                panel,new Coordinate(null,0d, 10d, null), employerTable,Employer.class);
        buttonFactory.createStandartDeleteButton(
                panel,new Coordinate(null,null, 10d, 0d), employerTable);


///////////////////////////////////////////////////

        rateSide=innerPanelsFabric.createInnerPanels(panel,0.3,new Coordinate(0d,0d,0d,null));

        textFabric.createText("Реестр тарифных ставок ",
                FontsStore.ROBOTO_LIGHT,20d, rateSide,new Coordinate(40d,0d,null,0d));



        rateTable =tableFabric.createStandartTable(
                rateSide,0.4,new Coordinate(80d, 0d, 70d, null),
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
                rateSide,new Coordinate(null,null, 10d, 0d), rateTable);





    }



}
