package basisFx.domainModel.targets;

import basisFx.appCore.controls.GridTable;
import basisFx.appCore.controls.KindOfColumn;
import basisFx.appCore.elements.AppNode;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.grid.GridTablesBuilder;
import basisFx.appCore.grid.TablesButtonKind;
import basisFx.appCore.panels.Target;
import basisFx.appCore.utils.Coordinate;
import basisFx.domainModel.domaine.Equipment;
import basisFx.domainModel.domaine.RatePerHour;
import basisFx.appCore.settings.CSSID;
import basisFx.appCore.settings.FontsStore;

public class RatePerHourPanel extends Target {

    private TableWrapper tableWrapper;

    @Override
    @SuppressWarnings("unchecked")
    public void configurate() {

        GridTablesBuilder tr=new GridTablesBuilder();
        tr.setTitle("Шаблоны тарифных ставок ");
        tr.setTablesButtonKind(TablesButtonKind.Right);
        tr.setDomainClass(RatePerHour.class);
        tr.setDataMapper(dataMapperFabric.ratePerHourTemplatesDataMapper());
        tr.setCoordinate(new Coordinate(10d, 10d, 10d, 10d));
        tr.setPanel(panel);
        tr.setColumn(columnFabric.stringColumn(KindOfColumn.DOUBLE,
                "\"Тариф ( бел. руб/час. )\"","name",1d,true,
                (obj,val)->((RatePerHour)obj).setName((String) val)
                )
        );

        GridTable gridTable = gridFabric.singleGridTable(tr);

    }

}
