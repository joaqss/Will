package com.joaquinpacete.will.Game.Entity;

import javafx.scene.shape.Rectangle;

public class Player {

    // config
    private int x, y;
    private int width, height;
    private Rectangle player;

    public Player(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.player = new Rectangle(x, y, width, height);
    }

    public Rectangle getGraphic() {
        return player;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
