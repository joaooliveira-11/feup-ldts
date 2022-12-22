package com.aor.hero.model.game.elements;

public class Pacman extends Element {
    private int vidas;

    private int pontos;

    private long PowerTime;

    private String direction;


    public Pacman(int x, int y) {
        super(x, y);
        this.vidas = 3;
        this.pontos = 0;
        this.PowerTime = 0;
        this.direction = "none";
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
    public void aumentarpontosmonstro(){this.pontos+=100;}

    public void setPontos(int pontos1){this.pontos = pontos1;}

    public void setVidas(int vidas1){this.vidas = vidas1;}

    public long getPowerTime() {
        return PowerTime;
    }

    public void startPowerTime(){
        this.PowerTime = System.currentTimeMillis();
    }

    public boolean didTimeEnd(){
        return System.currentTimeMillis() - PowerTime >= 5000;
    }

    public String getDirection(){
        return direction;
    }
    public void setDirection(String direction){
        this.direction=direction;
    }
}
