package basisFx.appCore.fabrics;

import basisFx.appCore.SubmitElement;
import basisFx.appCore.Submitted;
import basisFx.appCore.elements.AppNode;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.utils.Coordinate;
import basisFx.appCore.settings.CSSID;
import basisFx.appCore.settings.FontsStore;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


/**
 * Created by AlexanderGulevich on 24.03.2018.
 *
 * @autor AlexanderGulevich
 */
public class ButtonFactory {


    protected EventFactory eventFactory=EventFactory.getInstance();

    public void littleRowAddButton(TableWrapper tableWrapper, AnchorPane panel, Class c, Coordinate coordinate ){

        AppNode.NodeBuilder.create()
                .setId(CSSID.PANELS_BUTTON)
                .setCoordinate(coordinate)
                .setParent(panel)
                .setText("+").setFont(FontsStore.ROBOTO_LIGHT, 15)
                .setWidth(30d).setHeight(20d)
                .setEvent(eventFactory.
                        rowAdd(
                                tableWrapper,
                                (l)->{
                                    try {
                                        l.add( c.newInstance());
                                    } catch (InstantiationException e) {
                                        e.printStackTrace();
                                    } catch (IllegalAccessException e) {
                                        e.printStackTrace();
                                    }
                                }))
                .createNButton();

    }
    public void littleRowDeleteButton(TableWrapper tableWrapper, AnchorPane panel,  Coordinate coordinate ){

        AppNode.NodeBuilder.create()
                .setId(CSSID.PANELS_BUTTON)
                .setCoordinate(coordinate)
                .setParent(panel)
                .setText("-").setFont(FontsStore.ROBOTO_LIGHT, 15)
                .setWidth(30d).setHeight(20d)
                .setEvent(eventFactory.rowDeleteFromTable(tableWrapper))
                .createNButton();



    }
    public void addRowButton(AnchorPane panel, Coordinate coordinate, TableWrapper tableWrapper, Class cl){

        AppNode.NodeBuilder.create()
                .setId(CSSID.PANELS_BUTTON)
                .setParent(panel)
                .setCoordinate(coordinate)
                .setText("ДОБАВИТЬ").setFont(FontsStore.ROBOTO_LIGHT, 15)
                .setWidth(170d).setHeight(20d)
                .setEvent(eventFactory.
                        rowAdd(
                                tableWrapper,
                                (l)->{
                                    try {
                                        l.add(cl.newInstance());
                                    } catch (InstantiationException e) {
                                        e.printStackTrace();
                                    } catch (IllegalAccessException e) {
                                        e.printStackTrace();
                                    }
                                }))
                .createNButton();



    }
    public void deleteRowButton(AnchorPane panel, Coordinate coordinate, TableWrapper tableWrapper){
        AppNode.NodeBuilder.create()
                .setId(CSSID.PANELS_BUTTON)
                .setParent(panel)
                .setCoordinate(coordinate)
                .setText("УДАЛИТЬ").setFont(FontsStore.ROBOTO_LIGHT, 15)
                .setWidth(170d).setHeight(20d)
                .setEvent(eventFactory.rowDeleteFromTable(tableWrapper))
                .createNButton();



    }
    public void submitButton(SubmitElement mark, AnchorPane panel, Coordinate coordinate, Submitted...submitted){

        AppNode.NodeBuilder.create()
                .setId(CSSID.PANELS_BUTTON)
                .setMark(mark)
                .setParent(panel)
                .setCoordinate(coordinate)
                .setText("ОТПРАВИТЬ").setFont(FontsStore.ROBOTO_LIGHT, 15)
                .setWidth(170d).setHeight(20d)

                .createNButton();


    }
    public void popupCloseOkButton( AnchorPane panel, Coordinate coordinate, Stage stage){

        AppNode.NodeBuilder.create()
                .setId(CSSID.PANELS_BUTTON)
                .setParent(panel)
                .setCoordinate(coordinate)
                .setStage(stage)
                .setText("ОК").setFont(FontsStore.ROBOTO_BOLD, 17)
                .setWidth(50d).setHeight(30d)
                .setEvent(eventFactory.closingPopup())
                .createNButton();


    }
}
