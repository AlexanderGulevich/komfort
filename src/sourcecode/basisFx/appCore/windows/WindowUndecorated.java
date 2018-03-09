package basisFx.appCore.windows;

import basisFx.appCore.AnchorCoordinate;
import basisFx.appCore.registry.Layers;
import basisFx.domainModel.settings.CSSID;
import basisFx.domainModel.settings.FontsStore;
import basisFx.appCore.elements.AppNode;
import basisFx.appCore.elements.NAnchor;
import basisFx.appCore.elements.NButton;
import basisFx.appCore.elements.NImgView;
import basisFx.appCore.elements.NText;
import basisFx.appCore.events.AppEvent;
import basisFx.domainModel.settings.TopButtons;
import javafx.geometry.Insets;
import javafx.scene.control.ContentDisplay;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author 62
 */
public class WindowUndecorated extends WindowFx{
    
    private NButton  hideButton;
    private boolean isManeWindow=false;
    private NButton  maximazeButton;
    private NButton  closingButton;
    private NText title;
    private Text textIcon;
    private NImgView  imageViewIcon;
    private NAnchor  imageViewTitle;

    

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

    @Override
    void initIcon() {
  
//             imageViewIcon=AppNode.NodeBuilder.create()
//                .setCoordinate(titlePanel, 5d, null, null, 5d)
//                .setSize(15d, 15d)
//                .setStage(stage)
//                .createNImgView()
//                .setImg(IMGpath.ICONTOOP);
  
    }
    
    public WindowUndecorated setTextIcon(AnchorCoordinate c,FontsStore f, Double fHeight,String tIcn){
        textIcon=(Text) AppNode.NodeBuilder.create()
                 .setCoordinate(c)
                 .setParent(Layers.getTitlePanel())
                 .setFont(f, fHeight)
                 .setId(CSSID.ROOT_TEXT_ICON)
                 .setText(tIcn)
                 .createNText().getElement();
        
    
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
                setEvent(AppEvent.createClosingWindowEvent()).
                createNButton().
                setString(closeStr, ContentDisplay.CENTER);


         hideButton= AppNode.NodeBuilder.create().
                 setFont(fs, fontHeight).
                 setEvent(AppEvent.createHidingWindowEvent()).
                 setSize(width,height).
                 setPadding(padding).
                 setCoordinate(topMatgin, width+width, null, null).
                 setId(CSSID.TOP_CONTROL_BUTTON).setParent(Layers.getTitlePanel()).
                 setStage(stage).
                 createNButton().
                 setString(hideStr, ContentDisplay.CENTER);
         
       
         maximazeButton= AppNode.NodeBuilder.create().
                setFont(fs, fontHeight).
                setEvent(AppEvent.createMaximazingSwitcher()).
                setSize(width,height).
                setPadding(padding).
                setCoordinate(topMatgin, width, null, null).
                setId(CSSID.TOP_CONTROL_BUTTON).setParent(Layers.getTitlePanel()).
                setStage(stage).
                createNButton().
                setString(maximazeStr, ContentDisplay.CENTER);
    }

    void initTitle() {}

    
      private void setTransparentRoot(){
                 this.root=(AnchorPane) AppNode.NodeBuilder.create()
                         .setId(CSSID.TRANSPARENT_ROOT)
                         .setStage(stage)
                         .setInsects(new Insets(3d, 3d, 3d, 3d))
                         .createNpAnchor()
                         .getElement();
                 
                Layers.setTransparentRoot(root);
     }
      private void setVisibleRoot(){
                 this.visibleRoot=(AnchorPane) AppNode.NodeBuilder.create()
                         .setCoordinate(root, 0d, 0d, 0d, 0d)
                         .setId(CSSID.VISIBLE_ROOT)
                         .setStage(stage)
//                         .setDropShadow(new DropShadow())
                         .createNpAnchor()
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

    