package ru.netology.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private Game game = new Game();
    private Player player1 = new Player(1, "player1", 2);
    private Player player2 = new Player(2, "player2", 3);
    private Player player3 = new Player(3, "player3", 2);

    @Test
    void register() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        Player[] expected = {player1, player2, player3};
        Player[] actual = game.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void registerSamePlayer() {
        game.register(player1);
        game.register(player1);
        game.register(player3);
        Player[] expected = {player1, player3};
        Player[] actaul = game.findAll();
        assertArrayEquals(expected, actaul);
    }

    @Test
    void roundRegisterSameStrength() {
        game.register(player2);
        game.register(player3);
        int expected = 1;
        int actaul = game.round(player2, player3);
        assertEquals(expected, actaul);
    }

    @Test
    void roundRegisterFirstStronger() {
        game.register(player1);
        game.register(player2);
        int expected = 2;
        int actaul = game.round(player1, player2);
        assertEquals(expected, actaul);
    }

    @Test
    void roundRegisterSecondStronger() {
        game.register(player1);
        game.register(player3);
        int expected = 0;
        int actaul = game.round(player1, player3);
        assertEquals(expected, actaul);
    }

    @Test
    void roundFirstNotRegister() {
        game.register(player3);
        Assertions.assertThrows(NotFoundException.class, () -> game.round(player1, player3));
    }

    @Test
    void roundSecondNotRegister() {
        game.register(player1);
        Assertions.assertThrows(NotFoundException.class, () -> game.round(player1, player2));
    }
}