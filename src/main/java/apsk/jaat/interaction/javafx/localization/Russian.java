package apsk.jaat.interaction.javafx.localization;

import java.util.ListResourceBundle;

public class Russian extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return new Object[][] {
                {"ok", "Ок"},
                {"cancel", "Отмена"},
                {"yes", "Да"},
                {"no", "Нет"}
        };
    }
}
