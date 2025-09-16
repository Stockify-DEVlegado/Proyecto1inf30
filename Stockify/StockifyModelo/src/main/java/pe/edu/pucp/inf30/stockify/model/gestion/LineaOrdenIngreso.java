/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.inf30.stockify.model.gestion;

import pe.edu.pucp.inf30.stockify.model.almacen.Producto;

public class LineaOrdenIngreso {
    private int idLineaOrdenIngreso;
    private Producto producto;
    private int cantidad;
    private double subtotal;
    private Estado estado;

    public LineaOrdenIngreso() {}

    public LineaOrdenIngreso(int idLineaOrdenIngreso, Producto producto, int cantidad,
                             double subtotal, Estado estado) {
        this.idLineaOrdenIngreso = idLineaOrdenIngreso;
        this.producto = producto;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.estado = estado;
    }

    public int getIdLineaOrdenIngreso() { return idLineaOrdenIngreso; }
    public void setIdLineaOrdenIngreso(int idLineaOrdenIngreso) { this.idLineaOrdenIngreso = idLineaOrdenIngreso; }

    public Producto getProducto() { return producto; }
    public void setProducto(Producto producto) { this.producto = producto; }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    public double getSubtotal() { return subtotal; }
    public void setSubtotal(double subtotal) { this.subtotal = subtotal; }

    public Estado getEstado() { return estado; }
    public void setEstado(Estado estado) { this.estado = estado; }
}
