package index;

import java.util.Optional;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.environment.AbstractEnvironment;
import main.lisp.evaluator.function.Function;
import main.lisp.parser.terms.IdentifierAtom;
import main.lisp.parser.terms.SExpression;

public class EnvironmentImpl extends AbstractEnvironment{

	public EnvironmentImpl() {
		super();
	}

	public EnvironmentImpl(Environment parent) {
		super(parent);
	}

	@Override
	public void assign(IdentifierAtom arg0, SExpression arg1) {
		put(arg0, arg1);
	}

	@Override
	public void assignFun(IdentifierAtom arg0, Function arg1) {
		
	}

	@Override
	public Environment copy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<SExpression> lookup(IdentifierAtom arg0) {
		Optional<SExpression> retVal = get(arg0);
		return (retVal.isEmpty() && this.getParent() != null) ? this.getParent().lookup(arg0) : retVal;
	}

	@Override
	public Optional<Function> lookupFun(IdentifierAtom arg0) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Environment newChild() {
		return new EnvironmentImpl(this);
	}
	
}
