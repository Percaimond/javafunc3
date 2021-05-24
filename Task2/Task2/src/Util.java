import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.Pair;

public class Util {

    public static TinyPLParser.ProgramContext parseCode(String code) {
        return parseCodeWithParser(code).a;
    }

    public static Pair<TinyPLParser.ProgramContext, TinyPLParser> parseCodeWithParser(String code) {
        TinyPLLexer lexer = new TinyPLLexer(CharStreams.fromString(code));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TinyPLParser parser = new TinyPLParser(tokens);
        TinyPLParser.ProgramContext tree = parser.program();
        return new Pair<TinyPLParser.ProgramContext, TinyPLParser>(tree, parser);
    }

}
