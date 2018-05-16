package basisFx.domainModel.targets;

import basisFx.appCore.controls.KindOfColumn;
import basisFx.appCore.domainScetch.BoolComboBox;
import basisFx.appCore.domainScetch.ComboBoxValue;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.grid.GridColWidth;
import basisFx.appCore.grid.GridTablesBuilder;
import basisFx.appCore.grid.KindOfGridCol;
import basisFx.appCore.grid.TablesButtonKind;
import basisFx.appCore.panels.Target;
import basisFx.appCore.utils.Coordinate;
import basisFx.domainModel.domaine.Employer;
import basisFx.domainModel.domaine.Price;
import basisFx.domainModel.domaine.Product;
import basisFx.domainModel.domaine.RatePerHour;
import basisFx.appCore.settings.FontsStore;
import javafx.geometry.Pos;
import javafx.scene.layout.AnchorPane;

import java.time.LocalDate;

public class EmployeesManagerPanel extends Target {
    private TableWrapper employerTable;
    private TableWrapper rateTable;
    private AnchorPane employerSide;
    private AnchorPane rateSide;

    @Override
    protected void configurate() {


        GridTablesBuilder observed=new GridTablesBuilder();
        observed.setGridColWidth(new GridColWidth(KindOfGridCol.percent,60d));
        observed.setTitle("Текущий список сотрудников ");
        observed.setTablesButtonKind(TablesButtonKind.Bottom_right);
        observed.setDomainClass(Employer.class);
        observed.setDataMapper(dataMapperFabric.employerDataMapper());
        observed.setColumn(
                columnFabric.stringColumn(KindOfColumn.STRING,"ФИО","name",1d,true,
                        (obj,val)->{((Employer)obj).setName((String)val);})
        );




        GridTablesBuilder observer=new GridTablesBuilder();
        observer.setGridColWidth(new GridColWidth(KindOfGridCol.percent,40d));
        observer.setTitle("Реестр тарифных ставок ");
        observer.setTablesButtonKind(TablesButtonKind.Bottom_right);
        observer.setDomainClass(RatePerHour.class);
        observer.setDataMapper(dataMapperFabric.ratePerHourDataMapper());
        observer.setColumn(
                columnFabric.comboBoxColumn(KindOfColumn.INT,"Тариф","rate",0.3d,true,
                (obj,val)->{((RatePerHour)obj).setRate((ComboBoxValue) val);},
                () -> dataMapperFabric.employerDataMapper().getRateTemplateList()
                )
        );
        observer.setColumn( columnFabric.dateColumn(KindOfColumn.DATE,"Дата начала действия тарифа","startingRateDate",0.7d,true,
                (obj, val)->{((RatePerHour)obj).setStartingRateDate((LocalDate) val); })
        );


        gridFabric.boundTables(
                observed,
                observer,
                new Coordinate(10d,10d,10d,10d),
                panel
        );







    }



}
