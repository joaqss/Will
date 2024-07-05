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

    @Override
    public void start(Stage stage) throws IOException {

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) dimension.getWidth();
        int screenHeight = (int) dimension.getHeight();
        stage.setWidth(screenWidth);
        stage.setHeight(screenHeight);
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
        launch();
    }
}