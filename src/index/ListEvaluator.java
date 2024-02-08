package index;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.parser.terms.SExpression;
import main.lisp.parser.terms.ExpressionFactory;

public class ListEvaluator implements Evaluator{

	@Override
	public SExpression eval(SExpression expr, Environment environment) {
		expr = expr.getTail();
		return evalHelper(expr, environment);
	}
	
	public static SExpression evalHelper(SExpression expr, Environment environment) {
		if(expr.isAtom()) {
			return expr.eval(environment);
		}
		return ExpressionFactory.newInstance(expr.getHead().eval(environment), evalHelper(expr.getTail(), environment));
		
	}

}
