package builder.model;

public class Cuenta {
	private long numeroCuenta;
	private String titular;
	private double saldo;
	private String tipoCuenta;
	public long getNumeroCuenta() {
		return numeroCuenta;
	}
	void setNumeroCuenta(long numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}
	public String getTitular() {
		return titular;
	}
	void setTitular(String titular) {
		this.titular = titular;
	}
	public double getSaldo() {
		return saldo;
	}
	void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public String getTipoCuenta() {
		return tipoCuenta;
	}
	void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}
	@Override
	public String toString() {
		return "Cuenta [numeroCuenta=" + numeroCuenta + ", titular=" + titular + ", saldo=" + saldo + ", tipoCuenta="
				+ tipoCuenta + "]";
	}
	
}
