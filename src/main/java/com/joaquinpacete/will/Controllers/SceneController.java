package com.joaquinpacete.will.Controllers;

import com.joaquinpacete.will.Game.RunTime.Display;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
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

    public void setLoadGameScene(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/LoadGameScene/loadGameScene.fxml"));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void setSettingsScene(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/SettingsScene/settingsScene.fxml"));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void setGameScene(ActionEvent e) throws IOException {
        Display gameDisplay = new Display();
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        gameDisplay.setupAndShowStage(stage);
//        stage.hide();
    }
}
