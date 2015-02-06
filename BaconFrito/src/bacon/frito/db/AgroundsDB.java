package bacon.frito.db;

import bacon.frito.db.ContractClass.DatosUsuario;

public class AgroundsDB {
	private static final String DATABASE_CREATE_USUARIO = "CREATE TABLE if not exists "
			+ DatosUsuario.TABLE_NAME 					+ " (" 
			+ DatosUsuario.COLUMN_NAME_ROWID				+ " integer PRIMARY KEY autoincrement," 
			+ DatosUsuario.COLUMN_NAME_NICK				+ ","
			+ DatosUsuario.COLUMN_NAME_PASS 				+ ","
			+ DatosUsuario.COLUMN_NAME_NOMBRE 	+ "," 
			+ DatosUsuario.COLUMN_NAME_APELLIDOS 			+ " ," 
			+ DatosUsuario.COLUMN_NAME_TELEFONO			+ "," 
			+ DatosUsuario.COLUMN_NAME_SEXO 			+ ");";
}
