package basisFx.appCore.table;

import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.settings.CSSID;
import basisFx.domain.ActiveRecord;
import javafx.beans.value.ObservableValue;
import javafx.beans.value.WritableValue;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import javafx.util.StringConverter;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class ColumnWrapperDate extends ColumnWrapper{


    protected TableColumn<ActiveRecord, LocalDate> column;

    private ColumnWrapperDate(Builder builder) {
        tableWrapper = builder.tableWrapper;
        propertyName = builder.propertyName;
        columnName = builder.columnName;
        columnSize = builder.columnSize;
        isEditeble = builder.isEditeble;

        this.column = new TableColumn<>(columnName);

        Callback<TableColumn<ActiveRecord, LocalDate>, TableCell<ActiveRecord, LocalDate>> dateCellFactory
                = (TableColumn<ActiveRecord, LocalDate> param) -> new ColumnWrapperDate.DateEditingCell();

        column.setCellValueFactory(new PropertyValueFactory<>(propertyName));
        column.setCellFactory(dateCellFactory);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    @Override
    public void setOnEditCommit() {

        column.setOnEditCommit((TableColumn.CellEditEvent<ActiveRecord, LocalDate> event)  -> {
            if (checkValue(event)) {
                ActiveRecord domain = (ActiveRecord) event.getRowValue();
                int row = event.getTablePosition().getRow();
                ObservableValue<LocalDate> v = event.getTableColumn().getCellObservableValue(row);
                if (v instanceof WritableValue) {
                    ((WritableValue<LocalDate>)v).setValue(event.getNewValue());
                }
                tableWrapper.getMediator().wasChanged(tableWrapper,domain);

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
            LocalDate newValue = (LocalDate) event.getNewValue();
            return true;
        }catch (DateTimeException e){


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

        public ColumnWrapperDate build() {
            return new ColumnWrapperDate(this);
        }
    }











    class DateEditingCell extends TableCell<ActiveRecord, LocalDate> {

        private DatePicker datePicker;

        private DateEditingCell() {
        }

        @Override
        public void startEdit() {
            if (!isEmpty()) {
                super.startEdit();
                createDatePicker();
                setText(null);
                setGraphic(datePicker);
            }
        }

        @Override
        public void cancelEdit() {
            super.cancelEdit();

//            setText(getDate().toString());
//            setText(getDate().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
            setText(null);
            setGraphic(null);
        }

        @Override
        public void updateItem(LocalDate item, boolean empty) {
            super.updateItem(item, empty);

            if (empty||item==null) {
                setText(null);
                setGraphic(null);
            } else {
                if (isEditing()) {
                    if (datePicker != null) {
                        datePicker.setValue(getDate());
                    }
                    setText(null);
                    setGraphic(datePicker);
                } else {
                    setText(getDate().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
                    setGraphic(null);
                }
            }
        }

        private void createDatePicker() {
            datePicker = new DatePicker(getDate());
            datePicker.setId(CSSID.DATEPICKER_IN_COLUMN.get());
            datePicker.setMinWidth(this.getWidth() - this.getGraphicTextGap() * 7);
//            datePicker.setMinWidth(this.getWidth() - this.getGraphicTextGap() * 2);
            datePicker.setConverter(new CustomStringConverter());
            datePicker.setPromptText("");
            datePicker.setOnAction((e) -> {
//                System.out.println("Committed: " + datePicker.getValue().toString());
//                commitEdit(LocalDate.from(datePicker.getRate().atStartOfDay(ZoneId.systemDefault()).toInstant()));
                commitEdit(datePicker.getValue());
            });
            datePicker.focusedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
                if (!newValue) {
//                    commitEdit(LocalDate.from(datePicker.getRate().atStartOfDay(ZoneId.systemDefault()).toInstant()));
                    commitEdit(datePicker.getValue());
                }
            });
        }

        private LocalDate getDate() {
            return getItem() == null ? null : getItem();
//                    toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        }
    }


    class CustomStringConverter extends StringConverter<LocalDate> {
        DateTimeFormatter dateFormatter =//DateTimeFormatter.ofPattern("dd-MM-yyyy");
                DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        @Override
        public String toString(LocalDate date) {
            if (date != null) {
                return dateFormatter.format(date);
            } else {
                return "";
            }
        }

        @Override
        public LocalDate fromString(String string) {
            if (string != null && !string.isEmpty()) {
                return LocalDate.parse(string, dateFormatter);
            } else {
                return null;
            }
        }
    }
}
