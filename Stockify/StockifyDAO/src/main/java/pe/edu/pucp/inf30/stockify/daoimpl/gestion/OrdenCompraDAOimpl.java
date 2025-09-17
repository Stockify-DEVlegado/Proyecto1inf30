/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.inf30.stockify.daoimpl.gestion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import pe.edu.pucp.inf30.stockify.dao.gestion.OrdenCompraDAO;
import pe.edu.pucp.inf30.stockify.daoimpl.BaseDAO;
import pe.edu.pucp.inf30.stockify.model.gestion.OrdenCompra;
import pe.edu.pucp.inf30.stockify.model.gestion.Estado;
import pe.edu.pucp.inf30.stockify.daoimpl.usuario.EmpresaDAOImpl;

/**
 *
 * @author Martino
 */
public class OrdenCompraDAOimpl extends BaseDAO<OrdenCompra> implements OrdenCompraDAO {
    
    @Override
    protected PreparedStatement comandoCrear(Connection conn, OrdenCompra modelo) throws SQLException {
        
        String sql = 
                "INSERT INTO ORDEN_COMPRA ("
                + "idOrdenCompra, "
                + "total, "
                + "fecha, "
                + "estado, "
                + "idProveedor)"
                + "VALUES (?, ?, ?, ?, ?)";
        
        PreparedStatement cmd = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        cmd.setInt(1, modelo.getIdOrdenCompra());
        cmd.setDouble(2, modelo.getTotal());
        cmd.setDate(3, new java.sql.Date(modelo.getFecha().getTime()));
        cmd.setString(4, String.valueOf(modelo.getEstado()));
        
        if (modelo.getProveedor() != null) {
            cmd.setInt(5, modelo.getProveedor().getIdEmpresa());
        } else {
            cmd.setNull(5, Types.INTEGER);
        }
        
        return cmd;
    }

    @Override
    protected PreparedStatement comandoActualizar(Connection conn, OrdenCompra modelo) throws SQLException {
        
        String sql = 
                "UPDATE ORDEN_COMPRA "
                + "SET "
                + "total = ?, "
                + "fecha = ?, "
                + "estado = ?, "
                + "idProveedor = ? "
                + "WHERE "
                + "idOrdenCompra = ?";
        
        PreparedStatement cmd = conn.prepareStatement(sql);
        cmd.setInt(5, modelo.getIdOrdenCompra());
        cmd.setDouble(1, modelo.getTotal());
        cmd.setDate(2, new java.sql.Date(modelo.getFecha().getTime()));
        cmd.setString(3, String.valueOf(modelo.getEstado()));
        
        if (modelo.getProveedor() != null) {
            cmd.setInt(4, modelo.getProveedor().getIdEmpresa());
        } else {
            cmd.setNull(4, Types.INTEGER);
        }
        return cmd;
    }

    @Override
    protected PreparedStatement comandoEliminar(Connection conn, Integer id) throws SQLException {
        
        String sql = 
                "DELETE "
                + "FROM ORDEN_COMPRA "
                + "WHERE idOrdenCompra = ?";
        
        PreparedStatement cmd = conn.prepareStatement(sql);
        cmd.setInt(1, id);
        
        return cmd;
    }

    @Override
    protected PreparedStatement comandoLeer(Connection conn, Integer id) throws SQLException {
        
        String sql = 
                "SELECT "
                + "idOrdenCompra, "
                + "total, "
                + "fecha, "
                + "estado, "
                + "idProveedor "
                + "FROM ORDEN_COMPRA "
                + "WHERE idOrdenCompra = ?";
        
        PreparedStatement cmd = conn.prepareStatement(sql);
        cmd.setInt(1, id);
        
        return cmd;
    }

    @Override
    protected PreparedStatement comandoLeerTodos(Connection conn) throws SQLException {
        
        String sql = 
                "SELECT "
                + "idOrdenCompra, "
                + "total, "
                + "fecha, "
                + "estado, "
                + "idProveedor "
                + "FROM ORDEN_COMPRA";
                
        PreparedStatement cmd = conn.prepareStatement(sql);
        
        return cmd;
    }

    @Override
    protected OrdenCompra mapearModelo(ResultSet rs) throws SQLException {
        OrdenCompra ordenCompra = new OrdenCompra();
        
        ordenCompra.setIdOrdenCompra(rs.getInt("idOrdenCompra"));
        ordenCompra.setTotal(rs.getDouble("total"));
        ordenCompra.setFecha(rs.getDate("fecha"));
        ordenCompra.setEstado(Estado.valueOf(rs.getString("estado")));
        
        int idProveedor = rs.getInt("idProveedor");
        if (!rs.wasNull()) {
            ordenCompra.setProveedor(new EmpresaDAOImpl().leer(idProveedor));
        }
        
        return ordenCompra;
    }
    
}