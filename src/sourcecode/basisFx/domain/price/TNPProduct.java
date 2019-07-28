package basisFx.domain.price;

import basisFx.appCore.activeRecord.ActiveRecord;
import basisFx.appCore.activeRecord.BoolComboBox;
import javafx.beans.property.*;

import java.io.InputStream;
import java.time.LocalDate;

public class    TNPProduct extends ActiveRecord {
    private static TNPProduct INSTANCE = new TNPProduct();
    public static TNPProduct getINSTANCE() {
        return INSTANCE;
    }

    private SimpleObjectProperty<String> priceCategory =new SimpleObjectProperty(this, "priceCategory", null);
    private SimpleObjectProperty<String> name =new SimpleObjectProperty(this, "name", null);
    private SimpleObjectProperty<String> barcode =new SimpleObjectProperty(this, "barcode", null);
    private SimpleObjectProperty<String> alias =new SimpleObjectProperty(this, "alias", null);
    private SimpleObjectProperty<String> order =new SimpleObjectProperty(this, "order", null);
    private SimpleObjectProperty<String> measure =new SimpleObjectProperty(this, "measure", null);//единица измерения
    private SimpleObjectProperty<String> amountInBox =new SimpleObjectProperty(this, "amountInBox", null);//единица измерения
    private SimpleObjectProperty<Double> amountInPrice =new SimpleObjectProperty(this, "amountInPrice", null);//единица измерения
    private SimpleObjectProperty<Double> pricePerUnit =new SimpleObjectProperty(this, "pricePerUnit", null);//единица измерения
    private SimpleObjectProperty<BoolComboBox> isInArchiv =new SimpleObjectProperty<>(this, "isInArchiv", null);
    private SimpleObjectProperty<Category> category =new SimpleObjectProperty<>(this, "category", null);
    private SimpleObjectProperty<LocalDate> dateOfPrice =new SimpleObjectProperty<>(this, "dateOfPrice", null);
    private SimpleObjectProperty<InputStream> img =new SimpleObjectProperty<>(this, "img", null);

    public InputStream getImg() {
        return img.get();
    }

    public SimpleObjectProperty<InputStream> imgProperty() {
        return img;
    }

    public void setImg(InputStream img) {
        this.img.set(img);
    }

    @Override
    public String toString() {
        return null;
    }

    public String getName() {
        return name.get();
    }

    public SimpleObjectProperty<String> nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getBarcode() {
        return barcode.get();
    }

    public SimpleObjectProperty<String> barcodeProperty() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode.set(barcode);
    }

    public String getPriceCategory() {
        return priceCategory.get();
    }

    public SimpleObjectProperty<String> priceCategoryProperty() {
        return priceCategory;
    }

    public void setPriceCategory(String priceCategory) {
        this.priceCategory.set(priceCategory);
    }

    public String getAlias() {
        return alias.get();
    }

    public SimpleObjectProperty<String> aliasProperty() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias.set(alias);
    }

    public String getOrder() {
        return order.get();
    }

    public SimpleObjectProperty<String> orderProperty() {
        return order;
    }

    public void setOrder(String order) {
        this.order.set(order);
    }

    public String getMeasure() {
        return measure.get();
    }

    public SimpleObjectProperty<String> measureProperty() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure.set(measure);
    }

    public String getAmountInBox() {
        return amountInBox.get();
    }

    public SimpleObjectProperty<String> amountInBoxProperty() {
        return amountInBox;
    }

    public void setAmountInBox(String amountInBox) {
        this.amountInBox.set(amountInBox);
    }

    public Double getAmountInPrice() {
        return amountInPrice.get();
    }

    public SimpleObjectProperty<Double> amountInPriceProperty() {
        return amountInPrice;
    }

    public void setAmountInPrice(Double amountInPrice) {
        this.amountInPrice.set(amountInPrice);
    }

    public Double getPricePerUnit() {
        return pricePerUnit.get();
    }

    public SimpleObjectProperty<Double> pricePerUnitProperty() {
        return pricePerUnit;
    }

    public void setPricePerUnit(Double pricePerUnit) {
        this.pricePerUnit.set(pricePerUnit);
    }

    public BoolComboBox getIsInArchiv() {
        return isInArchiv.get();
    }

    public SimpleObjectProperty<BoolComboBox> isInArchivProperty() {
        return isInArchiv;
    }

    public void setIsInArchiv(BoolComboBox isInArchiv) {
        this.isInArchiv.set(isInArchiv);
    }

    public Category getCategory() {
        return category.get();
    }

    public SimpleObjectProperty<Category> categoryProperty() {
        return category;
    }

    public void setCategory(Category category) {
        this.category.set(category);
    }

    public LocalDate getDateOfPrice() {
        return dateOfPrice.get();
    }

    public SimpleObjectProperty<LocalDate> dateOfPriceProperty() {
        return dateOfPrice;
    }

    public void setDateOfPrice(LocalDate dateOfPrice) {
        this.dateOfPrice.set(dateOfPrice);
    }
}
