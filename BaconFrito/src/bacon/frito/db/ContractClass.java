package bacon.frito.db;

public class ContractClass {

	public ContractClass() {}
	
	public static abstract class DatosUsuario {
        public static final String TABLE_NAME = "Usuario";
        public static final String COLUMN_NAME_ROWID 		   = "id";			//int
        public static final String COLUMN_NAME_NICK			= "nick";		//String
        public static final String COLUMN_NAME_PASS			= "pass";		//String
        public static final String COLUMN_NAME_NOMBRE 		   = "nombre";		//String
        public static final String COLUMN_NAME_APELLIDOS 		   = "apellido";		//String
        public static final String COLUMN_NAME_TELEFONO 		= "telefono";		//Int
        public static final String COLUMN_NAME_SEXO 	   = "sexo";	//String
        public static final String COLUMN_NAME_FOTO 		   = "foto";		//String
        public static final String COLUMN_NAME_TIPO 		   = "tipo";		//String
        public static final String[] COLUMNS = {COLUMN_NAME_NOMBRE
        										,COLUMN_NAME_APELLIDOS,COLUMN_NAME_TELEFONO
        										,COLUMN_NAME_SEXO,COLUMN_NAME_FOTO};
	}
	
	
	public static abstract class DatosGrupo {
		public static final String TABLE_NAME = "Grupo";
    	public static final String COLUMN_NAME_ROWID 		   = "id";			//int
    	public static final String COLUMN_NAME_NOMBRE 		   = "nombre";		//String
    	public static final String COLUMN_NAME_DESCRIPCION 	   = "descripcion";	//String
    	public static final String COLUMN_NAME_IMAGEN 	   = "imagen";		//String
    	public static final String COLUMN_NAME_MAXINTEGRANTES		   = "maxintegrantes";	//int
    	public static final String[] COLUMNS = {COLUMN_NAME_ROWID,COLUMN_NAME_NOMBRE
    											,COLUMN_NAME_DESCRIPCION,COLUMN_NAME_IMAGEN
    											,COLUMN_NAME_MAXINTEGRANTES};
    	
    	
    public static abstract class DatosMensaje {
    	public static final String TABLE_NAME = "Mensaje";
    	public static final String COLUMN_NAME_ROWID 		   = "id";			//int
    	public static final String COLUMN_NAME_TEXTO 		   = "texto";			//String
    	public static final String COLUMN_NAME_DESTINO  		   = "destino";			//String
    	public static final String[] COLUMNS = {COLUMN_NAME_ROWID,COLUMN_NAME_TEXTO
												,COLUMN_NAME_DESTINO};
    }
    
    
    public static abstract class DatosGrupoUsuario {
    	public static final String TABLE_NAME = "GrupoUsuario";
    	public static final String COLUMN_NAME_IDUSUARIO		="idusuario";
    	public static final String COLUMN_NAME_IDGRUPO			="idgrupo";
    	public static final String[] COLUMNS = {COLUMN_NAME_IDUSUARIO, COLUMN_NAME_IDGRUPO};
    }
 
    //DESAYUNO
    //CUENTA?
    //ANYTHING ELSE?
    //ffgfgfghfhf
	}
	
}
