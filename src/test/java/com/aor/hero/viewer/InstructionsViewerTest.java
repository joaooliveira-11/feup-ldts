package com.aor.hero.viewer;

import com.aor.hero.gui.GUI;
import com.aor.hero.model.Position;
import com.aor.hero.model.menu.GameOver;
import com.aor.hero.model.menu.Instructions;
import com.aor.hero.viewer.menu.GameOverViewer;
import com.aor.hero.viewer.menu.InstructionsViewer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class InstructionsViewerTest {
    private InstructionsViewer instructionsViewer= new InstructionsViewer(new Instructions());
    private GUI gui = Mockito.mock(GUI.class);

    @Test
    void drawElements() {
        instructionsViewer.drawElements(gui);
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(0, 0), "GOAL:", "#FC3626");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(0, 1), "eat all coins", "#FFFFFF");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(0, 2), "while lives >=1", "#FFFFFF");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(0, 3), "in the 2 levels", "#FFFFFF");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(0, 4), "to win the game", "#FFFFFF");

        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(0, 6), "HOW TO PLAY?", "#FC3626");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(0, 7), "Arrowup:Move Forwards", "#FFFFFF");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(0, 8), "Arrowdown:Move Backwards", "#FFFFFF");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(0, 9), "Arrowright:Move Right", "#FFFFFF");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(0, 10), "Arrowleft:Move Left", "#FFFFFF");


        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(0, 12), "POINTS", "#FC3626");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(0, 13), "Hit coin: +10", "#FFFFFF");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(0, 14), "Hit supercoin: +50", "#FFFFFF");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(0, 15), "Hit monster: -100", "#FFFFFF");

        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(0, 17), "Lives", "#FC3626");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(0, 18), "hit monster power=0: -1", "#FFFFFF");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(0, 19), "pass the lvl1 with:", "#FFFFFF");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(0, 20), "lives = 3: -0", "#FFFFFF");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(0, 21), "lives < 3: +1", "#FFFFFF");
    }
}