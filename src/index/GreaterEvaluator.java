package index;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.parser.terms.DecimalAtom;
import main.lisp.parser.terms.IntegerAtom;
import main.lisp.parser.terms.NilAtom;
import main.lisp.parser.terms.SExpression;
import main.lisp.parser.terms.TAtom;

public class GreaterEvaluator extends ArithmeticEvaluatorHelper implements Evaluator{

	@Override
	public SExpression eval(SExpression expr, Environment environment) {
		return super.getDifference(expr, environment, "greater");
	}

}
