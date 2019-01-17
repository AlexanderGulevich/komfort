package basisFx.appCore.events;

import basisFx.appCore.elements.AppNode;
import basisFx.appCore.elements.TableWrapper;
import basisFx.domain.ActiveRecord;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

public class RowDeleteFromTable extends AppEvent{
    private Button but;
    private TableWrapper tableWrapper;

    public RowDeleteFromTable(TableWrapper t) {
        this.tableWrapper = t;
    }

    @Override
    public void setEventToElement(AppNode node) {
        but=(Button) node.getElement();
        but.setOnMouseClicked((event) -> {

                run();

        });

    }

    @Override
    public void setEventToElement(Node node) {
        but=(Button) node;
        but.setOnMouseClicked((event) -> {

            run();

        });
    }


    @Override
    public void run()   {

        TableView.TableViewSelectionModel<ActiveRecord> selectionModel = tableWrapper.getElement().getSelectionModel();

        if(!selectionModel.isEmpty()){

            final ActiveRecord selectedItem = selectionModel.getSelectedItem();
            if (selectedItem != null) {
                tableWrapper.getItems().remove(selectedItem);
                tableWrapper.getServiceTables().wasRemoved(tableWrapper,selectedItem);
            }


        }



    }


}
