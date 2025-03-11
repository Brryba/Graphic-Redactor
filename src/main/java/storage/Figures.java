package storage;

import figures.Figure;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Figures {
    static private final Deque<Figure> figures = new ArrayDeque<>();
    private Figures() {}

    public static List<Figure> getFiguresList() {
        return figures.stream().toList();
    }

    public static Figure getLast() {
        return figures.isEmpty() ? null : figures.getLast();
    }

    public static void addFigure(Figure figure) {
        figures.add(figure);
    }

    public static Figure deleteLast() {
        if (figures.isEmpty()) {
            return null;
        }
        return figures.removeLast();
    }

    public static void deleteFigure(Figure figure) {
        figures.remove(figure);
    }
}
