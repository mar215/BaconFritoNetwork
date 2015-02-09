package bacon.frito.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;



import javax.naming.NamingException;

import org.apache.tomcat.jdbc.pool.DataSource;

import bacon.frito.db.ContractClass.DatosGrupo;
import bacon.frito.db.ContractClass.DatosUsuario;
import bacon.frito.modelo.Usuario;

public class DbConstructor {
	
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
		String sSQL = "CREATE TABLE USUARIO ("
				+ "ID INTEGER, " + "nick varchar2(25) NOT NULL, " + "pass varchar2(25) NOT NULL, "
				+ "nombre varchar2(25), " + "apellidos varchar2(50), " + "telefono integer, "
				+ "sexo varchar2(25), " + "foto varchar2(100), " + "tipo varchar2(15) NOT NULL,"
				+ "PRIMARY KEY (ID))";
		oStmt.executeUpdate(sSQL);
		oStmt.close();
			
	}
	
	public void insertarUsuario(/*Datos*/Usuario user) throws SQLException, NamingException {
		
		Connection conexion=conectarDb();
		Statement oStmt=conexion.createStatement();
		
		user.getClass().equals(bacon.frito.modelo.UsuarioBacon.class);
		String sSQL = "INSERT INTO USUARIO("
				+ "(ID, NICK, PASS, NOMBRE, APELLIDOS, TELEFONO, SEXO, TIPO)"
				+ "VALUES (user.id, user.nick, user.pass, user.nombre, user.apellidos, "
				+ "user.telefono, user.sexo, 'usuariobacon')";
		oStmt.executeUpdate(sSQL);	
		oStmt.close();
	}
	
	public void eliminarUsuario(/*Datos*/Usuario user) throws NamingException, SQLException {
		Connection conexion=conectarDb();
		Statement oStmt=conexion.createStatement();
		
		String sSQL = "DELETE FROM USUARIO WHERE USUARIO.ROWID=user.id";
		oStmt.executeUpdate(sSQL);	
		oStmt.close();
	}
	
	public void crearTablaGrupo() throws SQLException, NamingException  {
		Connection conexion=conectarDb();
		Statement oStmt=conexion.createStatement();
		String sSQL = "CREATE TABLE GRUPO ("
				+ "ID INTEGER, " +  "nombre varchar2(25), " + "descripcion varchar2(500), "
				+ "imagen varchar2(100), " + "maxintegrantes integer, "
				+ "PRIMARY KEY (ID))";
		oStmt.executeUpdate(sSQL);
		oStmt.close();
			
	}
	
	public void insertarGrupo(/*Datos*/Grupo grup) throws NamingException, SQLException {
		Connection conexion=conectarDb();
		Statement oStmt=conexion.createStatement();
		String sSQL = "INSERT INTO GRUPO("
				+ "(ID, NOMBRE, DESCRIPCION, IMAGEN, MXINTEGRANTES)"
				+ "VALUES (grup.id, grup.nombre, grup.descripcion, grup.imagen, "
				+ "grup.maxintegrantes)";
		oStmt.executeUpdate(sSQL);	
		oStmt.close();	
	}
	
	public void eliminarGrupo(/*Datos*/Grupo grup) throws NamingException, SQLException {
		Connection conexion=conectarDb();
		Statement oStmt=conexion.createStatement();
		
		String sSQL = "DELETE FROM GRUPO WHERE GRUPO.ROWID=grup.id";
		oStmt.executeUpdate(sSQL);	
		oStmt.close();
	}
	
	public void crearTablaMensaje() throws NamingException, SQLException  {
		Connection conexion=conectarDb();
		Statement oStmt=conexion.createStatement();
		String sSQL = "CREATE TABLE MENSAJE ("
				+ "ID INTEGER, " +  "texto varchar2(500), " + "destino varchar2(25) NOT NULL, "
				+ "PRIMARY KEY (ID))";
		oStmt.executeUpdate(sSQL);
		oStmt.close();
			
	}
	
	public void insertarMensaje(/*Datos*/Mensaje sms) throws NamingException, SQLException {
		Connection conexion=conectarDb();
		Statement oStmt=conexion.createStatement();
		String sSQL = "INSERT INTO MENSAJE("
				+ "(ID, TEXTO, DESTINO)"
				+ "VALUES (sms.id, sms.texto, sms.destino)";
		oStmt.executeUpdate(sSQL);	
		oStmt.close();	
	}
	
	public void eliminarMensaje(/*Datos*/Mensaje sms) throws NamingException, SQLException {
		Connection conexion=conectarDb();
		Statement oStmt=conexion.createStatement();
		
		String sSQL = "DELETE FROM MENSAJE WHERE MENSAJE.ID=sms.id";
		oStmt.executeUpdate(sSQL);	
		oStmt.close();
	}
	
	public void crearTablaGrupoUsuario() throws SQLException, NamingException  {
		Connection conexion=conectarDb();
		Statement oStmt=conexion.createStatement();
		String sSQL = "CREATE TABLE GRUPOUSUARIO ("
				+ "IDUSUARIO INTEGER, " +  "IDGRUPO INTEGER, "
				+ "PRIMARY KEY (IDUSUARIO),"
				+ "PRIMARY KEY (IDUSUARIO))";
		oStmt.executeUpdate(sSQL);
		oStmt.close();
	}
	
	public void insertarGrupoUsuario(/*Datos*/GrupoUsuario grupuser) throws NamingException, SQLException {
		Connection conexion=conectarDb();
		Statement oStmt=conexion.createStatement();
		String sSQL = "INSERT INTO GRUPOUSUARIO("
				+ "(IDUSUARIO, IDGRUPO)"
				+ "VALUES (grupuser.idusuario, grupuser.idgrupo)";
		oStmt.executeUpdate(sSQL);	
		oStmt.close();	
	}
	
	public void eliminarGrupoUsuario(/*Datos*/GrupoUsuario grupuser) throws NamingException, SQLException {
		Connection conexion=conectarDb();
		Statement oStmt=conexion.createStatement();
		
		String sSQL = "DELETE FROM GRUPOUSUARIO WHERE GRUPOUSUARIO.ID=grupuser.id";
		oStmt.executeUpdate(sSQL);	
		oStmt.close();
	}
	
	
}
