package basisFx.domainModel.targets;

import basisFx.appCore.elements.TableViewWrapper;
import basisFx.appCore.panels.Target;
import basisFx.appCore.utils.Coordinate;
import basisFx.domainModel.pojo.Employer;
import basisFx.domainModel.settings.FontsStore;
import javafx.scene.layout.AnchorPane;

public class EmployeesManagerPanel extends Target {
    private TableViewWrapper employerTable;
    private AnchorPane employerSide;
    private AnchorPane rateSide;

    @Override
    protected void createElement() {


        employerSide=innerPanelsFabric.createInnerPanels(panel,0.4d,new Coordinate(0d,null,0d,0d));



//        textFabric.createText("11111111111111111111111",
//                FontsStore.ROBOTO_BOLD,20d, employerSide,new Coordinate(69d,0d,null,0d));

        employerTable =tableFabric.createStandartTable(
                employerSide,1,new Coordinate(100d, 0d, 70d, 0d),
                dataMapperFabric.getEmployeesActualRateDataMapper(),
                columnFabric.createStringColumn("ФИО","stringValue",1d,
                        (obj,val)->{((Employer)obj).setStringValue((String)val);})
        );

        buttonFactory.createStandartAddButton(
                employerSide,new Coordinate(null,0d, 10d, null), employerTable,Employer.class);
        buttonFactory.createStandartDeleteButton(
                employerSide,new Coordinate(null,null, 10d, 0d), employerTable);


///////////////////////////////////////////////////




        rateSide=innerPanelsFabric.createInnerPanels(panel,0.6,new Coordinate(0d,0d,0d,null));



    }



}
