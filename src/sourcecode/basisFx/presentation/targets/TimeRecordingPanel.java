package basisFx.presentation.targets;


import basisFx.appCore.elements.DatePickerWrapper;
import basisFx.appCore.utils.Coordinate;
import basisFx.presentation.TargetPanel;

public class TimeRecordingPanel extends TargetPanel {

    @Override
    public void init() {

        DatePickerWrapper.newBuilder()
                .setCoordinate(new Coordinate(100d,null,null,100d))
                .setParentAnchor(innerAnchorPane)
                .build();

    }
}
