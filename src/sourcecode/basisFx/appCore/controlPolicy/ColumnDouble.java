package basisFx.appCore.controlPolicy;

import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;

public class ColumnDouble<T,K> extends ColumnWrapper<T> {

    protected TableColumn<T, Double> column;

//    todo


    @SuppressWarnings("unchecked")
    public ColumnDouble(ColumnWrapper.Bulder builder) {

        super(builder);
//        this.domainChangeAction =builder.domainChangeAction;
        this.column = new TableColumn<>(columnName);

        column.setCellValueFactory(new PropertyValueFactory<>(propertyName));

        column.setCellFactory(
                TextFieldTableCell.forTableColumn(
                        new DoubleStringConverter()
                ));

    }


    public void initEditPoliticy() {


        editPoliticy.setColumn(this.column);
        editPoliticy.setDomainChangeAction(this.domainChangeAction);
        editPoliticy.setUnitOfWork(this.tableWrapper.getUnitOfWork());
        editPoliticy.setTvw(this.tableWrapper);
        editPoliticy.run();
    }


    public TableColumn<T, Double> getColumn() {

        return this.column;

    }
}