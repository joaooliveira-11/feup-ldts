package com.aor.hero.model.game.arena;

import com.aor.hero.model.game.ArenaBuilder;
import com.aor.hero.model.game.CatchingMonstersArena.CatchingMonstersArena;
import com.aor.hero.model.game.elements.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class LoaderArenaBuilder extends ArenaBuilder<Arena> {
    private int level;
    private List<String> lines;

    private Arena arena;
    public LoaderArenaBuilder() {

    }
    public Arena createArena(int lifes, int pontos, Pacman pacman, List<Monster> monsters,List<MonsterRunning> monstersrunning, List<Wall> walls, List<Coin> coins, List<SupCoin> supercoins,List<Gate> gates,String direction){
        arena = new Arena(19,22);
        arena.setPacman(pacman);
        arena.setMonsters(arena.switchToMonsters(monsters,monstersrunning));
        arena.setWalls(walls);
        arena.setCoins(coins);
        arena.setSuperCoins(supercoins);
        arena.setGates(gates);
        arena.getPacman().setVidas(lifes);
        arena.getPacman().setPontos(pontos);
        arena.getPacman().setDirection(direction);

        return arena;
    }

    public Arena createArena(int vidas, int pontos) {
        arena= new Arena(getWidth(),getHeight());
        arena.setPacman(createPacman());
        arena.setMonsters(createMonsters());
        arena.setWalls(createWalls());
        arena.setCoins(createCoins());
        arena.setSuperCoins(createSupCoins());
        arena.setGates(createGates());
        arena.getPacman().setPontos(pontos);
        arena.getPacman().setVidas(vidas);
        return arena;
    }
    public Arena createArena(int vidas, int pontos,List<Wall> walls ,List<Coin> coins,List<SupCoin> supCoins,List<Gate> gates){
        arena= new Arena(getWidth(),getHeight());
        arena.setPacman(createPacman());
        arena.setMonsters(createMonsters());
        arena.setWalls(walls);
        arena.setGates(gates);
        arena.setSuperCoins(supCoins);
        arena.setCoins(coins);
        arena.getPacman().setVidas(vidas);
        arena.getPacman().setPontos(pontos);
        return arena;
    }

    public LoaderArenaBuilder(int level) throws IOException {
        this.level = level;

        URL resource = LoaderArenaBuilder.class.getResource("/levels/level" + level + ".lvl");
        BufferedReader br = new BufferedReader(new FileReader(resource.getFile()));

        lines = readLines(br);
    }

    private List<String> readLines(BufferedReader br) throws IOException {
        List<String> lines = new ArrayList<>();
        for (String line; (line = br.readLine()) != null; )
            lines.add(line);
        return lines;
    }

    @Override
    protected int getWidth() {
        int width = 0;
        for (String line : lines)
            width = Math.max(width, line.length());
        return width;
    }

    @Override
    protected int getHeight() {
        return lines.size();
    }

    @Override
    protected List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == '#') walls.add(new Wall(x, y));
        }

        return walls;
    }

    @Override
    protected List<Monster> createMonsters() {
        List<Monster> monsters = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'M') monsters.add(new Monster(x, y));
        }

        return monsters;
    }

    @Override
    protected Pacman createPacman() {
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'H') return new Pacman(x, y);
        }
        return null;
    }
    @Override
    protected List<Coin>createCoins() {
        List<Coin> coins = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'o') coins.add(new Coin(x, y));
        }

        return coins;
    }
    @Override
    protected List<SupCoin>createSupCoins() {
        List<SupCoin> supercoins = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'O') supercoins.add(new SupCoin(x, y));
        }

        return supercoins;
    }


    @Override
    protected List<Gate>createGates() {
        List<Gate> gates = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'G') gates.add(new Gate(x, y));
        }

        return gates;
    }
}