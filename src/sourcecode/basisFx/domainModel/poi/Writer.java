package basisFx.domainModel.poi;

//package hepo.domainModel.poi;
//
//import java.io.FileOutputStream;
//import java.io.IOException;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//public abstract class Writer {
//  protected      StringHandler strHandler;
//  protected      XSSFWorkbook workbook ;
//  protected      FileOutputStream out;
//  protected      XSSFRow row;
//  protected      XSSFSheet spreadsheet;
//  protected      Integer numRows=0;
//  
//  protected abstract void createFile() throws IOException;
//  
//  protected abstract void  setPrintSetup();
//  
//  
//  protected void setColumnWidth(int ... vars){
//      
//      int columnNum=0;
//      
//      for (int var : vars) {
//          spreadsheet.setColumnWidth(columnNum, 256*var); //   1/256 символа
//          columnNum += 1;
//          
//      }
//      
//  
//  
//  }
//    
//    
//
//        
//    }
//    
//    
//    
//
//    
//    
//    
//    