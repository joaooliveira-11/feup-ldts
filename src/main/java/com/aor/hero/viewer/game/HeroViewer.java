package com.aor.hero.viewer.game;

import com.aor.hero.gui.GUI;
import com.aor.hero.model.game.elements.Pacman;

public class HeroViewer implements ElementViewer<Pacman> {
    @Override
    public void draw(Pacman pacman, GUI gui) {
        gui.drawPacman(pacman.getPosition());
    }
}
