package basisFx.appCore;

import basisFx.appCore.elements.AppNode;
import basisFx.appCore.elements.TableWrapper;
import basisFx.domain.domaine.DomainObject;
import javafx.collections.ObservableList;

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
            if (node==primaryTableWrapper){

                refreshAccessoryTable(primaryTableWrapper.clickedDomain);

            }

            //todo create exeption
    }



    private void refreshAccessoryTable(DomainObject domainObject) {

        if (domainObject.getId() !=null) {

            ObservableList<DomainObject> list = accessoryTableWrapper.getActiveRecord().getDomainListForAccessoryTable(domainObject.getId());

             accessoryTableWrapper.clearItems();
             accessoryTableWrapper.clearUnitOfWork();
             accessoryTableWrapper.setList(list);



        }
    }
}

