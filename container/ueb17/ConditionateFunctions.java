package ueb17;

import java.util.function.IntPredicate;

/**
 * Erweitert das Funktionale-Interface MyFunction um zwei default Funktionen.
 *
 * @author Yannick Gross / Tim Mueller
 * @version 22.05.2023
 */
@FunctionalInterface
public interface ConditionateFunctions extends MyFunction{
    /**
     * Gibt einen Lambda Ausdruck zurueck der das uebergebene Praedikat ueberprueft.
     * Stimmt das Praedikat mit dem Wert x so wird der Wert von apply(x) zurueckgegeben, sonst 0.
     *
     * @param predicate IntPredicate
     * @return Lambda Ausdruck
     */
    default ConditionateFunctions conditionateInput(IntPredicate predicate){
        return (x) -> predicate.test(x) ? apply(x) : 0;
    }

    /**
     * Gibt einen Lambda Ausdruck zurueck der das uebgebene Praedikat ueberprueft.
     * Stimmt das Praedikat mit Wert von apply(x) so wird der Wert von apply(x) zurueckgegeben, sonst 0.
     *
     * @param predicate IntPredicate
     * @return Lambda Ausdruck
     */
    default ConditionateFunctions conditionateOutput(IntPredicate predicate){
        return (x) -> predicate.test(apply(x)) ? apply(x) : 0;
    }
}
