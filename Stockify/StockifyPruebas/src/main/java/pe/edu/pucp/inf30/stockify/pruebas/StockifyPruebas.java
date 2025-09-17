package pe.edu.pucp.inf30.stockify.pruebas;

import java.sql.Connection;
import java.sql.SQLException;
import pe.edu.pucp.inf30.stockify.dao.personal.CuentaUsuarioDAO;
import pe.edu.pucp.inf30.stockify.model.personal.Usuario;
import pe.edu.pucp.inf30.stockify.model.personal.TipoUsuario;
import pe.edu.pucp.inf30.stockify.daoimpl.personal.CuentaUsuarioDAOimpl;
import pe.edu.pucp.inf30.stockify.daoimpl.personal.UsuarioDAOimpl;
import pe.edu.pucp.inf30.stockify.dao.personal.UsuarioDAO;
import pe.edu.pucp.inf30.stockify.model.personal.CuentaUsuario;
import pe.edu.pucp.inf30.stockifydbmanager.dbfactoryprovider.DBFactoryProvider;
import pe.edu.pucp.inf30.stockifydbmanager.dbfactoryprovider.DBManager;
import pe.edu.pucp.inf30.stockify.model.almacen.Producto;
import pe.edu.pucp.inf30.stockify.dao.almacen.ProductoDAO;
import pe.edu.pucp.inf30.stockify.daoimpl.almacen.ProductoDAOImpl;
import pe.edu.pucp.inf30.stockify.model.usuario.Empresa;
import pe.edu.pucp.inf30.stockify.daoimpl.usuario.EmpresaDAOImpl;
import pe.edu.pucp.inf30.stockify.dao.usuario.EmpresaDAO;
import pe.edu.pucp.inf30.stockify.model.almacen.Existencias;
import pe.edu.pucp.inf30.stockify.model.usuario.TipoDocumento;
import pe.edu.pucp.inf30.stockify.model.usuario.TipoEmpresa;
import pe.edu.pucp.inf30.stockify.dao.almacen.ExistenciasDAO;
import pe.edu.pucp.inf30.stockify.daoimpl.almacen.ExistenciasDAOImpl;

/**
 *
 * @author DEVlegado
 */
public class StockifyPruebas {

    public static void main(String[] args) throws SQLException,
            ClassNotFoundException {
        DBManager dbManager = DBFactoryProvider.getManager();
        try (Connection connection = dbManager.getConnection()) {
            if (connection != null && !connection.isClosed()) {
                System.out.println("Conexion establecida correctamente.");
            } else {
                System.out.println("No se pudo establecer la conexion.");
            }
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos: "
                    + e.getMessage());
        }

        //CUENTA USUARIO-------------------------------------------------------------
//        CuentaUsuario cuenta = new CuentaUsuario();
//        cuenta.setIdCuentaUsuario(1);
//        cuenta.setPassword("Hola123");
//        cuenta.setUsername("Knito");
//        CuentaUsuarioDAO cuentaDao = new CuentaUsuarioDAOimpl();
//        cuentaDao.crear(cuenta);
//        cuenta.setPassword("Hola1234");
//        cuenta.setUsername("Knero");
//        cuentaDao.actualizar(cuenta);
//          cuentaDao.eliminar(1);

        //USUARIO --------------------------------------------------------------------
//        Usuario prueba = new Usuario();
//        prueba.setActivo(true);
//        prueba.setApellidos("Changa");
//        prueba.setCuenta(cuenta);
//        prueba.setEmail("gmail");
//        prueba.setNombres("Carlos");
//        prueba.setIdUsuario(2);
//        prueba.setTelefono("99999999");
//        prueba.setTipoUsuario(TipoUsuario.OPERARIO);
//
//        UsuarioDAO usuarioDao = new UsuarioDAOimpl();
//        usuarioDao.crear(prueba);
//        prueba.setNombres("Carla");
//        prueba.setApellidos("Chango");
//        usuarioDao.actualizar(prueba);
        //usuarioDao.eliminar(2);
        
        
        //PRODUCTO ---------------------------------------------------------------
//        Producto producto = new Producto();
//        producto.setIdProducto(3);
//        producto.setNombre("Laptop");
//        producto.setDescripcion("De Mesa");
//        producto.setPrecio(200);
//        producto.setStockActual(10);
//        producto.setUnidadMedida("kg");
//
//        ProductoDAO productoDao = new ProductoDAOImpl();
////     
//        producto.setNombre("Computadora");
//        producto.setStockActual(5);
//        producto.setPrecio(50);
//
//        //productoDao.crear(producto);
//        
//        producto.setStockActual(3);
//        producto.setPrecio(40);
//        
//        productoDao.actualizar(producto);
//        productoDao.eliminar(3);
        
//          EMPRESA -----------------------------------------------------------------
//        Empresa empresa = new Empresa();
//        empresa.setIdEmpresa(2);
//        empresa.setActivo(true);
//        empresa.setEmail("empresa@gmail.com");
//        empresa.setRazonSocial("Platanito");
//        empresa.setTelefono("+51933721210");
//        empresa.setTipoDocumento(TipoDocumento.RUC);
//        empresa.setTipoEmpresa(TipoEmpresa.CLIENTE);
//        
//        EmpresaDAO empresita = new EmpresaDAOImpl();
////        empresita.crear(empresa);
//        empresa.setRazonSocial("DavidSA");
//        empresa.setTelefono("+51956845876");
////        
//        empresita.actualizar(empresa);
//         empresita.eliminar(2);
        //EXISTENCIAS ------------------------------------------------------------
//       
        Existencias existencia = new Existencias();
        existencia.setIdExistencia(1);
        //existencia.setIdUnico(2);
        existencia.setNombre("Monitor");
        existencia.setPrecio(20);
        existencia.setStockActual(5);
        existencia.setCantidadUtilizada(1);
        existencia.setCantidad(3);
        ExistenciasDAO existenciaDao = new ExistenciasDAOImpl();
//        existenciaDao.crear(existencia);

       existencia.setPrecio(10);
       existencia.setStockActual(30); //ejemplo de re-stock
       existencia.setCantidadUtilizada(5); //ejemplo de re-stock
       existencia.setCantidad(4); //ejemplo de re-stock
       existenciaDao.actualizar(existencia);
        existenciaDao.eliminar(1);
    }
}
