package GUI;

import javafx.scene.control.Alert;

public class ErrorViewer {
    public void showError(String headerText, String errorText) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setContentText(headerText);
        alert.setHeaderText(errorText);
        alert.show();
    }
}
