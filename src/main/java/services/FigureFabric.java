package services;

import figures.Figure;
import figures.complex.BrokenLine;
import figures.complex.Polygon;
import figures.simple.Ellipse;
import figures.simple.Line;
import figures.simple.Rectangular;
import javafx.scene.paint.Color;

import java.lang.reflect.Constructor;
import java.util.HashMap;

public class FigureFabric {
    private final Color figureColor, borderColor;
    private final double startX, startY, thickness;
    private final HashMap<String, Constructor<? extends Figure>> figureChooser;

    public Figure createFigure(String figureName) throws ReflectiveOperationException {
        Figure figure;
        figure = figureChooser.get(figureName).newInstance(this.startX, this.startY);
        figure.setFigureColor(this.figureColor);
        figure.setBorderColor(this.borderColor);
        figure.setThickness(this.thickness);
        return figure;
    }

    public void put(Class<? extends Figure> figureClass) {
        try {
            figureChooser.put(figureClass.getSimpleName(),
                    figureClass.getConstructor(double.class, double.class));
        } catch (NoSuchMethodException e) {
            //For plugins
        }
    }

    private void initializeFigureChooser() {
        put(Line.class);
        put(Ellipse.class);
        put(Rectangular.class);
        put(Polygon.class);
        put(BrokenLine.class);
    }

    public FigureFabric(Color figureColor, Color borderColor, double startX, double startY, double thickness) {
        figureChooser = new HashMap<>();
        initializeFigureChooser();
        this.figureColor = figureColor;
        this.borderColor = borderColor;
        this.startX = startX;
        this.startY = startY;
        this.thickness = thickness;
    }
}
