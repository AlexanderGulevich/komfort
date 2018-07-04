package basisFx.appCore.fabrics;

import basisFx.appCore.windows.PopupUndecorated;

public class PopupFabric {


    public  static PopupUndecorated popupUndecorated(KindOfPopup kindOfPopup, String text){

        return new PopupUndecorated(kindOfPopup,text);

    }
    public  static PopupUndecorated popupUndecorated(KindOfPopup kindOfPopup,double fonSize, String text){

        return new PopupUndecorated(kindOfPopup,fonSize,text);

    }

    public static PopupUndecorated popupUndecorated(double width, double height, KindOfPopup kindOfPopup, String text){

        return new PopupUndecorated(width,height,kindOfPopup,text);

    }

//    public static WindowBridgeAbstraction popupDecorated(double width, double height, String text){
//
////        return new WindowDecorated(width, height,text);
//
//    }


}
