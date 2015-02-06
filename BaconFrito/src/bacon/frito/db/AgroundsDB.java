package bacon.frito.db;

public class AgroundsDB {
	private static final String DATABASE_CREATE_USUARIO = "CREATE TABLE if not exists "
			+ DatosUsaurio.TABLE_NAME 					+ " (" 
			+ DatosUsaurio.COLUMN_NAME_ROWID				+ " integer PRIMARY KEY autoincrement," 
			+ DatosUsaurio.COLUMN_NAME_NICK				+ ","
			+ DatosUsaurio.COLUMN_NAME_PASS 				+ ","
			+ DatosInventario.COLUMN_NAME_NOMBRE 	+ "," 
			+ DatosInventario.COLUMN_NAME_APELLIDOS 			+ " REAL," 
			+ DatosInventario.COLUMN_NAME_TELEFONO			+ "," 
			+ DatosInventario.COLUMN_NAME_SEXO 			+ " integer);";
}
