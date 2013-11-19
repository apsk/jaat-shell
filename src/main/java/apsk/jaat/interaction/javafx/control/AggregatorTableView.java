package apsk.jaat.interaction.javafx.control;

import apsk.jaat.core.Aggregator;
import apsk.jaat.core.DataItem;
import apsk.jaat.core.Option;
import javafx.beans.property.*;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;

import java.util.List;

public class AggregatorTableView extends TableView<Aggregator> {
    public AggregatorTableView() {
        TableColumn<Aggregator, Boolean> activeCol = new TableColumn<>("Active?");
        TableColumn<Aggregator, String> nameCol = new TableColumn<>("Name");
        TableColumn<Aggregator, String> resourceCol = new TableColumn<>("Resource");
        TableColumn<Aggregator, String> versionCol = new TableColumn<>("Version");
        activeCol.setCellValueFactory(cdf -> cdf.getValue().isActive());
        activeCol.setCellFactory(CheckBoxTableCell.forTableColumn(activeCol));
        activeCol.setOnEditCommit(e -> e.getRowValue().isActive().set(e.getNewValue()));
        nameCol.setCellValueFactory(cdf -> new SimpleStringProperty(cdf.getValue().getName()));
        resourceCol.setCellValueFactory(cdf -> new SimpleStringProperty(cdf.getValue().getResource()));
        versionCol.setCellValueFactory(cdf -> new SimpleStringProperty(cdf.getValue().getVersion()));
        getColumns().addAll(activeCol, nameCol, resourceCol, versionCol);
        setEditable(true);
        setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        getItems().add(new Aggregator() {
            private BooleanProperty isActive = new SimpleBooleanProperty(true);
            @Override public String getName() { return "test"; }
            @Override public String getVersion() { return "0.0.1"; }
            @Override public String getResource() { return "test.org"; }
            @Override public List<Option> getOptions() { return null; }
            @Override public String getOptionValue(String optionName) { return null; }
            @Override public List<DataItem> receiveData() { return null; }
            @Override public BooleanProperty isActive() { return isActive; }
        });
    }
}
