package pe.gob.inabif.type;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum TipoType {	
	TIPO_INTERVENCION(1, "Administrativa"),
	TIPO_ADMINISRATIVA(2, "Intervercion"); 	
	
	private int key;
	private String value;

	private static final List<TipoType> list = new ArrayList<TipoType>();
	private static final Map<Integer, TipoType> lookup = new HashMap<Integer, TipoType>();

	static {
		for (TipoType s : EnumSet.allOf(TipoType.class)) {
			list.add(s);
			lookup.put(s.getKey(), s);
		}
	}

	private TipoType(int key, String value) {
		this.key = key;
		this.value = value;
	}

	public int getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}

	public static TipoType get(int key) {
		return lookup.get(key);
	}
}
