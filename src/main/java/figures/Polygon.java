package figures;

import javafx.scene.canvas.GraphicsContext;

public class Polygon extends ComplexFigure {
    public Polygon(double startX, double startY) {
        super(startX, startY);
    }

    @Override
    public void draw(GraphicsContext gc) {
        double[] coordsXArr = coordsX.stream().mapToDouble(i -> i).toArray(),
                coordsYArr = coordsY.stream().mapToDouble(i -> i).toArray();
        gc.fillPolygon(coordsXArr, coordsYArr, coordsX.size());
        gc.strokePolygon(coordsXArr, coordsYArr, coordsX.size());
    }
}
