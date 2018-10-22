package basisFx.appCore;

import basisFx.appCore.elements.AppNode;
import basisFx.domain.ActiveRecord;

public abstract class Mediator {

    public abstract  void inform(AppNode node);
    public abstract void wasRemoved(AppNode node, ActiveRecord record);
    public abstract void wasChanged(AppNode node, ActiveRecord record);

    public boolean isNewDomane(ActiveRecord record) {
        if (record.getId() !=null) {
            return false;
        }
        return true;
    }
}
