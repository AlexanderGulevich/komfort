package basisFx.domainModel.targets;

import basisFx.appCore.controlPolicy.ColumnWrapper;
import basisFx.appCore.domainScetch.StringValueDomainObject;
import basisFx.appCore.elements.TableViewWrapper;
import basisFx.appCore.panels.Target;
import basisFx.appCore.utils.Coordinate;
import basisFx.domainModel.domaine.Price;
import basisFx.domainModel.domaine.Product;
import basisFx.domainModel.settings.FontsStore;
import javafx.geometry.Pos;
import javafx.scene.layout.AnchorPane;

import java.time.LocalDate;

public class ProductPanel  extends Target{
    private TableViewWrapper productTable;
    private TableViewWrapper priceTable;
    private AnchorPane productSide;
    private AnchorPane priceSide;

    @Override
    protected void createElement() {

        priceSide =innerPanelsFabric.createInnerPanels(panel,0.38,new Coordinate(0d,0d,0d,null));



        textFabric.createLabel("Архив цен", FontsStore.ROBOTO_LIGHT,  Pos.BASELINE_CENTER,25d,
                priceSide, new Coordinate(10d,0d,null,0d));




        priceTable =tableFabric.createStandartTable(
                panel,0.38d,new Coordinate(50d, 0d, 70d, null),
                dataMapper.priceDataMapper(),

                        columnFabric.createStringColumn("Цена","price",0.3d,
                        (obj,val)->{((Price)obj).setPrice( (String ) val);}),

                        columnFabric.createLocalDateColumn(ColumnWrapper.Bulder.create()
                                .setColumnName("Дата начала действия ").setPropertyName("startingDate").setColumnSize(0.7d)
                                .setDomainChangeAction((obj,val)->{((Price)obj).setStartingDate((LocalDate) val); } )
                        )
                );


        buttonFactory.createStandartAddButton(
                priceSide,new Coordinate(null,0d, 10d, null), priceTable,Price.class);
        buttonFactory.createStandartDeleteButton(
                priceSide,new Coordinate(null,180d, 10d, null), priceTable);

////////////////////////////////////////////////////////

        productSide =innerPanelsFabric.createInnerPanels(panel,0.6d,new Coordinate(0d,null,0d,0d));


        textFabric.createLabel("Список продукции ", FontsStore.ROBOTO_LIGHT,  Pos.BASELINE_CENTER,25d,
                productSide, new Coordinate(10d,0d,null,0d));




        productTable =tableFabric.createBoundTable(
                priceTable, panel,
                0.6d, new Coordinate(50d, null, 70d, 0d),
                dataMapper.productDataMapper(),

                columnFabric.createStringColumn("Наименование","name",0.4d,
                        (obj,val)->((Product)obj).setName((String)val)),
                columnFabric.createColumnStringComboBox(
                        "Ширина стержня","rod",0.3d,
                        (obj,val)->{((Product)obj).setRod((StringValueDomainObject) val);},
                        () -> dataMapper.productDataMapper().getRodWidthList()
                ),
                columnFabric.createStringColumn("C 1 стержня, шт","numberFromRods",0.3d,
                        (obj,val)->((Product)obj).setNumberFromRods((String)val))

        );





        buttonFactory.createStandartAddButton(
                productSide,new Coordinate(null,0d, 10d, null), productTable,Product.class);
        buttonFactory.createStandartDeleteButton(
                productSide,new Coordinate(null,180d, 10d, null), productTable);


////////////////////////////////////////////////////












    }

}
