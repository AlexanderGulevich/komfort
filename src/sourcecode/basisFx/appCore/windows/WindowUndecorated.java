package basisFx.appCore.windows;

import basisFx.appCore.AnchorCoordinate;
import basisFx.appCore.registry.Layers;
import basisFx.domainModel.settings.CSSID;
import basisFx.domainModel.settings.FontsStore;
import basisFx.appCore.elements.AppNode;
import basisFx.appCore.elements.NButton;
import basisFx.appCore.elements.NImgView;
import basisFx.appCore.elements.NText;
import basisFx.appCore.events.AppEvent;
import basisFx.appCore.menu.MenuRepresent;
import basisFx.appCore.menu.MenuSketchUtils;
import basisFx.appCore.menu.MenuCreator;
import basisFx.domainModel.settings.IMGpath;
import basisFx.domainModel.settings.Settings;
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
    
    private NButton  minimaze;
    private NButton  maximaze;
    private NButton  closing;
    private NText title;
    private Text textIcon;
    private NImgView  imageViewIcon;
    
    
    

    public WindowUndecorated(double w,double h, Stage primaryStage) {
        this.stage=primaryStage;
        createTransparentRoot();
        createInerRoot();
          
        this.width=w;
        this.height=h;
        this.stage.initStyle(StageStyle.UNDECORATED);
    }

    public WindowUndecorated(double w,double h) {
         this.stage=new Stage();
        createTransparentRoot();
        createInerRoot();
        this.width=w;
        this.height=h;
       
        
    }
    

    void initIcon() {

        imageViewIcon=AppNode.NodeBuilder.create()
                .setCoordinate(innerRoot, 5d, null, null, 5d)
                .setSize(15d, 15d)
                .setStage(stage)
                .createNImgView()
                .setImg(IMGpath.ICONTOOP);

   
        
                
                
       
    }
    
    public WindowUndecorated setTextIcon(AnchorCoordinate c,FontsStore f, Double fHeight,String tIcn){
        textIcon=(Text) AppNode.NodeBuilder.create()
                 .setCoordinate(c)
                 .setParentAnchor(innerRoot)
                 .setFont(f, fHeight)
                 .setId(CSSID.ROOT_TEXT_ICON)
                 .setText(tIcn)
                 .createNText().getElement();
        
    
        return this;
    }

    @Override
    void initControlTopButton() {
        
        double fontHeight=15d;
        double topMatgin=0d;
        double height=25d;
        double width=25d;
        Insets padding=new Insets(0d, 0d, 0d, 0d);
        
        
         //крестик
         closing= AppNode.NodeBuilder.create().
                setFont(FontsStore.FAWESOME5SOLID, fontHeight).
                setSize(width,height).
                setPadding(padding).
                setCoordinate(topMatgin, 0d, null, null).
                setId(CSSID.TOP_CONTROL_BUTTON).
                setParentAnchor(innerRoot).
                setStage(stage).
                setEvent(AppEvent.createClosingWindowEvent()).
                createNButton().
                setString("", ContentDisplay.CENTER);


         minimaze= AppNode.NodeBuilder.create().
                 setFont(FontsStore.FAWESOME5SOLID, fontHeight).
                 setEvent(AppEvent.createHidingWindowEvent()).
                 setSize(width,height).
                 setPadding(padding).
                 setCoordinate(topMatgin, width+width, null, null).
                 setId(CSSID.TOP_CONTROL_BUTTON).
                 setParentAnchor(innerRoot).
                 setStage(stage).
                 createNButton().
                 setString("", ContentDisplay.CENTER);
         
       
         maximaze= AppNode.NodeBuilder.create().
                setFont(FontsStore.FAWESOME5SOLID, fontHeight).
                setEvent(AppEvent.createMaximazingSwitcher()).
                setSize(width,height).
                setPadding(padding).
                setCoordinate(topMatgin, width, null, null).
                setId(CSSID.TOP_CONTROL_BUTTON).
                setParentAnchor(innerRoot).
                setStage(stage).
                createNButton().
                setString("", ContentDisplay.CENTER);
         
         
                
       
       
    }

    @Override
    void initTitle() {
        
        title=AppNode.NodeBuilder.create().
                  setCoordinate(innerRoot,0d, null, null, 40d).
                  setFont(FontsStore.FIRA_BOLD, Settings.MAIN_TITLE_HEIGHT).
                  setId(CSSID.TITLE_WINDOW_TEXT).
                  setText(WindowsTitlesNames.MAIN_WINDOW_NAME).
                  createNText();

          

    }

    @Override
    public WindowUndecorated setContentLayer(double t,double r,double b,double l) {
      
        this.contentLauer=(AnchorPane) AppNode.NodeBuilder.create()
               .setCoordinate(innerRoot, t, r, b, l)
               .setId(CSSID.MAIN_CONTENT_ANCHOR)
               .setStage(stage)
               .createNpAnchor().getElement();
        
        Layers.setContentLayer(contentLauer);
       
       
       
       
       return this;
    }
    


    
    
   
    
}

    