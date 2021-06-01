import java.util.ArrayList;
import java.util.List;
import org.antlr.v4.runtime.tree.*;
import static org.antlr.v4.runtime.CharStreams.fromFileName;
import org.antlr.v4.runtime.*;


public class InterpreterMilestone2 {

    private TinyPLParser.ProgramContext tree;

    public InterpreterMilestone2(TinyPLParser.ProgramContext tree) {
        this.tree = tree;
    }




    public List<String> run() {
        List<String> output = new ArrayList<>();
        StringBuilder code = new StringBuilder();


        // TODO: add your solution here

        return output;
    }

}