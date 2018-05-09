package basisFx.appCore.controls;

import basisFx.appCore.domainScetch.ComboBoxStringValue;
import basisFx.appCore.domainScetch.DomainObject;
import basisFx.appCore.settings.CSSID;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

/**
 *
 * @author 62
 * @param <T>
 */
public class ColumnStringComboBox<T,K> extends ColumnWrapper<T>{
    protected TableColumn<DomainObject, ComboBoxStringValue> column;

    @SuppressWarnings("unchecked")
    public ColumnStringComboBox(Bulder builder) {

        super(builder);
        this.column =  new TableColumn<>(columnName);
        setCellValueFactory();
        setCellFactory();



        }

    public void setCellValueFactory(){

        column.setCellValueFactory(new PropertyValueFactory<>(propertyName));

    }

    public void setCellFactory(){
        Callback<TableColumn<DomainObject, ComboBoxStringValue>, TableCell<DomainObject, ComboBoxStringValue>> comboBoxCellFactory
                = (TableColumn<DomainObject, ComboBoxStringValue> param) -> new ComboBoxCustomCell();

        // Set a ComboBoxTableCell, so we can selects a value from a list
        column.setCellFactory(comboBoxCellFactory);

    }



    public void initEditPoliticy(){

        editPoliticy.setColumn(this.column);
        editPoliticy.setDomainChanging(this.domainChanging);
        editPoliticy.setUnitOfWork(this.tableWrapper.getUnitOfWork());
        editPoliticy.setTvw(this.tableWrapper);
        editPoliticy.setKindOfColumn(kindOfColumn);
        editPoliticy.run();
    }

    public TableColumn<DomainObject, ComboBoxStringValue> getColumn(){

        return this.column;

    }

    class ComboBoxCustomCell extends TableCell<DomainObject, ComboBoxStringValue> {

        private ComboBox<ComboBoxStringValue> comboBox;

        private ComboBoxCustomCell() {
        }

        @Override
        public void startEdit() {
            if (!isEmpty()) {
                super.startEdit();
                createComboBox();
                setText(null);
                setGraphic(comboBox);
            }
        }

        @Override
        public void cancelEdit() {
            super.cancelEdit();
            setText(getNamedDomainObject().getStringValue());
            setGraphic(null);
        }

        @Override
        public void updateItem(ComboBoxStringValue item, boolean empty) {
            super.updateItem(item, empty);

            if (empty) {
                setText(null);
                setGraphic(null);


            } else {
                if (isEditing()) {

                    if (comboBox != null) {
                        comboBox.setValue(getNamedDomainObject());



                    }
                    setText(getNamedDomainObject().getStringValue());
                    setGraphic(comboBox);
                } else {
                    setText(getNamedDomainObject().getStringValue());
                    setGraphic(null);
                }
            }
        }

        private void createComboBox() {
            comboBox = new ComboBox<>(domainObjectsListGetter.getList());
            comboBox.setId(CSSID.COMBOBOX.get());
            comboBox.setEditable(false);
//            comboBox.setPromptText("fgfg");
            comboBoxConverter(comboBox);
            comboBox.valueProperty().set(getNamedDomainObject());
            comboBox.setMinWidth(this.getWidth() - this.getGraphicTextGap() * 2);
            comboBox.setOnAction((e) -> {
                System.err.println("Committed: " + comboBox.getSelectionModel().getSelectedItem());
                commitEdit(comboBox.getSelectionModel().getSelectedItem());
            });
            comboBox.focusedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
                if (!newValue) {
                    commitEdit(comboBox.getSelectionModel().getSelectedItem());
                }
            });
        }

        private void comboBoxConverter(ComboBox<ComboBoxStringValue> comboBox) {
//             Define rendering of the list of values in ComboBox drop down.
            comboBox.setCellFactory((c) -> {
                return new ListCell<ComboBoxStringValue>() {
                    @Override
                    protected void updateItem(ComboBoxStringValue comboBoxStringValue, boolean empty) {
                        super.updateItem(comboBoxStringValue, empty);
                        if (comboBoxStringValue == null || empty) {
                            setText(null);
                        } else {
                            setText(comboBoxStringValue.getStringValue());
                        }
                    }
                };
            });
        }

        private ComboBoxStringValue getNamedDomainObject() {

            if(getItem()== null){//if not exist


                ComboBoxStringValue comboBoxStringValue =new ComboBoxStringValue();
                comboBoxStringValue.setStringValue("");

                return comboBoxStringValue;

            }else {

                return  getItem();

            }



        }
    }




}
