package basisFx.appCore.controlPolicy;

import javafx.beans.value.ObservableValue;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;

public class ColumnLocalDate <T,K>extends ColumnWrapper<T>{


    protected TableColumn<T,LocalDate> column;

    @SuppressWarnings("unchecked")
    public ColumnLocalDate(ColumnWrapper.Bulder builder) {

        //        Callback<TableColumn<Person, Date>, TableCell<Person, Date>> dateCellFactory
//                = (TableColumn<Person, Date> param) -> new DateEditingCell();


//        TableColumn<Person, Date> emailCol = new TableColumn("Geburtstag");
//        emailCol.setMinWidth(200);
//        emailCol.setCellValueFactory(cellData -> cellData.getValue().birthdayProperty());
//        emailCol.setCellFactory(dateCellFactory);
//        emailCol.setOnEditCommit(
//                (TableColumn.CellEditEvent<Person, Date> t) -> {
//                    ((Person) t.getTableView().getItems()
//                    .get(t.getTablePosition().getRow()))
//                    .setBirthday(t.getNewValue());
//
//                });



        super(builder);
//        this.domainChangeAction =builder.domainChangeAction;
        this.column =  new TableColumn<>(columnName);

//        column.setCellValueFactory(new PropertyValueFactory<>(propertyName));
//        column.setCellFactory(
//                TextFieldTableCell.forTableColumn(
//                        new IntegerStringConverter()
//                ));


    }



    public void initEditPoliticy(){

        editPoliticy.setColumn(this.column);
        editPoliticy.setDomainChangeAction(this.domainChangeAction);
        editPoliticy.setUnitOfWork(this.tableWrapper.getUnitOfWork());
        editPoliticy.setTvw(this.tableWrapper);
        editPoliticy.run();
    }


    public TableColumn<T,LocalDate>  getColumn(){

        return this.column;

    }



    class DateEditingCell extends TableCell<T, Date> {

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

            setText(getDate().toString());
            setGraphic(null);
        }

        @Override
        public void updateItem(Date item, boolean empty) {
            super.updateItem(item, empty);

            if (empty) {
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
                    setText(getDate().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)));
                    setGraphic(null);
                }
            }
        }

        private void createDatePicker() {
            datePicker = new DatePicker(getDate());
            datePicker.setMinWidth(this.getWidth() - this.getGraphicTextGap() * 2);
            datePicker.setOnAction((e) -> {
                System.out.println("Committed: " + datePicker.getValue().toString());
                commitEdit(Date.from(datePicker.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
            });
            datePicker.focusedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
                if (!newValue) {
                    commitEdit(Date.from(datePicker.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
                }
            });
        }

        private LocalDate getDate() {
            return getItem() == null ? LocalDate.now() : getItem().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        }
    }





}
