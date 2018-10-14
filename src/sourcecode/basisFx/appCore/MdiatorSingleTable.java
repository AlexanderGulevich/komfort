package basisFx.appCore;

import basisFx.appCore.elements.AppNode;
import basisFx.appCore.elements.TableWrapper;
import basisFx.domain.ActiveRecord;
import basisFx.service.ServiceSingleEditableSubmitTable;

public class MdiatorSingleTable implements Mediator {


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

}
