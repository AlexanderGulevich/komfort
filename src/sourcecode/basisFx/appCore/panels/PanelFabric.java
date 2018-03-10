/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.panels;

/**
 *
 * @author Alek
 */
public class PanelFabric {
    
    public TitlePanel createTitlePanel(AbstractPanel.PanelBuilder b){
    
        return new TitlePanel(b);
    
    };
    public ContentPanel createContentPanel(AbstractPanel.PanelBuilder b){
    
        return new ContentPanel(b);
    
    };
    public VerticalMenuPanel createVerticalMenuPanel(AbstractPanel.PanelBuilder b){
    
        return new VerticalMenuPanel(b);
    
    };
    public HorisontalFlowPanel createHorisontalFlowPanel(AbstractPanel.PanelBuilder b){
    
        return new HorisontalFlowPanel(b);
    
    };
    public TextAnchorPanel createTextAnchorPanel(AbstractPanel.PanelBuilder b){
    
        return new TextAnchorPanel(b);
    
    };
    public InnerContentPanel createInnerContentPanel(AbstractPanel.PanelBuilder b){
    
        return new InnerContentPanel(b);
    
    };
}
