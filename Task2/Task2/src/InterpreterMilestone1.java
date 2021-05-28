import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InterpreterMilestone1 {

    private TinyPLParser.ProgramContext tree;

    public InterpreterMilestone1(TinyPLParser.ProgramContext tree) {
        this.tree = tree;
    }


     public static void helpermethod(){
       List<String> output = new ArrayList<>();
        String code = "var foo; foo = 23; print(foo);";
        String regex = "[a-z][a-z]*\\s=\\s([a-z][a-z]*|[0-9][0-9]*);";

        final String string = code;
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(string);

        List<String> assignments = new ArrayList<>();
        List<String> valueOfAssignment = new ArrayList<>();
        List<String> variableName = new ArrayList<>();
        List<String> printStatements = new ArrayList<>();
        HashMap<String,String> pairsOfAssignment = new HashMap<>();
        while (matcher.find()) {
            //System.out.println(matcher.group(0));
            assignments.add(matcher.group(0));
            for (int i = 1; i <= matcher.groupCount(); i++) {
                //System.out.println("Value of assignment " + ": " + matcher.group(i));
                String firstWord = matcher.group(0).replaceAll(" .*", "");
                variableName.add(firstWord);
                valueOfAssignment.add(matcher.group(i));
            }
        }

        for(int i = 0; i<variableName.size();i++){
            pairsOfAssignment.put(variableName.get(i),valueOfAssignment.get(i));
        }
        System.out.println("Assignments: " + assignments);
        System.out.println("Name of variable: " + variableName);
        System.out.println("Values of assignments: " + valueOfAssignment);
        System.out.println("Assignmentpairs: " + pairsOfAssignment);

        String regex2 = "[p][r][i][n][t][(]([a-z][a-z]*)[)]";
        final Pattern pattern2 = Pattern.compile(regex2, Pattern.MULTILINE);
        final Matcher matcher2 = pattern2.matcher(string);
        while (matcher2.find()) {
            //System.out.println(matcher2.group(0));
            //System.out.println(matcher2.group(1));
            printStatements.add(matcher2.group(1));
        }
        for(int i = 0; i<printStatements.size();i++){
            for(String name: pairsOfAssignment.keySet())
                if(printStatements.get(i).equals(name)){
                    output.add(pairsOfAssignment.get(name));
                }
            }System.out.println(output);
        }
    public List<String> run() {
        List<String> output = new ArrayList<>();
        String code = "var x; var y; var z; z = 567; print(z); y = z; print(y);";
        String regex = "[a-z][a-z]*\\s=\\s([a-z][a-z]*|[0-9][0-9]*);";

        String string = code;
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(string);

        List<String> assignments = new ArrayList<>();
        List<String> valueOfAssignment = new ArrayList<>();
        List<String> variableName = new ArrayList<>();
        List<String> printStatements = new ArrayList<>();
        HashMap<String,String> pairsOfAssignment = new HashMap<>();
        while (matcher.find()) {
            //System.out.println(matcher.group(0));
            assignments.add(matcher.group(0));
            for (int i = 1; i <= matcher.groupCount(); i++) {
                //System.out.println("Value of assignment " + ": " + matcher.group(i));
                String firstWord = matcher.group(0).replaceAll(" .*", "");
                variableName.add(firstWord);
                valueOfAssignment.add(matcher.group(i));
            }
        }

        for(int i = 0; i<variableName.size();i++){
            pairsOfAssignment.put(variableName.get(i),valueOfAssignment.get(i));
        }
        /*System.out.println("Assignments: " + assignments);
        System.out.println("Name of variable: " + variableName);
        System.out.println("Values of assignments: " + valueOfAssignment);
        System.out.println("Assignmentpairs: " + pairsOfAssignment);*/

        String regex2 = "[p][r][i][n][t][(]([a-z][a-z]*)[)]";
        final Pattern pattern2 = Pattern.compile(regex2, Pattern.MULTILINE);
        final Matcher matcher2 = pattern2.matcher(string);
        while (matcher2.find()) {
            //System.out.println(matcher2.group(0));
            //System.out.println(matcher2.group(1));
            printStatements.add(matcher2.group(1));
        }
        for(int i = 0; i<printStatements.size();i++){
            for(String name: pairsOfAssignment.keySet())
                if(printStatements.get(i).equals(name)){
                    output.add(pairsOfAssignment.get(name));
                }
        }//System.out.println(output);

        return output;
    }
    public static void main(String[] args ){
        //helpermethod();
    }
}