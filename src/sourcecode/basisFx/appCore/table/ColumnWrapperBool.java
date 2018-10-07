package basisFx.appCore.table;

import basisFx.appCore.elements.TableWrapper;
import basisFx.domain.domaine.ActiveRecord;
import javafx.beans.value.ObservableValue;
import javafx.beans.value.WritableValue;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class ColumnWrapperBool<T> extends ColumnWrapper{

    protected TableColumn<T,Boolean> column;

    private ColumnWrapperBool(Builder builder) {
        tableWrapper = builder.tableWrapper;
        propertyName = builder.propertyName;
        columnName = builder.columnName;
        columnSize = builder.columnSize;
        isEditeble = builder.isEditeble;


        this.column =  new TableColumn<>(columnName);

        column.setEditable(isEditeble);

        column.setCellValueFactory(new PropertyValueFactory<>(propertyName));
        column.setCellFactory(CheckBoxTableCell.<T>forTableColumn(column));

    }

    public static Builder newBuilder() {
        return new Builder();
    }

    @Override
    public void setOnEditCommit() {
        column.setOnEditCommit((event) -> {
            if (checkValue(event)) {
                ActiveRecord domain = (ActiveRecord) event.getRowValue();
                int row = event.getTablePosition().getRow();
                ObservableValue<Boolean> v = event.getTableColumn().getCellObservableValue(row);
                if (v instanceof WritableValue) {
                    ((WritableValue<Boolean>)v).setValue(event.getNewValue());
                }

            };
        });

    }

    @Override
    public TableColumn getColumn() {
        return column;
    }

    @Override
    protected boolean checkValue(TableColumn.CellEditEvent event) {
        return true;
    }

    public static final class Builder {
        private TableWrapper tableWrapper;
        private String propertyName;
        private String columnName;
        private double columnSize;
        private Boolean isEditeble;

        private Builder() {
        }

        public Builder setTableWrapper(TableWrapper val) {
            tableWrapper = val;
            return this;
        }

        public Builder setPropertyName(String val) {
            propertyName = val;
            return this;
        }

        public Builder setColumnName(String val) {
            columnName = val;
            return this;
        }

        public Builder setColumnSize(double val) {
            columnSize = val;
            return this;
        }

        public Builder setIsEditeble(Boolean val) {
            isEditeble = val;
            return this;
        }

        public ColumnWrapperBool build() {
            return new ColumnWrapperBool(this);
        }
    }
}
