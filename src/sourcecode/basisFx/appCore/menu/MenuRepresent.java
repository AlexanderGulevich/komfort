/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.menu;

import basisFx.appCore.settings.CSSid;
import basisFx.appCore.utils.Coordinate;
import javafx.scene.layout.AnchorPane;

public abstract class MenuRepresent {

    protected CSSid css;
    protected MenuComponent component;
    protected AnchorPane ap;
    protected Coordinate c;
    protected Double width;
    protected Double height;

    protected abstract <T> void   makeStructuredMenuView(MenuComponent c, MenuComposite parentMenu );

    public void setCss(CSSid id) {
        this.css = id;
         }

    public void setComponent(MenuComponent component) {
        this.component = component;
    }


    public void setParentAnchor(AnchorPane ap) {
        this.ap = ap;
    }

    public void setCoordinate(Coordinate c) {
        this.c = c;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public void setHeight(Double height) {
        this.height = height;
    }


}
