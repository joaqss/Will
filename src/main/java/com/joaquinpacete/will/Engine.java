package com.joaquinpacete.will;

import com.joaquinpacete.will.Controllers.SceneController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class Engine extends Application {

    SceneController sceneController = new SceneController();
    Scene scene;

    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
    public final int SCREEN_WIDTH = (int) dimension.getWidth();
    public final int SCREEN_HEIGHT = (int) dimension.getHeight();
    public final int TILE_SIZE = 32;
    public final int WORLD_WIDTH = (SCREEN_WIDTH / TILE_SIZE)*4;
    public final int WORLD_HEIGHT = (SCREEN_HEIGHT / TILE_SIZE)*4;

    @Override
    public void start(Stage stage) throws IOException {

        stage.setWidth(SCREEN_WIDTH);
        stage.setHeight(SCREEN_HEIGHT);
        stage.setResizable(false);
        stage.setTitle("Will");

        stage.setFullScreen(false);
        stage.setFullScreenExitKeyCombination(KeyCombination.valueOf("q"));

        // game icon
        Image icon = new Image(getClass().getResourceAsStream("/icon.png"));
        stage.getIcons().add(icon);

        try {
            Parent root = FXMLLoader.load(getClass().getResource("/MenuPanelScene/menuScene.fxml"));
            stage.setScene(scene = new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}