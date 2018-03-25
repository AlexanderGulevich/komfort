package basisFx.appCore.elements;

import basisFx.appCore.events.EventFactory;
import basisFx.domainModel.pojo.Country;
import basisFx.domainModel.settings.CSSID;
import basisFx.domainModel.settings.FontsStore;
import javafx.scene.layout.AnchorPane;


/**
 * Created by AlexanderGulevich on 24.03.2018.
 *
 * @autor AlexanderGulevich
 */
public class SketchedButtonFactory {


    protected EventFactory eventFactory=EventFactory.getInstance();

    public void createLittleTableAddButton(TableViewWrapper tableViewWrapper,AnchorPane panel, Class c,Double top, Double right, Double bottom, Double left ){

        AppNode.NodeBuilder.create()
                .setId(CSSID.PANELS_BUTTON)
                .setCoordinate(panel, top,right, bottom, left)
                .setText("+").setFont(FontsStore.ROBOTO_LIGHT, 15)
                .setWidth(30d).setHeight(20d)
                .setEvent(eventFactory.
                        createRowAdd(
                                tableViewWrapper,
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
    public void createLittleTableDeleteButton(TableViewWrapper tableViewWrapper,AnchorPane panel,Double top, Double right, Double bottom, Double left ){

        AppNode.NodeBuilder.create()
                .setId(CSSID.PANELS_BUTTON)
                .setCoordinate(panel, top,right, bottom, left)
                .setText("-").setFont(FontsStore.ROBOTO_LIGHT, 15)
                .setWidth(30d).setHeight(20d)
                .setEvent(eventFactory.createRowDeleteFromTable(tableViewWrapper))
                .createNButton();



    }
}
