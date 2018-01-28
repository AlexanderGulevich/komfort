package basisFx.domainModel.poi;

//package hepo.domainModel.poi;
//
//import hepo.domainModel.ReportTnp;
//import hepo.appCore.HierarchyForTreeTable;
//import hepo.domainModel.CategoryPojo;
//import hepo.domainModel.GoodsPojo;
//import hepo.domainModel.poi.CellHandler;
//import hepo.domainModel.poi.CellStylesStore;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.xssf.usermodel.XSSFPrintSetup;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
///**
// *
// * @author 62
// */
//public class WriteReportTnp extends Writer{
//    
//    private ReportTnp report;
//    private final CellHandler cellHandler;
//    private int firstLeftCellNum=1;
//    private int lastRightCellNum=14;
//    private  enum dataFrom{PRICE,DATABASE };
//    public WriteReportTnp(ReportTnp  report) throws IOException {
//            
//        this.report=report;
//
//        strHandler=new StringHandler();
//        workbook= new XSSFWorkbook();
//        spreadsheet = workbook.createSheet("ОТЧЕТ ТНП");
//
//        this.cellHandler=new CellHandler(workbook, spreadsheet);
//        
//        setPrintSetup();
//        createFile();
//
//    }
//    @Override
//    protected void createFile() throws IOException {
//        
//         out = new FileOutputStream(
//                 new File(this.report.getPath()+"\\ОТЧЕТ ТНП "+this.report.getPriceDate()+".xlsx")
//         );
//        try {
//            writeRows();
//        } catch (SQLException ex) {
//            Logger.getLogger(WriteReportTnp.class.getName()).log(Level.SEVERE, null, ex);
//        }
//            setColumnWidth(2,10,10,10,10,10,10,10,10,10,10,10,10,10);
//            workbook.write(out);
//            out.close();
//
//    }
//    @Override
//    protected void setPrintSetup() {
//            XSSFPrintSetup printSetup = spreadsheet.getPrintSetup();
//            printSetup.setScale((short)70);
//            printSetup.setLandscape(false);
//           
//                   
//            spreadsheet.setMargin(Sheet.TopMargin,       0.1);
//            spreadsheet.setMargin(Sheet.RightMargin,     0.1);
//            spreadsheet.setMargin(Sheet.LeftMargin,      0.1);
//            spreadsheet.setMargin(Sheet.BottomMargin,    0.1);
////            spreadsheet.setMargin(Sheet.HeaderMargin,    0.1);
////            spreadsheet.setMargin(Sheet.FooterMargin,    0.1);
//            
//            
////             spreadsheet.setAutobreaks(true);
////             spreadsheet.setFitToPage(true);
////             spreadsheet.setPrintGridlines(true);
//    }
//    private void writeRows() throws SQLException {
//         
//        writeHeader();
//        categoryRecursion(this.report.getHeadNods());
//        writePlanLowPerCent();
//        
//    }
//    private void writeHeader(){
//    
//           row=spreadsheet.createRow(numRows++);
//           row=spreadsheet.createRow(numRows++);
//           
//           cellHandler.setCellToHandle(row.createCell(firstLeftCellNum))           
//                   .setCellValue("•              ОТЧЕТ - ТОВАРЫ НАРОДНОГО ПОТРЕБЛЕНИЯ       ")
//                   .setRowHeight(row, 50)
//                   .setConcreteCellStyle(CellStylesStore.StyleKind.TITLE_REPORT_TNP)
//                   .addMergedRegion(row.getRowNum() , row.getRowNum(), firstLeftCellNum, lastRightCellNum);
//           
//           
//              cellHandler.multipleSetStyle(
//                   row, firstLeftCellNum+1, lastRightCellNum, CellStylesStore.StyleKind.TITLE_REPORT_TNP
//           );
//           
//           
//           row=spreadsheet.createRow(numRows++);
//           
//           cellHandler.setCellToHandle(row.createCell(lastRightCellNum-3))           
//                   .setCellValue( report.getPriceDate() )
//                   .setRowHeight(row, 20)
//                   .setConcreteCellStyle(CellStylesStore.StyleKind.DATE_REPORT_TNP)
//                   .addMergedRegion(row.getRowNum() , row.getRowNum(), lastRightCellNum-3, lastRightCellNum);
//      
//              cellHandler.multipleSetStyle(
//                   row, lastRightCellNum-2, lastRightCellNum, CellStylesStore.StyleKind.DATE_REPORT_TNP
//           );
//           
//              row=spreadsheet.createRow(numRows++);
//              
//           
//           
//           
//    
//    }
//    private void categoryRecursion(ObservableList headNods) throws SQLException {  
//        
//               ObservableList <CategoryPojo> categoryWithoutDescendant=FXCollections.<CategoryPojo> observableArrayList(); 
//        
//               for (Iterator<HierarchyForTreeTable.Node> iterator = headNods.iterator(); iterator.hasNext();) {
//
//                   HierarchyForTreeTable.Node concreteCategoryNode = iterator.next();
//               
//                if(concreteCategoryNode.hasDescendant()){
//                   
//                    
//                   int level=concreteCategoryNode.getValue().getLevelId();
//                   
//                   String name=concreteCategoryNode.getValue().getCategoryNameOfTnp();
//                   
//                   
//                   if (level==1) {
//                       writeFirstLevelCategoryName(name, firstLeftCellNum);
//                   }
//                   if (level==2) {
//                       writeSecondLevelCategoryName(name, firstLeftCellNum);
//                   }
//
//                   categoryRecursion(concreteCategoryNode.getDescendants());
//
//                }else{
////                    System.err.println("if(concreteCategoryNode.hasDescendant()){-------нет");
//                   categoryWithoutDescendant.add(concreteCategoryNode.getValue());
//                  
//               }
// 
//        }
//               if (!categoryWithoutDescendant.isEmpty()) {
//                   
//            writeTable(categoryWithoutDescendant);  
//            writeDetaleInformation(categoryWithoutDescendant);
//        }
//                
//               
//                row=spreadsheet.createRow(numRows++);
//    }
//    private void writeTable(ObservableList <CategoryPojo> categoryWithoutDescendant) {
//        
//
//           row=spreadsheet.createRow(numRows++);
//           row=spreadsheet.createRow(numRows++);
//           row=spreadsheet.createRow(numRows++);
//           row=spreadsheet.createRow(numRows++);
//           
//
//        int cellNum=1;
//        
//         // таблица товарного блока - левая колонка
//        XSSFRow row1= spreadsheet.getRow(row.getRowNum()-3);
//        cellHandler.setCellToHandle(row1.createCell(cellNum))
//          .setRowHeight(row, 30)
//          .setConcreteCellStyle(CellStylesStore.StyleKind.REPORT_TNP_TABLE_LEFT)
//          .setCellValue("");  
//        
//        XSSFRow row2= spreadsheet.getRow(row.getRowNum()-2);
//        cellHandler.setCellToHandle(row2.createCell(cellNum))
//          .setRowHeight(row, 30)
//          .setConcreteCellStyle(CellStylesStore.StyleKind.REPORT_TNP_TABLE_LEFT)
//          .setCellValue("ПЛАН");       
//        
//        XSSFRow row3= spreadsheet.getRow(row.getRowNum()-1);
//        cellHandler.setCellToHandle(row3.createCell(cellNum))
//          .setRowHeight(row, 30)
//          .setConcreteCellStyle(CellStylesStore.StyleKind.REPORT_TNP_TABLE_LEFT)
//          .setCellValue("Склад");      
//        
//        
//        
//
//        for (Iterator<CategoryPojo> iterator = categoryWithoutDescendant.iterator(); iterator.hasNext();) {
//            CategoryPojo next = iterator.next();
//            
//            cellNum++;
//
//                    
//            int categoryId=next.getId();
//            String shortName=next.getShortName();
//            
//            @SuppressWarnings("unchecked")
//            ArrayList <GoodsPojo> fitPrice=getListFromPriceByCategoryId(categoryId);
//            @SuppressWarnings("unchecked")
//            ArrayList <GoodsPojo> fitDb=getListFromDbOpenOrdersByCategoryId(categoryId);
//            
//            double summaPrice=getSummaPrice(fitPrice);  
//            double summaDb=getSummaDB(fitDb); 
//            
//
//            int rowNum=row.getRowNum();
//        
//
//            //шапка таблицы товарного блока
//            XSSFRow rowHeadTable= spreadsheet.getRow(rowNum-3);
//            cellHandler.setCellToHandle(rowHeadTable.createCell(cellNum))
//              .setRowHeight(row, 50)
//              .setConcreteCellStyle(CellStylesStore.StyleKind.REPORT_TNP_TABLE_HEAD)
//              .setCellValue(shortName);       
//
//            //значения плана товарного блока
//            XSSFRow rowPlan= spreadsheet.getRow(rowNum-2); 
//            cellHandler.setCellToHandle(rowPlan.createCell(cellNum))
//              .setRowHeight(row, 30)
//              .setConcreteCellStyle(CellStylesStore.StyleKind.PRODUCT_BLOCK__REPORT_TNP_VALUE)
//              .setCellValue(summaDb);  
//
//            //значения прайса товарного блока
//            XSSFRow rowPrice= spreadsheet.getRow(rowNum-1);
//            cellHandler.setCellToHandle(rowPrice.createCell(cellNum))
//              .setRowHeight(row, 30)
//              .setConcreteCellStyle(CellStylesStore.StyleKind.PRODUCT_BLOCK__REPORT_TNP_VALUE)
//              .setCellValue(summaPrice);   
//
//            
//            
//        }
//        
//         
//        
//
//    }
//    private void writeDetaleInformation(ObservableList <CategoryPojo> categoryWithoutDescendant) throws SQLException {
//        
//                row=spreadsheet.createRow(numRows++);
//                
//                writeHeadDetaleLevel1();
//                
//                row=spreadsheet.createRow(numRows++);
//          
//                writeHeadDetaleLevel2(firstLeftCellNum);
//                writeHeadDetaleLevel2(firstLeftCellNum+7);
//                
//                row=spreadsheet.createRow(numRows++);
//                
//                int rowNumber=row.getRowNum();
//                
//                writeDetalesList(
//                        rowNumber, firstLeftCellNum, firstLeftCellNum+7, 
//                        categoryWithoutDescendant,dataFrom.PRICE
//                );
//                writeDetalesList(
//                        rowNumber, firstLeftCellNum+7, firstLeftCellNum+13,
//                        categoryWithoutDescendant,dataFrom.DATABASE
//                );
//                
//                
//                row=spreadsheet.createRow(numRows++);
//    }
//    private void writeFirstLevelCategoryName(String name, int cellNum){
//       
//        row=spreadsheet.createRow(numRows++);
//        row=spreadsheet.createRow(numRows++);
//        
//           cellHandler.setCellToHandle(row.createCell(cellNum))
//           .addMergedRegion(row.getRowNum() , row.getRowNum(), firstLeftCellNum, lastRightCellNum)
//           .setRowHeight(row, 30)
//           .setConcreteCellStyle(CellStylesStore.StyleKind.LEVE1_CATEGORY)
//           .setCellValue("----  "+name+"  ----");    
//           
//           cellHandler.multipleSetStyle(
//                   row, cellNum+1, cellNum+13, CellStylesStore.StyleKind.LEVE1_CATEGORY
//           );
//
//           row=spreadsheet.createRow(numRows++);
//           row=spreadsheet.createRow(numRows++);
//           row=spreadsheet.createRow(numRows++);
//
//    }
//    private void writeSecondLevelCategoryName(String name, int cellNum){
//          
//        row=spreadsheet.createRow(numRows++);
//        
//          cellHandler.setCellToHandle(row.createCell(cellNum))
//           .addMergedRegion(row.getRowNum() , row.getRowNum(), firstLeftCellNum, lastRightCellNum)
//           .setConcreteCellStyle(CellStylesStore.StyleKind.LEVE2_CATEGORY)
//           .setCellValue(name);       
//          
//          
//            cellHandler.multipleSetStyle(
//                   row, cellNum+1, cellNum+13, CellStylesStore.StyleKind.LEVE2_CATEGORY
//           );
//
//           row=spreadsheet.createRow(numRows++);
//
//        
//    
//    }
//    private ArrayList getListFromPriceByCategoryId(int categoryId) {
//        
//        ArrayList <GoodsPojo> categorized=new ArrayList<>();
//        
//        ObservableList<GoodsPojo> analyzed=report.getAnalyzedGoodsPojoListFromPrice();
//        
//        for (Iterator<GoodsPojo> iterator = analyzed.iterator(); iterator.hasNext();) {
//            GoodsPojo next = iterator.next();
//            
//            
//            if (next.getCategoryId()==categoryId) {
//                
//                categorized.add(next);
//                
//                
//            }
//            
//        }
//        
//        
//       
//        return categorized;
//         
//    }
//    private ArrayList getListFromDbOpenOrdersByCategoryId(int categoryId) {
//        
//        ArrayList <GoodsPojo> categorized=new ArrayList<>();
//        
//        ObservableList<GoodsPojo> opened=report.getOpenOrders();
//        
//        for (Iterator<GoodsPojo> iterator = opened.iterator(); iterator.hasNext();) {
//            GoodsPojo next = iterator.next();
//            
//            
//            if (next.getCategoryId()==categoryId) {
//                
//                categorized.add(next);
//                
//                
//            }
//            
//        }
//        
//        
//       
//        return categorized;
//        
//    }
//    private double getSummaPrice(ArrayList<GoodsPojo> fit) {
//        
//        double summa=0.0;
//        
//        for (Iterator<GoodsPojo> iterator = fit.iterator(); iterator.hasNext();) {
//            GoodsPojo next = iterator.next();
//            
//            summa=summa+ next.getAmountOfPrice();
//            
//        }
//        
//        return summa;
//       
//    }
//    private double getSummaDB(ArrayList<GoodsPojo> fit) {
//        
//        double summa=0.0;
//        
//        for (Iterator<GoodsPojo> iterator = fit.iterator(); iterator.hasNext();) {
//            GoodsPojo next = iterator.next();
//            
//            summa=summa+ next.getRemainAmountOfOrder();
//            
//        }
//        
//        return summa;
//       
//    }
//    private void writePlanLowPerCent() {
//       
//
//        ObservableList <GoodsPojo>  lowPerCent=report.getOpenOrdersLowPerCent();
//        
//        writeFirstLevelCategoryName("Заказы, с остатком <20% в произвостве", firstLeftCellNum);
//        
//        
//        
//         for (Iterator<GoodsPojo> productIterator = lowPerCent.iterator(); productIterator.hasNext();) {
//                        
//                      GoodsPojo product = productIterator.next();
//                      
//                    
//                       row=spreadsheet.createRow(numRows++);
//        
//                       
//                  cellHandler.setCellToHandle(row.createCell(firstLeftCellNum))           
//                   .setCellValue(product.getOrder())
//                   .setRowHeight(row, 20)
//                   .setConcreteCellStyle(CellStylesStore.StyleKind.REPORT_TNP_DETALE_TEXT_LEFT);
//                  
//                  
//                  
//                  String name=null;
//                  
//                      if (product.getProductNameCommon()==null) {
//                          
//                          try {
//                              name= report.getDao().getRandomProductName(product);
//                          } catch (SQLException ex) {
//                              Logger.getLogger(WriteReportTnp.class.getName()).log(Level.SEVERE, null, ex);
//                          }
//                        
//                      }else{
//                     
//                          name=product.getProductNameCommon();
//                      
//                      }
//                  
//                  
//                  
//                  cellHandler.setCellToHandle(row.createCell(firstLeftCellNum+1))           
//                   .setCellValue( name)
//                   .setRowHeight(row, 20)
//                   .setConcreteCellStyle(CellStylesStore.StyleKind.REPORT_TNP_DETALE_TEXT)
//                   .addMergedRegion(row.getRowNum() , row.getRowNum(), firstLeftCellNum+1, firstLeftCellNum+10);
//                  
//                   cellHandler.multipleSetStyle(row, firstLeftCellNum+2, firstLeftCellNum+10, CellStylesStore.StyleKind.REPORT_TNP_DETALE_TEXT);
//                   
//                    cellHandler.setCellToHandle(row.createCell(firstLeftCellNum+11))           
//                   .setCellValue( product.getRemainAmountOfOrder())
//                   .setRowHeight(row, 20)
//                   .setConcreteCellStyle(CellStylesStore.StyleKind.REPORT_TNP_DETALE_TEXT_RIGHT);
//    
//                      
//                  }
// 
//            
//        
//       
//        
//    }
//    private void writeDetalesList(int rowNum , int left,  int right, ObservableList<CategoryPojo> categoryWithoutDescendant,dataFrom from) throws SQLException {
//        
//        int rowNumber=rowNum;
//        
//         ArrayList <GoodsPojo> fit;
//         
//              for (Iterator<CategoryPojo> iterator = categoryWithoutDescendant.iterator(); iterator.hasNext();) {
//                    CategoryPojo next = iterator.next();
//                    
// 
//                  if (from==dataFrom.PRICE) {
//
//                        fit=getListFromPriceByCategoryId(next.getId());
//                        
//                        
//                      
//                  }else {
//                  
//                       fit=getListFromDbOpenOrdersByCategoryId(next.getId());
//                      
//                  }
//                  
//            
//             
//                
//                  for (Iterator<GoodsPojo> productIterator = fit.iterator(); productIterator.hasNext();) {
//                        
//                      GoodsPojo product = productIterator.next();
//                      
//                      
//                      double amount=0.0;
//                      
//                        if (from==dataFrom.PRICE) {
//
//                        fit=getListFromPriceByCategoryId(next.getId());
//                        
//                        amount=product.getAmountOfPrice();
//                      
//                            }else {
//
//                              fit=getListFromDbOpenOrdersByCategoryId(next.getId());
//                              
//                              amount=product.getRemainAmountOfOrder();
//
//                            }
//                      
//                      
//                      
//                      
//                      if(spreadsheet.getRow(rowNumber+1)==null){
//                       
//                           row=spreadsheet.createRow(numRows++);
//                           rowNumber=rowNumber+1;
//                      }else{
//                      
//                      row=spreadsheet.getRow(rowNumber+1);
//                      rowNumber=rowNumber+1;
//                      }
//                      
//                      
//                       
//                  cellHandler.setCellToHandle(row.createCell(left))           
//                   .setCellValue(product.getOrder())
//                   .setRowHeight(row, 30)
//                   .setConcreteCellStyle(CellStylesStore.StyleKind.REPORT_TNP_DETALE_TEXT_LEFT);
//                  
//                  
//                  
//                  String name;
//                  
//                      if (product.getProductNameCommon()==null) {
//                          
//                          name= report.getDao().getRandomProductName(product);
//                        
//                      }else{
//                      
//                     
//                          name=product.getProductNameCommon();
//                      
//                      }
//                  
//                 
//                  
//                  cellHandler.setCellToHandle(row.createCell(left+1))           
//                   .setCellValue( name)
//                   .setRowHeight(row, 30)
//                   .setConcreteCellStyle(CellStylesStore.StyleKind.REPORT_TNP_DETALE_TEXT)
//                   .addMergedRegion(row.getRowNum() , row.getRowNum(), left+1, left+5);
//                  
//                   cellHandler.multipleSetStyle(row, left+2, left+5, CellStylesStore.StyleKind.REPORT_TNP_DETALE_TEXT);
//                   
//                    cellHandler.setCellToHandle(row.createCell(left+6))           
//                   .setCellValue( amount )
//                   .setRowHeight(row, 30)
//                   .setConcreteCellStyle(CellStylesStore.StyleKind.REPORT_TNP_DETALE_TEXT_RIGHT);
//    
//                      
//                  }
// 
//            
//        }
//              
//        
//        
//        
//        
//        
//        
//    }
//    private void writeHeadDetaleLevel1() {
//                int left=firstLeftCellNum;
//                int middle=firstLeftCellNum+7;
//                int right=middle+7;
//                          
//     ////////////////////////////////////////////////////////////////////////////////  
//     
//                  cellHandler.setCellToHandle(row.createCell(left))           
//                   .setCellValue("Детализация СКЛАД")
//                   .setRowHeight(row, 20)
//                   .setConcreteCellStyle(CellStylesStore.StyleKind.REPORT_TNP_DETALE_HEADER)
//                   .addMergedRegion(row.getRowNum() ,row.getRowNum(), left, left+6);
//           
//           
//              cellHandler.multipleSetStyle(row, left+1, left+6, 
//                      CellStylesStore.StyleKind.REPORT_TNP_DETALE_HEADER
//           );
//  
//    ////////////////////////////////////////////////////////////////////////////////    
//              
//                  cellHandler.setCellToHandle(row.createCell(middle))           
//                   .setCellValue("Детализация План")
//                   .setConcreteCellStyle(CellStylesStore.StyleKind.REPORT_TNP_DETALE_HEADER)
//                   .addMergedRegion(row.getRowNum() , row.getRowNum(), middle, middle+6);
//           
//          
//              cellHandler.multipleSetStyle(row, middle+1, middle+6, CellStylesStore.StyleKind.REPORT_TNP_DETALE_HEADER
//           );
//              
//        
//                }
//    private void writeHeadDetaleLevel2(int firstCell) {
//         
//   
//                  cellHandler.setCellToHandle(row.createCell(firstCell))           
//                   .setCellValue("№Зак")
//                   .setRowHeight(row, 20)
//                   .setConcreteCellStyle(CellStylesStore.StyleKind.REPORT_TNP_DETALE_HEADER_LEVEL2);
//                  
//           
//                 cellHandler.setCellToHandle(row.createCell(firstCell+1))           
//                   .setCellValue("Наименование")
//                   .setRowHeight(row, 20)
//                   .setConcreteCellStyle(CellStylesStore.StyleKind.REPORT_TNP_DETALE_HEADER_LEVEL2)
//                   .addMergedRegion(row.getRowNum() , row.getRowNum(), firstCell+1, firstCell+5);
//           
//   
//              cellHandler.multipleSetStyle(row, firstCell+2, firstCell+5, 
//                      CellStylesStore.StyleKind.REPORT_TNP_DETALE_HEADER_LEVEL2
//           );
//              
//               cellHandler.setCellToHandle(row.createCell(firstCell+6))           
//                   .setCellValue("Остаток")
//                   .setRowHeight(row, 20)
//                   .setConcreteCellStyle(CellStylesStore.StyleKind.REPORT_TNP_DETALE_HEADER_LEVEL2);
//           
//              
//              
//              
//    }
//
//  
//}
