package com.aor.hero.model;
import com.aor.hero.model.menu.Instructions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InstructionsTest {
    Instructions instructions;
    @BeforeEach
    void setUp() {
        instructions = new Instructions();
    }

    @Test
    void Instructions_getentry(){
        Assertions.assertNotNull(instructions.getEntry(0));
        Assertions.assertEquals("Return", instructions.getEntry(0));
        Assertions.assertNotEquals("Exit", instructions.getEntry(0));
    }

    @Test
    void Instructions_getsize(){
        Assertions.assertNotNull(instructions.getNumberEntries());
        Assertions.assertEquals(1, instructions.getNumberEntries());
        Assertions.assertNotEquals(2, instructions.getNumberEntries());
        Assertions.assertNotEquals(-1, instructions.getNumberEntries());
    }
}
