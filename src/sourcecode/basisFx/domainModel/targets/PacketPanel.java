package basisFx.domainModel.targets;

import basisFx.appCore.controls.GridTable;
import basisFx.appCore.controls.KindOfColumn;
import basisFx.appCore.domainScetch.BoolComboBox;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.grid.*;
import basisFx.appCore.panels.Target;
import basisFx.appCore.utils.Coordinate;
import basisFx.domainModel.domaine.Equipment;
import basisFx.domainModel.domaine.Price;
import basisFx.domainModel.domaine.Product;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.time.LocalDate;

public class PacketPanel  extends Target {


    @Override
    protected void configurate() {
        GridTablesBuilder observed=new GridTablesBuilder();
        observed.setGridColWidth(new GridColWidth(KindOfGridCol.percent,60d));
        observed.setTitle("Список продукции ");
        observed.setTablesButtonKind(TablesButtonKind.Bottom_right);
        observed.setDomainClass(Product.class);
        observed.setDataMapper(dataMapper.productDataMapper());
        observed.setColumn(
                columnFabric.stringColumn(KindOfColumn.STRING,"Наименование","name",0.7d,true,
                        (obj,val)->((Product)obj).setName((String)val))
        );
        observed.setColumn(

                columnFabric.comboBoxColumn(KindOfColumn.COMBOBOX,
                        "Втулка","sleeve",0.3d,true,
                        (obj,val)->{((Product)obj).setSleeve((BoolComboBox) val);},
                        () -> BoolComboBox.comboBoxes
                )
        );



        GridTablesBuilder observer=new GridTablesBuilder();
        observer.setGridColWidth(new GridColWidth(KindOfGridCol.percent,40d));
        observer.setTitle("Архив цен");
        observer.setTablesButtonKind(TablesButtonKind.Bottom_right);
        observer.setDomainClass(Price.class);
        observer.setDataMapper(dataMapper.priceDataMapper());
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




        GridTablesBuilder tr=new GridTablesBuilder();
        tr.setTitle("Перечень станков ");
        tr.setTablesButtonKind(TablesButtonKind.Bottom_right);
        tr.setDomainClass(Equipment.class);
        tr.setGridColWidth(new GridColWidth(KindOfGridCol.percent,30));
        tr.setDataMapper(dataMapper.equipmentDataMapper());
        tr.setCoordinate(new Coordinate(10d, 10d, 10d, 10d));
        tr.setPanel(panel);
        tr.setColumn(columnFabric.stringColumn(KindOfColumn.STRING,"Наименование ","name",1d,true,
                (obj,val)->((Equipment)obj).setName((String)val))
        );








        gridFabric.boundWithSecondRaw(
                boundTablesGrid,
                0.3d,
                0.7d,
                panel,
                tr,
                tr

        );


    }
}