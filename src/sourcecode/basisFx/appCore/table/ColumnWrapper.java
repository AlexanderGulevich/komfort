package basisFx.appCore.table;

import basisFx.appCore.elements.TableWrapper;
import basisFx.domain.domaine.ActiveRecord;
import javafx.beans.value.ObservableValue;
import javafx.beans.value.WritableValue;
import javafx.scene.control.TableColumn;
public  abstract class ColumnWrapper<T,K> {

    public TableWrapper tableWrapper;
    public String propertyName;
    public String columnName;
    public Double columnSize;
    public Boolean isEditeble;
    protected static String message=   "Произошла ошибка.\nВ поле было введено неправильное значение.";



    public abstract void setOnEditCommit(); //todo ИЗМЕНЯТЬ ДОМЕН БЕЗ ЛЯМБДЫ
    public abstract TableColumn<T, K> getColumn();
    protected abstract boolean checkValue(TableColumn.CellEditEvent<T, K> event);




}
