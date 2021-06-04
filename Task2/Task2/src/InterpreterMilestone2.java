
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.*;


public class InterpreterMilestone2 extends TinyPLCustomListener2 {

    private TinyPLParser.ProgramContext tree;

    public InterpreterMilestone2(TinyPLParser.ProgramContext tree) {
        this.tree = tree;
    }

    public List<String> run(){
        List<String> output = new ArrayList<>();
        outputvalues.clear();
        TinyPLCustomListener2 listener = new TinyPLCustomListener2();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(listener,tree);
        //System.out.println("values of method: " + lister());
        output = outputvalues;
        //System.out.println("values of original: " + outputvalues);
        //System.out.println("values of output: " + output);
        return output;
    }
    public static void main(String[] args){
        String code = "function callme { var inner; inner = 567; print(outer); print(inner); } var outer; outer = 99; callme(); print(outer);";
        TinyPLParser.ProgramContext tree = Util.parseCode(code);
        InterpreterMilestone2 interpreter = new InterpreterMilestone2(tree);
        List<String> output = interpreter.run();
        System.out.println(output);
    }
}

