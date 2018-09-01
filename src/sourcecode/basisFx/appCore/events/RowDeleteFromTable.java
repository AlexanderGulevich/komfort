///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package basisFx.appCore.events;
//
//import basisFx.dataSource.UnitOfWork;
//import basisFx.appCore.elements.AppNode;
//import basisFx.appCore.elements.TableWrapper;
//import basisFx.appCore.domainScetch.DomainObject;
//import javafx.collections.ObservableList;
//import javafx.scene.control.Button;
//import javafx.scene.control.TableView;
//
//import java.sql.SQLException;
//
///**
// *
// * @author Alek
// */
//public class RowDeleteFromTable extends AppEvent{
//
//    private TableView <DomainObject>  table;
//    private Button but;
//    private final ObservableList list;
//    private TableWrapper tableWrapper;
//    private   UnitOfWork unitOfWork;
//
//
//
//    @SuppressWarnings("unchecked")
//    public RowDeleteFromTable(TableWrapper t) {
//        this.tableWrapper = t;
//        this.table= (TableView<DomainObject>) this.tableWrapper.getElement();
//        this.list=this.table.getItems();
//        this.unitOfWork = this.tableWrapper.getUnitOfWork();
//    }
//
//
//
//
//    @Override
//    public void setElement(AppNode node) {
//        but=(Button) node.getElement();
//        but.setOnMouseClicked((event) -> {
//            try {
//                run();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        });
//
//    }
//
//
//    @Override
//    public void run() throws SQLException {
//
//        TableView.TableViewSelectionModel<DomainObject> selectionModel = table.getSelectionModel();
//
//        if(!selectionModel.isEmpty()){
//
//
//            final DomainObject selectedItem = selectionModel.getSelectedItem();
//
//            this.list.remove(selectedItem);
//            this.unitOfWork.setRemovedPojoes(selectedItem);
//            this.unitOfWork.commitRemoved();
//            System.out.println("удаление строки в таблице");
//
//            if (this.unitOfWork.getNewPojoes().contains(selectedItem)){
//                this.unitOfWork.clearNewPojoesList();
//                System.out.println("так как строка является новым доменным обхектом, то удаляют из списка новых");
//            }
//
//
//
//
//
//
//
//        }
//
//
//
//    }
//
//
//}
