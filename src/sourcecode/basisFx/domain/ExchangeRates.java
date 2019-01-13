package basisFx.domain;

import basisFx.appCore.annotation.DataStore;
import basisFx.appCore.annotation.Sorting;
import javafx.beans.property.SimpleObjectProperty;
import java.time.LocalDate;

public class ExchangeRates extends ActiveRecord{

    private static ExchangeRates INSTANCE = new ExchangeRates();
    @DataStore(SORTING = Sorting.DESC) private SimpleObjectProperty<LocalDate> startDate =new SimpleObjectProperty<>(this, "startDate", null);
    private SimpleObjectProperty<Double> exchangeRate =new SimpleObjectProperty<>(this, "exchangeRate", null);
    @DataStore (AS_OUTER_ID = true) private SimpleObjectProperty<Integer> currencyId =new SimpleObjectProperty<>(this, "currencyId", null);

    public static ExchangeRates getINSTANCE() {
        return INSTANCE;
    }

    @Override
    public String toString() {
        return getExchangeRate().toString();
    }

    public LocalDate getStartDate() {
        return startDate.get();
    }

    public SimpleObjectProperty<LocalDate> startDateProperty() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate.set(startDate);
    }

    public Double getExchangeRate() {
        return exchangeRate.get();
    }

    public SimpleObjectProperty<Double> exchangeRateProperty() {
        return exchangeRate;
    }

    public void setExchangeRate(Double exchangeRate) {
        this.exchangeRate.set(exchangeRate);
    }

    public Integer getCurrencyId() {
        return currencyId.get();
    }

    public SimpleObjectProperty<Integer> currencyIdProperty() {
        return currencyId;
    }

    public void setCurrencyId(Integer currencyId) {
        this.currencyId.set(currencyId);
    }
}

