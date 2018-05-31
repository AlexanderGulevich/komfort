package basisFx.domainModel.targets;

import basisFx.appCore.KindOfSubmitElement;
import basisFx.appCore.controls.GridTable;
import basisFx.appCore.elements.DatePickerWrapper;
import basisFx.appCore.controls.KindOfColumn;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.grid.GridTablesBuilder;
import basisFx.appCore.grid.TablesButtonKind;
import basisFx.appCore.panels.Target;
import basisFx.appCore.utils.Coordinate;
import basisFx.domainModel.domaine.Employer;
import basisFx.appCore.settings.FontsStore;
import basisFx.domainModel.domaine.Equipment;
import javafx.geometry.Pos;
import javafx.scene.layout.AnchorPane;

public class TimeRecordingPanel extends Target {

    private TableWrapper employerTable;
    private AnchorPane employerSide;
    private AnchorPane controlSide;
    private DatePickerWrapper datePickerWrapper;

    @Override
    protected void configurate() {


        GridTablesBuilder tr=new GridTablesBuilder();
        tr.setTitle("Учет рабочего времени  ");
        tr.setTablesButtonKind(TablesButtonKind.No_buttons);
        tr.setDomainClass(Employer.class);
        tr.setDataMapper(dataMapperFabric.employerMapper());
        tr.setCoordinate(new Coordinate(30d, 10d, 10d, 10d));
        tr.setPanel(panel);
        tr.setColumn(columnFabric.stringColumn(KindOfColumn.STRING,"ФИО ","name",0.3d,true,
                (obj,val)->((Employer)obj).setName((String)val))
        );
//        tr.setColumn(columnFabric.stringColumn(KindOfColumn.COMBOBOX,"Тариф ","rate",0.1d,false,
//                null,()->dataMapperFabric.employeesRateMapper().)
//        );



        GridTable gridTable = gridFabric.singleGridTable(tr);




        employerTable =tableFabric.submitTable(KindOfSubmitElement.SubmitTable,
                employerSide,1.0d,new Coordinate(50d, 0d, 20d, 0d),
                dataMapperFabric.employerMapper(),

                columnFabric.stringColumn(KindOfColumn.STRING,"ФИО","name",0.3d,true,
                        (obj,val)->{((Employer)obj).setName((String)val);})
        );


        datePickerWrapper=vidgetFactory.datePickerWrapper(
                controlSide,170d, new Coordinate(10d,10d, null, null),employerTable.getList());



    }
}
