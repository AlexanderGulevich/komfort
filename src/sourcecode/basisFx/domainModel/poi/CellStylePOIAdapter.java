package basisFx.domainModel.poi;

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package hepo.domainModel.poi;
//
//import org.apache.poi.ss.usermodel.BorderStyle;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.CellStyle;
//import org.apache.poi.ss.usermodel.CellType;
//import org.apache.poi.ss.usermodel.DataFormat;
//import org.apache.poi.ss.usermodel.FillPatternType;
//import org.apache.poi.ss.usermodel.HorizontalAlignment;
//import org.apache.poi.ss.usermodel.VerticalAlignment;
//import org.apache.poi.xssf.usermodel.XSSFCellStyle;
//import org.apache.poi.xssf.usermodel.XSSFColor;
//import org.apache.poi.xssf.usermodel.XSSFCreationHelper;
//import org.apache.poi.xssf.usermodel.XSSFFont;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
///**
// *
// * @author 62
// */
//public class CellStylePOIAdapter {
//    
////    protected    CellStyle сellStyle=null;
//    protected    XSSFCellStyle  сellStyle=null;
//    protected    XSSFFont font=null;
//    protected    Cell cell=null;
//    protected    XSSFWorkbook workbook=null;
//    protected    XSSFSheet spreadsheet=null;
//    
//    
//
//    public  CellStylePOIAdapter(XSSFWorkbook wb,  XSSFSheet spreadsheet) {
//       
//       this.workbook=wb;
//       this.сellStyle= workbook.createCellStyle();
//       this.font=workbook.createFont();
//       this.spreadsheet=spreadsheet;
//       this.сellStyle.setFont(font);
////       this.cell=cell;
//
//        
//        
//    }
//
//    public CellStylePOIAdapter setFontHeight(int h) {
//        
//         font.setFontHeightInPoints((short)h);
//         return this;
//        
//    }
//    
//    public CellStylePOIAdapter setFontName(String n) {
//        
//         font.setFontName(n);
//         return this;
//        
//    }
//    
//    public CellStylePOIAdapter setFontBold() {
//        
//         font.setBold(true);
//         return this;
//        
//    }
//    
//    public CellStylePOIAdapter setWrapText() {
//       
//             this.сellStyle.setWrapText(true);
// 
//         return this;
//        
//    }
//    
//    public CellStylePOIAdapter setRowHeight(int h) {
//       
//             this.cell.getRow().setHeightInPoints(h);
// 
//         return this;
//        
//    }
//    
//    public CellStylePOIAdapter setHorizontalAlignmentCENTER() {
//        
//        this.сellStyle.setAlignment(HorizontalAlignment.CENTER);
//         return this;
//        
//    }
//    
//    public CellStylePOIAdapter setHorizontalAlignmentLeft() {
//        
//        this.сellStyle.setAlignment(HorizontalAlignment.LEFT);
//         return this;
//        
//    }
//   
//    public CellStylePOIAdapter setHorizontalAlignmentRight() {
//        
//        this.сellStyle.setAlignment(HorizontalAlignment.RIGHT);
//         return this;
//        
//    }
//   
//    public CellStylePOIAdapter setVerticalAlignmentCENTER() {
//        
//        this.сellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
//         return this;
//        
//    }
//
//    
//    public CellStylePOIAdapter setFontItalic() {
//        
//         font.setItalic(true);
//         return this;
//        
//    }
//    
//    public CellStylePOIAdapter setFontColor(short s) {
//
//         font.setColor(s);   
//         return this;
//        
//    }
//    
//    public CellStylePOIAdapter setFontColorRGB(int i, int  k, int j) {
//
//         font.setColor(new XSSFColor(new java.awt.Color(i, k, j)));
//         return this;
//        
//    }
//    
//    public CellStylePOIAdapter setCellType(CellType ct) {
//
//         cell.setCellType(ct);
//         return this;
//        
//    }
//    
//    public CellStylePOIAdapter setDataFormatForNumericNotNegative() {
//        
//        XSSFCreationHelper creationHelper = new XSSFCreationHelper(workbook);
//
//        сellStyle.setDataFormat(creationHelper.createDataFormat().getFormat("# ##0")); 
//
////         this.сellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("# ##0"));
//         
//         return this;
//        
//    }
//    
//    public CellStylePOIAdapter setDataFormatForNumericWithNegative() {
//      
//        DataFormat format = workbook.createDataFormat();
//        
//        сellStyle.setDataFormat(format.getFormat("0.00"));
//        
//        
////        XSSFCreationHelper creationHelper = new XSSFCreationHelper(workbook);
//
////        сellStyle.setDataFormat(creationHelper.createDataFormat().getFormat("0,00")); 
//
////         this.сellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("# ##0"));
//         
//         return this;
//        
//    }
//    
//    public CellStyle getСellStyle() {
//               
//                return сellStyle;
//    }
//    
//    public CellStylePOIAdapter setBorder(BorderStyle top,BorderStyle right,
//            BorderStyle bottom,BorderStyle left, short s ){
//        
//        сellStyle.setBorderTop(top);
//        сellStyle.setBorderBottom(bottom);
//        сellStyle.setBorderLeft(left);
//        сellStyle.setBorderRight(right);
//        
//        сellStyle.setBottomBorderColor(s);
//        сellStyle.setTopBorderColor(s);
//        сellStyle.setRightBorderColor(s);
//        сellStyle.setLeftBorderColor(s);
//        
//    
//        return this;
//    
//    }
//    
//    public CellStylePOIAdapter setBorderRGB(BorderStyle top,BorderStyle right,
//            BorderStyle bottom,BorderStyle left, XSSFColor s ){
//        
//        сellStyle.setBorderTop(top);
//        сellStyle.setBorderBottom(bottom);
//        сellStyle.setBorderLeft(left);
//        сellStyle.setBorderRight(right);
//        
//        сellStyle.setBottomBorderColor(s);
//        сellStyle.setTopBorderColor(s);
//        сellStyle.setRightBorderColor(s);
//        сellStyle.setLeftBorderColor(s);
//        
//    
//        return this;
//    
//    }
//
//    public CellStylePOIAdapter setFillForegroundCol(short s ){
//        
//        сellStyle.setFillForegroundColor(s );
//        
//
//        return this;
//    
//    }
//    public CellStylePOIAdapter setFillForegroundCol(XSSFColor color ){
//        
//        сellStyle.setFillForegroundColor(color );
//       
//        return this;
//    
//    }
//    
//    public CellStylePOIAdapter setFillPattern(FillPatternType f ){
//        
//        сellStyle.setFillPattern(f);
//      
//        
//    
//        return this;
//    
//    }
//
//    public CellStylePOIAdapter setFillForegroundColRGB(int i, int k, int j) {
//
//       сellStyle.setFillForegroundColor(new XSSFColor(new java.awt.Color(i, k, j)));
//       
//        
//       return this;
//    }
//    
//
//    
//    
//    
//}
