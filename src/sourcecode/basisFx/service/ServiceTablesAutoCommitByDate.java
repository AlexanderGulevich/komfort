package basisFx.service;

import basisFx.appCore.elements.AppNode;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.interfaces.DataStoreCallBack;
import basisFx.appCore.interfaces.RecordWithDate;
import basisFx.appCore.utils.DateGetter;
import basisFx.dataSource.UnitOfWork;
import basisFx.appCore.activeRecord.ActiveRecord;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lombok.Setter;
import java.time.LocalDate;

public class ServiceTablesAutoCommitByDate extends ServiceTables {
    private TableWrapper tableWrapper;
    @Setter
    public DataStoreCallBack dataStoreCallBack;
    @Setter
    private DateGetter dateGetter;

    @Override
    public void inform(Object node) {
        if (node==dateGetter){
            initElements();
        }
    }

    @Override
    public void wasRemoved(AppNode node, ActiveRecord record) {
        UnitOfWork unitOfWork = ((TableWrapper) node).unitOfWork;
        boolean newDomane = ActiveRecord.isNewDomane(record);
        if (!newDomane) {
            unitOfWork.registercDeleted(record);
            commit(tableWrapper);
        }
    }

    @Override
    public void wasChanged(AppNode node, ActiveRecord record) {
        UnitOfWork unitOfWork = ((TableWrapper) node).unitOfWork;
        LocalDate date = dateGetter.getDate();
        ((RecordWithDate) record).setDate(date);
        boolean readyToTransaction = record.isReadyToTransaction();
        if (dataStoreCallBack != null) {
            if (dataStoreCallBack.check(record)) {
                write(record, unitOfWork, readyToTransaction);
            }
        }else {
            write(record, unitOfWork, readyToTransaction);
        }

    }

    private void write(ActiveRecord record, UnitOfWork unitOfWork, boolean readyToTransaction) {
        if (readyToTransaction) {
            boolean newDomane = ActiveRecord.isNewDomane(record);
            if (newDomane) {
                unitOfWork.registerNew(record);
            }else{
                unitOfWork.registercDirty(record);
            }
            commit(tableWrapper);
        }
    }

    @Override
    public void refresh(AppNode node) {
        initElements();
    }

    @Override
    public void initElements() {
        LocalDate date = dateGetter.getDate();
        if (date != null) {
            ObservableList <ActiveRecord> list=tableWrapper.activeRecord.getAllByDate(date);
            if (list == null) {
                list=FXCollections.observableArrayList();
            }
            tableWrapper.setItems(list);
        }

    }

    public void setTableWrapper(TableWrapper tableWrapper) {
        this.tableWrapper = tableWrapper;
    }


}
