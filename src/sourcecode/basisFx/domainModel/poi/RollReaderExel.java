package basisFx.domainModel.poi;

//package hepo.domainModel.poi;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.math.BigDecimal;
//import java.math.RoundingMode;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Iterator;
//import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.CellType;
//
//public class RollReaderExel extends Reader{
//    
//    private static ArrayList<ArrayList> allOrders=new ArrayList<>();  
//    private ArrayList<HashMap> concreateOrder;
//    
//    public ArrayList<HashMap> getConcreateOrder() {
//        return concreateOrder;
//    }
//    
//    public static ArrayList <ArrayList> getAllOrders(){
//        return RollReaderExel.allOrders;
//    }
//    public void printSetOfRows() {
//        System.out.println("setOfRows   "+concreateOrder);        
//        
//    }
//    public RollReaderExel(String path) throws IOException, FileNotFoundException, InvalidFormatException {
//        
//       concreateOrder=new ArrayList(); 
//       openWorkBook(path);
//       sheet=wb.getSheetAt(0);
////       getLengthAndHeigthOfSheet(sheet);    
//       rowIteration();
//       
//       RollReaderExel.getAllOrders().add(concreateOrder);
//       
////       this.wrte=new WriteRoll(concreateOrder);
//       
//       
////       printSetOfRows();
//       
////     file.close();
//    
//    }
//    public RollReaderExel(File file) throws IOException, FileNotFoundException, InvalidFormatException {
//        
//       concreateOrder=new ArrayList(); 
//       openWorkBook(file);
//       sheet=wb.getSheetAt(0);
////       getLengthAndHeigthOfSheet(sheet);    
//       rowIteration();
////       this.wrte=new WriteRoll(concreateOrder);
//       
//       RollReaderExel.getAllOrders().add(concreateOrder);
////       printSetOfRows();
//       
////     file.close();
//    
//    }
//    protected void rowIteration(){
//      
//        Iterator<Row> rowIterator = sheet.iterator();
//        
//        Cell cell=null;
////
////        String beginningOfString;
////        String endingOfString;
//        
//       
//            while (rowIterator.hasNext()) {
//
//                     Row row = rowIterator.next();
//                     cell=  row.getCell(0);
//
//           if (!(cell.getCellTypeEnum()==CellType.BLANK)){
////           if (!(cell.getCellTypeEnum()==cell.getCellTypeEnum().BLANK)){
//
//                HashMap<String,String> hm=new HashMap<>();
//                String allString=cell.getStringCellValue();
//                String str=allString;
//                String count="";
//                Double doubleCount=0d;
//
//                if(str.contains("ЗАЯВКА")){
//                    str=strHandler.delDimension(str, "ЗАЯВКА", "№");
//                    str=strHandler.clearEdges(str);
//                    System.err.println(str);
//                    hm.put("order",str);
//                    concreateOrder.add(hm);//
//                    
//                            }
//                
//                if((str.contains("Рулон"))
//                        &&(str.contains("Содержание текста:"))
//                        &&(str.contains("ираж"))){
//
//                    hm.put("typeOfTicket", "Рулонный");
//
//                    //вырезать главную строку 
//                    str=(str.substring(
//                            str.indexOf("Содержание текста:")+"Содержание текста:".length(), 
//                            str.indexOf("РУП")-2
//                    ));
//
//                    str=strHandler.changeWord(str,  "КОНТРОЛЬНЫЙ БИЛЕТ", "к/б");
//                    str=strHandler.changeWord(str,  "КОНТРОЛЬНЫЙ  БИЛЕТ", "к/б");
//                    str=strHandler.changeWord(str,  "копеек", "коп");
//                    str=strHandler.changeWord(str,  "рубля", "руб");
//                    str=strHandler.changeWord(str,  "копейка", "коп");
//                    str=strHandler.changeWord(str,  "копейки", "коп");
//                    str=strHandler.changeWord(str,  "рублей", "руб");
//                    str=strHandler.changeWord(str,  "рубль", "руб");
//                    str=strHandler.delDimension(str, "БИЛЕТ", ",");
//                    str=strHandler.delDimension(str, "ИНН", ",");
//                    str=strHandler.delDimension(str, "КПП", ",");
//                    str=strHandler.delDimension(str, "ОГРН", ",");
//                    str=strHandler.delDimension(str, "Договор обязательного страхования", ",");
//                    str=strHandler.delDimension(str, "г.", ","); 
//
//                    hm.put("mainInf", str);
//                    
//                    // тираж
//                    count=allString;
//                    if((count.contains("ираж"))&&(count.contains("штук"))){
//
//                    count=count.substring(allString.indexOf("ираж")+"ираж".length()+2,
//                             allString.indexOf("штук")
//                             ); 
//                    
//                   count=  strHandler.delAllSpace(count);
//                      
//                   count=  strHandler.delText(count, "-");
//                   count=  strHandler.delText(count, "–");
//                        try {
//                            count=  ((Integer)(Integer.parseInt(count)/1000)).toString()    ;
//                        } catch (Exception e) {
//                            System.out.println(count);
//                        }
////                    new BigDecimal(count).divide(BigDecimal.ZERO))
//                   
////                   String sum=setSum(count); 
//                   
////                   String price=setPrice(count); 
//                   
//                    hm.put("count", count);
////                    hm.put("price", price);
////                    hm.put("summa", sum);
//                   
//                
//                    }
//                    if((count.contains("ираж"))&&(count.contains("шт"))){
//
//                    count=count.substring(allString.indexOf("ираж")+"ираж".length()+2,
//                             allString.indexOf("шт")
//                             ); 
//                    
//                   count=  strHandler.delAllSpace(count);
//                      
//                   count=  strHandler.delText(count, "-");
//                   count=  strHandler.delText(count, "–");
//                        try {
//                            count=  ((Integer)(Integer.parseInt(count)/1000)).toString()    ;
//                        } catch (Exception e) {
//                            System.out.println(count);
//                        }
//                   
//                   
////                    new BigDecimal(count).divide(BigDecimal.ZERO))
//                   
////                   String sum=setSum(count); 
//                   
////                   String price=setPrice(count); 
//                   
//                    hm.put("count", count);
////                    hm.put("price", price);
////                    hm.put("summa", sum);
//                   
//                
//                    }
// 
//                    concreateOrder.add(hm);
//
//                }
//
//           }
//
//    }
//    
//
//   
//}
//    
//    
//    private String multiply(Double price,BigDecimal countBigDecimal){
//          BigDecimal priceBigDecimal=new BigDecimal(price) ; 
//          BigDecimal result=countBigDecimal.multiply(priceBigDecimal);
//         return   result.setScale(2, RoundingMode.HALF_UP).toString();
//    
//    }
//  
//   
//
//
//
//}
