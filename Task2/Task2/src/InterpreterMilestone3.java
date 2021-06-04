import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InterpreterMilestone3 extends TinyPLCustomListener2{

    private TinyPLParser.ProgramContext tree;

    public InterpreterMilestone3(TinyPLParser.ProgramContext tree) {
        this.tree = tree;
    }

    public List<String> run() {
        List<String> output = new ArrayList<>();
        outputvalues.clear();
        TinyPLCustomListener2 listener = new TinyPLCustomListener2();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(listener,tree);

        output = outputvalues;

        return output;

    }

}
