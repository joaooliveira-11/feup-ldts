package com.aor.hero.model.game.arena;

import com.aor.hero.model.Position;
import com.aor.hero.model.game.GameArena;
import com.aor.hero.model.game.elements.*;

import java.util.ArrayList;
import java.util.List;

public class Arena implements GameArena {
    private final int width;
    private final int height;
    private Pacman pacman;

    private List<MonsterRunning> monstersRunning;

    private List<Monster> monsters;
    private List<Wall> walls;

    private List<Coin> coins;

    private List<SupCoin> supercoins;

    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
    }
    @Override
    public int getWidth() {
        return width;
    }
    @Override
    public int getHeight() {
        return height;
    }
    @Override
    public Pacman getPacman() {
        return pacman;
    }
    @Override
    public void setPacman(Pacman pacman) {
        this.pacman = pacman;
    }

    public List<Monster> getMonsters() {
        return monsters;
    }

    public void setMonsters(List<Monster> monsters) {
        this.monsters = monsters;
    }
    @Override
    public List<Wall> getWalls() {
        return walls;
    }
    @Override
    public void setWalls(List<Wall> walls) {
        this.walls = walls;
    }
    @Override
    public List<Coin> getCoins() {
        return coins;
    }
    @Override
    public Coin getCoin(Position position){
        for(Coin coin:coins){
            if(coin.getPosition().equals(position)) return coin;
        }
        return null;
    }
    @Override
    public SupCoin getSuperCoin(Position position){
        for(SupCoin supercoin:supercoins){
            if(supercoin.getPosition().equals(position)) return supercoin;
        }
        return null;
    }

    public List<MonsterRunning> getMonstersRunning() {
        try {
            return monstersRunning;
        }
        catch (NullPointerException e){
            return new ArrayList<MonsterRunning>();
        }
    }

    public void setMonstersRunning(List<MonsterRunning> monsterRunnings) {
        this.monstersRunning = monsterRunnings;
    }

    public Monster getMonster(Position position){
        for(Monster monster:monsters){
            if(monster.getPosition().equals(position)) return monster;
        }
        return null;
    }
    @Override
    public void setCoins(List<Coin> coins1) {
        this.coins = coins1;
    }
    @Override
    public List<SupCoin> getSuperCoins() {
        return supercoins;
    }
    @Override
    public void setSuperCoins(List<SupCoin> supercoins1) {
        this.supercoins = supercoins1;
    }
    @Override
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
    @Override
    public boolean isCoin(Position position) {
        for (Coin coin : coins)
            if (coin.getPosition().equals(position))
                return true;
        return false;
    }
    @Override
    public boolean isSuperCoin(Position position) {
        for (SupCoin supercoin : supercoins)
            if (supercoin.getPosition().equals(position))
                return true;
        return false;
    }
    public List<Monster> switchToMonsters(List<Monster> monsters, List<MonsterRunning> monstersrunning){
        for (MonsterRunning monsterrunning: monstersrunning){
            monsters.add(new Monster(monsterrunning.getPosition().getX(),monsterrunning.getPosition().getY()));
        }
        return monsters;
    }
    public void DeleteMonsters(){
        monsters.clear();
    }
}
