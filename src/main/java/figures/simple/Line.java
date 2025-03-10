package figures.simple;

import javafx.scene.canvas.GraphicsContext;

public class Line extends SimpleFigure {
    public Line(double startX, double startY) {
        super(startX, startY);
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.moveTo(start.getX(), start.getY());
        gc.lineTo(end.getX(), end.getY());
        gc.stroke();
    }
}
