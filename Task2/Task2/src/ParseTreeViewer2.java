import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.misc.Pair;

public class ParseTreeViewer2 {

    public static void main(String[] args) {
        // write code into string
        StringBuilder code = new StringBuilder();
        code.append("function f {");
        code.append("  var x;");
        code.append("  x = 7;");
        code.append("  print(x);");
        code.append("}");
        code.append("f();");

        // parse code into AST
        Pair<TinyPLParser.ProgramContext, TinyPLParser> pair = Util.parseCodeWithParser(code.toString());
        TinyPLParser.ProgramContext tree = pair.a;
        TinyPLParser parser = pair.b;

        // show AST in console
        System.out.println(tree.toStringTree(parser));

        // show AST in GUI
        JFrame frame = new JFrame("Antlr AST");
        JPanel panel = new JPanel();
        TreeViewer viewer = new TreeViewer(Arrays.asList(parser.getRuleNames()), tree);
        viewer.setScale(1.5); // Scale a little
        panel.add(viewer);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
