package apsk.jaat.interaction.javafx.controller;

import apsk.jaat.Jaat;
import apsk.jaat.core.aggregator.Aggregator;
import apsk.jaat.core.aggregator.AggregatorFactory;
import javafx.fxml.FXML;
import javafx.stage.FileChooser;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.ServiceReference;

import java.io.File;
import java.io.IOException;

public class MainCtrl {
    @FXML
    public void loadAggregator() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Aggregator Bundle");
        fileChooser.getExtensionFilters().add(
            new FileChooser.ExtensionFilter("Bundle files (*.jar)", "*.jar")
        );
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            try {
                BundleContext context = Jaat.osgi.getBundleContext();
                context.installBundle(file.getPath()).start();
                ServiceReference reference = context.getServiceReference(
                    "apsk.jaat.core.aggregator.AggregatorFactory"
                );
                AggregatorFactory factory = (AggregatorFactory) context.getService(reference);
                Aggregator aggregator = factory.create();
                System.out.println("Loaded aggregator: "
                    + aggregator.getName() + " v" + aggregator.getVersion()
                );
                Jaat.aggregators.add(aggregator);
            } catch (Exception e) {
                System.err.println("Failed loading aggregator: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
    @FXML
    public void removeAggregator() {
        System.out.println("remove...");
    }
}
