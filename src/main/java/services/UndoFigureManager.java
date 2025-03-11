package services;

import figures.Figure;
import storage.Figures;

public class UndoFigureManager {
    private UndoFigureManager() {}

    public static void undo() {
        Figure figure = Figures.removeLast();
        if (figure == null) {
            return;
        }
        RedoFigureManager.add(figure);
    }
}
