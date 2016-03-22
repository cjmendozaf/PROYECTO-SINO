package pe.gob.inabif.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import pe.gob.inabif.bean.Estadistica;
import pe.gob.inabif.seguridad.ServiceContext;
import pe.gob.inabif.service.OcurrenciaService;
import pe.gob.inabif.util.Constantes;

@Controller
public class EstadisticaController {

	@Autowired
	private OcurrenciaService ocurrenciaService;
	private ServiceContext context;

	@RequestMapping("/estadisticas")
	public ModelAndView estadisticas(Map<String, Object> map,
			HttpServletRequest request, HttpSession session, ModelMap model) {
		ModelAndView modelAndView = new ModelAndView();
		context = new ServiceContext().getInstance();
		if (context == null) {
			model.addAttribute("msj",
					"Su sesion a finalizado, vuelva a ingresar!!!");
			modelAndView.setViewName("redirect:login.html");
			return modelAndView;
		}		
		map.put("estadistica", new Estadistica());
		return modelAndView;
	}

	@RequestMapping(value = "/buscarEstadistica.htm", method = RequestMethod.POST)
	public @ResponseBody String buscarEstadistica(
			@ModelAttribute("estadistica") Estadistica estadistica) {
		String json = Constantes.FIN_SESSION;
		try {
			context = new ServiceContext().getInstance();
			if (context == null) {
				return json;
			}		
			json = ocurrenciaService.buscarEstadistica(estadistica, context.getUsuario());
		} catch (Exception e) {
			e.printStackTrace();
			json = Constantes.ERROR;
		}
		return json;
	}

	@RequestMapping(value = "/verDetalleEstadistica.htm", method = RequestMethod.POST)
	public @ResponseBody String verEstadistica(@RequestParam String id) {
		String json = Constantes.FIN_SESSION;
		try {
			context = new ServiceContext().getInstance();
			if (context == null) {
				return json;
			}		
			json = ocurrenciaService.verDetalle(Integer.parseInt(id));
		} catch (Exception e) {
			e.printStackTrace();
			json = Constantes.ERROR;
		}
		return json;
	}	
	
	@RequestMapping(value = "/validarEstadistica.htm", method = RequestMethod.POST)
	public @ResponseBody String validarEstadistica(@RequestParam String id) {
		String json = Constantes.FIN_SESSION;
		try {
			context = new ServiceContext().getInstance();
			if (context == null) {
				return json;
			}		
			json = ocurrenciaService.validarEstadistica(Integer.parseInt(id), context.getUsuario());
		} catch (Exception e) {
			e.printStackTrace();
			json = Constantes.ERROR;
		}
		return json;
	}
	
	
	@RequestMapping(value = "/noCorrespondeEnviarEstadistica.htm", method = RequestMethod.POST)
	public @ResponseBody String noCorrespondeEnviarEstadistica(@RequestParam String id, @RequestParam String detalle) {
		String json = Constantes.FIN_SESSION;
		try {
			context = new ServiceContext().getInstance();
			if (context == null) {
				return json;
			}		
			return ocurrenciaService.enviarNoCorrespondeEstadistica(id, detalle, context.getUsuario());
		} catch (Exception e) {
			e.printStackTrace();
			json = Constantes.ERROR;
		}
		return json;
	}
	
	
	@RequestMapping(value = "/atendidoAtendidaEstadistica.htm", method = RequestMethod.POST)
	public @ResponseBody String atendidoAtendidaEstadistica(@RequestParam String id) {
		String json = Constantes.FIN_SESSION;
		try {
			context = new ServiceContext().getInstance();
			if (context == null) {
				return json;
			}		
			return ocurrenciaService.atendidoEstadistica(Integer.parseInt(id), context.getUsuario());
		} catch (Exception e) {
			e.printStackTrace();
			json = Constantes.ERROR;
		}
		return json;
	}
	
	@RequestMapping(value = "/registrarAccionAtendidaEstadistica.htm", method = RequestMethod.POST)
	public @ResponseBody String registrarAccionAtendidaEstadistica(@RequestParam String id, @RequestParam String detalle) {
		String json = Constantes.FIN_SESSION;
		try {
			context = new ServiceContext().getInstance();
			if (context == null) {
				return json;
			}		
			return ocurrenciaService.enviarRegistrarAccionAtendidaEstadistica(id, detalle, context.getUsuario());
		} catch (Exception e) {
			e.printStackTrace();
			json = Constantes.ERROR;
		}
		return json;
	}
	
	@RequestMapping(value = "/cerrarOcurrenciaArgumentoSuspendidaEstadistica.htm", method = RequestMethod.POST)
	public @ResponseBody String cerrarOcurrenciaArgumentoSuspendidaEstadistica(@RequestParam String id) {
		String json = Constantes.FIN_SESSION;
		try {
			context = new ServiceContext().getInstance();
			if (context == null) {
				return json;
			}		
			return ocurrenciaService.cerrarOcurrenciaEstadistica(Integer.parseInt(id), context.getUsuario());
		} catch (Exception e) {
			e.printStackTrace();
			json = Constantes.ERROR;
		}
		return json;		
	}
	
	@RequestMapping(value = "/enviarDenegarSuspendidaEstadistica.htm", method = RequestMethod.POST)
	public @ResponseBody String enviarDenegarSuspendidaEstadistica(@RequestParam String id, @RequestParam String detalle) {
		String json = Constantes.FIN_SESSION;
		try {
			context = new ServiceContext().getInstance();
			if (context == null) {
				return json;
			}		
			return ocurrenciaService.enviarDenegarArgumentoSuspendidaEstadistica(id, detalle, context.getUsuario());
		} catch (Exception e) {
			e.printStackTrace();
			json = Constantes.ERROR;
		}
		return json;
	}
}