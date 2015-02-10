package gft.luzti.java.bd;

import gft.luzti.java.bd.ContractClass.DatosCliente;
import gft.luzti.java.bd.ContractClass.DatosCuenta;
import gft.luzti.java.modelo.Cliente;
import gft.luzti.java.modelo.Cuenta;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBHelper {
	
	private static DBHelper instancia;
	
	static{
		instancia 	= new DBHelper();
	}
	
	private DBHelper(){
		if(!init()){
			System.err.println("Error en el constructor de DBHelper");
		}
	}
	
	public DBHelper getInstance(){
		return instancia;
	}

	private Connection getConexion() {
		
		Connection 	conexion 	= null;
		Context ic = null;
		try {
			ic = new InitialContext();
		} catch (NamingException e) {
			System.err.println("Error al inicializar el contexto (getConexion)");
			e.printStackTrace();
			return null;
		}
		DataSource miDS = null;
		try {
			miDS = (DataSource) ic.lookup("java:comp/env/jdbc/DataSourceBank");
		} catch (NamingException e) {
			System.err.println("Error al inicializar el dataSource (getConexion)");
			e.printStackTrace();
			return null;
		}
		
		try {
			conexion	= miDS.getConnection();
		} catch (SQLException e) {
			System.err.println("Error al obtener la conexión (getConexion)");
			e.printStackTrace();
			return null;
		}
		
		return conexion;
	}
	
	private boolean init(){
		Connection conexion = getConexion();
		Statement  stat = null;
		try {
			stat = conexion.createStatement();
		} catch (SQLException e) {
			System.err.println("Error al crear el Statement (init)");
			e.printStackTrace();
			return false;
		}
		
		// Creamos, si no existe, la tabla de cuentas
		try {
			stat.executeUpdate(BancoDB.DATABASE_CREATE_ACCOUNTS);
		} catch (SQLException e) {
			System.err.println("Error al crear la tabla cuentas (init)");
			e.printStackTrace();
			return false;
		}
		
		// Creamos, si no exite, la constraint primary key de cuentas
		try {
			stat.executeUpdate(BancoDB.DATABASE_ADD_CONSTRAINT_ACCOUNTS);
		} catch (SQLException e) {
			System.err.println("Error al crear la constraint primary key cuentas (init)");
			e.printStackTrace();
			return false;
		}
		
		// Creamos, si no exite, la secuencia para cuentas
		try {
			stat.executeUpdate(BancoDB.DATABASE_ACCOUNT_SEQUENCE);
		} catch (SQLException e) {
			System.err.println("Error al crear la secuencia para cuentas (init)");
			e.printStackTrace();
			return false;
		}
		/*
		// Creamos, si no exite, la constraint de secuencia para cuentas
		try {
			stat.executeUpdate(BancoDB.DATABASE_ACCOUNT_TRIGGER);
		} catch (SQLException e) {
			System.err.println("Error al crear el trigger para la secuencia de cuentas (init)");
			e.printStackTrace();
			return false;
		}
		*/	
		// Creamos, si no exite, la tabla de clientes
		try {
			stat.executeUpdate(BancoDB.DATABASE_CREATE_ACCOUNTS);
		} catch (SQLException e) {
			System.err.println("Error al crear la tabla cuentas (init)");
			e.printStackTrace();
			return false;
		}
		
		// Creamos, si no exite, la constraint primary key de clientes
		try {
			stat.executeUpdate(BancoDB.DATABASE_ADD_CONSTRAINT_CLIENTS);
		} catch (SQLException e) {
			System.err.println("Error al crear la constraint primary key de cliente (init)");
			e.printStackTrace();
			return false;
		}
		
		try {
			conexion.close();
		} catch (SQLException e) {
			System.err.println("Error al cerrar la conexión (init)");
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public boolean addCliente(Cliente cliente){
		Connection 	conexion 	= getConexion();
		Statement 	stat		= null; 
		try {
			stat = conexion.createStatement();
		} catch (SQLException e) {
			System.err.println("Error al crear el Statement");
			e.printStackTrace();
			return false;
		}
		
		// TODO: Comprobar que no existe un usuario con el mismo user
		
		String insertar = "INSERT INTO " + DatosCliente.TABLE_NAME + "(" + DatosCliente.COLUMNAS + ") "
						+ "VALUES (" + cliente.getUser() + "," + cliente.getPass() + ","
									 + cliente.getNombre() + "," + cliente.getApellidos() + ","
									 + cliente.getDni() + "," + cliente.getCuenta().getNumeroCuenta() + ")";
		
		try {
			stat.executeUpdate(insertar);
		} catch (SQLException e) {
			System.err.println("Error al insertar un nuevo cliente (addCliente)");
			e.printStackTrace();
			return false;
		}
		
		try {
			conexion.close();
		} catch (SQLException e) {
			System.err.println("Error al cerrar la conexión (addCliente)");
			e.printStackTrace();
			return false;
		}
		
		
		return true;
	}
	
	public Cuenta addCuenta(double saldoInicial){
		Connection 	conexion 	= getConexion();
		Statement 	stat		= null; 
		Cuenta		cuenta		= null;
		ResultSet 	rs			= null;
		int 		id			= -1;
		try {
			stat = conexion.createStatement();
		} catch (SQLException e) {
			System.err.println("Error al crear el Statement (addCuenta)");
			e.printStackTrace();
			return null;
		}
		
		try {
			rs = stat.executeQuery(BancoDB.DATABASE_ACCOUNT_NEXT_ID);
		} catch (SQLException e1) {
			System.err.println("Error al obtener el siguiente id cuenta (addCuenta)");
			e1.printStackTrace();
			return null;
		}
		
		try {
			rs.first();
			id = rs.getInt(1);
		} catch (SQLException e1) {
			System.err.println("Error al obtener el id del resultset (addCuenta)");
			e1.printStackTrace();
			return null;
		}
				
		String insertar = "INSERT INTO " + DatosCuenta.TABLE_NAME 
							+ "(" + DatosCuenta.COLUMN_NAME_ROWID + "," + DatosCuenta.COLUMN_NAME_SALDO + ") "
						+ "VALUES ("+ id + "," + saldoInicial + ")";
		
		try {
			stat.executeUpdate(insertar);
		} catch (SQLException e) {
			System.err.println("Error al insertar una nueva cuenta (addCuenta)");
			e.printStackTrace();
			return null;
		}
		
		cuenta = new Cuenta(id, saldoInicial);
		
		try {
			conexion.close();
		} catch (SQLException e) {
			System.err.println("Error al cerrar la conexión (addCuenta)");
			e.printStackTrace();
			return null;
		}
		
		
		return cuenta;
	}
	
	public Cliente login(String user, String pass){
		Connection conexion = getConexion();
		Statement stat 		= null;
		ResultSet rs		= null;
		
		//Obtenemos el Statement para hacer ejecutar la sentencia
		try {
			stat = conexion.createStatement();
		} catch (SQLException e) {
			System.err.println("Error al crear el Statement (login)");
			e.printStackTrace();
			return null;
		}		
		
		//Obtenemos la fila del cliente que solicitamos
		try {
			rs = stat.executeQuery(BancoDB.getCliente(user));
		} catch (SQLException e1) {
			System.err.println("Error al obtener el siguiente id cuenta (login)");
			e1.printStackTrace();
			return null;
		}
		
		//Comprobamos que hemos obtenido resultados
		try {
			if(!rs.first()){
				conexion.close();
				return null;
			}else{//hay resultados-> comprobamos el pass
				if(rs.getString(DatosCliente.COLUMN_NAME_PASS).equals(pass)){
					Cliente cliente = new Cliente(rs.getString(DatosCliente.COLUMN_NAME_USER), 
												  rs.getString(DatosCliente.COLUMN_NAME_PASS), 
												  rs.getString(DatosCliente.COLUMN_NAME_NOMBRE), 
												  rs.getString(DatosCliente.COLUMN_NAME_APELLIDOS), 
												  rs.getString(DatosCliente.COLUMN_NAME_DNI), 
												  getCuenta(rs.getInt(DatosCliente.COLUMN_NAME_CUENTA)));
					conexion.close();
					return cliente;
				}else{//La password no coincide
					conexion.close();
					return null;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public Cuenta getCuenta(int id){
		Connection conexion = getConexion();
		Statement stat 		= null;
		ResultSet rs		= null;
		
		//Obtenemos el Statement para hacer ejecutar la sentencia
		try {
			stat = conexion.createStatement();
		} catch (SQLException e) {
			System.err.println("Error al crear el Statement (getCuenta)");
			e.printStackTrace();
			return null;
		}		
		
		//Obtenemos la fila del cliente que solicitamos
		try {
			rs = stat.executeQuery(BancoDB.getCuenta(id));
		} catch (SQLException e1) {
			System.err.println("Error al obtener el RS de saldo (getCuenta)");
			e1.printStackTrace();
			return null;
		}
		
		try {
			if(!rs.first()){
				conexion.close();
				return null;
			}else{
				return new Cuenta(id, rs.getDouble(DatosCuenta.COLUMN_NAME_SALDO));
			}
		} catch (SQLException e) {
			System.err.println("Error al obtener el saldo (getCuenta)");
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean addSaldo(int id, double saldo){
		Connection conexion = getConexion();
		Statement stat 		= null;
		ResultSet rs		= null;
		
		//Obtenemos el Statement para hacer ejecutar la sentencia
		try {
			stat = conexion.createStatement();
		} catch (SQLException e) {
			System.err.println("Error al crear el Statement (addSaldo)");
			e.printStackTrace();
		}
		
		//Obtenemos la fila del cliente que solicitamos
		try {
			stat.executeQuery(BancoDB.addSaldo(id, saldo));
			conexion.close();
			return true;
		} catch (SQLException e1) {
			System.err.println("Error al actulizar el saldo (addSaldo)");
			e1.printStackTrace();
			return false;
		}
		
	}
	
}





































