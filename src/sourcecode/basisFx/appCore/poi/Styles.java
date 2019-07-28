package basisFx.appCore.poi;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.HashMap;

public class Styles {

    public static void create(HashMap<CellStylesStore.StyleKind, CellStyle> cellStyles, XSSFWorkbook workbook, XSSFSheet spreadsheet){
        cellStyles.put(CellStylesStore.StyleKind.TITLE_16_BOLD_vCENTR_text,
                new CellStylePOIHandler(workbook, spreadsheet)
                        .setFontHeight(18)
                        .setFontName("Calibri")
                        .setVerticalAlignmentCENTER()
                        .setFontBold()
                        .getСellStyle()
        );

        cellStyles.put(CellStylesStore.StyleKind.TITLE_14_BOLD_GREY80_vCENTR_text,
                new CellStylePOIHandler(workbook, spreadsheet)
                        .setFontHeight(14)
                        .setFontColor( HSSFColor.HSSFColorPredefined.GREY_80_PERCENT.getIndex())
                        .setVerticalAlignmentCENTER()
                        .setFontName("Calibri")
                        .setWrapText()
                        .setFontBold()
                        .getСellStyle()
        );

        cellStyles.put(CellStylesStore.StyleKind.TITLE_11_BOLD_GREY80_vCENTR_text,
                new CellStylePOIHandler(workbook, spreadsheet)
                        .setFontHeight(11)
                        .setFontName("Calibri")
                        .setFontColor( HSSFColor.HSSFColorPredefined.GREY_80_PERCENT.getIndex())
                        .setVerticalAlignmentCENTER()
                        .setFontBold()
                        .getСellStyle()
        );

        cellStyles.put(CellStylesStore.StyleKind.WRAPTEXT,
                new CellStylePOIHandler(workbook, spreadsheet)
                        .setWrapText()
                        .getСellStyle()
        );

        cellStyles.put(CellStylesStore.StyleKind.Standart12,
                new CellStylePOIHandler(workbook, spreadsheet)
                        .setFontHeight(12)
                        .setVerticalAlignmentCENTER()
                        .setFontName("Calibri")
                        .getСellStyle()
        );

        cellStyles.put(CellStylesStore.StyleKind.Standart11,
                new CellStylePOIHandler(workbook, spreadsheet)
                        .setFontHeight(11)
                        .setVerticalAlignmentCENTER()
                        .setFontName("Calibri")
                        .getСellStyle()
        );



        cellStyles.put(CellStylesStore.StyleKind.PRICE_DATE,
                new CellStylePOIHandler(workbook, spreadsheet)
                        .setFontHeight(14)
                        .setFontName("Calibri")
                        .getСellStyle()
        );



        cellStyles.put(CellStylesStore.StyleKind.Huge22BoldGrey50Text,
                new CellStylePOIHandler(workbook, spreadsheet)
                        .setFontHeight(22)
                        .setFontColor(IndexedColors.GREY_50_PERCENT.index)
                        .setFontName("Calibri")
                        .setVerticalAlignmentCENTER()
                        .setFontBold()
                        .getСellStyle()
        );

        cellStyles.put(CellStylesStore.StyleKind.TABLEHEAD,
                new CellStylePOIHandler(workbook, spreadsheet)
                        .setFontHeight(11)
                        .setFontColor( HSSFColor.HSSFColorPredefined.GREY_80_PERCENT.getIndex())
                        .setFontBold()
                        .setWrapText()
                        .setHorizontalAlignmentCENTER()
                        .setVerticalAlignmentCENTER()
                        .setBorder(BorderStyle.THIN,
                                BorderStyle.THIN,
                                BorderStyle.THIN,
                                BorderStyle.THIN,
                                IndexedColors.BLACK.index).
                        setFontName("Calibri")
                        .getСellStyle()
        );
        cellStyles.put(CellStylesStore.StyleKind.ORANGE_FILLED_CELL_Little_9_Blue_TEXT,
                new CellStylePOIHandler(workbook, spreadsheet)
                        .setFontHeight(9)
                        .setFontColorRGB(31,78,120)
                        .setFillForegroundColRGB(255,242,204)
                        .setFillPattern(FillPatternType.SOLID_FOREGROUND)
                        .setFontBold()
                        .setWrapText()
//                        .setHorizontalAlignmentCENTER()
//                        .setVerticalAlignmentCENTER()
                        .setBorder(BorderStyle.THIN,
                                BorderStyle.THIN,
                                BorderStyle.THIN,
                                BorderStyle.THIN,
                                IndexedColors.BLACK.index).
                        setFontName("Calibri")
                        .getСellStyle()
        );
        cellStyles.put(CellStylesStore.StyleKind.ORANGE_FILLED_CELL_HUGE_16_WHITE_TEXT,
                new CellStylePOIHandler(workbook, spreadsheet)
                        .setFontHeight(16)
                        .setFontColor(HSSFColor.HSSFColorPredefined.WHITE.getIndex())
                        .setFillForegroundColRGB(244,176,132)
                        .setFillPattern(FillPatternType.SOLID_FOREGROUND)
                        .setFontBold()
                        .setWrapText()
                        .setHorizontalAlignmentCENTER()
                        .setVerticalAlignmentCENTER()
                        .setBorder(BorderStyle.THIN,
                                BorderStyle.THIN,
                                BorderStyle.THIN,
                                BorderStyle.THIN,
                                IndexedColors.BLACK.index).
                        setFontName("Calibri")
                        .getСellStyle()
        );

        cellStyles.put(CellStylesStore.StyleKind.TABLEHEAD_18_Bold_80Grey,
                new CellStylePOIHandler(workbook, spreadsheet)
                        .setFontHeight(18)
                        .setFontColor( HSSFColor.HSSFColorPredefined.GREY_80_PERCENT.getIndex())
                        .setFontBold()
                        .setHorizontalAlignmentCENTER()
                        .setVerticalAlignmentCENTER()
                        .setBorder(BorderStyle.THIN,
                                BorderStyle.THIN,
                                BorderStyle.THIN,
                                BorderStyle.THIN,
                                IndexedColors.BLACK.index).
                        setFontName("Calibri")
                        .getСellStyle()
        );

        cellStyles.put(CellStylesStore.StyleKind.TABLECATEGORY,
                new CellStylePOIHandler(workbook, spreadsheet)
                        .setFontHeight(10)
                        .setFontColor(HSSFColor.BLACK.index)
                        .setFontBold()
                        .setFillForegroundCol(IndexedColors.YELLOW.index)
                        .setFillPattern(FillPatternType.SOLID_FOREGROUND)
                        .setFontName("Times New Roman")
                        .setBorder(
                                BorderStyle.THIN,
                                BorderStyle.THIN,
                                BorderStyle.THIN,
                                BorderStyle.THIN,
                                IndexedColors.BLACK.index)
                        .getСellStyle()
        );

        cellStyles.put(CellStylesStore.StyleKind.PERMANENTDATASTRING,
                new CellStylePOIHandler(workbook, spreadsheet)
                        .setFontHeight(10)
                        .setFontColor(HSSFColor.HSSFColorPredefined.BLACK.getIndex())
                        .setBorder(BorderStyle.THIN,
                                BorderStyle.THIN,
                                BorderStyle.THIN,
                                BorderStyle.THIN,
                                IndexedColors.BLACK.index)
                        .getСellStyle()
        );
        cellStyles.put(CellStylesStore.StyleKind.ORANGE_FILLED_CELL_10_Brown_TEXT,
                new CellStylePOIHandler(workbook, spreadsheet)
                        .setFontHeight(10)
                        .setFontColorRGB(131,60,12)
                        .setFillForegroundColRGB(255,242,204)
                        .setFillPattern(FillPatternType.SOLID_FOREGROUND)
                        .setBorder(BorderStyle.THIN,
                                BorderStyle.THIN,
                                BorderStyle.THIN,
                                BorderStyle.THIN,
                                IndexedColors.BLACK.index)
                        .getСellStyle()
        );
        cellStyles.put(CellStylesStore.StyleKind.NOT_FILLED_CELL_10_BLUE_TEXT,
                new CellStylePOIHandler(workbook, spreadsheet)
                        .setFontHeight(10)
                        .setFontColorRGB(31,78,120)
                        .setBorder(BorderStyle.THIN,
                                BorderStyle.THIN,
                                BorderStyle.THIN,
                                BorderStyle.THIN,
                                IndexedColors.BLACK.index)
                        .getСellStyle()
        );
        cellStyles.put(CellStylesStore.StyleKind.CELL_BORDERED_STRING_10_CENTER,
                new CellStylePOIHandler(workbook, spreadsheet)
                        .setFontHeight(10)
                        .setHorizontalAlignmentCENTER()
                        .setVerticalAlignmentCENTER()
                        .setFontColor(HSSFColor.HSSFColorPredefined.BLACK.getIndex())
                        .setBorder(BorderStyle.THIN,
                                BorderStyle.THIN,
                                BorderStyle.THIN,
                                BorderStyle.THIN,
                                IndexedColors.BLACK.index)
                        .getСellStyle()
        );

        cellStyles.put(CellStylesStore.StyleKind.PERMANENTDANUMERIC_NotNegative,
                new CellStylePOIHandler(workbook, spreadsheet)
//                    .setCellType(CellType.NUMERIC)
                        .setFontHeight(10)
                        .setFontColor(HSSFColor.BLACK.index)
                        .setDataFormatForNumericNotNegative()
                        .setBorder(BorderStyle.THIN,
                                BorderStyle.THIN,
                                BorderStyle.THIN,
                                BorderStyle.THIN,
                                IndexedColors.BLACK.index)
                        .getСellStyle()
        );

        cellStyles.put(CellStylesStore.StyleKind.PERMANENTDANUMERIC_withNehative,
                new CellStylePOIHandler(workbook, spreadsheet)
//                    .setCellType(CellType.NUMERIC)
                        .setFontHeight(10)
                        .setFontColor(HSSFColor.BLACK.index)
                        .setDataFormatForNumericWithNegative()
                        .setBorder(BorderStyle.THIN,
                                BorderStyle.THIN,
                                BorderStyle.THIN,
                                BorderStyle.THIN,
                                IndexedColors.BLACK.index)
                        .getСellStyle()
        );


        cellStyles.put(CellStylesStore.StyleKind.TITLE_REPORT_TNP,
                new CellStylePOIHandler(workbook, spreadsheet)
                        .setFontHeight(25)
                        .setFontName("Calibri")
                        .setFontColor(HSSFColor.WHITE.index)
                        .setFontBold()
                        .setHorizontalAlignmentCENTER()
                        .setVerticalAlignmentCENTER()
                        .setFontColorRGB(255, 255, 255)
                        .setFillForegroundColRGB(95,158,160)
                        .setFillPattern(FillPatternType.SOLID_FOREGROUND)
                        .setBorder(BorderStyle.THIN,
                                BorderStyle.THIN,
                                BorderStyle.THIN,
                                BorderStyle.THIN,
                                IndexedColors.BLACK.index)
                        .getСellStyle()
        );

        cellStyles.put(CellStylesStore.StyleKind.DATE_REPORT_TNP,
                new CellStylePOIHandler(workbook, spreadsheet)
                        .setFontHeight(14)
                        .setFontName("Calibri")
                        .setFontBold()
                        .setFontColor(HSSFColor.ORANGE.index)
                        .setFillForegroundColRGB(255,222,173)
                        .setFillPattern(FillPatternType.SOLID_FOREGROUND)
                        .setBorder(BorderStyle.THIN,
                                BorderStyle.THIN,
                                BorderStyle.THIN,
                                BorderStyle.THIN,
                                IndexedColors.BLACK.index)
                        .getСellStyle()
        );

        cellStyles.put(CellStylesStore.StyleKind.REPORT_TNP_TABLE_HEAD,
                new CellStylePOIHandler(workbook, spreadsheet)
                        .setFontHeight(12)
                        .setFontName("Calibri")
                        .setFontBold()
                        .setWrapText()
                        .setFontHeight(12)
                        .setFontColorRGB(255, 255, 255)
                        .setFillForegroundColRGB(244, 176, 132)
                        .setFillPattern(FillPatternType.SOLID_FOREGROUND)
                        .setBorder(BorderStyle.THIN,
                                BorderStyle.THIN,
                                BorderStyle.THIN,
                                BorderStyle.THIN,
                                IndexedColors.BLACK.index)
                        .getСellStyle()
        );

        cellStyles.put(CellStylesStore.StyleKind.REPORT_TNP_TABLE_LEFT,
                new CellStylePOIHandler(workbook, spreadsheet)
                        .setFontHeight(14)
                        .setFontName("Calibri")
                        .setFontBold()
                        .setWrapText()
                        .setFontColor(HSSFColor.TEAL.index)
                        .setFillForegroundColRGB(255,222,173)
                        .setFillPattern(FillPatternType.SOLID_FOREGROUND)
                        .setBorder(BorderStyle.THIN,
                                BorderStyle.THIN,
                                BorderStyle.THIN,
                                BorderStyle.THIN,
                                IndexedColors.BLACK.index)
                        .getСellStyle()
        );

        cellStyles.put(CellStylesStore.StyleKind.LEVE1_CATEGORY,
                new CellStylePOIHandler(workbook, spreadsheet)
                        .setFontHeight(28)
                        .setFontName("Calibri")
                        .setFontBold()
                        .setWrapText()
                        .setHorizontalAlignmentCENTER()
                        .setVerticalAlignmentCENTER()
                        .setFontColorRGB(0, 128, 128)
                        .setBorder(BorderStyle.THIN,
                                BorderStyle.THIN,
                                BorderStyle.THIN,
                                BorderStyle.THIN,
                                IndexedColors.BLACK.index)
                        .getСellStyle()
        );

        cellStyles.put(CellStylesStore.StyleKind.LEVE2_CATEGORY,
                new CellStylePOIHandler(workbook, spreadsheet)
                        .setFontHeight(18)
                        .setFontName("Calibri")
                        .setFontBold()
                        .setWrapText()
                        .setFontColorRGB(0, 128, 128)
                        .setBorderRGB(BorderStyle.NONE,
                                BorderStyle.NONE,
                                BorderStyle.THIN,
                                BorderStyle.NONE,
                                new XSSFColor(new java.awt.Color(54, 96, 146)))
                        .getСellStyle()


        );
        cellStyles.put(CellStylesStore.StyleKind.PRODUCT_BLOCK__REPORT_TNP_VALUE,
                new CellStylePOIHandler(workbook, spreadsheet)
                        .setFontHeight(11)
                        .setFontName("Calibri")
                        .setFontColorRGB(0, 128, 128)
                        .setDataFormatForNumericNotNegative()
                        .setBorder(BorderStyle.THIN,
                                BorderStyle.THIN,
                                BorderStyle.THIN,
                                BorderStyle.THIN,
                                IndexedColors.BLACK.index)
                        .getСellStyle()
        );

        cellStyles.put(CellStylesStore.StyleKind.REPORT_TNP_DETALE_HEADER,
                new CellStylePOIHandler(workbook, spreadsheet)
                        .setFontHeight(14)
                        .setFontName("Calibri")
                        .setFontBold()
                        .setHorizontalAlignmentCENTER()
                        .setFontColorRGB(33, 89, 103)
//                         .setFillForegroundColRGB(255, 247, 239)
//                         .setFillPattern(FillPatternType.SOLID_FOREGROUND)
//                         .setBorder(BorderStyle.THIN,
//                                    BorderStyle.THIN,
//                                    BorderStyle.THIN,
//                                    BorderStyle.THIN,
//                                    IndexedColors.BLACK.index)
                        .getСellStyle()
        );


        cellStyles.put(CellStylesStore.StyleKind.REPORT_TNP_DETALE_TEXT_LEFT,
                new CellStylePOIHandler(workbook, spreadsheet)
                        .setFontHeight(12)
                        .setFontName("Calibri")
                        .setHorizontalAlignmentRight()
                        .setFontColorRGB(33, 89, 103)
                        .setWrapText()
//                         .setBorder(BorderStyle.NONE,
//                                    BorderStyle.NONE,
//                                    BorderStyle.NONE,
//                                    BorderStyle.THIN,
//                                    IndexedColors.BLACK.index)
                        .getСellStyle()
        );

        cellStyles.put(CellStylesStore.StyleKind.REPORT_TNP_DETALE_TEXT_RIGHT,
                new CellStylePOIHandler(workbook, spreadsheet)
                        .setFontHeight(12)
                        .setFontName("Calibri")
                        .setFontColorRGB(33, 89, 103)
                        .setWrapText()
                        .setHorizontalAlignmentLeft()
                        .setDataFormatForNumericNotNegative()
//                         .setBorder(BorderStyle.NONE,
//                                    BorderStyle.THIN,
//                                    BorderStyle.NONE,
//                                    BorderStyle.NONE,
//                                    IndexedColors.BLACK.index)
                        .getСellStyle()
        );

        cellStyles.put(CellStylesStore.StyleKind.REPORT_TNP_DETALE_TEXT,
                new CellStylePOIHandler(workbook, spreadsheet)
                        .setFontHeight(12)
                        .setFontName("Calibri")
                        .setFontColorRGB(33, 89, 103)
                        .setWrapText()
                        .getСellStyle()
        );

        cellStyles.put(CellStylesStore.StyleKind.REPORT_TNP_DETALE_HEADER_LEVEL2,
                new CellStylePOIHandler(workbook, spreadsheet)
                        .setFontHeight(12)
                        .setFontName("Calibri")
                        .setFontBold()
                        .setHorizontalAlignmentCENTER()
                        .setFontColorRGB(33, 89, 103)
//                         .setBorder(BorderStyle.THIN,
//                                    BorderStyle.THIN,
//                                    BorderStyle.THIN,
//                                    BorderStyle.THIN,
//                                    IndexedColors.BLACK.index)
                        .getСellStyle()
        );

    }

}
