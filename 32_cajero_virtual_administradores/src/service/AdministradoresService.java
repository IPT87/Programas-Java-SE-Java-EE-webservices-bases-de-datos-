package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdministradoresService {
	
	public boolean comprobarCuenta(int numeroCuenta) {
		try (Connection con = Datos.getConnection()) {
			String sql = "SELECT numeroCuenta FROM cuentas";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				if (rs.getInt(1) == numeroCuenta) {
					return true;
				}
			}
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean comprobarDni(int dni) {
		try (Connection con = Datos.getConnection()) {
			String sql = "SELECT dni FROM clientes";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				if (rs.getInt(1) == dni) {
					return true;
				}
			}
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean addCuenta(int numeroCuenta, double saldo, String tipoCuenta) {
		try (Connection con = Datos.getConnection()) {
			String sql = "INSERT INTO cuentas(numeroCuenta, saldo, tipocuenta) values(?, ?, ?)";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, numeroCuenta);
			st.setDouble(2, saldo);
			st.setString(3, tipoCuenta);
			st.execute();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean addCliente(int dni, String nombre, String direccion, int telefono) {
		try (Connection con = Datos.getConnection()) {
			String sql = "INSERT INTO clientes(dni, nombre, direccion, telefono) values(?, ?, ?, ?)";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, dni);
			st.setString(2, nombre);
			st.setString(3, direccion);
			st.setInt(4, telefono);
			st.execute();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean addNuevoTitular(int numeroCuenta, double saldo, String tipoCuenta, int dni, String nombre, String direccion, int telefono) {
		addCuenta(numeroCuenta, saldo, tipoCuenta);
		addCliente(dni, nombre, direccion, telefono);
		
		try (Connection con = Datos.getConnection()) {
			String sql = "INSERT INTO titulares(idCuenta, idCliente) values(?, ?)";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, numeroCuenta);
			st.setInt(2, dni);
			st.execute();
	
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean addTitularCuentaExistente(int numeroCuenta, int dni, String nombre, String direccion, int telefono) {
		addCliente(dni, nombre, direccion, telefono);
		
		try (Connection con = Datos.getConnection()) {
			String sql = "INSERT INTO titulares(idCuenta, idCliente) values(?, ?)";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, numeroCuenta);
			st.setInt(2, dni);
			st.execute();
	
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
