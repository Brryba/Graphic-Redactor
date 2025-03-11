package figures.simple;

import javafx.scene.canvas.GraphicsContext;

public class Line extends SimpleFigure {
    public Line(double startX, double startY) {
        super(startX, startY);
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setStroke(this.borderColor);
        gc.strokeLine(start.getX(), start.getY(),
                end.getX(), end.getY());
        gc.stroke();
    }
}
