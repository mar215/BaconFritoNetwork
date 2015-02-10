package bacon.frito.db;

import java.sql.Connection;
import java.sql.ResultSet;
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
	
	public static DbConstructor getInstance(){
		return instancia;
	}
	
	//CREAR CONEXION
	
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
	
	//FUNCIONES CON USUARIO
	
	public void insertarUsuario(UsuarioBacon user) throws SQLException, NamingException {
		
		Connection conexion=conectarDb();
		Statement oStmt=conexion.createStatement();
		String sSQL;
		if(user.getClass().equals(bacon.frito.modelo.UsuarioBacon.class)){
			sSQL = "INSERT INTO " + DatosUsuario.TABLE_NAME + " ("
					+ DatosUsuario.COLUMNAS +") VALUES ("
					+ " "  + Db.DATABASE_USUARIO_NEXT_ID
					+ ", " + user.getNombre()
					+ ", " + user.getApellidos()
					+ ", " + user.getTelefono()
					+ ", " + user.getBday()
					+ ", " + user.getSexo()
					+ ", " + user.getFoto()
					+ ", true"
					+ ", usuariobacon);";	
		} else {
			sSQL = "INSERT INTO " + DatosUsuario.TABLE_NAME + " ("
					+ DatosUsuario.COLUMNAS +") VALUES ("
					/////IMPORTANTE/////
					//NECESITAMOS INTRODUCIR EL VALOR DE LA SECUENCIA
					//PARA RELLENAR EL ID
					// NECESITA COMILLAS????				
					+ " "  + Db.DATABASE_USUARIO_NEXT_ID
					+ ", " + user.getNombre()
					+ ", " + user.getApellidos()
					+ ", " + user.getTelefono()
					+ ", " + user.getBday()
					+ ", " + user.getSexo()
					+ ", " + user.getFoto()
					+ ", true"
					+ ", usuariopremium);";	
		}
		oStmt.executeUpdate(sSQL);	
		oStmt.close();
	}
	
	public void eliminarUsuario(String nick) throws NamingException, SQLException {
		Connection conexion=conectarDb();
		Statement oStmt=conexion.createStatement();
		
		UsuarioBacon userAux = dameUsuario(nick);
		 String sSQL = "UPDATE "+ DatosUsuario.TABLE_NAME + ""
				+ "SET " +DatosUsuario.COLUMN_NAME_ACTIVO+"='false' (WHERE  " +nick+"="+userAux.getNick()+")";
		oStmt.executeUpdate(sSQL);	
		oStmt.close();
	}
	
	/**
	 * Este m�todo conecta con la base de datos para buscar que en la tabla de Usuarios existe uno
	 * con este nick y nos devuelve true si lo ha encontrado y false si no hay ninguno.
	 * @param nick
	 * @return
	 */
	
	public boolean buscaUsuario(String nick) throws SQLException, NamingException{
		Connection conexion = conectarDb();
		Statement oStmt=conexion.createStatement();
		String sSQL = "SELECT "
				+ DatosUsuario.COLUMN_NAME_ID + ","
				+ DatosUsuario.COLUMN_NAME_NICK	+ ","
				+ DatosUsuario.COLUMN_NAME_PASS	+ "FROM Usuario"
				+ "WHERE ("
				+ DatosUsuario.COLUMN_NAME_NICK + "=" + nick + ")";
		ResultSet oRs = oStmt.executeQuery(sSQL);
		return oRs.next();
	}
	
	public UsuarioBacon dameUsuario(String nick) throws SQLException, NamingException{
		Connection conexion = conectarDb();
		Statement oStmt=conexion.createStatement();
		String sSQL = "SELECT "
				+ DatosUsuario.COLUMN_NAME_ID + ", "
				+ DatosUsuario.COLUMN_NAME_NICK	+ ", "
				+ DatosUsuario.COLUMN_NAME_NOMBRE	+ ", "
				+ DatosUsuario.COLUMN_NAME_APELLIDOS	+ ", "
				+ DatosUsuario.COLUMN_NAME_TELEFONO	+ ", "
				+ DatosUsuario.COLUMN_NAME_BDAY	+ ", "
				+ DatosUsuario.COLUMN_NAME_SEXO	+ ", "
				+ DatosUsuario.COLUMN_NAME_FOTO	+ ", "
				+ DatosUsuario.COLUMN_NAME_TIPO+ ", "
				+ DatosUsuario.COLUMN_NAME_ACTIVO+ "FROM Usuario"
				+ "WHERE ("
				+ DatosUsuario.COLUMN_NAME_NICK + "=" + nick + ")";
		ResultSet oRs = oStmt.executeQuery(sSQL);
		UsuarioBacon userAux=null;
		while(oRs.next()){
			int idUser = oRs.getInt(DatosUsuario.COLUMN_NAME_ID);
			String nickUser = oRs.getString(DatosUsuario.COLUMN_NAME_NICK);
			String passUser = oRs.getString(DatosUsuario.COLUMN_NAME_PASS);
			String nombreUser = oRs.getString(DatosUsuario.COLUMN_NAME_NOMBRE);
			String apellidosUser = oRs.getString(DatosUsuario.COLUMN_NAME_APELLIDOS);
			String telefonoUser = oRs.getString(DatosUsuario.COLUMN_NAME_TELEFONO);
			String bdayUser = oRs.getString(DatosUsuario.COLUMN_NAME_BDAY);
			String sexoUser = oRs.getString(DatosUsuario.COLUMN_NAME_SEXO);
			String fotoUser = oRs.getString(DatosUsuario.COLUMN_NAME_FOTO);
			String tipoUser = oRs.getString(DatosUsuario.COLUMN_NAME_TIPO);
			String activoUser = oRs.getString(DatosUsuario.COLUMN_NAME_ACTIVO);
		    userAux = new UsuarioBacon(idUser,nickUser, passUser, nombreUser,
					apellidosUser, telefonoUser, sexoUser, bdayUser, fotoUser, activoUser);
		}
		return userAux;
	}
	
	
	//FUNCIONES CON GRUPO
	
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
				+ "  " + Db.DATABASE_GRUPO_NEXT_ID
				+ ", " + grup.getNombre()
				+ ", " + grup.getDescripcion()
				+ ", " + grup.getImagen()
				+ ", " + grup.getMaxintegrantes()
				+ ", true);";		
		oStmt.executeUpdate(sSQL);	
		oStmt.close();	
	}
	
	public void eliminarGrupo(String nombre) throws NamingException, SQLException {
		Connection conexion=conectarDb();
		Statement oStmt=conexion.createStatement();
		
		Grupo grupAux = dameGrupo(nombre);
		 String sSQL = "UPDATE "+ DatosGrupo.TABLE_NAME + ""
				+ "SET " +DatosGrupo.COLUMN_NAME_ACTIVO+"='false' (WHERE  " +nombre+"="+grupAux.getNombre()+")";
		oStmt.executeUpdate(sSQL);	
		oStmt.close();

	}
	
	public boolean buscaGrupo(String nombre) throws SQLException, NamingException{
		Connection conexion = conectarDb();
		Statement oStmt=conexion.createStatement();
		String sSQL = "SELECT "
				+ DatosGrupo.COLUMN_NAME_ID + ","
				+ DatosGrupo.COLUMN_NAME_NOMBRE	+ "FROM Grupo"
				+ "WHERE ("
				+ DatosGrupo.COLUMN_NAME_NOMBRE + "=" + nombre + ")";
		ResultSet oRs = oStmt.executeQuery(sSQL);
		return oRs.next();
	}
	
	public Grupo dameGrupo(String nombre) throws SQLException, NamingException{
		Connection conexion = conectarDb();
		Statement oStmt=conexion.createStatement();
		String sSQL = "SELECT "
				+ DatosGrupo.COLUMN_NAME_ID + ","
				+ DatosGrupo.COLUMN_NAME_NOMBRE	+ ","
				+ DatosGrupo.COLUMN_NAME_DESCRIPCION + ","
				+ DatosGrupo.COLUMN_NAME_IMAGEN + ","	
				+ DatosGrupo.COLUMN_NAME_MAXINTEGRANTES	+ ","
				+ DatosGrupo.COLUMN_NAME_ACTIVO	+ "FROM Usuario"
				+ "WHERE ("
				+ DatosGrupo.COLUMN_NAME_NOMBRE + "=" + nombre + ")";
		ResultSet oRs = oStmt.executeQuery(sSQL);
		Grupo grupAux=null;
		while(oRs.next()){
			int idGrup = oRs.getInt(DatosGrupo.COLUMN_NAME_ID);
			String nombreGrup = oRs.getString(DatosUsuario.COLUMN_NAME_NOMBRE);
			String descripcionGrup = oRs.getString(DatosGrupo.COLUMN_NAME_DESCRIPCION);
			String imagenGrup = oRs.getString(DatosGrupo.COLUMN_NAME_IMAGEN);
			int maxintGrup = oRs.getInt(DatosGrupo.COLUMN_NAME_MAXINTEGRANTES);
			String activoGrup = oRs.getString(DatosGrupo.COLUMN_NAME_ACTIVO);
		    grupAux = new Grupo(idGrup, nombreGrup, descripcionGrup, imagenGrup, maxintGrup, activoGrup);
		}
		return grupAux;
	}
	
	
	//FUNCIONES CON MENSAJE
	
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
				+ "  " + Db.DATABASE_MENSAJE_NEXT_ID
				+ ", " + sms.getTexto()
				+ ", " + sms.getDestino()+");";
		oStmt.executeUpdate(sSQL);	
		oStmt.close();	
	}
	

	
	//FUNCIONES CON GRUPOUSUARIO
	
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
	
	public void dameGrupoUsuario(String nick) throws SQLException, NamingException{
		Connection conexion = conectarDb();
		Statement oStmt=conexion.createStatement();
		String sSQL = "SELECT "
				+ DatosGrupo.COLUMN_NAME_ID + ","
				+ DatosGrupo.COLUMN_NAME_NOMBRE	+ "FROM " + DatosUsuario.TABLE_NAME + ", "
				+ DatosGrupoUsuario.TABLE_NAME +", "+ DatosGrupo.TABLE_NAME
				+ "WHERE ("
				+ DatosUsuario.COLUMN_NAME_NICK + "=" + nick + "AND" 
				+ DatosUsuario.COLUMN_NAME_ID +"="+DatosGrupoUsuario.COLUMN_NAME_IDUSUARIO
				+ DatosGrupoUsuario.COLUMN_NAME_IDGRUPO +"="+DatosGrupo.COLUMN_NAME_ID +")";
		oStmt.executeUpdate(sSQL);	
		oStmt.close();

	}
	
	
}
