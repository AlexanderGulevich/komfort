//package basisFx.presentation.targets;
//
//import basisFx.appCore.controls.*;
//import basisFx.appCore.domainScetch.ComboBoxValue;
//import basisFx.appCore.grid.GridTablesBuilder;
//import basisFx.appCore.elements.TableWrapper;
//import basisFx.appCore.grid.TablesButtonKind;
//import basisFx.appCore.utils.Coordinate;
//import basisFx.domain.domaine.Counterparty;
//import basisFx.domain.domaine.Currency;
//
///**
// *
// * @author Alek
// */
//public class CounterpartyPanel extends DynamicElements{
//
//    private TableWrapper tableWrapper;
//
//
//    @Override
//    @SuppressWarnings("unchecked")
//    public void configurate() {
//
//        GridTablesBuilder tr=new GridTablesBuilder();
//        tr.setTitle("Контрагенты");
//        tr.setTablesButtonKind(TablesButtonKind.Bottom_right);
//        tr.setDomainClass(Counterparty.class);
//        tr.setActiveRecord(dataMapperFabric.counterpartyMapper());
//        tr.setCoordinate(new Coordinate(10d, 10d, 10d, 10d));
//        tr.setPanel(panel);
//        tr.setColumn(
//                columnFabric.string(KindOfColumn.STRING, "Наименование", "name", 0.6d, true,
//                (obj,val)->((Counterparty)obj).setName((String)val))
//        );
//        tr.setColumn(
//                columnFabric.comboBox(KindOfColumn.COMBOBOX,"Валюта ","currency",0.4d,true,
//                        (obj,val)->((Counterparty)obj).setCurrency((ComboBoxValue)val),
//                        () -> dataMapperFabric.currencyMapper().toComboBoxValueList((val)->{return ((Currency)val).getName();})
//                ));
//
//
//
//
//
//        GridTable gridTable = gridFabric.singleGridTable(tr);
//
//    }
//
//
//
//
//
//}
