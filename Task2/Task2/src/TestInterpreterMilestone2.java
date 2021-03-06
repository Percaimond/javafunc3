import static org.junit.Assert.assertEquals;

import java.util.List;
import org.junit.Test;

public class TestInterpreterMilestone2 {

    @Test
    public void testProgram1() {
        StringBuilder code = new StringBuilder();
        code.append("function f {");
        code.append("  var x;");
        code.append("  x = 7;");
        code.append("  print(x);");
        code.append("}");
        code.append("f();");

        TinyPLParser.ProgramContext tree = Util.parseCode(code.toString());
        InterpreterMilestone2 interpreter = new InterpreterMilestone2(tree);
        List<String> output = interpreter.run();
        assertEquals(1, output.size());
        assertEquals("7", output.get(0));
    }

    @Test
    public void testProgram2() {
        StringBuilder code = new StringBuilder();
        code.append("function callme {");
        code.append("  var inner;");
        code.append("  inner = 567;");
        code.append("  print(outer);");
        code.append("  print(inner);");
        code.append("}");
        code.append("var outer;");
        code.append("outer = 99;");
        code.append("callme();");
        code.append("print(outer);");

        TinyPLParser.ProgramContext tree = Util.parseCode(code.toString());
        InterpreterMilestone2 interpreter = new InterpreterMilestone2(tree);
        List<String> output = interpreter.run();
        assertEquals(3, output.size());
        assertEquals("99", output.get(0));
        assertEquals("567", output.get(1));
        assertEquals("99", output.get(2));
    }

    @Test
    public void testProgram3() {
        StringBuilder code = new StringBuilder();
        code.append("function a {");
        code.append("  var x;");
        code.append("  x = 55;");
        code.append("  b();");
        code.append("}");
        code.append("function b {");
        code.append("  print(x);");
        code.append("}");
        code.append("var x;");
        code.append("x = 1;");
        code.append("a();");

        TinyPLParser.ProgramContext tree = Util.parseCode(code.toString());
        InterpreterMilestone2 interpreter = new InterpreterMilestone2(tree);
        List<String> output = interpreter.run();
        assertEquals(1, output.size());
        assertEquals("55", output.get(0));
    }

    @Test
    public void testProgram5() {
        System.out.println("-------------------------------------");
        StringBuilder code = new StringBuilder();

        code.append("var x;");
        code.append("var y;");
        code.append("x = 1;");
        code.append("function a {");
        code.append("    var x;");
        code.append("    x = 2;");
        code.append("    function b {");
        code.append("        x = 3;");
        code.append("        y = 100;");
        code.append("    }");
        code.append("    b();");
        code.append("    print(x);");
        code.append("}");
        code.append("a();");
        code.append("print(x);");

        TinyPLParser.ProgramContext tree = Util.parseCode(code.toString());
        InterpreterMilestone3 interpreter = new InterpreterMilestone3(tree);
        List<String> output = interpreter.run();
        assertEquals(2, output.size());
        assertEquals("3", output.get(0));
        assertEquals("1", output.get(1));

    }
}

