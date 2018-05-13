package basisFx.appCore.elements;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;


/**
 * Created by AlexanderGulevich on 11.03.2018.
 *
 * @autor AlexanderGulevich
 */
public class ComboBoxWrapper <T>extends AppNode {


    private ComboBox<T> comboBox=null;
    private ObservableList<T> list= FXCollections.<T> observableArrayList();
//    private UnitOfWork unitOfWork=new UnitOfWork();
//    private TableListener  tableListener=new TableListener (this);
//    protected DataMapper dataMapperFabric;
    protected String tableName;



    public ComboBoxWrapper(NodeBuilder builder) {

        comboBox=new ComboBox<>(list);
        setElement(comboBox);
        comboBox.setEditable(true);
        init(builder);
        comboBox.setPrefWidth(this.width);
        comboBox.setPrefHeight(this.height);

//        list.addListener(tableListener);
//        unitOfWork.setRefreshable(this);
//        comboBox.setConverter();
//        comboBox.getItems().addAll();

//        comboBox.getSelectionModel().selectedItemProperty().addListener();


        // Add ChangeListeners to the selectedItem and selectedIndex
        // properties of the selection model
        comboBox.getSelectionModel().selectedItemProperty()
                .addListener(this::domainObjectchanged);
        comboBox.getSelectionModel().selectedIndexProperty()
                .addListener(this::indexChanged);

        // Update the message Label when the value changes
        comboBox.setOnAction(e -> valueChanged(comboBox));
    }

    public ComboBoxWrapper setEditable(Boolean b){
        this.comboBox.setEditable(b);
        return this;
    }


    public void valueChanged(ComboBox<T> list) {
        T p = list.getValue();

    }

    // A change listener to track the change in item selection
    public void domainObjectchanged(
            ObservableValue<? extends T> observable,T oldValue, T newValue) {
        System.out.println("Itemchanged: old = " + oldValue +
                ", new = " + newValue);
    }

    // A change listener to track the change in index selection
    public void indexChanged(ObservableValue<? extends Number> observable,
                             Number oldValue,
                             Number newValue) {
        System.out.println("Indexchanged: old = " + oldValue + ", new = " + newValue);
    }










}



