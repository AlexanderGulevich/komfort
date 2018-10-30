//package basisFx.presentation.targets;
//
//import basisFx.appCore.controls.KindOfColumn;
//import basisFx.appCore.domainScetch.ComboBoxValue;
//import basisFx.appCore.grid.*;
//import basisFx.appCore.utils.Coordinate;
//import basisFx.domain.domaine.*;
//
//import java.time.LocalDate;
//
//public class SleevePanel  extends TargetPanel {
//
//
//    @Override
//    protected void configurate() {
//        GridTablesBuilder observed=new GridTablesBuilder();
//        observed.setGridColWidth(new GridColWidth(KindOfGridCol.percent,60d));
//        observed.setTitle("Втулка ");
//        observed.setTablesButtonKind(TablesButtonKind.Bottom_right);
//        observed.setDomainClass(Sleeve.class);
//        observed.setActiveRecord(dataMapperFabric.sleeveMapper());
//        observed.setColumnWidthByContent(
//                columnFabric.comboBox(KindOfColumn.COMBOBOX,"Поставщик ","counterparty",1d,true,
//                        (obj,val)->((Sleeve)obj).setCounterparty((ComboBoxValue) val),
//                        () ->  dataMapperFabric.counterpartyMapper().toComboBoxValueList((val)->{return ((Counterparty)val).getName();})
//                ));
//
//
//
//        GridTablesBuilder observer=new GridTablesBuilder();
//        observer.setGridColWidth(new GridColWidth(KindOfGridCol.percent,40d));
//        observer.setTitle("Архив цен");
//        observer.setTablesButtonKind(TablesButtonKind.Bottom_right);
//        observer.setDomainClass(ProductPrice.class);
//        observer.setActiveRecord(dataMapperFabric.sleevePriceMapper());
//        observer.setColumnWidthByContent(  columnFabric.string(KindOfColumn.DOUBLE,"Цена","price",0.3d,true,
//                (obj,val)->{((ProductPrice)obj).setPrice( (String ) val);})
//        );
//        observer.setColumnWidthByContent(  columnFabric.dateColumn(KindOfColumn.DATE,"Дата начала действия ","startingDate",0.7d,true,
//                (obj, val)->{((ProductPrice)obj).setStartingDate((LocalDate) val); })
//        );
//
//
//        BoundTablesGrid boundTablesGrid = gridFabric.boundTables(
//                observed,
//                observer,
//                new Coordinate(10d, 10d, 10d, 10d),
//                panel
//        );
//
//    }
//}
