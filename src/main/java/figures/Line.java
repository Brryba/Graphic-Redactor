package figures;

import javafx.scene.canvas.GraphicsContext;

public class Line extends SimpleFigure {
    public Line(double startX, double startY, double endX, double endY) {
        super(startX, startY, endX, endY);
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.moveTo(startX, startY);
        gc.lineTo(endX, endY);
        gc.stroke();
    }
}
