/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.inf30.stockify.model.gestion;


import java.util.Date;
import java.util.List;
import pe.edu.pucp.inf30.stockify.model.usuario.Empresa;

public class OrdenCompra {
    private int idOrdenCompra;
    private double total;
    private Date fecha;
    private Estado estado;
    private Empresa proveedor;
    private List<LineaOrdenCompra> lineas;

    public OrdenCompra() {}

    public OrdenCompra(int idOrdenCompra, double total, Date fecha, Estado estado,
                       Empresa proveedor, List<LineaOrdenCompra> lineas) {
        this.idOrdenCompra = idOrdenCompra;
        this.total = total;
        this.fecha = fecha;
        this.estado = estado;
        this.proveedor = proveedor;
        this.lineas = lineas;
    }

    public int getIdOrdenCompra() { return idOrdenCompra; }
    public void setIdOrdenCompra(int idOrdenCompra) { this.idOrdenCompra = idOrdenCompra; }

    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }

    public Date getFecha() { return fecha; }
    public void setFecha(Date fecha) { this.fecha = fecha; }

    public Estado getEstado() { return estado; }
    public void setEstado(Estado estado) { this.estado = estado; }

    public Empresa getProveedor() { return proveedor; }
    public void setProveedor(Empresa proveedor) { this.proveedor = proveedor; }

    public List<LineaOrdenCompra> getLineas() { return lineas; }
    public void setLineas(List<LineaOrdenCompra> lineas) { this.lineas = lineas; }
}
