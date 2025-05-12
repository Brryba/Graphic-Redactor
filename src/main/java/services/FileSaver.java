package services;

import GUI.FiguresFileChooser;
import storage.Figures;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FileSaver {
    public void save() throws IOException {
        FiguresFileChooser fileChooser = new FiguresFileChooser();
        File file = fileChooser.selectSaveFile();
        if (file == null) return;
        XmlSerializer serializer = new XmlSerializer();
        try (OutputStream outputStream = new FileOutputStream(file)) {
            serializer.toXML(Figures.getFiguresList(), outputStream);
        }
    }
}
