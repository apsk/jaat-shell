package apsk.jaat.interaction.javafx.control;

import apsk.jaat.core.aggregator.Aggregator;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;

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
    }
}
