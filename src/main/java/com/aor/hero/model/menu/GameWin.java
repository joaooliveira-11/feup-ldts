package com.aor.hero.model.menu;

import java.util.Arrays;
import java.util.List;

public class GameWin {
    private List<String> gamewin_entries;

    private int gameowin_currentEntry = 0;

    public GameWin() {
        this.gamewin_entries = Arrays.asList("Try Better Score", "Exit");
    }

    public void nextEntry() {
        gameowin_currentEntry++;
        if (gameowin_currentEntry > this.gamewin_entries.size() - 1)
            gameowin_currentEntry= 0;
    }

    public void previousEntry() {
        gameowin_currentEntry--;
        if (gameowin_currentEntry< 0)
            gameowin_currentEntry = this.gamewin_entries.size() - 1;
    }

    public String getEntry(int i) {
        return gamewin_entries.get(i);
    }

    public boolean isSelected(int i) {
        return gameowin_currentEntry == i;
    }

    public boolean isSelectedTryBetterScore() {
        return isSelected(0);
    }

    public boolean isSelectedExit() {
        return isSelected(1);
    }

    public int getNumberEntries() {
        return this.gamewin_entries.size();
    }
}

