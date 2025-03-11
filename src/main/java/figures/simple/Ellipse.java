package figures.simple;

import javafx.scene.canvas.GraphicsContext;

public class Ellipse extends SimpleFigure {
    public Ellipse(double startX, double startY) {
        super(startX, startY);
    }

    @Override
    public void draw(GraphicsContext gc) {
        super.draw(gc);
        gc.fillOval(Math.min(start.x(), end.x()), Math.min(start.y(), end.y()),
                Math.abs(start.x() - end.x()), Math.abs(start.y() - end.y()));
        gc.strokeOval(Math.min(start.x(), end.x()), Math.min(start.y(), end.y()),
                Math.abs(start.x() - end.x()), Math.abs(start.y() - end.y()));
    }
}
