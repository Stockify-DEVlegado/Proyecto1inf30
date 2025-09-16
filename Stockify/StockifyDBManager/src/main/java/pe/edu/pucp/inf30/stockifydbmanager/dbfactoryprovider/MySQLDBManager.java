/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.inf30.stockifydbmanager.dbfactoryprovider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import pe.edu.pucp.inf30.stockifydbmanager.dbfactoryprovider.utils.TipoDB;


public class MySQLDBManager extends DBManager {
    private static MySQLDBManager instancia;
    
    protected MySQLDBManager() {}
    
    protected MySQLDBManager(String host, int puerto, String esquema, 
                             String usuario, String password) {
        super(host, puerto, esquema, usuario, password, TipoDB.MySQL);
    }
    
    static synchronized MySQLDBManager getInstance(String host, int puerto, 
                                                   String esquema, 
                                                   String usuario, 
                                                   String password) {
        if (instancia == null) {
            instancia = new MySQLDBManager(host, puerto, esquema, usuario, 
                                           password);
        }
        return instancia;
    }
    
    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String cadenaConexion = cadenaConexion();
            return DriverManager.getConnection(cadenaConexion, usuario, password);
        }
        catch (ClassNotFoundException | SQLException e) {
            System.err.println(e);
            throw e;
        }
    }
}