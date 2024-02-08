package index;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.evaluator.function.FunctionFactory;
import main.lisp.evaluator.function.Lambda;
import main.lisp.parser.terms.SExpression;

public class FunctionEvaluator implements Evaluator{

	@Override
	public SExpression eval(SExpression expr, Environment environment) {
        Lambda lambda = (Lambda)expr.getTail().getHead().eval(environment);
        return FunctionFactory.newInstance(lambda, environment);
	}
}
