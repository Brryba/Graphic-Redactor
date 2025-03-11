package GUI;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class FiguresFileChooser {
    private static Stage stage;

    public static void setStage(Stage currStage) {
        stage = currStage;
    }

    private final String DEFAULT_EXT = "*.fgr";
    private final String FILE_EXT_LABEL = "Текстовые файлы (" + DEFAULT_EXT + ")";

    public File selectReadFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Открыть файл");

        fileChooser.getExtensionFilters().add(new FileChooser
                .ExtensionFilter(FILE_EXT_LABEL, DEFAULT_EXT));

        return fileChooser.showOpenDialog(stage);
    }

    public File selectSaveFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Сохранить файл");

        fileChooser.getExtensionFilters().add(new FileChooser
                .ExtensionFilter(FILE_EXT_LABEL, DEFAULT_EXT));

        return fileChooser.showSaveDialog(stage);
    }
}
