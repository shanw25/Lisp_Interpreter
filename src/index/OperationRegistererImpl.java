package index;

import main.lisp.evaluator.OperationRegisterer;
import valgrindpp.codegen.Function;
import main.lisp.evaluator.BasicOperationRegisterer;
import main.lisp.evaluator.BuiltinOperationManagerSingleton;

public class OperationRegistererImpl extends BasicOperationRegisterer implements OperationRegisterer{
	
	public static void registerBasic() {
		BuiltinOperationManagerSingleton.get().registerEvaluatorIfNew("QUOTE", new QuoteEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluatorIfNew("LIST", new ListEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluatorIfNew("LOAD", new LoadEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluatorIfNew("EVAL", new EvalEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluatorIfNew("COND", new CondEvaluator());
	}
	
	public static void registerArithmetic() {
		BuiltinOperationManagerSingleton.get().registerEvaluatorIfNew(">", new GreaterEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluatorIfNew("<", new LesserEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluatorIfNew(">=", new GreaterEqualEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluatorIfNew("<=", new LesserEqualEvaluator());
	}
	
	public static void registerLogic() {
		BuiltinOperationManagerSingleton.get().registerEvaluatorIfNew("AND", new AndEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluatorIfNew("OR", new OrEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluatorIfNew("NOT", new NotEvaluator());
	}
	
	public static void registerAdvance() {
		BuiltinOperationManagerSingleton.get().registerEvaluatorIfNew("SETQ", new SetqEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluatorIfNew("LAMBDA", new LambdaEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluatorIfNew("FUNCALL", new FuncallEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluatorIfNew("FUNCTION", new FunctionEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluatorIfNew("CURRY", new CurryEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluatorIfNew("LET", new LetEvaluator());
	}
	
	@Override
	public void registerOperations() {
		registerAll();
	}
	
	public static void registerAll() {
		registerBasic();
		registerArithmetic();
		registerLogic();
		registerAdvance();
	}
}
