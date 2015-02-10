package bacon.frito.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.tomcat.jdbc.pool.DataSource;

import com.sun.org.apache.xerces.internal.dom.DeferredAttrImpl;

import bacon.frito.db.ContractClass.DatosGrupo;
import bacon.frito.db.ContractClass.DatosGrupoUsuario;
import bacon.frito.db.ContractClass.DatosMensaje;
import bacon.frito.db.ContractClass.DatosUsuario;
import bacon.frito.modelo.Grupo;
import bacon.frito.modelo.GrupoUsuario;
import bacon.frito.modelo.Mensaje;
import bacon.frito.modelo.Usuario;
import bacon.frito.modelo.UsuarioBacon;

public class DbConstructor {
	
	private static DbConstructor instancia;
	
	static {
		instancia = new DbConstructor();
	}
	
	public DbConstructor getInstance(){
		return instancia;
	}
	
	private Connection conectarDb() throws NamingException, SQLException {		
		//Datasource para java
		DataSource miDS;
		Context ic = new InitialContext();
		miDS = (DataSource)ic.lookup("java:comp/env/jdbc/DatasourceLocal1");
		Connection conexion=null;
		conexion=miDS.getConnection();
		return conexion;
		
	}
	
	public void crearTablaUsuario() throws NamingException, SQLException  {
		Connection conexion=conectarDb();
		Statement oStmt=conexion.createStatement();
		String sSQL = Db.DATABASE_CREATE_USUARIO;
		oStmt.executeUpdate(sSQL);
		oStmt.close();
			
	}
	
	public void insertarUsuario(UsuarioBacon user) throws SQLException, NamingException {
		
		Connection conexion=conectarDb();
		Statement oStmt=conexion.createStatement();
		String sSQL;
		if(user.getClass().equals(bacon.frito.modelo.UsuarioBacon.class)){
			sSQL = "INSERT INTO " + DatosUsuario.TABLE_NAME + " ("
					+ DatosUsuario.COLUMNAS +") VALUES ("
					+ " " + user.getNombre()
					+ ", " + user.getApellidos()
					+ ", " + user.getTelefono()
					+ ", " + user.getBday()
					+ ", " + user.getSexo()
					+ ", " + user.getFoto()
					+ ", usuariobacon);";	
		} else {
			sSQL = "INSERT INTO " + DatosUsuario.TABLE_NAME + " ("
					+ DatosUsuario.COLUMNAS +") VALUES ("
					/////IMPORTANTE/////
					//NECESITAMOS INTRODUCIR EL VALOR DE LA SECUENCIA
					//PARA RELLENAR EL ID
					+ " " +  user.getNombre()
					+ ", " + user.getApellidos()
					+ ", " + user.getTelefono()
					+ ", " + user.getBday()
					+ ", " + user.getSexo()
					+ ", " + user.getFoto()
					+ ", usuariopremium);";	
		}
		oStmt.executeUpdate(sSQL);	
		oStmt.close();
	}
	
	public void eliminarUsuario(Usuario user) throws NamingException, SQLException {
		Connection conexion=conectarDb();
		Statement oStmt=conexion.createStatement();
		
		String sSQL = "DELETE "+ DatosUsuario.TABLE_NAME + "("
				+ "FROM USUARIO WHERE "
				+ ;
		oStmt.executeUpdate(sSQL);	
		oStmt.close();
	}
	
	public void crearTablaGrupo() throws SQLException, NamingException  {
		Connection conexion=conectarDb();
		Statement oStmt=conexion.createStatement();
		String sSQL = Db.DATABASE_CREATE_GRUPO;
		oStmt.executeUpdate(sSQL);
		oStmt.close();
			
	}
	
	public void insertarGrupo(Grupo grup) throws NamingException, SQLException {
		Connection conexion=conectarDb();
		Statement oStmt=conexion.createStatement();
		String sSQL = "INSERT INTO "+ DatosUsuario.TABLE_NAME + " ("
				+ DatosGrupo.COLUMNAS +") VALUES ("
				+ " " + grup.getNombre()
				+ ", " + grup.getDescripcion()
				+ ", " + grup.getImagen()
				+ ", " + grup.getMaxintegrantes()+");";		
		oStmt.executeUpdate(sSQL);	
		oStmt.close();	
	}
	
	public void eliminarGrupo(Grupo grup) throws NamingException, SQLException {
		Connection conexion=conectarDb();
		Statement oStmt=conexion.createStatement();
		
		String sSQL = "DELETE FROM GRUPO WHERE GRUPO.ROWID=grup.id";
		oStmt.executeUpdate(sSQL);	
		oStmt.close();
	}
	
	public void crearTablaMensaje() throws NamingException, SQLException  {
		Connection conexion=conectarDb();
		Statement oStmt=conexion.createStatement();
		String sSQL = Db.DATABASE_CREATE_MENSAJE;
		oStmt.executeUpdate(sSQL);
		oStmt.close();
			
	}
	
	public void insertarMensaje(Mensaje sms) throws NamingException, SQLException {
		Connection conexion=conectarDb();
		Statement oStmt=conexion.createStatement();
		String sSQL = "INSERT INTO " + DatosMensaje.TABLE_NAME + " ("
				+ DatosMensaje.COLUMNAS +") VALUES ("
				+ " " + sms.getTexto()
				+ ", " + sms.getDestino()+");";
		oStmt.executeUpdate(sSQL);	
		oStmt.close();	
	}
	
	public void eliminarMensaje(Mensaje sms) throws NamingException, SQLException {
		Connection conexion=conectarDb();
		Statement oStmt=conexion.createStatement();
		
		String sSQL = "DELETE FROM MENSAJE WHERE MENSAJE.ID=sms.id";
		oStmt.executeUpdate(sSQL);	
		oStmt.close();
	}
	
	public void crearTablaGrupoUsuario() throws SQLException, NamingException  {
		Connection conexion=conectarDb();
		Statement oStmt=conexion.createStatement();
		String sSQL = Db.DATABASE_CREATE_GRUPOUSUARIO;
		oStmt.executeUpdate(sSQL);
		oStmt.close();
	}
	
	public void insertarGrupoUsuario(GrupoUsuario grupuser) throws NamingException, SQLException {
		Connection conexion=conectarDb();
		Statement oStmt=conexion.createStatement();
		String sSQL = "INSERT INTO " + DatosGrupoUsuario.TABLE_NAME + "("
				+ " " + grupuser.getIdusuario()
				+ ", " + grupuser.getIdgrupo()+");";		
		oStmt.executeUpdate(sSQL);	
		oStmt.close();	
	}
	
	public void eliminarGrupoUsuario(GrupoUsuario grupuser) throws NamingException, SQLException {
		Connection conexion=conectarDb();
		Statement oStmt=conexion.createStatement();
		
		String sSQL = "DELETE FROM GRUPOUSUARIO WHERE GRUPOUSUARIO.ID=grupuser.id";
		oStmt.executeUpdate(sSQL);	
		oStmt.close();
	}
	
	
}
