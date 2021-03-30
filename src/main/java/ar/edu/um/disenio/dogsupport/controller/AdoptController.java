package ar.edu.um.disenio.dogsupport.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ar.edu.um.disenio.dogsupport.entity.Cliente;
import ar.edu.um.disenio.dogsupport.entity.Edad;
import ar.edu.um.disenio.dogsupport.entity.Imagen;
import ar.edu.um.disenio.dogsupport.entity.Perro;
import ar.edu.um.disenio.dogsupport.entity.Sexo;
import ar.edu.um.disenio.dogsupport.entity.Tamanio;
import ar.edu.um.disenio.dogsupport.servicio.ClienteDAOImpl;
import ar.edu.um.disenio.dogsupport.servicio.Crud;
import ar.edu.um.disenio.dogsupport.servicio.ImagenDAOImpl;
import ar.edu.um.disenio.dogsupport.servicio.PerroDAOImpl;
import ar.edu.um.disenio.dogsupport.util.Path;
import ar.edu.um.disenio.dogsupport.util.ViewUtil;
import spark.Request;
import spark.Response;
import spark.Route;

public class AdoptController {
	

	private static final Logger logger = LoggerFactory.getLogger(AdoptController.class);
	public static final Route adoptPage = (Request request, Response response) -> {
		Crud<Perro, Integer> perro = new PerroDAOImpl();
		Map<String, Object> model = new HashMap<>();
		
		model.put("perros", perro.findAll());
		
		return ViewUtil.render(request, model, Path.Template.ADOPT);
	};
	
	public static final Route detailPage = (Request request, Response response) -> {
		Crud<Perro, Integer> perroService = new PerroDAOImpl();
		Crud<Imagen, Integer> imagenesService = new ImagenDAOImpl();
		Map<String, Object> model = new HashMap<>();
		Perro perro = perroService.findById(Integer.valueOf(request.queryParams("id")));
		
		model.put("imagenes", imagenesService.findAllByForeignKey("perro", perro));
		model.put("perro", perro);
		
		return ViewUtil.render(request, model, Path.Template.ADOPTCAN);
	};

	public static final Route addPage = (Request request, Response response) -> {
		Map<String, Object> model = new HashMap<>();
		
		model.put("perro", new Perro());
		
		return ViewUtil.render(request, model, Path.Template.ADDDOG);
	};
	
	public static final Route postPage = (Request request, Response response) -> {
		Perro perro = new Perro();
		Crud<Perro,Integer> crud = new PerroDAOImpl();
		Crud<Cliente,Integer> crudCliente = new ClienteDAOImpl();
		
		perro.setNombre(request.queryParams("nombreP"));
		perro.setTamanio(Tamanio.valueOf(request.queryParamOrDefault("tamanio", "")));
		perro.setEdad(Edad.valueOf(request.queryParamOrDefault("edad", "")));
		perro.setSexo(Sexo.valueOf(request.queryParamOrDefault("sexo", "")));
		perro.setRaza(request.queryParamOrDefault("raza", "Callejero"));
		perro.setDescripcion(request.queryParamOrDefault("descripcion", "No se proporcionaron datos para este perro."));
		perro.setAptoNinios(Boolean.valueOf(request.queryParamOrDefault("aptoNinios", "false")));
		perro.setAptoPerros(Boolean.valueOf(request.queryParamOrDefault("aptoPerros", "false")));
		perro.setEsterilizado(Boolean.valueOf(request.queryParamOrDefault("esterilizado", "false")));
		perro.setEntrenado(Boolean.valueOf(request.queryParamOrDefault("entrenado", "false")));
		perro.setIngresado(false);
		perro.setClienteIngreso(crudCliente.findById(1));
		
		logger.info("Datos del perro {}",perro);
		
		crud.create(perro);
		
		response.redirect(Path.Web.INDEX);
		return null;
	};
}
