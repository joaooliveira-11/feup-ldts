package com.aor.hero.viewer.menu;

import com.aor.hero.gui.GUI;
import com.aor.hero.model.Position;
import com.aor.hero.model.menu.GameWin;
import com.aor.hero.viewer.Viewer;

public class GameWinViewer extends Viewer<GameWin> {
    public GameWinViewer(GameWin gamewin) {
        super(gamewin);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(1, 5), "Congratulations Player", "#0000CC");
        gui.drawText(new Position(1, 6), "you passed all levels", "#0000CC");
        gui.drawText(new Position(1, 7), "with sucess", "#0000CC");
        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(5, 20 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
    }
}
