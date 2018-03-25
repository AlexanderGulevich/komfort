package basisFx.appCore.elements;

import javafx.scene.control.ScrollPane;

/**
 * Created by AlexanderGulevich on 24.03.2018.
 *
 * @autor AlexanderGulevich
 */
public class ScrollPaneWrapper<T>  extends AppNode{

    private ScrollPane scrollPane;


    ScrollPaneWrapper(NodeBuilder builder) {

        element=new ScrollPane();
        scrollPane= (ScrollPane) element;
        init(builder);


    }
}
