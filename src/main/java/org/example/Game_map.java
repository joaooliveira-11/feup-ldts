package org.example;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyType;

public class Game_map {
    private Pacman pacman;
    private int height;
    private int widht;

    Game_map(int height,int widht){
        this.height=height;
        this.widht=widht;
        pacman=new Pacman(20,35);
    }

    void draw(TextGraphics graphics) {
        pacman.draw(graphics);
    }

    void movePacman(KeyType key, boolean flag) {
        switch (key) {
            case ArrowDown -> pacman.setPosition(pacman.moveDown());
            case ArrowLeft -> pacman.setPosition(pacman.moveLeft());
            case ArrowRight -> pacman.setPosition(pacman.moveRight());
            case ArrowUp -> pacman.setPosition(pacman.moveUp());
            case Backspace -> {
                flag = false;
            }
        }
    }
}
