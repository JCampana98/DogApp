package ar.edu.um.disenio.dogsupport.controller;

import java.util.HashMap;
import java.util.Map;

import ar.edu.um.disenio.dogsupport.entity.Perro;
import ar.edu.um.disenio.dogsupport.servicio.Crud;
import ar.edu.um.disenio.dogsupport.servicio.PerroDAOImpl;
import ar.edu.um.disenio.dogsupport.util.Path;
import ar.edu.um.disenio.dogsupport.util.ViewUtil;
import spark.Request;
import spark.Response;
import spark.Route;

public class SearchController {

	public static final Route searchDog = (Request request, Response response) -> {
		Crud<Perro, Integer> servicioSearch = new PerroDAOImpl();
		Map<String, Object> model = new HashMap<>();
		
		
		model.put("perros", servicioSearch.findByQuery("nombre",request.queryParams("nombre")));
		
		return ViewUtil.render(request, model, Path.Template.ADOPT);
	};
}
