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
import pe.edu.pucp.inf30.stockify.dao.almacen.ExistenciasDAO;
import pe.edu.pucp.inf30.stockify.model.almacen.Existencias;

/**
 *
 * @author patri
 */
public class ExistenciasDAOImpl extends BaseDAO<Existencias> implements ExistenciasDAO{
    @Override
     protected PreparedStatement comandoCrear(Connection conn, Existencias modelo) 
            throws SQLException {
        
        String sql = 
                "INSERT INTO Existencias("
                + " idExistencia, "
            //    + " idUnico, "
                + " stockMaximo, "
                + " stockMinimo, "
                + " nombre, "
                + " precio )"
               // + " estado ) "
                + "VALUES (?, ?, ?, ?, ?)";
        PreparedStatement cmd = conn.prepareStatement(sql, 
                Statement.RETURN_GENERATED_KEYS);
        cmd.setInt(1, modelo.getIdExistencia());
        //cmd.setInt(2, modelo.getIdUnico());
        cmd.setString(4, modelo.getNombre());
        cmd.setDouble(5, modelo.getPrecio());
        //cmd.setInt(6, modelo.get());
        cmd.setInt(2, modelo.getCantidad());
        cmd.setInt(3, modelo.getCantidadUtilizada());
        
        return cmd;
    }
     
    @Override
    protected PreparedStatement comandoActualizar(Connection conn, 
            Existencias modelo) throws SQLException {
        
        String sql = 
                "UPDATE Existencias "
                + "SET "
                + " nombre = ?, "
                + " precio = ?, "
               // + " stockActual = ?, "
                + " stockMinimo = ?, "
                + " stockMaximo = ? "
                + "WHERE "
                + " idExistencia = ?";
  
        PreparedStatement cmd = conn.prepareStatement(sql);
        cmd.setString(1, modelo.getNombre());
        cmd.setDouble(2, modelo.getPrecio());
       // cmd.setInt(3, modelo.getStockActual());
        cmd.setInt(3, modelo.getCantidad());
        cmd.setInt(4, modelo.getCantidadUtilizada());
        cmd.setInt(5, modelo.getIdExistencia());
        return cmd;
    }
    
    @Override
    protected PreparedStatement comandoEliminar(Connection conn, Integer id) throws SQLException {
        String sql = 
                "DELETE "
                + "FROM Existencias "
                + "WHERE idExistencia = ?";
        PreparedStatement cmd = conn.prepareStatement(sql);
        cmd.setInt(1, id);
        return cmd;
    }
    
    @Override
    protected PreparedStatement comandoLeer(Connection conn, Integer id) throws SQLException {
        String sql = 
                "SELECT "
                + " nombre, "
                + " precio, "
                + " stockMaximo, "
                + " stockMinimo "
                //+ " cantidadUtilizada "
                + "FROM Existencias"
                + "WHERE "
                + " idExistencia = ?";
        PreparedStatement cmd = conn.prepareStatement(sql);
        cmd.setInt(1, id);
        return cmd;
    }

    
     @Override
    protected PreparedStatement comandoLeerTodos(Connection conn) throws SQLException {
        String sql = 
                "SELECT "
                + " nombre, "
                + " precio, "
                + " stockMaximo, "
                + " stockMinimo "
               // + " cantidadUtilizada "
                + "FROM Existencias";
        PreparedStatement cmd = conn.prepareStatement(sql);
        return cmd;
    }
    
     @Override
    protected Existencias mapearModelo(ResultSet rs) throws SQLException {
        Existencias existencia = new Existencias();
        existencia.setIdExistencia(rs.getInt("idExistencia"));
        existencia.setIdUnico(rs.getInt("idUnico"));
        existencia.setNombre(rs.getString("nombre"));
        existencia.setPrecio(rs.getDouble("precio"));
        existencia.setStockActual(rs.getInt("stockActual"));
        existencia.setCantidad(rs.getInt("cantidad"));
        existencia.setCantidadUtilizada(rs.getInt("cantidadUtilizada"));
        return existencia;
    }
}
