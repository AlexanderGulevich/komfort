package basisFx.appCore.grid;

import basisFx.appCore.elements.LabelWrapper;
import basisFx.appCore.settings.CSSID;
import basisFx.appCore.settings.FontsStore;
import javafx.geometry.HPos;
import javafx.geometry.VPos;

public class GridOrganizationInnerTwoGridsTwoTables extends GridOrganization {

    protected GridPaneWrapper leftGridWrapper;
    protected GridPaneWrapper rightGridWrapper;

    public void setLeftGridWrapper(GridPaneWrapper leftGridWrapper) {
        this.leftGridWrapper = leftGridWrapper;
    }

    public void setRightGridWrapper(GridPaneWrapper rightGridWrapper) {
        this.rightGridWrapper = rightGridWrapper;
    }

    @Override
    public void organize() {

        bindHeight(leftGridWrapper);
        bindHeight(rightGridWrapper);

        if (parentGridWrapper.getName() != null) {
            createInnerNodsAndCommonName();
        }else{
            createInnerNodsWithoutCommonName();
        }
        applyWidth();
    }

    private void applyWidth() {

        System.out.println("GridOrganizationInnerTwoGridsTwoTables.applyWidth");
        parentGridWrapper.getElement().getColumnConstraints().get(0).prefWidthProperty().addListener(
                (observable, oldValue, newValue) -> {
                    leftGridWrapper.getElement().setPrefWidth(newValue.doubleValue());

                    System.err.println(newValue.doubleValue());


                }
        );

         parentGridWrapper.getElement().getColumnConstraints().get(1).prefWidthProperty().addListener(
                (observable, oldValue, newValue) -> {
                    rightGridWrapper.getElement().setPrefWidth(newValue.doubleValue());

                    System.err.println(newValue.doubleValue());
                }
        );


    }

    private void createInnerNodsAndCommonName() {
        LabelWrapper labelWrapper = createCommonLabel();

        parentGridWrapper.addSpanNode(
                labelWrapper.getElement(),
                0,0,2,1, HPos.LEFT, VPos.CENTER,insets);

        parentGridWrapper.addSpanNode(
                leftGridWrapper.getElement(),
                0,1,1,1, HPos.LEFT, VPos.TOP,insets);

        parentGridWrapper.addSpanNode(
                rightGridWrapper.getElement(),
                1,1,1,1, HPos.LEFT, VPos.TOP,insets);
    }

    private LabelWrapper createCommonLabel() {
        return LabelWrapper.newBuilder()
                    .setName(parentGridWrapper.getName())
                    .setCssid(CSSID.LABEL_TEXT)
                    .setFontSize(25d)
                    .setFont(FontsStore.ROBOTO_BOLD)
                    .build();
    }

    private void createInnerNodsWithoutCommonName() {
        parentGridWrapper.addSpanNode(
                leftGridWrapper.getElement(),
                0,0,1,1, HPos.LEFT, VPos.TOP,insets);

        parentGridWrapper.addSpanNode(
                rightGridWrapper.getElement(),
                1,0,1,1, HPos.LEFT, VPos.TOP,insets);
    }


//
//
//
//        gridPane.heightProperty().addListener((obs, oldVal, newVal) -> {
//
//
//        observedGrid.getGridPane().setPrefHeight(gridPane.getHeight());
//        observerGrid.getGridPane().setPrefHeight(gridPane.getHeight());
//
//    });


}
