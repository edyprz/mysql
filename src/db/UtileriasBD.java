package db;
import java.sql.*;
public class UtileriasBD {
	//metodo para conectarse a la bd
	Connection obtieneConexion(String URL, String nombreBD,String usuario,String pass){
		Connection bd = null;
		try{
			Class.forName("com.mysql.jbdc.Driver");
			String URLBD = URL + "/" + nombreBD;
			bd = DriverManager.getConnection(URLBD,usuario,pass);
		}catch(SQLException | ClassNotFoundException e){
			e.printStackTrace();
		}
		return bd;
	}
	
	//metodo para registrar estudiantes en la bd
	public void registraEstudiantes(Connection con,Estudiante ind){
		try{
			Statement stm = con.createStatement();
			String sql = "INSERT INTO REGISTRO VALUES (" + ind.getId() + ", " + ind.getNombre() + 
					". " + ind.getCarrera() + ", " + ind.getGenero() + ", " + 
					ind.getPeso() + ", " +
					ind.getEstatura() + ", " + 
					ind.getEdad() + ")";
			System.out.println(sql);
			stm.executeUpdate(sql);
		}catch(SQLException se){
			se.printStackTrace();
		}
	}
	
	//metodo para eliminar un registro por su id
	public void eliminaEstudiante(Connection con, int id){
		try{
			String sql = "DELETE FROM REGISTRO WHERE id = " + id;
			Statement stm = con.createStatement();
			stm.executeUpdate(sql);
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
		
	//metodo que devuelve true si el id existe
		public boolean idExiste(Connection con,int id){
			boolean res = false;
			try{
				Statement stm = con.createStatement();
				String sql = "SELECT * FROM REGISTRO WHERE id = " +id;
				ResultSet rs = stm.executeQuery(sql);
				if(rs.next()){
					if(rs.getInt("Id")==id){
						res = true;
					}
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
			return res;
		}
	
	//metodo que devuelve el nombre dado un id
		public String leeNombre(Connection con, int id){
			String nom = "";
			try{
				Statement stm = con.createStatement();
				String sql = "SELECT nombre FROM REGISTRO WHERE id = " + id;
				ResultSet rs = stm.executeQuery(sql);
				if(rs.next()){
					nom = rs.getString("nombre");
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
			return nom;
		}
		
	//metodo para realizar una consulta generica
		public String [] consultaRegistro(Connection con){
			String[] res = null;
			try{
				Statement stm = con.createStatement();
				String sql = "SELECT * FROM REGISTRO";
				ResultSet rs = stm.executeQuery(sql);
				int numRegistros = 0;
				while(rs.next()){
					numRegistros++;   
				}
				
				res = new String[numRegistros];
				int i = 0;
				rs.beforeFirst();
				while(rs.next()){
					res[i] = rs.getInt("id") + " " +
				rs.getString("nombre") + " " +
				rs.getString("carrera") + " " +
				rs.getString("genero") + " " +
				rs.getFloat("peso") + " " +
				rs.getFloat("estatura") + " " +
				rs.getFloat("edad");
					i++;
				}
				
			}catch(SQLException e){
				e.printStackTrace();
			}
			return res;
		}
	//metodo que realiza una consulta por carrera
		public String[] consultaPorCarrera(Connection con, String carrera){
			String[] res = null;
			try{
				Statement stm = con.createStatement();
				String sql = "SELECT * FROM REGISTRO WHERE CARRERA LIKE ´%" + carrera + "%´";
				ResultSet rs = stm.executeQuery(sql);
				int numRegistros = 0;
				while(rs.next()){
					numRegistros++;
				}
				res = new String[numRegistros];
				int i=0;
				rs.beforeFirst();
				while(rs.next()){
					res[i] = rs.getInt("id") + " " +
							rs.getString("nombre") + " " +
							rs.getString("carrera") + " " +
							rs.getString("genero") + " " +
							rs.getFloat("peso") + " " +
							rs.getFloat("estatura") + " " +
							rs.getFloat("edad");
							i++;					
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
			
			return res;
		}
		
}
