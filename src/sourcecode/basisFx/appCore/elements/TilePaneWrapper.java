/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.elements;

import basisFx.appCore.interfaces.ParentAnchorFetching;
import basisFx.appCore.settings.CSSID;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;

/**
 *
 * @author Alek
 */
public  class TilePaneWrapper<T> extends AppNode {


    TilePane tilePane;
    private double widthRelativeByParent;
    private double childrenAnchorHeight;

    public TilePaneWrapper(NodeBuilder builder) {

        this.element = new TilePane();

         element = (TilePane) this.element;

         tilePane =(TilePane) element;

        init(builder);


    }


    public TilePaneWrapper setChildrenAnchorSize(double widthRelativeByParent,double height){

        this.widthRelativeByParent=widthRelativeByParent;
        this.childrenAnchorHeight=height;

        return this;
    }



    public TilePaneWrapper childGenerator( ParentAnchorFetching parentAnchorFetching){


        AnchorPane anchorPane = (AnchorPane) NodeBuilder.create()
                .setId(CSSID.TILE_PANE_ANCHOR)
                .createAnchorPanelWrapper()
                .getElement();

        parentAnchorFetching.set(anchorPane);


        anchorPane.prefWidthProperty().bind(parentAnchor.widthProperty().multiply(widthRelativeByParent));
        anchorPane.prefHeight(childrenAnchorHeight);


        tilePane.getChildren().add(anchorPane);

        return this;
    }



}
