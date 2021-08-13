package ast;

import java.util.ArrayList;

public class CommandPara extends AbstractCommand {
	private String id;
	private String initialIndex;
	private String finalIndex;
	private ArrayList<AbstractCommand> listaFor;
	
	public CommandPara(String id, String initialIndex, String finalIndex, ArrayList<AbstractCommand> listaFor) {
		this.id = id;
		this.initialIndex = initialIndex;
		this.finalIndex = finalIndex;
		this.listaFor = listaFor;
	}
	
	@Override
	public String generateJavaCode() {
		StringBuilder str = new StringBuilder();
		
		str.append("for (" + id + " = " + initialIndex + "; i <= " + finalIndex + "; i++) {\n");
		for (AbstractCommand cmd : listaFor) {
			str.append(cmd.generateJavaCode());
		}
		str.append("}\n");
		
		return str.toString();
	}
	
	@Override
	public String toString() {
		return "CommandPara [id=" + id + ", initialIndex=" + initialIndex + ", finalIndex=" + finalIndex + ", lista=" + listaFor + "]";
	}
}
