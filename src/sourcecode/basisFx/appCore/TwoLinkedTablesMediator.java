package basisFx.appCore;

import basisFx.appCore.elements.AppNode;
import basisFx.appCore.elements.TableWrapper;

public class TwoLinkedTablesMediator implements Mediator {

    private  TableWrapper primaryTableWrapper;
    private  TableWrapper accessoryTableWrapper;

    public TwoLinkedTablesMediator(TableWrapper primaryTableWrapper, TableWrapper accessoryTableWrapper) {
        this.primaryTableWrapper = primaryTableWrapper;
        this.accessoryTableWrapper = accessoryTableWrapper;
        primaryTableWrapper.setMediator(this);
        accessoryTableWrapper.setMediator(this);
    }

    @Override
    public void inform(AppNode node) {

    }
}
