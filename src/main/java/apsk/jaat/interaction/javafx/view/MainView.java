package apsk.jaat.interaction.javafx.view;

import apsk.jaat.interaction.javafx.util.LocalizedFxmlLoader;
import apsk.jaat.interaction.javafx.generic.View;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class MainView implements View {
    private final Pane root;
    public MainView() throws IOException {
        root = LocalizedFxmlLoader.load("main", "English");
    }
    @Override
    public Pane getRoot() {
        return root;
    }
}
