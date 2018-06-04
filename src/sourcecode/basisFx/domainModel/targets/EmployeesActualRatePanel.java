package basisFx.domainModel.targets;

import basisFx.appCore.controls.GridTable;
import basisFx.appCore.controls.KindOfColumn;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.grid.GridTablesBuilder;
import basisFx.appCore.grid.TablesButtonKind;
import basisFx.appCore.panels.Target;
import basisFx.appCore.utils.Coordinate;
import basisFx.domainModel.domaine.Employer;

import java.time.LocalDate;

public class EmployeesActualRatePanel extends Target{

    private static EmployeesActualRatePanel ourInstance = new EmployeesActualRatePanel();

    public static EmployeesActualRatePanel getInstance() {
        return ourInstance;
    }


    private TableWrapper tableWrapper;
    @Override
    protected void configurate() {

        GridTablesBuilder tr=new GridTablesBuilder();
        tr.setTitle("Текущий список сотрудников и актуальных тарифных ставок");
        tr.setTablesButtonKind(TablesButtonKind.No_buttons);
        tr.setDomainClass(null);
        tr.setDataMapper(dataMapperFabric.employeesActualRateMapper());
        tr.setCoordinate(new Coordinate(10d, 10d, 10d, 10d));
        tr.setPanel(panel);
        tr.setColumn(columnFabric.string(KindOfColumn.STRING,"ФИО","name",0.6d,false,
                        (obj,val)->((Employer)obj).setName((String)val)));
        tr.setColumn(columnFabric.comboBox(KindOfColumn.COMBOBOX,"Тариф","rate",0.1,false,
                        null,null));
        tr.setColumn(columnFabric.dateColumn(KindOfColumn.DATE,"Дата начала действия тарифа","startingRateDate",0.3d,false,
                        (obj, val)->{((Employer)obj).setStartingRateDate((LocalDate) val); }));

        GridTable gridTable = gridFabric.singleGridTable(tr);

    }







}
