package bacon.frito.db;

import bacon.frito.db.ContractClass.DatosGrupo;
import bacon.frito.db.ContractClass.DatosGrupo.DatosGrupoUsuario;
import bacon.frito.db.ContractClass.DatosGrupo.DatosMensaje;
import bacon.frito.db.ContractClass.DatosUsuario;

public class Db {
	private static final String DATABASE_CREATE_USUARIO = "CREATE TABLE if not exists "
			+ DatosUsuario.TABLE_NAME 					+ " (" 
			+ DatosUsuario.COLUMN_NAME_ID				+ "number(6) PRIMARY KEY, " 
			+ DatosUsuario.COLUMN_NAME_NICK				+ "varchar2(25) NOT NULL, "
			+ DatosUsuario.COLUMN_NAME_PASS 			+ "varchar2(25) NOT NULL, "
			+ DatosUsuario.COLUMN_NAME_NOMBRE 			+ "varchar2(25), " 
			+ DatosUsuario.COLUMN_NAME_APELLIDOS 		+ "varchar2(50), " 
			+ DatosUsuario.COLUMN_NAME_TELEFONO			+ "integer, " 
			+ DatosUsuario.COLUMN_NAME_BDAY				+ "varchar2(10), "
			+ DatosUsuario.COLUMN_NAME_SEXO				+ "varchar2(25), "
			+ DatosUsuario.COLUMN_NAME_FOTO				+ "varchar2(100), "
			+ DatosUsuario.COLUMN_NAME_TIPO             + "varchar2(15) NOT NULL);";
	
	private static final String DATABASE_CREATE_GRUPO = "CREATE TABLE if not exists "
			+ DatosGrupo.TABLE_NAME						+ " ("
			+ DatosGrupo.COLUMN_NAME_ID				+ "integer PRIMARY KEY,"
			+ DatosGrupo.COLUMN_NAME_NOMBRE				+ "varchar2(25), "
			+ DatosGrupo.COLUMN_NAME_DESCRIPCION		+ "varchar2(500), "
			+ DatosGrupo.COLUMN_NAME_IMAGEN				+ "varchar2(100), "
			+ DatosGrupo.COLUMN_NAME_MAXINTEGRANTES		+ "integer);";
	
	private static final String DATABASE_CREATE_MENSAJE = "CREATE TABLE if not exists "
			+ DatosMensaje.TABLE_NAME					+ " ("
			+ DatosMensaje.COLUMN_NAME_ID			+ "integer PRIMARY KEY,"
			+ DatosMensaje.COLUMN_NAME_TEXTO			+ "varchar2(500), "
			+ DatosMensaje.COLUMN_NAME_DESTINO			+ "varchar2(25) NOT NULL);";
	
	private static final String DATABASE_CREATE_GRUPOUSUARIO = "CREATE TABLE if not exists "
			+ DatosGrupoUsuario.TABLE_NAME				+ " ("
			+ DatosGrupoUsuario.COLUMN_NAME_IDUSUARIO	+ "integer PRIMARY KEY"
			+ DatosGrupoUsuario.COLUMN_NAME_IDGRUPO		+ "integer PRIMARY KEY)";
	//PASAR CLAVE SECUNDARIA
	//AUTOINCREMENTO DE LA ID. SOLUCIONARLO.		
}
