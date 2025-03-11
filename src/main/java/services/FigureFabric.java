package services;

import figures.Figure;
import figures.complex.BrokenLine;
import figures.complex.Polygon;
import figures.simple.Ellipse;
import figures.simple.Line;
import figures.simple.Rectangular;
import javafx.scene.paint.Color;

public class FigureFabric {
    private final Color figureColor, borderColor;
    private final double startX, startY, thickness;

    public Figure createFigure(String figureName) {
        Figure figure = null;
        switch (figureName) {
            case "Line" ->
                figure = new Line(this.startX, this.startY);
            case "Ellipse" ->
                figure = new Ellipse(this.startX, this.startY);
            case "Rectangular" ->
                figure = new Rectangular(this.startX, this.startY);
            case "Polygon" ->
                figure = new Polygon(this.startX, this.startY);
            case "Broken Line" ->
                figure = new BrokenLine(this.startX, this.startY);
        }
        assert figure != null;
        figure.setFigureColor(this.figureColor);
        figure.setBorderColor(this.borderColor);
        figure.setThickness(this.thickness);
        return figure;
    }

    public FigureFabric(Color figureColor, Color borderColor, double startX, double startY, double thickness) {
        this.figureColor = figureColor;
        this.borderColor = borderColor;
        this.startX = startX;
        this.startY = startY;
        this.thickness = thickness;
    }
}
