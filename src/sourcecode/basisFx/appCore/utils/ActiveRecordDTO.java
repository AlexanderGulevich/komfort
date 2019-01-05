package basisFx.appCore.utils;

import basisFx.domain.ActiveRecord;

public class ActiveRecordDTO  extends  DTO{

    private ActiveRecord activeRecord;

    public ActiveRecordDTO(ActiveRecord activeRecord) {
        this.activeRecord = activeRecord;
    }

    public ActiveRecord getActiveRecord() {
        return activeRecord;
    }

    public void setActiveRecord(ActiveRecord activeRecord) {
        this.activeRecord = activeRecord;
    }
}
