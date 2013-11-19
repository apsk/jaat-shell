package apsk.jaat.interaction.javafx.util;

import apsk.jaat.Jaat;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LocalizedFxmlLoader {
    public static Pane load(String location, String locale) throws IOException {
        URL locationURL = Jaat.class.getClassLoader().getResource("fxml/" + location + ".fxml");
        ResourceBundle resources = ResourceBundle.getBundle("apsk.jaat.interaction.javafx.localization." + locale);
        FXMLLoader fxmlLoader = new FXMLLoader(locationURL, resources);
        return fxmlLoader.load();
    }
}
