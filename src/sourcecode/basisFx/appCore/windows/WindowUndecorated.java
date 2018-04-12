package basisFx.appCore.windows;

import basisFx.appCore.panels.AbstractPanel;
import basisFx.appCore.utils.Coordinate;
import basisFx.appCore.registry.Layers;
import basisFx.domainModel.settings.CSSID;
import basisFx.domainModel.settings.FontsStore;
import basisFx.appCore.elements.AppNode;
import basisFx.appCore.elements.ButtonWrapper;
import basisFx.domainModel.settings.TopButtons;
import javafx.geometry.Insets;
import javafx.scene.control.ContentDisplay;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author 62
 */
public class WindowUndecorated extends WindowFx{
    
    private ButtonWrapper  hideButton;
    private boolean isManeWindow=false;
    private ButtonWrapper  maximazeButton;
    private ButtonWrapper  closingButton;


    public WindowUndecorated(double w,double h, Stage primaryStage) {
        this.stage=primaryStage;
        setTransparentRoot();
        setVisibleRoot();
        this.isManeWindow=true;
          
        this.width=w;
        this.height=h;
        this.stage.initStyle(StageStyle.UNDECORATED);
    }

    public WindowUndecorated(double w,double h) {
         this.stage=new Stage();
        setTransparentRoot();
        setVisibleRoot();
        this.width=w;
        this.height=h;
       
        
    }
    
    public WindowUndecorated setTitle(AbstracttTitle t){
        t.init();
        return this;
        
        
    }

   
    public WindowUndecorated setIconAnchor(Coordinate c, AnchorPane p) {
        AppNode.NodeBuilder.create()
                .setCoordinate(c)
                .setParent(p)
                .setId(CSSID.IMG_ICON)
                .createAnchorPanelWrapper()
                .getElement();
        return this;
        
    }
    
    public WindowUndecorated setTextIcon(AnchorPane parent, Coordinate c, FontsStore f, Double fHeight, String tIcn){
        AppNode.NodeBuilder.create()
                 .setCoordinate(c)
                 .setParent(parent)
                 .setFont(f, fHeight)
                 .setId(CSSID.TEXT_ICON_ANCHOR)
                 .setText(tIcn)
                 .createNText();

        return this;
    }

    void initControlTopButton() {
        
        double fontHeight=TopButtons.FONT_HEIGHT;
        double topMatgin=TopButtons.TOP_MARGIN;
        double height=TopButtons.FONT_HEIGHT;
        double width=TopButtons.BUTTON_WIDTH;
        Insets padding=TopButtons.PADDING;
        FontsStore fs=TopButtons.FONT_STORE;
        String closeStr=TopButtons.CLOSE_String;
        String hideStr=TopButtons.HIDE_String;
        String maximazeStr=TopButtons.MAXIMAZE_String;
        
         //крестик
         closingButton= AppNode.NodeBuilder.create().
                setFont(fs, fontHeight).
                setSize(width,height).
                setPadding(padding).
                setCoordinate(topMatgin, 0d, null, null).
                setId(CSSID.TOP_CONTROL_BUTTON).setParent(Layers.getTitlePanel()).
                setStage(stage).
                setEvent(eventFactory.createClosingWindowEvent()).
                createNButton().
                setString(closeStr, ContentDisplay.CENTER);


         hideButton= AppNode.NodeBuilder.create().
                 setFont(fs, fontHeight).
                 setEvent(eventFactory.createHidingWindowEvent()).
                 setSize(width,height).
                 setPadding(padding).
                 setCoordinate(topMatgin, width+width, null, null).
                 setId(CSSID.TOP_CONTROL_BUTTON).setParent(Layers.getTitlePanel()).
                 setStage(stage).
                 createNButton().
                 setString(hideStr, ContentDisplay.CENTER);
         
       
         maximazeButton= AppNode.NodeBuilder.create().
                setFont(fs, fontHeight).
                setEvent(eventFactory.createMaximazingSwitcher()).
                setSize(width,height).
                setPadding(padding).
                setCoordinate(topMatgin, width, null, null).
                setId(CSSID.TOP_CONTROL_BUTTON).setParent(Layers.getTitlePanel()).
                setStage(stage).
                createNButton().
                setString(maximazeStr, ContentDisplay.CENTER);
    }

      private void setTransparentRoot(){
                 this.root=(AnchorPane) AppNode.NodeBuilder.create()
                         .setId(CSSID.TRANSPARENT_ROOT)
                         .setStage(stage)
                         .setInsects(new Insets(3d, 3d, 3d, 3d))
                         .createAnchorPanelWrapper()
                         .getElement();
                 
                Layers.setTransparentRoot(root);
     }
      private void setVisibleRoot(){
                 this.visibleRoot=(AnchorPane) AppNode.NodeBuilder.create()
                         .setCoordinate(root, 0d, 0d, 0d, 0d)
                         .setId(CSSID.VISIBLE_ROOT)
                         .setStage(stage)
//                         .setDropShadow(new DropShadow())
                         .createAnchorPanelWrapper()
                         .getElement();
                 
                 Layers.setVisibleRoot(visibleRoot);
     }
      public WindowUndecorated setPanel(AbstractPanel p){
          p.setStage(stage);
          p.init();
          if(this.isManeWindow)   {p.register();}   
          return this;
     }
      public WindowFx windowShow(){
            
            windowInit();
            
            scene.setFill( Color.TRANSPARENT);
            stage.initStyle(StageStyle.TRANSPARENT);
            
            initControlTopButton();
            stage.show();
            return this;

     }

  
     
   
     

    
    
   
    
}

    