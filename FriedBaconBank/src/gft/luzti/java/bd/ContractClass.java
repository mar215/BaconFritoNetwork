package gft.luzti.java.bd;

public class ContractClass {

	public ContractClass() {}
	
	public static abstract class DatosCliente {
        public static final String TABLE_NAME = "Clientes";
        public static final String COLUMN_NAME_USER			= "user";		//int primary key
        public static final String COLUMN_NAME_PASS 		= "pass";		//String
        public static final String COLUMN_NAME_NOMBRE 		= "nombre";		//String
        public static final String COLUMN_NAME_APELLIDOS 	= "apellidos";	//String
        public static final String COLUMN_NAME_DNI		 	= "dni";		//String
        public static final String COLUMN_NAME_CUENTA		= "cuenta";		//int foreign key datos cuenta
        public static final String CONSTRAINT_USER			= "user_pk";
        public static final String[] COLUMNS = {COLUMN_NAME_USER, COLUMN_NAME_PASS
        										,COLUMN_NAME_NOMBRE, COLUMN_NAME_APELLIDOS
        										,COLUMN_NAME_DNI, COLUMN_NAME_CUENTA};
        public static final String COLUMNAS = COLUMN_NAME_USER + "," + COLUMN_NAME_PASS
        	 								+ "," + COLUMN_NAME_NOMBRE + "," + COLUMN_NAME_APELLIDOS
        	 								+ "," + COLUMN_NAME_DNI + "," + COLUMN_NAME_CUENTA;
	}
	
	public static abstract class DatosCuenta {
        public static final String TABLE_NAME = "Cuentas";
        public static final String COLUMN_NAME_ROWID		= "id";			//int primary key
        public static final String COLUMN_NAME_SALDO 		= "saldo";		//double
        public static final String CONSTRAINT_ACCOUNT		= "id_account_pk";
        public static final String SEQUENCE_ACCOUNT_ID		= "account_seq";
        //public static final String TRIGGER_ID				= "account_tri";
        public static final String[] COLUMNS = {COLUMN_NAME_ROWID, COLUMN_NAME_SALDO};
	}
	
}
