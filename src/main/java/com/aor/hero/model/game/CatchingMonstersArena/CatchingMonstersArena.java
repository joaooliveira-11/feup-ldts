package com.aor.hero.model.game.CatchingMonstersArena;

import com.aor.hero.model.Position;
import com.aor.hero.model.game.GameArena;
import com.aor.hero.model.game.elements.*;

import java.util.ArrayList;
import java.util.List;

public class CatchingMonstersArena implements GameArena {
    private final int width;
    private final int height;

    private List<Monster> monsters= new ArrayList<>();
    private Pacman pacman;

    private List<MonsterRunning> monstersrunning;
    private List<Wall> walls;

    private List<Coin> coins;

    private List<SupCoin> supercoins;
    private List<Gate> gates;

    CatchingMonstersArena(int width,int height){
        this.width=width;
        this.height=height;
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
        this.pacman=pacman;
    }

    @Override
    public List<Wall> getWalls() {
        return walls;
    }

    @Override
    public void setWalls(List<Wall> walls) {
        this.walls=walls;
    }

    @Override
    public List<Coin> getCoins() {
        return coins;
    }

    @Override
    public Coin getCoin(Position position) {
        for(Coin coin:coins){
            if(coin.getPosition().equals(position)) return coin;
        }
        return null;
    }

    @Override
    public SupCoin getSuperCoin(Position position) {
        for(SupCoin supercoin:supercoins){
            if(supercoin.getPosition().equals(position)) return supercoin;
        }
        return null;
    }

    @Override
    public void setCoins(List<Coin> coins1) {
        this.coins=coins1;
    }

    @Override
    public List<SupCoin> getSuperCoins() {
        return supercoins;
    }

    @Override
    public void setSuperCoins(List<SupCoin> supercoins1) {
        this.supercoins=supercoins1;
    }

    @Override
    public List<Gate> getGates() {
        return gates;
    }

    @Override
    public void setGates(List<Gate> gates) {
        this.gates=gates;
    }

    @Override
    public boolean isEmpty(Position position) {
        for (Wall wall : walls)
            if (wall.getPosition().equals(position))
                return false;
        return true;
    }
    public boolean isMonsterRunning(Position position) {
        try {
            for (MonsterRunning monsterrunning : monstersrunning)
                if (monsterrunning.getPosition().equals(position))
                    return true;
            return false;
        }
        catch (NullPointerException e){
            return false;
        }
    }
    public boolean isMonster(Position position) {
        try {
            for (Monster monster : monsters)
                if (monster.getPosition().equals(position))
                    return true;
            return false;
        }
        catch (NullPointerException e){
            return false;
        }
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
    public List<MonsterRunning> getMonstersRunning() {
        try {
            return monstersrunning;
        }
        catch (NullPointerException e){
            return new ArrayList<>();
        }
    }

    public MonsterRunning getMonsterRunning(Position position){
        for(MonsterRunning monster:monstersrunning){
            if(monster.getPosition().equals(position)) return monster;
        }
        return null;
    }
    public void setMonstersRunning(List<MonsterRunning> monstersRunning) {
        this.monstersrunning = monstersRunning;
    }

    public List<Monster> getMonsters() {
        try {
            return monsters;
        }
        catch (NullPointerException e){
            return new ArrayList<>();
        }
    }

    public List<MonsterRunning> switchToMonstersRunning(List<Monster> monsters){
        if(monstersrunning==null){
            monstersrunning=new ArrayList<>();
        }
        for (Monster monster: monsters){
            monstersrunning.add(new MonsterRunning(monster.getPosition().getX(),monster.getPosition().getY()));
        }
        monsters.clear();
        return monstersrunning;
    }
    public boolean isGate(Position position) {
        for (Gate gate : gates)
            if (gate.getPosition().equals(position))
                return true;
        return false;
    }

}
