/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.fabrics;

import basisFx.appCore.panels.*;

/**
 *
 * @author Alek
 */
public class PanelFabric {

    public TitlePanel titlePanel(AbstractPanel.PanelBuilder b){

        return new TitlePanel(b);

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
