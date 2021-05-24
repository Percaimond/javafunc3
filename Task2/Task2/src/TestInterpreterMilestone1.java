import static org.junit.Assert.assertEquals;
import java.util.List;
import org.junit.Test;

public class TestInterpreterMilestone1 {

    @Test
    public void testProgram1() {
        String code = "var foo; foo = 23; print(foo);";
        TinyPLParser.ProgramContext tree = Util.parseCode(code);
        InterpreterMilestone1 interpreter = new InterpreterMilestone1(tree);
        List<String> output = interpreter.run();
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

}
