package basisFx.appCore.fabrics;

import basisFx.appCore.windows.KindOfPopup;
import basisFx.appCore.windows.PopupUndecorated;
import basisFx.appCore.windows.WindowDecorated;
import basisFx.appCore.windows.WindowFx;

public class PopupFabric {


    public  static PopupUndecorated popupUndecorated(KindOfPopup kindOfPopup, String text){

        return new PopupUndecorated(kindOfPopup,text);

    }

    public static PopupUndecorated popupUndecorated(double width, double height, KindOfPopup kindOfPopup, String text){

        return new PopupUndecorated(width,height,kindOfPopup,text);

    }

//    public static WindowFx popupDecorated(double width, double height, String text){
//
////        return new WindowDecorated(width, height,text);
//
//    }


}
