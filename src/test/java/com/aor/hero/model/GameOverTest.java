package com.aor.hero.model;

import com.aor.hero.model.menu.GameOver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameOverTest {
    // public GameOver() {
    //        this.gameover_entries = Arrays.asList("Try Again", "Give Up");
    //    }
    GameOver gameOver;
    @BeforeEach
    void setUp() {
        gameOver = new GameOver();
    }
    @Test
    void Instructions_getentry_0(){
        Assertions.assertNotNull(gameOver.getEntry(0));
        Assertions.assertEquals("Try Again", gameOver.getEntry(0));
        Assertions.assertNotEquals("Give Up", gameOver.getEntry(0));
    }

    @Test
    void Instructions_getentry_1(){
        Assertions.assertNotNull(gameOver.getEntry(1));
        Assertions.assertEquals("Give Up", gameOver.getEntry(1));
        Assertions.assertNotEquals("Try again", gameOver.getEntry(1));
    }

    @Test
    void Instructions_getsize(){
        Assertions.assertNotNull(gameOver.getNumberEntries());
        Assertions.assertEquals(2, gameOver.getNumberEntries());
        Assertions.assertNotEquals(3, gameOver.getNumberEntries());
        Assertions.assertNotEquals(-1, gameOver.getNumberEntries());
        Assertions.assertNotEquals(1, gameOver.getNumberEntries());
    }
}
