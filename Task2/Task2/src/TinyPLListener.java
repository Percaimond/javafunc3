// Generated from E:\projects\javafunc3\Task2\Task2\src\TinyPL.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TinyPLParser}.
 */
public interface TinyPLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TinyPLParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(TinyPLParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyPLParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(TinyPLParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyPLParser#statements}.
	 * @param ctx the parse tree
	 */
	void enterStatements(TinyPLParser.StatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyPLParser#statements}.
	 * @param ctx the parse tree
	 */
	void exitStatements(TinyPLParser.StatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyPLParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(TinyPLParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyPLParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(TinyPLParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyPLParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaration(TinyPLParser.VariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyPLParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaration(TinyPLParser.VariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyPLParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(TinyPLParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyPLParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(TinyPLParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyPLParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclaration(TinyPLParser.FunctionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyPLParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclaration(TinyPLParser.FunctionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyPLParser#call}.
	 * @param ctx the parse tree
	 */
	void enterCall(TinyPLParser.CallContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyPLParser#call}.
	 * @param ctx the parse tree
	 */
	void exitCall(TinyPLParser.CallContext ctx);
}