package com.aor.hero.model.game.elements;

public class Pacman extends Element {
    private int vidas;

    private int pontos;

    public Pacman(int x, int y) {
        super(x, y);
        this.vidas = 3;
        this.pontos = 0;
    }

    public void diminuirVidas() {
        this.vidas--;
    }

    public int getVidas() {
        return vidas;
    }

    public int getPontos() {
        return pontos;
    }

    public void aumentarpontoscoin() {
        this.pontos += 10;
    }

    public void aumentarpontossupercoin() {
        this.pontos += 50;
    }
}
