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
//public class PacketPanel  extends TargetPanel {
//
//
//    @Override
//    protected void configurate() {
//        GridTablesBuilder observed=new GridTablesBuilder();
//        observed.setGridColWidth(new GridColWidth(KindOfGridCol.percent,60d));
//        observed.setTitle("Пакеты ");
//        observed.setTablesButtonKind(TablesButtonKind.Right_little);
//        observed.setDomainClass(Packet.class);
//        observed.setActiveRecord(dataMapperFabric.packetMapper());
//        observed.setColumnWidthByContent(
//                columnFabric.comboBox(KindOfColumn.COMBOBOX,"Размер ","size",0.5d,true,
//                        (obj,val)->((Packet)obj).setSize((ComboBoxValue) val),
//                        () ->  dataMapperFabric.packetSizeMapper().toComboBoxValueList((val)->{return ((PacketSize)val).getSize();})
//                ));
//        observed.setColumnWidthByContent(
//                columnFabric.comboBox(KindOfColumn.COMBOBOX,"Поставщик ","counterparty",0.5d,true,
//                        (obj,val)->((Packet)obj).setCounterparty((ComboBoxValue) val),
//                        () ->  dataMapperFabric.counterpartyMapper().toComboBoxValueList((val)->{return ((Counterparty)val).getName();})
//                ));
//
//
//
//        GridTablesBuilder observer=new GridTablesBuilder();
//        observer.setGridColWidth(new GridColWidth(KindOfGridCol.percent,40d));
//        observer.setTitle("Архив цен");
//        observer.setTablesButtonKind(TablesButtonKind.Right_little);
//        observer.setDomainClass(ProductPrice.class);
//        observer.setActiveRecord(dataMapperFabric.packetPriceMapper());
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
//        GridTablesBuilder packetSize=new GridTablesBuilder();
//        packetSize.setTitle("Размеры пакетов ");
//        packetSize.setTablesButtonKind(TablesButtonKind.Right_little);
//        packetSize.setDomainClass(PacketSize.class);
//        packetSize.setGridColWidth(new GridColWidth(KindOfGridCol.percent,40));
//        packetSize.setActiveRecord(dataMapperFabric.packetSizeMapper());
//        packetSize.setColumnWidthByContent(columnFabric.string(KindOfColumn.STRING,"Размер ","size",1d,true,
//                (obj,val)->((PacketSize)obj).setSize((String)val))
//        );
//
//
//
//
//        GridTablesBuilder packetSizeProductAccordance=new GridTablesBuilder();
//        packetSizeProductAccordance.setTitle("Вместимость пакетов ");
//        packetSizeProductAccordance.setTablesButtonKind(TablesButtonKind.Right_little);
//        packetSizeProductAccordance.setDomainClass(PacketProductAccordance.class);
//        packetSizeProductAccordance.setGridColWidth(new GridColWidth(KindOfGridCol.percent,60d));
//        packetSizeProductAccordance.setActiveRecord(dataMapperFabric.packetProductAccordanceMapper());
//        packetSizeProductAccordance.setColumnWidthByContent(
//                columnFabric.comboBox(KindOfColumn.COMBOBOX,"Размер ","size",0.3d,true,
//                        (obj,val)->((PacketProductAccordance)obj).setSize((ComboBoxValue) val),
//                         () ->  dataMapperFabric.packetSizeMapper().toComboBoxValueList((val)->{return ((PacketSize)val).getSize();})
//                ));
//        packetSizeProductAccordance.setColumnWidthByContent(
//                columnFabric.comboBox(KindOfColumn.COMBOBOX,"Продукция ","product",0.5d,true,
//                        (obj,val)->((PacketProductAccordance)obj).setProduct((ComboBoxValue)val),
//                        () -> dataMapperFabric.productMapper().toComboBoxValueList((val)->{return ((Product)val).getName();})
//                ));
//        packetSizeProductAccordance.setColumnWidthByContent(
//                columnFabric.string(KindOfColumn.INT,"Кол-во ","number",0.2d,true,
//                        (obj,val)->((PacketProductAccordance)obj).setNumber((String)val))
//        );
//
//
//
//        gridFabric.boundWithSecondRaw(
//                boundTablesGrid,0.6d,0.4d,
//                panel,      packetSizeProductAccordance,packetSize
//
//        );
//
//
//
//
//
//
//    }
//
//}