package ar.edu.um.disenio.dogsupport.controller;

import java.util.HashMap;
import java.util.Map;

import ar.edu.um.disenio.dogsupport.entity.Slide;
import ar.edu.um.disenio.dogsupport.servicio.Crud;
import ar.edu.um.disenio.dogsupport.servicio.SlideDAOImpl;
import ar.edu.um.disenio.dogsupport.util.Path;
import ar.edu.um.disenio.dogsupport.util.ViewUtil;
import spark.Request;
import spark.Response;
import spark.Route;

public class IndexController {
	public static Route indexPage = (Request request, Response response) -> {
		Crud<Slide, Integer> slides = new SlideDAOImpl();
		Map<String, Object> model = new HashMap<>();
		
		model.put("slides", slides.findAll());
		
		return ViewUtil.render(request, model, Path.Template.INDEX);
	};
}
