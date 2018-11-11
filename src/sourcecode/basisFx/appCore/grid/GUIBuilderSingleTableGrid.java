package basisFx.appCore.grid;

import basisFx.appCore.mediators.Mediator;
import basisFx.appCore.table.ColumnWrapper;
import basisFx.dataSource.UnitOfWork;
import javafx.scene.Group;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;

import java.awt.*;

public class GUIBuilderSingleTableGrid extends GUIBuilder {

    private Class activeRecordClass;
    private double widthPercent;
    private AnchorPane parentAnchor;
    private Group parentGroup;
    private FlowPane parentFlowPane;
    private ScrollPane parentScrollPane;
    private String name;
    private boolean isEditable;
    private boolean isSortableColums;
    private Mediator mediator;
    private ColumnWrapper[] columnWrappers;
    private UnitOfWork unitOfWork;
    private boolean gridLinesVisibility;
    private GridOrganization gridOrganization;
    private String commonGridName;




}
