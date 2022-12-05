package com.aor.hero.model;
import com.aor.hero.model.game.arena.Arena;
import com.aor.hero.model.game.elements.Coin;
import com.aor.hero.model.game.elements.SupCoin;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class ArenaTest {
    private Arena arena;

    @BeforeEach
    void setUp() {
        arena = new Arena(10, 12);
        arena.setCoins(Arrays.asList(new Coin(1, 2), new Coin(2, 3), new Coin(3, 4)));
        arena.setSuperCoins(Arrays.asList(new SupCoin(7, 7), new SupCoin(8, 8), new SupCoin(9, 9)));
    }

    @Test
    void Arena_getwidth(){
        Assertions.assertNotNull(arena.getWidth());
        Assertions.assertEquals(10, arena.getWidth());
    }

    @Test
    void Arena_getheight(){
        Assertions.assertNotNull(arena.getHeight());
        Assertions.assertEquals(12, arena.getHeight());
    }

    @Test
    void Arena_getsupercoins(){
        Assertions.assertNotNull(arena.getSuperCoins());
    }
    /*
    @Test
    void Arena_getCoin(){
        Assertions.assertEquals(new Coin(1,2), arena.getCoin(new Position(1,2)));
    }
     */
}
