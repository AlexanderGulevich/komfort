package basisFx.domain.price;

import basisFx.appCore.poi.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;

import static basisFx.appCore.poi.CellStylesStore.StyleKind.*;

public class WritePrice extends Writer {

    private Price price;
    private String  path;
    private ArrayList categoriesArrayList;
    int firstColIndex=1;
    int last=9;
    private CellHandler cellHandler ;

    public WritePrice(Price pr, String path)   {
        this.price=pr;
        this.path=path;
        this.categoriesArrayList=pr.getCategoriesArrayList();

            strHandler=new StringHandler();
            workbook= new XSSFWorkbook();
            spreadsheet = workbook.createSheet("Складские остатки");

            cellHandler=new CellHandler(workbook, spreadsheet);

            setPrintSetup();

        try {
            createFile();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void createFile() throws  IOException {

         out = new FileOutputStream(new File(this.path+"\\Прайс "+this.price.getPriceDateString()+".xlsx"));

         createHeader();
         createTableHead();
         createPermanentData();

         setColumnWidth(2,8,15,23,45,10,10,9,14,20);

         workbook.write(out);
         out.close();
         workbook.close();

    }


    private void createHeader(){
        createHollowMergedRow();
        createNewRow();

        cellHandler.setCell(row.createCell(firstColIndex))
                   .setCellValue("РУП \"Бобруйская укрупненная типография им.А.Т.Непогодина\"  ")
                   .setRowHeight(row, 30)
                   .setCellStyle(TITLE_16_BOLD_vCENTR_text)
                   .addMergedRegion(row.getRowNum() , row.getRowNum(), firstColIndex, last-3);

        cellHandler.setCell(row.createCell(last-2))
                   .setCellValue("     КОНТАКТЫ ТИПОГРАФИИ")
                   .addMergedRegion(row.getRowNum() , row.getRowNum() , last-2, last)
                   .setCellStyle(TITLE_11_BOLD_GREY80_vCENTR_text);

        createNewRow();

        cellHandler.setCell(row.createCell(firstColIndex))
                   .setCellValue("Ведомость наличия товара на "+price.getPriceDateString()+" г.")
                   .setRowHeight(row, 22)
                   .addMergedRegion(row.getRowNum() , row.getRowNum(), firstColIndex, last-3)
                   .setCellStyle(Standart12);


         cellHandler.setCell(row.createCell(  last-2 ))
                     .setRowHeight(row, 22)
                     .addMergedRegion(row.getRowNum() , row.getRowNum() , last-2, last)
                     .setCellValue("     e-mail:        hepogodin@mail.ru")
                     .setCellStyle(Standart11);

        createNewRow();

        cellHandler.setCell(row.createCell(firstColIndex))
                   .addMergedRegion(row.getRowNum() , row.getRowNum(), firstColIndex, last-3);


        cellHandler.setCell(row.createCell( last-2  ))
                     .setCellValue("     тел.:             8 0225 72 25 16")
                     .setRowHeight(row, 22)
                     .addMergedRegion(row.getRowNum() , row.getRowNum() , last-2, last)
                     .setCellStyle(Standart11);


        createNewRow();


        cellHandler.setCell(row.createCell(firstColIndex))
                     .setCellValue("Наименование заказчика :  ")
                     .setRowHeight(row, 50)
                     .addMergedRegion(row.getRowNum(), row.getRowNum(), firstColIndex, firstColIndex +2)
                     .setCellStyle(TITLE_14_BOLD_GREY80_vCENTR_text);

        cellHandler.setCell(row.createCell( firstColIndex +3  ))
                     .addMergedRegion(row.getRowNum(), row.getRowNum(), firstColIndex +3, last)
                     .multipleSetStyle(row,firstColIndex +3, last, Huge22BoldGrey50Text);

        createHollowMergedRow();

    }

    private void createNewRow() {
        row = spreadsheet.createRow(numRows++);
    }

    private void createHollowMergedRow() {
        createNewRow();
        cellHandler.setCell(row.createCell(firstColIndex)).addMergedRegion(row.getRowNum(), row.getRowNum(), firstColIndex, last);
    }


    private void createTableHead() {

        createNewRow();
        row.setHeightInPoints(40);

           cellHandler.setCell(row.createCell(firstColIndex))
                    .setCellValue("№")
                    .setCellStyle(ORANGE_FILLED_CELL_HUGE_16_WHITE_TEXT);

        cellHandler.setCell(row.createCell( firstColIndex +1  ))
                .setCellValue("Шрихкод и КАРТИНКА при наведении")
                .setCellStyle(ORANGE_FILLED_CELL_Little_9_Blue_TEXT);

        cellHandler.setCell(row.createCell( firstColIndex +2  ))
                .setCellValue("Наименование продукции")
                .addMergedRegion(row.getRowNum(), row.getRowNum(), firstColIndex +2, firstColIndex +3)
                .multipleSetStyle(row,firstColIndex +2, firstColIndex +3, TABLEHEAD_18_Bold_80Grey);

        cellHandler.setCell(row.createCell( firstColIndex +4  ))
                .setCellValue("Ед. Изм.")
                .setCellStyle(TABLEHEAD);

        cellHandler.setCell(row.createCell( firstColIndex +5  ))
                .setCellValue("Кол-во в упаковке")
                .setCellStyle(TABLEHEAD);

           cellHandler.setCell(row.createCell(  firstColIndex +6 ))
                    .setCellValue("Цена б/НДС")
                    .setCellStyle(TABLEHEAD);


            cellHandler.setCell(row.createCell( firstColIndex +7  ))
                    .setCellValue("Количество на складе")
                    .setCellStyle(TABLEHEAD);


           cellHandler.setCell(row.createCell( firstColIndex +8  ))
                    .setCellValue("Заявка")
                    .setCellStyle(TABLEHEAD);

    }

    private void createPermanentData() {

        createNewRow();

        for (Iterator it = categoriesArrayList.iterator(); it.hasNext();) {
                PriceCategory pc = (PriceCategory) it.next();

             cellHandler.setCell(row.createCell(firstColIndex))
            .setCellValue("                * "+pc.getName())
            .addMergedRegion(row.getRowNum(), row.getRowNum(), firstColIndex, last)
            .multipleSetStyle(row,firstColIndex , last, TABLECATEGORY);

             row.setHeightInPoints(15);

            createNewRow();

            for (TNPProduct filds : pc.getFilds()) {

            row.setHeightInPoints(15);


           cellHandler.setCell(row.createCell(firstColIndex))
                    .setCellValue(filds.getOrder())
                    .setCellStyle(PERMANENTDATASTRING);

                String barcode = filds.getBarcode();
                if (barcode != null) {

                    if (filds.getImg() != null) {
                        cellHandler.setCell(row.createCell(  firstColIndex +1))
                                .setCellValue("  "+filds.getBarcode())
                                .setCellStyle(ORANGE_FILLED_CELL_10_Brown_TEXT);
                    }else {
                        cellHandler.setCell(row.createCell(  firstColIndex +1))
                                .setCellValue("  "+filds.getBarcode())
                                .setCellStyle(ORANGE_FILLED_CELL_10_Brown_TEXT);
                    }

                }else{

                    cellHandler.setCell(row.createCell(  firstColIndex +1))
                            .setCellValue("---")
                            .setCellStyle(CELL_BORDERED_STRING_10_CENTER);
                }


          cellHandler.setCell(row.createCell(  firstColIndex +2))
                    .setCellValue("  "+filds.getName())
                    .addMergedRegion(row.getRowNum(), row.getRowNum(), firstColIndex +2, firstColIndex +3)
                    .setCellStyle(PERMANENTDATASTRING);

           cellHandler.setCell(row.createCell(  firstColIndex +3))
                    .setCellStyle(PERMANENTDATASTRING);


          cellHandler.setCell(row.createCell(  firstColIndex +4))
                    .setCellValue(filds.getMeasure())
                    .setCellStyle(PERMANENTDATASTRING);

                String amountInBox = filds.getAmountInBox();
                if (amountInBox != null) {
                    cellHandler.setCell(row.createCell(  firstColIndex +5))
                            .setCellValue(Double.parseDouble(amountInBox))
                            .setCellStyle(PERMANENTDATASTRING);
                }else {
                    cellHandler.setCell(row.createCell(  firstColIndex +5))
                            .setCellValue("---")
                            .setCellStyle(CELL_BORDERED_STRING_10_CENTER);
                }




          cellHandler.setCell(row.createCell(  firstColIndex +6))
                    .setCellStyle(PERMANENTDANUMERIC_withNehative)
                    .setCellValue(
                              new BigDecimal(
                              String.valueOf(filds.getPricePerUnit())
                             ).setScale(2, RoundingMode.CEILING).doubleValue()

                    );
            cellHandler.setCell(row.createCell(  firstColIndex +7))
                    .setCellStyle(PERMANENTDANUMERIC_NotNegative)
                    .setCellValue(
                              new BigDecimal(
                              String.valueOf(filds.getAmountInPrice())
                             ).setScale(2, RoundingMode.CEILING).doubleValue()

                    );

            cellHandler.setCell(row.createCell(  firstColIndex +8))
                    .setCellStyle(PERMANENTDANUMERIC_NotNegative);


                createNewRow();


            }


        }



    }



}
