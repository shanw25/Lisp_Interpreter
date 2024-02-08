package index;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.parser.terms.NilAtom;
import main.lisp.parser.terms.SExpression;
import main.lisp.parser.terms.TAtom;
import main.lisp.parser.terms.TAtomicExpressionFactory;
import main.lisp.parser.terms.NilAtomicExpressionFactory;

public class NotEvaluator implements Evaluator {

	@Override
	public SExpression eval(SExpression expr, Environment environment) {
		expr = expr.getTail().getHead();
		if(expr.isNIL()) {
			return TAtomicExpressionFactory.newInstance();
		}else {
			return NilAtomicExpressionFactory.newInstance();
		}
	}

}
