/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.windows;

import basisFx.appCore.elements.AppNode;
import basisFx.domainModel.settings.CSSID;
import basisFx.domainModel.settings.Settings;
import basisFx.domainModel.settings.WindowsTitlesNames;

/**
 *
 * @author Alek
 */
public class TextTitle extends AbstracttTitle{

    @Override
    public void init() {
       
    
         AppNode.NodeBuilder.create()
                    .setParent(titlePanel)
                    .setCoordinate(titleNameCoordinate)
                    .setFont(Settings.MAIN_TITLE_FONT, Settings.MAIN_TITLE_HEIGHT)
                    .setId(CSSID.TITLE_WINDOW_TEXT)
                    .setText(WindowsTitlesNames.MAIN_WINDOW_NAME)
                    .createNText();
    
    }
    
    @Override
    public TextTitle getInstance() {
        return this;
    }
    
}