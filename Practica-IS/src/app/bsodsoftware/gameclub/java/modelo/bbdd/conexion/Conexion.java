package app.bsodsoftware.gameclub.java.modelo.bbdd.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

// http://www.vogella.com/articles/EclipseDataToolsPlatform/article.html

public class Conexion {
	private static Connection conexion_bd = null;
	private static Statement sentencia = null;

	public void CrearConexion() {
		try {

			String driver = "org.apache.derby.jdbc.EmbeddedDriver";
			Class.forName(driver).newInstance();
			// C:\hlocal\git\IS-VideoClub\Practica-IS\db
			String db = "jdbc:derby:C:\\hlocal\\git\\IS-VideoClub\\Practica-IS\\db\\db\\db;create=true";
			conexion_bd = DriverManager.getConnection(db);
			System.out.println("Derby connection ok.");

		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
		}
	}

	public void Ejecutar_Consulta(String Consulta) {
		try {
			Statement stmt = conexion_bd.createStatement();
			stmt.executeQuery(Consulta);
			stmt.close();
		} catch (SQLException sqlExcept) {
			sqlExcept.printStackTrace();
		}
	}

	public static void main(String[] args) {

		Conexion c = new Conexion();
		c.CrearConexion();
		c.Ejecutar_Consulta("select * from  TROLLMILIO.tablatroll");

	}
}
