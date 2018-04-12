package basisFx.domainModel.targets;

import basisFx.appCore.elements.TableViewWrapper;
import basisFx.appCore.panels.Target;
import basisFx.appCore.utils.Coordinate;
import basisFx.domainModel.pojo.Employer;
import javafx.scene.layout.AnchorPane;

public class EmployeesManagerPanel extends Target {
    private TableViewWrapper employerTable;
    private AnchorPane employerSide;
    private AnchorPane rateSide;

    @Override
    protected void createElement() {





        employerTable =tableFabric.createStandartTable(
                panel,0.4,new Coordinate(50d, null, 70d, 0d),
                dataMapperFabric.getEmployeesActualRateDataMapper(),
                columnFabric.createStringColumn("ФИО","stringValue",1d,
                        (obj,val)->{((Employer)obj).setStringValue((String)val);})
        );


        buttonFactory.createStandartAddButton(
                panel,new Coordinate(null,null, 10d, 200d), employerTable,Employer.class);
        buttonFactory.createStandartDeleteButton(
                panel,new Coordinate(null,null, 10d, 10d), employerTable);






    }



}
