package basisFx.appCore.grid;

public enum TablesButtonKind {

    No_buttons("No_buttons"),
    Submit("SUBMIT"),
    TOP_right("TOP_right_little"),
    Bottom_right("Bottom_right_little"),
    Right("Right_little"),
    TOP_right_little("TOP_right_little"),
    Bottom_right_little("Bottom_right_little"),
    Right_little("Right_little");



    private final String buttonPosition;

    private TablesButtonKind(String buttonPosition) {
        this.buttonPosition = buttonPosition;
    }

    public String get() {
        return buttonPosition;
    }



}
