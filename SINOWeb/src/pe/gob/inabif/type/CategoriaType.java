package pe.gob.inabif.type;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum CategoriaType {	
	CATEGORIA_1("01", "Categoria 1"),
	CATEGORIA_2("02", "Categoria 2"); 
	
	private String key;
	private String value;

	private static final List<CategoriaType> list = new ArrayList<CategoriaType>();
	private static final Map<String, CategoriaType> lookup = new HashMap<String, CategoriaType>();

	static {
		for (CategoriaType s : EnumSet.allOf(CategoriaType.class)) {
			list.add(s);
			lookup.put(s.getKey(), s);
		}
	}

	private CategoriaType(String key, String value) {
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}

	public static CategoriaType get(int key) {
		return lookup.get(key);
	}
}
