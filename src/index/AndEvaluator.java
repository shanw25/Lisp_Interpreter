package index;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.parser.terms.SExpression;
import main.lisp.parser.terms.NilAtom;

public class AndEvaluator implements Evaluator {

    @Override
    public SExpression eval(SExpression expr, Environment environment) {
        expr = expr.getTail();
        return evalHelper(expr, environment, null);
    }

    public static SExpression evalHelper(SExpression expr, Environment environment, SExpression lastEvaluated) {
        if (expr instanceof NilAtom) {
            return lastEvaluated;
        }
        SExpression current = expr.getHead().eval(environment);
        if (current.isNIL()) {
            return current;
        } else {
            return evalHelper(expr.getTail(), environment, current);
        }
    }
}
