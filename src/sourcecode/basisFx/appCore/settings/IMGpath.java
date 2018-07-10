/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.settings;

/**
 *
 * @author Alek
 */
public enum IMGpath {
    ICONTOOP("/res/img/icon.png");

    private final String path;

    private IMGpath(String path) {
        this.path = path;
    }

    public String get() {
        return path;
    }
}
