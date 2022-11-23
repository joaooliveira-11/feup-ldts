package org.example;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import java.util.ArrayList;
import java.util.List;

public class Game_map {
    private Pacman pacman;

    private ArrayList<Monster> monsters=new ArrayList<>();
    private int height;
    private int widht;

    Game_map(int height,int widht){
        this.height=height;
        this.widht=widht;
        pacman = new Pacman(9,16);
        Monster m1 = new Monster(7,9);
        Monster m2 = new Monster(8,9);
        Monster m3 = new Monster(9,9);
        Monster m4 = new Monster(10,9);
        monsters.add(m1);
        monsters.add(m2);
        monsters.add(m3);
        monsters.add(m4);
    }

    void draw(TextGraphics graphics) {
        pacman.draw(graphics);
    }

    boolean movePacman(KeyStroke input) {
        boolean answer = true;
        switch (input.getKeyType()) {
            case ArrowDown:
                pacman.setPosition(pacman.moveDown());
                break;
            case ArrowLeft:
                pacman.setPosition(pacman.moveLeft());
                break;
            case ArrowRight:
                pacman.setPosition(pacman.moveRight());
                break;
            case ArrowUp:
                pacman.setPosition(pacman.moveUp());
                break;
            case Character:
                if (input.getCharacter() == 'q') {
                    answer = false;
                }
                break;
            case EOF:
                answer = false;
                break;
        }
        return answer;
    }
    void moveMonsters(){
        for(Monster monster:monsters){
            monster.setPosition(monster.move());
        }
    }
}
