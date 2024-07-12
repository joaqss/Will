package com.joaquinpacete.will.Game.Overlays;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import com.joaquinpacete.will.Engine;

public class Hotbar {
    Engine engine;
    private Rectangle[] hotbarSlots = new Rectangle[9];
    private int selectedSlot = 0;

    public Hotbar(Engine engine, Pane pane) {
        this.engine = engine;

        int totalWidth = (50 * 9) + (10 * 9); // Total width of slots and gaps
        int slotX = (engine.SCREEN_WIDTH - totalWidth)/2;
        int slotY = engine.SCREEN_HEIGHT-120;

        System.out.println("SLOT X: " + slotX);
        System.out.println("SLOT Y: " + slotY);
        System.out.println("SCREEN WIDTH: " + engine.SCREEN_WIDTH);
        System.out.println("SCREEN HEIGHT: " + engine.SCREEN_HEIGHT);

        for (int slot = 0; slot<=8; slot++) {
            Rectangle hotbarSlot = new Rectangle(slotX + (slot * (50 + 10)), slotY, 50, 50);
            hotbarSlots[slot] = hotbarSlot;
            hotbarSlot.setFill(Color.TRANSPARENT);
            hotbarSlot.setStroke(Color.BLACK);
            pane.getChildren().add(hotbarSlot);
        }
    }

    public void selectSlot(int slot) {

        // unhighlight previously selected slot
        if (selectedSlot != -1) {
            hotbarSlots[selectedSlot].setStroke(Color.BLACK);
        }

        hotbarSlots[slot].setStroke(Color.RED); // Highlight the selected slot
        selectedSlot = slot;
        System.out.println("Selected slot: " + slot);
    }

}
