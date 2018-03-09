/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.windows;

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
}
