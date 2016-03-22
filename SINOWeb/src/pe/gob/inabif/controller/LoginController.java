package pe.gob.inabif.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pe.gob.inabif.bean.Usuario;
import pe.gob.inabif.seguridad.ServiceContext;

@Controller
public class LoginController {
	private ServiceContext context;
	
	@RequestMapping("/login")
	public String login(Map<String, Object> map,
			HttpServletRequest request, ModelMap model) {		
		return "login";
	}
	
	@RequestMapping("/validar")
	public String estadisticas(@RequestParam int id, @RequestParam int perfil, HttpSession session, HttpServletRequest request) {		
		
		context = (ServiceContext) session.getAttribute("ServiceContext");
		if (context == null) {
    		context = new ServiceContext();
    	} else {
    		session.removeAttribute("ServiceContext");
    	}
		
		Usuario usuario = new Usuario();
		usuario.setIdUsuario(id);
		usuario.setPerfil(perfil);
		
		if(id==1) { // rol 1:registra, 3:atiende				
			usuario.setRol("1");
		} else if(id==2){ // rol 2:valida, 4:cerrar
			usuario.setRol("2");
		} else
			usuario.setRol("3"); // rol ver
		
		context.setUsuario(usuario);
				
		session.setAttribute("ServiceContext", context);
		session.setAttribute("rol", context.getUsuario().getRol());
		return "inicio";
	}
	
	@RequestMapping("/direccionarLogin")
	public String loginSesion(Map<String, Object> map,
			HttpServletRequest request, ModelMap model) {	
		request.setAttribute("msj", "Su sesion ha expirado");
		return "login";
	}
}