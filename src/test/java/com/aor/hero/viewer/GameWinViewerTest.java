package com.aor.hero.viewer;

import com.aor.hero.gui.GUI;
import com.aor.hero.model.Position;
import com.aor.hero.model.menu.GameWin;
import com.aor.hero.viewer.menu.GameWinViewer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class GameWinViewerTest {
    private final GameWinViewer gameWinViewer= new GameWinViewer(new GameWin());
    private final GUI gui = Mockito.mock(GUI.class);

    @Test
    void drawElements() {
        gameWinViewer.drawElements(gui);
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(1, 5), "Congratulations Player", "#FFFFFF");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(1, 6), "you passed all levels", "#FFFFFF");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(1, 7), "with sucess", "#FFFFFF");
    }
}
