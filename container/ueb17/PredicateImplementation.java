package ueb17;

import java.util.function.IntPredicate;

/**
 * Implementierung der Funktionen even und odd.
 *
 * @author Yannick Gross / Tim Mueller
 * @version 20.05.2023
 */
public abstract class PredicateImplementation {

    /**
     *
     * @return Lambda Ausdruck (IntPredicate) der prueft ob uebergebene Zahl gerade ist.
     */
    public static IntPredicate even(){
        return (x) -> x % 2 == 0;
    }

    /**
     *
     * @return Anonyme Klasse (IntPredicate) die prueft ob uebergebene Zahl ungerade ist.
     */
    public static IntPredicate odd(){
        return new IntPredicate() {
            @Override
            public boolean test(int value) {
                return value % 2 == 1;
            }
        };
    }
}
