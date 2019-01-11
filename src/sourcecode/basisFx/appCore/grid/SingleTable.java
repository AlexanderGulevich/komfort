package basisFx.appCore.grid;

import basisFx.appCore.elements.TableWrapper;
import javafx.geometry.Insets;
import javafx.scene.control.Button;


public class SingleTable extends GridOrganization{
    private ButSizeForGrid butSizeForGrid;
    private Button add;
    private Button del;
    protected TableWrapper tableWrapper=null;

    public SingleTable(TableWrapper tableWrapper, ButSizeForGrid butSizeForGrid, ButPosition position) {

            this.tableWrapper = tableWrapper;
            this.butPosition =position;
            this.butSizeForGrid = butSizeForGrid;
            this.butSizeForGrid.setTableWrapper(tableWrapper);
            this.butSizeForGrid.init();

    }

    public void setTableWrapper(TableWrapper tableWrapper) {
        this.tableWrapper = tableWrapper;
    }

    public SingleTable(ButSizeForGrid butSizeForGrid, ButPosition position) {
        this.butPosition =position;
        this.butSizeForGrid = butSizeForGrid;

    }

    @Override
    public SingleTable setInsets(Insets insets) {
        this.insets = insets;
        return this;
    }


    @Override
    public void organize() {

            if (butSizeForGrid instanceof ButSizeNon &&
                    butPosition instanceof ButPosNotExist
            ){
                organizeNonButtons();
            }else{

                organizeWithButtons();
            }


    }

    private void organizeNonButtons() {
        parentGridWrapper.setColumnComputerWidth();
        butPosition.setParentGridWrapper(parentGridWrapper);
        label= parentGridWrapper.label.getElement();
        bindHeight(tableWrapper);
        butPosition.organize(label, tableWrapper.getElement()  );
    }

    private void organizeWithButtons() {
        butSizeForGrid.setTableWrapper(tableWrapper);
        butSizeForGrid.init();

        parentGridWrapper.setColumnComputerWidth();
        parentGridWrapper.setColumnFixed(butSizeForGrid.getColumnWidth());
        parentGridWrapper.setColumnFixed(butSizeForGrid.getColumnWidth());

        butPosition.setParentGridWrapper(parentGridWrapper);


        bindHeight(tableWrapper);

        butPosition.organize(
                parentGridWrapper.label.getElement(),
                butSizeForGrid.buttonAdd,
                butSizeForGrid.buttonDel,
                tableWrapper.getElement()
        );
    }
}
