package mainPackage;

/*
 * Arquivo fonte extensão .mylang
 * 
 * Caminho para execução dos comandos:
 * cd C:\Users\Lucas\eclipse-workspace\MyLanguage\antlrlib
 * 
 * Comando para criação do parser e lexer:
 * java -jar antlr-4.9.2-complete.jar ../MyLang.g4 -o ../src/parser -package parser
 * 
 */

import org.antlr.v4.runtime.*;

import exceptions.MyLangSemanticException;
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
			
			parser.exibeComandos();
			parser.verificaVariaveisUtilizadas();
			parser.generateCode();
		} catch (MyLangSemanticException ex) {
			System.err.println("Semantic error - " + ex.getMessage());
		} catch (Exception ex) {
			System.err.println("ERROR " + ex.getMessage());
		}
	}
}
