// Generated from ../MyLang.g4 by ANTLR 4.9.2
package parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MyLangParser}.
 */
public interface MyLangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MyLangParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(MyLangParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLangParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(MyLangParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLangParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(MyLangParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLangParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(MyLangParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLangParser#declaravar}.
	 * @param ctx the parse tree
	 */
	void enterDeclaravar(MyLangParser.DeclaravarContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLangParser#declaravar}.
	 * @param ctx the parse tree
	 */
	void exitDeclaravar(MyLangParser.DeclaravarContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLangParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(MyLangParser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLangParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(MyLangParser.TipoContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLangParser#bloco}.
	 * @param ctx the parse tree
	 */
	void enterBloco(MyLangParser.BlocoContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLangParser#bloco}.
	 * @param ctx the parse tree
	 */
	void exitBloco(MyLangParser.BlocoContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLangParser#comando}.
	 * @param ctx the parse tree
	 */
	void enterComando(MyLangParser.ComandoContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLangParser#comando}.
	 * @param ctx the parse tree
	 */
	void exitComando(MyLangParser.ComandoContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLangParser#cmdleitura}.
	 * @param ctx the parse tree
	 */
	void enterCmdleitura(MyLangParser.CmdleituraContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLangParser#cmdleitura}.
	 * @param ctx the parse tree
	 */
	void exitCmdleitura(MyLangParser.CmdleituraContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLangParser#cmdescrita}.
	 * @param ctx the parse tree
	 */
	void enterCmdescrita(MyLangParser.CmdescritaContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLangParser#cmdescrita}.
	 * @param ctx the parse tree
	 */
	void exitCmdescrita(MyLangParser.CmdescritaContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLangParser#cmdattrib}.
	 * @param ctx the parse tree
	 */
	void enterCmdattrib(MyLangParser.CmdattribContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLangParser#cmdattrib}.
	 * @param ctx the parse tree
	 */
	void exitCmdattrib(MyLangParser.CmdattribContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(MyLangParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(MyLangParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLangParser#termo}.
	 * @param ctx the parse tree
	 */
	void enterTermo(MyLangParser.TermoContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLangParser#termo}.
	 * @param ctx the parse tree
	 */
	void exitTermo(MyLangParser.TermoContext ctx);
}