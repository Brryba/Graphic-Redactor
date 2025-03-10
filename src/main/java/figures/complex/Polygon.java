package figures.complex;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;

public class Polygon extends ComplexFigure {
    public Polygon(double startX, double startY) {
        super(startX, startY);
    }

    @Override
    public void draw(GraphicsContext gc) {
        double[] coordsXArr = coords.stream().mapToDouble(Point2D::getX).toArray(),
                coordsYArr = coords.stream().mapToDouble(Point2D::getY).toArray();
        gc.fillPolygon(coordsXArr, coordsYArr, coords.size());
        gc.strokePolygon(coordsXArr, coordsYArr, coords.size());
    }
}
