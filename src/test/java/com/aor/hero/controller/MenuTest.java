package com.aor.hero.controller;

import com.aor.hero.model.menu.Menu;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class MenuTest {

    private Menu menu = new Menu();
    @Test
    void MenuFunctionalitiesTest(){
        assertEquals(3,menu.getNumberEntries());
        assertEquals("Start Game",menu.getEntry(0));
        assertEquals("Instructions",menu.getEntry(1));
        assertEquals("Exit",menu.getEntry(2));
        menu.nextEntry();
        menu.nextEntry();
        assertTrue(menu.isSelected(2));
        assertTrue(menu.isSelectedExit());
        assertFalse(menu.isSelectedStart());
        //assertFalse(menu.isSelectedInstructions());
        menu.nextEntry();
        assertTrue(menu.isSelected(0));
        assertTrue(menu.isSelectedStart());
        assertFalse(menu.isSelectedExit());
        //assertFalse(menu.isSelectedInstructions());
        menu.previousEntry();
        menu.previousEntry();
        assertTrue(menu.isSelected(1));
        //assertTrue(menu.isSelectedInstructions());
        assertFalse(menu.isSelectedExit());
        assertFalse(menu.isSelectedStart());
    }
}
