package basisFx.domainModel.old;

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package hepo.domainModel;
//
//import hepo.domainModel.GoodsPojo;
//import hepo.domainModel.Communicable;
//import hepo.domainModel.Communicator;
//import hepo.domainModel.GoodsPojoCommunicator;
//import java.util.ArrayList;
//
///**
// *
// * @author 62
// */
//public class Plan implements Communicable{
//
//     private ArrayList<GoodsPojo>  filds=null;
//     private GoodsPojoCommunicator gpc;
//
//    public Plan() {
//         this.filds=new ArrayList<GoodsPojo>();
//         this.gpc =new GoodsPojoCommunicator();
//    }
//    
//    public void setGoodsPojo(GoodsPojo gp){
//        this.filds.add(gp);
//    }
//
//    @Override
//    public void setDataToCommunicator() {
//         
//            for (GoodsPojo pojo : filds) {
//                
//                gpc.setPojo(pojo);
//                
//            }
//    }
//
//    @Override
//    public GoodsPojoCommunicator getCommunicator() {
//        return this.gpc;
//    }
//
//    @Override
//    public void setCommunicator(Communicator c) {
//        this.gpc=(GoodsPojoCommunicator)c;
//    }
//    
//    
//    
//    
//}
