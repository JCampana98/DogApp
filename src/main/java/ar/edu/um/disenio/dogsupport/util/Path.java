package ar.edu.um.disenio.dogsupport.util;

import lombok.Getter;

public class Path {
	
	public static class Web {
		@Getter public static final String INDEX		= "/";
		@Getter public static final String ABOUT		= "/about.html";
		@Getter public static final String CONTACT		= "/contact.html";
		@Getter public static final String ADOPT		= "/adopt.html";
		@Getter public static final String SEARCH 		= "/search.html";
		@Getter public static final String ADOPTCAN 	= "/adoptcan.html";
		@Getter public static final String ADDDOG		= "/adddog.html";
		@Getter public static final String VACCINES		= "/vaccines.html";
		@Getter public static final String DOGLIST		= "/doglist.html";
		@Getter public static final String NOT_FOUND	= "/404.html";
	}
	
	public static class Template {
		@Getter public static final String INDEX		= "index/index";
		@Getter public static final String ABOUT		= "about/about";
		@Getter public static final String CONTACT		= "contact/contact";
		@Getter public static final String ADOPT		= "adopt/adopt";
		@Getter public static final String SEARCH 		= "adopt/adopt";
		@Getter public static final String ADOPTCAN 	= "adopt/adoptcan";
		@Getter public static final String ADDDOG	 	= "adopt/adddog";
		@Getter public static final String VACCINES		= "vaccines/vaccines";
		@Getter public static final String DOGLIST		= "vaccines/doglist";
		@Getter public static final String NOT_FOUND	= "errors/404";
	}
}
