package storage;

import figures.Figure;

import java.io.Serializable;
import java.util.*;

public class Figures implements Serializable {
    static private Deque<Figure> figures = new ArrayDeque<>();
    private Figures() {}

    public static ArrayList<Figure> getFiguresList() {
        return new ArrayList<>(figures);
    }

    public static void createFigures(Collection<Figure> addedFigures) {
        figures = new ArrayDeque<>(addedFigures);
    }
    public static void addFigure(Figure figure) {
        figures.add(figure);
    }

    public static Figure removeLast() {
        if (figures.isEmpty()) {
            return null;
        }
        return figures.removeLast();
    }
}
