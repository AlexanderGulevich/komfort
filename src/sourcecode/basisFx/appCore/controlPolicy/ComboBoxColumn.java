package basisFx.appCore.controlPolicy;

import basisFx.appCore.domainScetch.DomainObject;
import basisFx.appCore.domainScetch.NamedDomainObject;
import basisFx.domainModel.mapper.CounterpartyDataMapper;
import basisFx.domainModel.pojo.Country;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.util.StringConverter;

import java.util.*;

/**
 *
 * @author 62
 * @param <T>
 */
public class ComboBoxColumn<T,K> extends ColumnWrapper<T>{
    protected TableColumn<DomainObject, String> column;
//    protected PojoChanging<T,String> pojoChanging;



    @SuppressWarnings("unchecked")
    public ComboBoxColumn(Bulder builder) {

        super(builder);

//      this.pojoChanging=builder.domainChangeAction;

        this.column =  new TableColumn<>(columnName);

        Map<String, Country> countryMap = ((CounterpartyDataMapper) dataMapper).getCountryMapByName();
        ArrayList <Country> countries=new ArrayList<>();
        countries.addAll( countryMap.values());
        ObservableList<String> names = FXCollections.observableArrayList();
        for (String key : countryMap.keySet()) {
            names.add(key);
        }


        // By default, all cells are have null values
        column.setCellValueFactory((TableColumn.CellDataFeatures<DomainObject, String> param) -> {

            DomainObject domainObject=  param.getValue();

            StringProperty stringProperty=null;

            if (domainObject.getId() != null) {

                comboBoxCellValueInitLogic.init(domainObject,stringProperty);
            }

            return stringProperty;

        });

        // Set a ComboBoxTableCell, so we can selects a value from a list
        column.setCellFactory(

                ComboBoxTableCell.<DomainObject, String>forTableColumn(names)

        );


    }
    
    
    
    public void initEditPoliticy(){

        for (Edit edit : editPoliticy) {
            edit.setColumn(this.column);
            edit.setPojoChanging(this.pojoChanging);
            edit.setUnitOfWork(this.tableWrapper.getUnitOfWork());
            edit.setTvw(this.tableWrapper);
            edit.run();
            
        }
          
          
    }
      

      public TableColumn<DomainObject, String> getColumn(){
    
        return this.column;
    
    }



      
}
