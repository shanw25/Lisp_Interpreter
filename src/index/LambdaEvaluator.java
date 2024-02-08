package index;

import java.util.ArrayList;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.parser.terms.IdentifierAtom;
import main.lisp.parser.terms.NilAtom;
import main.lisp.evaluator.function.LambdaFactory;
import main.lisp.parser.terms.SExpression;

public class LambdaEvaluator implements Evaluator{

	@Override
	public SExpression eval(SExpression expr, Environment environment) {
        expr = expr.getTail();
		return evalHelper(expr, environment);
	}
	
	public static SExpression evalHelper(SExpression expr, Environment environment) {
		SExpression body = expr.getTail();
		IdentifierAtom ids[] = {};
		if(expr.getHead() instanceof NilAtom) {
			return LambdaFactory.newInstance(ids, body);
		}
        ids = extractIdentifiers(expr.getHead());
        return LambdaFactory.newInstance(ids, body);
	}

    private static IdentifierAtom[] extractIdentifiers(SExpression expr) {
        ArrayList<IdentifierAtom> ids = new ArrayList<>();
        while(!(expr instanceof NilAtom)) {
            ids.add((IdentifierAtom) expr.getHead());
            expr = expr.getTail();
        }
        IdentifierAtom[] idArray = new IdentifierAtom[ids.size()];
        for(IdentifierAtom id : ids) {
            idArray[ids.indexOf(id)] = id;
        }
        return idArray;
    }
}