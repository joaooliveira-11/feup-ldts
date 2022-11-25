package com.aor.hero.model.game.elements;

public class Pacman extends Element {
    private int vidas;

    public Pacman(int x, int y) {
        super(x, y);
        this.vidas = 3;
    }

    public void diminuirVidas() {
        this.vidas--;
    }

    public int getVidas() {
        return vidas;
    }
}
