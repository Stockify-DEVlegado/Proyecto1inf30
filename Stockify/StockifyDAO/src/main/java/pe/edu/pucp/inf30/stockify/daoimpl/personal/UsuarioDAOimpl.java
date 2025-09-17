/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.inf30.stockify.daoimpl.personal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import pe.edu.pucp.inf30.stockify.dao.personal.UsuarioDAO;
import pe.edu.pucp.inf30.stockify.daoimpl.BaseDAO;
import pe.edu.pucp.inf30.stockify.model.personal.Usuario;
import pe.edu.pucp.inf30.stockify.model.personal.TipoUsuario;

/**
 *
 * @author Personal
 */
public class UsuarioDAOimpl extends BaseDAO<Usuario> implements 
        UsuarioDAO{
    @Override
    protected PreparedStatement comandoCrear(Connection conn, 
            Usuario modelo) throws SQLException {
        
        String sql = 
                "INSERT INTO Usuario ("
                + "idUsuario, "
                + " nombres, "
                + " apellidos, "
                + " email, "
                + " telefono, "
                + " activo, "
                + " cuenta, "
                + " tipoUsuario)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        PreparedStatement cmd = conn.prepareStatement(sql, 
                Statement.RETURN_GENERATED_KEYS);
        cmd.setInt(1, modelo.getIdUsuario());
        if (modelo.getCuenta()!= null) {
            cmd.setInt(7, modelo.getCuenta().getIdCuentaUsuario());
        }
        else {
            cmd.setNull(7, Types.INTEGER);
        }
        cmd.setString(2, modelo.getNombres());
        cmd.setString(3, modelo.getApellidos());
        cmd.setString(4, modelo.getEmail());
        cmd.setString(5, modelo.getTelefono());
        cmd.setBoolean(6, modelo.isActivo());
        cmd.setString(8, String.valueOf(modelo.getTipoUsuario()));
        return cmd;
    }

    @Override
    protected PreparedStatement comandoActualizar(Connection conn, 
            Usuario modelo) throws SQLException {
        
        String sql = 
                "UPDATE Usuario "
                + "SET "
                + " cuenta = ?, "
                + " nombres = ?, "
                + " apellidos = ?, "
                + " email = ?, "
                + " telefono = ?, "
                + " activo = ?, "
                + " tipoUsuario = ? "
                + "WHERE "  
                + " idUsuario = ?";
        
        PreparedStatement cmd = conn.prepareStatement(sql);
         if (modelo.getCuenta()!= null) {
            cmd.setInt(1, modelo.getCuenta().getIdCuentaUsuario());
        }
        else {
            cmd.setNull(1, Types.INTEGER);
        }
        cmd.setString(2, modelo.getNombres());
        cmd.setString(3, modelo.getApellidos());
        cmd.setString(4, modelo.getEmail());
        cmd.setString(5, modelo.getTelefono());
        cmd.setBoolean(6, modelo.isActivo());
        cmd.setString(7, String.valueOf(modelo.getTipoUsuario()));
        cmd.setInt(8, modelo.getIdUsuario());
        return cmd;
    }

    @Override
    protected PreparedStatement comandoEliminar(Connection conn, 
            Integer id) throws SQLException {
        
        String sql = 
                "DELETE "
                + "FROM Usuario "
                + "WHERE idUsuario = ?";
        
        PreparedStatement cmd = conn.prepareStatement(sql);
        cmd.setInt(1, id);
        
        return cmd;
    }

    @Override
    protected PreparedStatement comandoLeer(Connection conn, 
            Integer id) throws SQLException {
        
        String sql = 
                "SELECT "
                + " idCuentaUsuario, "
                + " nombres, "
                + " apellidos, "
                + " email, "
                + " telefono, "
                + " activo, "
                + " tipo usuario, "
                + "FROM EMPLEADO "
                + " idUsuario = ?";
        
        PreparedStatement cmd = conn.prepareStatement(sql);
        cmd.setInt(1, id);
        
        return cmd;
    }

    @Override
    protected PreparedStatement comandoLeerTodos(Connection conn) 
            throws SQLException {
        
        String sql = 
                "SELECT "
                + " id, "
                + " idArea, "
                + " idCuentaUsuario, "
                + " dni, "
                + " nombre, "
                + " apellidoPaterno, "
                + " genero, "
                + " fechaNacimiento, "
                + " cargo, "
                + " sueldo, "
                + " activo "
                + "FROM Usuario";
                
        PreparedStatement cmd = conn.prepareStatement(sql);
        
        return cmd;
    }

    @Override
    protected Usuario mapearModelo(ResultSet rs) throws SQLException {
        Usuario usuario = new Usuario();
        
        int idCuentaUsuario = rs.getInt("idCuentaUsuario");
        if (!rs.wasNull()) {
            usuario.setCuenta(
                    new CuentaUsuarioDAOimpl().leer(idCuentaUsuario));
        }
        
        usuario.setIdUsuario(rs.getInt("id"));
        usuario.setNombres(rs.getString("userName"));
        usuario.setApellidos(rs.getString("password"));
        usuario.setEmail(rs.getString("email"));
        usuario.setTelefono(rs.getString("telefono"));
        usuario.setActivo(rs.getBoolean("activo"));
        usuario.setTipoUsuario(TipoUsuario.valueOf(rs.getString("tipo usuario")));
        
        return usuario;
    }    
}
