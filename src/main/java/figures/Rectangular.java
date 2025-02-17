package figures;

import javafx.scene.canvas.GraphicsContext;

public class Rectangular extends SimpleFigure {
    public Rectangular(double startX, double startY, double endX, double endY) {
        super(startX, startY, endX, endY);
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.fillRect(Math.min(startX, endX), Math.min(startY, endY),
                Math.abs(startX - endX), Math.abs(startY - endY));
    }
}
