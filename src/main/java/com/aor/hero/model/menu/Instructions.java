package com.aor.hero.model.menu;

import java.util.Arrays;
import java.util.List;

public class Instructions {
    private final List<String> instructions_entries;

    public Instructions() {
        this.instructions_entries = List.of("Return");
    }

    public String getEntry(int i) {
        return instructions_entries.get(i);
    }

    public boolean isSelected(int i) {
        int instructions_currentEntry = 0;
        return instructions_currentEntry == i;
    }

    public boolean isSelectedReturn() { return isSelected(0);}

    public int getNumberEntries() {
        return this.instructions_entries.size();
    }

}
