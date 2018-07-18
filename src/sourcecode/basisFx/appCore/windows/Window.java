package basisFx.appCore.windows;

import basisFx.appCore.elements.AppNode;
import basisFx.appCore.settings.CSSID;
import basisFx.appCore.settings.IMGpath;
import basisFx.appCore.utils.CSSHandler;
import basisFx.appCore.fabrics.EventFactory;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
//import org.scenicview.ScenicView;


/**
 *
 * @author 62
 */
public abstract class Window {

    protected Stage stage;
    protected Scene scene;
    protected AnchorPane root;
    protected AnchorPane topVisiblePanel;
    protected WindowKind kind;
    protected EventFactory eventFactory = EventFactory.getInstance();

    public Window(WindowKind kind) {
        this.kind = kind;
        this.kind.setWindow(this);
        initRoot();
        initTopVisiblePanel();
        scene= new Scene(root, this.kind.getWidth(), this.kind.getHeight());
        stage.setScene(scene);
        scene.setFill(Color.TRANSPARENT);
        stage.initStyle(StageStyle.TRANSPARENT);
        initIcon();
        CSSHandler.getInstanse().loadStylesToScene(scene);
    }

    protected abstract void initRoot();

    private void initTopVisiblePanel() {
        topVisiblePanel = (AnchorPane) AppNode.NodeBuilder.create()
                .setCoordinate(root, 0d, 0d, 0d, 0d)
                .setId(CSSID.TopVisiblePanel)
                .createAnchorPanelWrapper()
                .getElement();
    }

    public Scene getScene() {
        return scene;
    }

    public Stage getStage() {
        return stage;
    }

    public AnchorPane getRoot() {
        return root;
    }

    private void initIcon() {
        stage.getIcons().add(
                new Image(getClass().getResourceAsStream(IMGpath.ICONTOOP.get()
                )));
    }

    public AnchorPane getTopVisiblePanel() {
        return topVisiblePanel;
    }




}
