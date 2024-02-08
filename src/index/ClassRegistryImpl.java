package index;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;	
import main.lisp.evaluator.OperationRegisterer;
import main.lisp.parser.terms.IdentifierAtom;
import main.lisp.parser.terms.SExpression;
import gradingTools.comp524f23.assignment6.ClassRegistryA6;

public class ClassRegistryImpl implements ClassRegistryA6 {

	@Override
	public Class<? extends Evaluator> getAndEvaluator() {
		// TODO Auto-generated method stub
		return AndEvaluator.class;
	}

	@Override
	public Class<? extends Evaluator> getCondEvaluator() {
		// TODO Auto-generated method stub
		return CondEvaluator.class;
	}

	@Override
	public Class<? extends OperationRegisterer> getCustomOperationRegisterer() {
		// TODO Auto-generated method stub
		return OperationRegistererImpl.class;
	}

	@Override
	public Class<? extends Evaluator> getEvalEvaluator() {
		// TODO Auto-generated method stub
		return EvalEvaluator.class;
	}

	@Override
	public Class<? extends Evaluator> getGTEEvaluator() {
		// TODO Auto-generated method stub
		return GreaterEqualEvaluator.class;
	}

	@Override
	public Class<? extends Evaluator> getGTEvaluator() {
		// TODO Auto-generated method stub
		return GreaterEvaluator.class;
	}

	@Override
	public Class<? extends Evaluator> getLTEEvaluator() {
		// TODO Auto-generated method stub
		return LesserEqualEvaluator.class;
	}

	@Override
	public Class<? extends Evaluator> getLTEvaluator() {
		// TODO Auto-generated method stub
		return LesserEvaluator.class;
	}

	@Override
	public Class<? extends Evaluator> getListEvaluator() {
		// TODO Auto-generated method stub
		return ListEvaluator.class;
	}

	@Override
	public Class<? extends Evaluator> getLoadEvaluator() {
		// TODO Auto-generated method stub
		return LoadEvaluator.class;
	}

	@Override
	public Class<?> getMain() {
		// TODO Auto-generated method stub
		return index.class;
	}

	@Override
	public Class<? extends Evaluator> getNotEvaluator() {
		// TODO Auto-generated method stub
		return NotEvaluator.class;
	}

	@Override
	public Class<? extends Evaluator> getOrEvaluator() {
		// TODO Auto-generated method stub
		return OrEvaluator.class;
	}

	@Override
	public Class<? extends Evaluator> getQuoteEvaluator() {
		// TODO Auto-generated method stub
		return QuoteEvaluator.class;
	}

	@Override
	public Class<? extends SExpression> getStringFormattingSExpression() {
		// TODO Auto-generated method stub
		return BasicExpressionImpl.class;
	}

	@Override
	public Class<? extends SExpression> getFunctionCallingSExpression() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getFunctionCallingSExpression'");
	}

	@Override
	public Class<? extends Evaluator> getFunctionEvaluator() {
		return FuncallEvaluator.class;
	}

	@Override
	public Class<? extends Evaluator> getLetEvaluator() {
		return LetEvaluator.class;
	}

	@Override
	public Class<? extends Evaluator> getBasicFuncallEvaluator() {
		return FuncallEvaluator.class;
	}

	@Override
	public Class<? extends IdentifierAtom> getIdentifierAtomWithLookup() {
		return IdentifierAtomImpl.class;
	}

	@Override
	public Class<? extends SExpression> getLambdaCallingSExpression() {
		return null;
	}

	@Override
	public Class<? extends Evaluator> getLambdaEvaluator() {
		return LambdaEvaluator.class;
	}

	@Override
	public Class<? extends Environment> getNestedLexicalEnvironment() {
		// TODO Auto-generated method stub
		return EnvironmentImpl.class;
	}

	@Override
	public Class<? extends Evaluator> getSetqEvaluator() {
		return SetqEvaluator.class;
	}

	@Override
	public Class<? extends OperationRegisterer> getStatefulOperationRegisterer() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getStatefulOperationRegisterer'");
	}

}
