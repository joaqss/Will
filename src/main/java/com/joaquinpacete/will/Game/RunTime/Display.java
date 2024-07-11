package com.joaquinpacete.will.Game.RunTime;

import com.joaquinpacete.will.Game.Entity.Player;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Display {
    private Player player;

    public Display() {
        player = new Player(100,100,50,50);
    }

    public void setupAndShowStage(Stage stage) {
        Pane root = new Pane();
        root.getChildren().add(player.getGraphic()); // Add player to the pane
        Scene scene = new Scene(root, 400, 300);
        stage.setScene(scene);
        stage.setTitle("Game Display");
    }

}
