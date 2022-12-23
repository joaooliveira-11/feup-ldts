package com.aor.hero.viewer;
import com.aor.hero.gui.GUI;
import com.aor.hero.model.game.elements.Gate;
import com.aor.hero.viewer.game.GateViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class GateViewerTest {
    private Gate gate;
    private GateViewer gateViewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        gate = new Gate(10, 10);
        gateViewer = new GateViewer();
        gui = Mockito.mock(GUI.class);
    }
    @Test
    void drawElement() {
        gateViewer.draw(gate, gui);
        Mockito.verify(gui, Mockito.times(1)).drawGate(gate.getPosition());
    }
}