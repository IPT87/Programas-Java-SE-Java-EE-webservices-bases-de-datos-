package builder.model;

public class CuentaBuilder implements Builder {

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