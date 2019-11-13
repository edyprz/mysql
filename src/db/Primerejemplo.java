package db;
import java.io.IOException;
import java.sql.*;
public class Primerejemplo {
	public static void main (String[] args){
	
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexion = DriverManager.getConnection(
					"jdbc:mysql://localhost/Directorio","kevin","kevin");
			Statement s = conexion.createStatement();
			
			ResultSet rs = s.executeQuery("select * from alumnos");
			System.out.println("Nombre	Edad	Genero");
			while(rs.next()){
				System.out.println(rs.getString("nombre") + " " + rs.getInt("edad") + " " + 
						rs.getString("genero"));
			}
			conexion.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
}
