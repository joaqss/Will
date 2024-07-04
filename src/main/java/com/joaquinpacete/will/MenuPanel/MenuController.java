package com.joaquinpacete.will.MenuPanel;

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
    public void loadGame(ActionEvent e) {
        System.out.println("Load Game");
    }

    @FXML
    public void settings(ActionEvent e) {
        System.out.println("Settings");
    }

    @FXML
    public void exit(ActionEvent e) {
        System.out.println("Exit");
        System.exit(0);
    }

}
