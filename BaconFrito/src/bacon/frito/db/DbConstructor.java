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
				+ DatosUsuario.COLUMN_NAME_ID + " NUMBER(6), " 
				+ DatosUsuario.COLUMN_NAME_NICK + "varchar2(25) NOT NULL, "
				+ DatosUsuario.COLUMN_NAME_PASS + "varchar2(25) NOT NULL, "
				+ DatosUsuario.COLUMN_NAME_NOMBRE + "varchar2(25), "
				+ DatosUsuario.COLUMN_NAME_APELLIDOS + "varchar2(50), "
				+ DatosUsuario.COLUMN_NAME_TELEFONO + "number(15), "
				+ DatosUsuario.COLUMN_NAME_BDAY + "varchar2(10), "
				+ DatosUsuario.COLUMN_NAME_SEXO + "varchar2(25), "
				+ DatosUsuario.COLUMN_NAME_FOTO + "varchar2(100), " 
				+ DatosUsuario.COLUMN_NAME_TIPO + "varchar2(15) NOT NULL,"
				+ "PRIMARY KEY (ID));";
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
					+ DatosUsuario.COLUMN_NAME_NOMBRE 		+ " " + user.getNombre()
					+ DatosUsuario.COLUMN_NAME_APELLIDOS 	+ " " + user.getApellidos()
					+ DatosUsuario.COLUMN_NAME_TELEFONO		+ " " + user.getTelefono()
					+ DatosUsuario.COLUMN_NAME_BDAY			+ " " + user.getBday()
					+ DatosUsuario.COLUMN_NAME_SEXO			+ " " + user.getSexo()
					+ DatosUsuario.COLUMN_NAME_FOTO			+ " " + user.getFoto()
					+ DatosUsuario.COLUMN_NAME_TIPO			+ "usuariobacon);";	
		} else {
			sSQL = "INSERT INTO " + DatosUsuario.TABLE_NAME + " ("
					+ DatosUsuario.COLUMNAS +") VALUES ("
					+ DatosUsuario.COLUMN_NAME_NOMBRE 		+ " " + user.getNombre()
					+ DatosUsuario.COLUMN_NAME_APELLIDOS 	+ " " + user.getApellidos()
					+ DatosUsuario.COLUMN_NAME_TELEFONO		+ " " + user.getTelefono()
					+ DatosUsuario.COLUMN_NAME_BDAY			+ " " + user.getBday()
					+ DatosUsuario.COLUMN_NAME_SEXO			+ " " + user.getSexo()
					+ DatosUsuario.COLUMN_NAME_FOTO			+ " " + user.getFoto()
					+ DatosUsuario.COLUMN_NAME_TIPO			+ "usuariopremium);";	
		}
		oStmt.executeUpdate(sSQL);	
		oStmt.close();
	}
	
	public void eliminarUsuario(Usuario user) throws NamingException, SQLException {
		Connection conexion=conectarDb();
		Statement oStmt=conexion.createStatement();
		
		String sSQL = "DELETE FROM USUARIO WHERE ";
		oStmt.executeUpdate(sSQL);	
		oStmt.close();
	}
	
	public void crearTablaGrupo() throws SQLException, NamingException  {
		Connection conexion=conectarDb();
		Statement oStmt=conexion.createStatement();
		String sSQL = "CREATE TABLE GRUPO ("
				+ DatosGrupo.TABLE_NAME						+ " ("
				+ DatosGrupo.COLUMN_NAME_ID					+ "number(6),"
				+ DatosGrupo.COLUMN_NAME_NOMBRE				+ "varchar2(25), "
				+ DatosGrupo.COLUMN_NAME_DESCRIPCION		+ "varchar2(500), "
				+ DatosGrupo.COLUMN_NAME_IMAGEN				+ "varchar2(100), "
				+ DatosGrupo.COLUMN_NAME_MAXINTEGRANTES		+ "number(3)"
				+ "PRIMARY KEY (ID));";
		oStmt.executeUpdate(sSQL);
		oStmt.close();
			
	}
	
	public void insertarGrupo(Grupo grup) throws NamingException, SQLException {
		Connection conexion=conectarDb();
		Statement oStmt=conexion.createStatement();
		String sSQL = "INSERT INTO "+ DatosUsuario.TABLE_NAME + " ("
				+ DatosGrupo.COLUMNAS +") VALUES ("
				+ DatosGrupo.COLUMN_NAME_NOMBRE				+ " " + grup.getNombre()
				+ DatosGrupo.COLUMN_NAME_DESCRIPCION		+ " " + grup.getDescripcion()
				+ DatosGrupo.COLUMN_NAME_IMAGEN				+ " " + grup.getImagen()
				+ DatosGrupo.COLUMN_NAME_MAXINTEGRANTES		+ " " + grup.getMaxintegrantes()+");";		
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
		String sSQL = "CREATE TABLE MENSAJE (" 
				+ DatosMensaje.COLUMN_NAME_TEXTO			+ "varchar2(500), "
				+ DatosMensaje.COLUMN_NAME_DESTINO			+ "varchar2(25) NOT NULL)"
				+ "PRIMARY KEY (ID));";
		oStmt.executeUpdate(sSQL);
		oStmt.close();
			
	}
	
	public void insertarMensaje(Mensaje sms) throws NamingException, SQLException {
		Connection conexion=conectarDb();
		Statement oStmt=conexion.createStatement();
		String sSQL = "INSERT INTO " + DatosMensaje.TABLE_NAME + " ("
				+ DatosMensaje.COLUMNAS +") VALUES ("
				+ DatosMensaje.COLUMN_NAME_TEXTO			+ " " + sms.getTexto()
				+ DatosMensaje.COLUMN_NAME_DESTINO			+ " " + sms.getDestino()+");";
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
		String sSQL = "CREATE TABLE GRUPOUSUARIO ("
				+ DatosGrupoUsuario.COLUMN_NAME_IDUSUARIO	+ "number(6), "
				+ DatosGrupoUsuario.COLUMN_NAME_IDGRUPO		+ "number(6), "
				+ "CONSTRAINT FK_IDUSUARIO FOREIGN KEY(idusuario) REFERENCES USUARIO(id), "
				+ "CONSTRAINT FK_IDGRUPO FOREIGN KEY(idgrupo) REFERENCES GRUPO(id));";
		oStmt.executeUpdate(sSQL);
		oStmt.close();
	}
	
	public void insertarGrupoUsuario(GrupoUsuario grupuser) throws NamingException, SQLException {
		Connection conexion=conectarDb();
		Statement oStmt=conexion.createStatement();
		String sSQL = "INSERT INTO " + DatosGrupousuario.TABLE_NAME + "("
				
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
