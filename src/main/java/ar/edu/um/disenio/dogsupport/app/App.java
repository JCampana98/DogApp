package ar.edu.um.disenio.dogsupport.app;

import ar.edu.um.disenio.dogsupport.controller.AdoptController;
import ar.edu.um.disenio.dogsupport.controller.IndexController;
import ar.edu.um.disenio.dogsupport.controller.SearchController;
import ar.edu.um.disenio.dogsupport.controller.VaccineController;
import ar.edu.um.disenio.dogsupport.util.Filters;
import ar.edu.um.disenio.dogsupport.util.Path;
import ar.edu.um.disenio.dogsupport.util.ViewUtil;

import static spark.Spark.*;
import static spark.debug.DebugScreen.*;

public class App {

	public static void main(String[] args) {
		//Configure Spark
		port(8080);
		staticFiles.location("/public");
		staticFiles.expireTime(600L);
		enableDebugScreen();
		
		//Set routes
		get(Path.Web.INDEX,		IndexController.indexPage);
		get(Path.Web.ADOPT,		AdoptController.adoptPage);
		get(Path.Web.SEARCH,	SearchController.searchDog);
		get(Path.Web.ADOPTCAN,	AdoptController.detailPage);
		get(Path.Web.ADDDOG,	AdoptController.addPage);
		post(Path.Web.ADDDOG,	AdoptController.postPage);
		get(Path.Web.VACCINES,	VaccineController.vaccinesPage);
		get(Path.Web.DOGLIST,	VaccineController.detailPage);
		get("*",				ViewUtil.routeNotFound);
		
		//Set up after-filters (Called after each get/post)
		after("*",				Filters.addGzipHeader);
	}

}
