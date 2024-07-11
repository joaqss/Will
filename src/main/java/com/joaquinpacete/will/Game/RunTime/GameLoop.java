package com.joaquinpacete.will.Game.RunTime;

import javafx.animation.AnimationTimer;

public class GameLoop {
    private final Display display;
    private AnimationTimer gameLoop;
    private long lastTime = System.nanoTime();
    private double deltaTime = 0;
    private final double desiredFPS = 120;
    private final double desiredFrameTime = 1e9 / desiredFPS; // Nanoseconds per frame
    private double totalRuntime = 0;

    public GameLoop(Display display) {
        this.display = display;
        runGameLoop();
    }

    private void runGameLoop() {
        gameLoop = new AnimationTimer() {
            @Override
            public void handle(long now) {
                deltaTime = now - lastTime;
                totalRuntime += deltaTime;

                // Convert deltaTime to seconds for easier use in game logic
                double deltaTimeSeconds = deltaTime / 1e9;

                // Game update and render methods can use deltaTimeSeconds
                System.out.println("GameLoop running at: " + System.currentTimeMillis() + ", FPS: " + (1e9 / deltaTime) + ", Runtime: " + (totalRuntime / 1e9) + " seconds");
                display.update();

                // Sleep if the frame was processed faster than desiredFrameTime
                long sleepTime = (long) (desiredFrameTime - (System.nanoTime() - now)) / 1_000_000; // Convert to milliseconds
                if (sleepTime > 0) {
                    try {
                        Thread.sleep(sleepTime);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }

                // Update lastTime for the next frame's deltaTime calculation
                lastTime = now;
            }
        };
        gameLoop.start();
    }
}