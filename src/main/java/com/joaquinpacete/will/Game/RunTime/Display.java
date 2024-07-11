package com.joaquinpacete.will.Game.RunTime;

import com.joaquinpacete.will.Engine;
import com.joaquinpacete.will.Game.Object.Player;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Display extends Engine {
    private Player player;
    public Scene scene;

    public void setupAndShowStage(Stage stage) {
        Pane root = new Pane();
        player = new Player(500,500,50,50);
        root.getChildren().add(player.getGraphic()); // Add player to the pane
        scene = new Scene(root, getWidth(), getHeight());
        Controls controls = new Controls(this);
        GameLoop gameLoop = new GameLoop(this);

        stage.setScene(scene);
        stage.setTitle("Game Display");
    }

    public void update() {
        System.out.println("update called on display");
    }

    public Scene getScene() {
        return scene;
    }

    public Player getPlayer() {
        return player;
    }


}
