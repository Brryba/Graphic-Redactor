package figures;

import javafx.scene.canvas.GraphicsContext;

public class Ellipse extends SimpleFigure {
    public Ellipse(double startX, double startY, double endX, double endY) {
        super(startX, startY, endX, endY);
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.fillOval(Math.min(startX, endX), Math.min(startY, endY),
                Math.abs(startX - endX), Math.abs(startY - endY));
    }
}
