/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.poi;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

/**
 *
 * @author Alek
 */
public class PriceCommonLogic {
    
  protected StringHandler strHandler=new StringHandler();
  
//искать категорию
     public Boolean isCategory(Cell c ) {
     
     String value=null;
     
            if (!(c==null)){
            
                 if (!(c.getCellTypeEnum()==c.getCellTypeEnum().BLANK)){
                     
                     
                        if (c.getCellTypeEnum()==c.getCellTypeEnum().STRING){
                            
                            value=c.getStringCellValue();
                            
                           
                                if (value.contains("готовая продукция")&&
                                        (!(value.contains("Итого по группе:")))){

                                     return true;

                                  }else{ return false;}
                    
                        }else{ return false;}

                }else{ return false;}
            
            }else{ return false;}
    }
//искать поле в категории   
     public Boolean isFild(Cell c){
        
            if (!(c==null)){
            
                 if (!(c.getCellTypeEnum()==c.getCellTypeEnum().BLANK)){//не пустая ячейка
                     
                     
                        if (c.getCellTypeEnum()==c.getCellTypeEnum().STRING){//соит строку
                            
                            return true;
                            
                           
                    
                        }else{ return false;}

                }else{ return false;}
            
            }else{ return false;}
     }

     public Boolean isDate(Cell c){
         
            String value;
      
             if (!(c==null)){
            
                 if (!(c.getCellTypeEnum()==c.getCellTypeEnum().BLANK)){
                     
                     
                        if (c.getCellTypeEnum()==c.getCellTypeEnum().STRING){
                            
                            value=c.getStringCellValue();
                            
                            if (value.contains("по подразделениям")) {
                                
                                 return true;
                                 
                            } else{ return false;}   
                            
                        }else{ return false;}

                }else{ return false;}
            
            }else{ return false;}
     }
     
     public Boolean isEnd(Cell c){
         
            String value;
      
             if (!(c==null)){
            
                 if (!(c.getCellTypeEnum()==c.getCellTypeEnum().BLANK)){
                     
                     
                        if (c.getCellTypeEnum()==c.getCellTypeEnum().STRING){
                            
                            value=c.getStringCellValue();
                            
                            if (value.contains("ИТОГО ПО ПРЕДПРИЯТИЮ")) {
                                
                                 return true;
                                 
                            } else{ return false;}   
                            
                        }else{ return false;}

                }else{ return false;}
            
            }else{ return false;}
     }
//получить имя категории    
     public String readCategoryName(Cell c){
         
          String value=null;
          
           value=c.getStringCellValue();
                            
                           
                                if (value.contains("готовая продукция")&&
                                        (!(value.contains("Итого по группе:")))){
                                    
                                    
                                     value= strHandler.delText(value, "готовая продукция,");
                                     value= strHandler.delText(value, "готовая продукция");
                                     value= strHandler.delDimension(value, "(", ")");
                                     value= strHandler.delDimension(value, "(", ")");
                                                                       
                                     return value;

                                  }else{ return "не найдено";}
          
         
     }
//получить имя продукта      
     public String readProdactName(Cell c){
           String value=null;
           value=c.getStringCellValue();
           
//           value=value.substring(value.indexOf(" "));
           
//           value=strHandler.delAllSpace(value);
           

         try {
             
                  value=value.substring(
                     value.indexOf("-")+3);
             
                  
         } catch (Exception e) {
             
             System.err.println("ERROR IS----------------"+ value);
         }

      
           
           
           value=strHandler.clearEdges(value);
                   
           return value;      
     }
//найти конец категории     
     public Boolean isEndOfCategory(Cell c){
        
         String value=null;
     
            if (!(c==null)){
            
                 if (!(c.getCellTypeEnum()==c.getCellTypeEnum().BLANK)){
                     
                     
                        if (c.getCellTypeEnum()==c.getCellTypeEnum().STRING){
                            
                            value=c.getStringCellValue();
                            
                           
                                if (value.contains("Итого по группе: готовая продукция")){

                                     return true;

                                  }else{ return false;}
                    
                        }else{ return false;}

                }else{ return false;}
            
            }else{ return false;}
         
     
     }
//найти единицу измерения   
     public String readMeasure(Cell c){
          
            String value=null;
            value=c.getStringCellValue();
            value= strHandler.clearEdges(value);
            return value;
            
     }
//найти количество       
     public Double readAmount(Cell c){
            Double value=null;
            value=c.getNumericCellValue();
            return value;
     }
//найти цену за единицу         
     public Double readPricePerUnit(Cell c){
            
            Double value=null;
            value=c.getNumericCellValue();
            return value;
     }
//найти дату      
     public String readDate(Sheet sheet){
        
        Row dateRow =sheet.getRow(3);
        Cell dateCell=dateRow.getCell(0);
        
        String dateCellString=dateCell.getStringCellValue();
        dateCellString =strHandler.delText(dateCellString, "по подразделениям на");
        dateCellString =strHandler.delText(dateCellString, "г.");
        dateCellString =dateCellString.toLowerCase();
        dateCellString =strHandler.clearEdges(dateCellString);
        
       
         if(dateCellString.contains("января")){   
             dateCellString=strHandler.changeWord(dateCellString, "января", "01") ;
                     }
         if(dateCellString.contains("февраля")){   
             dateCellString=strHandler.changeWord(dateCellString, "февраля", "02") ;
                     }
         if(dateCellString.contains("марта")){   
             dateCellString=strHandler.changeWord(dateCellString, "марта", "03") ;
                     }
         if(dateCellString.contains("апреля")){   
             dateCellString=strHandler.changeWord(dateCellString, "апреля", "04") ;
                     }
         if(dateCellString.contains("мая")){   
             dateCellString=strHandler.changeWord(dateCellString, "мая", "05") ;
                     }
         if(dateCellString.contains("июня")){   
             dateCellString=strHandler.changeWord(dateCellString, "июня", "06") ;
                     }
         if(dateCellString.contains("июля")){   
             dateCellString=strHandler.changeWord(dateCellString, "июля", "07") ;
                     }
         if(dateCellString.contains("августа")){   
             dateCellString=strHandler.changeWord(dateCellString, "августа", "08") ;
                     }
         if(dateCellString.contains("сентября")){   
             dateCellString=strHandler.changeWord(dateCellString, "сентября", "09") ;
                     }
         if(dateCellString.contains("октября")){   
             dateCellString=strHandler.changeWord(dateCellString, "октября", "10") ;
                     }
         if(dateCellString.contains("ноября")){   
             dateCellString=strHandler.changeWord(dateCellString, "ноября", "11") ;
                     }
         if(dateCellString.contains("декарбя")){   
             dateCellString=strHandler.changeWord(dateCellString, "декарбя", "12") ;
                     }
        
               
        dateCellString=strHandler.changeWord(dateCellString, " ", ".");
        dateCellString=strHandler.changeWord(dateCellString, " ", ".");
        
        return dateCellString;
        
        
        
    
    }
//найти сумму     
     public Double readTotalSumma(Cell c){      
         
            Double value=null;
            value=c.getNumericCellValue();
            return value;
            
     }
     
     public String readOrderName(Cell c){
     
            String value=null;
          
            value=c.getStringCellValue();
                            
            value= value.substring(0, 10);
            value= strHandler.delText(value, "з.");
            value= value.substring(0, value.indexOf("-")+3);
            value= strHandler.clearEdges(value);

            return value;

     
     }
     
     public String readBarcode(Cell c) throws Exception{
     
            String value=null;
          
            value=c.getStringCellValue();
            value= strHandler.clearEdges(value);
            

            if (value.contains("(")) { 
                
              value= value.substring(
                        value.lastIndexOf("(")-13,
                        value.lastIndexOf("("));
              
              
                
                
         }else{
            
              throw new Exception("readBarcode not find  -   ) "); 
            
            }
                
            value= strHandler.clearEdges(value);
            
            if (value.contains(" ")) {
                
                 throw new Exception("readBarcode find   \"  \"  ===== "+   value + "-ряд-"+c.getRow()); 
             
         }

            return value;

     
     }
     
     public String readAmountInbox(Cell c) throws Exception{
     
            String value=null;
          
            value=c.getStringCellValue();
            

            if (value.contains("(")) { 
                
                value= value.substring(
                        value.lastIndexOf("(")+1,
                        value.lastIndexOf(")"));
                
            }else{
            
             // throw new Exception("readAmountInbox not find  -   ) "); 
             
             value="не указано";
            
            }
                
            value= strHandler.clearEdges(value);

            return value;

     
     }
     
     
     public Integer readOrderNumber(String orderString){
         
          String leftValue=orderString.substring(0,
                  orderString.indexOf("-")
          
          );
       

         return Integer.parseInt(leftValue);

     }
     
     public Integer  readOrderYear(String orderString){
         
           String rightValue=orderString.substring(
                   orderString.indexOf("-")+1,
                   orderString.length()
          );

         return Integer.parseInt(rightValue);

     }
     
     
}
