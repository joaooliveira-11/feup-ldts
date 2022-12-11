package com.aor.hero.model.menu;

import java.util.Arrays;
import java.util.List;

public class GameOver {
    private List<String> gameover_entries;

    private int gameover_currentEntry = 0;

    public GameOver() {
        this.gameover_entries = Arrays.asList("Try Again", "Give Up");
    }

    public void nextEntry() {
        gameover_currentEntry++;
        if (gameover_currentEntry > this.gameover_entries.size() - 1)
            gameover_currentEntry= 0;
    }

    public void previousEntry() {
        gameover_currentEntry--;
        if (gameover_currentEntry< 0)
            gameover_currentEntry = this.gameover_entries.size() - 1;
    }

    public String getEntry(int i) {
        return gameover_entries.get(i);
    }

    public boolean isSelected(int i) {
        return gameover_currentEntry == i;
    }

    public boolean isSelectedGiveUp() {
        return isSelected(1);
    }

    public boolean isSelectedTryAgain() {
        return isSelected(0);
    }

    public int getNumberEntries() {
        return this.gameover_entries.size();
    }
}
