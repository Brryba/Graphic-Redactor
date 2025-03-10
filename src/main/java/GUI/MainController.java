package GUI;

import figures.*;
import figures.complex.*;
import figures.simple.*;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.*;
import storage.Figures;
import services.UndoManager;

public class MainController {
    @FXML
    private DrawingCanvas canvas;
    private Figure currentFigure;

    public void onMousePressed(MouseEvent event) {
        if (currentFigure == null) {
            currentFigure = createFigure(event.getX(), event.getY());
            Figures.addFigure(currentFigure);
        } else if (currentFigure instanceof ComplexFigure) {
            ((ComplexFigure) currentFigure).addPoint(event.getX(), event.getY());
        }
        canvas.redraw(Figures.getFiguresList());
    }

    public void onMouseDragged(MouseEvent event) {
        currentFigure.setEndCoords(event.getX(), event.getY());
        canvas.redraw(Figures.getFiguresList());
    }

    public void onMouseReleased() {
        if (currentFigure instanceof SimpleFigure) {
            currentFigure = null;
        }
        canvas.redraw(Figures.getFiguresList());
    }

    public void onKeyPress(KeyEvent event) {
        if (currentFigure instanceof ComplexFigure && event.getCode() == KeyCode.ENTER) {
            currentFigure = null;
        }
    }

    @FXML
    public void onKeyReleased(KeyEvent event) {
        if (new KeyCodeCombination(KeyCode.Z, KeyCombination.CONTROL_ANY)
                .match(event)) {
            UndoManager.undo();
        }
        canvas.redraw(Figures.getFiguresList());
    }

public void ignoreEnterButton(KeyEvent event) {
    if (event.getCode() == KeyCode.ENTER) {
        ((ToggleButton) event.getSource()).setSelected(false);
        onKeyPress(event);
    }
}

private Figure createFigure(double startX, double startY) {
    return switch ("a") {
        case ("LINE") -> new Line(startX, startY, startX, startY);
        case ("ELLIPSE") -> new Ellipse(startX, startY, startX, startY);
        case ("RECTANGULAR") -> new Rectangular(startX, startY, startX, startY);
        case ("BROKEN_LINE") -> new BrokenLine(startX, startY);
        case ("POLYGON") -> new Polygon(startX, startY);
        default -> null;
    };
}

@FXML
public void initialize() {

}
}