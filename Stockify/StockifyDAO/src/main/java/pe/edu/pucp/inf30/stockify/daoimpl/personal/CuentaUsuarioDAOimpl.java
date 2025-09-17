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
import pe.edu.pucp.inf30.stockify.dao.personal.CuentaUsuarioDAO;
import pe.edu.pucp.inf30.stockify.daoimpl.BaseDAO;
import pe.edu.pucp.inf30.stockify.model.personal.CuentaUsuario;

/**
 *
 * @author Martino
 */
public class CuentaUsuarioDAOimpl extends BaseDAO<CuentaUsuario> implements 
        CuentaUsuarioDAO{
    @Override
    protected PreparedStatement comandoCrear(Connection conn, 
            CuentaUsuario modelo) throws SQLException {
        
        String sql = 
                "INSERT INTO CuentaUsuario ("
                + "idCuentaUsuario, "
                + "userName, "
                + " password, "
                + " ultimoAcceso ) "
                + "VALUES (?, ?, ?, ?)";
        
        PreparedStatement cmd = conn.prepareStatement(sql, 
                Statement.RETURN_GENERATED_KEYS);
        cmd.setInt(1, modelo.getIdCuentaUsuario());
        cmd.setString(2, modelo.getUsername());
        cmd.setString(3, modelo.getPassword());
        cmd.setDate(4, new java.sql.Date(modelo.getUltimoAcceso().getTime()));
        
        return cmd;
    }

    @Override
    protected PreparedStatement comandoActualizar(Connection conn, 
            CuentaUsuario modelo) throws SQLException {
        
        String sql = 
                "UPDATE CuentaUsuario "
                + "SET "
                + " userName = ?, "
                + " password = ?, "
                + " ultimoAcceso = ? "
                + "WHERE "
                + " idCuentaUsuario = ?";
        
        PreparedStatement cmd = conn.prepareStatement(sql);
        cmd.setString(1, modelo.getUsername());
        cmd.setString(2, modelo.getPassword());
        cmd.setDate(3, new java.sql.Date(modelo.getUltimoAcceso().getTime()));
        cmd.setInt(4, modelo.getIdCuentaUsuario());
        
        return cmd;
    }

    @Override
    protected PreparedStatement comandoEliminar(Connection conn, 
            Integer id) throws SQLException {
        
        String sql = 
                "DELETE "
                + "FROM CuentaUsuario "
                + "WHERE idCuentaUsuario = ?";
        
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
                + " userName, "
                + " password, "
                + " ultimoAcceso "
                + "FROM CuentaUsuario "
                + "WHERE "
                + " idCuentaUsuario = ?";
        
        PreparedStatement cmd = conn.prepareStatement(sql);
        cmd.setInt(1, id);
        
        return cmd;
    }

    @Override
    protected PreparedStatement comandoLeerTodos(Connection conn) 
            throws SQLException {
        
        String sql = 
                "SELECT "
                + " idCuentaUsuario, "
                + " userName, "
                + " password, "
                + " ultimoAcceso "
                + "FROM CuentaUsuario";
                
        PreparedStatement cmd = conn.prepareStatement(sql);
        
        return cmd;
    }

    @Override
    protected CuentaUsuario mapearModelo(ResultSet rs) throws SQLException {
        CuentaUsuario cuentaUsuario = new CuentaUsuario();
        cuentaUsuario.setIdCuentaUsuario(rs.getInt("idCuentaUsuario"));
        cuentaUsuario.setUsername(rs.getString("userName"));
        cuentaUsuario.setPassword(rs.getString("password"));
        cuentaUsuario.setUltimoAcceso(rs.getDate("ultimoAcceso"));

        return cuentaUsuario;
    }    
}
