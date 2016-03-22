package pe.gob.inabif.controller;

import java.util.ArrayList;
import java.util.List;
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

import pe.gob.inabif.bean.ClaveValor;
import pe.gob.inabif.bean.Ocurrencia;
import pe.gob.inabif.seguridad.ServiceContext;
import pe.gob.inabif.service.OcurrenciaService;
import pe.gob.inabif.type.TipoType;
import pe.gob.inabif.util.Constantes;

import com.google.gson.Gson;

@Controller
public class SeguimientoController {

	@Autowired
	private OcurrenciaService ocurrenciaService;
	private ServiceContext context;
	
	@RequestMapping("/seguimiento")
	public ModelAndView Seguimiento(Map<String, Object> map,
			HttpServletRequest request, ModelMap model) {
		ModelAndView modelAndView = new ModelAndView();
		context = new ServiceContext().getInstance();
		if (context == null) {
			model.addAttribute("msj",
					"Su sesion a finalizado, vuelva a ingresar!!!");
			modelAndView.setViewName("redirect:login.html");
			return modelAndView;
		}		
		map.put("ocurrencia", new Ocurrencia());
		return modelAndView;
	}

	@RequestMapping(value = "/listarTipo.htm", method = RequestMethod.GET)
	public @ResponseBody String listarTipo(ModelMap modelo) {

		List<ClaveValor> lista = null;
		ClaveValor claveValor = null;
		Gson gson = null;
		String json = "[]";
		try {
			lista = new ArrayList<ClaveValor>();
			for (TipoType o : TipoType.values()) {
				claveValor = new ClaveValor();
				claveValor.setClave(o.getKey());
				claveValor.setValor(o.getValue());
				lista.add(claveValor);
			}
			gson = new Gson();
			json = gson.toJson(lista);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json;
	}

	@RequestMapping(value = "/listarCategoria.htm", method = RequestMethod.GET)
	public @ResponseBody String listarCategoria(@RequestParam String tipo, ModelMap modelo) {
		String json = "[]";
		try {
			json = ocurrenciaService.obtenerCategoria(tipo);		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json;
	}

	@RequestMapping(value = "/listarSubCategoria.htm", method = RequestMethod.GET)
	public @ResponseBody String listarSubCategoria(@RequestParam String categoria, ModelMap modelo) {
		String json = "[]";
		try {
			json = ocurrenciaService.obtenerSubCategoria(categoria);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json;
	}

	@RequestMapping(value = "/guardarOcurrencia.htm", method = RequestMethod.POST)
	public @ResponseBody String guardarOcurrencia(
			@ModelAttribute("ocurrencia") Ocurrencia ocurrencia, HttpSession session, HttpServletRequest request) {
		String json = Constantes.FIN_SESSION;
		try {
			context = new ServiceContext().getInstance();
			if (context == null) {
				return json;
			}		
			json = ocurrenciaService.guardarOcurrencia(ocurrencia, context.getUsuario());	
		} catch (Exception e) {
			e.printStackTrace();
			json = Constantes.ERROR;
		}
		return json;
	}
}