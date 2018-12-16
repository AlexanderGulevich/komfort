//package basisFx.appCore.windows;
//
//import basisFx.appCore.elements.AppNode;
//import basisFx.appCore.settings.CSSID;
//import basisFx.appCore.settings.FontsStore;
//import javafx.geometry.Insets;
//import javafx.scene.control.ContentDisplay;
//
//public class SingleButton extends ButtonsForWindowStage {
//
//    String closeStr="";
//    double fontHeight= 17d;
//    double topMatgin=4d;
//    double height=25d;
//    double widthValue=25d;
//    Insets padding=new Insets(0d, 0d, 0d, 0d);
//    FontsStore fs=FontsStore.FAWESOME5SOLID;
//
//    public SingleButton(Window window) {
//        super(window);
//    }
//
//    @Override
//    protected void organize() {
//
//        //крестик
//        closingButton= AppNode.NodeBuilder.create().
//                setFont(fs, fontHeight).
//                setSize(widthValue,height).
//                setPadding(padding).
//                setCoordinate(topMatgin, 0d, null, null).
//                setId(CSSID.TOP_CONTROL_BUTTON).setParent(buttonsAnchor).
//                setStage(stage).
//                setEvent(eventFabric.closingWindow()).
//                createNButton().
//                setName(closeStr, ContentDisplay.CENTER);
//
//    }
//}
