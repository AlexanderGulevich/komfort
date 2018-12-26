package basisFx.service;

import basisFx.appCore.elements.AppNode;
import basisFx.appCore.elements.TableWrapper;
import basisFx.dataSource.UnitOfWork;
import basisFx.domain.ActiveRecord;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class Service extends ServiceMediator {

    @FXML
    private AnchorPane mainAnchor;

    @Override
    public void inform(AppNode node) {

    }

    @Override
    public void wasRemoved(AppNode node, ActiveRecord record) {
    }

    @Override
    public void wasChanged(AppNode node, ActiveRecord record) {
    }

    @Override
    public void refresh(AppNode node) {
    }

    @Override
    public void initElements()
    {
    }

}
