package basisFx.appCore.windows;

import basisFx.appCore.panels.AbstractPanel;
import basisFx.appCore.events.AppEvent;
import basisFx.appCore.utils.Coordinate;
import basisFx.appCore.registry.Layers;
import basisFx.appCore.settings.CSSID;
import basisFx.appCore.settings.FontsStore;
import basisFx.appCore.elements.AppNode;
import basisFx.appCore.elements.ButtonWrapper;
import basisFx.appCore.settings.TopButtons;
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



    public WindowUndecorated(double w,double h, Stage stage) {
        this.stage=stage;
        this.isManeWindow=true;
        this.width=w;
        this.height=h;
        this.stage.initStyle(StageStyle.UNDECORATED);
    }

    public WindowUndecorated(double w,double h, WindowType windowType) {
        if (windowType==WindowType.POPUP) {

            setIsPopup(true);
            this.stage = new Stage();
            this.width = w;
            this.height = h;
            this.stage.initStyle(StageStyle.UNDECORATED);
        }

    }

    public WindowUndecorated setTextIcon(AnchorPane parent, Coordinate c, FontsStore f, Double fHeight, String tIcn){
        AppNode.NodeBuilder.create()
                 .setCoordinate(c)
                 .setParent(parent)
                 .setFont(f, fHeight)
                 .setId(CSSID.TEXT_ICON_ANCHOR)
                 .setText(tIcn)
                 .createText();

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



        AppEvent closeEvent;
        AnchorPane buttonsPanelParent;


        if (isPopup) {
            closeEvent= eventFactory.closingPopup();
            buttonsPanelParent=Layers.getPopupTitlePunel();
        }else {
            closeEvent=eventFactory.closingWindow();
            buttonsPanelParent=Layers.getWindowButtonsPanel();
        }

        
         //крестик
         closingButton= AppNode.NodeBuilder.create().
                setFont(fs, fontHeight).
                setSize(width,height).
                setPadding(padding).
                setCoordinate(topMatgin, 0d, null, null).
                setId(CSSID.TOP_CONTROL_BUTTON).setParent(buttonsPanelParent).
                setStage(stage).
                setEvent(closeEvent).
                createNButton().
                setString(closeStr, ContentDisplay.CENTER);



         if (!isPopup) {

             hideButton = AppNode.NodeBuilder.create().
                     setFont(fs, fontHeight).
                     setEvent(eventFactory.hidingWindow()).
                     setSize(width, height).
                     setPadding(padding).
                     setCoordinate(topMatgin, width + width, null, null).
                     setId(CSSID.TOP_CONTROL_BUTTON).setParent(buttonsPanelParent).
                     setStage(stage).
                     createNButton().
                     setString(hideStr, ContentDisplay.CENTER);


             maximazeButton = AppNode.NodeBuilder.create().
                     setFont(fs, fontHeight).
                     setEvent(eventFactory.maximazingSwitcher()).
                     setSize(width, height).
                     setPadding(padding).
                     setCoordinate(topMatgin, width, null, null).
                     setId(CSSID.TOP_CONTROL_BUTTON).setParent(buttonsPanelParent).
                     setStage(stage).
                     createNButton().
                     setString(maximazeStr, ContentDisplay.CENTER);
         }
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

    