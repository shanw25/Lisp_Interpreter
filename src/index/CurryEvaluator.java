package index;

import java.util.ArrayList;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.evaluator.function.Lambda;
import main.lisp.evaluator.function.LambdaFactory;
import main.lisp.parser.terms.ExpressionFactory;
import main.lisp.parser.terms.IdentifierAtom;
import main.lisp.parser.terms.NilAtom;
import main.lisp.parser.terms.SExpression;

public class CurryEvaluator implements Evaluator{

    @Override
    public SExpression eval(SExpression expr, Environment environment) {
        expr = expr.getTail();
        return evalHelper(expr, environment);
    }

    public static SExpression evalHelper(SExpression expr, Environment environment) {
        Lambda flambda = (Lambda) expr.getHead().eval(environment);
        IdentifierAtom identifierAtoms[] = flambda.getArgumentNames();
        SExpression expressions[] = getExpressions(expr.getTail());
        IdentifierAtom curryLambdaArgs[] = new IdentifierAtom[identifierAtoms.length - expressions.length];
        for(int i = expressions.length; i < identifierAtoms.length; i++) {
            curryLambdaArgs[i - expressions.length] = identifierAtoms[i];
        }

        SExpression curryLambdaBody = ExpressionFactory.newInstance(new IdentifierAtom("QUOTE"), flambda);
        curryLambdaBody = ExpressionFactory.newInstance(new IdentifierAtom("FUNCALL"), curryLambdaBody);
        curryLambdaBody = quoteMakeList(curryLambdaBody, expressions, environment);
        curryLambdaBody = makeList(curryLambdaBody, curryLambdaArgs);
        return LambdaFactory.newInstance(curryLambdaArgs, curryLambdaBody);
    }

    private static SExpression[] getExpressions(SExpression expr) {
        ArrayList<SExpression> expressions = new ArrayList<>();
        while(!(expr instanceof NilAtom)) {
            expressions.add(expr.getHead());
            expr = expr.getTail();
        }
        SExpression[] idArray = new SExpression[expressions.size()];
        for(SExpression id : expressions) {
            idArray[expressions.indexOf(id)] = id;
        }
        return idArray;
    }

    private static SExpression quoteMakeList(SExpression curryLambdaBody, SExpression expression[], Environment environment){
        for(int i = 0; i < expression.length; i++){
            SExpression tempExpression = ExpressionFactory.newInstance(new IdentifierAtom("QUOTE"), expression[i].eval(environment));
            curryLambdaBody = ExpressionFactory.newInstance(curryLambdaBody, tempExpression);
        }
        return curryLambdaBody;
    }

    private static SExpression makeList(SExpression curryLambdaBody, IdentifierAtom ids[]){
        for(int i = 0; i < ids.length; i++){
            SExpression tempExpression = ids[i];
            curryLambdaBody = ExpressionFactory.newInstance(tempExpression, curryLambdaBody);
        }
        return curryLambdaBody;
    }
}
