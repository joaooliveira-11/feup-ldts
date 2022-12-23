package com.aor.hero.viewer.menu;

import com.aor.hero.gui.GUI;
import com.aor.hero.model.Position;
import com.aor.hero.model.menu.GameOver;
import com.aor.hero.viewer.Viewer;


public class GameOverViewer extends Viewer<GameOver> {
    public GameOverViewer(GameOver gameover) {
        super(gameover);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(5, 5), "GAMEOVER", "#FFFFFF");
        gui.drawText(new Position(5, 6), "YOU FAILLED", "#FFFFFF");
        gui.drawText(new Position(5, 7), "THE TEST", "#FFFFFF");
        gui.drawText(new Position(2, 9), "YOU CAN DO BETTER!", "#FFFFFF");

        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(5, 20 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
    }
}
