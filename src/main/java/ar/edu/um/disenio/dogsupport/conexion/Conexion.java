package ar.edu.um.disenio.dogsupport.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import ar.edu.um.disenio.dogsupport.util.PropertiesObtainer;

public class Conexion {
	private static Statement statement;
	private static String USUARIO;
	private static String PASSWORD;
	private static String PUERTO;
	private static String URL;
	private static String BASEDEDATOS;
	
	
	private Conexion(){
		USUARIO = PropertiesObtainer.getInstance().getPropiedad("user");
		PASSWORD = PropertiesObtainer.getInstance().getPropiedad("password");
		PUERTO = PropertiesObtainer.getInstance().getPropiedad("puerto");
		URL = PropertiesObtainer.getInstance().getPropiedad("url");
		BASEDEDATOS = PropertiesObtainer.getInstance().getPropiedad("basededatos");
		statement = setStatement();
	}
	
	private Statement setStatement() {
		String url = URL + ":" + PUERTO + "/" + BASEDEDATOS + "?useSSL=false"; 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, USUARIO, PASSWORD);
			Statement state = conn.createStatement();
			return state;
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static Statement getStatement() {
		return statement;
	}
	
	public static Connection getConnection() throws SQLException {
		return statement.getConnection();
	}
	
	private static class DBManager{
		private static final Conexion INSTANCE = new Conexion();
		
	}
	
	public static Conexion getInstance(){
		try {
			return DBManager.INSTANCE;
		} catch (ExceptionInInitializerError ex) {
			
		}
		return null;
	}
}
