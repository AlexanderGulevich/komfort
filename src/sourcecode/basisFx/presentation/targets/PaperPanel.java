//package basisFx.presentation.targets;
//
//import basisFx.appCore.controls.KindOfColumn;
//import basisFx.appCore.domainScetch.ComboBoxValue;
//import basisFx.appCore.grid.*;
//import basisFx.appCore.utils.Coordinate;
//import basisFx.domain.domaine.Counterparty;
//import basisFx.domain.domaine.Paper;
//import basisFx.domain.ProductPrice;
//
//import java.time.LocalDate;
//
//public class PaperPanel  extends TargetPanel {
//
//
//    @Override
//    protected void configurate() {
//
//        GridTablesBuilder observed=new GridTablesBuilder();
//        observed.setGridColWidth(new GridColWidth(KindOfGridCol.percent,60d));
//        observed.setTitle("Бумага ");
//        observed.setTablesButtonKind(TablesButtonKind.Bottom_right);
//        observed.setDomainClass(Paper.class);
//        observed.setActiveRecord(dataMapperFabric.paperMapper());
//        observed.setColumnWidthByContent(
//                columnFabric.comboBox(KindOfColumn.COMBOBOX,"Поставщик ","counterparty",1d,true,
//                        (obj,val)->((Paper)obj).setCounterparty((ComboBoxValue) val),
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
//        observer.setActiveRecord(dataMapperFabric.paperPriceMapper());
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
//
//
//
//
//    }
//
//}
