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
import pe.edu.pucp.inf30.stockify.dao.gestion.LineaOrdenIngresoDAO;
import pe.edu.pucp.inf30.stockify.daoimpl.BaseDAO;
import pe.edu.pucp.inf30.stockify.model.gestion.LineaOrdenIngreso;
import pe.edu.pucp.inf30.stockify.daoimpl.almacen.ProductoDAOImpl;

/**
 *
 * @author Martino
 */
public class LineaOrdenIngresoDAOimpl extends BaseDAO<LineaOrdenIngreso> implements 
        LineaOrdenIngresoDAO{
    @Override
    protected PreparedStatement comandoCrear(Connection conn, 
            LineaOrdenIngreso modelo) throws SQLException {
        
        String sql = 
                "INSERT INTO LineaOrdenCompra ("
                + "id, "
                + "producto, "
                + " cantidad, "
                + " subtotal) "
                + "VALUES (?, ?, ?, ?)";
        
        PreparedStatement cmd = conn.prepareStatement(sql, 
                Statement.RETURN_GENERATED_KEYS);
        cmd.setInt(1, modelo.getIdLineaOrdenIngreso());
        if (modelo.getProducto()!= null) {
            cmd.setInt(2, modelo.getProducto().getIdProducto());
        }
        else {
            cmd.setNull(2, Types.INTEGER);
        }
        cmd.setInt(3, modelo.getCantidad());
        cmd.setDouble(4, modelo.getSubtotal());
        
        return cmd;
    }

    @Override
    protected PreparedStatement comandoActualizar(Connection conn, 
            LineaOrdenIngreso modelo) throws SQLException {
        
        String sql = 
                "UPDATE LineaOrdenCompra "
                + "SET "
                + " producto = ?, "
                + " cantidad = ?, "
                + " subtotal = ? "
                + "WHERE "
                + " id = ?";
        
        PreparedStatement cmd = conn.prepareStatement(sql);

        if (modelo.getProducto()!= null) {
            cmd.setInt(1, modelo.getProducto().getIdProducto());
        }
        else {
            cmd.setNull(1, Types.INTEGER);
        }
        cmd.setInt(2, modelo.getCantidad());
        cmd.setDouble(3, modelo.getSubtotal());
        cmd.setInt(4, modelo.getIdLineaOrdenIngreso());
        
        return cmd;
    }

    @Override
    protected PreparedStatement comandoEliminar(Connection conn, 
            Integer id) throws SQLException {
        
        String sql = 
                "DELETE "
                + "FROM LineaOrdenCompra "
                + "WHERE id = ?";
        
        PreparedStatement cmd = conn.prepareStatement(sql);
        cmd.setInt(1, id);
        
        return cmd;
    }

    @Override
    protected PreparedStatement comandoLeer(Connection conn, 
            Integer id) throws SQLException {
        
        String sql = 
                "SELECT "
                + "id, "
                + "producto, "
                + " cantidad, "
                + " subtotal "
                + "FROM LineaOrdenCompra "
                + "WHERE "
                + " id = ?";
        
        PreparedStatement cmd = conn.prepareStatement(sql);
        cmd.setInt(1, id);
        
        return cmd;
    }

    @Override
    protected PreparedStatement comandoLeerTodos(Connection conn) 
            throws SQLException {
        
        String sql = 
                "SELECT "
                + "id, "
                + "producto, "
                + " cantidad, "
                + " subtotal "
                + "FROM LineaOrdenCompra ";
                
        PreparedStatement cmd = conn.prepareStatement(sql);
        
        return cmd;
    }

    @Override
    protected LineaOrdenIngreso mapearModelo(ResultSet rs) throws SQLException {
        LineaOrdenIngreso lineaordeningreso = new LineaOrdenIngreso();
        lineaordeningreso.setIdLineaOrdenIngreso(rs.getInt("id"));
        lineaordeningreso.setCantidad(rs.getInt("userName"));
        lineaordeningreso.setSubtotal(rs.getDouble("password"));
        
        int idProducto = rs.getInt("idProducto");
        if (!rs.wasNull()) {
            lineaordeningreso.setProducto(
                    new ProductoDAOImpl().leer(idProducto));
        }
        

        return lineaordeningreso;
    }    
}
