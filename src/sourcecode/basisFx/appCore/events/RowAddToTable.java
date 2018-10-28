package basisFx.appCore.events;

import basisFx.appCore.elements.AppNode;
import basisFx.appCore.elements.TableWrapper;
import basisFx.domain.ActiveRecord;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

public class RowAddToTable <T> extends AppEvent{

    private Button but;
    private TableWrapper tableWrapper;

    public RowAddToTable(TableWrapper tableWrapper ) {
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
            if (tableWrapper.isItemListExist() && !tableWrapper.haveNewItem()) {
                System.out.println("RowAddToTable.run---tableWrapper.isItemListExist() && !tableWrapper.haveNewItem()");
                    tableWrapper.getItems().add(newInstance);
                    tableWrapper.scrollToItem(newInstance);
                    tableWrapper.focusItem(newInstance);
            }else {
                System.err.println("RowAddToTable--!tableWrapper.isItemListExist() && tableWrapper.haveNewItem()".toUpperCase());
            }


        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }


}
