package ar.edu.um.disenio.dogsupport.controller;

import java.util.HashMap;
import java.util.Map;

import ar.edu.um.disenio.dogsupport.entity.Vacuna;
import ar.edu.um.disenio.dogsupport.entity.Vacunacion;
import ar.edu.um.disenio.dogsupport.servicio.Crud;
import ar.edu.um.disenio.dogsupport.servicio.VacunaDAOImpl;
import ar.edu.um.disenio.dogsupport.servicio.VacunacionDAOImpl;
import ar.edu.um.disenio.dogsupport.util.Path;
import ar.edu.um.disenio.dogsupport.util.ViewUtil;
import spark.Request;
import spark.Response;
import spark.Route;

public class VaccineController {
	public static final Route vaccinesPage = (Request request, Response response) -> {
		Crud<Vacuna, Integer> vacuna = new VacunaDAOImpl();
		Map<String, Object> model = new HashMap<>();
		
		model.put("vacunas", vacuna.findAll());
		
		return ViewUtil.render(request, model, Path.Template.VACCINES);
	};
	
	public static final Route detailPage = (Request request, Response response) -> {
		Crud<Vacunacion, Integer> vacunacionService = new VacunacionDAOImpl();
		Crud<Vacuna, Integer> vacunaService = new VacunaDAOImpl();
		Map<String, Object> model = new HashMap<>();
		Vacuna vacuna = vacunaService.findById(Integer.valueOf(request.queryParams("id")));
		
		model.put("vacuna", vacuna);
		model.put("vacunacion", vacunacionService.findAllByForeignKey("vacuna", vacuna));
		
		return ViewUtil.render(request, model, Path.Template.DOGLIST);
	};
}
