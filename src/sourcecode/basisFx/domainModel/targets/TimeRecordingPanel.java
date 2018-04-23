package basisFx.domainModel.targets;

import basisFx.appCore.controlPolicy.ColumnWrapper;
import basisFx.appCore.domainScetch.StringValueDomainObject;
import basisFx.appCore.elements.TableViewWrapper;
import basisFx.appCore.panels.Target;
import basisFx.appCore.utils.Coordinate;
import basisFx.domainModel.domaine.Employer;
import basisFx.domainModel.domaine.RatePerHour;
import basisFx.domainModel.settings.FontsStore;
import javafx.geometry.Pos;
import javafx.scene.layout.AnchorPane;

import java.time.LocalDate;

public class TimeRecordingPanel extends Target {

    private TableViewWrapper employerTable;
    private AnchorPane employerSide;
    private AnchorPane controlSide;

    @Override
    protected void createElement() {

        employerSide=innerPanelsFabric.createInnerPanels(panel,0.78d,new Coordinate(0d,null,0d,0d));
        controlSide=innerPanelsFabric.createInnerPanels(panel,0.2d,new Coordinate(0d,0d,0d,null));



        textFabric.createLabel("Список сотрудников", FontsStore.ROBOTO_LIGHT,  Pos.BASELINE_LEFT,25d,
                employerSide, new Coordinate(10d,0d,null,0d));

        employerTable =tableFabric.createStandartTable(
                employerSide,1.0d,new Coordinate(50d, 0d, 20d, 0d),
                dataMapper.employerDataMapper(),
                columnFabric.createNotEditableStringColumn("ФИО","stringValue",0.7d,
                        (obj,val)->{((Employer)obj).setStringValue((String)val);}),
                columnFabric.createStringColumn("ФИО","stringValue",0.3d,
                        (obj,val)->{((Employer)obj).setStringValue((String)val);})
        );



        buttonFactory.createSubmitButton(
                controlSide,new Coordinate(80d,10d, null, null), employerTable);

        vidgetFactory.datePickerWrapper(controlSide,170d, new Coordinate(10d,10d, null, null),employerTable.getList());




    }
}
