package com.joaquinpacete.will.Game.Object;

import javafx.scene.shape.Rectangle;

public class Player {

    // config
    public double x, y;
    public int width, height;
    public Rectangle player;
    public double PLAYER_MOVEMENT = 2.5;

    public Player(double x, double y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.player = new Rectangle(x, y, width, height);
    }

    public void update() {
    }

    public Rectangle getGraphic() {
        return player;
    }


    public double setX(double x) {
        this.x = x;
        player.setX(x);
        return x;
    }

    public double setY(double y) {
        this.y = y;
        player.setY(y);
        return y;
    }


    // getters
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getPLAYER_MOVEMENT() {
        return PLAYER_MOVEMENT;
    }

    public void setPLAYER_MOVEMENT(double PLAYER_MOVEMENT) {
        this.PLAYER_MOVEMENT = PLAYER_MOVEMENT;
    }

}
