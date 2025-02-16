package Figures;

import javafx.scene.canvas.GraphicsContext;

public class Line extends Figure {
    public Line(double startX, double endX, double startY, double endY) {
        super(startX, endX, startY, endY);
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.moveTo(startX, startY);
        gc.lineTo(endX, endY);
        gc.stroke();
    }
}
