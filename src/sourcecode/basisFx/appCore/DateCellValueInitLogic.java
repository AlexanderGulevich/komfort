package basisFx.appCore;

import javafx.beans.property.SimpleObjectProperty;

import java.time.LocalDate;

public interface DateCellValueInitLogic <T>{

    public SimpleObjectProperty<LocalDate> init(T domainObject);
}
