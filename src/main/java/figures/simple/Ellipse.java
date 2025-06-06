package figures.simple;

import javafx.scene.canvas.GraphicsContext;

public class Ellipse extends SimpleFigure {
    public Ellipse(double startX, double startY) {
        super(startX, startY);
    }

    @Override
    public void draw(GraphicsContext gc) {
        super.draw(gc);
        gc.fillOval(Math.min(start.getX(), end.getX()), Math.min(start.getY(), end.getY()),
                Math.abs(start.getX() - end.getX()), Math.abs(start.getY() - end.getY()));
        gc.strokeOval(Math.min(start.getX(), end.getX()), Math.min(start.getY(), end.getY()),
                Math.abs(start.getX() - end.getX()), Math.abs(start.getY() - end.getY()));
    }
}
