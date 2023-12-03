package com.example;

/**
 * Luokka `Peli` kuvaa peliä kahden pelaajan (`Pelaaja`-instanssien) välillä.
 * Se hallinnoi pelin kulkua, seuraa pelattujen pelien, tasapelien ja voittajan
 * määrää.
 *
 * Peli jatkuu, kunnes toinen pelaajista saavuttaa kolme voittoa.
 *
 * @author Ira Dook
 * @author Jonne Borgman
 * @see Main
 * @see Pelaaja
 */
public class Peli {

    private Pelaaja p1 = new Pelaaja();
    private Pelaaja p2 = new Pelaaja();
    private int pelatutPelit; // Pelattujen pelien määrä
    private int tasapelit; // Tasapelien määrä
    private boolean peliLoppui = false; // Kertoo, onko peli päättynyt

    /**
     * Luo uuden pelin annetuilla pelaajilla.
     *
     * @param p1 Pelaaja 1
     * @param p2 Pelaaja 2
     */
    public Peli(Pelaaja p1, Pelaaja p2) {
        this.p1 = p1;
        this.p2 = p2;
        this.pelatutPelit = 0;
        this.tasapelit = 0;
    }

    /**
     * Pelaa yhden kierroksen peliä, määrittää kunkin pelaajan valinnan,
     * arvioi voittajan ja päivittää pelin tilastoja.
     */
    public void pelaa() {

        System.out.println("Erä: "
                + (pelatutPelit += 1) + " =====================\n");

        String pelaaja1Valinta = p1.pelaajanValinta();
        String pelaaja2Valinta = p2.pelaajanValinta();

        kumpiVoitti(p1, p2, pelaaja1Valinta, pelaaja2Valinta);

        System.out.println("Tasapelien määrä: "
                + tasapelit + "\n");

        System.out.println("Pelaaja 1: " + pelaaja1Valinta
                + "\n\t Pelaaja 1:llä koossa " + p1.getVoitot() + " voittoa.");

        System.out.println("Pelaaja 2: " + pelaaja2Valinta
                + "\n\t Pelaaja 2:llä koossa " + p2.getVoitot() + " voittoa.");

        System.out.println();
    }

    /**
     * Määrittää kierroksen voittajan pelaajien valintojen perusteella.
     *
     * @param p1        Pelaaja 1
     * @param p2        Pelaaja 2
     * @param p1Valinta Pelaaja 1:n valinta
     * @param p2Valinta Pelaaja 2:n valinta
     */
    public void kumpiVoitti(Pelaaja p1, Pelaaja p2, String p1Valinta, String p2Valinta) {
        if (p1Valinta.equals(p2Valinta)) {
            tasapelit++;
            System.out.println("\t Tasapeli \n");
        } else if (p1.onkoVoittaja(p1Valinta, p2Valinta)) {
            p1.setVoitot();
            System.out.println("\t Pelaaja 1 voittaa \n");
        } else {
            p2.setVoitot();
            System.out.println("\t Pelaaja 2 voittaa \n");
        }
    }

    /**
     * Palauttaa tasapelien määrän.
     *
     * @return Tasapelien määrä
     */
    public int getTasapelit() {
        return tasapelit;
    }

    /**
     * Palauttaa pelattujen pelien määrän.
     *
     * @return Pelattujen pelien määrä
     */
    public int getPelatutPelit() {
        return pelatutPelit;
    }

    /**
     * Palauttaa Pelaajan 1.
     *
     * @return Pelaaja 1
     */
    public Pelaaja getP1() {
        return p1;
    }

    /**
     * Palauttaa Pelaajan 2.
     *
     * @return Pelaaja 2
     */
    public Pelaaja getP2() {
        return p2;
    }

    /**
     * Tarkistaa, onko peli päättynyt.
     *
     * @return True, jos peli on päättynyt, muuten false
     */
    public boolean onkoPeliOhi() {
        if (p1.getVoitot() == 3 || p2.getVoitot() == 3) {
            System.out.println("KOLME VOITTOA! Peli loppui. Voittaja: " + (p1.getVoitot() == 3 ? "Pelaaja 1" : "Pelaaja 2"));
            return true;
        }
        return false;
    }
}
