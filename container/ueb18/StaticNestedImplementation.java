package ueb18;

import static ueb18.ApplyAndPrint.applyAndPrint;

/**
 * Implementierung der Funktionen Quadrieren, Fakultaet, Potenz und Fibonacci Folge
 * als Static nested classes.
 *
 * @author Yannick Gross / Tim Mueller
 * @version 20.05.2023
 */
public abstract class StaticNestedImplementation {
    private static final String ERROR_NOT_NAT = "x muss eine natuerliche Zahl sein.";
    private static final int MIN_TEST_VALUE = 1;
    private static final int MAX_TEST_VALUE = 10;
/*
    public static class Quadrieren implements MyFunction {
        @Override
        public int apply(int x){
            if(x < 0){
                throw new IllegalArgumentException(ERROR_NOT_NAT);
            }
            return x * x;
        }
    }
*/
    public static class Fakultaet implements MyFunction{
        @Override
        public int apply(int x){
            if(x < 0){
                throw new IllegalArgumentException(ERROR_NOT_NAT);
            }
            if (x == 0) {
                return 1;
            }
            return apply(x - 1) * x;
        }
    }
/*
    public static class Potenz implements MyFunction{
        @Override
        public int apply(int x){
            if(x < 0){
                throw new IllegalArgumentException(ERROR_NOT_NAT);
            }
            int sum = x;
            for(int i = 0; i < x; i++){
                sum *= x;
            }
            return sum;

        }
    }

    public static class Fibonacci implements MyFunction{
        @Override
        public int apply(int x){
            if(x < 0){
                throw new IllegalArgumentException(ERROR_NOT_NAT);
            }
            if(x <= 2){
                return 1;
            }
            return apply(x - 1) + apply(x - 2);
        }
    }
*/
}
