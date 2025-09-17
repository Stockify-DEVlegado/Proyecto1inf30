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
import pe.edu.pucp.inf30.stockify.dao.almacen.GuiaRemisionDAO;
import pe.edu.pucp.inf30.stockify.model.almacen.Estado;
import pe.edu.pucp.inf30.stockify.model.almacen.GuiaRemision;

/**
 *
 * @author patri
 */
public class GuiaRemisionDAOImpl extends BaseDAO<GuiaRemision> implements GuiaRemisionDAO {

    @Override
    protected PreparedStatement comandoCrear(Connection conn, GuiaRemision modelo)
            throws SQLException {

        String sql
                = "INSERT INTO GuiaRemision("
                + " idGuiaRemision, "
                + " total, "
                + " fecha, "
                + " estado, "
                + " responsable, "
                + " cliente ) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement cmd = conn.prepareStatement(sql,
                Statement.RETURN_GENERATED_KEYS);
        cmd.setInt(1, modelo.getIdGuiaRemision());
        cmd.setDouble(2, modelo.getTotal());
        cmd.setDate(3, new java.sql.Date(modelo.getFecha().getTime()));
        cmd.setString(4, String.valueOf(modelo.getEstado()));
        cmd.setInt(5, modelo.getResponsable().getIdUsuario());
        cmd.setInt(6, modelo.getCliente().getIdEmpresa());
        return cmd;
    }

    @Override
    protected PreparedStatement comandoActualizar(Connection conn,
            GuiaRemision modelo) throws SQLException {

        String sql
                = "UPDATE GuiaRemision "
                + "SET "
                + " total, "
                + " fecha, "
                + " estado, "
                + " responsable, "
                + " cliente ) "
                + "WHERE "
                + " id = ?";
        PreparedStatement cmd = conn.prepareStatement(sql,
                Statement.RETURN_GENERATED_KEYS);
        cmd.setDouble(1, modelo.getTotal());
        cmd.setDate(2, new java.sql.Date(modelo.getFecha().getTime()));
        cmd.setString(3, String.valueOf(modelo.getEstado()));
        cmd.setInt(4, modelo.getResponsable().getIdUsuario());
        cmd.setInt(5, modelo.getCliente().getIdEmpresa());
        cmd.setInt(6, modelo.getIdGuiaRemision());

        return cmd;
    }

    @Override
    protected PreparedStatement comandoEliminar(Connection conn, Integer id) throws SQLException {
        String sql
                = "DELETE "
                + "FROM GuiaRemision "
                + "WHERE id = ?";
        PreparedStatement cmd = conn.prepareStatement(sql);
        cmd.setInt(1, id);
        return cmd;
    }

    @Override
    protected PreparedStatement comandoLeer(Connection conn, Integer id) throws SQLException {
        String sql
                = "SELECT "
                + " idGuiaRemision, "
                + " total, "
                + " fecha, "
                + " estado, "
                + " responsable, "
                + " cliente "
                + "FROM GuiaRemision"
                + "WHERE "
                + " id = ?";
        PreparedStatement cmd = conn.prepareStatement(sql);
        cmd.setInt(1, id);
        return cmd;
    }

    @Override
    protected PreparedStatement comandoLeerTodos(Connection conn) throws SQLException {
        String sql
                = "SELECT "
                + " idGuiaRemision, "
                + " total, "
                + " fecha, "
                + " estado, "
                + " responsable, "
                + " cliente "
                + "FROM GuiaRemision";
        PreparedStatement cmd = conn.prepareStatement(sql);
        return cmd;
    }

    @Override
    protected GuiaRemision mapearModelo(ResultSet rs) throws SQLException {
        GuiaRemision guiar = new GuiaRemision();
        guiar.setIdGuiaRemision(rs.getInt("idGuiaRemision"));
        guiar.setTotal(rs.getDouble("total"));
        guiar.setFecha(rs.getDate("fecha"));
        guiar.setEstado(Estado.valueOf(rs.getString("estado")));
        return guiar;
    }
}
