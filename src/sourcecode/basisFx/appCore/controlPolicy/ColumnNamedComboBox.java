package basisFx.appCore.controlPolicy;

import basisFx.appCore.domainScetch.DomainObject;
import basisFx.appCore.domainScetch.NamedDomainObject;
import basisFx.domainModel.settings.CSSID;
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
public class ColumnNamedComboBox<T,K> extends ColumnWrapper<T>{
    protected TableColumn<DomainObject, NamedDomainObject> column;

    @SuppressWarnings("unchecked")
    public ColumnNamedComboBox(Bulder builder) {

        super(builder);
        this.column =  new TableColumn<>(columnName);
        setCellValueFactory();
        setCellFactory();



        }

    public void setCellValueFactory(){

        column.setCellValueFactory(new PropertyValueFactory<>(propertyName));

    }

    public void setCellFactory(){
        Callback<TableColumn<DomainObject, NamedDomainObject>, TableCell<DomainObject, NamedDomainObject>> comboBoxCellFactory
                = (TableColumn<DomainObject, NamedDomainObject> param) -> new ComboBoxCustomCell();

        // Set a ComboBoxTableCell, so we can selects a value from a list
        column.setCellFactory(comboBoxCellFactory);

    }



    public void initEditPoliticy(){

        editPoliticy.setColumn(this.column);
        editPoliticy.setDomainChangeAction(this.domainChangeAction);
        editPoliticy.setUnitOfWork(this.tableWrapper.getUnitOfWork());
        editPoliticy.setTvw(this.tableWrapper);
        editPoliticy.run();
    }

    public TableColumn<DomainObject, NamedDomainObject> getColumn(){

        return this.column;

    }

    class ComboBoxCustomCell extends TableCell<DomainObject, NamedDomainObject > {

        private ComboBox<NamedDomainObject> comboBox;

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
            setText(getNamedDomainObject().getName());
            setGraphic(null);
        }

        @Override
        public void updateItem(NamedDomainObject item, boolean empty) {
            super.updateItem(item, empty);

            if (empty) {
                setText(null);
                setGraphic(null);


            } else {
                if (isEditing()) {

                    if (comboBox != null) {
                        comboBox.setValue(getNamedDomainObject());



                    }
                    setText(getNamedDomainObject().getName());
                    setGraphic(comboBox);
                } else {
                    setText(getNamedDomainObject().getName());
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

        private void comboBoxConverter(ComboBox<NamedDomainObject> comboBox) {
//             Define rendering of the list of values in ComboBox drop down.
            comboBox.setCellFactory((c) -> {
                return new ListCell<NamedDomainObject>() {
                    @Override
                    protected void updateItem(NamedDomainObject namedDomainObject, boolean empty) {
                        super.updateItem(namedDomainObject, empty);
                        if (namedDomainObject == null || empty) {
                            setText(null);
                        } else {
                            setText(namedDomainObject.getName());
                        }
                    }
                };
            });
        }

        private NamedDomainObject getNamedDomainObject() {

            if(getItem()== null){//if not exist


                NamedDomainObject namedDomainObject=new NamedDomainObject();
                namedDomainObject.setName("");

                return  namedDomainObject;

            }else {

                return  getItem();

            }



        }
    }




}
