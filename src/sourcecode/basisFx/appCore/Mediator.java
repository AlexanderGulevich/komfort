package basisFx.appCore;

import basisFx.appCore.elements.AppNode;
import basisFx.domain.ActiveRecord;

public abstract class Mediator {

    public  void inform(AppNode node);
    public void wasRemoved(AppNode node, ActiveRecord record);
    public void wasChanged(AppNode node, ActiveRecord record);
    public void wasChanged(AppNode node, ActiveRecord record);
}
