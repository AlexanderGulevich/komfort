
package basisFx.dataSource;
import basisFx.domain.domaine.ActiveRecord;

import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class UnitOfWork {

    private HashMap <String,ArrayList<ActiveRecord>>      newDomainObjects=new HashMap<>();
    private HashMap <String,ArrayList<ActiveRecord>>      dirtyDomainObjects=new HashMap<>();
    private HashMap <String,ArrayList<ActiveRecord>>      deletedDomainObject=new HashMap<>();

    public void registerNew(String activeRecordName, ActiveRecord record){
        listNullCheck(newDomainObjects,activeRecordName);
        ArrayList<ActiveRecord> records = newDomainObjects.get(activeRecordName);
        records.add(record);
    }
    public void registercDirty(String activeRecordName,ActiveRecord record){
        listNullCheck(dirtyDomainObjects,activeRecordName);
        ArrayList<ActiveRecord> records = dirtyDomainObjects.get(activeRecordName);
        records.add(record);
    }
    public void registercDeletedDomainObject(String activeRecordName,ActiveRecord record){
        listNullCheck(deletedDomainObject,activeRecordName);
        ArrayList<ActiveRecord> records = deletedDomainObject.get(activeRecordName);
        records.add(record);
    }

    public void clearNew(){
        this.newDomainObjects.clear();
    }
    public void cleardDeleted(){
        this.deletedDomainObject.clear();
    }
    public void clearDirty(){
        this.dirtyDomainObjects.clear();

    }

    public boolean isExistNew(String s,ActiveRecord record){
        return newDomainObjects.get(s).contains(record);
    }
    public boolean isExistDeleted(String s,ActiveRecord record){
        return deletedDomainObject.get(s).contains(record);
    }
    public boolean isExistDirty(String s,ActiveRecord record){
        return dirtyDomainObjects.get(s).contains(record);
    }

    private void listNullCheck(HashMap<String,ArrayList<ActiveRecord>>  map,String activeRecordName) {
        ArrayList<ActiveRecord> activeRecords = map.get(activeRecordName);
        if(activeRecords==null){
            map.put(activeRecordName,new ArrayList<>());
        }
    }

    public void commit() throws SQLException{
        updateNew();
        updateDirty();
        updateDeleted();
        cleardDeleted();
        clearDirty();
        clearNew();
    }
    public void updateNew(){
        Set<ActiveRecord> recordsSet=iterateHMapAndGetAllDomainObjects(newDomainObjects);

        for (Iterator<ActiveRecord> iterator = recordsSet.iterator(); iterator.hasNext();) {
            ActiveRecord next = iterator.next();
            if (next.isReadyToTransaction(next)) {
                next.insertDomainObject(next);
            }
        }
    }
    public void updateDirty(){

        Set<ActiveRecord> recordsSet=iterateHMapAndGetAllDomainObjects(dirtyDomainObjects);

        for (Iterator<ActiveRecord> iterator = recordsSet.iterator(); iterator.hasNext();) {
            ActiveRecord next = iterator.next();
            if (next.isReadyToTransaction(next)) {
                next.updateDomainObject(next);
            }
        }
    }
    public void updateDeleted(){
        Set<ActiveRecord> recordsSetDeleted=iterateHMapAndGetAllDomainObjects(deletedDomainObject);
        Set<ActiveRecord> recordsSetNew=iterateHMapAndGetAllDomainObjects(newDomainObjects);

        for (Iterator<ActiveRecord> iterator = recordsSetDeleted.iterator(); iterator.hasNext();) {
            ActiveRecord next = iterator.next();

            if (!recordsSetNew.contains(next)) {// если обеъект не является новым, то удаляем их БД

                next.deleteDomainObject(next);
            }
        }
    }

    private  Set<ActiveRecord>  iterateHMapAndGetAllDomainObjects(HashMap <String,ArrayList<ActiveRecord>>map) {
        Set<ActiveRecord> recordsSet=null;
        for (String s : map.keySet()) {
            ArrayList<ActiveRecord> activeRecords = map.get(s);
            recordsSet = Collections.newSetFromMap(new ConcurrentHashMap<ActiveRecord, Boolean>() {});
            recordsSet.addAll(activeRecords);
        }

        return recordsSet;
    }

}
