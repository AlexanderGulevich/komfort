package basisFx.appCore.elements;

import basisFx.appCore.events.AppEvent;
import basisFx.appCore.windows.WindowAbstraction;
import basisFx.service.ServiceMediator;
import basisFx.appCore.settings.CSSID;
import basisFx.appCore.utils.Coordinate;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;

public class DatePickerWrapper  extends AppNode{

    private DatePicker element;
    private ServiceMediator serviceMediator;
    private LocalDate date;
    private DatePickerWrapper datePickerWrapper;


    private DatePickerWrapper(Builder builder) {
        events = builder.events;
        cssid = builder.cssid;
        width = builder.width;
        height = builder.height;
        coordinate = builder.coordinate;
        parentAnchor = builder.parentAnchor;
        parentGroup = builder.parentGroup;
        parentFlowPane = builder.parentFlowPane;
        parentScrollPane = builder.parentScrollPane;
        metaName = builder.name;
        stage = builder.stage;
        serviceMediator = builder.serviceMediator;
        datePickerWrapper=this;
        applyWidth();
        createDatePicker();
        windowAbstraction=builder.windowAbstraction;
        setElementToWindowRegistry();
        bond(this);
    }

    private void applyWidth() {
        if (width == null) {
            width=100d;
        }
    }

    private void createDatePicker() {
        element=new DatePicker();

        element.setId(CSSID.DATEPICKER_IN_COLUMN.get());
        element.setMinWidth(width);
        element.setConverter(new CustomStringConverter());
        element.setPromptText("");
//        element.setOnAction((e) -> {
//               this.date = element.getValue();
//               serviceMediator.inform(this);
//
//        });
        element.valueProperty().addListener(new ChangeListener<LocalDate>() {
            @Override
            public void changed(ObservableValue<? extends LocalDate> observable, LocalDate oldValue, LocalDate newValue) {
                date = element.getValue();
                serviceMediator.inform(datePickerWrapper);
            }
        });
    }

    public LocalDate getDate() {
        return date;
    }

    public static Builder newBuilder() {
        return new Builder();
    }


    @Override
    public DatePicker getElement() {
        return element;
    }

    class CustomStringConverter extends StringConverter<LocalDate> {
        DateTimeFormatter dateFormatter =//DateTimeFormatter.ofPattern("dd-MM-yyyy");
                DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        @Override
        public String toString(LocalDate date) {
            if (date != null) {
                return dateFormatter.format(date);
            } else {
                return "";
            }
        }

        @Override
        public LocalDate fromString(String string) {
            if (string != null && !string.isEmpty()) {
                return LocalDate.parse(string, dateFormatter);
            } else {
                return null;
            }
        }
    }


    public static final class Builder {
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
        private String name;
        private Stage stage;
        private ServiceMediator serviceMediator;

        private Builder() {
        }

        public void setWindowAbstraction(WindowAbstraction windowAbstraction) {
            this.windowAbstraction = windowAbstraction;
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

        public Builder setName(String val) {
            name = val;
            return this;
        }

        public Builder setStage(Stage val) {
            stage = val;
            return this;
        }

        public Builder setServiceMediator(ServiceMediator val) {
            serviceMediator = val;
            return this;
        }

        public DatePickerWrapper build() {
            return new DatePickerWrapper(this);
        }
    }
}
