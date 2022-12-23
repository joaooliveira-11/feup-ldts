package com.aor.hero.model;
import com.aor.hero.model.menu.GameWin;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameWinTest {
    GameWin gamewin;
    @BeforeEach
    void setUp() {
        gamewin = new GameWin();
    }
    @Test
    void Instructions_getentry_0(){
        Assertions.assertNotNull(gamewin.getEntry(0));
        Assertions.assertEquals("Try Better Score", gamewin.getEntry(0));
        Assertions.assertNotEquals("Exit", gamewin.getEntry(0));
    }

    @Test
    void Instructions_getentry_1(){
        Assertions.assertNotNull(gamewin.getEntry(1));
        Assertions.assertEquals("Exit", gamewin.getEntry(1));
        Assertions.assertNotEquals("Try Better Score", gamewin.getEntry(1));
    }

    @Test
    void Instructions_getsize(){
        Assertions.assertNotNull(gamewin.getNumberEntries());
        Assertions.assertEquals(2, gamewin.getNumberEntries());
        Assertions.assertNotEquals(3, gamewin.getNumberEntries());
        Assertions.assertNotEquals(-1, gamewin.getNumberEntries());
    }
}
