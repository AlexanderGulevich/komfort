package basisFx.appCore.table;

import basisFx.appCore.elements.TableWrapper;
import basisFx.domain.ActiveRecord;
import javafx.beans.value.ObservableValue;
import javafx.beans.value.WritableValue;
import javafx.scene.control.TableColumn;

public class ColumnWrapperDouble <T>extends ColumnWrapper{

    protected TableColumn<T,String> column;

    private ColumnWrapperDouble(Builder builder) {
        tableWrapper = builder.tableWrapper;
        propertyName = builder.propertyName;
        columnName = builder.columnName;
        columnSize = builder.columnSize;
        isEditeble = builder.isEditeble;
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
                ObservableValue<String> v = event.getTableColumn().getCellObservableValue(row);
                if (v instanceof WritableValue) {
                    ((WritableValue<String>)v).setValue(event.getNewValue());
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
        try {

            String string=(String) event.getNewValue();

            if(string.contains(",")){
                string=string.replace(',','.');
            }

            Double newValue = Double.parseDouble(string);

            return true;

        }catch (NumberFormatException   e){



            return false;
        }
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

        public ColumnWrapperDouble build() {
            return new ColumnWrapperDouble(this);
        }
    }
}
