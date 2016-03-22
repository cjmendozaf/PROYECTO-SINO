package pe.gob.inabif.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import pe.gob.inabif.seguridad.ServiceContext;
import pe.gob.inabif.service.OcurrenciaService;
import pe.gob.inabif.util.Constantes;

@Controller
public class InicioController {
	@Autowired
	private OcurrenciaService ocurrenciaService;
	private ServiceContext context;
	
	@RequestMapping("/inicio")
	public ModelAndView inicio(Map<String, Object> map, HttpServletRequest request,
			ModelMap model) {
		ModelAndView modelAndView = new ModelAndView();
		context = new ServiceContext().getInstance();
		if (context == null) {
			model.addAttribute("msj",
					"Su sesion a finalizado, vuelva a ingresar!!!");
			modelAndView.setViewName("redirect:login.html");
			return modelAndView;
		}
		return modelAndView;
	}	
	
	@RequestMapping(value = "/datosGrafico.htm", method = RequestMethod.POST)
	public @ResponseBody String datosGrafico(@RequestParam String id) {
		String json = Constantes.FIN_SESSION;
		try {
			context = new ServiceContext().getInstance();
			if (context == null) {
				return json;
			}		
			json = ocurrenciaService.datosGrafico();
		} catch (Exception e) {
			e.printStackTrace();
			json = Constantes.ERROR;
		}
		return json;
	}
	
}