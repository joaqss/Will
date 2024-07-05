package com.joaquinpacete.will.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

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
