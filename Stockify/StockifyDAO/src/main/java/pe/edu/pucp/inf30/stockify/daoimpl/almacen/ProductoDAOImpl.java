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

import pe.edu.pucp.inf30.stockify.daoimpl.BaseDAO;
import pe.edu.pucp.inf30.stockify.dao.almacen.ProductoDAO;
import pe.edu.pucp.inf30.stockify.model.almacen.Producto;

/**
 *
 * @author patri
 */
public class ProductoDAOImpl extends BaseDAO<Producto> implements ProductoDAO{
    @Override
     protected PreparedStatement comandoCrear(Connection conn, Producto modelo) 
            throws SQLException {
        
        String sql = 
                "INSERT INTO PRODUCTO("
                + " id, "
                + " nombre, "
                + " descripcion, "
                + " precio, "
                + " stockActual, "
                + " unidadMedida) "
                + "VALUES (?, ?, ?, ?)";
        PreparedStatement cmd = conn.prepareStatement(sql, 
                Statement.RETURN_GENERATED_KEYS);
        cmd.setInt(1, modelo.getIdProducto());
        cmd.setString(2, modelo.getNombre());
        cmd.setString(3, modelo.getDescripcion());
        cmd.setDouble(4, modelo.getPrecio());
        cmd.setInt(5, modelo.getStockActual());
        cmd.setString(6, modelo.getUnidadMedida());
        return cmd;
    }
     
    @Override
    protected PreparedStatement comandoActualizar(Connection conn, 
            Producto modelo) throws SQLException {
        
        String sql = 
                "UPDATE PRODUCTO "
                + " id, "
                + " nombre, "
                + " descripcion, "
                + " precio, "
                + " stockActual, "
                + " unidadMedida "
                + "WHERE "
                + " id = ?";
        PreparedStatement cmd = conn.prepareStatement(sql);
        cmd.setInt(1, modelo.getIdProducto());
        cmd.setString(2, modelo.getNombre());
        cmd.setString(3, modelo.getDescripcion());
        cmd.setDouble(4, modelo.getPrecio());
        cmd.setInt(5, modelo.getStockActual());
        cmd.setString(6, modelo.getUnidadMedida());
        return cmd;
    }
    
    @Override
    protected PreparedStatement comandoEliminar(Connection conn, Integer idEmpresa) throws SQLException {
        String sql = 
                "DELETE "
                + "FROM PRODUCTO "
                + "WHERE id = ?";
        PreparedStatement cmd = conn.prepareStatement(sql);
        cmd.setInt(1, idEmpresa);
        return cmd;
    }
    
    @Override
    protected PreparedStatement comandoLeer(Connection conn, Integer id) throws SQLException {
        String sql = 
                "SELECT "
                + " id, "
                + " nombre, "
                + " descripcion, "
                + " precio, "
                + " stockActual, "
                + " unidadMedida "
                + "FROM PRODUCTO"
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
                + " id, "
                + " nombre, "
                + " descripcion, "
                + " precio, "
                + " stockActual, "
                + " unidadMedida "
                + "FROM PRODUCTO";
        PreparedStatement cmd = conn.prepareStatement(sql);
        return cmd;
    }
    
     @Override
    protected Producto mapearModelo(ResultSet rs) throws SQLException {
        Producto producto = new Producto();
        producto.setIdProducto(rs.getInt("id"));
        producto.setNombre(rs.getString("nombre"));
        producto.setDescripcion(rs.getString("descripcion"));
        producto.setPrecio(rs.getDouble("precio"));
        producto.setStockActual(rs.getInt("stockActual"));
        producto.setUnidadMedida(rs.getString("unidadMedida"));
        return producto;
    }
    
}
