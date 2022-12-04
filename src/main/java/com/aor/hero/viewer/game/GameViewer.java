package com.aor.hero.viewer.game;

import com.aor.hero.gui.GUI;
import com.aor.hero.model.Position;
import com.aor.hero.model.game.arena.Arena;
import com.aor.hero.model.game.elements.Element;
import com.aor.hero.viewer.Viewer;

import java.util.List;

public class GameViewer extends Viewer<Arena> {
    public GameViewer(Arena arena) {
        super(arena);
    }

    @Override
    public void drawElements(GUI gui) {
        drawElements(gui, getModel().getWalls(), new WallViewer());
        drawElements(gui, getModel().getMonsters(), new MonsterViewer());
        drawElement(gui, getModel().getPacman(), new HeroViewer());
        drawElements(gui, getModel().getCoins(), new CoinViewer());
        drawElements(gui, getModel().getSuperCoins(), new SuperCoinViewer());
        gui.drawText(new Position(0, 0), "Vidas: " + getModel().getPacman().getVidas(), "#FFD700");
        gui.drawText(new Position(10, 0), "Pontos: " + getModel().getPacman().getPontos(), "#FFD700");
    }

    private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements)
            drawElement(gui, element, viewer);
    }

    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }
}
