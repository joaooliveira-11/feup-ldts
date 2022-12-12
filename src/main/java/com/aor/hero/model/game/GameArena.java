package com.aor.hero.model.game;

import com.aor.hero.model.Position;
import com.aor.hero.model.game.elements.*;

import java.util.List;

public interface GameArena {


    int getWidth();
    int getHeight();
    Pacman getPacman();
    void setPacman(Pacman pacman);
    List<Wall> getWalls();
    void setWalls(List<Wall> walls);
    List<Coin> getCoins();
    Coin getCoin(Position position);
    SupCoin getSuperCoin(Position position);
    void setCoins(List<Coin> coins1);
    List<SupCoin> getSuperCoins();
    void setSuperCoins(List<SupCoin> supercoins1);
    List<Gate> getGates();
    void setGates(List<Gate> gates);

    boolean isEmpty(Position position);
    boolean isCoin(Position position);
    boolean isSuperCoin(Position position);

}
