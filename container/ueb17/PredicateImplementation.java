package ueb17;

import java.util.function.IntPredicate;

public abstract class PredicateImplementation {

    public static IntPredicate even(){
        return (x) -> x % 2 == 0;
    }

    public static IntPredicate odd(){
        return new IntPredicate() {
            @Override
            public boolean test(int value) {
                return value % 2 == 1;
            }
        };
    }
}
