package MainScreen__202607261925.headers;

public record Headers(String text, HeaderType type) {

    public void show(){
        int quanSymbols;
        int tabs;

        if (type == HeaderType.CROSS_SOLID){
            quanSymbols = (int) (text.length() * 1.5);
        }else{
            quanSymbols = text.length() * 3;
        }

        tabs = text.length();

        showLines(quanSymbols);

        tab(tabs);
        System.out.printf("%s \n", text);

        showLines(quanSymbols);

    }

    private void showLines(int numSymbols){
        for (int i = 0; i < numSymbols; i++){
            System.out.printf(type.getSymbol());
        }

        System.out.printf("\n");
    }

    private void tab(int tabs){
        for (int i = 0; i < tabs; i++){
            System.out.printf(" ");
        }
    }
}
