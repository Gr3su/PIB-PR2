package ueb17;

import static ueb17.ApplyAndPrint.applyAndPrint;
public abstract class UsingApplyAndPrint {
    private static final int MIN_TEST_VALUE = 1;
    private static final int MAX_TEST_VALUE = 10;

    public static void main(String[] args) {
        MyFunction squareIfEven = (x) -> PredicateImplementation.even().test(x) ? x * x : -1;
        MyFunction facIfFacEven = (x) -> PredicateImplementation.even().test(new Fac().apply(x)) ? new Fac().apply(x) : 0;

        applyAndPrint(MIN_TEST_VALUE, MAX_TEST_VALUE, squareIfEven);
        applyAndPrint(MIN_TEST_VALUE, MAX_TEST_VALUE, facIfFacEven);
    }
}
