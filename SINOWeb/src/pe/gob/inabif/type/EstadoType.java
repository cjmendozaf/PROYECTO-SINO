package pe.gob.inabif.type;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum EstadoType {
	REGISTRAR(1, "Nueva"),
	VALIDAR(2, "Validada"),
	NO_CORRESPONDE(3, "No es ocurrencia"),
	ATENDIDA(4, "Atendida"),
	PROCESO_ACCION(5, "En Proceso"),	
	CERRADA(6, "Cerrada"),
	SUSPENDIDA_DENEGAR(7, "Suspendida");
		
	private int key;
	private String value;

	private static final List<EstadoType> list = new ArrayList<EstadoType>();
	private static final Map<Integer, EstadoType> lookup = new HashMap<Integer, EstadoType>();

	static {
		for (EstadoType s : EnumSet.allOf(EstadoType.class)) {
			list.add(s);
			lookup.put(s.getKey(), s);
		}
	}

	private EstadoType(int key, String value) {
		this.key = key;
		this.value = value;
	}

	public int getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}

	public static EstadoType get(int key) {
		return lookup.get(key);
	}
}
