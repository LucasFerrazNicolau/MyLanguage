package ast;

import datastructures.MyLangVariable;

public class CommandLeitura extends AbstractCommand {
	private String id;
	private MyLangVariable var;
	
	public CommandLeitura(String id, MyLangVariable var) {
		this.id = id;
		this.var = var;
	}
	
	@Override
	public String generateJavaCode() {
		return id + " = _key." + (var.getType() == MyLangVariable.NUMBER ? "nextDouble();\n" : "nextLine();\n");
	}
	
	@Override
	public String toString() {
		return "CommandLeitura [id=" + id + "]";
	}
}
