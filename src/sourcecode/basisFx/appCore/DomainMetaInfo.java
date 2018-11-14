package basisFx.appCore;

public class DomainMetaInfo {
    String typeName;
    String genericTypeName;

    public DomainMetaInfo(String typeName, String genericTypeName) {
        this.typeName = typeName;
        this.genericTypeName = genericTypeName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getGenericTypeName() {
        return genericTypeName;
    }

    public void setGenericTypeName(String genericTypeName) {
        this.genericTypeName = genericTypeName;
    }
}
