/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.fabrics;

import basisFx.appCore.panels.*;
import basisFx.appCore.utils.Coordinate;
import javafx.geometry.Insets;

/**
 *
 * @author Alek
 */
public class PanelFabric {

    public TitlePanel titlePanel(AbstractPanel.PanelBuilder b){

        return new TitlePanel(b);

    };

    public TransparentRootPanel transparentRootPanel(Insets insets){
        AbstractPanel.PanelBuilder builder = new AbstractPanel.PanelBuilder().setInsets(insets);
        return new TransparentRootPanel(builder);
    };

    public VisibleRootPanel visibleRootPanel(Coordinate coordinate){
        AbstractPanel.PanelBuilder builder = new AbstractPanel.PanelBuilder().setPanelCoordinate(coordinate);
        return new VisibleRootPanel(builder);
    };

    public PopupTitlePanel popupTitlePanel(AbstractPanel.PanelBuilder b){

        return new PopupTitlePanel(b);

    };
    public ContentPanel contentPanel(AbstractPanel.PanelBuilder b){
    
        return new ContentPanel(b);
    
    };
    public VerticalMenuPanel verticalMenuPanel(AbstractPanel.PanelBuilder b){
    
        return new VerticalMenuPanel(b);
    
    };
    public HorisontalFlowPanel horisontalFlowPanel(AbstractPanel.PanelBuilder b){
    
        return new HorisontalFlowPanel(b);
    
    };
    public TextAnchorPanel textAnchorPanel(AbstractPanel.PanelBuilder b){
    
        return new TextAnchorPanel(b);
    
    };
    public InnerContentPanel innerContentPanel(AbstractPanel.PanelBuilder b){

        return new InnerContentPanel(b);

    };
    public WindowButtonsPanel windowButtonsPanel(AbstractPanel.PanelBuilder b){

        return new WindowButtonsPanel(b);

    };
    public PopupButtonPanel popupButtonPanel(AbstractPanel.PanelBuilder b){

        return new PopupButtonPanel(b);

    };
    public PopupContentPanel popupContentPanel(AbstractPanel.PanelBuilder b){

        return new PopupContentPanel(b);

    };
}
