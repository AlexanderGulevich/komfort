package basisFx.domainModel.targets;

import basisFx.appCore.controlPolicy.ColumnWrapper;
import basisFx.appCore.domainScetch.NamedDomainObject;
import basisFx.appCore.elements.AppNode;
import basisFx.appCore.elements.TableViewWrapper;
import basisFx.appCore.panels.Target;
import basisFx.domainModel.mapper.CounterpartyDataMapper;
import basisFx.domainModel.pojo.Counterparty;
import basisFx.domainModel.pojo.Country;
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
                        columnFabric.<Counterparty,String>createTextColumn(ColumnWrapper.Bulder.create()
                                .setColumnName("Наименование контрагента")
                                .setPropertyName("name")
                                .setValueChecking(check.createTextCheck())
                                .setEditPoliticy(editFabric.<Counterparty,String>createEditCommitDefault())
                                .setColumnSize(0.6)
                                .setDomainObjectChanging(
                                        (obj,val)->{((Counterparty)obj).setName((String)val);}
                                )
                        ),
                        columnFabric.createComboBoxColumn(ColumnWrapper.Bulder.create()
                                .setColumnName("Страна").setColumnSize(0.4)
                                .setEditPoliticy(editFabric.<Counterparty,String>createEditCommitComboBox())
                                .setDataMapper(this.dataMapperFabric.getCounterpartyDataMapper())
                                .setComboBoxCellValueInitLogic((domainObject,objectProperty)->{
                                    Counterparty domain=(Counterparty)domainObject;
                                    objectProperty=domain.countryProperty();

                                        }
                                )
                        )





                );



        AppNode.NodeBuilder.create()
                .setId(CSSID.PANELS_BUTTON)
                .setCoordinate(panel, 80d,0d, null, null)
                .setText("ДОБАВИТЬ").setFont(FontsStore.ROBOTO_LIGHT, 15)
                .setWidth(170d).setHeight(20d)
                .setEvent(eventFactory.
                        createRowAdd(
                                tableViewWrapper,
                                (l)->{l.add(new Counterparty());}))
                .createNButton();

        AppNode.NodeBuilder.create()
                .setId(CSSID.PANELS_BUTTON)
                .setCoordinate(panel, 120d,0d, null, null)
                .setText("УДАЛИТЬ").setFont(FontsStore.ROBOTO_LIGHT, 15)
                .setWidth(170d).setHeight(20d)
                .setEvent(eventFactory.createRowDeleteFromTable(tableViewWrapper))
                .createNButton();





    }

   
    


}
