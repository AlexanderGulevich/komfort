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
            ObservableList<ActiveRecord> list = tableWrapper.list;
            ActiveRecord instance = (ActiveRecord) tableWrapper.activeRecordClass.newInstance();
            TableView tableView=tableWrapper.getElement();
            ObservableList items = tableView.getItems();
            if (items != null) {
                items.add(instance);
            }

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }


}
