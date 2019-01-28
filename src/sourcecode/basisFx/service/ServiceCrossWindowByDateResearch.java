package basisFx.service;

import basisFx.appCore.elements.RangeDirector;
import basisFx.appCore.elements.DatePickerHandler;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.events.ClosePopupAndSubWindow;
import basisFx.appCore.events.RowAddToTable;
import basisFx.appCore.events.RowDeleteFromTable;
import basisFx.appCore.events.StageDragging;
import basisFx.appCore.utils.Coordinate;
import basisFx.appCore.utils.Range;
import basisFx.appCore.utils.Registry;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.time.LocalDate;

public  class ServiceCrossWindowByDateResearch  extends ServiceCrossWindow   {

    private RangeDirector rangeDirector;
    private DatePickerHandler datePickerHandlerSTART;
    private DatePickerHandler datePickerHandlerEND;
    private TableWrapper table_wrapper;
    private TableWrapper outer_table_wrapper;
    private LocalDate selectedDateStart ;
    private LocalDate selectedDateEnd ;

    @FXML private AnchorPane dynamicContentAnchorHolder;
    @FXML private AnchorPane titlePanel;
    @FXML private Button addBut;
    @FXML private Button delBut;
    @FXML private Button okBut;
    @FXML private Button periodBut;
    @FXML private Label title;
    @FXML private DatePicker dateStart;
    @FXML private DatePicker dateEnd;
    @FXML private ComboBox combobox;

    @FXML public void initialize() {
           outer_table_wrapper = (TableWrapper) Registry.mainWindow.getNodeFromMap("outer_table_wrapper_for_ByDateResearchWindow");
    }

    public ServiceCrossWindowByDateResearch() {
        Registry.crossWindowMediators.put("ByDateResearchWindow",this);
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
        initPeriodButEvent();

    }

    private void initDatePickersHadler() {
        datePickerHandlerSTART=new DatePickerHandler(dateStart,this);
        datePickerHandlerEND=new DatePickerHandler(dateEnd,this);
    }

    private void initComboboxHandler() {
        rangeDirector =new RangeDirector(
                combobox,
                this,
                Range.LAST10,
                Range.getAll()
        );
    }

    private void bondingToContentAnchorWidth() {
        dynamicContentAnchor = currentWindow.getCurrentDynamicContent().getDynamicContentAnchorHolder();
        Coordinate coordinate = new Coordinate(0d, 0d, 0d, 0d);
        coordinate.setChildNode(dynamicContentAnchor);
        coordinate.setParentAnchorPane(dynamicContentAnchorHolder);
        coordinate.bonding();
    }

    private void initAddDelButtonsEvents() {
        table_wrapper = (TableWrapper) currentWindow.getNodeFromMap("TABLE_wrapper_ByDateResearchWindow");

        new RowAddToTable(table_wrapper).setEventToElement(addBut);
        new RowDeleteFromTable(table_wrapper).setEventToElement(delBut);
    }

    private void initPeriodButEvent() {
        periodBut.setOnMousePressed(event -> {
            if (event.isPrimaryButtonDown() && event.getClickCount() == 1 ||  event.getClickCount() ==2 ) {
                if (selectedDateStart != null && selectedDateEnd!= null ) {
                    table_wrapper.getMediator()
                            .refreshViaPeriodAndOuterId(
                                    table_wrapper,
                                    outer_table_wrapper.clickedDomain.id.get(),
                                    selectedDateStart,
                                    selectedDateEnd
                            );
                }
            }
        });
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
        title.setText(outer_table_wrapper.clickedDomain.toString());
    }

    @Override
    public void inform(Object node) {
        if (node == okBut) {
            informParentWindowAboutClosing();
        }
        if (node == rangeDirector) {
            table_wrapper.getMediator().refreshViaRangeAndOuterId(table_wrapper, outer_table_wrapper.clickedDomain.id.get(),rangeDirector.getSelectedRange());
        }
        if (node == datePickerHandlerSTART) {
            selectedDateStart=datePickerHandlerSTART.getSelectedDate();
        }
        if (node == datePickerHandlerEND) {
            selectedDateEnd=datePickerHandlerEND.getSelectedDate();
        }
    }

}
