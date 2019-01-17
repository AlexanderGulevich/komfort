package basisFx.appCore.elements;

import basisFx.appCore.utils.RangeForCombobox;
import basisFx.service.Mediator;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

public class ComboboxHandler {

    protected ComboBox<RangeForCombobox> comboBox;
    private RangeForCombobox selectedRange;

    public ComboboxHandler(ComboBox<RangeForCombobox> comboBox,
                           Mediator mediator,
                           RangeForCombobox startRange,
                           ObservableList<RangeForCombobox> range) {
        this.comboBox = comboBox;

        comboBox.setOnAction((e) -> {
            selectedRange=comboBox.getSelectionModel().getSelectedItem();
            mediator.inform(this);
        });

        comboBox.setValue(startRange);

        comboBox.setItems(range);

        setCellFactory();
    }



    public RangeForCombobox getSelectedRange() {
        return selectedRange;
    }

    private void setCellFactory() {
        comboBox.setCellFactory(
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
                                        if (comboBox != null) {
                                            comboBox.setValue(item );
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
}
