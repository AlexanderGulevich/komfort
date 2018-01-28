/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore;

import javafx.beans.property.ReadOnlyDoubleProperty;

/**
 *
 * @author Alek
 */
public interface TableCreater {
  public void  setPrefWidthBindToColums(ReadOnlyDoubleProperty widthProperty);
}
