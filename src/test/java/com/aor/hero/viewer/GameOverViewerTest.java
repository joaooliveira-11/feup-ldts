package com.aor.hero.viewer;

import com.aor.hero.gui.GUI;
import com.aor.hero.model.Position;
import com.aor.hero.model.menu.GameOver;
import com.aor.hero.viewer.menu.GameOverViewer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class GameOverViewerTest {

    private GameOverViewer gameOverViewer= new GameOverViewer(new GameOver());
    private GUI gui = Mockito.mock(GUI.class);

    @Test
    void drawElements() {
        gameOverViewer.drawElements(gui);
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(5, 5), "GAMEOVER", "#FFFFFF");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(5, 6), "YOU FAILLED", "#FFFFFF");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(5, 7), "THE TEST", "#FFFFFF");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(2, 9), "YOU CAN DO BETTER!", "#FFFFFF");
    }
}
