package com.aor.hero.model.game.CatchingMonstersArena;


import com.aor.hero.model.game.ArenaBuilder;
import com.aor.hero.model.game.elements.*;

import java.util.List;

public class CatchingMonstersArenaBuilder extends ArenaBuilder<CatchingMonstersArena> {
    CatchingMonstersArena arena = new CatchingMonstersArena(19, 22);

    public CatchingMonstersArena createCatchingMonstersArena(int lifes,int pontos,Pacman pacman, List<Monster> monsters,List<MonsterRunning> monstersrunning,List<Wall> walls, List<Coin> coins, List<SupCoin> supercoins ){

        arena.setPacman(pacman);
        arena.setMonstersRunning(arena.switchToMonstersRunning(monsters));
        arena.setWalls(walls);
        arena.setCoins(coins);
        arena.setSuperCoins(supercoins);
        arena.getPacman().setVidas(lifes);
        arena.getPacman().setPontos(pontos);

        return arena;
    }

    @Override
    protected int getWidth() { return 19;}

    @Override
    protected int getHeight() {
        return 22;
    }

    @Override
    protected List<Wall> createWalls() {
        return null;
    }

    @Override
    protected List<Monster> createMonsters() {
        return null;
    }

    @Override
    protected List<Coin> createCoins() {
        return null;
    }

    @Override
    protected List<SupCoin> createSupCoins() {
        return null;
    }

    @Override
    protected Pacman createPacman() {
        return null;
    }

}
