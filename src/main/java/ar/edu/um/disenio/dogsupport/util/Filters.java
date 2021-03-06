package ar.edu.um.disenio.dogsupport.util;

import spark.*;

public class Filters {
	public static Filter addFrailingSlashes = (Request request, Response response) -> {
		if (!request.pathInfo().endsWith("/")) {
			response.redirect(request.pathInfo() + "/");
		}
	};
	public static Filter addGzipHeader = (Request request, Response response) -> {
		response.header("Content-Encoding", "gzip");
	};
}
