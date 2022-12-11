package com.aor.hero.model.menu;

import java.util.Arrays;
import java.util.List;

public class Instructions {
    private List<String> instructions_entries;

    private int instructions_currentEntry = 0;

    public Instructions() {
        this.instructions_entries = Arrays.asList("Return");
    }

    public String getEntry(int i) {
        return instructions_entries.get(i);
    }

    public boolean isSelected(int i) {
        return instructions_currentEntry == i;
    }

    public boolean isSelectedReturn() { return isSelected(0);}

    public int getNumberEntries() {
        return this.instructions_entries.size();
    }

}
