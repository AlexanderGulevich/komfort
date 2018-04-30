package basisFx.appCore.fabrics;

import basisFx.appCore.domainScetch.DomainObject;
import basisFx.appCore.elements.AppNode;
import basisFx.appCore.elements.DatePickerWrapper;
import basisFx.appCore.utils.Coordinate;
import javafx.collections.ObservableList;
import javafx.scene.layout.AnchorPane;

public class VidgetFactory {


    public DatePickerWrapper datePickerWrapper(AnchorPane panel, double width, Coordinate coordinate,ObservableList<DomainObject> list){

        DatePickerWrapper datePickerWrapper=
                AppNode.NodeBuilder.create()
                        .setWidth(width)
                .setParent(panel).setCoordinate(coordinate)
                .createDatePickerWrapper();

        datePickerWrapper.insertList(list);

        return datePickerWrapper;

    }
}
