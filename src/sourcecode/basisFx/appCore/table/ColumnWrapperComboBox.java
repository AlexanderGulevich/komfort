package basisFx.appCore.table;

import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.settings.CSSID;
import basisFx.domain.ActiveRecord;
import javafx.beans.value.ObservableValue;
import javafx.beans.value.WritableValue;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ColumnWrapperComboBox extends ColumnWrapper{

    protected TableColumn<ActiveRecord, ActiveRecord> column;
    protected ActiveRecord domain;
    protected Class <? extends ActiveRecord> domainClass;

    private ColumnWrapperComboBox(Builder builder) {
        tableWrapper = builder.tableWrapper;
        propertyName = builder.propertyName;
        columnName = builder.columnName;
        columnSize = builder.columnSize;
        isEditeble = builder.isEditeble;
        domainClass=builder.domainClass;
        createNewInstance();
        column =  new TableColumn<>(columnName);
        column.setEditable(isEditeble);
        setCellValueFactory();
        setCellFactory();
        setOnEditCommit();
    }

    private void setCellFactory() {
        Callback<TableColumn<ActiveRecord, ActiveRecord>, TableCell<ActiveRecord, ActiveRecord>> comboBoxCellFactory
                = (TableColumn<ActiveRecord, ActiveRecord> param) -> new ComboBoxCustomCell();
        // Set a ComboBoxTableCell, so we can selects a value from a list
        column.setCellFactory(comboBoxCellFactory);
    }

    private void setCellValueFactory() {
        column.setCellValueFactory(new PropertyValueFactory<>(propertyName));
    }

    private void createNewInstance() {
        Method getInstanceMethod;
            try {
                getInstanceMethod = domainClass.getDeclaredMethod("getINSTANCE");
                try {
                    try {
                        domain = (ActiveRecord) getInstanceMethod.invoke(null);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }


    }

    public static Builder newBuilder(Class aClass) {

        Builder builder = new Builder();
        builder.setDomainClass(aClass);
        return builder;
    }

    @Override
    public void setOnEditCommit() {
        column.setOnEditCommit((event) -> {
            if (checkValue(event)) {
                int row = event.getTablePosition().getRow();
                ObservableValue<ActiveRecord> value = event.getTableColumn().getCellObservableValue(row);
                if (value != null) {
                    if (value instanceof WritableValue) {
                        ((WritableValue<ActiveRecord>)value).setValue(event.getNewValue());
                        ActiveRecord domain = (ActiveRecord) event.getRowValue();
                        tableWrapper.getServiceMediator().wasChanged(tableWrapper,domain);
                    }
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

    @Override
    protected boolean checkValue(String s) {
        return false;
    }

    public static final class Builder {
        public Class domainClass;
        private TableWrapper tableWrapper;
        private String propertyName;
        private String columnName;
        private Double columnSize;
        private Boolean isEditeble;

        private Builder() {
        }

        public Builder setDomainClass(Class domainClass) {
            this.domainClass = domainClass;
            return this;
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

        public ColumnWrapperComboBox build() {
            return new ColumnWrapperComboBox(this);
        }
    }

    class ComboBoxCustomCell extends TableCell<ActiveRecord, ActiveRecord> {

        private ComboBox<ActiveRecord> comboBox;

        private ComboBoxCustomCell() {}
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
            setText(getNamedDomainObject().toString());
            setGraphic(null);
        }

        @Override
        public void updateItem(ActiveRecord item, boolean empty) {
            super.updateItem(item, empty);
            if (empty) {
                setText(null);
//                setGraphic(null);
            } else {
                if (isEditing()) {
                    if (comboBox != null) {
                        comboBox.setValue(getNamedDomainObject());
                    }
                    String s = getNamedDomainObject().toString();
                    if (s != null) {
                        s=" "+s;
                    }
//                    setText(" "+getNamedDomainObject().toString());
//                    setText(getNamedDomainObject().toString());
                    setText(s);
                    setGraphic(comboBox);
                } else {
                    String s = getNamedDomainObject().toString();
                    if (s != null) {
                        s=" "+s;
                    }
//                    setText(" " +getNamedDomainObject().toString());
//                    setText(getNamedDomainObject().toString());
                    setText(s);
                    setGraphic(null);
                }
            }
        }

        private void createComboBox() {
            ObservableList<ActiveRecord> comboBoxValues = domain.getAll();

            comboBox = new ComboBox<>(comboBoxValues);
            comboBox.setId(CSSID.COMBOBOX.get());
            comboBox.setEditable(false);
//            comboBox.setPromptText("fgfg");
            comboBoxConverter(comboBox);
            comboBox.valueProperty().set(getNamedDomainObject());
            comboBox.setMinWidth(this.getWidth() - this.getGraphicTextGap() * 2);
            comboBox.setOnAction((e) -> {
//                System.err.println("Committed: " + comboBox.getSelectionModel().getSelectedItem());
                commitEdit(comboBox.getSelectionModel().getSelectedItem());
//                tableWrapper.getServiceMediator().wasChanged(tableWrapper,domain);
            });
            comboBox.focusedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
                if (!newValue) {
                    commitEdit(comboBox.getSelectionModel().getSelectedItem());
                }
            });
        }

        private void comboBoxConverter(ComboBox<ActiveRecord> comboBox) {
//             Define rendering of the list of values in ComboBox drop down.
            comboBox.setCellFactory((c) -> new ListCell<ActiveRecord>() {
                @Override
                protected void updateItem(ActiveRecord comboBoxValue, boolean empty) {
                    super.updateItem(comboBoxValue, empty);
                    if (comboBoxValue == null || empty) {
                        setText(null);
                    } else {
                        String s = comboBoxValue.toString();
                        if (s != null) {
                            s=" "+s;
                        }
//                        setText(" "+comboBoxValue.toString());
                        setText(s);
                    }
                }
            });
        }

        private ActiveRecord getNamedDomainObject() {
            ActiveRecord item = getItem();
            if(item== null){//if not exist
                return domain;
            }else {
                return  item;
            }
        }
    }




}
