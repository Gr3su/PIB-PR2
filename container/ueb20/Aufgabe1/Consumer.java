package ueb20.Aufgabe1;

import com.sun.source.util.Trees;

import java.util.*;

/**
 * Dient zur Verarbeitung der pseudo zufaellig generierten Zahlen.
 *
 * @author Tim Mueller / Yannick Gross
 * @version 22.06.23 / 12:00Uhr
 */
public class Consumer {
    private Map<Integer, LinkedList<Long>> checkSumMemory;
    private Map<Integer, Integer> occurenceCounter;

    public Consumer() {
        checkSumMemory = new HashMap<>();
        occurenceCounter = new HashMap<>();
    }

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
    }

    public int numberOfDifferentResults(){
        return checkSumMemory.size();
    }

    public int numberOfOccurences(int value){
        return occurenceCounter.get(value);
    }

    public TreeSet<Integer> getCrossTotalsAscending(){
        return new TreeSet<>(checkSumMemory.keySet());
    }

    public TreeSet<Integer> getCrosstotalsDescending(){
        TreeSet<Integer> sorted = new TreeSet<>(Collections.reverseOrder());
        sorted.addAll(checkSumMemory.keySet());
        return sorted;
    }

    public LinkedList<Long> getTimestampsForResult(int value){
        return checkSumMemory.get(value);
    }

}
