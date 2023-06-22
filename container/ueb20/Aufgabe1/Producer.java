package ueb20.Aufgabe1;

import java.util.Random;

/**
 * Lediglich dazu da um pseudozufaellige Zahlen bis zu einem maximalen Bound zurueckzugeben.
 *
 * @author Yannick Gross / Tim Mueller
 * @version 22.06.23 / 12:00Uhr
 */
public class Producer {
    private static final int MAX_PRODUCER_VALUE = 1001;

    private final Random rand;

    public Producer(){
        this.rand = new Random();
    }

    /**
     *
     * @return pseudo zufaellige Zahl bis MAX_PRODUCER_VALUE - 1
     */
    public int produce(){
        return rand.nextInt(MAX_PRODUCER_VALUE);
    }
}
