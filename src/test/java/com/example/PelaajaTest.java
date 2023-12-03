package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Testaa Pelaaja-luokan toiminnot
 *
 * @author Jonne Borgman
 */

public class PelaajaTest {

  @Test
  public void testPelaaja1Voitti() {
    Pelaaja pelaaja = new Pelaaja();
    assertTrue(pelaaja.onkoVoittaja("kivi", "sakset"));
    assertTrue(pelaaja.onkoVoittaja("paperi", "kivi"));
    assertTrue(pelaaja.onkoVoittaja("sakset", "paperi"));
  }

  @Test
  public void testPelaaja1Havisi() {
    Pelaaja pelaaja = new Pelaaja();
    assertFalse(pelaaja.onkoVoittaja("kivi", "paperi"));
    assertFalse(pelaaja.onkoVoittaja("paperi", "sakset"));
    assertFalse(pelaaja.onkoVoittaja("sakset", "kivi"));
  }

  @Test
  public void testTasaPeli() {
    Pelaaja pelaaja = new Pelaaja();
    assertFalse(pelaaja.onkoVoittaja("kivi", "kivi"));
    assertFalse(pelaaja.onkoVoittaja("paperi", "paperi"));
    assertFalse(pelaaja.onkoVoittaja("sakset", "sakset"));
  }

  @Test
  public void testVoittoLisays() {
    Pelaaja pelaaja = new Pelaaja();
    pelaaja.setVoitot();
    assertEquals(1, pelaaja.getVoitot());
  }

  @Test
  public void testGetVoitot() {
    Pelaaja pelaaja = new Pelaaja();
    pelaaja.setVoitot();
    assertEquals(1, pelaaja.getVoitot());
  }

  @Test
  public void testPelaajanValinta() {
    Pelaaja pelaaja = new Pelaaja();
    String valinta = pelaaja.pelaajanValinta();
    assertTrue(valinta.equals("kivi") || valinta.equals("paperi") || valinta.equals("sakset"));
  }

  @ParameterizedTest
  @ValueSource(ints = { 0, 1, 2 })
  public void testPelaajanValintaVaihtoehdot(int mockValue) {
    Pelaaja pelaaja = Mockito.spy(new Pelaaja());
    Mockito.when(pelaaja.getRandomIndex()).thenReturn(mockValue);

    String valinta = pelaaja.pelaajanValinta();

    assertTrue(valinta.equals("kivi") || valinta.equals("paperi") || valinta.equals("sakset"));
    assertTrue(valinta.equals(pelaaja.getValinnat()[mockValue]));
  }
}
