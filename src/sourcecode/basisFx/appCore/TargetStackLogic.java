///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package basisFx.appCore;
//
//import basisFx.domain.targets.Target;
//import basisFx.appCore.utils.TargetRegistry;
//
///**
// *
// * @author Alek
// */
//public class TargetStackLogic {
//
//    private TargetStackLogic() {
//    }
//
//     public void handle(Target target) {
//
//        TargetRegistry.targets.clear();
//        TargetRegistry.targets.add(target);
//        Layers.getContentLayer().getChildren().clear();
//
//     }
//
//
//
//
//
//
//    public static TargetStackLogic getInstance() {
//        return TargetDinamicsLogicHolder.INSTANCE;
//    }
//
//
//    private static class TargetDinamicsLogicHolder {
//
//        private static final TargetStackLogic INSTANCE = new TargetStackLogic();
//    }
//}
//