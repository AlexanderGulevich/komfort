//package basisFx.appCore.controlPolicy;
//
//import basisFx.appCore.domainScetch.DomainObject;
//import basisFx.appCore.domainScetch.DoubleDomainObject;
//import basisFx.appCore.settings.CSSID;
//import javafx.beans.value.ObservableValue;
//import javafx.scene.control.ComboBox;
//import javafx.scene.control.ListCell;
//import javafx.scene.control.TableCell;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.util.Callback;
//
///**
// *
// * @author 62
// * @param <T>
// */
//public class ColumnDoubleComboBox<T,K> extends ColumnWrapper<T>{
//    protected TableColumn<DomainObject, DoubleDomainObject> column;
//
//    @SuppressWarnings("unchecked")
//    public ColumnDoubleComboBox(Bulder builder) {
//
//        super(builder);
//        this.column =  new TableColumn<>(columnName);
//        setCellValueFactory();
//        setCellFactory();
//
//
//
//        }
//
//    public void setCellValueFactory(){
//
////        // By default, all cells are have null values
////        column.setCellValueFactory((TableColumn.CellDataFeatures<DomainObject, DoubleDomainObject> param) -> {
////
////            DomainObject domainObject=  param.getValue();
////
////            //isn`t new object
////            if (domainObject.getId() != null) {
////                System.err.println("ColumnDoubleComboBox-доменный объект из БД ");
////                return   comboBoxCellValueInitLogic.init(domainObject);
////
////            }else {
////                System.err.println("ColumnDoubleComboBox- новый доменный объект");
////                return null;
////            }
////
////        });
//
//
//        column.setCellValueFactory(new PropertyValueFactory<>(propertyName));
//
//
//
//
//
//
//
//
//
//
//    }
//
//    public void setCellFactory(){
//        Callback<TableColumn<DomainObject, DoubleDomainObject>, TableCell<DomainObject, DoubleDomainObject>> comboBoxCellFactory
//                = (TableColumn<DomainObject, DoubleDomainObject> param) -> new ComboBoxCustomCell();
//
//        // Set a ComboBoxTableCell, so we can selects a value from a list
//        column.setCellFactory(comboBoxCellFactory);
//
//    }
//
//
//
//    public void initEditPoliticy(){
//
//        editPoliticy.setColumn(this.column);
//        editPoliticy.setDomainChanging(this.domainChanging);
//        editPoliticy.setUnitOfWork(this.tableWrapper.getUnitOfWork());
//        editPoliticy.setTvw(this.tableWrapper);
//        editPoliticy.run();
//    }
//
//    public TableColumn<DomainObject, DoubleDomainObject> getColumn(){
//
//        return this.column;
//
//    }
//
//    class ComboBoxCustomCell extends TableCell<DomainObject, DoubleDomainObject > {
//
//        private ComboBox<DoubleDomainObject> comboBox;
//
//        private ComboBoxCustomCell() {
//        }
//
//        @Override
//        public void startEdit() {
//            if (!isEmpty()) {
//                super.startEdit();
//                createComboBox();
//                setText(null);
//                setGraphic(comboBox);
//            }
//        }
//
//        @Override
//        public void cancelEdit() {
//            super.cancelEdit();
//            setText(getDoubleDomainObject().getDoubleValue().toString());
//            setGraphic(null);
//        }
//
//        @Override
//        public void updateItem(DoubleDomainObject item, boolean empty) {
//            super.updateItem(item, empty);
//
//            if (empty) {
//                setText(null);
//                setGraphic(null);
//
//
//            } else {
//                if (isEditing()) {
//
//                    if (comboBox != null) {
//                        comboBox.setValue(getDoubleDomainObject());
//
//
//
//                    }
//                    setText(getDoubleDomainObject().getDoubleValue().toString());
//                    setGraphic(comboBox);
//                } else {
//                    setText(null);
////                    setText(getDoubleDomainObject().getRate().toString());
//                    setGraphic(null);
//                }
//            }
//        }
//
//        private void createComboBox() {
//            comboBox = new ComboBox<>(domainObjectsListGetter.getList());
//            comboBox.setId(CSSID.COMBOBOX.get());
//            comboBox.setEditable(false);
////            comboBox.setPromptText("fgfg");
//            comboBoxConverter(comboBox);
//            comboBox.valueProperty().set(getDoubleDomainObject());
//            comboBox.setMinWidth(this.getWidth() - this.getGraphicTextGap() * 2);
//            comboBox.setOnAction((e) -> {
//                System.err.println("Committed: " + comboBox.getSelectionModel().getSelectedItem());
//                commitEdit(comboBox.getSelectionModel().getSelectedItem());
//            });
//            comboBox.focusedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
//                if (!newValue) {
//                    commitEdit(comboBox.getSelectionModel().getSelectedItem());
//                }
//            });
//        }
//
//        private void comboBoxConverter(ComboBox<DoubleDomainObject> comboBox) {
////             Define rendering of the list of values in ComboBox drop down.
//            comboBox.setCellFactory((c) -> {
//                return new ListCell<DoubleDomainObject>() {
//                    @Override
//                    protected void updateItem(DoubleDomainObject doubleDomainObject, boolean empty) {
//                        super.updateItem(doubleDomainObject, empty);
//                        if (doubleDomainObject == null || empty) {
//                            setText(null);
//                        } else {
//                            setText(doubleDomainObject.getDoubleValue().toString());
//                        }
//                    }
//                };
//            });
//        }
//
//        private DoubleDomainObject getDoubleDomainObject() {
//
//            if(getItem()== null){//if not exist
//                System.out.println("getItem()== null-----ComboBoxCustomCell.getDoubleDomainObject");
//
//                DoubleDomainObject doubleDomainObject=new DoubleDomainObject();
////                doubleDomainObject.setRate("");
//
//                return  doubleDomainObject;
//
//            }else {
//                System.out.println("getItem()!!== null-----ComboBoxCustomCell.getDoubleDomainObject");
//                return  getItem();
//
//            }
//
//
//
//        }
//    }
//
//
//
//
//}
