package com.joaquinpacete.will.Game.RunTime;

import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyCode;

import java.util.HashSet;

public class Controls {

    private final Display display;
    private HashSet<KeyCode> pressedKeys = new HashSet<>();

    public Controls(Display display) {
        this.display = display;
        setupKeyHandlers();
        startMovementTimer();
    }

    private void setupKeyHandlers() {
        display.getScene().setOnKeyPressed(e -> {
            pressedKeys.add(e.getCode());
        });

        display.getScene().setOnKeyReleased(e -> {
            pressedKeys.remove(e.getCode());
        });
    }

    private void startMovementTimer() {
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (pressedKeys.contains(KeyCode.W)) {
                    display.getPlayer().setY(display.getPlayer().getY() - display.getPlayer().getPLAYER_MOVEMENT());
                }
                if (pressedKeys.contains(KeyCode.S)) {
                    display.getPlayer().setY(display.getPlayer().getY() + display.getPlayer().getPLAYER_MOVEMENT());
                }
                if (pressedKeys.contains(KeyCode.A)) {
                    display.getPlayer().setX(display.getPlayer().getX() - display.getPlayer().getPLAYER_MOVEMENT());
                }
                if (pressedKeys.contains(KeyCode.D)) {
                    display.getPlayer().setX(display.getPlayer().getX() + display.getPlayer().getPLAYER_MOVEMENT());
                }

                if (pressedKeys.contains(KeyCode.SHIFT)) {
                    display.getPlayer().setPLAYER_MOVEMENT(1.5);
                } else {
                    display.getPlayer().setPLAYER_MOVEMENT(2.5);
                }
            }
        }.start();
    }
}