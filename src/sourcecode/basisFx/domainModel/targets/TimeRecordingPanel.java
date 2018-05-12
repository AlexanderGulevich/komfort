package basisFx.domainModel.targets;

import basisFx.appCore.KindOfSubmitElement;
import basisFx.appCore.elements.DatePickerWrapper;
import basisFx.appCore.controls.KindOfColumn;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.panels.Target;
import basisFx.appCore.utils.Coordinate;
import basisFx.domainModel.domaine.Employer;
import basisFx.appCore.settings.FontsStore;
import javafx.geometry.Pos;
import javafx.scene.layout.AnchorPane;

public class TimeRecordingPanel extends Target {

    private TableWrapper employerTable;
    private AnchorPane employerSide;
    private AnchorPane controlSide;
    private DatePickerWrapper datePickerWrapper;

    @Override
    protected void configurate() {

        employerSide=innerPanelsFabric.createInnerPanels(panel,0.78d,new Coordinate(0d,null,0d,0d));
        controlSide=innerPanelsFabric.createInnerPanels(panel,0.2d,new Coordinate(0d,0d,0d,null));

        textFabric.createLabel("Список сотрудников", FontsStore.ROBOTO_LIGHT,  Pos.BASELINE_LEFT,25d,
                employerSide, new Coordinate(10d,0d,null,0d));

        employerTable =tableFabric.submitTable(KindOfSubmitElement.SubmitTable,
                employerSide,1.0d,new Coordinate(50d, 0d, 20d, 0d),
                dataMapper.employerDataMapper(),

                columnFabric.stringColumn(KindOfColumn.STRING,"ФИО","name",0.3d,true,
                        (obj,val)->{((Employer)obj).setName((String)val);})
        );


        datePickerWrapper=vidgetFactory.datePickerWrapper(
                controlSide,170d, new Coordinate(10d,10d, null, null),employerTable.getList());


        buttonFactory.submitButton(KindOfSubmitElement.SubmitDatePicker,
                controlSide,new Coordinate(80d,10d, null, null), employerTable,datePickerWrapper);




    }
}
