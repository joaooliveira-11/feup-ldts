package com.aor.hero.model.menu;

import java.util.Arrays;
import java.util.List;

public class Menu {
    private List<String> entries;
    private int currentEntry = 0;

    public Menu() {
        this.entries = Arrays.asList("Start Game", "Instructions", "Exit");
    }

    public void setMenuToGameOverMenu(){
        this.entries = Arrays.asList("Play again", "Exit");
    }

    public boolean isGameOver() {
        return entries.equals(Arrays.asList("Play again", "Exit"));
    }
    public void nextEntry() {
        currentEntry++;
        if (currentEntry > this.entries.size() - 1)
            currentEntry = 0;
    }

    public void previousEntry() {
        currentEntry--;
        if (currentEntry < 0)
            currentEntry = this.entries.size() - 1;
    }

    public String getEntry(int i) {
        return entries.get(i);
    }

    public boolean isSelected(int i) {
        return currentEntry == i;
    }

    public boolean isSelectedExit() {

        return isGameOver() ? isSelected(1) : isSelected(2);
    }

    public boolean isSelectedStart() {
        return isSelected(0);
    }

    public int getNumberEntries() {
        return this.entries.size();
    }
}

