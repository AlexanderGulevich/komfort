package basisFx.domainModel.poi;

//package hepo.domainModel.poi;
//
//import hepo.domainModel.GoodsPojo;
//import hepo.domainModel.Plan;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.math.BigDecimal;
//import java.math.RoundingMode;
//import java.text.DecimalFormat;
//import java.util.Iterator;
//import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.CellType;
//import org.apache.poi.ss.usermodel.Row;
//
///**
// *
// * @author Alek
// */
//public class PlanReader extends Reader{
//    
//     private Plan plan=null;
//  
//
//     public PlanReader(File file) throws IOException, FileNotFoundException, InvalidFormatException {
//
//          openWorkBook(file);
////          sheet=wb.getSheetAt(6);
//          sheet=wb.getSheet("ТНП");
//          
//          this.plan=new Plan();
//          rowIteration();
//          
////          TestDebuggingReader.run(file,6);
////          TestDebuggingReader.run().printLengthAndHeigthOfSheet(sheet);
//       }
//    
//    
//         @Override
//       protected void rowIteration() {
// 
//           Iterator<Row> rowIterator = sheet.iterator();
//
//
//               while (rowIterator.hasNext()) {
//
//                        Row row = rowIterator.next();
//       
//                        
//                        if(findOrder(row)){
//                            
//                            Double amountOfOrder=readAmountOfOrder(row.getCell(3));
//                            String name=readName(row.getCell(2));
//                            String order=readOrder(row.getCell(1));
//                            Integer leftOrderNum=readLeftOrderNum(row.getCell(1));
//                            Integer year=readYear(row.getCell(1));
//                            Double price=readPrice(row.getCell(4));
//                            Double emittedAmountOfOrder=readEmittedAmountOfOrder(row.getCell(6));
//                            Double remainAmountOfOrder=amountOfOrder-emittedAmountOfOrder;
//                           
//                            BigDecimal remain=new BigDecimal(remainAmountOfOrder) ; 
//                            BigDecimal amount=new BigDecimal(amountOfOrder) ; 
//                            BigDecimal percent=remain.divide(amount,2, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100.0));  
//                  
//                            
//                           
//                            
//                            GoodsPojo gp=new  GoodsPojo();
//                            
//                            gp.setAmountOfOrder(amountOfOrder);
//                            gp.setEmittedAmountOfOrder(emittedAmountOfOrder);
//                            gp.setProductNamePlan(name);
//                            gp.setPricePerUnit(price);
//                            gp.setEmittedAmountOfOrder(emittedAmountOfOrder);
//                            gp.setRemainAmountOfOrder(remainAmountOfOrder);
//                            gp.setOrder(order);
//                            gp.setYear(year);
//                            gp.setLeftOrderNum(leftOrderNum);
//                            gp.setPercentRemained(percent.doubleValue());    
//                
//                            
//                            plan.setGoodsPojo(gp);
//             
//                        
//                        }
//
//                    
//       }
//          
//       }
//
//        public Plan getPlan() {
//            return plan;
//        }
//       
//       
//        private Boolean findOrder(Row row){
//            try {
//                 return   (row.getCell(1)!=null)&&
//                         (row.getCell(1).getCellTypeEnum()==CellType.STRING) &&
//                 (row.getCell(1).getStringCellValue().contains("-"))   ;
//            
//            } catch (Exception e) {
//
//                System.err.println("РЯД ошибики-----"+row.getRowNum()); 
//
//              
//                
//            }
//            
//            return false;
////            
//        }
//
//
//        private String readOrder(Cell c ){
//            return  strHandler.clearEdges(c.getStringCellValue());
//        }
//        
//        private String readName(Cell c ){
//            return  strHandler.clearEdges(c.getStringCellValue());
//        }
//       
//        private Double readAmountOfOrder(Cell c ){
//            
//            return c.getNumericCellValue();
//
//        }
//        private Double readEmittedAmountOfOrder(Cell c ){
//            
//            return c.getNumericCellValue();
//
//        }
//       
//        private Double readPrice(Cell c ){
//            
//            return c.getNumericCellValue();
//        }
//
//    private Integer readLeftOrderNum(Cell cell) {
//        
//        String orderString=readOrder(cell);
//        
//         String leftValue=orderString.substring(0,
//                  orderString.indexOf("-")
//          
//          );
//       
//        
//         return Integer.parseInt(leftValue);
//
//    }
//
//    private Integer readYear(Cell cell) {
//        
//           String orderString=readOrder(cell);
//        
//           String rightValue=orderString.substring(
//                   orderString.indexOf("-")+1,
//                   orderString.length()
//          );
//           
//       
//
//         return Integer.parseInt(rightValue);
//
//    }
//    
//}
