package basisFx.appCore;

import basisFx.appCore.elements.AppNode;
import basisFx.appCore.elements.TableWrapper;
import basisFx.domain.ActiveRecord;
import basisFx.service.AplicationService;
import basisFx.service.ServiceSingleEditableSubmitTable;

public class MdiatorSingleTable extends Mediator {


    @Override
    public void inform(AppNode node) {

    }

    @Override
    public void wasRemoved(AppNode node, ActiveRecord record) {
        ServiceSingleEditableSubmitTable.wasRemoved(node,record, ((TableWrapper) node).unitOfWork);
    }

    @Override
    public void wasChanged(AppNode node, ActiveRecord record) {
        ServiceSingleEditableSubmitTable.wasChanged(node,record, ((TableWrapper) node).unitOfWork);
    }

    @Override
    public void refresh(AppNode node) {
        TableWrapper tableWrapper = (TableWrapper) node;
        AplicationService.refreshTable(tableWrapper,tableWrapper.activeRecord.getAll());
    }

}
