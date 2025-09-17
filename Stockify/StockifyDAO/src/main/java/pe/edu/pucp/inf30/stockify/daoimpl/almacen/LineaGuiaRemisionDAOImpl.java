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

import pe.edu.pucp.inf30.stockify.daoimpl.BaseDAO;
import pe.edu.pucp.inf30.stockify.dao.almacen.LineaGuiaRemisionDAO;
import pe.edu.pucp.inf30.stockify.model.almacen.LineaGuiaRemision;

/**
 *
 * @author patri
 */
public class LineaGuiaRemisionDAOImpl extends BaseDAO<LineaGuiaRemision> implements LineaGuiaRemisionDAO {

    @Override
    protected PreparedStatement comandoCrear(Connection conn, LineaGuiaRemision modelo)
            throws SQLException {

        String sql
                = "INSERT INTO LINEAGUIAREMISION("
                + " idLineaGuiaRemision, "
                + " idProducto, "
                + " cantidad, "
                + " subtotal) "
                + "VALUES (?, ?, ?, ?)";
        PreparedStatement cmd = conn.prepareStatement(sql,
                Statement.RETURN_GENERATED_KEYS);
        cmd.setInt(1, modelo.getIdLineaGuiaRemision());
        if (modelo.getProducto() != null) {
            cmd.setInt(2, modelo.getProducto().getIdProducto());
        } else {
            cmd.setNull(2, Types.INTEGER);
        }
        cmd.setInt(3, modelo.getCantidad());
        cmd.setDouble(4, modelo.getSubtotal());
        return cmd;
    }

    @Override
    protected PreparedStatement comandoActualizar(Connection conn,
            LineaGuiaRemision modelo) throws SQLException {

        String sql
                = "UPDATE LINEAGUIAREMISION "
                + "SET "
                + " idProducto, "
                + " cantidad, "
                + " subtotal) "
                + "WHERE "
                + " id = ?";
        PreparedStatement cmd = conn.prepareStatement(sql);

        if (modelo.getProducto() != null) {
            cmd.setInt(1, modelo.getProducto().getIdProducto());
        } else {
            cmd.setNull(1, Types.INTEGER);
        }
        cmd.setInt(2, modelo.getCantidad());
        cmd.setDouble(3, modelo.getSubtotal());
        cmd.setInt(4, modelo.getIdLineaGuiaRemision());
        return cmd;
    }

    @Override
    protected PreparedStatement comandoEliminar(Connection conn, Integer id) throws SQLException {
        String sql
                = "DELETE "
                + "FROM LINEAGUIAREMISION "
                + "WHERE id = ?";
        PreparedStatement cmd = conn.prepareStatement(sql);
        cmd.setInt(1, id);
        return cmd;
    }

    @Override
    protected PreparedStatement comandoLeer(Connection conn, Integer id) throws SQLException {
        String sql
                = "SELECT "
                + " idLineaGuiaRemision, "
                + " idProducto, "
                + " cantidad, "
                + " subtotal "
                + "FROM LINEA GUIA REMISION"
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
                + " idLineaGuiaRemision, "
                + " idProducto, "
                + " cantidad, "
                + " subtotal "
                + "FROM LINEA GUIA REMISION";
        PreparedStatement cmd = conn.prepareStatement(sql);
        return cmd;
    }

    @Override
    protected LineaGuiaRemision mapearModelo(ResultSet rs) throws SQLException {
        LineaGuiaRemision lgre = new LineaGuiaRemision();
        lgre.setIdLineaGuiaRemision(rs.getInt("idLineaGuiaRemision"));
        int idProd = rs.getInt("idProducto");
        if (!rs.wasNull()) {
            lgre.setProducto(new ProductoDAOImpl().leer(idProd));
        }
        lgre.setCantidad(rs.getInt("cantidad"));
        lgre.setSubtotal(rs.getDouble("subtotal"));
        return lgre;
    }
}
