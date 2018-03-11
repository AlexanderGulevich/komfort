/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.controlPolicy;

import basisFx.domainModel.pojo.Country;
import basisFx.domainModel.pojo.DomainObject;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;
import javafx.util.converter.DefaultStringConverter;
import javafx.util.converter.IntegerStringConverter;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author 62
 * @param <T>
 */
public class ComboBoxColumn<T,K> extends ColumnWrapper<T>{
    protected TableColumn<T,String> column;
//    protected PojoChanging<T,String> pojoChanging;

    private static Map<Integer,K> countryMap= new HashMap<>();

    @SuppressWarnings("unchecked")
    public ComboBoxColumn(Bulder builder) {

        super(builder);
        this.pojoChanging=builder.domainChangeAction;
        this.column =  new TableColumn<>(columnName);


        // By default, all cells are have null values
//        column.setCellValueFactory(
//                cellData -> new ReadOnlyStringWrapper(null)
//        );

        // By default, all cells are have null values
        column.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<T, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<T, String> param) {
                T pojo=param.getValue();
                return null;
            }
        });

        // Set a ComboBoxTableCell, so we can selects a value from a list
        column.setCellFactory(
                ComboBoxTableCell.<T, String>forTableColumn("Male", "Female"));



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
      

      public TableColumn<T,String>  getColumn(){
    
        return this.column;
    
    }



      
}
