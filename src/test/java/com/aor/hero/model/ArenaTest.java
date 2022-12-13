package com.aor.hero.model;

import com.aor.hero.model.game.arena.Arena;
import com.aor.hero.model.game.elements.Coin;
import com.aor.hero.model.game.elements.Gate;
import com.aor.hero.model.game.elements.Monster;
import com.aor.hero.model.game.elements.SupCoin;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ArenaTest {
    private Arena arena;

    @BeforeEach
    void setUp() {
        arena = new Arena(10, 12);
        arena.setCoins(Arrays.asList(new Coin(1, 2), new Coin(2, 3), new Coin(3, 4)));
        arena.setSuperCoins(Arrays.asList(new SupCoin(7, 7), new SupCoin(8, 8), new SupCoin(9, 9)));
        arena.setMonsters(Arrays.asList(new Monster(12, 12), new Monster(13, 13), new Monster(14, 14)));
        arena.setGates(Arrays.asList(new Gate(15, 15), new Gate(16, 16)));
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
    @Test
    void Arena_getCoin(){
        Position position = new Position(50,50);
        Assertions.assertNull(arena.getCoin(position));
    }
    @Test
    void Arena_getSuperCoim(){
        Position position = new Position(60,60);
        Assertions.assertNull(arena.getSuperCoin(position));
    }
    @Test
    void Arena_getMonster(){
        Position position = new Position(50,50);
        Assertions.assertNull(arena.getMonster(position));
    }

    @Test
    void Arena_isMonster(){
        Position position = new Position(99,99);
        Position position2 = new Position(12,12);
        Assertions.assertNotEquals(true, arena.isMonster(position));
        Assertions.assertEquals(true, arena.isMonster(position2));
    }
    @Test
    void Arena_isCoin(){
        Position position = new Position(99,99);
        Position position2 = new Position(1,2);
        Assertions.assertNotEquals(true, arena.isCoin(position));
        Assertions.assertEquals(true, arena.isCoin(position2));
    }
    @Test
    void Arena_isSuperCoin(){
        Position position = new Position(99,99);
        Position position2 = new Position(7,7);
        Assertions.assertNotEquals(true, arena.isSuperCoin(position));
        Assertions.assertEquals(true, arena.isSuperCoin(position2));
    }

    @Test
    void Arena_getgates(){
        Assertions.assertNotNull(arena.getGates());
    }
    @Test
    void Arena_getGate(){
        Position position = new Position(50,50);
        Assertions.assertNull(arena.getGate(position));
        Position position1 = new Position(15,15);
        Assertions.assertNotNull(arena.getGate(position1));
    }

    @Test
    void Arena_isGate(){
        Position position = new Position(99,99);
        Position position2 = new Position(15,15);
        Assertions.assertNotEquals(true, arena.isGate(position));
        Assertions.assertEquals(true, arena.isGate(position2));
    }
}
