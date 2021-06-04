import com.sun.deploy.net.MessageHeader;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.Pair;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;

public class InterpreterMilestone1 extends TinyPLCustomListener {

    private TinyPLParser.ProgramContext tree;

    public InterpreterMilestone1(TinyPLParser.ProgramContext tree) {
        this.tree = tree;
    }

    public List<String> run() {
        List<String> output = new ArrayList<>();
        outputvalues.clear();
        TinyPLCustomListener listener = new TinyPLCustomListener();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(listener, tree);
        //System.out.println("values of method: " + lister());
        output = outputvalues;
        //System.out.println("values of original: " + outputvalues);
        //System.out.println("values of output: " + output);
        return output;
    }
    public static void main(String[] args){
        String code = "var x; var y; var z; z = 567; print(z); y = z; print(y);";
        TinyPLParser.ProgramContext tree = Util.parseCode(code);
        InterpreterMilestone1 interpreter = new InterpreterMilestone1(tree);
        List<String> output = interpreter.run();
        System.out.println(output);
    }
}
