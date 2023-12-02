package com.example;

/**
 *
 * @author Ira Dook
 */
public class Peli {

    private Pelaaja p1 = new Pelaaja();
    private Pelaaja p2 = new Pelaaja();
    private int pelatutPelit; // Pelattujen pelien lkm
    private int tasapelit; // Tasapelien lkm
    private boolean peliLoppui = false;

    public Peli(Pelaaja p1, Pelaaja p2) {
        this.p1 = p1;
        this.p2 = p2;
        this.pelatutPelit = 0;
        this.tasapelit = 0;
    }

    public void pelaa() {

        System.out.println("Erä: "
                + (pelatutPelit += 1) + " =====================\n");

        String player1Choice = p1.pelaajanValinta();
        String player2Choice = p2.pelaajanValinta();

        kumpiVoitti(p1, p2, player1Choice, player2Choice);

        System.out.println("Tasapelien lukumäärä: "
                + tasapelit + "\n");

        System.out.println("Pelaaja 1: " + player1Choice
                + "\n\t Pelaaja 1:llä koossa " + p1.getVoitot() + " voittoa.");

        System.out.println("Pelaaja 2: " + player2Choice
                + "\n\t Pelaaja 2:lla koossa " + p2.getVoitot() + " voittoa.");

        if (onkoPeliOhi()) {
            peliLoppui = true;
            System.out.println("KOLME VOITTOA! Peli loppui.");
        }

        System.out.println();
    }

    public void kumpiVoitti(Pelaaja p1, Pelaaja p2, String p1Valinta, String p2Valinta) {
        if (p1Valinta.equals(p2Valinta)) {
            tasapelit++;
            System.out.println("\t Tasapeli \n");
        } else if (p1.onkoVoittaja(p1Valinta, p2Valinta) == true) {
            p1.setVoitot();
            System.out.println("\t Pelaaja 1 voittaa \n");
        } else {
            p2.setVoitot();
            System.out.println("\t Pelaaja 2 voittaa \n");
        }
    }

    public int getTasapelit() {
        return tasapelit;
    }

    public int getPelatutPelit() {
        return pelatutPelit;
    }

    public Pelaaja getP1() {
        return p1;
    }

    public Pelaaja getP2() {
        return p2;
    }

    public boolean onkoPeliOhi() {
        return p1.getVoitot() == 3 || p2.getVoitot() == 3;
    }

    public boolean onkoKäynnissä() {
        return peliLoppui;
    }
}
