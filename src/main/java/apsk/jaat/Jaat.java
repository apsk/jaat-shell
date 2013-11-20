package apsk.jaat;

import apsk.jaat.core.aggregator.Aggregator;
import apsk.jaat.interaction.Interaction;
import apsk.jaat.interaction.javafx.JavaFx;
import apsk.jaat.interaction.shell.Shell;
import org.apache.felix.main.AutoProcessor;
import org.osgi.framework.launch.Framework;
import org.osgi.framework.launch.FrameworkFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

public class Jaat {
    public static Framework osgi;
    public static List<Aggregator> aggregators = new ArrayList<>();
    public static void start(Interaction.Mode mode) {
        Interaction interaction;
        switch (mode) {
            case Shell:  interaction = new Shell();  break;
            case JavaFx: interaction = new JavaFx(); break;
            default:
                System.err.println("Unsupported interaction mode!");
                return;
        }
        try {
            FrameworkFactory ff = ServiceLoader.load(FrameworkFactory.class).iterator().next();
            osgi = ff.newFramework(null);
            osgi.init();
            AutoProcessor.process(null, osgi.getBundleContext());
            osgi.start();
            interaction.start();
            osgi.waitForStop(0);
            System.exit(0);
        }
        catch (Exception ex) {
            System.err.println("Couldn't create framework: " + ex);
            ex.printStackTrace();
            System.exit(-1);
        }
    }
}
