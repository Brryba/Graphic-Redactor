package Figures;

import javafx.scene.canvas.GraphicsContext;

public class Rectangular extends Figure {
    public Rectangular(double startX, double endX, double startY, double endY) {
        super(startX, endX, startY, endY);
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.fillRect(Math.min(startX, endX), Math.min(startY, endY),
                Math.abs(startX - endX), Math.abs(startY - endY));
    }
}
