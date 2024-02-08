package index;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.parser.terms.IdentifierAtom;
import main.lisp.parser.terms.SExpression;

public class SetqEvaluator implements Evaluator{

	@Override
	public SExpression eval(SExpression expr, Environment environment) {
		expr = expr.getTail();
		return evalHelper(expr, environment);
	}
	
	public static SExpression evalHelper(SExpression expr, Environment environment) {
        SExpression e2 = expr.getTail().getHead();
        SExpression e2Eval = e2.eval(environment);
        environment.assign((IdentifierAtom)expr.getHead(), e2Eval);
        return e2Eval;
	}
}
