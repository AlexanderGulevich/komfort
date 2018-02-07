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
import basisFx.domainModel.settings.IMGpath;
import basisFx.domainModel.settings.Settings;
import basisFx.domainModel.settings.TopButtons;
import basisFx.domainModel.settings.WindowsTitlesNames;
import javafx.geometry.Insets;
import javafx.scene.control.ContentDisplay;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author 62
 */
public class WindowUndecorated extends WindowFx{
    
    private NButton  hideButton;
    private NButton  maximazeButton;
    private NButton  closingButton;
    private NText title;
    private Text textIcon;
    private NImgView  imageViewIcon;
    private NAnchor  imageViewTitle;
    public static enum TITLE_VIEW{IMG,TEXT};
    public  TITLE_VIEW titleView=TITLE_VIEW.IMG;
    

    public WindowUndecorated(double w,double h, Stage primaryStage) {
        this.stage=primaryStage;
        setTransparentRoot();
        setVisibleRoot();
        
          
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
    
    public WindowUndecorated setKindOfTitle(TITLE_VIEW tw){
    
        this.titleView=tw;
        return this;
        
    }

    void initIcon() {
  
             imageViewIcon=AppNode.NodeBuilder.create()
                .setCoordinate(titlePanel, 5d, null, null, 5d)
                .setSize(15d, 15d)
                .setStage(stage)
                .createNImgView()
                .setImg(IMGpath.ICONTOOP);
  
    }
    
    public WindowUndecorated setTextIcon(AnchorCoordinate c,FontsStore f, Double fHeight,String tIcn){
        textIcon=(Text) AppNode.NodeBuilder.create()
                 .setCoordinate(c)
                 .setParent(titlePanel)
                 .setFont(f, fHeight)
                 .setId(CSSID.ROOT_TEXT_ICON)
                 .setText(tIcn)
                 .createNText().getElement();
        
    
        return this;
    }

    @Override
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
                setId(CSSID.TOP_CONTROL_BUTTON).setParent(titlePanel).
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
                 setId(CSSID.TOP_CONTROL_BUTTON).setParent(titlePanel).
                 setStage(stage).
                 createNButton().
                 setString(hideStr, ContentDisplay.CENTER);
         
       
         maximazeButton= AppNode.NodeBuilder.create().
                setFont(fs, fontHeight).
                setEvent(AppEvent.createMaximazingSwitcher()).
                setSize(width,height).
                setPadding(padding).
                setCoordinate(topMatgin, width, null, null).
                setId(CSSID.TOP_CONTROL_BUTTON).setParent(titlePanel).
                setStage(stage).
                createNButton().
                setString(maximazeStr, ContentDisplay.CENTER);
         
         
                
       
       
    }

    @Override
    void initTitle() {
        
        if (this.titleView==TITLE_VIEW.TEXT) {
            
            title=AppNode.NodeBuilder.create()
                    .setParent(titlePanel)
                    .setCoordinate(titleNameCoordinate)
                    .setFont(Settings.MAIN_TITLE_FONT, Settings.MAIN_TITLE_HEIGHT)
                    .setId(CSSID.TITLE_WINDOW_TEXT)
                    .setText(WindowsTitlesNames.MAIN_WINDOW_NAME)
                    .createNText();
        }
        
        if (this.titleView==TITLE_VIEW.IMG) {
        
            imageViewTitle=AppNode.NodeBuilder.create()
                    .setParent(titlePanel)
                    .setCoordinate(titleNameCoordinate)
                    .setId(CSSID.TITLE_WINDOW_IMG)
                    .setWidth(140d)
                    .setHeight(32d)
                    .createNpAnchor();
        }
          

    }

    @Override
    public WindowUndecorated setContentLayer(double t,double r,double b,double l) {
      
        this.contentLauer=(AnchorPane) AppNode.NodeBuilder.create()
               .setCoordinate(visibleRoot, t, r, b, l)
               .setId(CSSID.MAIN_CONTENT_ANCHOR)
               .setStage(stage)
               .createNpAnchor().getElement();
        
        Layers.setContentLayer(contentLauer);
       
       
       
       
       return this;
    }
    


    
    
   
    
}

    