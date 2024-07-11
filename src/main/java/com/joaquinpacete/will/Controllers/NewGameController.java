package com.joaquinpacete.will.Controllers;

import com.joaquinpacete.will.Game.RunTime.Display;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

public class NewGameController extends SceneController {

    private Stage stage;

    @FXML
    public void startGame(ActionEvent e) throws IOException {
        setGameScene(e);
        System.out.println("Start Game");
    }

    @FXML
    public void backToMenu(ActionEvent e) throws IOException {
        System.out.println("Back to Menu");
        setMenuScene(e);
    }

}
