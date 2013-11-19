package apsk.jaat.interaction.javafx.component;

import javafx.collections.ListChangeListener;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

public class AllAnchors extends AnchorPane {
    private double anchorDistance;
    public AllAnchors() {
        anchorDistance = 0.0;
        getChildren().addListener(
            (ListChangeListener.Change<?> c) -> updateAnchors()
        );
    }
    private void updateNodeAnchors(Node node) {
        AnchorPane.setTopAnchor(node, anchorDistance);
        AnchorPane.setBottomAnchor(node, anchorDistance);
        AnchorPane.setLeftAnchor(node, anchorDistance);
        AnchorPane.setRightAnchor(node, anchorDistance);
    }
    private void updateAnchors() {
        updateNodeAnchors(this);
        for (Node node : getChildren())
            updateNodeAnchors(node);
    }
    public double getAnchorDistance() {
        return anchorDistance;
    }
    public void setAnchorDistance(double anchorDistance) {
        this.anchorDistance = anchorDistance;
        updateAnchors();
    }
}
