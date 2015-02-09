package bacon.frito.db;

import bacon.frito.db.ContractClass.DatosGrupo;
import bacon.frito.db.ContractClass.DatosGrupo.DatosGrupoUsuario;
import bacon.frito.db.ContractClass.DatosGrupo.DatosMensaje;
import bacon.frito.db.ContractClass.DatosUsuario;

public class Db {
	private static final String DATABASE_CREATE_USUARIO = "CREATE TABLE if not exists "
			+ DatosUsuario.TABLE_NAME 					+ " (" 
			+ DatosUsuario.COLUMN_NAME_ROWID			+ "integer PRIMARY KEY autoincrement, " 
			+ DatosUsuario.COLUMN_NAME_NICK				+ "varchar() NOT NULL, "
			+ DatosUsuario.COLUMN_NAME_PASS 			+ "varchar() NOT NULL, "
			+ DatosUsuario.COLUMN_NAME_NOMBRE 			+ "varchar(), " 
			+ DatosUsuario.COLUMN_NAME_APELLIDOS 		+ "varchar(), " 
			+ DatosUsuario.COLUMN_NAME_TELEFONO			+ "integer, " 
			+ DatosUsuario.COLUMN_NAME_SEXO				+ "varchar(), "
			+ DatosUsuario.COLUMN_NAME_FOTO				+ "varchar(), "
			+ DatosUsuario.COLUMN_NAME_TIPO             + "varchar() NOT NULL);";
	
	private static final String DATABASE_CREATE_GRUPO = "CREATE TABLE if not exists "
			+ DatosGrupo.TABLE_NAME						+ " ("
			+ DatosGrupo.COLUMN_NAME_ROWID				+ "integer PRIMARY KEY autoincrement,"
			+ DatosGrupo.COLUMN_NAME_NOMBRE				+ "varchar(), "
			+ DatosGrupo.COLUMN_NAME_DESCRIPCION		+ "varchar(), "
			+ DatosGrupo.COLUMN_NAME_IMAGEN				+ "varchar(), "
			+ DatosGrupo.COLUMN_NAME_MAXINTEGRANTES		+ "integer);";
	
	private static final String DATABASE_CREATE_MENSAJE = "CREATE TABLE if not exists "
			+ DatosMensaje.TABLE_NAME					+ " ("
			+ DatosMensaje.COLUMN_NAME_ROWID			+ "integer PRIMARY KEY autoincrement,"
			+ DatosMensaje.COLUMN_NAME_TEXTO			+ "varchar(), "
			+ DatosMensaje.COLUMN_NAME_DESTINO			+ "varchar());";
	
	private static final String DATABASE_CREATE_GRUPOUSUARIO = "CREATE TABLE if not exists "
			+ DatosGrupoUsuario.TABLE_NAME				+ " ("
			+ DatosGrupoUsuario.COLUMN_NAME_IDUSUARIO	+ "integer PRIMARY KEY"
			+ DatosGrupoUsuario.COLUMN_NAME_IDGRUPO		+ "integer PRIMARY KEY";
	//PASAR CLAVE SECUNDARIA
			
}