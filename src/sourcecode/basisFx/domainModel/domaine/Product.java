/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.domainModel.domaine;

import basisFx.appCore.domainScetch.DomainObject;
import basisFx.appCore.domainScetch.StringValueDomainObject;
import javafx.beans.property.*;

import java.time.LocalDate;

/**
 *
 * @author Alek
 */
public class Product  extends DomainObject {

    private SimpleObjectProperty<String> name =new SimpleObjectProperty<>(this, "name", null);
    private SimpleObjectProperty<StringValueDomainObject> rod =new SimpleObjectProperty<>(this, "rod", null);
    private SimpleObjectProperty<String> numberFromRods =new SimpleObjectProperty<>(this, "numberFromRods", null);



    public String getName() {
        return name.get();
    }

    public SimpleObjectProperty<String> nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public StringValueDomainObject getRod() {
        return rod.get();
    }

    public SimpleObjectProperty<StringValueDomainObject> rodProperty() {
        return rod;
    }

    public void setRod(StringValueDomainObject rod) {
        this.rod.set(rod);
    }

    public String getNumberFromRods() {
        return numberFromRods.get();
    }

    public SimpleObjectProperty<String> numberFromRodsProperty() {
        return numberFromRods;
    }

    public void setNumberFromRods(String numberFromRods) {
        this.numberFromRods.set(numberFromRods);
    }


}
