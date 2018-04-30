package basisFx.appCore.controlPolicy;

import basisFx.appCore.domainScetch.DomainObject;
import basisFx.appCore.settings.CSSID;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import javafx.util.StringConverter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class ColumnLocalDate <T,K>extends ColumnWrapper<T> {


    protected TableColumn<DomainObject, LocalDate> column;

    @SuppressWarnings("unchecked")
    public ColumnLocalDate(ColumnWrapper.Bulder builder) {
        super(builder);
        this.column = new TableColumn<>(columnName);

        Callback<TableColumn<DomainObject, LocalDate>, TableCell<DomainObject, LocalDate>> dateCellFactory
                = (TableColumn<DomainObject, LocalDate> param) -> new DateEditingCell();

//        column.setCellValueFactory(
//                cellData -> this.dateCellValueInitLogic.init(cellData.getValue())
//        );


        column.setCellValueFactory(new PropertyValueFactory<>(propertyName));

        column.setCellFactory(dateCellFactory);
        column.setOnEditCommit(
                (TableColumn.CellEditEvent<DomainObject, LocalDate> t) -> {
                        this.domainChanging.change(
                                t.getTableView().getItems().get(t.getTablePosition().getRow()),
                                t.getNewValue());
                });
    }

    public void initEditPoliticy() {

        editPoliticy.setColumn(this.column);
        editPoliticy.setDomainChanging(this.domainChanging);
        editPoliticy.setUnitOfWork(this.tableWrapper.getUnitOfWork());
        editPoliticy.setTvw(this.tableWrapper);
        editPoliticy.setKindOfColumn(kindOfColumn);
        editPoliticy.run();
    }


    public TableColumn<DomainObject, LocalDate> getColumn() {

        return this.column;

    }

    class DateEditingCell extends TableCell<DomainObject, LocalDate> {

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
                System.out.println("Committed: " + datePicker.getValue().toString());
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
