package com.joaquinpacete.will.MenuPanel;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class MenuScene {
    private Scene scene;

    public MenuScene() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/MenuPanelScene/menuScene.fxml"));
            scene = new Scene(root);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Scene getScene() {
        return scene;
    }
}
