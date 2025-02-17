package graphic_redactor;

import Figures.ComplexFigure;
import Figures.Figure;
import Figures.Line;
import Figures.Polygon;
import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.List;

public class MainController {
    @FXML
    private DrawingCanvas canvas;
    private Figure figure;
    private final List<Figure> figures = new ArrayList<>();

    public void onMousePressed(MouseEvent event) {
        if (figure == null) {
            figure = new Polygon(event.getX(), event.getY(), event.getX(), event.getY());
            figures.add(figure);
        } else if (figure instanceof ComplexFigure) {
            ((ComplexFigure) figure).addPoint(event.getX(), event.getY());
        }
        canvas.redraw(figures);
    }

    public void onMouseDragged(MouseEvent event) {
        figure.setEndCoords(event.getX(), event.getY());
        canvas.redraw(figures);
    }

    public void onMouseReleased(MouseEvent event) {
        if (!(figure instanceof ComplexFigure)) {
            figure = null;
        }
    }

    public void onKeyPress(KeyEvent event) {
        if (figure instanceof ComplexFigure && event.getCode() == KeyCode.ENTER) {
            figure = null;
        }
    }
}