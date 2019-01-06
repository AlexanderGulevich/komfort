package basisFx.appCore.grid;

import basisFx.appCore.elements.GridPaneWrapper;
import basisFx.appCore.elements.LabelWrapper;
import basisFx.appCore.settings.CSSid;
import basisFx.appCore.settings.FontsStore;
import javafx.geometry.HPos;
import javafx.geometry.VPos;

public class GridTwoVerticaGrids extends GridOrganization {

    protected GridPaneWrapper gridWrapperTop;
    protected GridPaneWrapper gridWrapperBottom;


    public GridTwoVerticaGrids(GridOrganization organizationTop, GridOrganization organizationBottom) {

        gridWrapperTop = GridPaneWrapper.newBuilder()
                .setGridLinesVisibility(false)
                .setColumnVsPercent(40)
                .setColumnVsPercent(60)
                .setGridOrganization(organizationTop).build();

        gridWrapperBottom = GridPaneWrapper.newBuilder()
                .setGridLinesVisibility(false)
                .setColumnVsPercent(40)
                .setColumnVsPercent(60)
                .setGridOrganization(organizationBottom).build();

    }
    private void applyWidth() {

        parentGridWrapper.getElement().getColumnConstraints().get(0).prefWidthProperty().addListener(
                (observable, oldValue, newValue) -> {
                    gridWrapperTop.getElement().setPrefWidth(newValue.doubleValue());
                    gridWrapperBottom.getElement().setPrefWidth(newValue.doubleValue());
                }
        );


    }

    @Override
    public void organize() {
        parentGridWrapper.setColumnComputerWidth();
        parentGridWrapper.setRowConstraints();
        parentGridWrapper.setRowConstraints();
        applyWidth();



        if (parentGridWrapper.getText() != null) {
            createInnerNodsAndCommonName();
        }else{
            createInnerNodsWithoutCommonName();
        }
    }


    private void createInnerNodsAndCommonName() {
        LabelWrapper labelWrapper = createCommonLabel();

        parentGridWrapper.addSpanNode(
                labelWrapper.getElement(),
                0,0,2,1, HPos.LEFT, VPos.CENTER,insets);

        parentGridWrapper.addSpanNode(
                gridWrapperTop.getElement(),
                0,1,2,1, HPos.LEFT, VPos.TOP,insets);

        parentGridWrapper.addSpanNode(
                gridWrapperBottom.getElement(),
                0,2,2,1, HPos.LEFT, VPos.TOP,insets);
    }

    private LabelWrapper createCommonLabel() {
        return LabelWrapper.newBuilder()
                .setText(parentGridWrapper.getText())
                .setCSSid(CSSid.LABEL_TEXT)
                .setFontSize(25d)
                .setFont(FontsStore.ROBOTO_BOLD)
                .build();
    }

    private void createInnerNodsWithoutCommonName() {
        parentGridWrapper.addSpanNode(
                gridWrapperTop.getElement(),
                0,0,1,1, HPos.LEFT, VPos.TOP,insets);

        parentGridWrapper.addSpanNode(
                gridWrapperBottom.getElement(),
                0,1,1,1, HPos.LEFT, VPos.TOP,insets);
    }

}
