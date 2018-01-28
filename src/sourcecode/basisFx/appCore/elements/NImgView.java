/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.elements;

import basisFx.appCustomLogic.settings.IMGpath;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Alek
 */
public class NImgView <T extends Node> extends AppNode{

    
    private ImageView imgView;
    private Image img;

    NImgView(NodeBuilder builder) {
        
        element=new ImageView();
        init(builder);
       
     
    }
   
        
    public NImgView setImg(IMGpath path){
       this.img=new Image(path.get());
       
       ImageView element=(ImageView) this.element;
      
       element.setImage(this.img);
       element.setFitHeight(width);
       element.setFitWidth(height);
       return this;
    }
    
}
