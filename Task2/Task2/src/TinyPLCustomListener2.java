import org.antlr.v4.runtime.ParserRuleContext;

import java.util.*;

public class TinyPLCustomListener2 extends TinyPLBaseListener {

    HashMap<String, String> valueOfAssignment = new HashMap<>();
    static List<String> outputvalues = new ArrayList<>();
    HashMap<String, List<String>> functionOutput = new HashMap<>();

    @Override
    public void exitAssignment(TinyPLParser.AssignmentContext ctx) {//almoste finished differentiate between dynamic and static scoping
            if(valueOfAssignment.containsKey(ctx.getChild(2).toString())){
                this.valueOfAssignment.put(ctx.getChild(0).toString(), valueOfAssignment.get(ctx.getChild(2).toString()));
            }else{
                this.valueOfAssignment.put(ctx.getChild(0).toString(), ctx.getChild(2).toString());
            }
    }

    @Override
    public void exitCall(TinyPLParser.CallContext ctx) {//almost finished missing right output of funcitons
        if(ctx.getParent().getParent().getParent().getChild(0).toString().equals("function")){//todo
            System.out.println("this print statement belongs to the function: " + ctx.getParent().getParent().getParent().getChild(1).toString());
        }else{
            if(!ctx.getChild(0).toString().equals("print")){//todo
                if(functionOutput.get(ctx.getChild(0).toString()) == null){

               }else{
                    for(String string: functionOutput.get(ctx.getChild(0).toString())){
                        if(valueOfAssignment.containsKey(string)){
                            this.valueOfAssignment.put(ctx.getChild(0).toString(), valueOfAssignment.get(ctx.getChild(2).toString()));
                            System.out.println(valueOfAssignment.get(string));
                            outputvalues.add(valueOfAssignment.get(string));
                        }else{
                            this.valueOfAssignment.put(ctx.getChild(0).toString(), ctx.getChild(2).toString());
                            outputvalues.add(string);
                        }

                    }
                    //outputvalues.addAll(functionOutput.get(ctx.getChild(0).toString()));

                    //outputvalues.addAll(functionOutput.get(ctx.getChild(0).toString()));
                }
            }else{
                outputvalues.add(valueOfAssignment.get(ctx.Identifier().toString()));
            }
        }
    }

    @Override
    public void exitFunctionDeclaration(TinyPLParser.FunctionDeclarationContext ctx) {//todo
        System.out.println("function exited: " + ctx.getChild(1).toString() + "()");
        List<String> functionMappedVariables = new ArrayList<>();
        List<String> functionMappedValues = new ArrayList<>();
        for(int i =0;i<ctx.getChild(3).getChildCount();i++) {
            if(ctx.getChild(3).getChild(i).getChild(0).getChild(0).toString().equals("print")){
                functionMappedVariables.add(ctx.getChild(3).getChild(i).getChild(0).getChild(2).toString());
            }
        }
        for(String string: functionMappedVariables){
            if(valueOfAssignment.containsKey(string)){
                functionMappedValues.remove(string);
                functionMappedValues.add(valueOfAssignment.get(string));
            }else{
               for(int i =0;i<ctx.getChild(3).getChildCount();i++) {
                    if (ctx.getChild(3).getChild(i).getChild(0).getChild(0).toString().equals("print")) {
                        functionMappedValues.add(ctx.getChild(3).getChild(i).getChild(0).getChild(2).toString());
                    }
                }
            }

        }
        functionOutput.put( ctx.getChild(1).toString(),functionMappedValues);
        System.out.println(functionOutput);
    }
    @Override
    public void exitProgram(TinyPLParser.ProgramContext ctx) {



        System.out.println(outputvalues);
    }
}