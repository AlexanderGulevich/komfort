//package basisFx.presentation.targets;
//
//import basisFx.appCore.grid.GridTable;
//import basisFx.appCore.controls.KindOfColumn;
//import basisFx.appCore.elements.TableWrapper;
//import basisFx.appCore.grid.GridTablesBuilder;
//import basisFx.appCore.grid.TablesButtonKind;
//import basisFx.appCore.utils.Coordinate;
//import basisFx.domain.domaine.RatePerHourTamplate;
//
//public class RatePerHourPanel extends TargetPanel {
//
//    private TableWrapper tableWrapper;
//
//    @Override
//    @SuppressWarnings("unchecked")
//    public void configurate() {
//
//        GridTablesBuilder tr=new GridTablesBuilder();
//        tr.setTitle("Шаблоны тарифных ставок ");
//        tr.setTablesButtonKind(TablesButtonKind.Right);
//        tr.setDomainClass(RatePerHourTamplate.class);
//        tr.setActiveRecord(dataMapperFabric.ratePerHourTemplatesMapper());
//        tr.setCoordinate(new Coordinate(10d, 10d, 10d, 10d));
//        tr.setPanel(panel);
//        tr.setColumn(columnFabric.string(KindOfColumn.DOUBLE,
//                "\"Тариф ( бел. руб/час. )\"","name",1d,true,
//                (obj,val)->((RatePerHourTamplate)obj).setName((String) val)
//                )
//        );
//
//        GridTable gridTable = gridFabric.singleGridTable(tr);
//
//    }
//
//}
