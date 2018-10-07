package basisFx.appCore.interfaces;


import basisFx.domain.domaine.ActiveRecord;
import javafx.beans.property.SimpleObjectProperty;

public interface ComboBoxCellValueInitLogic<T> {
    public SimpleObjectProperty<? extends ActiveRecord>
    init(T domainObject);
}
