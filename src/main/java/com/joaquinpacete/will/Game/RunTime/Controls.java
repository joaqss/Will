package com.joaquinpacete.will.Game.RunTime;

import com.joaquinpacete.will.Game.Overlays.Hotbar;
import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyCode;

import java.util.HashSet;

public class Controls {

    private final Display display;
    private final Hotbar hotbar;
    private final GameLoop gameLoop;
    private HashSet<KeyCode> pressedKeys = new HashSet<>();

    public Controls(Display display, GameLoop gameLoop, Hotbar hotbar) {
        this.display = display;
        this.gameLoop = gameLoop;
        this.hotbar = hotbar;
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

                movements();
                hotbar();

                if (pressedKeys.contains(KeyCode.I)) {
                    // inventory

                }

                if (pressedKeys.contains(KeyCode.ESCAPE)) {
                    // pause menu

                }
            }
        }.start();
    }

    public void movements() {
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

        // slow movement
        if (pressedKeys.contains(KeyCode.SHIFT)) {
            display.getPlayer().setPLAYER_MOVEMENT(1.5);
        } else {
            display.getPlayer().setPLAYER_MOVEMENT(2.5);
        }

        // sprint movement
        if (pressedKeys.contains(KeyCode.CONTROL)) {
            display.getPlayer().setPLAYER_MOVEMENT(3.5);
        } else {
            display.getPlayer().setPLAYER_MOVEMENT(2.5);
        }
    }

    public void hotbar() {
        if (pressedKeys.contains(KeyCode.DIGIT1)) {
            hotbar.selectSlot(0);
        } else if (pressedKeys.contains(KeyCode.DIGIT2)) {
            hotbar.selectSlot(1);
        } else if (pressedKeys.contains(KeyCode.DIGIT3)) {
            hotbar.selectSlot(2);
        } else if (pressedKeys.contains(KeyCode.DIGIT4)) {
            hotbar.selectSlot(3);
        } else if (pressedKeys.contains(KeyCode.DIGIT5)) {
            hotbar.selectSlot(4);
        } else if (pressedKeys.contains(KeyCode.DIGIT6)) {
            hotbar.selectSlot(5);
        } else if (pressedKeys.contains(KeyCode.DIGIT7)) {
            hotbar.selectSlot(6);
        } else if (pressedKeys.contains(KeyCode.DIGIT8)) {
            hotbar.selectSlot(7);
        } else if (pressedKeys.contains(KeyCode.DIGIT9)) {
            hotbar.selectSlot(8);
        } else if (pressedKeys.contains(KeyCode.DIGIT0)) {
            hotbar.selectSlot(9);
        } else {
            System.out.println("Invalid slot bar key pressed.");
        }
    }
}