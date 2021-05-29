import static org.junit.Assert.assertEquals;
import java.util.List;
import org.junit.Test;

public class TestInterpreterMilestone1 {

    @Test
    public void testProgram1() {
        String code = "var foo; foo = 23; print(foo);";
        TinyPLParser.ProgramContext tree = Util.parseCode(code);
        InterpreterMilestone1 interpreter = new InterpreterMilestone1(tree);
        List<String> output = interpreter.run(code);//wrong without code
        assertEquals(1, output.size());
        assertEquals("23", output.get(0));
    }

    @Test
    public void testProgram2() {
        String code = "var x; var y; var z; z = 567; print(z); y = z; print(y);";
        TinyPLParser.ProgramContext tree = Util.parseCode(code);
        InterpreterMilestone1 interpreter = new InterpreterMilestone1(tree);
        List<String> output = interpreter.run(code);//wrong without code
        assertEquals(2, output.size());
        assertEquals("567", output.get(0));
        assertEquals("567", output.get(1));
    }
    @Test
    public void testProgram3() {
        String code = "var x; var y; var z; var q; var v; var x; z = 567; x = z; y = 323; q = 456; v = 45; print(x); print(y); print(z); print(q); print(v); print(x);";
        TinyPLParser.ProgramContext tree = Util.parseCode(code);
        InterpreterMilestone1 interpreter = new InterpreterMilestone1(tree);
        List<String> output = interpreter.run(code);//wrong without code
        assertEquals(6, output.size());
        assertEquals("567", output.get(0));
        assertEquals("323", output.get(1));
        assertEquals("567", output.get(2));
        assertEquals("456", output.get(3));
        assertEquals("45",  output.get(4));
        assertEquals("567", output.get(5));
    }

}
