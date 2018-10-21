//package basisFx.presentation.targets;
//
//import basisFx.appCore.grid.GridTable;
//import basisFx.appCore.controls.KindOfColumn;
//import basisFx.appCore.elements.TableWrapper;
//import basisFx.appCore.grid.GridTablesBuilder;
//import basisFx.appCore.grid.TablesButtonKind;
//import basisFx.appCore.utils.Coordinate;
//import basisFx.domain.domaine.Employer;
//
//import java.time.LocalDate;
//
//public class EmployeesActualRatePanel extends TargetPanel{
//
//    private static EmployeesActualRatePanel ourInstance = new EmployeesActualRatePanel();
//
//    public static EmployeesActualRatePanel getInstance() {
//        return ourInstance;
//    }
//
//
//    private TableWrapper tableWrapper;
//    @Override
//    protected void configurate() {
//
//        GridTablesBuilder tr=new GridTablesBuilder();
//        tr.setTitle("Текущий список сотрудников и актуальных тарифных ставок");
//        tr.setTablesButtonKind(TablesButtonKind.No_buttons);
//        tr.setDomainClass(null);
//        tr.setActiveRecord(dataMapperFabric.employeesActualRateMapper());
//        tr.setCoordinate(new Coordinate(10d, 10d, 10d, 10d));
//        tr.setPanel(panel);
//        tr.setColumnWidthByContent(columnFabric.string(KindOfColumn.STRING,"ФИО","name",0.6d,false,
//                        (obj,val)->((Employer)obj).setName((String)val)));
//        tr.setColumnWidthByContent(columnFabric.comboBox(KindOfColumn.COMBOBOX,"Тариф","rate",0.1,false,
//                        null,null));
//        tr.setColumnWidthByContent(columnFabric.dateColumn(KindOfColumn.DATE,"Дата начала действия тарифа","startingRateDate",0.3d,false,
//                        (obj, val)->{((Employer)obj).setStartingRateDate((LocalDate) val); }));
//
//        GridTable gridTable = gridFabric.singleGridTable(tr);
//
//    }
//
//
//
//
//
//
//
//}
