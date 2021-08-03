package mainPackage;

/*
 * Arquivo fonte extens�o .mylang
 * 
 * Caminho para execu��o dos comandos:
 * cd C:\Users\Lucas\eclipse-workspace\MyLanguage\antlrlib
 * 
 * Inclus�o tempor�ria do .jar no CLASSPATH:
 * SET CLASSPATH=.;C:\Users\Lucas\eclipse-workspace\MyLanguage\antlrlib\antlr-4.9-complete.jar;%CLASSPATH%
 * 
 * Comando para cria��o do parser e lexer:
 * java -jar antlr-4.9.2-complete.jar ../MyLang.g4 -o ../src/parser -package parser
 * 
 */

import org.antlr.v4.runtime.*;
import parser.MyLangLexer;
import parser.MyLangParser;

public class MainClass {
	public static void main(String[] args) {
		try {
			MyLangLexer lexer;
			MyLangParser parser;
			
			lexer = new MyLangLexer(CharStreams.fromFileName("input.mylang"));
			CommonTokenStream tokenStream = new CommonTokenStream(lexer);
			parser = new MyLangParser(tokenStream);
			
			parser.prog();
			
			System.out.println("Compilation Successful");
		} catch (Exception ex) {
			System.err.println("ERROR " + ex.getMessage());
		}
	}
}
