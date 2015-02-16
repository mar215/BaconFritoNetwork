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
	
	private DBHelper(){}
	
	public static DBHelper getInstance(){
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
	
	/*
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
		
		// Creamos, si no exite, la tabla de clientes
		try {
			stat.executeUpdate(BancoDB.DATABASE_CREATE_CLIENTS);
		} catch (SQLException e) {
			System.err.println("Error al crear la tabla clientes (init)");
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
		
		// Creamos, si no exite, la constraint primary key de clientes
		try {
			stat.executeUpdate("commit");
		} catch (SQLException e) {
			System.err.println("Error al hacer commit (init)");
			e.printStackTrace();
			return false;
		}
		
		//Cerramos la conexión
		try {
			conexion.close();
		} catch (SQLException e) {
			System.err.println("Error al cerrar la conexión (init)");
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	*/
	
	public boolean addCliente(Cliente cliente){
		Connection 	conexion 	= getConexion();
		Statement	checkU		= null;
		Statement 	stat		= null; 
		ResultSet	rs			= null;
		try {
			stat 	= conexion.createStatement();
			checkU 	= conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		} catch (SQLException e) {
			System.err.println("Error al crear el Statement (addCliente");
			e.printStackTrace();
			return false;
		}
		
		// TODO: Comprobar que no existe un usuario con el mismo user
		String comprobar = "SELECT * FROM " + DatosCliente.TABLE_NAME 
						 + " WHERE " + DatosCliente.COLUMN_NAME_USER + " = '" + cliente.getUser() + "'";
		
		try {
			rs = checkU.executeQuery(comprobar);
		} catch (SQLException e) {
			System.err.println("Error al comprobar existencia cliente (addCliente)");
			e.printStackTrace();
			return false;
		}
		
		try {
			if(rs.next()){
				conexion.close();
				return false;
			}
		} catch (SQLException e1) {
			System.err.println("Error al comprobra el RS de existencia cliente (addCliente)");
			e1.printStackTrace();
		}
		
		String insertar = "INSERT INTO " + DatosCliente.TABLE_NAME + "(" + DatosCliente.COLUMNAS + ") "
						+ "VALUES ('" + cliente.getUser() + "','" + cliente.getPass() + "','"
									 + cliente.getNombre() + "','" + cliente.getApellidos() + "','"
									 + cliente.getDni() + "'," + cliente.getCuenta().getNumeroCuenta() + ")";
		
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
			stat = conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
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
	
	public boolean login(String user, String pass){
		Connection conexion = getConexion();
		Statement stat 		= null;
		ResultSet rs		= null;
		
		try {
			stat = conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		} catch (SQLException e) {
			System.err.println("Error al crear el Statement (login)");
			e.printStackTrace();
			return false;
		}		
		
		try {
			rs = stat.executeQuery(BancoDB.getCliente(user.toLowerCase()));
		} catch (SQLException e1) {
			System.err.println("Error al obtener el RS (login)");
			e1.printStackTrace();
			return false;
		}
		
		try {
			if(!rs.first()){
				conexion.close();
				return false;
			}else{
				if(rs.getString(DatosCliente.COLUMN_NAME_PASS).equals(pass)){
					conexion.close();
					return true;
				}else{
					conexion.close();
					return false;
				}
			}
		} catch (SQLException e) {
			System.err.println("Error al comprobar el login (login)");
			e.printStackTrace();
		}
		return false;
	}
	
	public Cliente getCliente(String user){
		Connection conexion = getConexion();
		Statement stat 		= null;
		ResultSet rs		= null;
		
		try {
			stat = conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		} catch (SQLException e) {
			System.err.println("Error al crear el Statement (getCliente)");
			e.printStackTrace();
			return null;
		}		
		
		try {
			rs = stat.executeQuery(BancoDB.getCliente(user));
		} catch (SQLException e1) {
			System.err.println("Error al obtener el RS (getCliente)");
			e1.printStackTrace();
			return null;
		}
		
		try {
			if(rs.next()){
				Cliente cliente = new Cliente(rs.getString(DatosCliente.COLUMN_NAME_USER), 
						rs.getString(DatosCliente.COLUMN_NAME_PASS), 
						rs.getString(DatosCliente.COLUMN_NAME_NOMBRE), 
						rs.getString(DatosCliente.COLUMN_NAME_APELLIDOS), 
						rs.getString(DatosCliente.COLUMN_NAME_DNI), 
						getCuenta(rs.getInt(DatosCliente.COLUMN_NAME_CUENTA)));
				conexion.close();
				return cliente;
			}else{
				conexion.close();
				return null;
			}
		} catch (SQLException e) {
			System.err.println("Error en la obtención de los datos de cliente (getCliente)");
			e.printStackTrace();
			return null;
		}
	}
	
	public Cuenta getCuenta(int id){
		Connection conexion = getConexion();
		Statement stat 		= null;
		ResultSet rs		= null;
		
		try {
			stat = conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		} catch (SQLException e) {
			System.err.println("Error al crear el Statement (getCuenta)");
			e.printStackTrace();
			return null;
		}		
		
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
		
		try {
			stat = conexion.createStatement();
		} catch (SQLException e) {
			System.err.println("Error al crear el Statement (addSaldo)");
			e.printStackTrace();
		}
		
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
	
	public boolean paySaldo(int id, double saldo){
		Connection conexion = getConexion();
		Statement stat 		= null;
		
		try {
			stat = conexion.createStatement();
		} catch (SQLException e) {
			System.err.println("Error al crear el Statement (paySaldo)");
			e.printStackTrace();
		}
		
		try {
			stat.executeQuery(BancoDB.paySaldo(id, saldo));
			conexion.close();
			return true;
		} catch (SQLException e1) {
			System.err.println("Error al actulizar el saldo (paySaldo)");
			e1.printStackTrace();
			return false;
		}
		
	}
	
}





































