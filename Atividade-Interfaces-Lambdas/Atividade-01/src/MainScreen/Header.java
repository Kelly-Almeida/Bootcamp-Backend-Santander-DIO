package MainScreen;

public record Header(String titulo, int tab) {
    public void Header(){
        System.out.println("=====================================");
        for(int i = 0; i < tab; i++){
            System.out.printf("\t");
        }
        System.out.printf(titulo);
        System.out.println("\n=====================================");

    }
}
