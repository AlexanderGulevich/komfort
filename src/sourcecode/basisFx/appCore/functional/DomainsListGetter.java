package basisFx.appCore.functional;

import javafx.collections.ObservableList;

/**
 * Created by AlexanderGulevich on 20.03.2018.
 *
 * @autor AlexanderGulevich
 */
@FunctionalInterface
public interface DomainsListGetter {
    public ObservableList getList();
}
