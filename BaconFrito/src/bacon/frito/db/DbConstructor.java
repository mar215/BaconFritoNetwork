package bacon.frito.db;



import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import bacon.frito.db.ContractClass.DatosGrupo;
import bacon.frito.db.ContractClass.DatosGrupoUsuario;
import bacon.frito.db.ContractClass.DatosMensaje;
import bacon.frito.db.ContractClass.DatosNotificacion;
import bacon.frito.db.ContractClass.DatosUsuario;
import bacon.frito.modelo.Grupo;
import bacon.frito.modelo.GrupoUsuario;
import bacon.frito.modelo.Mensaje;
import bacon.frito.modelo.Notificacion;
import bacon.frito.modelo.UsuarioBacon;
import bacon.frito.modelo.UsuarioPremium;

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
		miDS = (DataSource)ic.lookup("java:comp/env/jdbc/DataSourceLocal1");
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
		sSQL = "INSERT INTO " + DatosUsuario.TABLE_NAME + " ("
				+ DatosUsuario.COLUMNAS +") VALUES ("
				+ " '"  	 + user.getNick()
				+ "', '" + user.getPass()
				+ "', '" + user.getNombre()
				+ "', '" + user.getApellidos()
				+ "', '" + user.getTelefono()
				+ "', '" + user.getBday()
				+ "', '" + user.getSexo()
				+ "', '" + user.getFoto()
				+ "', 'true"
				+ "', 'usuariobacon')";	
		System.out.println(sSQL);
		oStmt.executeUpdate(sSQL);	
		oStmt.close();
	}
	
	public void convertirAPremium(String nick) throws NamingException, SQLException {
		Connection conexion=conectarDb();
		Statement oStmt=conexion.createStatement();
		UsuarioBacon userAux = dameUsuario(nick);
		String sSQL = "UPDATE "+ DatosUsuario.TABLE_NAME + ""
				+ "SET " +DatosUsuario.COLUMN_NAME_TIPO+"='usuariopremium' (WHERE  " +nick+"="+userAux.getNick()+")";
		oStmt.executeUpdate(sSQL);	
		oStmt.close();
		
	}
	
	public UsuarioBacon devuelveTipo(String nick) throws NamingException, SQLException {
		UsuarioBacon userAux = dameUsuario(nick);
		if (userAux.getTipo() == "usuariobacon") {
			UsuarioBacon usuario = null;
			return usuario;
		} else {
			UsuarioPremium usuario = null;
			return usuario;
		}
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
	 * Este método conecta con la base de datos para buscar que en la tabla de Usuarios existe uno
	 * con este nick y nos devuelve true si lo ha encontrado y false si no hay ninguno.
	 * @param nick
	 * @return
	 */
	
	public boolean buscaUsuario(String nick) throws SQLException, NamingException{
		Connection conexion = conectarDb();
		Statement oStmt=conexion.createStatement();
		String sSQL = "SELECT "
				+ DatosUsuario.COLUMN_NAME_NICK	+ ", "
				+ DatosUsuario.COLUMN_NAME_PASS	+ " FROM Usuario"
				+ " WHERE ("
				+ DatosUsuario.COLUMN_NAME_NICK + "='" + nick + "')";
		System.out.println(sSQL);
		ResultSet oRs = oStmt.executeQuery(sSQL);
		return oRs.next();
	}
	
	public UsuarioBacon dameUsuario(String nick) throws SQLException, NamingException{
		Connection conexion = conectarDb();
		Statement oStmt=conexion.createStatement();
		String sSQL = "SELECT "
				+ DatosUsuario.COLUMN_NAME_NICK	+ ", "
				+ DatosUsuario.COLUMN_NAME_PASS	+ ", "
				+ DatosUsuario.COLUMN_NAME_NOMBRE	+ ", "
				+ DatosUsuario.COLUMN_NAME_APELLIDOS	+ ", "
				+ DatosUsuario.COLUMN_NAME_TELEFONO	+ ", "
				+ DatosUsuario.COLUMN_NAME_BDAY	+ ", "
				+ DatosUsuario.COLUMN_NAME_SEXO	+ ", "
				+ DatosUsuario.COLUMN_NAME_FOTO	+ ", "
				+ DatosUsuario.COLUMN_NAME_TIPO+ ", "
				+ DatosUsuario.COLUMN_NAME_ACTIVO+ " FROM Usuario"
				+ " WHERE ("
				+ DatosUsuario.COLUMN_NAME_NICK + "='" + nick + "')";
		System.out.println(sSQL);
		ResultSet oRs = oStmt.executeQuery(sSQL);
		UsuarioBacon userAux=null;
		if(oRs.next()){
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
		    userAux = new UsuarioBacon(nickUser, passUser, nombreUser,
					apellidosUser, telefonoUser, sexoUser, bdayUser, fotoUser, tipoUser, activoUser);
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
		Statement oStmt=conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = oStmt.executeQuery(Db.DATABASE_GRUPO_NEXT_ID);
		rs.first();
		int id = rs.getInt(1);
		String sSQL = "INSERT INTO "+ DatosGrupo.TABLE_NAME + " ("
				+ DatosGrupo.COLUMNAS +") VALUES ("
				+ "  " + id
				+ ", '" + grup.getNombre()
				+ "', '" + grup.getDescripcion()
				+ "', '" + grup.getImagen()
				+ "', " + grup.getMaxintegrantes()
				+ ", 'true')";		
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
				+ DatosGrupo.COLUMN_NAME_NOMBRE	+ " FROM Grupo"
				+ " WHERE ("
				+ DatosGrupo.COLUMN_NAME_NOMBRE + "='" + nombre + "')";
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
				+ DatosGrupo.COLUMN_NAME_ACTIVO	+ " FROM Grupo"
				+ " WHERE ("
				+ DatosGrupo.COLUMN_NAME_NOMBRE + "='" + nombre + "')";
		ResultSet oRs = oStmt.executeQuery(sSQL);
		Grupo grupAux=null;
		if(oRs.next()){
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
	
	public ArrayList<Grupo> listarGrupos() throws SQLException, NamingException {
		Connection conexion = conectarDb();
		Statement oStmt=conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		String sSQL = "SELECT * FROM " + DatosGrupo.TABLE_NAME;
		ResultSet oRs = oStmt.executeQuery(sSQL);
		ArrayList<Grupo> listaGrupos = new ArrayList<Grupo>();
		while (oRs.next()) {
			Grupo grupos = new Grupo(oRs.getInt(DatosGrupo.COLUMN_NAME_ID),
					oRs.getString(DatosGrupo.COLUMN_NAME_NOMBRE),
					oRs.getString(DatosGrupo.COLUMN_NAME_DESCRIPCION),
					oRs.getString(DatosGrupo.COLUMN_NAME_IMAGEN),
					oRs.getInt(DatosGrupo.COLUMN_NAME_MAXINTEGRANTES),
					oRs.getString(DatosGrupo.COLUMN_NAME_ACTIVO));
			
			listaGrupos.add(grupos);
		}
		
		return listaGrupos;
			
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
		Statement oStmt=conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = oStmt.executeQuery(Db.DATABASE_GRUPO_NEXT_ID);
		rs.first();
		int id = rs.getInt(1);
		String sSQL = "INSERT INTO " + DatosMensaje.TABLE_NAME + " ("
				+ DatosMensaje.COLUMNAS +") VALUES ("
				+ "  " + id
				+ ", '" + sms.getTexto()
				+ "', '" + sms.getDestino()
				+ "', '" + sms.getOrigen()
				+ "', '" + sms.getOrigen()+"')";
		System.out.println(sSQL);
		oStmt.executeUpdate(sSQL);	
		oStmt.close();	
	}
	
	/**
	 * Método que recibe un mensaje a un grupo y lo manda a todos los integrantes de dicho grupo
	 * @param sms
	 * @throws NamingException
	 * @throws SQLException
	 */
	
	public void mensajeGrupal(Mensaje sms) throws NamingException, SQLException {
		Connection conexion = conectarDb();
		Statement oStmt = conexion.createStatement();
		String sSQL = "SELECT"
				+ DatosGrupoUsuario.COLUMN_NAME_NICKUSUARIO + " FROM "
				+ DatosGrupoUsuario.TABLE_NAME + " WHERE ('"
				+ sms.getDestino() + "' = "+DatosGrupoUsuario.COLUMN_NAME_IDGRUPO+")";
		ResultSet resultUsers = oStmt.executeQuery(sSQL);
		while(resultUsers.next()){
			Mensaje mensajeAux = sms;
			mensajeAux.setDestino(resultUsers.getString(DatosGrupoUsuario.COLUMN_NAME_NICKUSUARIO));
			insertarMensaje(mensajeAux);
		}
		oStmt.close();
		conexion.close();
	}
	
	/**
	 * Funcion que recibe el nick de un usuario como parametro y busca en la base de datos y 
	 * nos devuelve los mensajes que van destinados a este usuario
	 * @param nick
	 * @return ArrayList que contiene objetos de tipo Mensaje con los mensajes al usuario
	 * @throws NamingException
	 * @throws SQLException
	 */
	
	public ArrayList<Mensaje> dameLista (String nick) throws NamingException, SQLException{
		ArrayList<Mensaje> listaMensajes = new ArrayList<Mensaje>();
		Connection conexion = conectarDb();
		Statement oStmt = conexion.createStatement();
		
		/*
		 * Vamos a buscar la lista de mensanjes en la base de datos que tengan como destino al 
		 * usuario que pasamos por parametro mediante una Query
		 */
		
		String sSQL = "SELECT "
				+ DatosMensaje.COLUMN_NAME_ID + ", "
				+ DatosMensaje.COLUMN_NAME_TEXTO + ", "
				+ DatosMensaje.COLUMN_NAME_DESTINO + ", "
				+ DatosMensaje.COLUMN_NAME_NICKUSUARIO + " FROM "
				+ DatosMensaje.TABLE_NAME + " WHERE ("
				+ DatosMensaje.COLUMN_NAME_DESTINO + " = '"
				+ nick + "')";
		ResultSet resultLista = oStmt.executeQuery(sSQL);	
		while(resultLista.next()){
			Mensaje mensajeAux = new Mensaje(resultLista.getInt(DatosMensaje.COLUMN_NAME_ID),
					resultLista.getString(DatosMensaje.COLUMN_NAME_TEXTO),
					resultLista.getString(DatosMensaje.COLUMN_NAME_DESTINO),
					resultLista.getString(DatosMensaje.COLUMN_NAME_NICKUSUARIO));
			
			listaMensajes.add(mensajeAux);
		}
		
		return listaMensajes;
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
		String sSQL = "INSERT INTO " + DatosGrupoUsuario.TABLE_NAME + " VALUES ("
				+ " '" + grupuser.getNickusuario()
				+ "', " + grupuser.getIdgrupo()+")";		
		oStmt.executeUpdate(sSQL);	
		oStmt.close();
	}
	
	public ArrayList<GrupoUsuario> entrarGrupo(String nick, int idG) throws SQLException, NamingException{
		Connection conexion = conectarDb();
		Statement oStmt=conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet oRs;
		System.out.println("Macho");
		String sSQL = "SELECT "
				+ DatosGrupoUsuario.COLUMN_NAME_IDGRUPO
				+ " FROM " + DatosGrupoUsuario.TABLE_NAME 
				+ " WHERE "
				+ DatosGrupoUsuario.COLUMN_NAME_NICKUSUARIO + " = '" + nick + "' AND "
				+ DatosGrupoUsuario.COLUMN_NAME_IDGRUPO + " = " + idG ;		
		oRs = oStmt.executeQuery(sSQL);	
		ArrayList<GrupoUsuario> lista = new ArrayList<GrupoUsuario>();
		System.out.println("Macho2");
		while(oRs.next()){
			lista.add(new GrupoUsuario(nick, oRs.getInt(DatosGrupoUsuario.COLUMN_NAME_IDGRUPO)));
		}
		
		oStmt.close();
		
		return lista;

	}
	
	public ArrayList<GrupoUsuario> salirGrupo(String nick, int idG) throws NamingException, SQLException {
		Connection conexion = conectarDb();
		Statement oStmt=conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet oRs;
		String sSQL = "DELETE FROM " + DatosGrupoUsuario.TABLE_NAME;
		oStmt.executeUpdate(sSQL);
		System.out.println("Ey1");
		String sSQL1 = "SELECT "
				+ DatosGrupoUsuario.COLUMN_NAME_IDGRUPO
				+ " FROM " + DatosGrupoUsuario.TABLE_NAME 
				+ " WHERE "
				+ DatosGrupoUsuario.COLUMN_NAME_NICKUSUARIO + " = '" + nick + "' AND "
				+ DatosGrupoUsuario.COLUMN_NAME_IDGRUPO + " = " + idG ;
		oRs = oStmt.executeQuery(sSQL1);	
		System.out.println("Ey2");
		ArrayList<GrupoUsuario> lista = new ArrayList<GrupoUsuario>();
		while(oRs.next()){
			lista.add(new GrupoUsuario(nick, oRs.getInt(DatosGrupoUsuario.COLUMN_NAME_IDGRUPO)));
		}
		oStmt.close();
		return lista;
	}
	
	//NOTIFICACIONES
	
	public ArrayList<Notificacion> dameNotificacionesUsuario(String nick) throws SQLException, NamingException{
		Connection conexion = conectarDb();
		Statement oStmt=conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ArrayList<Notificacion> result = new ArrayList<Notificacion>();
		System.out.println(Db.getNotif(dameUsuarios()));
		ResultSet oRs = oStmt.executeQuery(Db.getNotif(dameUsuarios()));
		while(oRs.next()){
			result.add(new Notificacion(oRs.getString(DatosNotificacion.COLUMN_NAME_USER),
										oRs.getString(DatosNotificacion.COLUMN_NAME_TEXT),
										oRs.getDate(DatosNotificacion.COLUMN_NAME_DATE)));			
		}
		System.out.println("DEBUG BORRAME CON AMOR "+result.size());
		return result;
	}

	public ArrayList<Notificacion> damePerfilUsuario(String nick) throws SQLException, NamingException{
		Connection conexion = conectarDb();
		Statement oStmt=conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ArrayList<Notificacion> result = new ArrayList<Notificacion>();
		ResultSet oRs = oStmt.executeQuery(Db.getPerfil(nick));
		while(oRs.next()){
			result.add(new Notificacion(nick,
										oRs.getString(DatosNotificacion.COLUMN_NAME_TEXT),
										oRs.getDate(DatosNotificacion.COLUMN_NAME_DATE)));			
		}
		return result;
	}

	public ArrayList<String> dameUsuarios() throws SQLException, NamingException{
		Connection conexion = conectarDb();
		Statement oStmt=conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ArrayList<String> result = new ArrayList<String>();
		ResultSet oRs = oStmt.executeQuery(Db.getUsuarios());
		while(oRs.next()){
			result.add(oRs.getString(DatosUsuario.COLUMN_NAME_NICK));			
		}
		return result;
	}
	
	public boolean nuevaNotif(String usuario, String texto) throws SQLException, NamingException{
		Connection conexion = conectarDb();
		Statement oStmt=conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = oStmt.executeQuery(Db.DATABASE_GRUPO_NEXT_ID);
		rs.first();
		int id = rs.getInt(1);
		Calendar c = new GregorianCalendar();
		String fecha = c.get(Calendar.HOUR_OF_DAY) 	+ ":"
					 + c.get(Calendar.MINUTE)		+ ":"
					 + c.get(Calendar.SECOND) 		+ "-"
					 + c.get(Calendar.DAY_OF_MONTH) + "/"
					 + (c.get(Calendar.MONTH) + 1)	+ "/"
					 + c.get(Calendar.YEAR);
		System.out.println(Db.addNotif(id, usuario, texto, fecha));
		oStmt.executeQuery(Db.addNotif(id, usuario, texto, fecha));
		return true;
	}
	
}
