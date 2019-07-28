package basisFx.appCore.poi;

import java.util.HashMap;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CellStylesStore{
    

    protected    CellStylePOIHandler cellStylePOIHandler;
    protected    XSSFWorkbook workbook;
    protected    HashMap<StyleKind,CellStyle> cellStyles=new HashMap();
    protected    XSSFSheet spreadsheet;
    protected    Cell cell;
    protected    CellStylesStore сellStylesStore=null;

    public CellStylesStore(XSSFWorkbook workbook, XSSFSheet spreadsheet) {
        this.workbook = workbook;
        this.spreadsheet=spreadsheet;
        Styles.create(cellStyles,workbook,spreadsheet);
    }

    public enum StyleKind {

        NOT_FILLED_CELL_10_BLUE_TEXT,
        ORANGE_FILLED_CELL_10_Brown_TEXT,
        CELL_BORDERED_STRING_10_CENTER,
        TITLE_16_BOLD_vCENTR_text,
        ORANGE_FILLED_CELL_HUGE_16_WHITE_TEXT,
        ORANGE_FILLED_CELL_Little_9_Blue_TEXT,
        WRAPTEXT,
        Standart11,
        TITLE_14_BOLD_GREY80_vCENTR_text,
        PRICE_DATE,
        Standart12,
        TABLEHEAD,
        TABLEHEAD_18_Bold_80Grey,
        TITLE_11_BOLD_GREY80_vCENTR_text,
        Huge22BoldGrey50Text,
        TABLECATEGORY,
        PERMANENTDATASTRING,
        PERMANENTDANUMERIC_NotNegative,
        PERMANENTDANUMERIC_withNehative,
        TITLE_REPORT_TNP, 
        DATE_REPORT_TNP,
        REPORT_TNP_TABLE_HEAD, 
        PRODUCT_BLOCK__REPORT_TNP_VALUE, 
        REPORT_TNP_TABLE_LEFT,
        LEVE1_CATEGORY, LEVE2_CATEGORY,
        REPORT_TNP_DETALE_HEADER,
        REPORT_TNP_DETALE_TEXT, 
        REPORT_TNP_DETALE_HEADER_LEVEL2,
        REPORT_TNP_DETALE_TEXT_LEFT, 
        REPORT_TNP_DETALE_TEXT_RIGHT;
    }
    public  CellStyle getCellStyle(StyleKind skp){
        return cellStyles.get(skp);
    }

}
