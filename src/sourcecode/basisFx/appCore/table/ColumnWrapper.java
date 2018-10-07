package basisFx.appCore.table;

import basisFx.appCore.elements.TableWrapper;
import basisFx.domain.domaine.ActiveRecord;
import javafx.beans.value.ObservableValue;
import javafx.beans.value.WritableValue;
import javafx.scene.control.TableColumn;
public  abstract class ColumnWrapper<T,K> {

    protected TableWrapper tableWrapper;
    protected String propertyName;
    protected String columnName;
    protected double columnSize;
    protected Boolean isEditeble;
    protected static String message=   "Произошла ошибка.\nВ поле было введено неправильное значение.";

    public ColumnWrapper() {
        setOnEditCommit();
    }


    public abstract void setOnEditCommit(); //todo ИЗМЕНЯТЬ ДОМЕН БЕЗ ЛЯМБДЫ
    public abstract TableColumn<T, K> getColumn();
    protected abstract boolean checkValue(TableColumn.CellEditEvent<T, K> event);




}
