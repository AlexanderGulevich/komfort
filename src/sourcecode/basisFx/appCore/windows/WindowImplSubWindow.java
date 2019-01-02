package basisFx.appCore.windows;

import basisFx.appCore.utils.FXMLFileLoader;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;


public class WindowImplSubWindow extends WindowImpl{

    private  String messagge;
    private  AnchorPane anchorFromFXML ;

    public WindowImplSubWindow(WindowBuilder builder) {
        super(builder.width, builder.height, builder.title);
        this.messagge=messagge;

        anchorFromFXML = FXMLFileLoader.load(builder.fxmlFileName);

    }

    @Override
    public void init() {

        AnchorPane topVisiblePanel = (AnchorPane) windowAbstraction.getNode("TopVisiblePanel").getElement();
        ObservableList<Node> children = topVisiblePanel.getChildren();
        children.addAll(anchorFromFXML);

    }
}
