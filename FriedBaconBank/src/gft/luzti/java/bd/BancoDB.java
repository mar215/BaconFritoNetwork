package gft.luzti.java.bd;

import gft.luzti.java.bd.ContractClass.DatosCliente;
import gft.luzti.java.bd.ContractClass.DatosCuenta;

public class BancoDB {

	public static final String DATABASE_CREATE_ACCOUNTS = "CREATE TABLE "
			+ DatosCuenta.TABLE_NAME					+ " ("
			+ DatosCuenta.COLUMN_NAME_ROWID				+ " NUMBER(6),"
			+ DatosCuenta.COLUMN_NAME_SALDO				+ " NUMBER(10,2))";
	
	public static final String DATABASE_CREATE_CLIENTS = "CREATE TABLE "
			+ DatosCliente.TABLE_NAME 					+ " (" 
			+ DatosCliente.COLUMN_NAME_USER				+ " VARCHAR2(10),"
			+ DatosCliente.COLUMN_NAME_PASS				+ " VARCHAR2(20),"
			+ DatosCliente.COLUMN_NAME_NOMBRE			+ " VARCHAR2(20),"
			+ DatosCliente.COLUMN_NAME_APELLIDOS		+ " VARCHAR2(40),"
			+ DatosCliente.COLUMN_NAME_DNI			 	+ " VARCHAR2(12)," 
			+ DatosCliente.COLUMN_NAME_CUENTA 			+ " NUMBER(6) CONSTRAINT fk_cuenta "
					+ "REFERENCES " + DatosCuenta.TABLE_NAME + "(" + DatosCuenta.COLUMN_NAME_ROWID + "))";
	
	public static final String DATABASE_ADD_CONSTRAINT_CLIENTS = "ALTER TABLE " 
			+ DatosCliente.TABLE_NAME + " ADD (CONSTRAINT " + DatosCliente.CONSTRAINT_USER 
			+ " PRIMARY KEY (" + DatosCliente.COLUMN_NAME_USER + "))";
	
	public static final String DATABASE_ADD_CONSTRAINT_ACCOUNTS = "ALTER TABLE " 
			+ DatosCuenta.TABLE_NAME + " ADD (CONSTRAINT " + DatosCuenta.CONSTRAINT_ACCOUNT 
			+ " PRIMARY KEY (" + DatosCuenta.COLUMN_NAME_ROWID + "))";
	
	public static final String DATABASE_ACCOUNT_SEQUENCE = "CREATE SEQUENCE " + DatosCuenta.SEQUENCE_ACCOUNT_ID;
	
	public static final String DATABASE_ACCOUNT_NEXT_ID	 = "SELECT " + DatosCuenta.SEQUENCE_ACCOUNT_ID
														 + ".NEXTVAL FROM DUAL";
	
	/*
	public static final String DATABASE_ACCOUNT_TRIGGER  = "CREATE OR REPLACE TRIGGER " + DatosCuenta.TRIGGER_ID 
			+ " BEFORE INSERT ON " + DatosCliente.TABLE_NAME 
			+ " FOR EACH ROW "
			+ "	BEGIN "
				+ "SELECT " + DatosCuenta.SEQUENCE_ACCOUNT_ID + ".NEXTVAL "
				+ " INTO   :new." + DatosCuenta.COLUMN_NAME_ROWID
				+ " FROM   dual;"
				+ "END";	
	*/
	
	public static String getCliente(String user){		
		return "SELECT * FROM " + DatosCliente.TABLE_NAME + " WHERE " + DatosCliente.COLUMN_NAME_USER + " = '" + user + "'";
	}
	
	public static String getCuenta(int id){		
		return "SELECT " + DatosCuenta.COLUMN_NAME_SALDO + " FROM " + DatosCuenta.TABLE_NAME + " WHERE " + DatosCuenta.COLUMN_NAME_ROWID + " = " + id;
	}
	
	public static String addSaldo(int id, double saldo){
		return "UPDATE " + DatosCuenta.TABLE_NAME + " SET " + DatosCuenta.COLUMN_NAME_SALDO + " = "
				+ DatosCuenta.COLUMN_NAME_SALDO + " + " + saldo + "WHERE " + DatosCuenta.COLUMN_NAME_ROWID
				+ " = " + id;
	}

}
