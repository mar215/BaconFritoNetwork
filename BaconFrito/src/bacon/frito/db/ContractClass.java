package bacon.frito.db;

public class ContractClass {

	public ContractClass() {}
	
	public static abstract class DatosUsuario {
        public static final String TABLE_NAME 					= "Usuario";
        public static final String COLUMN_NAME_ID 		   		= "id";				//int
        public static final String COLUMN_NAME_NICK				= "nick";			//String
        public static final String COLUMN_NAME_PASS				= "pass";			//String
        public static final String COLUMN_NAME_NOMBRE 		   	= "nombre";			//String
        public static final String COLUMN_NAME_APELLIDOS 		= "apellido";		//String
        public static final String COLUMN_NAME_TELEFONO 		= "telefono";		//Int
        public static final String COLUMN_NAME_BDAY				= "cumpleaños";		//String
        public static final String COLUMN_NAME_SEXO 	   		= "sexo";			//String
        public static final String COLUMN_NAME_FOTO 		  	= "foto";			//String
        public static final String COLUMN_NAME_TIPO 		   	= "tipo";			//String
        public static final String COLUMN_NAME_ACTIVO			= "activo";			//String
        public static final String CONSTRAINT_USUARIO			= "idusario_pk";
        public static final String SEQUENCE_USUARIO_ID			= "account_seq";
        public static final String[] COLUMNS = {COLUMN_NAME_ID, COLUMN_NAME_NOMBRE
        										,COLUMN_NAME_APELLIDOS,COLUMN_NAME_TELEFONO
        										,COLUMN_NAME_SEXO,COLUMN_NAME_FOTO
        										,COLUMN_NAME_TIPO, COLUMN_NAME_ACTIVO};
        public static final String COLUMNAS = COLUMN_NAME_NOMBRE
        									+ "," + COLUMN_NAME_APELLIDOS + "," + COLUMN_NAME_TELEFONO
        									+ "," + COLUMN_NAME_SEXO + "," + COLUMN_NAME_FOTO
        									+ "," + COLUMN_NAME_TIPO+ "," + COLUMN_NAME_ACTIVO;
	 
	}
	
	public static abstract class DatosGrupo {
		public static final String TABLE_NAME 					= "Grupo";
    	public static final String COLUMN_NAME_ID 		   		= "id";				//int
    	public static final String COLUMN_NAME_NOMBRE 		   	= "nombre";			//String
    	public static final String COLUMN_NAME_DESCRIPCION 	   	= "descripcion";	//String
    	public static final String COLUMN_NAME_IMAGEN 	  		= "imagen";			//String
    	public static final String COLUMN_NAME_MAXINTEGRANTES	= "maxintegrantes";	//int
    	public static final String COLUMN_NAME_ACTIVO			= "activo";			//String
    	public static final String CONSTRAINT_GRUPO				= "idgrupo_pk";
    	public static final String SEQUENCE_GRUPO_ID			= "account_seq";
    	public static final String[] COLUMNS = {COLUMN_NAME_ID,COLUMN_NAME_NOMBRE
    											,COLUMN_NAME_DESCRIPCION,COLUMN_NAME_IMAGEN
    											,COLUMN_NAME_MAXINTEGRANTES, COLUMN_NAME_ACTIVO};
    	public static final String COLUMNAS = COLUMN_NAME_NOMBRE + "," +
											COLUMN_NAME_DESCRIPCION + "," + COLUMN_NAME_IMAGEN
											+ "," + COLUMN_NAME_MAXINTEGRANTES+ "," + COLUMN_NAME_ACTIVO;
	}
    	
    	
    public static abstract class DatosMensaje {
    	public static final String TABLE_NAME = "Mensaje";
    	public static final String COLUMN_NAME_ID 		   		= "id";				//int
    	public static final String COLUMN_NAME_TEXTO 		   	= "texto";			//String
    	public static final String COLUMN_NAME_DESTINO  		= "destino";		//String
    	public static final String COLUMN_NAME_ORIGEN  			= "origen";			//String
    	public static final String COLUMN_NAME_IDUSUARIO		= "idusuario";		//int clave ajena usuario
    	public static final String CONSTRAINT_MENSAJE			= "idmensaje_pk";
    	public static final String SEQUENCE_MENSAJE_ID			= "account_seq";
    	public static final String[] COLUMNS = {COLUMN_NAME_ID,COLUMN_NAME_TEXTO
												,COLUMN_NAME_DESTINO, COLUMN_NAME_ORIGEN};
    	public static final String COLUMNAS = COLUMN_NAME_TEXTO + "," +
											COLUMN_NAME_DESTINO + "," + COLUMN_NAME_ORIGEN;
    	
    }
    
    
    public static abstract class DatosGrupoUsuario {
    	public static final String TABLE_NAME = "GrupoUsuario";
    	public static final String COLUMN_NAME_IDUSUARIO		="idusuario";		//int
    	public static final String COLUMN_NAME_IDGRUPO			="idgrupo";			//int
    	public static final String CONSTRAINT_GUSUARIO		="idusuario_fk";		//clave ajena a idusuario
    	public static final String CONSTRAINT_GRUPOU		="idgrupo_fk";			//clave ajena a idgrupo
    	public static final String[] COLUMNS = {COLUMN_NAME_IDUSUARIO, COLUMN_NAME_IDGRUPO};
    	
    	public static final String COLUMNAS = COLUMN_NAME_IDUSUARIO + "," +
				COLUMN_NAME_IDGRUPO;
    }
 
    //DESAYUNO
    //ANYTHING ELSE?

	
}
