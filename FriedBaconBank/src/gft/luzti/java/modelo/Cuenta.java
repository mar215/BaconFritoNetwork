package gft.luzti.java.modelo;

import gft.luzti.java.bd.DBHelper;

public class Cuenta {
	
	private int		numeroCuenta;
	private double  saldo;
	
	public Cuenta(int numeroCuenta, double saldo) {
		super();
		this.numeroCuenta = numeroCuenta;
		this.saldo = saldo;
	}
	
	public boolean cobrar(double cantidad){
		
		if(getSaldo() >= cantidad){
			setSaldo(getSaldo() - cantidad);
			DBHelper.getInstance().paySaldo(getNumeroCuenta(), cantidad);
			return true;
		}else{
			return false;
		}
	}
	
	public void ingresar(double cantidad){
		saldo += cantidad;
		DBHelper.getInstance().addSaldo(getNumeroCuenta(), cantidad);
		
	}
	
	@Override
	public String toString(){
		return "Nº Cuenta: " + getNumeroCuenta() 
				+ "  Saldo: " + getSaldo();
	}

	/**
	 * @return the numeroCuenta
	 */
	public int getNumeroCuenta() {
		return numeroCuenta;
	}

	/**
	 * @param numeroCuenta the numeroCuenta to set
	 */
	public void setNumeroCuenta(int numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	/**
	 * @return the saldo
	 */
	public double getSaldo() {
		return saldo;
	}

	/**
	 * @param saldo the saldo to set
	 */
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}	
}
