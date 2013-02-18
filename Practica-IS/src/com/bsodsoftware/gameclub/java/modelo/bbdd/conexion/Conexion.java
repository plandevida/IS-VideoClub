//package com.bsodsoftware.gameclub.java.modelo.bbdd.conexion;
//
//import java.sql.*;
//
//import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
//public class Conexion {
//
//private Connection conexion;
//private Statement st;
//	
//	/**
//	 * Crea la conexion y el Statement
//	 * @throws SQLException
//	 */
//	public Conexion() throws SQLException{
//		
//		MysqlDataSource dataSource = new MysqlDataSource();
//		dataSource.setUser("root");
//		dataSource.setPassword("root");
//		dataSource.setDatabaseName("mydb");
//		dataSource.setServerName("localhost");
//
//		try {
//			 conexion = dataSource.getConnection();
//			 st = conexion.createStatement();
//			 
//		} catch (SQLException e) {
//			
//			throw e;
//		}
//	}
//	
//	/**
//	 * Ejecuta Query pasandole la instruccion. Lanza SQLException
//	 * Devuelve un ResultSet con el resultado
//	 * 
//	 * @return Lista de resultados de la consulta.
//	 */
//	public ResultSet query(String query)throws SQLException{
//		
//		ResultSet rs = null;
//			try {
//				
//				rs = st.executeQuery(query);
//				
//			} catch (SQLException e) {
//
//				throw e;
//			}
//			
//		return rs;
//	}
//	
//	
//	/**
//	 * Ejecuta Query pasandole la instruccion. Lanza SQLException
//	 * Devuelve falso si no se puede ejecutar
//	 * 
//	 * @param query La consulta a ejecutar
//	 * @return Si se actualiz� correctamente.
//	 * @throws SQLException
//	 */
//	
//	public boolean update(String query)throws SQLException{
//		boolean resul = true;
//			try {
//				
//				st.executeUpdate(query);
//				
//			} catch (SQLException e) {
//				
//				resul = false;
//				throw e;
//								
//			}
//		return resul;
//	}
//	
//	/**
//	 * Cierra la conexión de la base de datos
//	 * 
//	 * @return true si se cerró correctamente
//	 * @throws SQLException
//	 */
//	public boolean cerrar() throws SQLException{
//		boolean resul = true;
//		try {
//			
//			conexion.close();
//			
//		} catch (SQLException e) {
//
//			resul = false;
//			throw e;
//			
//		}
//		return resul;
//	}
//	
//	
//	public static void main(String[] args) {
//
//		try {
//			
//			Conexion conexion = new Conexion();
//			conexion.cerrar();
//		} catch (SQLException e) {
//
//			e.printStackTrace();
//			
//		}
//	}
//}