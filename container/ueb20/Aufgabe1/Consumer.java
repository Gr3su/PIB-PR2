package ueb20.Aufgabe1;

import java.util.*;

/**
 * Dient zur Verarbeitung der pseudo zufaellig generierten Zahlen.
 *
 * @author Tim Mueller / Yannick Gross
 * @version 22.06.23 / 12:00Uhr
 */
public class Consumer {
    //Error-Messages
    private static final String ERROR_KEY_INVALID = "Der uebergebene Key existiert nicht in der Map";

    //Attribute
    private Map<Integer, LinkedList<Long>> checkSumMemory;
    private Map<Integer, Integer> occurenceCounter;
    private Map<Integer, Integer> startSumMemory;

    public Consumer() {
        checkSumMemory   = new HashMap<>();
        occurenceCounter = new HashMap<>();
        startSumMemory   = new HashMap<>();
    }

    /**
     * Berechnet die Quersumme, speichert die Zeiten der Berechnungen in einer LinkedList und mapt sie mit der Quersumme
     * als Key. Zusätzlich wird die Quersumme mit der haefigkeit der Quersumme gemapt und welcher Wert zu welcher
     * Quersumme gefuehrt hat.
     *
     * @param value Wert von der die Quersumme berechnet werden soll
     */
    public void consume(int value){
        int checkSum = 0;
        int copyOfValue = value;
        long startTime;
        LinkedList<Long> processTimes = new LinkedList<>();

        while(copyOfValue != 0) {

            startTime = System.nanoTime();
            checkSum += copyOfValue % 10;
            copyOfValue /= 10;
            processTimes.addFirst(System.nanoTime() - startTime);
        }

        checkSumMemory.put(checkSum, processTimes);

        if(occurenceCounter.containsKey(checkSum)){
            occurenceCounter.replace(checkSum, occurenceCounter.get(checkSum) + 1);
        }
        else{
            occurenceCounter.put(checkSum, 1);
        }
        startSumMemory.put(value,checkSum);
    }

    /**
     *
     * @return Anzahl der verschiedenen Quersummen
     */
    public int numberOfDifferentResults(){
        return checkSumMemory.size();
    }

    /**
     * Gibt die Haeufigkeit der Berechnung einer bestimmten Quersumme zurueck.
     *
     * @param value Quersumme von der die Haeufigkeit bestimmt werden soll
     * @return Haeufigkeit des Auftretens
     */
    public int numberOfOccurences(int value){
        if (!occurenceCounter.containsKey(value)){
            return 0;
        }
        return occurenceCounter.get(value);
    }

    /**
     *
     * @return TreeSet das aufsteigend geordnet die Quersummen beinhaltet
     */
    public TreeSet<Integer> getCrossTotalsAscending(){
        return new TreeSet<>(checkSumMemory.keySet());
    }

    /**
     *
     * @return TreeSet das absteigend geordnet die Quersummen beinhaltet
     */
    public TreeSet<Integer> getCrosstotalsDescending(){
        TreeSet<Integer> sorted = new TreeSet<>(Collections.reverseOrder());
        sorted.addAll(checkSumMemory.keySet());
        return sorted;
    }

    /**
     * Gibt die LinkedList der TimeStamps einer Quersumme zurueck.
     *
     * @param value Quersumme von der die TimeStamps zurueck gegeben werden sollen
     * @return LinkedList der TimeStamps
     */
    public LinkedList<Long> getTimestampsForResult(int value){
        if(!checkSumMemory.containsKey(value)){
            throw new IllegalArgumentException(ERROR_KEY_INVALID);
        }
        return checkSumMemory.get(value);
    }

    /**
     * Gibt die berechnete Quersumme zu einem uebergebenem Startwert zurueck.
     *
     * @param value Startwert zu der berechneten Quersumme
     * @return Quersumme zum berechneten Startwert
     */
    public int getQuersumme(int value){
        if(!startSumMemory.containsKey(value)) {
            throw new IllegalArgumentException(ERROR_KEY_INVALID);
        }
        return startSumMemory.get(value);
    }

}