package MainScreen__202607261925.headers;

public enum HeaderType {
    SOLID ("-"),
    BI_SOLID ("="),
    CROSS ("+"),
    CROSS_SOLID ("+-"),
    STAR("*");

    private String symbol;

    HeaderType(String symbol){
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
