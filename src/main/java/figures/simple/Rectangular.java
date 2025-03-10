package figures.simple;

import javafx.scene.canvas.GraphicsContext;

public class Rectangular extends SimpleFigure {
    public Rectangular(double startX, double startY) {
        super(startX, startY);
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.fillRect(Math.min(start.getX(), end.getX()), Math.min(start.getY(), end.getY()),
                Math.abs(start.getX() - end.getX()), Math.abs(start.getY() - end.getY()));
    }
}
