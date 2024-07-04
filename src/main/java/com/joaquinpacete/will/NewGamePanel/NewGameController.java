package com.joaquinpacete.will.NewGamePanel;

import com.joaquinpacete.will.SceneController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javax.swing.*;
import java.io.IOException;

public class NewGameController extends SceneController {
    @FXML
    public void backToMenu(ActionEvent e) throws IOException {
        System.out.println("Back to Menu");
        setMenuScene(e);
    }

}
