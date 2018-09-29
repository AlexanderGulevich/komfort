package basisFx.appCore.events;

import basisFx.dataSource.UnitOfWork;
import basisFx.appCore.elements.AppNode;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.interfaces.RowCreater;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

public class RowAddToTable <T> extends AppEvent{

    private TableView <T> table;
    private Button but;
    private final ObservableList list;
    protected RowCreater rowCreater;
    private TableWrapper tableWrapper;
    private   UnitOfWork unitOfWork;


    public RowAddToTable(TableWrapper tableWrapper, RowCreater rowCreater) {
        this.tableWrapper = tableWrapper;
        this.table= (TableView<T>) this.tableWrapper.getElement();
        this.list=this.table.getItems();
        this.rowCreater=rowCreater;
    }




    @Override
    public void setElement(AppNode node) {
        but=(Button) node.getElement();
        but.setOnMouseClicked((event) -> {
            run();
        });

    }


    @Override
    public void run() {

//        if(this.unitOfWork..isEmpty()){
//
//            if(tableWrapper.isObserver()&& tableWrapper.getClickedDomain()!=null){
//                rowCreater.createRow(list);
//
//            }
//            if (!tableWrapper.isObserver()){
//                rowCreater.createRow(list);
//            }
//
//
//        }else{
//
//        }



    }


}
