package index;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.parser.terms.IdentifierAtom;
import main.lisp.parser.terms.NilAtom;
import main.lisp.parser.terms.SExpression;

public class LetEvaluator implements Evaluator{

    @Override
    public SExpression eval(SExpression expr, Environment environment) {
        expr = expr.getTail();
        return evalHelper(expr, environment);
    }
    
    public static SExpression evalHelper(SExpression expr, Environment environment) {
        Environment childEnvironment = environment.newChild();
        SExpression headExpr = expr.getHead();
        while(!(headExpr instanceof NilAtom)){
            IdentifierAtom temp = (IdentifierAtom)(headExpr.getHead().getHead());
            SExpression temp2 = headExpr.getHead().getTail().getHead().eval(environment);
            childEnvironment.assign(temp, temp2);
            headExpr = headExpr.getTail();
        }
        SExpression tailExpr = expr.getTail();
        while(!(tailExpr.getTail() instanceof NilAtom)){
            tailExpr.getHead().eval(childEnvironment);
            tailExpr = tailExpr.getTail();
        }
        return tailExpr.getHead().eval(childEnvironment);
    }
}
