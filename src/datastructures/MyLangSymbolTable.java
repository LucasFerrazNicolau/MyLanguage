package datastructures;

import java.util.HashMap;

public class MyLangSymbolTable {
	private HashMap<String, MyLangSymbol> map;
	
	public MyLangSymbolTable() {
		map = new HashMap<String, MyLangSymbol>();
	}
	
	public void add(MyLangSymbol symbol) {
		map.put(symbol.getName(), symbol);
	}
	
	public boolean exists(String symbolName) {
		return map.get(symbolName) != null;
	}
	
	public MyLangSymbol get(String symbolName) {
		return map.get(symbolName);
	}
}
