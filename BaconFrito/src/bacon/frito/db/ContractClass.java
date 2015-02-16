package bacon.frito.db;

public class ContractClass {

	public ContractClass() {}
	
	public static abstract class DatosUsuario {
        public static final String TABLE_NAME 					= "Usuario";
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
        public static final String[] COLUMNS = {COLUMN_NAME_NICK, COLUMN_NAME_PASS, COLUMN_NAME_NOMBRE
        										, COLUMN_NAME_APELLIDOS, COLUMN_NAME_TELEFONO, COLUMN_NAME_BDAY
        										, COLUMN_NAME_SEXO, COLUMN_NAME_FOTO
        										, COLUMN_NAME_ACTIVO, COLUMN_NAME_TIPO};
        public static final String COLUMNAS = COLUMN_NAME_NICK + ", " +COLUMN_NAME_PASS 
        									+ ", " +COLUMN_NAME_NOMBRE
        									+ ", " + COLUMN_NAME_APELLIDOS + ", " + COLUMN_NAME_TELEFONO
        									+ ", " + COLUMN_NAME_BDAY + ", " + COLUMN_NAME_SEXO
        									+ ", " + COLUMN_NAME_FOTO
        									+ ", " + COLUMN_NAME_ACTIVO+ ", " + COLUMN_NAME_TIPO;
	 
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
    	public static final String SEQUENCE_GRUPO_ID			= "grupo_seq";
    	public static final String[] COLUMNS = {COLUMN_NAME_ID,COLUMN_NAME_NOMBRE
    											,COLUMN_NAME_DESCRIPCION,COLUMN_NAME_IMAGEN
    											,COLUMN_NAME_MAXINTEGRANTES, COLUMN_NAME_ACTIVO};
    	public static final String COLUMNAS = COLUMN_NAME_ID + "," + COLUMN_NAME_NOMBRE + "," +
											COLUMN_NAME_DESCRIPCION + "," + COLUMN_NAME_IMAGEN
											+ "," + COLUMN_NAME_MAXINTEGRANTES+ "," + COLUMN_NAME_ACTIVO;
	}
    	
    	
    public static abstract class DatosMensaje {
    	public static final String TABLE_NAME = "Mensaje";
    	public static final String COLUMN_NAME_ID 		   		= "id";				//int
    	public static final String COLUMN_NAME_TEXTO 		   	= "texto";			//String
    	public static final String COLUMN_NAME_DESTINO  		= "destino";		//String
    	public static final String COLUMN_NAME_ORIGEN  			= "origen";			//String
    	public static final String COLUMN_NAME_FECHA  			= "fecha";			//String
    	public static final String COLUMN_NAME_NICKUSUARIO		= "nickusuario";	//String clave ajena usuario
    	public static final String CONSTRAINT_MENSAJE			= "idmensaje_pk";
    	public static final String SEQUENCE_MENSAJE_ID			= "mensaje_seq";
    	public static final String[] COLUMNS = {COLUMN_NAME_ID,COLUMN_NAME_TEXTO
												,COLUMN_NAME_DESTINO, COLUMN_NAME_ORIGEN, COLUMN_NAME_NICKUSUARIO, COLUMN_NAME_FECHA};
    	public static final String COLUMNAS = COLUMN_NAME_ID + ","+COLUMN_NAME_TEXTO + "," +
											COLUMN_NAME_DESTINO + "," + COLUMN_NAME_ORIGEN+ "," 
											+COLUMN_NAME_NICKUSUARIO + "," + COLUMN_NAME_FECHA;
    	
    }
    
    
    public static abstract class DatosGrupoUsuario {
    	public static final String TABLE_NAME = "GrupoUsuario";
    	public static final String COLUMN_NAME_NICKUSUARIO		="nickusuario";		//String
    	public static final String COLUMN_NAME_IDGRUPO			="idgrupo";			//int
    	public static final String CONSTRAINT_GUSUARIO		="idusuario_fk";		//clave ajena a idusuario
    	public static final String CONSTRAINT_GRUPOU		="idgrupo_fk";			//clave ajena a idgrupo
    	public static final String[] COLUMNS = {COLUMN_NAME_NICKUSUARIO, COLUMN_NAME_IDGRUPO};
    	
    	public static final String COLUMNAS = COLUMN_NAME_NICKUSUARIO + "," +
				COLUMN_NAME_IDGRUPO;
    }
    
    public static abstract class DatosNotificacion {
		public static final String TABLE_NAME 					= "Notificaciones";
    	public static final String COLUMN_NAME_ID 		   		= "id";				//int
    	public static final String COLUMN_NAME_USER 		   	= "usuario";		//String FK Usuario(nick)
    	public static final String COLUMN_NAME_TEXT		 	   	= "texto";			//String
    	public static final String COLUMN_NAME_DATE 	  		= "fecha";			//Date (con hora)
    	public static final String SEQUENCE_NOTIF_ID			= "notif_seq";		//id sequence
    	public static final String FK_USER_NOTIF				= "notif_fk";		//FK usuario
    	public static final String[] COLUMNS = {COLUMN_NAME_ID,COLUMN_NAME_USER
    											,COLUMN_NAME_TEXT,COLUMN_NAME_DATE};
    	public static final String COLUMNAS = COLUMN_NAME_ID + "," + COLUMN_NAME_USER + "," +
											COLUMN_NAME_TEXT + "," + COLUMN_NAME_DATE;
	}
    
    public static abstract class DatosAmistad {
    	public static final String TABLE_NAME = "Amistad";
    	public static final String COLUMN_NAME_NICKORIGEN		="nickorigen";		//String
    	public static final String COLUMN_NAME_NICKDESTINO		="nickdestino";			//int
    	public static final String CONSTRAINT_NICKORIGEN		="origen_fk";		//clave ajena a idusuario
    	public static final String CONSTRAINT_NICKDESTINO		="destino_fk";			//clave ajena a idgrupo
    	public static final String[] COLUMNS = {COLUMN_NAME_NICKORIGEN, COLUMN_NAME_NICKDESTINO};
    	
    	public static final String COLUMNAS = COLUMN_NAME_NICKORIGEN + "," +
				COLUMN_NAME_NICKDESTINO;
    }
    
 

	
}
