package com.aor.hero.model.game.arena;

import com.aor.hero.model.game.elements.*;

import java.util.List;

public abstract class ArenaBuilder {
    public Arena createArena(int vidas, int pontos) {
        Arena arena = new Arena(getWidth(), getHeight());
        arena.setPacman(createPacman());
        arena.setMonsters(createMonsters());
        arena.setWalls(createWalls());
        arena.setCoins(createCoins());
        arena.setSuperCoins(createSupCoins());
        arena.getPacman().setPontos(pontos);
        arena.getPacman().setVidas(vidas);
        return arena;
    }

    protected abstract int getWidth();

    protected abstract int getHeight();

    protected abstract List<Wall> createWalls();

    protected abstract List<Monster> createMonsters();

    protected abstract List<Coin> createCoins();

    protected abstract List<SupCoin> createSupCoins();

    protected abstract Pacman createPacman();
}
