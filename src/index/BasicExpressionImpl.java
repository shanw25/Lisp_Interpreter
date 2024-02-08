package index;

import main.lisp.parser.terms.AbstractSExpression;
import main.lisp.parser.terms.Atom;
import main.lisp.parser.terms.BasicExpression;
import main.lisp.parser.terms.SExpression;

public class BasicExpressionImpl extends BasicExpression implements SExpression{
	
	public BasicExpressionImpl(SExpression head, SExpression tail) {
		super(head, tail);
	}

	@Override
	public boolean isList() {
		if((this.getTail() instanceof Atom)) {
			return this.getTail().isNIL();
		}else {
			return this.getTail().isList();
		}
	}

	@Override
	public String toStringAsSExpressionDeep() {
		if(this.isAtom()) {
			return "(" + this.toString() + ")";
		}
		return "(" + this.getHead().toStringAsSExpressionDeep() + " " + "." + " " +
				this.getTail().toStringAsSExpressionDeep() + ")";
	}

	@Override
	public String toStringAsSExpression() {
		return "(" + this.getHead().toString() + " " + "." + " " +
				this.getTail().toString() + ")";
	}

	@Override
	public String toStringAsList() {
		return "("+((AbstractSExpression)this).toStringAsListHelperPublic()+")";
	}

	@Override
	public String toString() {
		return this.isList()? this.toStringAsList() : this.toStringAsSExpression();
	}

	@Override
	public String toStringAsListHelperPublic() {
		if(this.getTail().isNIL()) {
			return this.getHead().toString();
		}else {
			return this.getHead().toString() + " " + ((AbstractSExpression)this.getTail()).toStringAsListHelperPublic();	
		}
	}

}
