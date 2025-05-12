package services;

import figures.Figure;
import storage.Figures;

public class UndoFigureManager {
    private UndoFigureManager() {}

    private static int firstDrawnFigureIndex = 0;

    public static void setFirstFigureIndex(int figureIndex) {
        firstDrawnFigureIndex = figureIndex;
    }

    public static void undo() {
        if (Figures.lastFigureIndex() == firstDrawnFigureIndex) {
            Figures.clearFigures();
        } else {
            Figure figure = Figures.removeLast();
            if (figure == null) {
                return;
            }
            RedoFigureManager.add(figure);
        }
    }
}
