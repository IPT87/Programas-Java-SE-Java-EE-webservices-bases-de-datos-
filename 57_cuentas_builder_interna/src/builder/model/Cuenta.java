package builder.model;

public class Cuenta {
	
	private long numeroCuenta;
	private String titular;
	private double saldo;
	private String tipoCuenta;
	
	public static class CuentaBuilder{

		private long numeroCuenta;
		private String titular;
		private double saldo;
		private String tipoCuenta;
		
		
		public CuentaBuilder withNumero(long numeroCuenta) {
			this.numeroCuenta = numeroCuenta;
			return this;
		}
		
		public CuentaBuilder withTitular(String titular) {
			this.titular=titular;
			return this;
		}
		
		public CuentaBuilder withSaldo(double saldo) {
			this.saldo=saldo;
			return this;
		}
		public CuentaBuilder withTipoCuenta(String tipoCuenta) {
			this.tipoCuenta=tipoCuenta;
			return this;
		}
		
		public Cuenta build() {
			Cuenta cuenta=new Cuenta();
			cuenta.setNumeroCuenta(numeroCuenta);
			cuenta.setSaldo(saldo);
			cuenta.setTitular(titular);
			cuenta.setTipoCuenta(tipoCuenta);
			return cuenta;
		}
	}

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
