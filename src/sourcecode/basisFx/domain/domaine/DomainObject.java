package basisFx.domain.domaine;

import basisFx.dataSource.ActiveRecord;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public abstract class DomainObject {

    protected ActiveRecord activeRecord;
    protected String tableName;

    private ObjectProperty<Integer> id =new SimpleObjectProperty<>(this, "id", null);
    public  abstract ComboBoxValue  toComboBoxValue();
    public Integer getId() {
            return id.get();
        }
    public void setId(int value) {
        this.id.set(value);
    }
    public ActiveRecord getActiveRecord() {
        return activeRecord;
    }
    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }


    public void setActiveRecord(ActiveRecord activeRecord) {
        this.activeRecord = activeRecord;
    }


}
