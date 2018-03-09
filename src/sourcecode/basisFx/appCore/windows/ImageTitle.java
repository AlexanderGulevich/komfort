/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.windows;

import basisFx.appCore.elements.AppNode;
import basisFx.domainModel.settings.CSSID;

/**
 *
 * @author Alek
 */
public class ImageTitle extends AbstracttTitle{

    @Override
    public void init() {
           AppNode.NodeBuilder.create()
                    .setParent(titlePanel)
                    .setCoordinate(titleNameCoordinate)
                    .setId(CSSID.TITLE_WINDOW_IMG)
                    .createNpAnchor();
    }

    @Override
    public ImageTitle getInstance() {
        return this;
    }
    
}
