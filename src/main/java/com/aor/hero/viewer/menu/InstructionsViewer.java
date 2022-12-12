package com.aor.hero.viewer.menu;
import com.aor.hero.gui.GUI;
import com.aor.hero.model.Position;
import com.aor.hero.model.menu.Instructions;
import com.aor.hero.viewer.Viewer;

public class InstructionsViewer extends Viewer<Instructions> {
    public InstructionsViewer(Instructions instructions) {
        super(instructions);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(0, 0), "GOAL:", "#FC3626");
        gui.drawText(new Position(0, 1), "eat all coins", "#FFFFFF");
        gui.drawText(new Position(0, 2), "while lives >=1", "#FFFFFF");
        gui.drawText(new Position(0, 3), "in the 2 levels", "#FFFFFF");
        gui.drawText(new Position(0, 4), "to win the game", "#FFFFFF");

        gui.drawText(new Position(0, 6), "HOW TO PLAY?", "#FC3626");
        gui.drawText(new Position(0, 7), "Arrowup:Move Forwards", "#FFFFFF");
        gui.drawText(new Position(0, 8), "Arrowdown:Move Backwards", "#FFFFFF");
        gui.drawText(new Position(0, 9), "Arrowright:Move Right", "#FFFFFF");
        gui.drawText(new Position(0, 10), "Arrowleft:Move Left", "#FFFFFF");


        gui.drawText(new Position(0, 12), "POINTS", "#FC3626");
        gui.drawText(new Position(0, 13), "Hit coin: +10", "#FFFFFF");
        gui.drawText(new Position(0, 14), "Hit supercoin: +50", "#FFFFFF");
        gui.drawText(new Position(0, 15), "Hit monster: -100", "#FFFFFF");

        gui.drawText(new Position(0, 17), "Lives", "#FC3626");
        gui.drawText(new Position(0, 18), "hit monster power=0: -1", "#FFFFFF");
        gui.drawText(new Position(0, 19), "pass the lvl1 with:", "#FFFFFF");
        gui.drawText(new Position(0, 20), "lives = 3: -0", "#FFFFFF");
        gui.drawText(new Position(0, 21), "lives < 3: +1", "#FFFFFF");

        for (int i = 0; i < getModel().getNumberEntries(); i++) {
            gui.drawText(
                    new Position(0, 24 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
        }
    }
}
