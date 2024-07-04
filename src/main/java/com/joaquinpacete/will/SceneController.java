package com.joaquinpacete.will;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void setMenuScene(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/MenuPanelScene/menuScene.fxml"));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void setNewGameScene(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/NewGameScene/newGameScene.fxml"));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
