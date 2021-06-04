import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;
import org.junit.Test;

public class TestInterpreterMilestone1 {

    @Test
    public void testProgram1(){
        String code = "var foo; foo = 23; print(foo);";
        TinyPLParser.ProgramContext tree = Util.parseCode(code);
        InterpreterMilestone1 interpreter = new InterpreterMilestone1(tree);
        List<String> output = interpreter.run();//wrong without code
        assertEquals(1, output.size());
        assertEquals("23", output.get(0));
    }
    @Test
    public void testProgram2() {
        String code = "var x; var y; var z; z = 567; print(z); y = z; print(y);";
        TinyPLParser.ProgramContext tree = Util.parseCode(code);
        InterpreterMilestone1 interpreter = new InterpreterMilestone1(tree);
        List<String> output = interpreter.run();
        assertEquals(2, output.size());
        assertEquals("567", output.get(0));
        assertEquals("567", output.get(1));
    }
    @Test
    public void testProgram3() {
        String code = "var x; var y; var z; z = 567; x = z; y = 323; print(x); print(y); print(z);";
        TinyPLParser.ProgramContext tree = Util.parseCode(code);
        InterpreterMilestone1 interpreter = new InterpreterMilestone1(tree);
        List<String> output = interpreter.run();
        assertEquals(3, output.size());
        assertEquals("567", output.get(0));
        assertEquals("323", output.get(1));
        assertEquals("567", output.get(2));
    }
    @Test
    public void testProgram4(){
        String code = "var x; var y; var z; var q; z = 567; x = z; y = 323; q = z; q = y; print(x); print(y); print(z); print(q);";
        TinyPLParser.ProgramContext tree = Util.parseCode(code);
        InterpreterMilestone1 interpreter = new InterpreterMilestone1(tree);
        List<String> output = interpreter.run();
        assertEquals(4, output.size());
        assertEquals("567", output.get(0));
        assertEquals("323", output.get(1));
        assertEquals("567", output.get(2));
        assertEquals("323", output.get(3));
    }
    @Test
    public void testProgram5(){
        String code = "var x; var y; var z; var q; var o; z = 123; x = z; y = 2; q = z; q = y; o = 3; q = o; print(o); print(x); print(y); print(z); print(q);";
        TinyPLParser.ProgramContext tree = Util.parseCode(code);
        InterpreterMilestone1 interpreter = new InterpreterMilestone1(tree);
        List<String> output = interpreter.run();
        assertEquals(5, output.size());
        assertEquals("3", output.get(0));
        assertEquals("123", output.get(1));
        assertEquals("2", output.get(2));
        assertEquals("123", output.get(3));
        assertEquals("3",   output.get(4));
    }
    @Test
    public void testProgram6(){
        String code = "var x; var y; var z; var q; var o; z = 123; x = z; y = z; q = z; o = z; print(o); print(x); print(y); print(z); print(q);";
        TinyPLParser.ProgramContext tree = Util.parseCode(code);
        InterpreterMilestone1 interpreter = new InterpreterMilestone1(tree);
        List<String> output = interpreter.run();
        assertEquals(5, output.size());
        assertEquals("123", output.get(0));
        assertEquals("123", output.get(1));
        assertEquals("123", output.get(2));
        assertEquals("123", output.get(3));
        assertEquals("123",   output.get(4));
    }
    @Test
    public void testProgram7(){
        String code = "var x; var y; var z; var q; var o; z = 123; o = 2; print(o); x = z; y = z; q = z; print(x); print(y); print(z); print(q);";
        TinyPLParser.ProgramContext tree = Util.parseCode(code);
        InterpreterMilestone1 interpreter = new InterpreterMilestone1(tree);
        List<String> output = interpreter.run();
        assertEquals(5, output.size());
        assertEquals("2", output.get(0));
        assertEquals("123", output.get(1));
        assertEquals("123", output.get(2));
        assertEquals("123", output.get(3));
        assertEquals("123", output.get(4));
    }

    @Test
    public void testProgram8(){
        String code = "var x; var y; var z; var q; var o; z = 123; o = 2; print(o); x = x; y = z; q = z; print(x); print(y); print(z); print(q);";
        TinyPLParser.ProgramContext tree = Util.parseCode(code);
        InterpreterMilestone1 interpreter = new InterpreterMilestone1(tree);
        List<String> output = interpreter.run();
        assertEquals(5, output.size());
        assertEquals("2", output.get(0));
        assertEquals("x", output.get(1));
        assertEquals("123", output.get(2));
        assertEquals("123", output.get(3));
        assertEquals("123", output.get(4));
    }
}
