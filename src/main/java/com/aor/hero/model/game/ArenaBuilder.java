package com.aor.hero.model.game;

import com.aor.hero.model.game.arena.Arena;
import com.aor.hero.model.game.elements.*;

import java.util.List;

public abstract class ArenaBuilder<T> {

    protected abstract int getWidth();

    protected abstract int getHeight();

    protected abstract List<Wall> createWalls();

    protected abstract List<Monster> createMonsters();

    protected abstract List<Coin> createCoins();

    protected abstract List<SupCoin> createSupCoins();

    protected abstract Pacman createPacman();
}
