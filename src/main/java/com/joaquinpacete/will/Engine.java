package com.joaquinpacete.will;

import com.joaquinpacete.will.MenuPanel.MenuScene;
import com.joaquinpacete.will.NewGamePanel.NewGameScene;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class Engine extends Application {

    SceneController sceneController = new SceneController();

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

        MenuScene menuScene = new MenuScene();
        stage.setScene(menuScene.getScene());
        stage.show();
    }

    public static void main(String[] args) {

        launch();
    }
}