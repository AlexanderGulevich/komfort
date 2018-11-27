package basisFx.appCore.events;

import basisFx.appCore.elements.AppNode;
import basisFx.appCore.elements.TableWrapper;
import basisFx.domain.ActiveRecord;
import basisFx.service.ServiceAutoPushTableAndCommonDate;
import basisFx.service.ServiceTableAndCommonDate;
import javafx.scene.control.Button;

public class RowAddToSubmitTableWhisCommonDate<T> extends AppEvent{

    private Button but;
    private TableWrapper tableWrapper;

    public RowAddToSubmitTableWhisCommonDate(TableWrapper tableWrapper ) {
        this.tableWrapper = tableWrapper;
    }

    @Override
    public void setEventToElement(AppNode node) {
        but=(Button) node.getElement();
        but.setOnMouseClicked((event) -> {
            run();
        });
    }

    @Override
    public void run() {
        try {
            ActiveRecord newInstance = (ActiveRecord) tableWrapper.activeRecordClass.newInstance();
            if (tableWrapper.isItemListExist()
                    && ((ServiceAutoPushTableAndCommonDate) tableWrapper.getServiceMediator()).
                          getDatePickerWrapper().getDate()!=null) {
                    tableWrapper.getItems().add(newInstance);
                    tableWrapper.scrollToItem(newInstance);
                    tableWrapper.focusItem(newInstance);
            }else {
            }


        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }


}
