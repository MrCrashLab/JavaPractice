package Practic_12;

public enum ColorEnumeration {
    RED("\u001B[31m"),
    BLUE("\u001B[34m"),
    GREEN("\u001B[32m"),
    YELLOW("\u001B[33m"),
    CYAN("\u001B[36m"),
    BRIGHT_RED("\u001B[91m"),
    BRIGHT_MAGENTA("\u001B[95m")
    ;

    private String controlExpression;


    ColorEnumeration(String controlExpression) {
        this.controlExpression = controlExpression;
    }

    public String getControlExpression() {
        return controlExpression;
    }
}
