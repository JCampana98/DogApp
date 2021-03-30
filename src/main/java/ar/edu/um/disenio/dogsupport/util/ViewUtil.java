package ar.edu.um.disenio.dogsupport.util;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jetty.http.HttpStatus;

import spark.*;
import spark.template.thymeleaf.ThymeleafTemplateEngine;

public class ViewUtil {
	
	public static Route routeNotFound = (Request request, Response response) ->{
		response.status(HttpStatus.NOT_FOUND_404);
		return render(request, new HashMap<>(), Path.Template.NOT_FOUND);
	};
	
	public static String render(Request request, Map<String, Object> model, String templatePath) {
		return templateEngine().render(new ModelAndView(model, templatePath));
	}
	
	private static ThymeleafTemplateEngine templateEngine() {
		return new ThymeleafTemplateEngine();
	}
	
}
