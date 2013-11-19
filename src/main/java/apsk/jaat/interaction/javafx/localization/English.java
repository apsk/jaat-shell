package apsk.jaat.interaction.javafx.localization;

import java.util.ListResourceBundle;

public class English extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return new Object[][] {
                {"ok", "Ok"},
                {"cancel", "Cancel"},
                {"yes", "Yes"},
                {"no", "No"}
        };
    }
}
