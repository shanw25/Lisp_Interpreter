package index;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.parser.terms.NilAtom;
import main.lisp.parser.terms.SExpression;

public class CondEvaluator implements Evaluator{

	@Override
	public SExpression eval(SExpression expr, Environment environment) {
		expr = expr.getTail();
		return evalHelper(expr, environment);
	}
	
	public static SExpression evalHelper(SExpression expr, Environment environment) {
		if(expr.isNIL()) {
			return new NilAtom();
		}
		if(!expr.getHead().getHead().eval(environment).isNIL()) {
			if(expr.getHead().getTail() instanceof NilAtom) {
				return expr.getHead().getHead().eval(environment);
			}
			if(expr.getHead().getTail().isAtom()) {
				return expr.getHead().getTail();
			}else {
				return expr.getHead().getTail().getHead().eval(environment);
			}
		}else {
			return evalHelper(expr.getTail(), environment);
		}
	}
}
