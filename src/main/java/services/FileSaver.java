package services;

import GUI.FiguresFileChooser;
import storage.Figures;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class FileSaver {
    public void save() throws IOException{
        FiguresFileChooser fileChooser = new FiguresFileChooser();
        File file = fileChooser.selectSaveFile();
        if (file == null) return;
        try (ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream(file))) {
            ous.writeObject(Figures.getFiguresList());
        }
    }
}
