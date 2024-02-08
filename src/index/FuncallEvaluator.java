package index;

import java.beans.Expression;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.evaluator.function.Function;
import main.lisp.evaluator.function.Lambda;
import main.lisp.parser.terms.ExpressionFactory;
import main.lisp.parser.terms.SExpression;


public class FuncallEvaluator implements Evaluator{

    @Override
    public SExpression eval(SExpression expr, Environment environment) {
        expr = expr.getTail();
		return evalHelper(expr, environment);
    }
    public static SExpression evalHelper(SExpression expr, Environment environment) {
        ExpressionFactory.newInstance(expr, expr);
        SExpression body = expr.getHead().eval(environment);
        return body instanceof Lambda ? BasicExpressionEvaluatorImpl.lambdaHelper((Lambda)body, expr, environment) : BasicExpressionEvaluatorImpl.functionHelper((Function)body, expr, environment);
	}
}
