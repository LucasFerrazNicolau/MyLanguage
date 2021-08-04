package ast;

import java.util.ArrayList;

public class CommandSelecao extends AbstractCommand {
	private String condition;
	private ArrayList<AbstractCommand> listaTrue;
	private ArrayList<AbstractCommand> listaFalse;
	
	public CommandSelecao(String condition, ArrayList<AbstractCommand> listaTrue, ArrayList<AbstractCommand> listaFalse) {
		this.condition = condition;
		this.listaTrue = listaTrue;
		this.listaFalse = listaFalse;
	}
	
	@Override
	public String generateJavaCode() {
		StringBuilder str = new StringBuilder();
		
		str.append("if (" + condition + ") {\n");
		for (AbstractCommand cmd : listaTrue) {
			str.append(cmd.generateJavaCode());
		}
		str.append("}");
		if (listaFalse.size() > 0) {
			str.append(" else {");
			for (AbstractCommand cmd : listaFalse) {
				str.append(cmd.generateJavaCode());
			}
			str.append("}\n");
		}
		
		return str.toString();
	}
	
	@Override
	public String toString() {
		return "CommandSelecao [condition=" + condition + ", listaTrue=" + listaTrue + ", listaFalse=" + listaFalse + "]";
	}
}
