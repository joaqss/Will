package com.joaquinpacete.will.Controllers;

import com.joaquinpacete.will.SceneController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController extends SceneController {

    @FXML
    public void newGame(ActionEvent e) throws IOException {
        System.out.println("New Game");
        setNewGameScene(e);
    }

    @FXML
    public void loadGame(ActionEvent e) throws IOException {
        System.out.println("Load Game");
        setLoadGameScene(e);
    }

    @FXML
    public void settings(ActionEvent e) throws IOException {
        System.out.println("Settings");
        setSettingsScene(e);
    }

    @FXML
    public void exit(ActionEvent e) {
        System.out.println("Exit");
        System.exit(0);
    }

}
