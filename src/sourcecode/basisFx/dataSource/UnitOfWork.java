
package basisFx.dataSource;
import basisFx.domain.ActiveRecord;

import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class UnitOfWork {

    public HashMap <String,ArrayList<ActiveRecord>>      newDomainObjects=new HashMap<>();
    public HashMap <String,ArrayList<ActiveRecord>>      dirtyDomainObjects=new HashMap<>();
    public HashMap <String,ArrayList<ActiveRecord>>      deletedDomainObject=new HashMap<>();

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
    public void registercDeleted(String activeRecordName, ActiveRecord record){
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
        commitNew();
        commitDirty();
        commitDeleted();
        cleardDeleted();
        clearDirty();
        clearNew();
    }
    public void commitNew(){
        Set<ActiveRecord> recordsSet=iterateHMapAndGetAllDomainObjects(newDomainObjects);

        for (Iterator<ActiveRecord> iterator = recordsSet.iterator(); iterator.hasNext();) {
            ActiveRecord next = iterator.next();
            if (next.isReadyToTransaction()) {
                System.out.println("UnitOfWork.commitNew----ReadyToTransaction");
                next.insert();
            }
        }
    }
    public void commitDirty(){

        Set<ActiveRecord> recordsSet=iterateHMapAndGetAllDomainObjects(dirtyDomainObjects);

        for (Iterator<ActiveRecord> iterator = recordsSet.iterator(); iterator.hasNext();) {
            ActiveRecord next = iterator.next();
            if (next.isReadyToTransaction()) {
                System.out.println("UnitOfWork.commitDirty----ReadyToTransaction");
                next.update();
            }
        }
    }
    public void commitDeleted(){
        Set<ActiveRecord> recordsSetDeleted=iterateHMapAndGetAllDomainObjects(deletedDomainObject);
        Set<ActiveRecord> recordsSetNew=iterateHMapAndGetAllDomainObjects(newDomainObjects);

        for (Iterator<ActiveRecord> iterator = recordsSetDeleted.iterator(); iterator.hasNext();) {
            ActiveRecord next = iterator.next();

            if (!recordsSetNew.contains(next)) {// если обеъект не является новым, то удаляем их БД

                next.delete();
            }
        }
    }

    private  Set<ActiveRecord>  iterateHMapAndGetAllDomainObjects(HashMap <String,ArrayList<ActiveRecord>>map) {
        Set<ActiveRecord> recordsSet = Collections.newSetFromMap(new ConcurrentHashMap<ActiveRecord, Boolean>() {});

        for (String s : map.keySet()) {
            ArrayList<ActiveRecord> activeRecords = map.get(s);
            recordsSet.addAll(activeRecords);
        }

        return recordsSet;
    }

}
