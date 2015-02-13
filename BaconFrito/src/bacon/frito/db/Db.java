package bacon.frito.db;

import java.sql.Date;
import java.util.ArrayList;

import bacon.frito.db.ContractClass.DatosGrupo;
import bacon.frito.db.ContractClass.DatosGrupoUsuario;
import bacon.frito.db.ContractClass.DatosMensaje;
import bacon.frito.db.ContractClass.DatosNotificacion;
import bacon.frito.db.ContractClass.DatosUsuario;

public class Db {
	//CREACION DE TABLAS
	
	public static final String DATABASE_CREATE_USUARIO = "CREATE TABLE "
			+ DatosUsuario.TABLE_NAME 					+ " (" 
			+ DatosUsuario.COLUMN_NAME_NICK				+ " varchar2(25) PRIMARY KEY NOT NULL, "
			+ DatosUsuario.COLUMN_NAME_PASS 			+ " varchar2(25) NOT NULL, "
			+ DatosUsuario.COLUMN_NAME_NOMBRE 			+ " varchar2(25), " 
			+ DatosUsuario.COLUMN_NAME_APELLIDOS 		+ " varchar2(50), " 
			+ DatosUsuario.COLUMN_NAME_TELEFONO			+ " varchar2(15), " 
			+ DatosUsuario.COLUMN_NAME_BDAY				+ " varchar2(10), "
			+ DatosUsuario.COLUMN_NAME_SEXO				+ " varchar2(25), "
			+ DatosUsuario.COLUMN_NAME_FOTO				+ " varchar2(500), "
			+ DatosUsuario.COLUMN_NAME_ACTIVO			+ " varchar2(10), "
			+ DatosUsuario.COLUMN_NAME_TIPO             + " varchar2(15) NOT NULL)";
	
	
	public static final String DATABASE_CREATE_GRUPO = "CREATE TABLE "
			+ DatosGrupo.TABLE_NAME						+ " ("
			+ DatosGrupo.COLUMN_NAME_ID					+ " number(6) PRIMARY KEY,"
			+ DatosGrupo.COLUMN_NAME_NOMBRE				+ " varchar2(25), "
			+ DatosGrupo.COLUMN_NAME_DESCRIPCION		+ " varchar2(500), "
			+ DatosGrupo.COLUMN_NAME_IMAGEN				+ " varchar2(100), "
			+ DatosGrupo.COLUMN_NAME_MAXINTEGRANTES		+ " number(3), "
			+ DatosGrupo.COLUMN_NAME_ACTIVO				+ " varchar(10))";
	
	public static final String DATABASE_CREATE_MENSAJE = "CREATE TABLE "
			+ DatosMensaje.TABLE_NAME					+ " ("
			+ DatosMensaje.COLUMN_NAME_ID				+ " number(6) PRIMARY KEY, "
			+ DatosMensaje.COLUMN_NAME_TEXTO			+ " varchar2(500), "
			+ DatosMensaje.COLUMN_NAME_DESTINO			+ " varchar2(25) NOT NULL, "
			+ DatosMensaje.COLUMN_NAME_ORIGEN			+ " varchar2(25) NOT NULL, "
			+ DatosMensaje.COLUMN_NAME_NICKUSUARIO		+ " varchar2(25) CONSTRAINT fk_nickusuario "
					+ "REFERENCES " + DatosUsuario.TABLE_NAME + "(" + DatosUsuario.COLUMN_NAME_NICK + "))";
	
	public static final String DATABASE_CREATE_GRUPOUSUARIO = "CREATE TABLE "
			+ DatosGrupoUsuario.TABLE_NAME				+ " ("
			+ DatosGrupoUsuario.COLUMN_NAME_NICKUSUARIO	+ " varchar2(25) CONSTRAINT FK_NICKUSUARIO1 "
			+ "REFERENCES " + DatosUsuario.TABLE_NAME + "(" + DatosUsuario.COLUMN_NAME_NICK + "), "
			+ DatosGrupoUsuario.COLUMN_NAME_IDGRUPO		+ " number(6) CONSTRAINT FK_IDGRUPO "
			+ "REFERENCES " + DatosGrupo.TABLE_NAME + "(" + DatosGrupo.COLUMN_NAME_ID + "))";
	
	//AÑADIENDO CLAVES PRIMARIAS
	
	public static final String DATABASE_ADD_CONSTRAINT_USUARIO = "ALTER TABLE " 
			+ DatosUsuario.TABLE_NAME + " ADD (CONSTRAINT " + DatosUsuario.CONSTRAINT_USUARIO 
			+ " PRIMARY KEY (" + DatosUsuario.COLUMN_NAME_NICK + "))";
	
	public static final String DATABASE_ADD_CONSTRAINT_GRUPO = "ALTER TABLE " 
			+ DatosGrupo.TABLE_NAME + " ADD (CONSTRAINT " + DatosGrupo.CONSTRAINT_GRUPO
			+ " PRIMARY KEY (" + DatosGrupo.COLUMN_NAME_ID + "))";
	
	public static final String DATABASE_ADD_CONSTRAINT_MENSAJE = "ALTER TABLE " 
			+ DatosMensaje.TABLE_NAME + " ADD (CONSTRAINT " + DatosMensaje.CONSTRAINT_MENSAJE 
			+ " PRIMARY KEY (" + DatosMensaje.COLUMN_NAME_ID + "))";
	
	//AÑADIENDO AUTOINCREMENTO ID
	
	
	public static final String DATABASE_GRUPO_SEQUENCE = "CREATE SEQUENCE " + DatosGrupo.SEQUENCE_GRUPO_ID;
	
	public static final String DATABASE_GRUPO_NEXT_ID	 = "SELECT " + DatosGrupo.SEQUENCE_GRUPO_ID
			 + ".NEXTVAL FROM DUAL";
	
	public static final String DATABASE_MENSAJE_SEQUENCE = "CREATE SEQUENCE " + DatosMensaje.SEQUENCE_MENSAJE_ID;
	
	public static final String DATABASE_MENSAJE_NEXT_ID	 = "SELECT " + DatosMensaje.SEQUENCE_MENSAJE_ID
			 + ".NEXTVAL FROM DUAL";
	
	
	//NOTIFICACIONES
	
	public static final String DATABASE_CREATE_NOTIF = "CREATE TABLE "
			+ DatosNotificacion.TABLE_NAME						+ " ("
			+ DatosNotificacion.COLUMN_NAME_ID					+ " NUMBER(6) PRIMARY KEY NOT NULL,"
			+ DatosNotificacion.COLUMN_NAME_USER				+ " VARCHAR2(25) CONSTRAINT " 
																+ DatosNotificacion.FK_USER_NOTIF
																+ " REFERENCES " + DatosUsuario.TABLE_NAME 
																+ "(" + DatosUsuario.COLUMN_NAME_NICK + "),"
			+ DatosNotificacion.COLUMN_NAME_TEXT				+ " VARCHAR2(500), "
			+ DatosNotificacion.COLUMN_NAME_DATE				+ " DATE)";

	/*
	CREATE TABLE Notificaciones (id NUMBER(6) PRIMARY KEY NOT NULL, 
									usuario VARCHAR2(25) CONSTRAINT notif_fk REFERENCES Usuario(nick),
									texto VARCHAR2(500),
									fecha DATE);
	*/

	public static final String DATABASE_NOTIF_SEQUENCE = "CREATE SEQUENCE " + DatosNotificacion.SEQUENCE_NOTIF_ID;
	//CREATE SEQUENCE notif_seq;
	
	public static final String DATABASE_NOTIF_NEXT_ID  = "SELECT " + DatosNotificacion.SEQUENCE_NOTIF_ID
			 													   + ".NEXTVAL FROM DUAL";
	//SELECT notif_seq.NEXTVAL FROM DUAL;

	public static String addNotif(int id, String usuario, String texto, Date fecha){
		return "INSERT INTO " + DatosNotificacion.TABLE_NAME + " ("
				+ DatosNotificacion.COLUMNAS +") VALUES ("
				+ id
				+ ", '"  + usuario
				+ "', '" + texto
				+ "', to_date('"  + fecha + "')"
				+ ")";	
	}
	//INSERT INTO Notificaciones(id, nick, texto, fecha) VALUES (notif_seq.nextval, 'usuario', 'texto', fecha);

	public static String getPerfil(String usuario){
		return "SELECT " + DatosNotificacion.COLUMN_NAME_TEXT + ", " + DatosNotificacion.COLUMN_NAME_DATE
			   + " FROM " + DatosNotificacion.TABLE_NAME
			   + " WHERE " + DatosNotificacion.COLUMN_NAME_USER + " = '" + usuario
			   + "' ORDER BY " + DatosNotificacion.COLUMN_NAME_DATE + " DESC";
	}
	//SELECT texto FROM Notificaciones WHERE usuario = 'nick' ORDER BY fecha DESC;

	public static String getNotif(ArrayList<String> usuarios){
		String result = "SELECT " + DatosNotificacion.COLUMN_NAME_USER + ", " + DatosNotificacion.COLUMN_NAME_TEXT
						+ ", " + DatosNotificacion.COLUMN_NAME_DATE
						+ " FROM " + DatosNotificacion.TABLE_NAME + " WHERE ";
		result += DatosNotificacion.COLUMN_NAME_USER + " = '" + usuarios.get(0) + "' ";
		if(usuarios.size() > 1){
			for(int i = 1; i < usuarios.size(); i++){
				result += "OR " + DatosNotificacion.COLUMN_NAME_USER + " = '" + usuarios.get(i) + "' ";
			}
		}
		result += " ORDER BY " + DatosNotificacion.COLUMN_NAME_DATE + " DESC";
		return result;
	}
	//SELECT texto FROM Notificaciones WHERE usuario = 'nick' ORDER BY fecha DESC;

	public static String getUsuarios(){
		return "SELECT " + DatosUsuario.COLUMN_NAME_NICK
			   + " FROM " + DatosUsuario.TABLE_NAME;
	}
	//SELECT nick FROM Usuario;

}
