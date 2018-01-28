package basisFx.domainModel.poi;

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package hepo.domainModel.poi;
//
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.util.CellRangeAddress;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
///**
// *
// * @author 62
// */
//public class CellHandler {
//    protected      Cell cell;
//    protected      XSSFWorkbook workbook ;
//    protected      CellStylesStore cellStylesStore;
//    protected      XSSFSheet spreadsheet;
//    
//
//    public CellHandler(XSSFWorkbook workbook, XSSFSheet spreadsheet) {
//
//        this.workbook=workbook;
//        this.spreadsheet=spreadsheet;
//        this.cellStylesStore=new CellStylesStore(workbook, spreadsheet);
//
//    }
//    
//    
//    public CellHandler setCellToHandle( Cell cell){
//        
//        this.cell=cell;
//         return this;
//    
//    }
//    public CellHandler setCellValue(String val){
//    
//        cell.setCellValue(val);
//        return this;
//    }
//    public CellHandler setCellValue(Double val){
//        
//        cell.setCellValue(val);
//        return this;
//        
//    }
//    public CellStylesStore getCellStylesStore() {
//        return cellStylesStore;
//    }
//    public CellHandler setRowHeight( XSSFRow row,int h) {
//       
//             row.setHeightInPoints(h);
// 
//         return this;
//        
//    }
//    public CellHandler setConcreteCellStyle(CellStylesStore.StyleKind sk) {
//        
//               cell.setCellStyle(cellStylesStore.getConcreteCellStyle(sk));      
//        return this;
//    
//    }
//    public CellHandler addMergedRegion(int startRow,int endRow,int startCell,int endCell){
//        
//
//        spreadsheet.addMergedRegion(new CellRangeAddress(
//                        startRow,        // ряд начала
//                        endRow,          // ряд конца
//                        startCell,       // ячейка начала
//                        endCell          // ячейка конца
//                ));
//    
//        return this;
//    }
//    public CellHandler multipleSetStyle(XSSFRow row,int srartCell,int endCell,CellStylesStore.StyleKind d){
//   
//
//        for (; srartCell <=endCell; srartCell++) {
//          
//            this.setCellToHandle(row.createCell(srartCell))
//           .setConcreteCellStyle(d);
//    
//        }
//         
//        return this;
//    }
//    
//    
//
//
//
//}
//    
//      
//    
//      
//      
//    
//
