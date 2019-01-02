//package basisFx.appCore.events;
//
//import basisFx.appCore.elements.AppNode;
//import basisFx.appCore.utils.Registry;
//import basisFx.presentation.TargetPanel;
//import javafx.scene.control.Button;
//
//public class SubWindowCreater<T> extends AppEvent{
//
//    private Button but;
//    private TargetPanel targetPanel;
//    private double width;
//    private double height;
//
//    public SubWindowCreater(TargetPanel targetPanel, double width, double height) {
//        this.targetPanel = targetPanel;
//        this.width = width;
//        this.height = height;
//    }
//
//    public SubWindowCreater(TargetPanel targetPanel ) {
//        this.targetPanel = targetPanel;
//        this.width = 1000d;
//        this.height = 700d;
//    }
//
//    @Override
//    public void setEventToElement(AppNode node) {
//        but=(Button) node.getElement();
//        but.setOnMouseClicked((event) -> {
//            run();
//        });
//    }
//
//    @Override
//    public void run() {
//        Registry.windowFabric.subWindow(targetPanel,width,height);
//    }
//
//
//}
