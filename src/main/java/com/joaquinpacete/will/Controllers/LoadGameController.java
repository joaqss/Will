package com.joaquinpacete.will.Controllers;

import com.joaquinpacete.will.SceneController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class LoadGameController extends SceneController {
    @FXML
    public void backToMenu(ActionEvent e) throws IOException {
        System.out.println("Back to Menu");
        setMenuScene(e);
    }

}
