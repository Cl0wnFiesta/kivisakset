package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;

public class PeliTest {
    Peli game;
    Pelaaja player1;
    Pelaaja player2;

    @BeforeEach
    public void setUp() {
        player1 = new Pelaaja();
        player2 = new Pelaaja();
        game = new Peli(player1, player2);
    }

    @Test
    @Order(1)
    void testaaAlustus() {
        assertEquals(0, game.getPelatutPelit());
        assertEquals(0, game.getTasapelit());
        assertEquals(player1, game.getP1());
        assertEquals(player2, game.getP2());
    }

    @ParameterizedTest(name = "{index} => player1Choice={0}, player2Choice={1}, expectedPlayer1Wins={2}, expectedPlayer2Wins={3}")
    @CsvSource({
            "kivi, paperi, 0, 1",
            "paperi, kivi, 1, 0",
            "kivi, sakset, 1, 0",
            "sakset, kivi, 0, 1",
            "sakset, paperi, 1, 0",
            "paperi, sakset, 0, 1",
            "kivi, kivi, 0, 0",
            "paperi, paperi , 0, 0",
            "sakset, sakset , 0, 0"
    })
    @Order(2)
    void testaaVoittaja(String player1Choice, String player2Choice, int expectedPlayer1Wins,
            int expectedPlayer2Wins) {

        Peli game = new Peli(player1, player2);

        game.kumpiVoitti(player1, player2, player1Choice, player2Choice);

        assertEquals(player1.getVoitot(), expectedPlayer1Wins);
        assertEquals(player2.getVoitot(), expectedPlayer2Wins);
    }

    @ParameterizedTest(name = "{index} => player1Choice={0}, player2Choice={1}")
    @CsvSource({
            "kivi, kivi",
            "paperi, paperi ",
            "sakset, sakset "
    })
    @Order(3)
    void testaaTasapelit(String player1Choice, String player2Choice) {

        game.kumpiVoitti(player1, player2, player1Choice, player2Choice);
        assertEquals(1, game.getTasapelit());
    }

    @Order(4)
    @Test
    public void testPeli() {
        Peli spy = Mockito.spy(game);

        doNothing().when(spy).kumpiVoitti(player1, player2, player1.pelaajanValinta(), player2.pelaajanValinta());

        spy.pelaa();

        verify(spy, times(1)).pelaa();
    }

    @Order(5)
    @Test
    public void testPeliLoppui() {
        while (!game.onkoKäynnissä()) {
            game.pelaa();
        }
        assertTrue(game.onkoKäynnissä());
    }

}
