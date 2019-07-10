package basisFx.appCore.poi;

import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Row;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class PriceReader extends Reader{
    
    private String categoryPriceName;
    
    private PriceCommonLogic logic;
    
    private Price price;
    
    
    public PriceReader(String path) throws IOException, FileNotFoundException, InvalidFormatException {
        
       openWorkBook(path);
       sheet=wb.getSheetAt(4);
       logic=new PriceCommonLogic();
       price =new Price();
       price.setPriceDateString(logic.readDate(sheet));
       rowIteration();

    }
    
    public PriceReader(File file) throws IOException, FileNotFoundException, InvalidFormatException {
          
      openWorkBook(file);
      sheet=wb.getSheetAt(4);
      logic=new PriceCommonLogic();
      price =new Price();
      this.price.setPriceDateString(logic.readDate(sheet));
      rowIteration();

       }
    
      public Price getPrice() {
         return price;
     }

       @Override
       protected void rowIteration() {
           

           Iterator<Row> rowIterator = sheet.iterator();
//           String categoryName;

               while (rowIterator.hasNext()) {

                        Row row = rowIterator.next();

                        //ищем категорию
                        if (logic.isCategory(row.getCell(1))) {
                           
                            categoryPriceName= logic.readCategoryName(row.getCell(1));
                            
                            try {
                                price.createCategory(categoryPriceName, fildsHandler(row,rowIterator));
                                
                            } catch (Exception ex) {
                                Logger.getLogger(PriceReader.class.getName()).log(Level.SEVERE, null, ex);
                            }


                            continue;                    
                       }
                        //ищем сумму
                        if (logic.isEnd(row.getCell(0))) {
                            

                            this.price.setTotalSumma(logic.readTotalSumma(row.getCell(13)));

                            break;                    
                       }
                   
                            
                           

                       

       }
       }
       
       private   ArrayList<GoodsPojo> fildsHandler(Row row,Iterator<Row> rowIterator) throws Exception{
           
            ArrayList<GoodsPojo> categories=new ArrayList<>();
           
             while (! logic.isEndOfCategory(row.getCell(1))) {
             row = rowIterator.next();
                
             
                          
                   //ищем поле
                     if (logic.isFild(row.getCell(2))) {
                         
                         String productName=logic.readProdactName(row.getCell(2));
                         String order=logic.readOrderName(row.getCell(2));
                         Integer orderYear=logic.readOrderYear(order);
                         Integer orderNumber=logic.readOrderNumber(order);
                         String measure=logic.readMeasure(row.getCell(6));
                         Double amountOfPrice=logic.readAmount(row.getCell(8));
                         Double pricePerUnit=logic.readPricePerUnit(row.getCell(10));
                         String amountInBox=logic.readAmountInbox(row.getCell(2));

                           GoodsPojo goodsPojo=new  GoodsPojo();
                           
                           goodsPojo.setProductNamePrice(productName);
                           goodsPojo.setAmountOfPrice(amountOfPrice);
                           goodsPojo.setOrder(order);
                           goodsPojo.setMeasure(measure);
                           goodsPojo.setPricePerUnit(pricePerUnit);
                           goodsPojo.setAmountInBox(amountInBox);
                           goodsPojo.setLeftOrderNum(orderNumber);
                           goodsPojo.setYear(orderYear);
                           
                          
                         categories.add(goodsPojo);

                    }  
             }
            
             return  categories;
       }
     

}
