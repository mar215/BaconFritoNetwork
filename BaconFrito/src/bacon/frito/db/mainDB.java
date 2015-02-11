package bacon.frito.db;

public class mainDB {

	public static void main(String[] args) {
		//CREACIONTABLAS
		/*String sSQL = Db.DATABASE_CREATE_USUARIO;
		System.out.println(sSQL);
		
		String sSQL1 = Db.DATABASE_CREATE_GRUPO;
		System.out.println(sSQL1);
		
		String sSQL2 = Db.DATABASE_CREATE_MENSAJE;
		System.out.println(sSQL2);
		
		String sSQL3 = Db.DATABASE_CREATE_GRUPOUSUARIO;
		System.out.println(sSQL3);*/
		
		//AÑADIRSECUENCIAS
		
		String sSQL = Db.DATABASE_MENSAJE_SEQUENCE;
		System.out.println(sSQL);
		String sSQL1 = Db.DATABASE_MENSAJE_NEXT_ID;
		System.out.println(sSQL1);
		
		String sSQL2 = Db.DATABASE_GRUPO_SEQUENCE;
		System.out.println(sSQL2);
		String sSQL3 = Db.DATABASE_GRUPO_NEXT_ID;
		System.out.println(sSQL3);
		
	}

}
