package basisFx.appCore.table;

import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.utils.ActiveRecordDTO;
import basisFx.appCore.utils.Registry;
import basisFx.appCore.windows.WindowAbstraction;
import basisFx.appCore.windows.WindowBuilder;
import basisFx.domain.ActiveRecord;
import javafx.beans.value.ObservableValue;
import javafx.beans.value.WritableValue;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;

public class ColumnWrapperSubWindow extends  ColumnWrapper{

    protected TableColumn<ActiveRecord, ActiveRecord> column;
    protected ActiveRecord domain;
    protected Class <? extends ActiveRecord> domainClass;
    protected WindowAbstraction currentWindow;
    protected WindowBuilder windowBuilder;

    private ColumnWrapperSubWindow(Builder builder) {
        tableWrapper = builder.tableWrapper;
        propertyName = builder.propertyName;
        columnName = builder.columnName;
        columnSize = builder.columnSize;
        isEditeble = builder.isEditeble;
        domain = builder.domain;
        windowBuilder = builder.windowBuilder1;
        domainClass = builder.domainClass;
        currentWindow = builder.currentWindow;
        column =  new TableColumn<>(columnName);
        column.setEditable(isEditeble);
        setCellValueFactory();
        setCellFactory();
        setOnEditCommit();

    }

    public static Builder newBuilder() {
        return new Builder();
    }

    private void setCellFactory() {
        column.setCellFactory((value) -> {
            TableCell<ActiveRecord, ActiveRecord> tableCell = new SubWindowCell();
            tableCell.setOnMouseClicked((mouseEvent) -> {
                if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                    if (mouseEvent.getClickCount() == 2) {
                        subWindowHandler((SubWindowCell) tableCell);
                    }
                }
            });
            return tableCell;
        });
    }

    private void subWindowHandler(SubWindowCell tableCell) {
//        WindowAbstraction subWindow = Registry.windowFabric.customSubWindow(windowBuilder);
//        currentWindow.getCrossWindowMediator().setSubWindow(subWindow);
//        currentWindow.getCrossWindowMediator().setReceiverDataFromSubWindow(
//                (dto)-> tableCell.updateItem(((ActiveRecordDTO) dto).getActiveRecord(),false)
//        );
    }

    private void setCellValueFactory() {
        column.setCellValueFactory(new PropertyValueFactory<>(propertyName));
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
                        tableWrapper.getServiceTables().wasChanged(tableWrapper,domain);
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
        try {
            ActiveRecord newValue = (ActiveRecord) event.getNewValue();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    protected boolean checkValue(String s) {
        return false;
    }
    class SubWindowCell extends TableCell<ActiveRecord, ActiveRecord> {
        @Override
        public void startEdit() {
            if (!isEmpty()) {
                super.startEdit();
                setText(null);
            }
        }
        @Override
        public void cancelEdit() {
            super.cancelEdit();
            setText(getNamedDomainObject().toString());
        }
        @Override
        public void updateItem(ActiveRecord item, boolean empty) {
            super.updateItem(item, empty);
            if (empty) {
                setText(null);
            } else {
                if (isEditing()) {
                    if (getNamedDomainObject() != null) {
                        String s = getNamedDomainObject().toString();
                        if (s != null) {
                            s=" "+s;
                            setText(s);
                        }
                    }
                } else {
                    if (getNamedDomainObject() != null) {
                        String s = getNamedDomainObject().toString();
                        if (s != null) {
                            s=" "+s;
                        }
                        setText(s);
                    }
                }
            }
        }
        private ActiveRecord getNamedDomainObject() {
            ActiveRecord item = getItem();
            if(item== null){
                return domain;
            }else {
                return  item;
            }
        }
    }


    public static final class Builder {
        private TableWrapper tableWrapper;
        private String propertyName;
        private String columnName;
        private Double columnSize;
        private Boolean isEditeble;
        private ActiveRecord domain;
        private Class<? extends ActiveRecord> domainClass;
        private WindowAbstraction currentWindow;
        private WindowBuilder windowBuilder1;

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

        public Builder setColumnSize(Double val) {
            columnSize = val;
            return this;
        }

        public Builder setIsEditeble(Boolean val) {
            isEditeble = val;
            return this;
        }


        public Builder setCurrentWindow(WindowAbstraction val) {
            currentWindow = val;
            return this;
        }

        public Builder setWindowBuilder(WindowBuilder val) {
            windowBuilder1 = val;
            return this;
        }

        public ColumnWrapperSubWindow build() {
            return new ColumnWrapperSubWindow(this);
        }
    }
}
