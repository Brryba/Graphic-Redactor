package graphic_redactor;

import figures.Figure;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import java.util.List;

public class DrawingCanvas extends Canvas {
    public void redraw(List<Figure> figures) {
        GraphicsContext gc = this.getGraphicsContext2D();
        gc.clearRect(0, 0, this.getWidth(), this.getHeight());
        gc.beginPath();
        for (Figure figure : figures) {
            figure.draw(gc);
        }
    }

    public DrawingCanvas() {
        super();
    }
}
