package basisFx.appCore.poi;

import org.apache.poi.hssf.usermodel.*;

import java.io.ByteArrayOutputStream;

public class CommentUtils {

    HSSFPatriarch patriarch;
    HSSFClientAnchor anchor;
    HSSFCreationHelper factory;
    HSSFComment comment;
    ByteArrayOutputStream baos;
    HSSFCell cell;
    HSSFRow  row;
    int      picIndex;
    HSSFWorkbook wb;

    public CommentUtils() {

        picIndex = wb.addPicture(baos.toByteArray(),HSSFWorkbook.PICTURE_TYPE_PNG);

        /* add comment with picture in it */
        int c = cell.getColumnIndex();
        int r = cell.getRowIndex();

        anchor = factory.createClientAnchor();
        anchor.setCol1(c);
        anchor.setCol2(c+4);
        anchor.setRow1(r);
        anchor.setRow2(r+8);

        comment = patriarch.createCellComment(anchor);
        comment.setBackgroundImage(picIndex); // set picture as background image

        cell.setCellComment(comment);

        new HSSFClientAnchor();

    }
}
