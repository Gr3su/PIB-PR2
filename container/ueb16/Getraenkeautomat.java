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
    private ArrayList<Flasche<?>> flaschenlager;
    private int kapazitaet;

    public Getraenkeautomat(){
        flaschenlager = new ArrayList<>();
        kapazitaet = 30;
    }

    public Getraenkeautomat(int kapazitaet){
        flaschenlager = new ArrayList<>();
        setKapazitaet(kapazitaet);
    }

    public void flascheEinlegen(Flasche<? extends T> flasche){
        GetraenkeautomatException.capacityReached(flaschenlager.size(), kapazitaet);
        GetraenkeautomatException.flascheVoll(flasche);

        flaschenlager.add(flasche);
        kapazitaet++;
    }

    public Flasche<?> flascheAusgeben(){
        GetraenkeautomatException.empty(flaschenlager.size());

        return flaschenlager.remove(0);
    }

    public void setKapazitaet(int kapazitaet){
        GetraenkeautomatException.validateKapazitaet(kapazitaet);

        this.kapazitaet = kapazitaet;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Automaten Inhalt:\n");
        if(flaschenlager.size() == 0){
            return sb.append("--Leer--").toString();
        }

        for(Flasche flasche : flaschenlager){
            sb.append(flasche + "\n");
        }

        return sb.toString();
    }
}
