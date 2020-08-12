package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class CajeroVirtualService {
	
	public boolean validarCuenta(int numeroCuenta) {
		try(Connection con = Datos.getConnection()) {
			String sql = "SELECT numeroCuenta FROM cuentas"; 
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				if (rs.getInt(1) == numeroCuenta) {
					return true;
				}
			}
			return false;
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean ingresarDinero(int cantidad, int numeroCuenta) {
		try(Connection con = Datos.getConnection()) {
			String sql = "UPDATE cuentas SET saldo = saldo + ? WHERE numeroCuenta = ?"; 
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, cantidad);
			st.setInt(2, numeroCuenta);
			st.execute(); 	
			
			String sql1 = "INSERT INTO movimientos(idCuenta, fecha, cantidad, operacion) values(?, ?, ?, ?)"; 
			PreparedStatement st1 = con.prepareStatement(sql1);
			st1.setInt(1, numeroCuenta);
			st1.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
			st1.setInt(3, cantidad);
			st1.setString(4, "ingreso");
			st1.execute();
			
			return true;
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean extraerDinero(int cantidad, int numeroCuenta) {
		try(Connection con = Datos.getConnection()) {
			int saldo = 0;
			
			String sql = "SELECT saldo FROM cuentas WHERE numeroCuenta = " + numeroCuenta; 
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			if (rs.next()) {
				saldo = rs.getInt("saldo");
			}
			
			if (saldo - cantidad >= 0) {
				String sql1 = "UPDATE cuentas SET saldo = saldo - ? WHERE numeroCuenta = ?"; 
				PreparedStatement pst = con.prepareStatement(sql1);
				pst.setInt(1, cantidad);
				pst.setInt(2, numeroCuenta);
				pst.execute();
				
				String sql2 = "INSERT INTO movimientos(idCuenta, fecha, cantidad, operacion) values(?, ?, ?, ?)"; 
				PreparedStatement st2 = con.prepareStatement(sql2);
				st2.setInt(1, numeroCuenta);
				st2.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
				st2.setInt(3, cantidad);
				st2.setString(4, "extracción");
				st2.execute();
				
				return true;
			} else {
				return false;
			}
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean mostrarSaldoMovimientos(int numeroCuenta) {
		SimpleDateFormat sdt = new SimpleDateFormat("dd-MM-YYYY HH:mm:ss");
		
		try(Connection con = Datos.getConnection()) {
			String sql = "SELECT fecha, cantidad, operacion FROM movimientos WHERE DATEDIFF(NOW(), fecha) <= 30 AND idCuenta = " + numeroCuenta; 
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while (rs.next()) {
				System.out.println("Usted realizo " + rs.getString("operacion") + " de " + rs.getInt("cantidad") + "€" + " el dia " + sdt.format(rs.getTimestamp("fecha")) + ".");
			}
			
			String sql1 = "SELECT saldo FROM cuentas WHERE numeroCuenta = " + numeroCuenta; 
			Statement st1 = con.createStatement();
			ResultSet rs1 = st1.executeQuery(sql1);
			
			if (rs1.next()) {
				System.out.println("Saldo: " + rs1.getInt("saldo") + "€.");
			}
			
			return true;
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean realizarTransferencia(int cantidad, int numeroCuentaOrigen, int numeroCuentaDestino) {
		if(validarCuenta(numeroCuentaDestino) && extraerDinero(cantidad, numeroCuentaOrigen))  {
			ingresarDinero(cantidad, numeroCuentaDestino);
			return true;
		} else {
			return false;
		}
	}
}
