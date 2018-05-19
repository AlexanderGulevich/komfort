package basisFx.domainModel.targets;

import basisFx.appCore.controls.KindOfColumn;
import basisFx.appCore.domainScetch.ComboBoxValue;
import basisFx.appCore.grid.*;
import basisFx.appCore.panels.Target;
import basisFx.appCore.utils.Coordinate;
import basisFx.domainModel.domaine.*;

import java.time.LocalDate;

public class PacketPanel  extends Target {


    @Override
    protected void configurate() {
        GridTablesBuilder observed=new GridTablesBuilder();
        observed.setGridColWidth(new GridColWidth(KindOfGridCol.percent,60d));
        observed.setTitle("Пакеты ");
        observed.setTablesButtonKind(TablesButtonKind.Right_little);
        observed.setDomainClass(Packet.class);
        observed.setDataMapper(dataMapperFabric.packetMapper());
        observed.setColumn(
                columnFabric.comboBoxColumn(KindOfColumn.COMBOBOX,"Размер ","size",0.5d,true,
                        (obj,val)->((Packet)obj).setSize((ComboBoxValue) val),
                        () ->  dataMapperFabric.packetSizeMapper().toComboBoxValueList((val)->{return ((PacketSize)val).getSize();})
                ));
        observed.setColumn(
                columnFabric.comboBoxColumn(KindOfColumn.COMBOBOX,"Поставщик ","counterparty",0.5d,true,
                        (obj,val)->((Packet)obj).setCounterparty((ComboBoxValue) val),
                        () ->  dataMapperFabric.counterpartyMapper().toComboBoxValueList((val)->{return ((Counterparty)val).getName();})
                ));



        GridTablesBuilder observer=new GridTablesBuilder();
        observer.setGridColWidth(new GridColWidth(KindOfGridCol.percent,40d));
        observer.setTitle("Архив цен");
        observer.setTablesButtonKind(TablesButtonKind.Right_little);
        observer.setDomainClass(Price.class);
        observer.setDataMapper(dataMapperFabric.packetPriceMapper());
        observer.setColumn(  columnFabric.stringColumn(KindOfColumn.DOUBLE,"Цена","price",0.3d,true,
                (obj,val)->{((Price)obj).setPrice( (String ) val);})
        );
        observer.setColumn(  columnFabric.dateColumn(KindOfColumn.DATE,"Дата начала действия ","startingDate",0.7d,true,
                (obj, val)->{((Price)obj).setStartingDate((LocalDate) val); })
        );


        BoundTablesGrid boundTablesGrid = gridFabric.boundTables(
                observed,
                observer,
                new Coordinate(10d, 10d, 10d, 10d),
                panel
        );




        GridTablesBuilder packetSize=new GridTablesBuilder();
        packetSize.setTitle("Размеры пакетов ");
        packetSize.setTablesButtonKind(TablesButtonKind.Right_little);
        packetSize.setDomainClass(PacketSize.class);
        packetSize.setGridColWidth(new GridColWidth(KindOfGridCol.percent,40));
        packetSize.setDataMapper(dataMapperFabric.packetSizeMapper());
        packetSize.setColumn(columnFabric.stringColumn(KindOfColumn.STRING,"Размер ","size",1d,true,
                (obj,val)->((PacketSize)obj).setSize((String)val))
        );




        GridTablesBuilder packetSizeProductAccordance=new GridTablesBuilder();
        packetSizeProductAccordance.setTitle("Вместимость пакетов ");
        packetSizeProductAccordance.setTablesButtonKind(TablesButtonKind.Right_little);
        packetSizeProductAccordance.setDomainClass(PacketProductAccordance.class);
        packetSizeProductAccordance.setGridColWidth(new GridColWidth(KindOfGridCol.percent,60d));
        packetSizeProductAccordance.setDataMapper(dataMapperFabric.packetProductAccordanceMapper());
        packetSizeProductAccordance.setColumn(
                columnFabric.comboBoxColumn(KindOfColumn.COMBOBOX,"Размер ","size",0.3d,true,
                        (obj,val)->((PacketProductAccordance)obj).setSize((ComboBoxValue) val),
                         () ->  dataMapperFabric.packetSizeMapper().toComboBoxValueList((val)->{return ((PacketSize)val).getSize();})
                ));
        packetSizeProductAccordance.setColumn(
                columnFabric.comboBoxColumn(KindOfColumn.COMBOBOX,"Продукция ","product",0.5d,true,
                        (obj,val)->((PacketProductAccordance)obj).setProduct((ComboBoxValue)val),
                        () -> dataMapperFabric.productMapper().toComboBoxValueList((val)->{return ((Product)val).getName();})
                ));
        packetSizeProductAccordance.setColumn(
                columnFabric.stringColumn(KindOfColumn.INT,"Кол-во ","number",0.2d,true,
                        (obj,val)->((PacketProductAccordance)obj).setNumber((String)val))
        );



        gridFabric.boundWithSecondRaw(
                boundTablesGrid,0.6d,0.4d,
                panel,      packetSizeProductAccordance,packetSize

        );






    }

}