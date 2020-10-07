package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import model.Cliente;
import model.Cuenta;
import model.Movimiento;

class CajeroDaoImplJdbc implements CajeroDao {

	@Override
	public void insertarMovimiento(Movimiento movimiento) {
		try(Connection con = Datos.getConnection()) {
			String sql = "INSERT INTO movimientos (idCuenta, cantidad, fecha, operacion) values(?, ?, NOW(), ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, movimiento.getIdCuenta());
			ps.setDouble(2, movimiento.getCantidad());
			//ps.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
			ps.setString(3, movimiento.getOperacion());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actualizarSaldoCuenta(int numeroCuenta, double saldo) {
		try(Connection con = Datos.getConnection()) {
			String sql = "UPDATE cuentas SET saldo=? WHERE numeroCuenta=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setDouble(1, saldo);
			ps.setInt(2, numeroCuenta);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Cuenta recuperarCuenta(int numeroCuenta) {
		try(Connection con = Datos.getConnection()) {
			String sql = "SELECT * FROM cuentas WHERE numeroCuenta=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, numeroCuenta);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return new Cuenta(rs.getInt("numeroCuenta"), rs.getDouble("saldo"), rs.getString("tipocuenta"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Movimiento> recuperarMovimientos(int numeroCuenta) {
		List<Movimiento> movimientos = new ArrayList<>();
		try(Connection cn = Datos.getConnection();){	
			String sql = "SELECT * FROM movimientos WHERE idCuenta=?";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setInt(1, numeroCuenta);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				movimientos.add(new Movimiento(rs.getInt("idMovimiento"),
						rs.getInt("idCuenta"),
						rs.getTimestamp("fecha"),
						rs.getDouble("cantidad"),
						rs.getString("operacion")));
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return movimientos;
	}

	@Override
	public void insertarCliente(Cliente cliente) {
		try(Connection con = Datos.getConnection()) {
			String sql = "INSERT INTO clientes (dni, nombre, direccion, telefono) values(?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, cliente.getDni());
			ps.setString(2, cliente.getNombre());
			ps.setString(3, cliente.getDireccion());
			ps.setInt(4, cliente.getTelefono());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
