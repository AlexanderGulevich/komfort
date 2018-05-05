package basisFx.appCore.grid;

import basisFx.appCore.controls.ScretchedTableGrid;
import basisFx.appCore.elements.AppNode;
import basisFx.appCore.elements.LabelWrapper;
import basisFx.appCore.interfaces.MaximazingObserver;
import basisFx.appCore.obseverved.MaximazingManager;
import basisFx.appCore.settings.CSSID;
import basisFx.appCore.settings.FontsStore;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;


public class SingleTableGrid extends ScretchedTableGrid implements MaximazingObserver {
    
    private Insets insets=new Insets(3,3,3,3);
    private LabelWrapper label;
    private Button buttonAdd;
    private Button buttonDel;
    private Button buttonAddLittle;
    private Button buttonDelLittle;


    @Override
    public void init() {

        MaximazingManager.setObserver(this);

         label = textFabric.createLabel(title, FontsStore.ROBOTO_LIGHT, Pos.BASELINE_LEFT, 25d);


         if (observers.isEmpty()){
             tableWrapper= AppNode.NodeBuilder.create()
                     .setId(CSSID.TABLE)
                     .setEditCreater(()-> {return editFabric.createDefaultEditCommit();})
                     .createTableViewWrapper()
                     .setDataMapper(dataMapper)
                     .setEditable(true)
                     .setColums(columnWrappers)
                     .refresh();

         }
         else{
            tableWrapper= AppNode.NodeBuilder.create()
                    .setId(CSSID.TABLE)
                    .setEditCreater(()-> {return editFabric.createDefaultEditCommit();})
                    .createTableViewWrapper()
                    .setDataMapper(dataMapper)
                    .setEditable(true)
                    .setBoundTable(observers.get(0))
                    .setColums(columnWrappers)
                    .refresh();

        }


         tableView= tableWrapper.getTable();


         buttonAdd = buttonFactory.addRowButton(tableWrapper, domainClass);
         buttonDel =buttonFactory.deleteRowButton(tableWrapper);
         buttonAddLittle = buttonFactory.littleRowAddButton(tableWrapper,domainClass );
         buttonDelLittle =buttonFactory.littleRowDeleteButton(tableWrapper ) ;



        if (coordinate != null&& parentAnchorPane!=null) {
            gridPaneWrapper = AppNode.NodeBuilder.create()
                    .setCoordinate(coordinate)
                    .setParent(parentAnchorPane)
                    .createGridPaneWrapper();
        }else{
            gridPaneWrapper = AppNode.NodeBuilder.create()
                    .createGridPaneWrapper();
        }




        gridPane= (GridPane) gridPaneWrapper.getElement();



        gridPane.heightProperty().addListener((obs, oldVal, newVal) -> {


        tableView.setPrefHeight(gridPane.getHeight());

//            To listen to both width and height changes, the same listener can be used really simply:

//            ChangeListener<Number> stageSizeListener = (observable, oldValue, newValue) ->
//                    System.out.println("Height: " + stage.getHeight() + " Width: " + stage.getWidth());
//
//            stage.widthProperty().addListener(stageSizeListener);
//            stage.heightProperty().addListener(stageSizeListener);

        });




        organize();


    }


    private void organize(){

        switch (tablesButtonKind){

            case Right_little:
                gridPaneWrapper.setColumnComputerWidth();
                gridPaneWrapper.setColumn();
                gridPaneWrapper.setColumn();

                gridPaneWrapper.addSpanNode(
                        label.getElement(),
                        0,0,3,1, HPos.LEFT, VPos.TOP,insets);
                gridPaneWrapper.addSpanNode(
                        buttonAddLittle,
                        2,1,1,1,HPos.CENTER, VPos.TOP,insets);
                gridPaneWrapper.addSpanNode(
                        buttonDelLittle,
                        2,2,1,1,HPos.CENTER, VPos.TOP,insets);
                gridPaneWrapper.addSpanNode(
                        tableWrapper.getElement(),
                        0,1,2,2,HPos.CENTER, VPos.TOP,insets);
                break;

            case TOP_right_little:
                gridPaneWrapper.setColumnComputerWidth();
                gridPaneWrapper.setColumn();
                gridPaneWrapper.setColumn();

                gridPaneWrapper.addSpanNode(
                        label.getElement(),
                        0,0,1,1, HPos.LEFT, VPos.TOP,insets);
                gridPaneWrapper.addSpanNode(
                        buttonAddLittle,
                        2,0,1,1,HPos.RIGHT, VPos.TOP,insets);
                gridPaneWrapper.addSpanNode(
                        buttonDelLittle,
                        1,0,1,1,HPos.RIGHT, VPos.TOP,insets);
                gridPaneWrapper.addSpanNode(
                        tableWrapper.getElement(),
                        0,1,3,2,HPos.CENTER, VPos.TOP,insets);
                break;

            case Bottom_right_little:
                gridPaneWrapper.setColumnComputerWidth();
                gridPaneWrapper.setColumn();
                gridPaneWrapper.setColumn();

                gridPaneWrapper.addSpanNode(
                        label.getElement(),
                        0,0,3,1, HPos.LEFT, VPos.TOP,insets);
                gridPaneWrapper.addSpanNode(
                        buttonAddLittle,
                        2,2,1,1,HPos.RIGHT, VPos.TOP,insets);
                gridPaneWrapper.addSpanNode(
                        buttonDelLittle,
                        1,2,1,1,HPos.RIGHT, VPos.TOP,insets);
                gridPaneWrapper.addSpanNode(
                        tableWrapper.getElement(),
                        0,1,3,1,HPos.CENTER, VPos.TOP,insets);
                break;

            case Bottom_right:
                gridPaneWrapper.setColumnComputerWidth();
                gridPaneWrapper.setColumn();
                gridPaneWrapper.setColumn();

                gridPaneWrapper.addSpanNode(
                        label.getElement(),
                        0,0,3,1, HPos.LEFT, VPos.TOP,insets);
                gridPaneWrapper.addSpanNode(
                        buttonAdd,
                        2,2,1,1,HPos.RIGHT, VPos.TOP,insets);
                gridPaneWrapper.addSpanNode(
                        buttonDel,
                        1,2,1,1,HPos.RIGHT, VPos.TOP,insets);
                gridPaneWrapper.addSpanNode(
                        tableWrapper.getElement(),
                        0,1,3,1,HPos.CENTER, VPos.TOP,insets);
                break;

            case TOP_right:
                gridPaneWrapper.setColumnComputerWidth();
                gridPaneWrapper.setColumn();
                gridPaneWrapper.setColumn();

                gridPaneWrapper.addSpanNode(
                        label.getElement(),
                        0,0,1,1, HPos.LEFT, VPos.TOP,insets);
                gridPaneWrapper.addSpanNode(
                        buttonAdd,
                        2,0,1,1,HPos.RIGHT, VPos.TOP,insets);
                gridPaneWrapper.addSpanNode(
                        buttonDel,
                        1,0,1,1,HPos.RIGHT, VPos.TOP,insets);
                gridPaneWrapper.addSpanNode(
                        tableWrapper.getElement(),
                        0,1,3,2,HPos.CENTER, VPos.TOP,insets);
                break;


            case Right:
                gridPaneWrapper.setColumnComputerWidth();
                gridPaneWrapper.setColumn();
                gridPaneWrapper.setColumn();

                gridPaneWrapper.addSpanNode(
                        label.getElement(),
                        0,0,3,1, HPos.LEFT, VPos.TOP,insets);
                gridPaneWrapper.addSpanNode(
                        buttonAdd,
                        2,1,1,1,HPos.CENTER, VPos.TOP,insets);
                gridPaneWrapper.addSpanNode(
                        buttonDel,
                        2,2,1,1,HPos.CENTER, VPos.TOP,insets);
                gridPaneWrapper.addSpanNode(
                        tableWrapper.getElement(),
                        0,1,2,2,HPos.CENTER, VPos.TOP,insets);
                break;

        }


    }

    @Override
    public void pervormMaximazing() {

   // по сути отпала необходимость использования данной конструкции так как выше добавил listener к height poroperty

        System.out.println("ОКНО УВЕЛИЧЕНО");

    }
}
