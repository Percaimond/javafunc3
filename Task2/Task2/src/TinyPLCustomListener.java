import java.util.*;

public class TinyPLCustomListener extends TinyPLBaseListener {

    HashMap<String, String> valueOfAssignment = new HashMap<>();
    static List<String> outputvalues = new ArrayList<>();

    @Override
    public void exitVariableDeclaration(TinyPLParser.VariableDeclarationContext ctx) {
        //System.out.println("variable declaration exited: " + ctx.Identifier().getText());
    }

    @Override
    public void exitAssignment(TinyPLParser.AssignmentContext ctx) {
        if(valueOfAssignment.containsKey(ctx.getChild(2).toString())){
            this.valueOfAssignment.put(ctx.getChild(0).toString(), valueOfAssignment.get(ctx.getChild(2).toString()));
        }else {
            this.valueOfAssignment.put(ctx.getChild(0).toString(), ctx.getChild(2).toString());
        }
        /*System.out.println("assignment exited: " + ctx.getText());
        System.out.println("value of assignment: " + ctx.getChild(2));
        System.out.println("Hashmapvalue: " + valueOfAssignment.get(ctx.getChild(0).toString()));*/
    }

    @Override
    public void exitCall(TinyPLParser.CallContext ctx) {
        //System.out.println("call exited: " + ctx.getText());

        //System.out.println(valueOfAssignment.get(ctx.Identifier().toString()));
        outputvalues.add(valueOfAssignment.get(ctx.Identifier().toString()));
        //System.out.println("Values of list to copy: " + Arrays.toString(outputvalues.toArray()));
        //System.out.println("values of lister(): "+ lister());
    }
}
