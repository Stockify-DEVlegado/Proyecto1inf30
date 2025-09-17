/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.inf30.stockify.daoimpl.almacen;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Date;


import pe.edu.pucp.inf30.stockify.daoimpl.BaseDAO;
import pe.edu.pucp.inf30.stockify.dao.almacen.MovimientoDAO;
import pe.edu.pucp.inf30.stockify.model.almacen.Movimiento;
import pe.edu.pucp.inf30.stockify.model.almacen.Producto;
import pe.edu.pucp.inf30.stockify.model.almacen.TipoMovimiento;
import pe.edu.pucp.inf30.stockify.model.personal.TipoUsuario;

/**
 *
 * @author patri
 */
public class MovimientoDAOImpl extends BaseDAO<Movimiento> implements MovimientoDAO{
    @Override
     protected PreparedStatement comandoCrear(Connection conn, Movimiento modelo) 
            throws SQLException {
        
        String sql = 
                "INSERT INTO PRODUCTO("
                + " idMovimiento, "
                + " tipoMovimiento, "
                + " fecha, "
                + " precioUnitario, "
                + " montoTotal, "
                + " descripcion, "
                + " operario, "
                + " producto ) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement cmd = conn.prepareStatement(sql, 
                Statement.RETURN_GENERATED_KEYS);
        cmd.setInt(1, modelo.getIdMovimiento());
        cmd.setString(2, modelo.getTipoMovimiento().name());
        cmd.setDate(3, new java.sql.Date(modelo.getFecha().getTime()));
        cmd.setDouble(4, modelo.getPrecioUnitario());
        cmd.setDouble(5, modelo.getMontoTotal());
        cmd.setString(6, modelo.getDescripcion());
        cmd.setString(7, modelo.getOperario().name());
        if (modelo.getProducto()!= null) {
            cmd.setInt(8, modelo.getProducto().getIdProducto());
        }
        else {
            cmd.setNull(8, Types.INTEGER);
        }
        return cmd;
    }
     
    @Override
    protected PreparedStatement comandoActualizar(Connection conn, 
            Movimiento modelo) throws SQLException {
        
        String sql = 
                "UPDATE PRODUCTO "
                + " tipoMovimiento, "
                + " fecha, "
                + " precioUnitario, "
                + " montoTotal, "
                + " descripcion, "
                + " operario, "
                + " producto ) "
                + "WHERE "
                + " id = ?";
                PreparedStatement cmd = conn.prepareStatement(sql, 
                Statement.RETURN_GENERATED_KEYS);
        cmd.setString(1, modelo.getTipoMovimiento().name());
        cmd.setDate(2, new java.sql.Date(modelo.getFecha().getTime()));
        cmd.setDouble(3, modelo.getPrecioUnitario());
        cmd.setDouble(4, modelo.getMontoTotal());
        cmd.setString(5, modelo.getDescripcion());
        cmd.setString(6, modelo.getOperario().name());
        if (modelo.getProducto()!= null) {
            cmd.setInt(7, modelo.getProducto().getIdProducto());
        }
        else {
            cmd.setNull(7, Types.INTEGER);
        }
        cmd.setInt(8, modelo.getIdMovimiento());

        return cmd;
    }
    
    @Override
    protected PreparedStatement comandoEliminar(Connection conn, Integer id) throws SQLException {
        String sql = 
                "DELETE "
                + "FROM Movimiento "
                + "WHERE id = ?";
        PreparedStatement cmd = conn.prepareStatement(sql);
        cmd.setInt(1, id);
        return cmd;
    }
    
    @Override
    protected PreparedStatement comandoLeer(Connection conn, Integer id) throws SQLException {
        String sql = 
                "SELECT "
               + " idMovimiento, "
                + " tipoMovimiento, "
                + " fecha, "
                + " precioUnitario, "
                + " montoTotal, "
                + " descripcion, "
                + " operario, "
                + " producto ) "
                + "FROM Movimiento"
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
                + " idMovimiento, "
                + " tipoMovimiento, "
                + " fecha, "
                + " precioUnitario, "
                + " montoTotal, "
                + " descripcion, "
                + " operario, "
                + " producto  "
                + "FROM Movimiento";
        PreparedStatement cmd = conn.prepareStatement(sql);
        return cmd;
    }
    
     @Override
    protected Movimiento mapearModelo(ResultSet rs) throws SQLException {
        Movimiento movimiento = new Movimiento();
        movimiento.setIdMovimiento(rs.getInt("idMovimiento"));
        movimiento.setTipoMovimiento(TipoMovimiento.valueOf(rs.getString("tipoMovimiento")));
        movimiento.setFecha(rs.getDate("fecha"));
        movimiento.setPrecioUnitario(rs.getDouble("precioUnitario"));
        movimiento.setMontoTotal(rs.getDouble("montoTotal"));
        movimiento.setDescripcion(rs.getString("descripcion"));
        movimiento.setOperario(TipoUsuario.valueOf(rs.getString("operario")));
        return movimiento;
    }
}
