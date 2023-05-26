package ueb18;

import java.util.ArrayList;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Klasse zum Lagern und Verwalten von Artikel Objekten.
 *
 * @author Tim Mueller / Yannick Gross
 * @version 26.05.2023 / 18:00
 */

public class Lager{
    //Error-Messages
    private static final String ERROR_FILTERKRITERIEN = "Es wurden keine adaequaten Filterkriterien gefunden";

    //Konstanten
    private static final int MAX_LAGER = 10;

    //Attribute
    private Artikel[] lagerFeld;
    private final int lagerGroesse;
    private int lagerBestand;


    /**
     * Konstruktor fuer Lager, der Array mit uebergebener Groesse initialisiert
     * und <code>lagerGroesse</code> sowie <code>lagerBestand</code> initialisiert.
     *
     * @param lagerGroesse Der Wert fuer die laenge des Arrays und fue <code>lagerGroesse</code>
     */
    public Lager(int lagerGroesse){
        FehlerPruefung.fehlerPruefung(  ErrorMessages.ERROR_LAGER_LAGERGROESSE_MUSS_GROESSER,
                lagerGroesse);

        this.lagerFeld = new Artikel[lagerGroesse];
        this.lagerGroesse = lagerGroesse;
        this.lagerBestand = 0;
    }

    /**
     * Standardkonstruktor, der den Ersten mit dem Uebergabeparameter 10 aufruft.
     */
    public Lager(){
        this(MAX_LAGER);
    }

    /**
     * Speichert die Referenz eines Artikels in das Lager Array ein.
     *
     * @param artikel Der Artikel der in das Array gespeichert wird.
     *
     * @throws IllegalArgumentException Wenn kein Objekt uebergeben wurde.
     * @throws IllegalArgumentException Wenn Array bereits voll ist.
     * @throws IllegalArgumentException Wenn Artikelnummer bereits vergeben ist.
     */
    public void legeAnArtikel(Artikel artikel){
        FehlerPruefung.fehlerPruefung(  ErrorMessages.ERROR_LAGER_KEIN_OBJEKT,
                artikel);
        FehlerPruefung.fehlerPruefung(  ErrorMessages.ERROR_LAGER_LAGER_VOLL,
                lagerBestand, lagerGroesse);
        FehlerPruefung.fehlerPruefung(  ErrorMessages.ERROR_LAGER_ARTIKEL_EXISTIERT,
                istArtikelGelagert(artikel));

        lagerFeld[lagerBestand] = artikel;
        lagerBestand++;

    }

    /**
     * Loescht die Referenz eines Artikels aus dem Array.
     *
     * @param artikelNr Die Artikelnummer des zu loeschenden Artikels.
     *
     * @throws IllegalArgumentException Wenn zu Artikelnummer gehoerender Artikel
     * in Array gefunden wurde.
     */
    public void entferneArtikel(int artikelNr){
        int index = getIndexArtikel(artikelNr);

        lagerFeld[index] = null;
        lagerFeld[index] = lagerFeld[lagerBestand - 1];
        lagerFeld[lagerBestand - 1] = null;
        lagerBestand--;
    }

    /**
     * Ruft die bucheZugang Methode auf einen Artikel aus dem Lager auf.
     *
     * @param artikelNr Artikelnummer des Artikels auf den gebucht werden soll.
     * @param zugang Menge die dazugebucht werden soll.
     */
    public void bucheZugang(int artikelNr, int zugang){
        int index = getIndexArtikel(artikelNr);

        getArtikel(index).bucheZugang(zugang);
    }

    /**
     * Ruft die bucheAbgang Methode auf einen Artikel aus dem Lager auf.
     *
     * @param artikelNr Artikelnummer des Artikels auf den gebucht werden soll.
     * @param abgang Menge die abgebucht werden soll.
     */
    public void bucheAbgang(int artikelNr, int abgang){
        int index = getIndexArtikel(artikelNr);

        getArtikel(index).bucheAbgang(abgang);
    }

    /**
     * Aendert den Preis eines Artikels aus dem Lager um einen Prozentsatz.
     *
     * @param artikelNr Artikelnummer des Artikels, bei dem der Preis geandert wird.
     * @param prozent Der Prozentsatz um den der Preis geeandert wird.
     */
    public void aenderePreisEinesArtikels(int artikelNr, double prozent){
        int index = getIndexArtikel(artikelNr);
        Artikel tmp = getArtikel(index);

        tmp.aenderePreis(prozent);
    }

    /**
     * Aendert den Preis aller Artikel aus dem Lager um einen Prozentsatz.
     *
     * @param prozent Der Prozentsatz um den der Preis geeandert wird.
     */
    public void aenderePreisAllerArtikel(double prozent){
        for(Artikel tmp: lagerFeld){
            if(tmp != null){
                tmp.aenderePreis(prozent);
            }
        }
    }

    /**
     * Gibt den Bestand des Lager in einem formatiertem String zurueck.
     * Enthaelt Zeilenweise:
     * artNr - getBeschreibung - preis - bestand - preis * bestand
     *
     * @return formatierte Ausgabe von Bestand
     */
    public String ausgebenBestandsListe(){
        double gesamtPreis = 0.0;
        double artikelPreis;
        int artikelNr;
        int artikelBestand;
        StringBuilder artikelBeschreibung = new StringBuilder("");
        StringBuilder ausgabe = new StringBuilder();

        ausgabe.append("-----------------------------------------------------------------------------\n");
        ausgabe.append(String.format("|%-5s %-40s %8s %-7s %9s  |\n", "ArtNr", "Beschreibung", "Preis",
                "Bestand", "Gesamt"));
        ausgabe = ausgabe.append("|---------------------------------------------------------------------------|\n");
        for(Artikel artikel: lagerFeld){
            if(artikel != null){
                artikelPreis = artikel.getPreis();
                artikelNr = artikel.getArtikelNr();
                artikelBestand = artikel.getBestand();
                artikelBeschreibung.delete(0, artikelBeschreibung.length());
                artikelBeschreibung.append(artikel.getBeschreibung());

                ausgabe = ausgabe.append(String.format("|%-5d %-40.40s %8.2f %-7.7s %9.2f  |\n",
                        artikelNr,
                        artikelBeschreibung.toString(),
                        artikelPreis,
                        String.valueOf(artikelBestand),
                        artikelPreis * artikelBestand));

                gesamtPreis += artikelPreis * artikelBestand;
            }
        }
        ausgabe = ausgabe.append("|---------------------------------------------------------------------------|\n");
        ausgabe = ausgabe.append(String.format("|%-10s%62.2f  |\n","Gesamtwert:",gesamtPreis));
        ausgabe = ausgabe.append("-----------------------------------------------------------------------------\n");

        return ausgabe.toString();
    }

    /**
     * Gibt einen Artikel an einem uebergebenen Index aus dem Feld zurueck.
     *
     * @param index Stelle im Array die zurueckgegeben werden soll.
     *
     * @return Gewuenschter Artikel.
     *
     * @throws IllegalArgumentException Wenn Index ausserhalb des Bereichs vom Array ist.
     */
    public Artikel getArtikel(int index){
        if(index < 0 || index > lagerGroesse - 1){
            throw new IllegalArgumentException(ErrorMessages.ERROR_LAGER_INDEX_FALSCH + String.valueOf(lagerGroesse - 1));
        }

        return lagerFeld[index];
    }

    public int getLagerBestand(){
        return lagerBestand;
    }

    public int getLagerGroesse(){
        return lagerGroesse;
    }

    @Override
    public String toString(){
        String lager = ";\nLagerFeld:\n";
        for(Artikel tmp: lagerFeld){
            if(tmp != null){
                lager += "Klasse: " + tmp.getClass().getSimpleName() + " : " + tmp + "\n";
            }
        }

        return "Lagergroesse: " + String.valueOf(lagerGroesse) + "; Lagerbestand: "
                + String.valueOf(lagerBestand) + lager;
    }

    /**
     * Prueft ob Artikel im Lager ist.
     *
     * @param artikel Artikel nach dem im Array gesucht wird.
     *
     * @return true wenn Artikel gefunden, false wenn Artikel nicht gefunden.
     */
    private boolean istArtikelGelagert(Artikel artikel){
        for(int i = 0; i < lagerBestand; i++){
            if(lagerFeld[i].getArtikelNr() == artikel.getArtikelNr()){
                return true;
            }
            if(lagerFeld[i].equals(artikel)){
                return true;
            }
        }

        return false;
    }

    /**
     * Sucht an welchem Index ein Artikel steht.
     *
     * @param artikelNr Artikelnummer des Artikels der gesucht werden soll.
     *
     * @return Index des Artikels, wenn er gefunden wurde.
     *
     * @throws IllegalArgumentException Wenn Artikel nicht gefunden wurde.
     * Es wird kein Index zurueckgegeben.
     */
    public int getIndexArtikel(int artikelNr){
        int index;
        for(int i = 0; i < lagerBestand; i++){
            if(lagerFeld[i].getArtikelNr() == artikelNr){
                index = i;
                return index;
            }
        }

        throw new IllegalArgumentException(ErrorMessages.ERROR_LAGER_ARTIKEL_NICHT_GEFUNDEN.getMessage());
    }

    /**
     * Sortiert Lagerfeld mit uebergebenem Sortierkriterium als Lambda Ausdruck
     *
     * @param sortierKriterium Sortierkriterium auf das geprueft wird.
     *
     * @return Das sortierte Lager wird zurueck gegeben.
     */
    public Artikel[] getSorted(BiPredicate<Artikel, Artikel> sortierKriterium){
        int sortiertGroesse = getLagerBestand();
        Artikel[] sortiertesLager = lagerFeld.clone();

        for(int i = 0; i < sortiertGroesse; i++){
            for(int j = 0; j < sortiertGroesse - i; j++){

                if(sortierKriterium.test(sortiertesLager[j], sortiertesLager[j+1])){
                    Artikel tempo = sortiertesLager[j];
                    sortiertesLager[j] = sortiertesLager[j+1];
                    sortiertesLager[j+1] = tempo;
                }
            }
        }

        return sortiertesLager;
    }

    /**
     * Wendet eine Operation auf alle Artikel im Array an.
     *
     * @param operation Operation die auf alle Artikel im Lager angewendet werden soll.
     */
    public void applyToArticles(Consumer<Artikel> operation){
        for(int i = 0; i < getLagerBestand(); i++){
            operation.accept(lagerFeld[i]);
        }
    }

    /**
     * Wendet einen Filter auf ein Array an und gibt das gefilterte Array zurueck
     *
     * @param filterKriterium Filterkriterium
     * @param array Array das gefiltert wird
     * @return Gefiltertes Array
     */
    public Artikel[] filterAnwendung(Predicate<Artikel> filterKriterium, Artikel[] array){
        ArrayList<Artikel> filteredArrayList = new ArrayList<>();

        for(int i = 0; i < array.length; i++){
            if(array[i] == null){
                continue;
            }
            if(filterKriterium.test(array[i])){
                filteredArrayList.add(array[i]);
            }
        }

        return filteredArrayList.toArray(new Artikel[0]);
    }

    /**
     * Wendet ein Filterkriterium an und gibt die Artikel zurueck, die dieses erfuellen.
     *
     * @param filterKriterium Kriterium nach dem gefiltert wird.
     *
     * @return Array mit den Artikeln die den Filter erfuellen.
     */
    public Artikel[] filter(Predicate<Artikel> filterKriterium){
        ArrayList<Artikel> filteredArray = new ArrayList<>();

        return filterAnwendung(filterKriterium, lagerFeld);
    }

    /**
     * Wendet eine Operation nur auf die Kriterium erfuellende Artikel an.
     *
     * @param filterKriterium Kriterium nach dem die Artikel ausgewaehlt werden
     * @param operation Operation die auf Artikel ausgefuehrt wird
     */
    public void applyToSomeArticles(Predicate<Artikel> filterKriterium, Consumer<Artikel> operation){
        Artikel[] gefiltertesLager = filter(filterKriterium);
        for(int i = 0; i < gefiltertesLager.length; i++){
            operation.accept(gefiltertesLager[i]);
        }
    }

    /**
     * Gibt sortiert die gefilterten Artikel zurueck.
     *
     * @param filterKriterium Kriterium nach dem die Artikel ausgewaehlt werden
     * @param sortierKriterium Kriterium nach dem die Artikel sortiert werden
     *
     * @return Sortiertes Array mit den gewuenschten Artikeln
     */
    public Artikel[] getArticles(Predicate<Artikel> filterKriterium,BiPredicate <Artikel, Artikel> sortierKriterium){
        Artikel[] sortiertesLager = getSorted(sortierKriterium);

        return filterAnwendung(filterKriterium, sortiertesLager);

    }

    /**
     * Wendet eine Kette an Filtern auf das Lager an und gibt die passenden Artikel zurueck.
     *
     * @param filterKriterien Liste an Filtern
     *
     * @return Gefiltertes Lager
     */
    public Artikel[] filterAll(Predicate<Artikel>... filterKriterien) {

        Predicate<Artikel> alleKriterien = filterKriterien[0];

        for (Predicate<Artikel> kriterium: filterKriterien) {
            alleKriterien = alleKriterien.and(kriterium);
        }

        return filterAnwendung(alleKriterien, lagerFeld);
    }
}
