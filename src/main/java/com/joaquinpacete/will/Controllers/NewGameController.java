package com.joaquinpacete.will.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javax.swing.*;
import java.io.IOException;

public class NewGameController extends SceneController {

    @FXML
    public void startGame(ActionEvent e) {
        System.out.println("Start Game");
        JOptionPane.showMessageDialog(null, "Game Started");
    }

    @FXML
    public void backToMenu(ActionEvent e) throws IOException {
        System.out.println("Back to Menu");
        setMenuScene(e);
    }

}
