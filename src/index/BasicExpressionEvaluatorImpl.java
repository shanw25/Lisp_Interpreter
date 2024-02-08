package index;

import main.lisp.evaluator.BasicExpressionEvaluator;
import main.lisp.evaluator.BuiltinOperationManagerSingleton;
import main.lisp.evaluator.Environment;
import main.lisp.evaluator.function.BasicLambda;
import main.lisp.evaluator.function.Function;
import main.lisp.evaluator.function.Lambda;
import main.lisp.parser.terms.IdentifierAtom;
import main.lisp.parser.terms.SExpression;

public class BasicExpressionEvaluatorImpl extends BasicExpressionEvaluator{

	@Override
	public SExpression eval(SExpression expr, Environment environment) {
		if(!(expr.getHead() instanceof IdentifierAtom)){
			SExpression temp = expr.getHead();
			Lambda lambda;
			if(!(temp.getClass().equals(BasicLambda.class))) {
				lambda = (Lambda)temp.eval(environment);
			}else {
				lambda = (Lambda)temp;
			}
			return lambdaHelper(lambda, expr, environment);
		}else{
			return BuiltinOperationManagerSingleton.get().getEvaluator(expr.getHead().toString()).eval(expr, environment);
		}
	}

	public static SExpression lambdaHelper(Lambda lambda, SExpression expr, Environment environment){
		Environment childEnvironment = environment.newChild();
		IdentifierAtom[] ids = lambda.getArgumentNames();
		for (IdentifierAtom id : ids){
			childEnvironment.assign(id, expr.getTail().getHead().eval(environment));
			expr = expr.getTail();
		}
		return lambda.eval(childEnvironment);
	}

	public static SExpression functionHelper(Function function, SExpression expr, Environment environment){
		return lambdaHelper(function.getLambda(), expr, function.getEnvironment());
	}
}
