package basisFx.domain.price;

import java.io.IOException;
import java.util.Iterator;

import basisFx.appCore.poi.Reader;
import basisFx.appCore.utils.Registry;
import lombok.Getter;
import org.apache.poi.ss.usermodel.Row;
import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class PriceReader extends Reader {

    
    private PriceUtils logic=new PriceUtils();
    @Getter
    private Price price=new Price();

    public  PriceReader(String path) {
        try {
            openWorkBook(path);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
        rowIteration();

        try {
            wb.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public PriceReader(File file)  {
        try {
            openWorkBook(file);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }

        rowIteration();

        try {
            wb.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
       @Override
       protected void rowIteration() {
           sheet=wb.getSheetAt(4);
           price.setPriceDateString(logic.readDate(sheet));

           Iterator<Row> rowIterator = sheet.iterator();
               while (rowIterator.hasNext()) {
                        Row row = rowIterator.next();
                        if (logic.isCategory(row.getCell(1))) {
                            String categoryPriceName= logic.readCategoryName(row.getCell(1));
                            try {
                                price.createCategory(categoryPriceName, rowHandler(row,rowIterator));
                            } catch (Exception ex) {
                                Logger.getLogger(PriceReader.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            continue;
                       }
                        if (logic.isEnd(row.getCell(0))) {
                            Double summa = logic.readTotalSumma(row.getCell(13));
                            price.setTotalSumma(summa);
                            logic.getMessageArray().add("\n\n"+
                                    "_____________________________________\n"+
                                    "СУММА ПО ТЕКУЩИМ СОСТАТКАМ СОСТАВЛЯЕТ : " + summa.toString() + "  руб.");
                            break;
                       }
       }


           Registry.dataExchanger.put("PriceMessage", logic.getMessageArray()   )  ;


       }
       
       private   ArrayList<TNPProduct> rowHandler(Row row, Iterator<Row> rowIterator){
           
            ArrayList<TNPProduct> products=new ArrayList<>();

             while (! logic.isEndOfCategory(row.getCell(1))) {
             row = rowIterator.next();

                     if (logic.isFild(row.getCell(2))) {
                         
                         TNPProduct product=new  TNPProduct();
                         product.setOrder(logic.readOrder(row.getCell(2)));
                         product.setName(logic.readProdactName(row.getCell(2)));
                         product.setBarcode(logic.readBarcode(row.getCell(2)));
                         product.setAmountInBox(logic.readAmountInbox(row.getCell(2)));
                         product.setAmountInPrice(logic.readAmount(row.getCell(8)));
                         product.setMeasure(logic.readMeasure(row.getCell(6)));
                         product.setPricePerUnit(logic.readPricePerUnit(row.getCell(10)));
                         products.add(product);
                    }
             }
             return  products;
       }

}
