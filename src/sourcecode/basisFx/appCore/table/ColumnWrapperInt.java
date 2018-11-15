package basisFx.appCore.table;

import basisFx.appCore.elements.TableWrapper;
import basisFx.domain.ActiveRecord;
import javafx.beans.value.ObservableValue;
import javafx.beans.value.WritableValue;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.StringConverter;

public class ColumnWrapperInt<T> extends ColumnWrapper{


    protected TableColumn<T,Integer> column;

    private ColumnWrapperInt(Builder builder) {
        tableWrapper = builder.tableWrapper;
        propertyName = builder.propertyName;
        columnName = builder.columnName;
        columnSize = builder.columnSize;
        isEditeble = builder.isEditeble;

        column =  new TableColumn<>(columnName);

        column.setEditable(isEditeble);
        column.setCellValueFactory(new PropertyValueFactory<>(propertyName));
        column.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<Integer>() {
            @Override
            public String toString(Integer val) {
                if (val != null) {
                    return val.toString();
                }
                return "";

            }

            @Override
            public Integer fromString(String val) {
                val=val.trim();
                if (checkValue(val)) {
                    return Integer.valueOf(val);
                }
                return null;
            }
        }));

        setOnEditCommit();

        if (columnSize != null) {
            column.setPrefWidth(columnSize);
        }
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    @Override
    public void setOnEditCommit() {
        column.setOnEditCommit((event) -> {
                int row = event.getTablePosition().getRow();
                ObservableValue<Integer> v = event.getTableColumn().getCellObservableValue(row);
                if (v instanceof WritableValue) {
                    ((WritableValue<Integer>)v).setValue(event.getNewValue());
                }
            ActiveRecord domain = (ActiveRecord) event.getRowValue();
            tableWrapper.getServiceMediator().wasChanged(tableWrapper,domain);

        });
    }

    @Override
    public TableColumn getColumn() {
        return column;
    }

    @Override
    protected boolean checkValue(TableColumn.CellEditEvent event) {
       return  false;
    }

    @Override
    protected boolean checkValue(String s) {
        try {
            Integer newValue = Integer.valueOf(s);
            return true;
        }catch (NumberFormatException  e){
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

        public ColumnWrapperInt build() {
            return new ColumnWrapperInt(this);
        }
    }
}
