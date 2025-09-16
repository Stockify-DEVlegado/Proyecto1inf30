/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.inf30.stockify.daoimpl.usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import pe.edu.pucp.inf30.stockify.dao.usuario.EmpresaDAO;
import pe.edu.pucp.inf30.stockify.daoimpl.BaseDAO;
import pe.edu.pucp.inf30.stockify.model.usuario.Empresa;

/**
 *
 * @author patri
 */
public class EmpresaDAOImpl extends BaseDAO<Empresa> implements EmpresaDAO {
    @Override
     protected PreparedStatement comandoCrear(Connection conn, Empresa modelo) 
            throws SQLException {
        
        String sql = 
                "INSERT INTO PRODUCTO("
                + " razonSocial, "
                + " telefono, "
                + " email, "
                + " activo) "
                + "VALUES (?, ?, ?, ?)";
        PreparedStatement cmd = conn.prepareStatement(sql, 
                Statement.RETURN_GENERATED_KEYS);
        cmd.setString(1, modelo.getRazonSocial());
        cmd.setString(2, modelo.getTelefono());
        cmd.setString(3, modelo.getEmail());
        cmd.setBoolean(4, modelo.isActivo());
        return cmd;
    }
     
    @Override
    protected PreparedStatement comandoActualizar(Connection conn, 
            Empresa modelo) throws SQLException {
        
        String sql = 
                "UPDATE PRODUCTO "
                + "SET "
                + " razonSocial = ?, "
                + " telefono = ?, "
                + " email = ?, "
                + " activo = ? "
                + "WHERE "
                + " id = ?";
        PreparedStatement cmd = conn.prepareStatement(sql);
        cmd.setString(1, modelo.getRazonSocial());
        cmd.setString(2, modelo.getTelefono());
        cmd.setString(3, modelo.getEmail());
        cmd.setBoolean(4, modelo.isActivo());
        cmd.setInt(5, modelo.getIdEmpresa());
        return cmd;
    }
    
    @Override
    protected PreparedStatement comandoEliminar(Connection conn, Integer idEmpresa) throws SQLException {
        String sql = 
                "DELETE "
                + "FROM EMPRESA "
                + "WHERE id = ?";
        PreparedStatement cmd = conn.prepareStatement(sql);
        cmd.setInt(1, idEmpresa);
        return cmd;
    }
    
    @Override
    protected PreparedStatement comandoLeer(Connection conn, Integer id) throws SQLException {
        String sql = 
                "SELECT "
                + " id,"
                + " razonSocial,"
                + " telefono,"
                + " email, "
                + " activo "
                + "FROM EMPRESA"
                + "WHERE "
                + " id = ?";
        PreparedStatement cmd = conn.prepareStatement(sql);
        cmd.setInt(1, id);
        return cmd;
    }

    
     @Override
    protected PreparedStatement comandoLeerTodos(Connection conn) throws SQLException {
        String sql = 
                "SELECT "
                + " id,"
                + " razonSocial,"
                + " telefono,"
                + " email, "
                + " activo "
                + "FROM EMPRESA";
        PreparedStatement cmd = conn.prepareStatement(sql);
        return cmd;
    }
    
     @Override
    protected Empresa mapearModelo(ResultSet rs) throws SQLException {
        Empresa empresa = new Empresa();
        empresa.setIdEmpresa(rs.getInt("id"));
        empresa.setRazonSocial(rs.getString("razonSocial"));
        empresa.setTelefono(rs.getString("telefono"));
        empresa.setEmail(rs.getString("email"));
        empresa.setActivo(rs.getBoolean("activo"));
        return empresa;
    }
}
