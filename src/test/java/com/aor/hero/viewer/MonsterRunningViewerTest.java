package com.aor.hero.viewer;

import com.aor.hero.gui.GUI;
import com.aor.hero.model.game.elements.Gate;
import com.aor.hero.model.game.elements.MonsterRunning;
import com.aor.hero.viewer.CatchingMonsters.MonsterRunningViewer;
import com.aor.hero.viewer.game.GateViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MonsterRunningViewerTest {
    private MonsterRunning monsterRunning;
    private MonsterRunningViewer monsterRunningViewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        monsterRunning = new MonsterRunning(10, 10);
        monsterRunningViewer= new MonsterRunningViewer();
        gui = Mockito.mock(GUI.class);
    }
    @Test
    void drawElement() {
        monsterRunningViewer.draw(monsterRunning, gui);
        Mockito.verify(gui, Mockito.times(1)).drawMonsterRunning(monsterRunning.getPosition());
    }
}
