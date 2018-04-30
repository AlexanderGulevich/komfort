package basisFx.appCore.elements;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

public class GroupWrapper <T extends Node> extends AppNode    {


    public GroupWrapper(NodeBuilder builder) {
        element=new Group();
        Group element=(Group) this.element;

        init(builder);






    }



}
