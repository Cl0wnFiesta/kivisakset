package com.example;

/**
 * Pääluokka `Main` sisältää sovelluksen aloituspisteen ja pääsykohdan.
 * Tässä luokassa luodaan kaksi pelaajaa (`Pelaaja`-instanssia) ja peli (`Peli`-instanssi),
 * jonka jälkeen peliä pelataan, kunnes jompikumpi pelaajista voittaa kolme kertaa.
 * @see Pelaaja
 * @see Peli
 * @author Ira Dook
 * @author Jonne Borgman
 */
public class Main {

  /**
   * Sovelluksen aloituspiste.
   *
   * @param args Komentoriviparametrit (ei käytössä tässä sovelluksessa)
   */
  public static void main(String[] args) {
    Pelaaja p1 = new Pelaaja();
    Pelaaja p2 = new Pelaaja();
    Peli peli = new Peli(p1, p2);

    while (!peli.onkoPeliOhi()) {
      peli.pelaa();
    }
  }
}
