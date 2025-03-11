package figures.simple;

import javafx.scene.canvas.GraphicsContext;

public class Line extends SimpleFigure {
    public Line(double startX, double startY) {
        super(startX, startY);
    }

    @Override
    public void draw(GraphicsContext gc) {
        super.draw(gc);
        gc.strokeLine(start.x(), start.y(),
                end.x(), end.y());
        gc.stroke();
    }
}
