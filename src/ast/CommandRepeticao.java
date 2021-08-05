package ast;

import java.util.ArrayList;

public class CommandRepeticao extends AbstractCommand {
	private String condition;
	private ArrayList<AbstractCommand> listaWhile;
	
	public CommandRepeticao(String condition, ArrayList<AbstractCommand> listaWhile) {
		this.condition = condition;
		this.listaWhile = listaWhile;
	}
	
	@Override
	public String generateJavaCode() {
		StringBuilder str = new StringBuilder();
		
		str.append("while (" + condition + ") {\n");
		for (AbstractCommand cmd : listaWhile) {
			str.append(cmd.generateJavaCode());
		}
		str.append("}\n");
		
		return str.toString();
	}
	
	@Override
	public String toString() {
		return "CommandRepeticao [condition=" + condition + ", lista=" + listaWhile + "]";
	}
}
