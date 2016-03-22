package pe.gob.inabif.type;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum SubCategoriaType {	
	SUB_CATEGORIA_1("01", "Sub Categoria 1"),
	SUB_CATEGORIA_2("02", "Sub Categoria 2"); 
	
	private String key;
	private String value;

	private static final List<SubCategoriaType> list = new ArrayList<SubCategoriaType>();
	private static final Map<String, SubCategoriaType> lookup = new HashMap<String, SubCategoriaType>();

	static {
		for (SubCategoriaType s : EnumSet.allOf(SubCategoriaType.class)) {
			list.add(s);
			lookup.put(s.getKey(), s);
		}
	}

	private SubCategoriaType(String key, String value) {
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}

	public static SubCategoriaType get(int key) {
		return lookup.get(key);
	}
}
