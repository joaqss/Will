package com.joaquinpacete.will.Game.RunTime;

import com.joaquinpacete.will.Engine;
import com.joaquinpacete.will.Game.Object.Player;
import com.joaquinpacete.will.Game.Overlays.Hotbar;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Display extends Engine {
    private Player player;
    public Scene scene;

    public Display() {

    }

    public void setupAndShowStage(Stage stage) {
        Pane root = new Pane();
        root.setPrefSize(getWidth(), getHeight());
        System.out.println(root.getWidth());

        player = new Player(500,500,50,50);
        root.getChildren().add(player.getGraphic()); // Add player to the pane

        Hotbar hotbar = new Hotbar(this, root);
        scene = new Scene(root, getWidth(), getHeight());
        GameLoop gameLoop = new GameLoop(this);
        Controls controls = new Controls(this, gameLoop, hotbar);

        Thread gameLoopThread = new Thread(gameLoop);
        gameLoopThread.start();

        stage.setScene(scene);
        stage.setTitle("Game Display");
    }

    public void update() {
        player.update();

    }

    public Scene getScene() {
        return scene;
    }

    public Player getPlayer() {
        return player;
    }


}
