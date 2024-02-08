package index;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.parser.terms.SExpression;

public class OrEvaluator implements Evaluator {

	@Override
	public SExpression eval(SExpression expr, Environment environment) {
		expr = expr.getTail();
		return evalHelper(expr, environment);
	}

	public static SExpression evalHelper(SExpression expr, Environment environment) {
		if(expr.isAtom()) {
			if(expr.isNIL()) {
				return expr;
			}else {
				return expr;
			}
		}
		if(expr.getHead().eval(environment).isNIL()) {
			return evalHelper(expr.getTail(), environment);
		}else {
			return expr.getHead().eval(environment);
		}		
	}

}