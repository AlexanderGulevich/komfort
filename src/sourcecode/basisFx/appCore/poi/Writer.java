package basisFx.appCore.poi;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFPrintSetup;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public abstract class Writer {
  protected      StringHandler strHandler;
  protected      XSSFWorkbook workbook ;
  protected      FileOutputStream out;
  protected      XSSFRow row;
  protected      XSSFSheet spreadsheet;
  protected      Integer numRows=0;
  
  protected abstract void createFile() throws IOException;
  
  protected  void  setPrintSetup(){
      XSSFPrintSetup printSetup = spreadsheet.getPrintSetup();
      printSetup.setScale((short)85);
      printSetup.setLandscape(true);
      spreadsheet.setMargin(Sheet.TopMargin,       0.1);
      spreadsheet.setMargin(Sheet.RightMargin,     0.1);
      spreadsheet.setMargin(Sheet.BottomMargin,    0.1);
      spreadsheet.setMargin(Sheet.BottomMargin,    0.1);

      spreadsheet.setMargin(Sheet.HeaderMargin, 0.25);
      spreadsheet.setMargin(Sheet.FooterMargin, 0.25);


//             spreadsheet.setAutobreaks(true);
//             spreadsheet.setFitToPage(true);
//             spreadsheet.setPrintGridlines(true);

  };
  
  
  protected void setColumnWidth(int ... vars){
      
      int columnNum=0;
      
      for (int var : vars) {
          spreadsheet.setColumnWidth(columnNum, 256*var); //   1/256 символа
          columnNum += 1;
          
      }
      
  
  
  }
    
    

        
    }
    
    
    

    
    
    
    