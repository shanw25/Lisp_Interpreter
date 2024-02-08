package index;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.parser.terms.NilAtom;
import main.lisp.parser.terms.TAtom;
import main.lisp.parser.terms.SExpression;
import main.lisp.parser.terms.StringAtom;
import main.lisp.interpreter.InterpreterModel;
import main.lisp.interpreter.InterpreterModelSingleton;
import main.lisp.parser.terms.TAtomicExpressionFactory;
import main.lisp.parser.terms.NilAtomicExpressionFactory;


import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class LoadEvaluator implements Evaluator {

    @Override
    public SExpression eval(SExpression expr, Environment environment) {
        // Ensure the argument is a string
        if(expr.getTail().getHead() instanceof NilAtom) {
        	return NilAtomicExpressionFactory.newInstance();
        }

        String fileName = ((StringAtom)(expr.getTail().getHead())).getValue();
//        fileName = fileName.substring(fileName.lastIndexOf("/") + 1, fileName.length() - 1);
//        System.out.println("Filename: " + fileName);
        try {
//        	Charset charset = Charset.forName("ISO-8859-1");
        	List<String> lines = Files.readAllLines(Path.of(fileName));


            // Get the singleton instance of the interpreter model
            InterpreterModel interpreterModel = InterpreterModelSingleton.get();

            for (String line : lines) {
                interpreterModel.newInput(line);
            }

            return TAtomicExpressionFactory.newInstance();
        } catch (IOException e) {
        	System.out.println(e);
            return NilAtomicExpressionFactory.newInstance();
        }
    }
}
