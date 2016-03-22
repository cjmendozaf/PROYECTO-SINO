package pe.gob.inabif.seguridad;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import pe.gob.inabif.bean.Usuario;

public class ServiceContext {

	private static Logger log = LogManager.getLogger(ServiceContext.class
			.getName());

	private static ServiceContext instancia;

	private Usuario usuario = new Usuario();

	public ServiceContext() {

	}

	public ServiceContext getInstance() {
		try {
			HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes()).getRequest();
			HttpSession session = request.getSession();
			instancia = (ServiceContext) session.getAttribute("ServiceContext");
			return instancia;
		} catch (Exception e) {
			log.error(e);
			return null;
		}
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}