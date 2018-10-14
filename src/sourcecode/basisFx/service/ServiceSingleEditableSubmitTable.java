package basisFx.service;

import basisFx.appCore.elements.AppNode;
import basisFx.dataSource.UnitOfWork;
import basisFx.domain.ActiveRecord;

import java.sql.SQLException;

public class ServiceSingleEditableSubmitTable implements AplicationService{


    public static void commitAll(UnitOfWork unitOfWork) {

    }

    public static void wasRemoved(AppNode node, ActiveRecord record, UnitOfWork unitOfWork) {
        Boolean isNewDomane = AplicationService.checkIsNewDomane(record);
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

        Boolean isNewDomane = AplicationService.checkIsNewDomane(record);

        if (!isNewDomane){
            unitOfWork.registercDirty(record.entityName,record);
        }else {
            unitOfWork.registerNew(record.entityName,record);
        }
        try {
            unitOfWork.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



}
