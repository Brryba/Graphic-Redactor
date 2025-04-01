package services;

import figures.Figure;
import figures.complex.BrokenLine;
import figures.complex.Polygon;
import figures.simple.Ellipse;
import figures.simple.Line;
import figures.simple.Rectangular;
import javafx.scene.paint.Color;

import java.lang.reflect.Constructor;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class FigureFabric {
    private Color figureColor, borderColor;
    private double startX, startY, thickness;
    private final Map<String, Constructor<? extends Figure>> figureChooser;

    public Figure createFigure(String figureName) throws ReflectiveOperationException {
        Figure figure;
        figure = figureChooser.get(figureName).newInstance(this.startX, this.startY);
        figure.setFigureColor(this.figureColor);
        figure.setBorderColor(this.borderColor);
        figure.setThickness(this.thickness);
        return figure;
    }

    public void setFigureParams(Color figureColor, Color borderColor, double startX, double startY, double thickness) {
        this.figureColor = figureColor;
        this.borderColor = borderColor;
        this.startX = startX;
        this.startY = startY;
        this.thickness = thickness;
    }

    public void put(String figureName, Class<? extends Figure> figureClass) {
        try {
            figureChooser.put(figureName,
                    figureClass.getConstructor(double.class, double.class));
        } catch (NoSuchMethodException e) {
            //For plugins
        }
    }

    public Collection<String> getAllFigureNames() {
        return figureChooser.keySet();
    }

    private void initializeFigureChooser() {
        put("Line", Line.class);
        put("Ellipse", Ellipse.class);
        put("Rectangular", Rectangular.class);
        put("Polygon", Polygon.class);
        put("Broken Line", BrokenLine.class);
    }

    public FigureFabric() {
        figureChooser = new LinkedHashMap<>();
        initializeFigureChooser();
    }
}
