package ueb17;

import java.util.function.IntPredicate;

@FunctionalInterface
public interface ConditionateFunctions extends MyFunction{
    default ConditionateFunctions conditionateInput(IntPredicate predicate){
        return (x) -> predicate.test(x) ? apply(x) : 0;
    }

    default ConditionateFunctions conditionateOutput(IntPredicate predicate){
        return (x) -> predicate.test(apply(x)) ? apply(x) : 0;
    }
}
