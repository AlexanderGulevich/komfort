package basisFx.domainModel.poi;

//package hepo.domainModel.poi;
//
//import hepo.domainModel.GoodsPojo;
//import hepo.domainModel.Price;
//import hepo.domainModel.PriceCategory;
//import hepo.domainModel.poi.CellHandler;
//import hepo.domainModel.poi.CellStylesStore;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.math.BigDecimal;
//import java.math.RoundingMode;
//import java.util.ArrayList;
//import java.util.Iterator;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.xssf.usermodel.XSSFPrintSetup;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
///**
// *
// * @author Alek
// */
//public class WritePrice extends Writer{
//    
//    private Price price;
//    private String  path;
//    private ArrayList categoriesArrayList;
//    int first;
//    int last;
//    private CellHandler cellHandler ;
//    
//
//    public WritePrice(Price pr, String p) throws IOException {
//        this.price=pr;
//        this.path=p;
//        this.categoriesArrayList=price.getCategoriesArrayList();
//        this.first=1;
//        this.last=7;
//        
//
//            strHandler=new StringHandler();
//            workbook= new XSSFWorkbook();
//            out=null;
//            row=null;
//            spreadsheet = workbook.createSheet("Складские остатки");
//            
//            this.cellHandler=new CellHandler(workbook, spreadsheet);
//            
//            setPrintSetup();
//            
//            
//            createFile();
//            
//          
//     
//    }
//
//    @Override
//    protected void createFile() throws FileNotFoundException, IOException {
//      
//         out = new FileOutputStream(new File(this.path+"\\Прайс "+this.price.getPriceDateString()+".xlsx"));
//         
//         createHeader();
//         createTableHead();
//         createPermanentData();
////         createFooter();
//
//        setColumnWidth(2,8,23,60,7,9,14,20);
//
//            workbook.write(out);
//            out.close();
//          
//    }
//    
//    
//    private void createHeader(){
//        
//           row=spreadsheet.createRow(numRows++);
//          
//           
//           cellHandler.setCellToHandle(row.createCell(first))   
//                   .addMergedRegion(row.getRowNum(), row.getRowNum(), first, last);
//           
//           
//           row=spreadsheet.createRow(numRows++);
//           
//           cellHandler.setCellToHandle(row.createCell(first))           
//                   .setCellValue("РУП \"Бобруйская укрупненная типография им.А.Т.Непогодина\"  ")
//                   .setRowHeight(row, 30)
//                   .setConcreteCellStyle(CellStylesStore.StyleKind.NAMECOMPANY)
//                   .addMergedRegion(row.getRowNum() , row.getRowNum(), first, last-3);
//           
//         
//            cellHandler.setCellToHandle(row.createCell(last-2))          
//                   .setCellValue("     КОНТАКТЫ ТИПОГРАФИИ")
//                   .addMergedRegion(row.getRowNum() , row.getRowNum() , last-2, last)
//                   .setConcreteCellStyle(CellStylesStore.StyleKind.CONTACTS_HEPO_TITLE); 
//           
//           row=spreadsheet.createRow(numRows++);
//           
//            cellHandler.setCellToHandle(row.createCell( first  ))                      
//                   .setCellValue("Ведомость наличия товара на "+price.getPriceDateString()+" г.")
//                   .setRowHeight(row, 20)
//                   .addMergedRegion(row.getRowNum() , row.getRowNum(), first, last-3)
//                   .setConcreteCellStyle(CellStylesStore.StyleKind.STATEMENT);
//            
//
//            cellHandler.setCellToHandle(row.createCell(  last-2 ))           
//                     .setRowHeight(row, 20)
//                     .addMergedRegion(row.getRowNum() , row.getRowNum() , last-2, last)
//                     .setCellValue("     e-mail:        hepogodin@mail.ru")
//                     .setConcreteCellStyle(CellStylesStore.StyleKind.CONTACTS_HEPO);
//            
//             row=spreadsheet.createRow(numRows++);
//             
//              cellHandler.setCellToHandle(row.createCell(  first ))  
//                   .addMergedRegion(row.getRowNum() , row.getRowNum(), first, last-3);
//        
//
//             cellHandler.setCellToHandle(row.createCell( last-2  ))          
//                     .setCellValue("     тел.:             8 0225 72 25 16")
//                     .addMergedRegion(row.getRowNum() , row.getRowNum() , last-2, last)
//                     .setConcreteCellStyle(CellStylesStore.StyleKind.CONTACTS_HEPO);
//         
//           
//           row=spreadsheet.createRow(numRows++);
//           
//
//              cellHandler.setCellToHandle(row.createCell(  first ))           
//                     .setCellValue("Наименование заказчика: (очень просим   заполнять это поле)")
//                     .setRowHeight(row, 50)
//                     .addMergedRegion(row.getRowNum(), row.getRowNum(), first, first+1)
//                     .setConcreteCellStyle(CellStylesStore.StyleKind.CUSTOMERNAMETITLE);   
//           
//              cellHandler.setCellToHandle(row.createCell( first+2  ))           
////                     .setCellValue("Просим заполнять ЭТО поле,заранее СПАСИБО!")
//                     .addMergedRegion(row.getRowNum(), row.getRowNum(), first+2, last)
//                     .setConcreteCellStyle(CellStylesStore.StyleKind.CUSTOMERNAMEVALUE);    
//           
//              cellHandler.setCellToHandle(row.createCell( first+3  ))           
//                   .setConcreteCellStyle(CellStylesStore.StyleKind.CUSTOMERNAMEVALUE);
//              
//
//              cellHandler.setCellToHandle(row.createCell( first+4  ))           
//                   .setConcreteCellStyle(CellStylesStore.StyleKind.CUSTOMERNAMEVALUE);
//              
//
//              cellHandler.setCellToHandle(row.createCell(  first+5 ))         
//                   .setConcreteCellStyle(CellStylesStore.StyleKind.CUSTOMERNAMEVALUE);
//              
//             cellHandler.setCellToHandle(row.createCell(  first+6 ))         
//                   .setConcreteCellStyle(CellStylesStore.StyleKind.CUSTOMERNAMEVALUE);
//
//           row=spreadsheet.createRow(numRows++);
//           
//
//             cellHandler.setCellToHandle(row.createCell(  first+6  ))          
//               .addMergedRegion(row.getRowNum(), row.getRowNum(), first, last);
//
//            }
//    
//
//    private void createTableHead() {
//                
//          row=spreadsheet.createRow(numRows++);
//          row.setHeightInPoints(40);
//           
//
//
//           cellHandler.setCellToHandle(row.createCell(  first ))   
//                    .setCellValue("№")
//                    .setConcreteCellStyle(CellStylesStore.StyleKind.TABLEHEAD);
//                    
//           cellHandler.setCellToHandle(row.createCell( first+1  ))   
//                    .setCellValue("Наименование продукции").
//                     addMergedRegion(row.getRowNum(), row.getRowNum(), first+1, first+2)
//                    .setConcreteCellStyle(CellStylesStore.StyleKind.TABLEHEADPRODACSTNAME);
//                    
//           cellHandler.setCellToHandle(row.createCell( first+2  ))   
//                    .setConcreteCellStyle(CellStylesStore.StyleKind.TABLEHEADPRODACSTNAME);
//                    
//           cellHandler.setCellToHandle(row.createCell( first+3  ))   
//                    .setCellValue("Ед. Изм.")
//                    .setConcreteCellStyle(CellStylesStore.StyleKind.TABLEHEAD);
//                    
// 
//           cellHandler.setCellToHandle(row.createCell(  first+4 ))   
//                    .setCellValue("Цена б/НДС")
//                    .setConcreteCellStyle(CellStylesStore.StyleKind.TABLEHEAD);
//                    
//  
//            cellHandler.setCellToHandle(row.createCell( first+5  ))   
//                    .setCellValue("Количество на складе")
//                    .setConcreteCellStyle(CellStylesStore.StyleKind.TABLEHEAD);
// 
//            
//           cellHandler.setCellToHandle(row.createCell( first+6  ))   
//                    .setCellValue("Заявка")
//                    .setConcreteCellStyle(CellStylesStore.StyleKind.TABLEHEAD);
//
//    }
//    
//    private void createPermanentData() {
//        
//        
//         row=spreadsheet.createRow(numRows++);
//
//        
//        for (Iterator it = categoriesArrayList.iterator(); it.hasNext();) {
//                PriceCategory pc = (PriceCategory) it.next();
//
//
//                       cellHandler.setCellToHandle(row.createCell(  first ))   
//            .setCellValue("                * "+pc.getName())
//            .addMergedRegion(row.getRowNum(), row.getRowNum(), first, last)
//            .setConcreteCellStyle(CellStylesStore.StyleKind.TABLECATEGORY);
//
//                       cellHandler.setCellToHandle(row.createCell( first+1  ))   
//            .setConcreteCellStyle(CellStylesStore.StyleKind.TABLECATEGORY);
//
//                       cellHandler.setCellToHandle(row.createCell( first+2  ))   
//            .setConcreteCellStyle(CellStylesStore.StyleKind.TABLECATEGORY);
//
//                       cellHandler.setCellToHandle(row.createCell(first+3   ))   
//            .setConcreteCellStyle(CellStylesStore.StyleKind.TABLECATEGORY);
//
//                      cellHandler.setCellToHandle(row.createCell( first+4  ))   
//            .setConcreteCellStyle(CellStylesStore.StyleKind.TABLECATEGORY);
//
//                       cellHandler.setCellToHandle(row.createCell(  first+5 ))   
//            .setConcreteCellStyle(CellStylesStore.StyleKind.TABLECATEGORY);
//
//                       cellHandler.setCellToHandle(row.createCell(  first+6 ))   
//            .setConcreteCellStyle(CellStylesStore.StyleKind.TABLECATEGORY);
//
//                row.setHeightInPoints(15);
//
//                row=spreadsheet.createRow(numRows++);
// 
//            for (GoodsPojo filds : pc.getFilds()) {
//                
//            row.setHeightInPoints(15);
//                
//        
//           cellHandler.setCellToHandle(row.createCell(  first ))   
//                    .setCellValue(filds.getOrder())
//                    .setConcreteCellStyle(CellStylesStore.StyleKind.PERMANENTDATASTRING);
//
//          cellHandler.setCellToHandle(row.createCell(  first +1))   
//                    .setCellValue("  "+filds.getProductNamePrice())
//                    .addMergedRegion(row.getRowNum(), row.getRowNum(),first+1, first+2)
//                    .setConcreteCellStyle(CellStylesStore.StyleKind.PERMANENTDATASTRING);
//            
//           cellHandler.setCellToHandle(row.createCell(  first +2))    
//                    .setConcreteCellStyle(CellStylesStore.StyleKind.PERMANENTDATASTRING);
//
//
//          cellHandler.setCellToHandle(row.createCell(  first +3))   
//                    .setCellValue(filds.getMeasure())
//                    .setConcreteCellStyle(CellStylesStore.StyleKind.PERMANENTDATASTRING);
//
//     
//          cellHandler.setCellToHandle(row.createCell(  first +4))   
//                    .setConcreteCellStyle(CellStylesStore.StyleKind.PERMANENTDANUMERIC_withNehative)
//                    .setCellValue(
//                              new BigDecimal(
//                              String.valueOf(filds.getPricePerUnit())
//                             ).setScale(2, RoundingMode.CEILING).doubleValue()
//                 
//                    );
//            cellHandler.setCellToHandle(row.createCell(  first +5))           
//                    .setConcreteCellStyle(CellStylesStore.StyleKind.PERMANENTDANUMERIC_NotNegative)
//                    .setCellValue(
//                              new BigDecimal(
//                              String.valueOf(filds.getAmountOfPrice())
//                             ).setScale(2, RoundingMode.CEILING).doubleValue()
//                 
//                    );
//
//            cellHandler.setCellToHandle(row.createCell(  first +6))        
//                    .setConcreteCellStyle(CellStylesStore.StyleKind.PERMANENTDANUMERIC_NotNegative);
//                   
//
//
//                
//                row=spreadsheet.createRow(numRows++);
//                
//                
//                
//            }
//            
//            
//        }
//
//
//
//    }
//
//    private void createFooter() {
//       
//    
//           //     
////Дата:
////Сумма:
//    
//    
//    }
//
//    @Override
//    protected void setPrintSetup() {
//            XSSFPrintSetup printSetup = spreadsheet.getPrintSetup();
//            printSetup.setScale((short)85);
//            printSetup.setLandscape(true);
//            spreadsheet.setMargin(Sheet.TopMargin,       0.1);
//            spreadsheet.setMargin(Sheet.RightMargin,     0.1);
//            spreadsheet.setMargin(Sheet.BottomMargin,    0.1);
//            spreadsheet.setMargin(Sheet.BottomMargin,    0.1);
//            
//            spreadsheet.setMargin(Sheet.HeaderMargin, 0.25);
//            spreadsheet.setMargin(Sheet.FooterMargin, 0.25);
//            
//            
////             spreadsheet.setAutobreaks(true);
////             spreadsheet.setFitToPage(true);
////             spreadsheet.setPrintGridlines(true);
//    }
//
//    
//}
