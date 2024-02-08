package index;

import main.lisp.evaluator.Environment;
import main.lisp.parser.terms.DecimalAtom;
import main.lisp.parser.terms.IntegerAtom;
import main.lisp.parser.terms.NilAtomicExpressionFactory;
import main.lisp.parser.terms.SExpression;
import main.lisp.parser.terms.TAtomicExpressionFactory;

public class ArithmeticEvaluatorHelper {
	
	public static SExpression getDifference(SExpression expr, Environment environment, String comparator) {
		expr = expr.getTail();
		
		SExpression firstEvaled = expr.getHead().eval(environment);
		SExpression secondEvaled = expr.getTail().getHead().eval(environment);
		
		IntegerAtom firstInt = null;
		IntegerAtom secondInt = null;
		DecimalAtom firstDec = null;
		DecimalAtom secondDec = null;
		
		if (firstEvaled instanceof IntegerAtom) {
			firstInt = (IntegerAtom)firstEvaled;
			secondInt = (IntegerAtom)secondEvaled;
		}
		if (firstEvaled instanceof DecimalAtom) {
			firstDec = (DecimalAtom)firstEvaled;
			secondDec = (DecimalAtom)secondEvaled;
		}
		double difference = firstInt.getValue() - secondInt.getValue();
		if(comparator.equals("greater")) {
			if(difference > 0) {
				return TAtomicExpressionFactory.newInstance();
			}else {
				return NilAtomicExpressionFactory.newInstance();
			}
		}else if(comparator.equals("lesser")) {
			if(difference < 0) {
				return TAtomicExpressionFactory.newInstance();
			}else {
				return NilAtomicExpressionFactory.newInstance();
			}
		}else if(comparator.equals("GreaterEqual")){
			if(difference >= 0) {
				return TAtomicExpressionFactory.newInstance();
			}else {
				return NilAtomicExpressionFactory.newInstance();
			}
		}else {
			if(difference <= 0) {
				return TAtomicExpressionFactory.newInstance();
			}else {
				return NilAtomicExpressionFactory.newInstance();
			}
		}
	}
}
