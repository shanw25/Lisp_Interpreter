package index;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.parser.terms.SExpression;

public class EvalEvaluator implements Evaluator{

	@Override
	public SExpression eval(SExpression expr, Environment environment) {
		return expr.getTail().getHead().eval(environment).eval(environment);
	}
}
