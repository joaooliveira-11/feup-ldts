package com.aor.hero.model.game.arena;

import com.aor.hero.model.game.elements.*;

import java.util.List;

public abstract class ArenaBuilder {
    public Arena createArena() {
        Arena arena = new Arena(getWidth(), getHeight());

        arena.setPacman(createPacman());
        arena.setMonsters(createMonsters());
        arena.setWalls(createWalls());

        return arena;
    }

    protected abstract int getWidth();

    protected abstract int getHeight();

    protected abstract List<Wall> createWalls();

    protected abstract List<Monster> createMonsters();

    //protected abstract List<Coin> createCoins();

    //protected abstract List<SupCoin> createSupCoins();

    protected abstract Pacman createPacman();
}
