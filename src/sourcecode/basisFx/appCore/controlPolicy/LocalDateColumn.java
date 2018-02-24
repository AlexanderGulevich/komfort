/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.controlPolicy;

import java.time.LocalDate;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.LocalDateStringConverter;

/**
 *
 * @author Alek
 */
public class LocalDateColumn <T> extends Column<T>{
    protected TableColumn<T,LocalDate> column;
    protected String propertyName;


    public LocalDateColumn(String columnName,String propertyName) {
        
        this.column =  new TableColumn<>(columnName);
        this.propertyName=propertyName;
        setEddingPoliticy();
        edit();
    }

    
    
    
    public LocalDateColumn<T>  setEddingPoliticy(){
        
        column.setCellValueFactory(new PropertyValueFactory<>(propertyName));
        column.setCellFactory(
                        TextFieldTableCell.forTableColumn(
                                
                               new LocalDateStringConverter()
                               
                        ));
               
        
//            column.setOnEditCommit(
////            new EventHandler<CellEditEvent<T, E>() {
////                
//////                @Override
//////                public void handle(CellEditEvent<T, E> t) {
////////                    ((Person) t.getTableView().getItems().get(
////////                            t.getTablePosition().getRow())
////////                            ).setFirstName(t.getNewValue());
//////                }
////            }
//        );
 
    
    
        return this;
    }
    
    
      public TableColumn getColumn(){
    
        return this.column;
    
    }

      public void edit() {
        this.column.setOnEditCommit((event) -> {
            
            System.err.println("getRowValue    "+  event.getRowValue());
            System.err.println("getOldValue    "+  event.getOldValue());
            System.err.println("getNewValue    "+  event.getNewValue());
            
        });
      }
    
  
}

//
//
//// Create the birth date column
//		TableColumn<Person, LocalDate> birthDateCol =
//			PersonTableUtil.getBirthDateColumn();
//
//		// Set a custom cell factory for Birth Date column
//		birthDateCol.setCellFactory(col -> {
//			TableCell<Person, LocalDate> cell
//					= new TableCell<Person, LocalDate>() {
//						@Override
//						public void updateItem(LocalDate item, boolean empty) {
//							super.updateItem(item, empty);
//
//							// Cleanup the cell before populating it
//							this.setText(null);
//							this.setGraphic(null);
//
//							if (!empty) {
//								String formattedDob = DateTimeFormatter.ofPattern("MM/dd/yyyy")
//								.format(item);
//								this.setText(formattedDob);
//							}
//						}
//					};
//			return cell;
//		});
//
