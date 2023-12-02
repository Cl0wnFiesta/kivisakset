
package com.example;

/**
 *
 * @author Ira Dook
 */
public class Pelaaja {

    private int voitotYhteensä = 0;
    private String[] valinnat = { "kivi", "paperi", "sakset" };

    /**
     * Valitse randomilla kivi, paperi tai sakset
     */
    public String pelaajanValinta() {
        int valinta = (int) (Math.random() * 3);
        return valinnat[valinta];
    }

    public boolean onkoVoittaja(String p1Valinta, String p2Valinta) {
        return (p1Valinta.equals("kivi") && p2Valinta.equals("sakset")) ||
                (p1Valinta.equals("paperi") && p2Valinta.equals("kivi")) ||
                (p1Valinta.equals("sakset") && p2Valinta.equals("paperi"));
    }

    public void setVoitot() {
        voitotYhteensä += 1;
    }

    public int getVoitot() {
        return voitotYhteensä;
    }

    
}
