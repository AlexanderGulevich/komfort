package basisFx.appCore.interfaces;

import basisFx.domain.ActiveRecord;

import java.time.LocalDate;

public interface DateGetter {

    public LocalDate getDate(ActiveRecord activeRecord);
}
