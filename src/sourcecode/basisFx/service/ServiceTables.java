package basisFx.service;

import basisFx.appCore.elements.AppNode;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.interfaces.CallBack;
import basisFx.appCore.utils.Range;
import basisFx.appCore.activeRecord.ActiveRecord;
import javafx.collections.ObservableList;
import lombok.Setter;

import java.time.LocalDate;

public abstract class ServiceTables implements Mediator{

    @Setter
    protected CallBack refreshCallBack;
    public abstract void wasRemoved(AppNode node, ActiveRecord record);
    public abstract void wasChanged(AppNode node, ActiveRecord record);
    public abstract void refresh(AppNode node);
    public abstract void initElements();

    protected void commit(TableWrapper tableWrapper) {
            boolean isCommitted = tableWrapper.unitOfWork.commit();
            if (isCommitted) {
                tableWrapper.getMediator().refresh(tableWrapper);
            }
    }
    public  void setItems(TableWrapper tableWrapper, ObservableList<ActiveRecord> list ) {
        tableWrapper.setItems(list);
    }


    public void refreshByOuterId(TableWrapper tableWrapper, int idFromPrimeTable) {
        setItems(
                tableWrapper,
                tableWrapper.activeRecord.findAllByOuterId(idFromPrimeTable)
        );
    }
    public void refreshViaRangeAndOuterId(TableWrapper tableWrapper, int idFromPrimeTable, Range range) {
        setItems(
                tableWrapper,
                tableWrapper.activeRecord.findAllByOuterIdAndRange(
                        idFromPrimeTable,
                        range
                )


        );
    }
    public void refreshViaRange(TableWrapper tableWrapper,   Range range) {
        setItems(
                tableWrapper,
                tableWrapper.activeRecord.findAllByRange(
                        range
                )


        );
    }
    public void refreshViaPeriodAndOuterId(TableWrapper tableWrapper, int idFromPrimeTable,LocalDate start ,LocalDate end) {
        setItems(
                tableWrapper,
                tableWrapper.activeRecord.findAllByOuterIdAndPeriod(
                        idFromPrimeTable,
                        start,
                        end
                )


        );
    }

}
