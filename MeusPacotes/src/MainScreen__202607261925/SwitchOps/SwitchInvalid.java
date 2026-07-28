package MainScreen__202607261925.SwitchOps;

public class SwitchInvalid extends Exception {
    private final String messageShow;

    public SwitchInvalid(String message) {
        super(message);
        this.messageShow = message;
    }

    public String showMensage(){
        System.out.println(this.messageShow);
        return null;
    }
}
