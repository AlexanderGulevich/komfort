package basisFx.domainModel.targets;

import basisFx.appCore.controls.KindOfColumn;
import basisFx.appCore.domainScetch.ComboBoxValue;
import basisFx.appCore.grid.*;
import basisFx.appCore.panels.Target;
import basisFx.appCore.utils.Coordinate;
import basisFx.domainModel.domaine.Counterparty;
import basisFx.domainModel.domaine.Label;
import basisFx.domainModel.domaine.Price;

import java.time.LocalDate;

public class LabelPanel  extends Target {


    @Override
    protected void configurate() {

        GridTablesBuilder observed=new GridTablesBuilder();
        observed.setGridColWidth(new GridColWidth(KindOfGridCol.percent,60d));
        observed.setTitle("Этикетки ");
        observed.setTablesButtonKind(TablesButtonKind.Bottom_right);
        observed.setDomainClass(Label.class);
        observed.setDataMapper(dataMapperFabric.labelMapper());
        observed.setColumn(columnFabric.string(KindOfColumn.STRING,"Наименование","name",0.5d,true,
                (obj,val)->{((Label)obj).setName( (String ) val);})
        );
        observed.setColumn(
                columnFabric.comboBox(KindOfColumn.COMBOBOX,"Поставщик ","counterparty",0.5d,true,
                        (obj,val)->((Label)obj).setCounterparty((ComboBoxValue) val),
                        () ->  dataMapperFabric.counterpartyMapper().toComboBoxValueList((val)->{return ((Counterparty)val).getName();})
                ));



        GridTablesBuilder observer=new GridTablesBuilder();
        observer.setGridColWidth(new GridColWidth(KindOfGridCol.percent,40d));
        observer.setTitle("Архив цен");
        observer.setTablesButtonKind(TablesButtonKind.Bottom_right);
        observer.setDomainClass(Price.class);
        observer.setDataMapper(dataMapperFabric.labelPriceMapper());
        observer.setColumn(  columnFabric.string(KindOfColumn.DOUBLE,"Цена","price",0.3d,true,
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