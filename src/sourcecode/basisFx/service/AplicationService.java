package basisFx.service;

import basisFx.appCore.elements.AppNode;
import basisFx.dataSource.UnitOfWork;
import basisFx.domain.ActiveRecord;

public  interface AplicationService {

    public  static void commitAll(UnitOfWork unitOfWork){};
    public  static void wasRemoved(AppNode node, ActiveRecord record,UnitOfWork unitOfWork){};
    public  static void wasChanged(AppNode node, ActiveRecord record,UnitOfWork unitOfWork){};
    public  static void wasAdded(AppNode node, ActiveRecord record,UnitOfWork unitOfWork){};

    public static Boolean checkIsNewDomane(ActiveRecord record) {
        if (record.id.get() == null) {
            return true;
        }else{
            return false;
        }
    }



}
