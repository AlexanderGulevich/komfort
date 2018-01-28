package basisFx.domainModel;

//package hepo.domainModel;
//
//import hepo.appCore.AbstractTab;
//import java.io.Serializable;
//import java.time.LocalDate;
//import javafx.scene.control.Tab;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.cell.CheckBoxTableCell;
//import javafx.scene.control.cell.PropertyValueFactory;
//
//
//
//public class GoodsPojoCommunicator <Pojo> extends Communicator  implements Cloneable, Serializable  {
//    
//    private AbstractTab tabCreater=null;
//    private Tab tab=null;
//
//    public Tab getTab() {
//        return tab;
//    }
//
//    public void setTab(Tab tab) {
//        this.tab = tab;
//    }
//
//    public AbstractTab getTabCreater() {
//        return tabCreater;
//    }
//
//    public void setTabCreater(AbstractTab tabCreater) {
//        this.tabCreater = tabCreater;
//    }
//    
//    
//	
//	/* Returns  TableColumn */	
//    
//	public  TableColumn<GoodsPojo, Integer> getOrderNumColumn() {
//		TableColumn<GoodsPojo, Integer> orderNumCol = new TableColumn<>("№");
//		orderNumCol.setCellValueFactory(new PropertyValueFactory<>("leftOrderNum"));
//        //       priceCategoryCol.setPrefWidth(150);
//		return orderNumCol;
//	}
//	public  TableColumn<GoodsPojo, Integer> getYearColumn() {
//		TableColumn<GoodsPojo, Integer> yearCol = new TableColumn<>("Год");
//		yearCol.setCellValueFactory(new PropertyValueFactory<>("year"));
//        //       priceCategoryCol.setPrefWidth(150);
//		return yearCol;
//	}
//	public  TableColumn<GoodsPojo, String> getPriceCategoryColumn() {
//		TableColumn<GoodsPojo, String> priceCategoryCol = new TableColumn<>("Категория прайса");
//		priceCategoryCol.setCellValueFactory(new PropertyValueFactory<>("priceCategory"));
//        //       priceCategoryCol.setPrefWidth(150);
//		return priceCategoryCol;
//	}
//	public  TableColumn<GoodsPojo, String> getAmountOfOrderStringColumn() {
//		TableColumn<GoodsPojo, String> priceCategoryCol = new TableColumn<>("Объем заказа");
//		priceCategoryCol.setCellValueFactory(new PropertyValueFactory<>("amountOfOrderString"));
//        //       priceCategoryCol.setPrefWidth(150);
//		return priceCategoryCol;
//	}
//	public  TableColumn<GoodsPojo, String> getEmittedAmountOfOrderStringColumn() {
//		TableColumn<GoodsPojo, String> priceCategoryCol = new TableColumn<>("Сдано");
//		priceCategoryCol.setCellValueFactory(new PropertyValueFactory<>("emittedAmountOfOrderString"));
//        //       priceCategoryCol.setPrefWidth(150);
//		return priceCategoryCol;
//	}
//	public  TableColumn<GoodsPojo, String> getRemainAmountOfOrderStringColumn() {
//		TableColumn<GoodsPojo, String> priceCategoryCol = new TableColumn<>("Осталось");
//		priceCategoryCol.setCellValueFactory(new PropertyValueFactory<>("remainAmountOfOrderString"));
//        //       priceCategoryCol.setPrefWidth(150);
//		return priceCategoryCol;
//	}
//	public  TableColumn<GoodsPojo, String> getProductNameCommonColumn() {
//		TableColumn<GoodsPojo, String> productNameCommonCol = new TableColumn<>("Наименование");
//		productNameCommonCol.setCellValueFactory(new PropertyValueFactory<>("productNameCommon"));
//        //       priceCategoryCol.setPrefWidth(150);
//		return productNameCommonCol;
//	}
//	public  TableColumn<GoodsPojo, String> getRealCategoryColumn() {
//		TableColumn<GoodsPojo, String> realCategoryCol = new TableColumn<>("Категория");
//		realCategoryCol.setCellValueFactory(new PropertyValueFactory<>("realCategory"));
//                realCategoryCol.setEditable(true);
//
//                realCategoryCol.setCellFactory(
//                        javafx.scene.control.cell.TextFieldTableCell.forTableColumn()
//                );
//		return realCategoryCol;
//	}
//	public  TableColumn<GoodsPojo, String> getNameColumnPrice() {
//		TableColumn<GoodsPojo, String> nameCol = new TableColumn<>("Наименование ПРАЙС" );
//		nameCol.setCellValueFactory(new PropertyValueFactory<>("productNamePrice"));
//                nameCol.setEditable(true);
////                nameCol.setCellFactory(
////                        javafx.scene.control.cell.TextFieldTableCell.forTableColumn()
////                );
//                return nameCol;
//	}
//	public  TableColumn<GoodsPojo, String> getNameColumnPlan() {
//		TableColumn<GoodsPojo, String> nameCol = new TableColumn<>("Наименование ПЛАН");
//		nameCol.setCellValueFactory(new PropertyValueFactory<>("productNamePlan"));
//             //   nameCol.setPrefWidth(250);
//		return nameCol;
//	}
//	public  TableColumn<GoodsPojo, String> getOrderColumn() {
//		TableColumn<GoodsPojo, String> orderCol = new TableColumn<>("Зак.");
//		orderCol.setCellValueFactory(new PropertyValueFactory<>("order"));
//            //    orderCol.setPrefWidth(70);
//		return orderCol;
//	}
//	public  TableColumn<GoodsPojo, String> getMeasureColumn() {
//		TableColumn<GoodsPojo, String> measureCol = new TableColumn<>("Ед.изм.");
//		measureCol.setCellValueFactory(new PropertyValueFactory<>("measure"));
//           //     measureCol.setPrefWidth(70);
//		return measureCol;
//	}
//	public  TableColumn<GoodsPojo, Double> getAmountOfOrderColumn() {
//		TableColumn<GoodsPojo, Double> amountCol = new TableColumn<>("Объем заказа");
//		amountCol.setCellValueFactory(new PropertyValueFactory<>("amountOfOrder"));
//           //     amountCol.setPrefWidth(70);
//		return amountCol;
//	}
//	public  TableColumn<GoodsPojo, String> getAmountInBoxColumn() {
//		TableColumn<GoodsPojo, String> amountCol = new TableColumn<>("Кол-во в уп.");
//		amountCol.setCellValueFactory(new PropertyValueFactory<>("amountInBox"));
//         //       amountCol.setPrefWidth(70);
//		return amountCol;
//	}
//	public  TableColumn<GoodsPojo, Double> getAmountOfPriceColumn() {
//		TableColumn<GoodsPojo, Double> amountCol = new TableColumn<>("Кол-во в ПРАЙСЕ");
//		amountCol.setCellValueFactory(new PropertyValueFactory<>("amountOfPrice"));
//         //       amountCol.setPrefWidth(70);
//		return amountCol;
//	}
//	public  TableColumn<GoodsPojo, Double> getEmittedAmountOfOrderColumn() {
//		TableColumn<GoodsPojo, Double> amountCol = new TableColumn<>("Сдано");
//		amountCol.setCellValueFactory(new PropertyValueFactory<>("emittedAmountOfOrder"));
//          //      amountCol.setPrefWidth(70);
//		return amountCol;
//	}
//	public  TableColumn<GoodsPojo, Double> getPercentRemainedColumn() {
//		TableColumn<GoodsPojo, Double> amountCol = new TableColumn<>("Осталось, %");
//		amountCol.setCellValueFactory(new PropertyValueFactory<>("percentRemained"));
//          //      amountCol.setPrefWidth(70);
//		return amountCol;
//	}
//	public  TableColumn<GoodsPojo, Double> getRemainAmountOfOrderColumn() {
//		TableColumn<GoodsPojo, Double> amountCol = new TableColumn<>("Осталось");
//		amountCol.setCellValueFactory(new PropertyValueFactory<>("remainAmountOfOrder"));
//        //        amountCol.setPrefWidth(70);
//		return amountCol;
//	}
//	public  TableColumn<GoodsPojo, Double> getPricePerUnitColumn() {
//		TableColumn<GoodsPojo, Double> pricePerUnitCol = new TableColumn<>("Цена");
//		pricePerUnitCol.setCellValueFactory(new PropertyValueFactory<>("pricePerUnit"));
//         //       pricePerUnitCol.setPrefWidth(70);
//		return pricePerUnitCol;
//	}
//	public  TableColumn<GoodsPojo, LocalDate> getDateOfPriceColumn() {
//		TableColumn<GoodsPojo, LocalDate> dateOfPriceCol = new TableColumn<>("Дата прайса");
//		dateOfPriceCol.setCellValueFactory(new PropertyValueFactory<>("dateOfPrice"));
//         //       dateOfPriceCol.setPrefWidth(70);
//		return dateOfPriceCol;
//	}
//        public TableColumn<GoodsPojo,  Boolean> getToCloseOrderColumn() {
//	
//		TableColumn<GoodsPojo,  Boolean> toCloseOrderCol = new TableColumn<>("Закрыть заказ?");
//		
//                toCloseOrderCol.setEditable(true);
//               
//		toCloseOrderCol.setCellValueFactory(cellData -> {
//                   
//                   GoodsPojo gp = cellData.getValue();
//                   
//                   if(gp.getClosedOrderProperty().get()==true){
//                   
//                       gp.getClosedOrderProperty().set(false);
//                   
//                   }else{
//                        gp.getClosedOrderProperty().set(true);
//                   
//                   }
//
//
//			return gp.getClosedOrderProperty();
//		});
//
//		
//		toCloseOrderCol.setCellFactory(
//			CheckBoxTableCell.<GoodsPojo>forTableColumn(toCloseOrderCol));
//
//		
//                
//                return toCloseOrderCol;
//
//
//	}
//
//
//}
