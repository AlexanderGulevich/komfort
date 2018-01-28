package basisFx.domainModel;

//package hepo.domainModel;
//
//import hepo.domainModel.GoodsPojo;
//import hepo.domainModel.Communicable;
//import hepo.domainModel.Communicator;
//import hepo.domainModel.GoodsPojoCommunicator;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.HashMap;
//
//
//public class Price implements Communicable{
//    
//    
//    private ArrayList<PriceCategory> categoriesArrayList=new ArrayList<>();
//    
//    private GoodsPojoCommunicator gpc;
//    
//    private Date priceDate=null;
//    
//    private Double totalSumma=null;
//    
//    private String priceDateString=null;
//
//    public Price() {
//        this.gpc =new GoodsPojoCommunicator();
//    }
//    
//    
//    
//    
//    public Date getPriceDate() {
//        return priceDate;
//    }
//    public String getPriceDateString() {
//        return priceDateString;
//    }
//
//    public void setPriceDate(Date priceDate) {
//        this.priceDate = priceDate;
//    }
//
//
//    public void setPriceDateString(String priceDateString) {
//        this.priceDateString = priceDateString;
//    }
//
//    public void setTotalSumma(Double totalSumma) {
//        this.totalSumma = totalSumma;
//    }
//
//    public void setCategory(ArrayList<PriceCategory> category) {
//        this.categoriesArrayList = category;
//    }
//
//    public Double getTotalSumma() {
//        return totalSumma;
//    }
//
//    public ArrayList<PriceCategory> getCategoriesArrayList() {
//        return categoriesArrayList;
//    }
//    
//   
//    public void createCategory(String name,  ArrayList<GoodsPojo> categoryFilds){
//        
//        PriceCategory category=new PriceCategory();
//        category.setFilds(categoryFilds);
//        category.setName(name);
//        categoriesArrayList.add(category);
//
//    }
//
//    @Override
//    public void setDataToCommunicator() {
//       
//        for (PriceCategory category : categoriesArrayList) {
//         
//            ArrayList <GoodsPojo> filds=category.getFilds();
//          
//            for (GoodsPojo pojo : filds) {
//                
//                gpc.setPojo(pojo);
//                
//            }
//            
//        }
//        
//    }
//
//    @Override
//    public GoodsPojoCommunicator getCommunicator() {
//        
//        return this.gpc;
//    
//    }
//
//    @Override
//    public void setCommunicator(Communicator c) {
//        this.gpc=(GoodsPojoCommunicator)c;
//    }
//    
//}