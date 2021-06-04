import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import static org.antlr.v4.runtime.CharStreams.fromFileName;

public class InterpreterMilestoneTester {

        private TinyPLParser.ProgramContext tree;

        public InterpreterMilestoneTester(TinyPLParser.ProgramContext tree) {
            this.tree = tree;
        }




        public List<String> run() {
            List<String> output = new ArrayList<>();

            return output;}


    public static void main(String[] args ) throws IOException {
        InputStream inputStream = null;
        TinyPLLexer programLexer = null;
        try {
            File file = new File("E:\\projects\\javafunc3\\Task2\\Task2\\src\\programf.txt");
            inputStream = new FileInputStream(file);
            programLexer = new TinyPLLexer(CharStreams.fromStream(inputStream)); // read your program input and create lexer instance
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }

        /* assuming a basic grammar:
            myProgramStart: TOKEN1 otherRule TOKEN2 ';' | TOKENX finalRule ';'
            ...
        */
        CommonTokenStream tokens = new CommonTokenStream(programLexer); // get tokens
        TinyPLParser parser = new TinyPLParser(tokens);
        TinyPLCustomListener2 listener = new TinyPLCustomListener2();   // your custom extension from BaseListener
        parser.addParseListener(listener);
        parser.program().enterRule(listener);    // myProgramStart is your grammar rule to parse


        ParseTree tree = parser.program(); // parse the content and get the tree

        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(listener,tree);
    }

}
