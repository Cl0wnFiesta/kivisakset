package com.example;

import java.util.Random;

/**
 * Luokka `Pelaaja` kuvaa yhtä pelaajaa kivipaperisakset-pelissä.
 * Pelaajalla on voittojen laskuri, valintamahdollisuudet ja tarkistus
 * voittiko hän kierroksen.
 *
 * @author Ira Dook
 * @author Jonne Borgman
 */
public class Pelaaja {

    private int voitotYhteensä = 0;
    private String[] valinnat = { "kivi", "paperi", "sakset" };

    /**
     * Arpoo ja palauttaa pelaajan satunnaisen valinnan kivestä, paperista tai
     * saksista.
     *
     * @return Pelaajan valinta
     */
    public String pelaajanValinta() {
        int valinta = getRandomIndex();
        return valinnat[valinta];
    }

    /**
     * Palauttaa satunnaisen indeksin valintojen taulukosta.
     *
     * @return Satunnainen indeksi
     */
    public int getRandomIndex() {
        return new Random().nextInt(valinnat.length);
    }

    /**
     * Tarkistaa, voittaako pelaaja annetun vastapelaajan valinnan.
     *
     * @param p1Valinta Pelaajan oma valinta
     * @param p2Valinta Vastapelaajan valinta
     * @return True, jos pelaaja voittaa, muuten false
     */
    public boolean onkoVoittaja(String p1Valinta, String p2Valinta) {
        return (p1Valinta.equals("kivi") && p2Valinta.equals("sakset")) ||
                (p1Valinta.equals("paperi") && p2Valinta.equals("kivi")) ||
                (p1Valinta.equals("sakset") && p2Valinta.equals("paperi"));
    }

    /**
     * Lisää yhden voiton pelaajan voittojen lukumäärään.
     */
    public void setVoitot() {
        voitotYhteensä += 1;
    }

    /**
     * Palauttaa pelaajan voittojen kokonaismäärän.
     *
     * @return Voittojen kokonaismäärä
     */
    public int getVoitot() {
        return voitotYhteensä;
    }

    public String[] getValinnat() {
        return valinnat;
    }

}
