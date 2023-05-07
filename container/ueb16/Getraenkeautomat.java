package ueb16;

import java.util.ArrayList;

/**
 * Getraenkeautomat-Klasse zum lagern von Getraenken.
 *
 * @author Yannick Gross / Tim Mueller
 * @version 04.05.2023 / 23:00Uhr
 *
 * @param <T> Getraenke Typ der im Automat liegen darf.
 */
public class Getraenkeautomat <T extends Getraenk> {
    private ArrayList<Flasche<? extends T>> flaschenlager;
    private int kapazitaet;

    /**
     * Erstellt einen Standard-Automaten mit einer Kapazitaet von 30 Flaschen.
     */
    public Getraenkeautomat(){
        flaschenlager = new ArrayList<>();
        kapazitaet = 30;
    }

    /**
     * Erstellt einen Automaten mit gewuenschter Kapazitaet.
     *
     * @param kapazitaet
     */
    public Getraenkeautomat(int kapazitaet){
        flaschenlager = new ArrayList<>();
        setKapazitaet(kapazitaet);
    }
    /**
     * Nimmt nur eine Flasche des passenden Types entgegen.
     * Prueft ob Flasche voll ist und ob Kapazitaet noch nicht ausgeschoepft ist.
     *
     * @param flasche Einzulagernde Flasche
     */
    public void flascheEinlegen(Flasche<? extends T > flasche){
        GetraenkeautomatException.capacityReached(flaschenlager.size(), kapazitaet);
        GetraenkeautomatException.flascheValidierung(flasche);
        
        flaschenlager.add(flasche);
        kapazitaet++;
    }

    /**
     * Nach FIFO Prinzip wird die Flasche an Index 0 zurueckgegeben.
     *
     * @return Flasch an Index 0
     */
    public Flasche<?> flascheAusgeben(){
        GetraenkeautomatException.empty(flaschenlager.size());

        return flaschenlager.remove(0);
    }

    public int getKapazitaet(){
        return kapazitaet;
    }

    public void setKapazitaet(int kapazitaet){
        GetraenkeautomatException.validateKapazitaet(kapazitaet);

        this.kapazitaet = kapazitaet;
    }

    /**
     * Bereitet die Kapazitaet und den Inhalt als String auf.
     *
     * @return String im Format: Automaten Inhalt\nKapazitaet: X\nInhalt1\nInhalt2\n...
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Automaten Inhalt:\n");
        sb.append("Kapazitaet: " + kapazitaet + "\n");

        if(flaschenlager.size() == 0){
            return sb.append("--Leer--").toString();
        }

        for(Flasche flasche : flaschenlager){
            sb.append(flasche + "\n");
        }

        return sb.toString();
    }
}
