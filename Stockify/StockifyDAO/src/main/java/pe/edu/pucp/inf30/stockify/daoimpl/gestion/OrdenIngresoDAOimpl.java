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
import pe.edu.pucp.inf30.stockify.dao.gestion.OrdenIngresoDAO;
import pe.edu.pucp.inf30.stockify.daoimpl.BaseDAO;
import pe.edu.pucp.inf30.stockify.daoimpl.personal.UsuarioDAOimpl;
import pe.edu.pucp.inf30.stockify.model.gestion.OrdenIngreso;
import pe.edu.pucp.inf30.stockify.model.gestion.Estado;

/**
 *
 * @author Martino
 */
public class OrdenIngresoDAOimpl extends BaseDAO<OrdenIngreso> implements 
        OrdenIngresoDAO{
    
    @Override
    protected PreparedStatement comandoCrear(Connection conn, OrdenIngreso modelo) throws SQLException {
        
        String sql = 
                "INSERT INTO ORDEN_INGRESO ("
                + "idOrdenIngreso, "
                + "total, "
                + "fecha, "
                + "estado, "
                + "idUsuario)"
                + "VALUES (?, ?, ?, ?, ?)";
        
        PreparedStatement cmd = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        cmd.setInt(1, modelo.getIdOrdenIngreso());
        cmd.setDouble(2, modelo.getTotal());
        cmd.setDate(3, new java.sql.Date(modelo.getFecha().getTime()));
        cmd.setString(4, String.valueOf(modelo.getEstado()));
        
        if (modelo.getResponsable()!= null) {
            cmd.setInt(5, modelo.getResponsable().getIdUsuario());
        } else {
            cmd.setNull(5, Types.INTEGER);
        }
        
        return cmd;
    }

    @Override
    protected PreparedStatement comandoActualizar(Connection conn, OrdenIngreso modelo) throws SQLException {
        
        String sql = 
                "UPDATE ORDEN_INGRESO "
                + "SET "
                + "total = ?, "
                + "fecha = ?, "
                + "estado = ?, "
                + "idUsuario = ? "
                + "WHERE "
                + "idOrdenIngreso = ?";
        
        PreparedStatement cmd = conn.prepareStatement(sql);
        cmd.setInt(5, modelo.getIdOrdenIngreso());
        cmd.setDouble(1, modelo.getTotal());
        cmd.setDate(2, new java.sql.Date(modelo.getFecha().getTime()));
        cmd.setString(3, String.valueOf(modelo.getEstado()));
        
        if (modelo.getResponsable()!= null) {
            cmd.setInt(4, modelo.getResponsable().getIdUsuario());
        } else {
            cmd.setNull(4, Types.INTEGER);
        }
        return cmd;
    }

    @Override
    protected PreparedStatement comandoEliminar(Connection conn, Integer id) throws SQLException {
        
        String sql = 
                "DELETE "
                + "FROM ORDEN_INGRESO "
                + "WHERE idOrdenIngreso = ?";
        
        PreparedStatement cmd = conn.prepareStatement(sql);
        cmd.setInt(1, id);
        
        return cmd;
    }

    @Override
    protected PreparedStatement comandoLeer(Connection conn, Integer id) throws SQLException {
        
        String sql = 
                "SELECT "
                + "idOrdenIngreso, "
                + "total, "
                + "fecha, "
                + "estado, "
                + "idUsuario "
                + "FROM ORDEN_INGRESO "
                + "WHERE idOrdenIngreso = ?";
        
        PreparedStatement cmd = conn.prepareStatement(sql);
        cmd.setInt(1, id);
        
        return cmd;
    }

    @Override
    protected PreparedStatement comandoLeerTodos(Connection conn) throws SQLException {
        
        String sql = 
                "SELECT "
                + "idOrdenIngreso, "
                + "total, "
                + "fecha, "
                + "estado, "
                + "idUsuario "
                + "FROM ORDEN_INGRESO";
                
        PreparedStatement cmd = conn.prepareStatement(sql);
        
        return cmd;
    }

    @Override
    protected OrdenIngreso mapearModelo(ResultSet rs) throws SQLException {
        OrdenIngreso ordeningreso = new OrdenIngreso();
        
        ordeningreso.setIdOrdenIngreso(rs.getInt("idOrdenIngreso"));
        ordeningreso.setTotal(rs.getDouble("total"));
        ordeningreso.setFecha(rs.getDate("fecha"));
        ordeningreso.setEstado(Estado.valueOf(rs.getString("estado")));
        
        int idUsuario = rs.getInt("idUsuario");
        if (!rs.wasNull()) {
            ordeningreso.setResponsable(new UsuarioDAOimpl().leer(idUsuario));
        }
        
        return ordeningreso;
    }
}
