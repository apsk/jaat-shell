package apsk.jaat.interaction.javafx;

import apsk.jaat.interaction.Interaction;
import apsk.jaat.interaction.javafx.view.MainView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class JavaFx extends Application implements Interaction {
    @Override
    public void start() {
        javafx.application.Application.launch(JavaFx.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.getIcons().add(new Image(
            getClass().getClassLoader().getResourceAsStream("icon.png")
        ));
        stage.setTitle("Jaat");
        try {
            Scene scene = new Scene(new MainView().getRoot(), 640, 480);
            scene.getStylesheets().add("styles.css");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
