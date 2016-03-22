/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.inabif.controller;

/**
 *
 * @author Christopher
 */

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
public class EstadisticaRespController {

	@RequestMapping("/estadisticasrep")
	public String estadisticasrep(Map<String, Object> map, HttpServletRequest request,
			ModelMap model) {
            return "estadisticasrep";
	}
}
