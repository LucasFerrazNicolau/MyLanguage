package datastructures;

public class MyLangVariable extends MyLangSymbol {
	public static final int NUMBER = 0;
	public static final int TEXT = 1;
	
	private int type;
	private String value;
	
	public MyLangVariable(String name, int type, String value) {
		super(name);
		this.setType(type);
		this.setValue(value);
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "MyLangVariable [name=" + name + ", type=" + type + ", value=" + value + "]";
	}
}