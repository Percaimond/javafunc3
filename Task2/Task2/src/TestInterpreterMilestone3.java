import static org.junit.Assert.assertEquals;
import java.util.List;
import org.junit.Test;

public class TestInterpreterMilestone3 {

    @Test
    public void testProgram1() {
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
        InterpreterMilestone3 interpreter = new InterpreterMilestone3(tree);
        List<String> output = interpreter.run(code.toString());
        assertEquals(1, output.size());
        assertEquals("1", output.get(0));
    }

    @Test
    public void testProgram2() {
        StringBuilder code = new StringBuilder();

        code.append("function a {");
        code.append("  var x;");
        code.append("  x = 3;");
        code.append("  print(x);");
        code.append("}");
        code.append("var x;");
        code.append("x = 2;");
        code.append("a();");

        TinyPLParser.ProgramContext tree = Util.parseCode(code.toString());
        InterpreterMilestone3 interpreter = new InterpreterMilestone3(tree);
        List<String> output = interpreter.run(code.toString());
        assertEquals(1, output.size());
        assertEquals("3", output.get(0));
    }

    @Test
    public void testProgram3() {
        StringBuilder code = new StringBuilder();

        code.append("function outer {");
        code.append("  var foo;");
        code.append("  foo = 23;");
        code.append("  function inner {");
        code.append("    foo = 42;");
        code.append("    print(foo);");
        code.append("  }");
        code.append("  print(bar);");
        code.append("  print(foo);");
        code.append("  inner();");
        code.append("  bar = foo;");
        code.append("  print(bar);");
        code.append("  print(foo);");
        code.append("}");
        code.append("var bar;");
        code.append("bar = 5;");
        code.append("outer();");
        code.append("print(bar);");

        TinyPLParser.ProgramContext tree = Util.parseCode(code.toString());
        InterpreterMilestone3 interpreter = new InterpreterMilestone3(tree);
        List<String> output = interpreter.run(code.toString());
        assertEquals(6, output.size());
        assertEquals("5", output.get(0));
        assertEquals("23", output.get(1));
        assertEquals("42", output.get(2));
        assertEquals("42", output.get(3));
        assertEquals("42", output.get(4));
        assertEquals("42", output.get(5));

    }

}
