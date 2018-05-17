package basisFx.domainModel.targets;

import basisFx.appCore.controls.KindOfColumn;
import basisFx.appCore.domainScetch.ComboBoxValue;
import basisFx.appCore.grid.*;
import basisFx.appCore.panels.Target;
import basisFx.appCore.utils.Coordinate;
import basisFx.domainModel.domaine.*;

import java.time.LocalDate;

public class SleevePanel  extends Target {


    @Override
    protected void configurate() {
        GridTablesBuilder observed=new GridTablesBuilder();
        observed.setGridColWidth(new GridColWidth(KindOfGridCol.percent,60d));
        observed.setTitle("Втулка ");
        observed.setTablesButtonKind(TablesButtonKind.Bottom_right);
        observed.setDomainClass(Sleeve.class);
        observed.setDataMapper(dataMapperFabric.sleeveMapper());
        observed.setColumn(
                columnFabric.comboBoxColumn(KindOfColumn.COMBOBOX,"Поставщик ","counterparty",1d,true,
                        (obj,val)->((Sleeve)obj).setCounterparty((ComboBoxValue) val),
                        () ->  dataMapperFabric.counterpartyMapper().toComboBoxValueList((val)->{return ((Counterparty)val).getName();})
                ));



        GridTablesBuilder observer=new GridTablesBuilder();
        observer.setGridColWidth(new GridColWidth(KindOfGridCol.percent,40d));
        observer.setTitle("Архив цен");
        observer.setTablesButtonKind(TablesButtonKind.Bottom_right);
        observer.setDomainClass(Price.class);
        observer.setDataMapper(dataMapperFabric.paperPriceMapper());
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

    }
}
