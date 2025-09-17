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
import pe.edu.pucp.inf30.stockify.dao.gestion.OrdenVentaDAO;
import pe.edu.pucp.inf30.stockify.daoimpl.BaseDAO;
import pe.edu.pucp.inf30.stockify.model.gestion.Estado;
import pe.edu.pucp.inf30.stockify.model.gestion.OrdenVenta;
import pe.edu.pucp.inf30.stockify.daoimpl.usuario.EmpresaDAOImpl;

/**
 *
 * @author Martino
 */
public class OrdenVentaDAOimpl extends BaseDAO<OrdenVenta> implements 
        OrdenVentaDAO{
    
    @Override
    protected PreparedStatement comandoCrear(Connection conn, OrdenVenta modelo) throws SQLException {
        
        String sql = 
                "INSERT INTO ORDEN_VENTA ("
                + "idOrdenVenta, "
                + "total, "
                + "fecha, "
                + "estado, "
                + "idCliente)"
                + "VALUES (?, ?, ?, ?, ?)";
        
        PreparedStatement cmd = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        cmd.setInt(1, modelo.getIdOrdenCompra());
        cmd.setDouble(2, modelo.getTotal());
        cmd.setDate(3, new java.sql.Date(modelo.getFecha().getTime()));
        cmd.setString(4, String.valueOf(modelo.getEstado()));
        
        if (modelo.getCliente()!= null) {
            cmd.setInt(5, modelo.getCliente().getIdEmpresa());
        } else {
            cmd.setNull(5, Types.INTEGER);
        }
        
        return cmd;
    }

    @Override
    protected PreparedStatement comandoActualizar(Connection conn, OrdenVenta modelo) throws SQLException {
        
        String sql = 
                "UPDATE ORDEN_VENTA "
                + "SET "
                + "total = ?, "
                + "fecha = ?, "
                + "estado = ?, "
                + "idCliente = ? "
                + "WHERE "
                + "idOrdenVenta = ?";
        
        PreparedStatement cmd = conn.prepareStatement(sql);
        cmd.setInt(5, modelo.getIdOrdenCompra());
        cmd.setDouble(1, modelo.getTotal());
        cmd.setDate(2, new java.sql.Date(modelo.getFecha().getTime()));
        cmd.setString(3, String.valueOf(modelo.getEstado()));
        
        if (modelo.getCliente()!= null) {
            cmd.setInt(4, modelo.getCliente().getIdEmpresa());
        } else {
            cmd.setNull(4, Types.INTEGER);
        }
        return cmd;
    }

    @Override
    protected PreparedStatement comandoEliminar(Connection conn, Integer id) throws SQLException {
        
        String sql = 
                "DELETE "
                + "FROM ORDEN_VENTA "
                + "WHERE idOrdenVenta = ?";
        
        PreparedStatement cmd = conn.prepareStatement(sql);
        cmd.setInt(1, id);
        
        return cmd;
    }

    @Override
    protected PreparedStatement comandoLeer(Connection conn, Integer id) throws SQLException {
        
        String sql = 
                "SELECT "
                + "idOrdenVenta, "
                + "total, "
                + "fecha, "
                + "estado, "
                + "idCliente "
                + "FROM ORDEN_VENTA "
                + "WHERE idOrdenVenta = ?";
        
        PreparedStatement cmd = conn.prepareStatement(sql);
        cmd.setInt(1, id);
        
        return cmd;
    }

    @Override
    protected PreparedStatement comandoLeerTodos(Connection conn) throws SQLException {
        
        String sql = 
                "SELECT "
                + "idOrdenVenta, "
                + "total, "
                + "fecha, "
                + "estado, "
                + "idCliente "
                + "FROM ORDEN_VENTA";
                
        PreparedStatement cmd = conn.prepareStatement(sql);
        
        return cmd;
    }

    @Override
    protected OrdenVenta mapearModelo(ResultSet rs) throws SQLException {
        OrdenVenta ordenventa = new OrdenVenta();
        
        ordenventa.setIdOrdenCompra(rs.getInt("idOrdenIngreso"));
        ordenventa.setTotal(rs.getDouble("total"));
        ordenventa.setFecha(rs.getDate("fecha"));
        ordenventa.setEstado(Estado.valueOf(rs.getString("estado")));
        
        int idEmpresa = rs.getInt("idEmpresa");
        if (!rs.wasNull()) {
            ordenventa.setCliente(new EmpresaDAOImpl().leer(idEmpresa));
        }
        
        return ordenventa;
    }
}
