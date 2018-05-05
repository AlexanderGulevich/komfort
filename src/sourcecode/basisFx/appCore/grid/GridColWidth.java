package basisFx.appCore.grid;

public class GridColWidth {

    private KindOfGridCol kind;
    private  double width;

    public GridColWidth(KindOfGridCol kind, double width) {
        this.kind = kind;
        this.width = width;
    }
    public GridColWidth() {

    }

    public GridColWidth(KindOfGridCol kind) {
        this.kind = kind;
    }

    public void setKind(KindOfGridCol kind) {
        this.kind = kind;
    }



    public void setWidth(double width) {
        this.width = width;
    }

    public KindOfGridCol getKind() {
        return kind;
    }


    public double getWidth() {
        return width;
    }
}
