package com.aor.hero.model.game.arena;

import com.aor.hero.model.Position;
import com.aor.hero.model.game.elements.*;

import java.util.List;

public class Arena {
    private final int width;
    private final int height;

    private Pacman pacman;

    private List<Monster> monsters;
    private List<Wall> walls;

    private List<Coin> coins;

    private List<SupCoin> supercoins;

    private List<Gate> gates;

    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Pacman getPacman() {
        return pacman;
    }

    public void setPacman(Pacman pacman) {
        this.pacman = pacman;
    }

    public List<Monster> getMonsters() {
        return monsters;
    }

    public void setMonsters(List<Monster> monsters) {
        this.monsters = monsters;
    }

    public List<Wall> getWalls() {
        return walls;
    }

    public void setWalls(List<Wall> walls) {
        this.walls = walls;
    }

    public List<Coin> getCoins() {
        return coins;
    }

    public List<Gate> getGates() {
        return gates;
    }

    public void setGates(List<Gate> gates1) {
        this.gates = gates1;
    }

    public Coin getCoin(Position position){
        for(Coin coin:coins){
            if(coin.getPosition().equals(position)) return coin;
        }
        return null;
    }

    public SupCoin getSuperCoin(Position position){
        for(SupCoin supercoin:supercoins){
            if(supercoin.getPosition().equals(position)) return supercoin;
        }
        return null;
    }

    public Monster getMonster(Position position){
        for(Monster monster:monsters){
            if(monster.getPosition().equals(position)) return monster;
        }
        return null;
    }

    public Gate getGate(Position position){
        for(Gate gate:gates){
            if(gate.getPosition().equals(position)) return gate;
        }
        return null;
    }

    public void setCoins(List<Coin> coins1) {
        this.coins = coins1;
    }

    public List<SupCoin> getSuperCoins() {
        return supercoins;
    }

    public void setSuperCoins(List<SupCoin> supercoins1) {
        this.supercoins = supercoins1;
    }

    public boolean isEmpty(Position position) {
        for (Wall wall : walls)
            if (wall.getPosition().equals(position))
                return false;
        return true;
    }

    public boolean isMonster(Position position) {
        for (Monster monster : monsters)
            if (monster.getPosition().equals(position))
                return true;
        return false;
    }

    public boolean isCoin(Position position) {
        for (Coin coin : coins)
            if (coin.getPosition().equals(position))
                return true;
        return false;
    }

    public boolean isSuperCoin(Position position) {
        for (SupCoin supercoin : supercoins)
            if (supercoin.getPosition().equals(position))
                return true;
        return false;
    }
    public boolean isGate(Position position) {
        for (Gate gate : gates)
            if (gate.getPosition().equals(position))
                return true;
        return false;
    }
}
