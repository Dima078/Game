package ru.netology.game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    private Player player = new Player();

    @Test
    void getSetId() {
        player.setId(2);
        int expected = 2;
        int actual = player.getId();
        assertEquals(expected, actual);
    }

    @Test
    void getSetName() {
        player.setName("Dima");
        String expected = "Dima";
        String actual = player.getName();
        assertEquals(expected, actual);
    }

    @Test
    void getSetStrength() {
        player.setStrength(5);
        int expected = 5;
        int actual = player.getStrength();
        assertEquals(expected, actual);
    }
}