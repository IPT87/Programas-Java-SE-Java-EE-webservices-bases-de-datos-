package principal;

import builder.model.Cuenta;
import builder.model.Cuenta.CuentaBuilder;

public class ClienteCuenta {

	public static void main(String[] args) {
		long numeroCuenta=200;
		double saldo=300;
		String titular="prueba";
		String tipo="ahorro";
		//CuentaBuilder builder=new Cuenta().new CuentaBuilder();
		CuentaBuilder builder=new Cuenta.CuentaBuilder();
		Cuenta cuenta=builder
				.withNumero(numeroCuenta)
				.withSaldo(saldo)
				.withTitular(titular)
				.withTipoCuenta(tipo)
				.build();
		System.out.println(cuenta);
		
	}

}
