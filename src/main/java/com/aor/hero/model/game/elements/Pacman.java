package com.aor.hero.model.game.elements;

public class Pacman extends Element {
    private int vidas;

    private int pontos;

    private int power;

    private long PowerTime;

    public Pacman(int x, int y) {
        super(x, y);
        this.vidas = 3;
        this.pontos = 0;
        this.power = 0;
        this.PowerTime = 0;
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

    public void winpower(){
        this.power = 1;
    }

    public void losepower(){this.power = 0;}

    public int getPower() {
        return power;
    }

    public long getPowerTime() {
        return PowerTime;
    }

    public void startPowerTime(){
        this.PowerTime = System.currentTimeMillis();
    }

    public boolean didTimeEnd(){
        return System.currentTimeMillis() - PowerTime >= 5000;
    }
}
