package com.aor.hero.gui;

import com.aor.hero.model.Position;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class LanternaGUITest {
    private Screen screen;
    private LanternaGUI gui;
    private TextGraphics tg;

    @BeforeEach
    void setUp() {
        screen = Mockito.mock(Screen.class);
        tg = Mockito.mock(TextGraphics.class);

        Mockito.when(screen.newTextGraphics()).thenReturn(tg);

        gui = new LanternaGUI(screen);
    }


    @Test
    void drawHero() {
        gui.drawPacman(new Position(1, 1));
        //FFD700
        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 215, 0));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 2, "H");
    }

    @Test
    void drawWall() {
        gui.drawWall(new Position(1, 1));
        // 255 255 255
        // 0 0 204
        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 255, 255));
        Mockito.verify(tg, Mockito.times(1)).setBackgroundColor(new TextColor.RGB(0, 0, 204));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 2, " ");
    }

    @Test
    void drawMonster() {
        gui.drawMonster(new Position(1, 1));

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(204, 0, 0));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 2, "@");
    }

    @Test
    void drawCoin() {
        gui.drawCoin(new Position(1, 1));

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(218, 165, 32));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 2, "o");
    }

    @Test
    void drawSuperCoin() {
        gui.drawSupCoin(new Position(1, 1));

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(218, 165, 32));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 2, "O");
    }

    @Test
    void drawText() {
        gui.drawText(new Position(1, 1), "Hello World", "#336699");

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(51, 102, 153));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 1, "Hello World");
    }
}