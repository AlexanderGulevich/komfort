package basisFx.service;

import basisFx.appCore.elements.ComboboxHandler;
import basisFx.appCore.elements.DatePickerHandler;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.events.ClosePopupAndSubWindow;
import basisFx.appCore.events.RowAddToTable;
import basisFx.appCore.events.RowDeleteFromTable;
import basisFx.appCore.events.StageDragging;
import basisFx.appCore.utils.Coordinate;
import basisFx.appCore.utils.RangeForCombobox;
import basisFx.appCore.utils.Registry;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public  class ServiceCrossWindowByDateResearch  extends ServiceCrossWindow   {

    private ComboboxHandler comboboxHandler;
    private DatePickerHandler datePickerHandlerSTART;
    private DatePickerHandler datePickerHandlerEND;
    private TableWrapper  table_wrapper;

    @FXML private AnchorPane dynamicContentAnchorHolder;
    @FXML private AnchorPane titlePanel;
    @FXML private Button addBut;
    @FXML private Button delBut;
    @FXML private Button okBut;
    @FXML private Label title;
    @FXML private DatePicker dateStart;
    @FXML private DatePicker dateEnd;
    @FXML private ComboBox combobox;

    @FXML public void initialize() { }

 //   @FXML
//    private void leftclick(ActionEvent event) {
//    }


    public ServiceCrossWindowByDateResearch() {
        Registry.serviceCrossWindowMap.put("ByDateResearchWindow",this);
    }
    @Override
    public void init() {
        initCloseButtonEvent();
        initStageDragging();
        initTitle();
        bondingToContentAnchorWidth();
        initAddDelButtonsEvents();
        initComboboxHandler();
        initDatePickersHadler();

    }

    private void initDatePickersHadler() {
        datePickerHandlerSTART=new DatePickerHandler(dateStart,this);
        datePickerHandlerEND=new DatePickerHandler(dateEnd,this);
    }

    private void initComboboxHandler() {
        comboboxHandler=new ComboboxHandler(
                combobox,
                this,
                RangeForCombobox.LAST10,
                RangeForCombobox.getAll()
        );
    }

    private void bondingToContentAnchorWidth() {
        dynamicContentAnchor = currentWindow.getCurrentDynamicContent().getDynamicContentAnchor();
        Coordinate coordinate = new Coordinate(0d, 0d, 0d, 0d);
        coordinate.setChildNode(dynamicContentAnchor);
        coordinate.setParentAnchorPane(dynamicContentAnchorHolder);
        coordinate.bonding();
    }

    private void initAddDelButtonsEvents() {
        table_wrapper= (TableWrapper) currentWindow.getNodeFromMap("TABLE_wrapper_ByDateResearchWindow");
        new RowAddToTable( table_wrapper ).setEventToElement(addBut);
        new RowDeleteFromTable( table_wrapper ).setEventToElement(delBut);
    }

    private void initCloseButtonEvent() {
        ClosePopupAndSubWindow closePopupAndSubWindow = new ClosePopupAndSubWindow();
        closePopupAndSubWindow.setMediator(this);
        closePopupAndSubWindow.setEventToElement(okBut);
    }

    private void initStageDragging() {
        new StageDragging().setEventToElement(titlePanel);
    }

    private void initTitle() {
        title.setText(currentWindow.getWindowImpl().getTitleName());
    }

    @Override
    public void inform(Object node) {
        if (node == okBut) {
            informParentWindowAboutClosing();
        }
        if (node == comboboxHandler) {
            System.out.println("=========="+comboboxHandler.getSelectedRange());
        }
        if (node == datePickerHandlerSTART) {
            System.out.println("=========="+datePickerHandlerSTART.getSelectedDate());
        }
        if (node == datePickerHandlerEND) {
            System.out.println("=========="+datePickerHandlerEND.getSelectedDate());
        }
    }
    public void informParentWindowAboutClosing() {
        currentWindow.getWindowImpl().getCallBackSubWindowClosing().call();
    }
}
