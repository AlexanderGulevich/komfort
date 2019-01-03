package basisFx.appCore.elements;

import basisFx.appCore.events.AppEvent;
import basisFx.appCore.settings.CSSID;
import basisFx.appCore.utils.Coordinate;
import basisFx.appCore.utils.RangeForCombobox;
import basisFx.appCore.windows.WindowAbstraction;
import basisFx.service.ServiceMediator;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.util.ArrayList;

public class ComboBoxWrapper  extends AppNode {

    protected ComboBox <RangeForCombobox> element;
    protected RangeForCombobox startRange;
    protected String string;
    protected ServiceMediator serviceMediator;
    private ObservableList<RangeForCombobox> comboboxValues;
    private RangeForCombobox selectedRange;


    private ComboBoxWrapper(Builder builder) {

        events = builder.events;
        startRange=builder.startRange;
        events = builder.events;
        cssid = builder.cssid;
        width = builder.width;
        height = builder.height;
        coordinate = builder.coordinate;
        parentAnchor = builder.parentAnchor;
        parentGroup = builder.parentGroup;
        parentFlowPane = builder.parentFlowPane;
        parentScrollPane = builder.parentScrollPane;
        metaName = builder.metaName;
        text = builder.text;
        stage = builder.stage;
        string = builder.string;
        startRange = builder.startRange;
        serviceMediator = builder.serviceMediator;
        comboboxValues=builder.comboboxValues;
        element = new ComboBox <>(comboboxValues);
        element.setId(CSSID.COMBOBOX.get());
        element.setEditable(false);
        windowAbstraction=builder.windowAbstraction;
        setElementToWindowRegistry();
        setValue();
        setCellFactory();


        element.setOnAction((e) -> {
            selectedRange=element.getSelectionModel().getSelectedItem();
            serviceMediator.inform(this);
        });

        setId();
        bond(this);
        elocateEvents();

    }

    public RangeForCombobox getSelectedRange() {
        return selectedRange;
    }

    private void setValue() {
        if (startRange != null) {
            element.setValue(startRange);
        }
    }

    private void setCellFactory() {
        element.setCellFactory(
                new Callback<ListView<RangeForCombobox>, ListCell<RangeForCombobox>>() {
                    @Override public ListCell<RangeForCombobox> call(ListView<RangeForCombobox> param) {
                        final ListCell<RangeForCombobox> cell = new ListCell<RangeForCombobox>() {
                            {
                                super.setPrefWidth(200);
                            }
                            @Override
                            public void updateItem(RangeForCombobox item, boolean empty) {
                                super.updateItem(item, empty);

                                if (item == null || empty) {
                                    setText(null);
                                } else {
                                    if (isEditing()) {
                                        if (element != null) {
                                            element.setValue(item );
                                        }
                                        String s = item.getName();
                                        if (s != null) {
                                            s=" "+s;
                                        }
                                        setText(s);
                                    } else {
                                        String s= item.getName();
                                            if (s != null) {
                                                s=" "+s;
                                            }
                                        setText(s);
                                    }
                                }
                            }

                        };
                        return cell;
                    }});
    }


    private void setId() {
        if (cssid != null) {
            element.setId(cssid.get());
        }
    }
    public static Builder newBuilder() {
        return new Builder();
    }

    @Override
    public Node getElement() {
        return element;
    }


    public static final class Builder {
        public RangeForCombobox startRange;
        public WindowAbstraction windowAbstraction;
        private ArrayList<AppEvent> events;
        private CSSID cssid;
        private Double width;
        private Double height;
        private Coordinate coordinate;
        private AnchorPane parentAnchor;
        private Group parentGroup;
        private FlowPane parentFlowPane;
        private ScrollPane parentScrollPane;
        private String metaName;
        private String text;
        private Stage stage;
        private String string;
        private ServiceMediator serviceMediator;
        private ObservableList<RangeForCombobox> comboboxValues;

        private Builder() {
        }

        public void setWindowAbstraction(WindowAbstraction windowAbstraction) {
            this.windowAbstraction = windowAbstraction;
        }

        public Builder setStartRange(RangeForCombobox startRange) {
            this.startRange = startRange;
            return this;
        }

        public Builder setComboboxValues(ObservableList<RangeForCombobox> comboboxValues) {
            this.comboboxValues = comboboxValues;
            return this;
        }

        public Builder setEvents(ArrayList<AppEvent> val) {
            events = val;
            return this;
        }

        public Builder setCssid(CSSID val) {
            cssid = val;
            return this;
        }

        public Builder setWidth(Double val) {
            width = val;
            return this;
        }

        public Builder setHeight(Double val) {
            height = val;
            return this;
        }

        public Builder setCoordinate(Coordinate val) {
            coordinate = val;
            return this;
        }

        public Builder setParentAnchor(AnchorPane val) {
            parentAnchor = val;
            return this;
        }

        public Builder setParentGroup(Group val) {
            parentGroup = val;
            return this;
        }

        public Builder setParentFlowPane(FlowPane val) {
            parentFlowPane = val;
            return this;
        }

        public Builder setParentScrollPane(ScrollPane val) {
            parentScrollPane = val;
            return this;
        }

        public Builder setMetaName(String val) {
            metaName = val;
            return this;
        }

        public Builder setText(String val) {
            text = val;
            return this;
        }

        public Builder setStage(Stage val) {
            stage = val;
            return this;
        }

        public Builder setString(String val) {
            string = val;
            return this;
        }

        public Builder setServiceMediator(ServiceMediator val) {
            serviceMediator = val;
            return this;
        }

        public ComboBoxWrapper build() {
            return new ComboBoxWrapper(this);
        }
    }
}



