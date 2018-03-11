package basisFx.domainModel.targets;

import basisFx.appCore.controlPolicy.ColumnWrapper;
import basisFx.appCore.elements.AppNode;
import basisFx.appCore.elements.TableViewWrapper;
import basisFx.appCore.menu.Target;
import basisFx.domainModel.pojo.Counterparty;
import basisFx.domainModel.pojo.Equipment;
import basisFx.domainModel.settings.CSSID;
import basisFx.domainModel.settings.FontsStore;

/**
 *
 * @author Alek
 */
public class CounterpartyTargetPanel extends Target{
    
    private TableViewWrapper tableViewWrapper;

    
    @Override
    @SuppressWarnings("unchecked")
    public void createElement() {

        tableViewWrapper = AppNode.NodeBuilder.create()
                .setId(CSSID.TABLE).setCoordinate(panel,50d, null, 0d, 0d)
                .<Counterparty>createTableViewWrapper().setTablesSize(0.8, panel.widthProperty())
                .setDataMapper(this.dataMapperFabric.getCounterpartyDataMapper())
                .setDbTableName("Counterparty").refresh()
                .setColums(
                        columnFabric.createComboBoxColumn(ColumnWrapper.Bulder.create()
                                .setColumnName("Наименование")
//                                .setPropertyName("name")
//                                .setValueChecking(check.createTextCheck())
                                .setEditPoliticy(editFabric.<Counterparty,String>createEditCommitComboBox())
                                .setColumnSize(1.0)
//                                .setPojoChanging(
//                                        (obj,val)->{((Equipment)obj).setName((String)val);}
//                                )

                        )





                );



    }

   
    


}
