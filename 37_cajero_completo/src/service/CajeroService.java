package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Cuenta;
import model.Movimiento;

public class CajeroService {

	public Cuenta recuperarCuenta(int numeroCuenta) {
		try(Connection cn = Datos.getConnection();){
			String sql = "SELECT * FROM cuentas WHERE numeroCuenta = ?";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setInt(1, numeroCuenta);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return new Cuenta(rs.getInt("numeroCuenta"), rs.getDouble("saldo"), rs.getString("tipocuenta"));
			}
			return null;
		}
		catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public void extraer(double cantidad, int numeroCuenta) {
		try(Connection cn = Datos.getConnection();){
			cn.setAutoCommit(false);
			String sql = "UPDATE cuentas SET saldo = saldo - ? WHERE numeroCuenta = ?";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setDouble(1, cantidad);
			ps.setInt(2, numeroCuenta);			
			ps.execute();
			registrarMovimiento(numeroCuenta, cantidad, "extraccion", cn);
			cn.commit();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void ingresar(double cantidad, int numeroCuenta) {
		try(Connection cn = Datos.getConnection();){
			cn.setAutoCommit(false);
			String sql = "UPDATE cuentas SET saldo = saldo + ? WHERE numeroCuenta = ?";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setDouble(1, cantidad);
			ps.setInt(2, numeroCuenta);			
			ps.execute();
			registrarMovimiento(numeroCuenta, cantidad, "ingreso", cn);
			cn.commit();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private void registrarMovimiento(int numeroCuenta, double cantidad, String operacion, Connection cn) throws SQLException {		
			String sql = "INSERT INTO movimientos (idCuenta, cantidad, fecha, operacion) values(?, ?, ?, ?)";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setInt(1, numeroCuenta);
			ps.setDouble(2, cantidad);
			ps.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
			ps.setString(4, operacion);
			ps.execute();		
	}
	public double obtenerSaldo(int numeroCuenta) {
		return recuperarCuenta(numeroCuenta).getSaldo();
	}
	public List<Movimiento> obtenerMovimientos(int numeroCuenta){
		List<Movimiento> movimientos = new ArrayList<>();
		try(Connection cn = Datos.getConnection();){	
			String sql = "SELECT * FROM movimientos WHERE DATEDIFF(NOW(), fecha) <= 30 AND idCuenta = " + 1234;
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				movimientos.add(new Movimiento(rs.getInt("idMovimiento"),
						rs.getInt("idCuenta"),
						rs.getDate("fecha"),
						rs.getDouble("cantidad"),
						rs.getString("operacion")));
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return movimientos;
	}
	public void transferencia(int cuentaOrigen, int cuentaDestino, double cantidad) {
		ingresar(cantidad,cuentaDestino);
		extraer(cantidad,cuentaOrigen);
	}
}