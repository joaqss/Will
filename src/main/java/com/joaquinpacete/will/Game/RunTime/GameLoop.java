// fps printer obtained from: https://stackoverflow.com/questions/28287398/what-is-the-preferred-way-of-getting-the-frame-rate-of-a-javafx-application

package com.joaquinpacete.will.Game.RunTime;

import javafx.animation.AnimationTimer;
import javafx.application.Platform;

public class GameLoop implements Runnable {
    private final Display display;
    private boolean running;
    private final double updateRate = 1.0d/60.0d;

    private long nextStatTime;
    private int fps, ups;


    public GameLoop(Display display) {
        this.display = display;
    }

    @Override
    public void run() {
        running = true;
        double accumulator = 0;
        long currentTime , lastUpdate = System.currentTimeMillis();
        nextStatTime = System.currentTimeMillis() + 1000;

        while (running) {
            currentTime = System.currentTimeMillis();
            double lastRenderTimeInSeconds = (currentTime - lastUpdate) / 1000.0d;
            accumulator += lastRenderTimeInSeconds;
            lastUpdate = currentTime;

            while(accumulator > updateRate) {
                update();
                accumulator -= updateRate;
            }
            render();
            printStats();
        }
    }

    private void printStats() {
        if (System.currentTimeMillis() > nextStatTime) {
            System.out.printf("FPS: %d, UPS: %d\n", fps, ups);
            fps = 0;
            ups = 0;
            nextStatTime = System.currentTimeMillis() + 1000;
        }
    }

    private void render() {
        fps++;
    }

    private void update() {
        display.update();
        ups++;
    }
}