package basisFx.appCore;

public class DomainPropertiesMetaInfo {
    String propertyName;
    String genericShortTypeName;
    String genericFullTypeName;

    public Class getGenericClass() {
        return genericClass;
    }

    public void setGenericClass(Class genericClass) {
        this.genericClass = genericClass;
    }

    Class genericClass;

    public String getGenericFullTypeName() {
        return genericFullTypeName;
    }

    public void setGenericFullTypeName(String genericFullTypeName) {
        this.genericFullTypeName = genericFullTypeName;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getGenericShortTypeName() {
        return genericShortTypeName;
    }

    public void setGenericShortTypeName(String genericShortTypeName) {
        this.genericShortTypeName = genericShortTypeName;
    }
}
