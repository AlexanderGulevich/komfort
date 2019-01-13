package basisFx.presentation;

import basisFx.appCore.elements.AnchorWrapper;
import basisFx.appCore.settings.CSSid;
import basisFx.appCore.utils.Coordinate;
import basisFx.appCore.windows.WindowAbstraction;
import basisFx.dataSource.UnitOfWork;
import javafx.scene.layout.AnchorPane;

public abstract class DynamicContentPanel {

    protected AnchorPane dynamicContentAnchorHolder;
    protected UnitOfWork unitOfWork=new UnitOfWork();
    protected AnchorPane  mainContentAnchor;
    protected WindowAbstraction window;
    protected boolean gridVisibility =false;

    public abstract void createServices();
    public abstract void customDynamicElementsInit();
    public abstract void initServices();

    public  void initTemplateMethod(WindowAbstraction windowAbstraction){
        window=windowAbstraction;
        windowAbstraction.setCurrentDynamicContent(this);
        mainContentAnchor =((AnchorPane ) window.getNodeFromMap(WindowAbstraction.DefaultPanelsNames.mainContentAnchor.name()));
        createDynamicContentAnchorHolder();
        createServices();
        customDynamicElementsInit();
        initServices();
    }
    private void createDynamicContentAnchorHolder() {
        dynamicContentAnchorHolder = AnchorWrapper.newBuilder()
                .setWindowAbstraction(window)
                .setMetaName("dynamicContentAnchorHolder")
                .setCSSid(CSSid.TARGET_PANEL)
                .setCoordinate(new Coordinate(0d, 10d, 10d, 10d))
                .setParentAnchor(mainContentAnchor)
                .build().getElement();
    }


}
