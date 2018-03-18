package basisFx.appCore.controlPolicy;

import basisFx.appCore.domainScetch.DomainObject;
import basisFx.appCore.domainScetch.NamedDataMapper;
import basisFx.appCore.domainScetch.NamedDomainObject;
import basisFx.domainModel.mapper.CounterpartyDataMapper;
import basisFx.domainModel.pojo.Country;
import javafx.beans.property.StringProperty;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.util.Callback;
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
//        this.pojoChanging=builder.domainChangeAction;
        this.column =  new TableColumn<>(columnName);

        Map<Integer, Country> countryMap = ((CounterpartyDataMapper) tableWrapper.getDataMapper()).getCountryMap();
        ArrayList <Country> countries=new ArrayList<>();
        countries.addAll((Collection<? extends Country>) countryMap);

        // By default, all cells are have null values
//        column.setCellValueFactory(
//                cellData -> new ReadOnlyStringWrapper(null)
//        );

        // By default, all cells are have null values
        column.setCellValueFactory((TableColumn.CellDataFeatures<DomainObject, String> param) -> {
            DomainObject domainObject=  param.getValue();

            StringProperty stringProperty=null;

            comboBoxCellValueInitLogic.init(domainObject,stringProperty);

            return stringProperty;

        });

        // Set a ComboBoxTableCell, so we can selects a value from a list
        column.setCellFactory(

//        (TableColumn<DomainObject, String> e) -> {
//
//
//                    ComboBox <NamedDataMapper>combobox =new ComboBox<>();
//
////                    combobox.setConverter();
//
//            Map<Integer, Country> countryMap = ((CounterpartyDataMapper) tableWrapper.getDataMapper()).getCountryMap();
//
//            ComboBoxTableCell<NamedDataMapper, String> comboBoxTableCell = new ComboBoxTableCell<>();
//
//
//
//
//            return  comboBoxTableCell;
//
//
//
//
//                }

                ComboBoxTableCell.<DomainObject, NamedDomainObject>forTableColumn(new Converter(),  countries )
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

    class Converter extends StringConverter<NamedDomainObject>{


        @Override
        public String toString(NamedDomainObject object) {
            return null;
        }

        @Override
        public NamedDomainObject fromString(String string) {
            return null;
        }
    }

      
}
