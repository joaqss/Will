package com.joaquinpacete.will.Game.RunTime;

import com.joaquinpacete.will.Engine;
import com.joaquinpacete.will.Game.MapLoader.GameMap;
import com.joaquinpacete.will.Game.Object.Player;
import com.joaquinpacete.will.Game.Overlays.Hotbar;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Display extends Engine {
    private Player player;
    public Scene scene;

    public Display() {

    }

    public void setupAndShowStage(Stage stage) throws IOException {
        // default settings
        Pane root = new Pane();
        root.setPrefSize(getWidth(), getHeight());
        GameLoop gameLoop = new GameLoop(this);

        // canvas and drawing initialization
        Canvas canvas = new Canvas(getWidth(), getHeight());
        GraphicsContext gc = canvas.getGraphicsContext2D();
        GameMap gameMap = new GameMap();
        gameMap.drawMap(gc);
        root.getChildren().add(canvas);

        // player initialization
        player = new Player(500,500,50,50);
        root.getChildren().add(player.getGraphic()); // Add player to the pane

        // hotbar initialization
        Hotbar hotbar = new Hotbar(this, root);
        scene = new Scene(root, getWidth(), getHeight());

        // controls initialization
        Controls controls = new Controls(this, gameLoop, hotbar);

        // game loop initialization
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
