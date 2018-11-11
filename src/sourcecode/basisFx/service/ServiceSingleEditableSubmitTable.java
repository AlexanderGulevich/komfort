package basisFx.service;

import basisFx.appCore.elements.AppNode;
import basisFx.appCore.elements.TableWrapper;
import basisFx.dataSource.UnitOfWork;
import basisFx.domain.ActiveRecord;

import java.sql.SQLException;

public class ServiceSingleEditableSubmitTable extends AplicationService{


    public static void wasRemoved(AppNode node, ActiveRecord record, UnitOfWork unitOfWork) {
        Boolean isNewDomane = ActiveRecord.isNewDomane(record);
        if (!isNewDomane){
            unitOfWork.registercDeleted(record.entityName,record);

            try {
                unitOfWork.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }

    public static void wasChanged(AppNode node, ActiveRecord record, UnitOfWork unitOfWork) {

        Boolean isNewDomane = ActiveRecord.isNewDomane(record);

        if (!isNewDomane){
            unitOfWork.registercDirty(record.entityName,record);
        }else {
            unitOfWork.registerNew(record.entityName,record);
        }
        try {
            unitOfWork.commit();
            ((TableWrapper) node).getMediator().refresh(node);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



}
