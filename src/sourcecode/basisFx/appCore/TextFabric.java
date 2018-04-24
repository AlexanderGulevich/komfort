package basisFx.appCore;

import basisFx.appCore.elements.AppNode;
import basisFx.appCore.elements.LabelWrapper;
import basisFx.appCore.elements.TextWrapper;
import basisFx.appCore.utils.Coordinate;
import basisFx.appCore.settings.CSSID;
import basisFx.appCore.settings.FontsStore;
import javafx.geometry.Pos;
import javafx.scene.layout.AnchorPane;

public class TextFabric {


    public TextWrapper createText(String str,FontsStore font, double fontSize, AnchorPane panel, Coordinate coordinate) {

        return AppNode.NodeBuilder.create()
                .setParent(panel)
                .setCoordinate(coordinate)
                .setFont(font, fontSize)
                .setText(str)
                .setId(CSSID.LABEL_TEXT)
                .createText();
    }

    public LabelWrapper createLabel(String str, FontsStore font, Pos pos, double fontSize, AnchorPane panel, Coordinate coordinate) {

        return AppNode.NodeBuilder.create()
                .setParent(panel)
                .setPosToLabel(pos)
                .setCoordinate(coordinate)
                .setFont(font, fontSize)
                .setText(str)
                .setId(CSSID.LABEL_TEXT)
                .createLabel();
    }

}
