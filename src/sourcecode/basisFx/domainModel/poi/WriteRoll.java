package basisFx.domainModel.poi;

//package hepo.domainModel.poi;
//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.HashMap;
//import org.apache.poi.ss.usermodel.CellType;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//public class WriteRoll extends Writer{
//
//       
//        ArrayList <ArrayList>allOrders=new ArrayList();
//        String path;
//
////    public WriteRoll() {
////    }
//        Integer numRows=0;
//        
//    
//        public WriteRoll(ArrayList arrL, String path) throws IOException  {
//            strHandler=new StringHandler();
//            workbook= new XSSFWorkbook();
//            out=null;
//            row=null;
//            spreadsheet = workbook.createSheet("orders");
//            this.path=path;
//            
//            this.allOrders=arrL;
//            
//            handleList();
//        }
//        
////        public void setArrList(ArrayList a){this.allOrders.add(a);}
////        
////        
//
//    /**
//     *
//     * @throws IOException
//     */
//        
//        @Override
//        public void createFile() throws IOException{
//            
//            out = new FileOutputStream(new File(path+"\\РОЛЬ.xlsx"));
//
//              spreadsheet.setColumnWidth(0, 256*5); //   1/256 символа
//              spreadsheet.setColumnWidth(1, 256*30);
//              spreadsheet.setColumnWidth(2, 256*100);
//              spreadsheet.setColumnWidth(3, 256*20);
//              spreadsheet.setColumnWidth(4, 256*10);
//              
//              
//            workbook.write(out);
//            out.close();
//        
//        }
//        
////    public void setArrListOrders(ArrayList arr){
////    
////       this.allOrders=arr;
////    
////    }
////        
//        
//    public void handleList() throws IOException{
//        
//        for(ArrayList <HashMap> order: allOrders){
//
//            
//            for(int i=0;i<order.size();i++){
//                
//               HashMap line=order.get(i);
////               
////               Iterator iterator =line.entrySet().iterator();
////               
////                        while(iterator.hasNext()){
////                          iterator.next();
////                                   }
//                        lineHandle(line);
//                        
//            }       
//}
//         
//  createFile();      
//    }
//    
//    public void lineHandle(HashMap line){
//        
//        if(line.containsKey("order")){ 
//            row=spreadsheet.createRow(numRows++);
//            row=spreadsheet.createRow(numRows++);
//            row.createCell(1).setCellValue((String) line.get("order"));
//            row=spreadsheet.createRow(numRows++);
//        }else{
//        row=spreadsheet.createRow(numRows++);
//    
//        row.createCell(1).setCellValue((String) line.get("typeOfTicket"));
//        
//        row.createCell(2).setCellValue((String) line.get("mainInf"));
//        
//        row.createCell(3).setCellType(CellType.NUMERIC);
//        row.getCell(3).setCellValue(Double.parseDouble((String) line.get("count")));
//        
////        row.createCell(4).setCellType(CellType.NUMERIC);
////        row.getCell(4).setCellValue(Double.parseDouble((String) line.get("price")));
////        
////        row.createCell(5).setCellType(CellType.NUMERIC);
////        row.getCell(5).setCellValue(Double.parseDouble((String) line.get("summa")));
//
//        }
//    
//    }
//
//    @Override
//    protected void setPrintSetup() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//    
//    
//    
//}
//                
//                     
//
//    
//    
