package basisFx.appCore.domainScetch;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by AlexanderGulevich on 18.03.2018.
 *
 * @autor AlexanderGulevich
 */
public interface ComboBoxCellValueInitLogic<T> {
    public   SimpleObjectProperty<? extends DomainObject>  init(T domainObject);
}
