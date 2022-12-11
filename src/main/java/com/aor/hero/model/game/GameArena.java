package com.aor.hero.model.game;

import com.aor.hero.model.Position;
import com.aor.hero.model.game.elements.*;

import java.util.List;

public interface GameArena {


    public int getWidth();
    public int getHeight();
    public Pacman getPacman();
    public void setPacman(Pacman pacman);
    public List<Wall> getWalls();
    public void setWalls(List<Wall> walls);
    public List<Coin> getCoins();
    public Coin getCoin(Position position);
    public SupCoin getSuperCoin(Position position);
    public void setCoins(List<Coin> coins1);
    public List<SupCoin> getSuperCoins();
    public void setSuperCoins(List<SupCoin> supercoins1);
    public boolean isEmpty(Position position);
    public boolean isCoin(Position position);
    public boolean isSuperCoin(Position position);

}
