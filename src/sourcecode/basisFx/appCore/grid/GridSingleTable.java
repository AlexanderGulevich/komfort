package basisFx.appCore.grid;

import basisFx.appCore.elements.TableWrapper;
import javafx.geometry.Insets;
import javafx.scene.control.Button;


public class GridSingleTable extends GridOrganization{
    private ButtonsSizeForGrid buttonsSizeForGrid;
    private Button add;
    private Button del;
    protected TableWrapper tableWrapper=null;

    public GridSingleTable(TableWrapper tableWrapper, ButtonsSizeForGrid buttonsSizeForGrid, ButtonsPosition position) {

            this.tableWrapper = tableWrapper;
            this.buttonsPosition=position;
            this.buttonsSizeForGrid = buttonsSizeForGrid;
            this.buttonsSizeForGrid.setTableWrapper(tableWrapper);
            this.buttonsSizeForGrid.init();

    }

    public void setTableWrapper(TableWrapper tableWrapper) {
        this.tableWrapper = tableWrapper;
    }

    public GridSingleTable(ButtonsSizeForGrid buttonsSizeForGrid, ButtonsPosition position) {
        this.buttonsPosition=position;
        this.buttonsSizeForGrid = buttonsSizeForGrid;

    }

    @Override
    public GridSingleTable setInsets(Insets insets) {
        this.insets = insets;
        return this;
    }


    @Override
    public void organize() {

            if (buttonsSizeForGrid instanceof  ButtonsSizeNon &&
                    buttonsPosition instanceof  ButPositionNotExist
            ){
                organizeNonButtons();
            }else{

                organizeWithButtons();
            }


    }

    private void organizeNonButtons() {
        parentGridWrapper.setColumnComputerWidth();
        buttonsPosition.setParentGridWrapper(parentGridWrapper);
        label= parentGridWrapper.label.getElement();
        bindHeight(tableWrapper);
        buttonsPosition.organize(label, tableWrapper.getElement()  );
    }

    private void organizeWithButtons() {
        buttonsSizeForGrid.setTableWrapper(tableWrapper);
        buttonsSizeForGrid.init();

        parentGridWrapper.setColumnComputerWidth();
        parentGridWrapper.setColumnFixed(buttonsSizeForGrid.getColumnWidth());
        parentGridWrapper.setColumnFixed(buttonsSizeForGrid.getColumnWidth());

        buttonsPosition.setParentGridWrapper(parentGridWrapper);


        bindHeight(tableWrapper);

        buttonsPosition.organize(
                parentGridWrapper.label.getElement(),
                buttonsSizeForGrid.buttonAdd,
                buttonsSizeForGrid.buttonDel,
                tableWrapper.getElement()
        );
    }
}
