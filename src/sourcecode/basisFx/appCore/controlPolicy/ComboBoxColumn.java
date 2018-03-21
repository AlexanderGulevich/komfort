package basisFx.appCore.controlPolicy;

import basisFx.appCore.domainScetch.DomainObject;
import basisFx.appCore.domainScetch.NamedDomainObject;
import basisFx.domainModel.DataMapperFabric;
import basisFx.domainModel.settings.CSSID;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;

/**
 *
 * @author 62
 * @param <T>
 */
public class ComboBoxColumn<T,K> extends ColumnWrapper<T>{
    protected TableColumn<DomainObject, NamedDomainObject> column;

    @SuppressWarnings("unchecked")
    public ComboBoxColumn(Bulder builder) {

        super(builder);
        this.column =  new TableColumn<>(columnName);
        setCellValueFactory();
        setCellFactory();

    }

    public void setCellValueFactory(){

        // By default, all cells are have null values
        column.setCellValueFactory((TableColumn.CellDataFeatures<DomainObject, NamedDomainObject> param) -> {

            DomainObject domainObject=  param.getValue();

            //isn`t new object
            if (domainObject.getId() != null) {
                ObjectProperty objectProperty=null;
                comboBoxCellValueInitLogic.init(domainObject,objectProperty);
                System.out.println("ComboBoxColumn.ComboBoxColumn---objectProperty="+ objectProperty);
                return objectProperty;
            }else {
                return null;
            }

        });

    }

    public void setCellFactory(){
        Callback<TableColumn<DomainObject, NamedDomainObject>, TableCell<DomainObject, NamedDomainObject>> comboBoxCellFactory
                = (TableColumn<DomainObject, NamedDomainObject> param) -> new ComboBoxCustomCell();

        // Set a ComboBoxTableCell, so we can selects a value from a list
        column.setCellFactory(comboBoxCellFactory);


    }


    public void initEditPoliticy(){
//
//        for (Edit edit : editPoliticy) {
//            edit.setColumn(this.column);
//            edit.setDomainChangeAction(this.domainChangeAction);
//            edit.setUnitOfWork(this.tableWrapper.getUnitOfWork());
//            edit.setTvw(this.tableWrapper);
//            edit.run();
//
//        }
    }


    public TableColumn<DomainObject, NamedDomainObject> getColumn(){

        return this.column;

    }


    class ComboBoxCustomCell extends TableCell<DomainObject, NamedDomainObject> {

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

                System.out.println("ComboBoxCustomCell.updateItem----   if (empty) {");
            } else {
                if (isEditing()) {


                    System.out.println("ComboBoxCustomCell.updateItem----      if (isEditing()) {");

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
            comboBox = new ComboBox<>(namedObjectListGetter.getList());
            comboBox.setId(CSSID.COMBOBOX.get());
//            comboBox.setEditable(true);
            comboBox.setPromptText("fgfg");
            comboBoxConverter(comboBox);
            comboBox.valueProperty().set(getNamedDomainObject());
            comboBox.setMinWidth(this.getWidth() - this.getGraphicTextGap() * 2);
            comboBox.setOnAction((e) -> {
                System.out.println("Committed: " + comboBox.getSelectionModel().getSelectedItem());
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
                    protected void updateItem(NamedDomainObject item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item == null || empty) {
                            setText(null);
                        } else {
                            setText(item.getNameProperty().getValue());
                        }
                    }
                };
            });
        }

        private NamedDomainObject getNamedDomainObject() {

            if(getItem() == null){

                NamedDomainObject namedDomainObject=new NamedDomainObject();
                namedDomainObject.getNameProperty().setValue(null);
//                System.out.println("ComboBoxCustomCell.getNamedDomainObject---(getItem() == null");
                return  namedDomainObject;
//                return  null;

            }else {
//                System.out.println("ComboBoxCustomCell.getNamedDomainObject---(getItem() != null");
//                System.out.println("omboBoxCustomCell.getNamedDomainObject---getItem();------"+getItem().getName());
//                System.out.println("omboBoxCustomCell.getNamedDomainObject---getItem();------"+getItem().getNameProperty().toString());
                return  getItem();

//                return  null;
            }



        }
    }




}
