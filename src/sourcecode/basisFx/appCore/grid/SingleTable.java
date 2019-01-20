package basisFx.appCore.grid;

import basisFx.appCore.elements.TableWrapper;
import javafx.geometry.Insets;
import javafx.scene.control.Button;


public class SingleTable extends GridOrganization{
    private ButSizeForGrid butSizeForGrid;
    private Button add;
    private Button del;
    protected TableWrapper tableWrapper=null;

    public SingleTable(TableWrapper tableWrapper, ButSizeForGrid butSizeForGrid, CtrlPosition position) {

            this.tableWrapper = tableWrapper;
            this.ctrlPosition =position;
            this.butSizeForGrid = butSizeForGrid;
            this.butSizeForGrid.setTableWrapper(tableWrapper);
            this.butSizeForGrid.init();

    }

    public void setTableWrapper(TableWrapper tableWrapper) {
        this.tableWrapper = tableWrapper;
    }

    public SingleTable(ButSizeForGrid butSizeForGrid, CtrlPosition position) {
        this.ctrlPosition =position;
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
                    ctrlPosition instanceof CtrlPosNotExist
            ){
                organizeNonButtons();
            }else{

                organizeWithButtons();
            }


    }

    private void organizeNonButtons() {
        parentGridWrapper.setColumnComputerWidth();
        ctrlPosition.setParentGridWrapper(parentGridWrapper);
        label= parentGridWrapper.label.getElement();
        bindHeight(tableWrapper);
        ctrlPosition.organize(label, tableWrapper.getElement()  );
    }

    private void organizeWithButtons() {
        butSizeForGrid.setTableWrapper(tableWrapper);
        butSizeForGrid.init();

        parentGridWrapper.setColumnComputerWidth();
        parentGridWrapper.setColumnFixed(butSizeForGrid.getColumnWidth());
        parentGridWrapper.setColumnFixed(butSizeForGrid.getColumnWidth());

        ctrlPosition.setParentGridWrapper(parentGridWrapper);
        bindHeight(tableWrapper);

        ctrlPosition.organize(
                parentGridWrapper.label.getElement(),
                butSizeForGrid.buttonAdd,
                butSizeForGrid.buttonDel,
                tableWrapper.getElement()
        );
    }
}
