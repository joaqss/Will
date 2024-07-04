package com.joaquinpacete.will.NewGamePanel;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class NewGameScene {
    private Scene scene;

    public NewGameScene() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/NewGameScene/newGameScene.fxml"));
            scene = new Scene(root);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Scene getScene() {
        return scene;
    }
}
