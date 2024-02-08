package index;

import java.util.Optional;

import main.lisp.scanner.tokens.Token;
import main.lisp.evaluator.Environment;
import main.lisp.parser.terms.IdentifierAtom;
import main.lisp.parser.terms.SExpression;

public class IdentifierAtomImpl extends IdentifierAtom{

    public IdentifierAtomImpl(String string) {
        super(string);
    }
    
    public IdentifierAtomImpl(Token token) {
        super(token);
     }

    @Override
    public SExpression eval(Environment var1){
        Optional<SExpression> retVal = var1.lookup(this);
        if(retVal.isPresent()) {
            return retVal.get();
        }
        return this;
    }
}
