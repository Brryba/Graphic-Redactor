package Figures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class ComplexFigure extends Figure {
    protected List<Double> coordsX, coordsY;

    public void addPoint(double newX, double newY) {
        this.coordsX.add(newX);
        this.coordsY.add(newY);
    }

    @Override
    public void setEndCoords(double endX, double endY) {
        coordsX.set(coordsX.size() - 1, endX);
        coordsY.set(coordsY.size() - 1, endY);
    }

    ComplexFigure(double startX, double startY, double endX, double endY) {
        super(startX, startY, endX, endY);
        this.coordsX = new ArrayList<>(Arrays.asList(startX, startX));
        this.coordsY = new ArrayList<>(Arrays.asList(startY, startY));
    }
}
