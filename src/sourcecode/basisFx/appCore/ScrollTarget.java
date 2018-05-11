//package basisFx.domainModel.targets;
//
//import basisFx.appCore.controls.ColumnWrapper;
//import basisFx.appCore.domainScetch.ComboBoxValue;
//import basisFx.appCore.elements.AppNode;
//import basisFx.appCore.elements.TableWrapper;
//import basisFx.appCore.panels.Target;
//import basisFx.domainModel.domaine.Country;
//import basisFx.domainModel.domaine.Equipment;
//import basisFx.appCore.settings.CSSID;
//import javafx.scene.layout.AnchorPane;
//
///**
// * Created by AlexanderGulevich on 18.03.2018.
// *
// * @autor AlexanderGulevich
// */
//public class ScrollTarget extends Target {
//
//
//
//
//    @Override
//    protected void createElement() {
//
//
//     AppNode.NodeBuilder.create()
//             .setId(CSSID.TILE_PANE).setParent(panel)
//             .setCoordinate(80d , 0d, 0d, 0d)
//             .createTilePaneWrapper()
//             .setChildrenAnchorSize(0.3d,30d)
//             .childGenerator(pane -> {setCountryTable(pane);})
//             .childGenerator(pane -> {setCountryTable(pane);})
//             .childGenerator(pane -> {setCountryTable(pane);})
//             .childGenerator(pane -> {setCountryTable(pane);})
//             .childGenerator(pane -> {setCountryTable(pane);})
//             .childGenerator(pane -> {setCountryTable(pane);})
//             .childGenerator(pane -> {setCountryTable(pane);})
//             .childGenerator(pane -> {setCountryTable(pane);})
//             .childGenerator(pane -> {setCountryTable(pane);})
//             .childGenerator(pane -> {setCountryTable(pane);})
//             .childGenerator(pane -> {setCountryTable(pane);})
//             .childGenerator(pane -> {setCountryTable(pane);})
//             .childGenerator(pane -> {setCountryTable(pane);})
//                .getElement();
//
//
//    }
//
//
//
//    private void setCountryTable(AnchorPane pane){
//
//        TableWrapper countryTableWrapper = AppNode.NodeBuilder.create()
//                .setId(CSSID.TABLE).setCoordinate(pane,50d, 40d, 10d, 10d)
//                .<Equipment>createTableViewWrapper().setTablesWidthProperty(0.4, pane.widthProperty()).setTablesHeight(200d)
//                .setDataMapper(this.dataMapper.getNamedDataMapper())
//                .setDbTableName("Country").refresh()
//                .setColums(
//                        columnFabric.<Country,String>stringColumn(ColumnWrapper.Bulder.create()
//                                        .setColumnName("Наименование")
//                                        .setPropertyName("name")
//                                        .setValueChecking(check.createTextCheck())
//                                        .setColumnSize(1)
//                                        .setDomainChanging(
//                                                (obj,val)->{((ComboBoxValue)obj).setRate((String)val);}
//                                        )
//                        )
//                );
//
//        buttonFactory
//                .littleRowAddButton(countryTableWrapper,pane,Country.class,35d,5d,null,null);
//        buttonFactory
//                .littleRowDeleteButton(countryTableWrapper,pane,70d,5d,null,null);
//
//
//
//    }
//
//
//
//
//
//}
