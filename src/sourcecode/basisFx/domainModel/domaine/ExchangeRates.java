package basisFx.domainModel.domaine;

import basisFx.appCore.domainScetch.DomainObject;
import basisFx.appCore.domainScetch.StringValueDomainObject;
import javafx.beans.property.SimpleObjectProperty;

import java.time.LocalDate;

/**
 * Created by AlexanderGulevich on 11.03.2018.
 *
 * @autor AlexanderGulevich
 */
public class ExchangeRates extends DomainObject{

    private SimpleObjectProperty<LocalDate> startingDate =new SimpleObjectProperty<>(this, "startingDate", null);
    private SimpleObjectProperty<Integer> currencyId =new SimpleObjectProperty<>(this, "currencyId", null);
    private SimpleObjectProperty<String> exchangeRate =new SimpleObjectProperty<>(this, "exchangeRate", null);

    public LocalDate getStartingDate() {
        return startingDate.get();
    }

    public SimpleObjectProperty<LocalDate> startingDateProperty() {
        return startingDate;
    }

    public void setStartingDate(LocalDate startingDate) {
        this.startingDate.set(startingDate);
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

    public String getExchangeRate() {
        return exchangeRate.get();
    }

    public SimpleObjectProperty<String> exchangeRateProperty() {
        return exchangeRate;
    }

    public void setExchangeRate(String exchangeRate) {
        this.exchangeRate.set(exchangeRate);
    }
}
