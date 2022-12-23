package com.aor.hero.viewer;

import com.aor.hero.gui.GUI;
import com.aor.hero.model.Position;
import com.aor.hero.model.menu.GameOver;
import com.aor.hero.viewer.menu.GameOverViewer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class GameOverViewerTest {

    private final GameOverViewer gameOverViewer= new GameOverViewer(new GameOver());
    private final GUI gui = Mockito.mock(GUI.class);

    @Test
    void drawElements() {
        gameOverViewer.drawElements(gui);
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(5, 5), "GAMEOVER", "#FF0000");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(5, 6), "YOU FAILLED", "#FF0000");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(5, 7), "THE TEST", "#FF0000");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(2, 9), "YOU CAN DO BETTER!", "#FF0000");
    }
}