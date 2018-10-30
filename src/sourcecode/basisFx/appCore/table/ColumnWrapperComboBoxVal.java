package basisFx.appCore.table;

import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.settings.CSSID;
import basisFx.domain.ActiveRecord;
import basisFx.domain.ComboBoxValue;
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

public class ColumnWrapperComboBoxVal extends ColumnWrapper{

    protected TableColumn<ActiveRecord, ActiveRecord> column;
    protected ActiveRecord domain;
    protected Class <? extends ActiveRecord> domainClass;

    private ColumnWrapperComboBoxVal(Builder builder) {
        tableWrapper = builder.tableWrapper;
        propertyName = builder.propertyName;
        columnName = builder.columnName;
        columnSize = builder.columnSize;
        isEditeble = builder.isEditeble;
        domainClass=builder.domainClass;
        createNewInstance();
        column =  new TableColumn<>(columnName);
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
                getInstanceMethod = domainClass.getDeclaredMethod("getInstance");
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

    public static Builder newBuilder() {
        return new Builder();
    }

    @Override
    public void setOnEditCommit() {
        column.setOnEditCommit((event) -> {
            if (checkValue(event)) {
                int row = event.getTablePosition().getRow();
                ObservableValue<ActiveRecord> value = event.getTableColumn().getCellObservableValue(row);
                if (value instanceof WritableValue) {
                    ((WritableValue<ActiveRecord>)value).setValue(event.getNewValue());
                }
                ActiveRecord domain = (ActiveRecord) event.getRowValue();
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
        return true;
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

        public ColumnWrapperComboBoxVal build() {
            return new ColumnWrapperComboBoxVal(this);
        }
    }

    class ComboBoxCustomCell extends TableCell<ActiveRecord, ActiveRecord> {

        private ComboBox<ComboBoxValue> comboBox;

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
            setText(getNamedDomainObject().getStringValue());
            setGraphic(null);
        }

        @Override
        public void updateItem(ActiveRecord item, boolean empty) {
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
            ObservableList<ComboBoxValue> comboBoxValues = domain.toComboBoxValueList();

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
//                tableWrapper.getMediator().wasChanged(tableWrapper,domain);
            });
            comboBox.focusedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
                if (!newValue) {
                    commitEdit(comboBox.getSelectionModel().getSelectedItem());
                }
            });
        }

        private void comboBoxConverter(ComboBox<ComboBoxValue> comboBox) {
//             Define rendering of the list of values in ComboBox drop down.
            comboBox.setCellFactory((c) -> new ListCell<ComboBoxValue>() {
                @Override
                protected void updateItem(ComboBoxValue comboBoxValue, boolean empty) {
                    super.updateItem(comboBoxValue, empty);
                    if (comboBoxValue == null || empty) {
                        setText(null);
                    } else {
                        setText(comboBoxValue.getStringValue());
                    }
                }
            });
        }

        private ComboBoxValue getNamedDomainObject() {
            if(getItem()== null){//if not exist
                ComboBoxValue comboBoxValue =new ComboBoxValue("");
                return comboBoxValue;
            }else {
                return  getItem().toComboBoxValue();
            }
        }
    }




}
