/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.controls;

import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

/**
 *
 * @author Alek
 * @param <T>
 */
public class ColumnString<T> extends ColumnWrapper<T>{
    protected TableColumn<T,String> column;

    @SuppressWarnings("unchecked")
    public ColumnString(ColumnWrapper.Bulder builder) {

        super(builder);

        this.column =  new TableColumn<>(columnName);

        column.setEditable(isEditeble);

        column.setCellValueFactory(new PropertyValueFactory<>(propertyName));
        column.setCellFactory(TextFieldTableCell.forTableColumn());

    }

    public void initEditPoliticy(){

        editPoliticy.setColumn(this.column);
        editPoliticy.setDomainChanging(this.domainChanging);
        editPoliticy.setUnitOfWork(this.tableWrapper.getUnitOfWork());
        editPoliticy.setTvw(this.tableWrapper);
        editPoliticy.setKindOfColumn(kindOfColumn);
        editPoliticy.run();
    }
      public TableColumn<T,String> getColumn(){

        return this.column;

    }

}
