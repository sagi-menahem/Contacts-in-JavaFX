package com.sagiia.maman14ex2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * The Main class is the entry point of the JavaFX application.
 * It initializes and launches the application window.
 */
public class Main extends Application {

    /**
     * The start method is called when the JavaFX application is launched.
     *
     * @param stage The primary stage for the application.
     * @throws IOException If an error occurs while loading the FXML file.
     */
    @Override
    public void start(Stage stage) throws IOException {
        // Load the FXML file for the application view
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("maman14ex2-view.fxml"));

        // Create a scene with the loaded FXML file and set the stage title
        Scene scene = new Scene(fxmlLoader.load(), 666, 400);
        stage.setTitle("Sagi Menahem - Maman 14Ex2");
        stage.setScene(scene);

        // Show the stage (application window)
        stage.show();
    }
    /**
     * The main method is the entry point of the application.
     *
     * @param args Command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
        // Launch the JavaFX application
        launch();
    }
}