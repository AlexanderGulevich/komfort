package basisFx.appCore.events;

import basisFx.dataSource.UnitOfWork;
import basisFx.appCore.elements.AppNode;
import basisFx.appCore.elements.TableWrapper;
import basisFx.domain.domaine.ActiveRecord;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

import java.sql.SQLException;

public class RowDeleteFromTable extends AppEvent{

    private TableView <ActiveRecord>  table;
    private Button but;
    private final ObservableList list;
    private TableWrapper tableWrapper;
    private   UnitOfWork unitOfWork;

    public RowDeleteFromTable(TableWrapper t) {
        this.tableWrapper = t;
        this.table= (TableView<ActiveRecord>) this.tableWrapper.getElement();
        this.list=this.table.getItems();
    }

    @Override
    public void setElement(AppNode node) {
        but=(Button) node.getElement();
        but.setOnMouseClicked((event) -> {
            try {
                run();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

    }


    @Override
    public void run() throws SQLException {

        TableView.TableViewSelectionModel<ActiveRecord> selectionModel = table.getSelectionModel();

        if(!selectionModel.isEmpty()){


            final ActiveRecord selectedItem = selectionModel.getSelectedItem();

            this.list.remove(selectedItem);
            this.unitOfWork.registercDeletedDomainObject(selectedItem.entityName,selectedItem);

        }



    }


}
