package basisFx.appCore.events;

import basisFx.appCore.elements.AppNode;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.fabrics.WindowFabric;
import basisFx.appCore.interfaces.TableBasedDirectors;
import javafx.scene.Node;
import javafx.scene.control.Button;

public class YNWindowCreaterForTable extends AppEvent{
    protected AppEvent event;
    private String mess;
    private Button but;
    private TableWrapper tableWrapper;

    public YNWindowCreaterForTable(AppEvent event, String mess ) {
        this.event=event;
        this.mess = mess;
        tableWrapper=((TableBasedDirectors) event).getWrapper();

    }
    @Override
    public void setEventToElement(AppNode node) {
        but=(Button) node.getElement();
        but.setOnMouseClicked((event) -> {
            run();
        });
    }
    @Override
    public void setEventToElement(Node node) {
        but=(Button) node;
        but.setOnMouseClicked((event) -> {
            run();
        });
    }
    @Override
    public void run() {
        WindowFabric.WindowUndecorated().dialogWindow(  mess, (t) -> {
            if(t)  event.run(); }
            );
    }
}