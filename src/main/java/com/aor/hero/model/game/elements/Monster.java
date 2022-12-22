package com.aor.hero.model.game.elements;

public class Monster extends Element {

    private boolean running;

    public Monster(int x, int y) {

        super(x, y);
        this.running=false;

    }
    public boolean isRunning(){
        return this.running;
    }
    public void setRunningState(boolean x){
        this.running=x;
    }
}
