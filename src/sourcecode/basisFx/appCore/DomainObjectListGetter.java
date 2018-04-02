package basisFx.appCore;

import basisFx.appCore.domainScetch.NamedDomainObject;
import javafx.collections.ObservableList;

/**
 * Created by AlexanderGulevich on 20.03.2018.
 *
 * @autor AlexanderGulevich
 */
@FunctionalInterface
public interface DomainObjectListGetter {
    public ObservableList getList();
}
