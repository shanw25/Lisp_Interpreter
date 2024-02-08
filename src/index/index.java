package index;

import main.Main;
import main.lisp.parser.terms.ExpressionFactory;
import main.lisp.parser.terms.IdentifierAtomFactory;
import main.lisp.evaluator.ExpressionEvaluatorFactory;
import main.lisp.evaluator.environment.EnvironmentFactory;

public class index {

	public static void main(String[] args) {
		ExpressionEvaluatorFactory.setClass(BasicExpressionEvaluatorImpl.class);
		IdentifierAtomFactory.setClass(IdentifierAtomImpl.class);
		EnvironmentFactory.setClass(EnvironmentImpl.class);
		OperationRegistererImpl.registerAll();
		ExpressionFactory.setClass(BasicExpressionImpl.class);
		Main.main(args);
	}
}
