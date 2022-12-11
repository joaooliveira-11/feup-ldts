package com.aor.hero.viewer.menu;

import com.aor.hero.gui.GUI;
import com.aor.hero.model.Position;
import com.aor.hero.model.menu.GameOver;
import com.aor.hero.model.menu.GameWin;
import com.aor.hero.viewer.Viewer;

public class GameWinViewer extends Viewer<GameWin> {
    public GameWinViewer(GameWin gamewin) {
        super(gamewin);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(5, 5), "Congratulations, you won the game", "#FFFFFF");

        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(5, 7 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
    }
}
