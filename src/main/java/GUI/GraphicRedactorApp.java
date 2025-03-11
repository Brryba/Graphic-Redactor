package GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GraphicRedactorApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GraphicRedactorApp.class.getResource("GraphicRedactor.fxml"));
        FiguresFileChooser.setStage(stage);
        Scene scene = new Scene(fxmlLoader.load(), 1200, 700);
        stage.setTitle("Graphic Redactor");
        stage.setScene(scene);
        stage.setResizable(false);

        scene.setOnKeyPressed(keyEvent -> {
            MainController controller = fxmlLoader.getController();
            controller.onKeyPress(keyEvent);
        });

        stage.show();
        stage.centerOnScreen();
    }

    public static void main(String[] args) {
        launch();
    }
}