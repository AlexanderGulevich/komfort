package basisFx.appCore.table;

import basisFx.appCore.events.SubWindowCreater;
import basisFx.appCore.settings.CSSclasses;
import basisFx.appCore.windows.WindowBuilder;
import basisFx.domain.ActiveRecord;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;

public class ColWrapperPopupViaBtn extends ColWrapper {

    protected TableColumn<ActiveRecord, Void> column;
    protected  String btnName;
    protected  WindowBuilder windowBuilder;

    private ColWrapperPopupViaBtn(Builder builder) {
        columnName = builder.columnName;
        columnSize = builder.columnSize;
        btnName = builder.btnName;
        windowBuilder = builder.windowBuilder;
        column =  new TableColumn <>(columnName);
        column.getStyleClass().add(CSSclasses.column_with_button_BFx.get());
        column.setResizable(false);
        column.setEditable(false);
        column.setCellFactory((TableColumn<ActiveRecord, Void> param) -> new ButtonCustomCell( ));
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    class ButtonCustomCell extends TableCell<ActiveRecord,Void> {

        private   Button btn ;

        public ButtonCustomCell() {
            createButton();
        }


        @Override
        public void startEdit() {
            if (!isEmpty()) {
                super.startEdit();
                createButton();
                setText(null);
                setGraphic(btn);
            }
        }

        @Override
        public void updateItem(Void item, boolean empty) {
            super.updateItem(item, empty);
            if (empty) {
                setGraphic(null);
            } else {
                setGraphic(btn);
            }
        }

        private void createButton() {
            btn = new Button(btnName);
            btn.getStyleClass().add(CSSclasses.table_column_buttons_BFx.get());
            new SubWindowCreater(windowBuilder).setEventToElement(btn);

        }

    }

    public static final class Builder {
        private String columnName;
        private Double columnSize;
        private String btnName;
        protected  WindowBuilder windowBuilder;

        private Builder() {
        }

        public Builder setWindowBuilder(WindowBuilder windowBuilder) {
            this.windowBuilder = windowBuilder;
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

        public Builder setBtnName(String val) {
            btnName = val;
            return this;
        }


        public ColWrapperPopupViaBtn build() {
            return new ColWrapperPopupViaBtn(this);
        }

    }

    @Override
    public void setOnEditCommit() {}

    @Override
    public TableColumn getColumn() {return column;}

    @Override
    protected boolean checkValue(TableColumn.CellEditEvent event) {return false;}

    @Override
    protected boolean checkValue(String s) {return false;}
}
