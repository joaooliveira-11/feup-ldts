package com.aor.hero.viewer.game;

import com.aor.hero.gui.GUI;
import com.aor.hero.model.game.elements.Gate;

public class GateViewer implements ElementViewer<Gate>{
    @Override
    public void draw(Gate gate, GUI gui) {
        gui.drawGate(gate.getPosition());
    }
}
