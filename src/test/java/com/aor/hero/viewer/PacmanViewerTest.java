package com.aor.hero.viewer;

import com.aor.hero.gui.GUI;
import com.aor.hero.model.game.elements.Pacman;
import com.aor.hero.viewer.game.HeroViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PacmanViewerTest {
    private Pacman pacman;
    private HeroViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        pacman = new Pacman(10, 10);
        viewer = new HeroViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElement() {
        viewer.draw(pacman, gui);
        Mockito.verify(gui, Mockito.times(1)).drawPacman(pacman.getPosition());
    }
}