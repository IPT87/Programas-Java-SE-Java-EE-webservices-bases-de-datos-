package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import model.Libro;
import service.Datos;

@RequestScoped
@Named("librosDaoJdbc")
public class LibrosDaoJDBC implements LibrosDao {

	@Override
	public List<Libro> recuperarTodos() {
		List<Libro> lista=new ArrayList<> ();
        try(Connection cn=Datos.getConnection();) {                       
        	String sql="select * from libros";
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sql);            
            while(rs.next()){
                lista.add(new Libro(rs.getInt("isbn"),
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getDouble("precio"),
                        rs.getInt("paginas"),
                        rs.getInt("idTema")));
            }
        }  catch (SQLException ex) {
            ex.printStackTrace();
        }   
        return lista;
	}

	@Override
	public List<Libro> recuperarPorTema(int idTema) {
		List<Libro> lista=new ArrayList<> ();
        try(Connection cn=Datos.getConnection();) {                       
        	String sql="select * from libros where idTema=?";
            PreparedStatement st=cn.prepareStatement(sql);
            st.setInt(1, idTema);
            ResultSet rs=st.executeQuery();            
            while(rs.next()){
                lista.add(new Libro(rs.getInt("isbn"),
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getDouble("precio"),
                        rs.getInt("paginas"),
                        rs.getInt("idTema")));
            }
        }  catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
	}

	@Override
	public Libro recuperarPorIsbn(int isbn) {
		Libro lib=null;
		try(Connection cn=Datos.getConnection();){
			
			String sql="select * from libros where isbn=?";
			PreparedStatement ps=cn.prepareStatement(sql);
			ps.setInt(1, isbn);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				lib=new Libro(isbn,
								rs.getString("titulo"),
								rs.getString("autor"),
								rs.getDouble("precio"),
								rs.getInt("paginas"),
								rs.getInt("idTema"));
			}
			
		}
		catch (SQLException ex) {
            ex.printStackTrace();
        } 
		return lib;
	}

}
