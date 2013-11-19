package apsk.jaat.interaction;

public interface Interaction {
    public static enum Mode {
        Shell, JavaFx
    }
    void start();
}
