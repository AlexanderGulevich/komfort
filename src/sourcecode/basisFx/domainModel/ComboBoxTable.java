package basisFx.domainModel;

/**
 * Created by AlexanderGulevich on 18.03.2018.
 *
 * @autor AlexanderGulevich
 */
import java.util.function.BiConsumer;
import java.util.function.Function;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class ComboBoxTable extends Application {
    @Override
    public void start(Stage stage) {
        int numOfCols = 2;

        ObservableList<ObservableList<String>> tableData = FXCollections.observableArrayList();

        // Generate dummy data.
        for (int i = 0; i < 10; i++) {
            ObservableList<String> row = FXCollections.observableArrayList();

            for (int j = 0; j < numOfCols; j++)
                row.add("Row" + i + "Col" + j);

            tableData.add(row);
        }

        TableView<ObservableList<String>> table = new TableView<ObservableList<String>>();

        // Add columns to the table.
        for (int i = 0; i < numOfCols; i++) {
            final int j = i;
            // The fourth argument in the method, the BiConsumer, might require
            // an explanation. Basically we are saying that when the BiConsumer
            // are given an ObservableList<String> and a String, we set the
            // value of the String as the value of the element at position "j"
            // of the row, where "j" will be the column index.
            table.getColumns().add(addComboBoxColumn(i, "Column " + i, row -> new SimpleStringProperty(row.get(j)),
                    (row, newText) -> row.set(j, newText)));
        }

        table.getItems().addAll(tableData);

        Scene scene = new Scene(table);

        stage.setScene(scene);
        stage.show();
    }

    /**
     * Returns a TableColumn with ComboBoxCells.
     */
    private TableColumn<ObservableList<String>, String> addComboBoxColumn(
            int index, String name,
            Function<ObservableList<String>, ObservableValue<String>> property,
            BiConsumer<ObservableList<String>, String> updater) {

        TableColumn<ObservableList<String>, String> col = new TableColumn<ObservableList<String>, String>(name);

        col.setCellValueFactory(cellData -> property.apply(cellData.getValue()));

        col.setCellFactory(e -> new ComboBoxCell(updater, index));

        return col;
    }

    /**
     * A TableCell with a ComboBox in it.
     */
    public class ComboBoxCell extends TableCell<ObservableList<String>, String> {
        private ComboBox<String> comboBox = new ComboBox<String>();

        /**
         * @param updater
         *            The updater makes sure that the cell value corresponds
         *            with the value in the ComboBox.
         * @param colIndex
         *            The index of this column.
         */
        public ComboBoxCell(BiConsumer<ObservableList<String>, String> updater, int colIndex) {
            comboBox.setEditable(true);

            comboBox.getEditor().textProperty().addListener((old, oldValue, newValue) -> {
                if (getIndex() >= 0) {
                    // We provide the BiConsumer.accept() with an
                    // ObservableList<String> and a String. The BiConsumer will
                    // do the operation specified in the definition we provided
                    // in addColumn() using these two objects.
                    updater.accept(getTableView().getItems().get(getIndex()), (String) newValue);
                }
            });
        }

        @Override
        protected void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);
            if (empty) {
                setGraphic(null);
            } else {
                // If we don't check if this value is the same as the old one,
                // the cursor is moved to the beginning of the editor every time
                // anything is typed.
                if (!item.equals(comboBox.getEditor().getText())) {
                    comboBox.getEditor().setText(item);
                }
                setGraphic(comboBox);
            }
        }
    }

    public static void main(String[] args) {
        launch();
    }
}