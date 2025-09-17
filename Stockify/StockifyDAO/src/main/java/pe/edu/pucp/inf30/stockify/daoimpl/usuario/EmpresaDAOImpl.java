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
 * @author patrick
 */
public class EmpresaDAOImpl extends BaseDAO<Empresa> implements EmpresaDAO {
    @Override
     protected PreparedStatement comandoCrear(Connection conn, Empresa modelo) 
            throws SQLException {
        
        String sql = 
                "INSERT INTO Empresa("
                + " idEmpresa, "
                + " tipoDocumento, "
                + " razonSocial, "
                + " telefono, "
                + " email, "
                + " activo, "
                + " tipoEmpresa) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement cmd = conn.prepareStatement(sql, 
                Statement.RETURN_GENERATED_KEYS);
        cmd.setInt(1, modelo.getIdEmpresa());
        cmd.setString(2, String.valueOf(modelo.getTipoDocumento()));
        cmd.setString(3, modelo.getRazonSocial());
        cmd.setString(4, modelo.getTelefono());
        cmd.setString(5, modelo.getEmail());
        cmd.setBoolean(6, modelo.isActivo());
        cmd.setString(7, String.valueOf(modelo.getTipoEmpresa()));
        return cmd;
    }
     
    @Override
    protected PreparedStatement comandoActualizar(Connection conn, 
            Empresa modelo) throws SQLException {
        
        String sql = 
                "UPDATE Empresa "
                + "SET "
                + " tipoDocumento = ?, "
                + " razonSocial = ?, "
                + " telefono = ?, "
                + " email = ?, "
                + " activo = ?, "
                + " tipoEmpresa = ? "
                + "WHERE "
                + " idEmpresa = ?";
        PreparedStatement cmd = conn.prepareStatement(sql);
        cmd.setString(1, String.valueOf(modelo.getTipoDocumento()));
        cmd.setString(2, modelo.getRazonSocial());
        cmd.setString(3, modelo.getTelefono());
        cmd.setString(4, modelo.getEmail());
        cmd.setBoolean(5, modelo.isActivo());
        cmd.setString(6, String.valueOf(modelo.getTipoEmpresa()));
        cmd.setInt(7, modelo.getIdEmpresa());
        return cmd;
    }
    
    @Override
    protected PreparedStatement comandoEliminar(Connection conn, Integer idEmpresa) throws SQLException {
        String sql = 
                "DELETE "
                + "FROM Empresa "
                + "WHERE idEmpresa = ?";
        PreparedStatement cmd = conn.prepareStatement(sql);
        cmd.setInt(1, idEmpresa);
        return cmd;
    }
    
    @Override
    protected PreparedStatement comandoLeer(Connection conn, Integer id) throws SQLException {
        String sql = 
                "SELECT "
                + " idEmpresa,"
                + " tipoDocumento,"
                + " razonSocial,"
                + " telefono,"
                + " email, "
                + " activo "
                + " tipoEmpresa "
                + "FROM EMPRESA"
                + "WHERE "
                + " idEmpresa = ?";
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