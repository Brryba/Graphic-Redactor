package figures.complex;

import javafx.scene.canvas.GraphicsContext;

public class Polygon extends ComplexFigure {
    public Polygon(double startX, double startY) {
        super(startX, startY);
    }

    @Override
    public void draw(GraphicsContext gc) {
        super.draw(gc);
        double[] coordsXArr = coords.stream().mapToDouble(Point::x).toArray(),
                coordsYArr = coords.stream().mapToDouble(Point::y).toArray();
        gc.fillPolygon(coordsXArr, coordsYArr, coords.size());
        gc.strokePolygon(coordsXArr, coordsYArr, coords.size());
    }
}
