package basisFx.domainModel.targets;

import basisFx.appCore.controls.KindOfColumn;
import basisFx.appCore.domainScetch.BoolComboBox;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.grid.GridColWidth;
import basisFx.appCore.grid.GridTablesBuilder;
import basisFx.appCore.grid.KindOfGridCol;
import basisFx.appCore.grid.TablesButtonKind;
import basisFx.appCore.panels.Target;
import basisFx.appCore.utils.Coordinate;
import basisFx.domainModel.domaine.Price;
import basisFx.domainModel.domaine.Product;
import javafx.scene.layout.AnchorPane;

import java.time.LocalDate;

public class ProductPanel  extends Target{
    private TableWrapper productTable;
    private TableWrapper priceTable;
    private AnchorPane productSide;
    private AnchorPane priceSide;

    @Override
    protected void createElement() {

        GridTablesBuilder observed=new GridTablesBuilder();
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


        gridFabric.boundTables(
                observed,
                observer,
                new GridColWidth(KindOfGridCol.percent,60d),
                new GridColWidth(KindOfGridCol.percent,40d),
                new Coordinate(10d,10d,10d,10d),
                panel
        );

























    }

}
