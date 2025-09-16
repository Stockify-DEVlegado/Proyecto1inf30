/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.inf30.stockify.model.almacen;

public class LineaGuiaRemision {
    private int idLineaGuiaRemision;
    private Producto producto;
    private int cantidad;
    private double subtotal;

    public LineaGuiaRemision() {}

    public LineaGuiaRemision(int idLineaGuiaRemision, Producto producto, int cantidad, double subtotal) {
        this.idLineaGuiaRemision = idLineaGuiaRemision;
        this.producto = producto;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    public int getIdLineaGuiaRemision() {
        return idLineaGuiaRemision;
    }

    public void setIdLineaGuiaRemision(int idLineaGuiaRemision) {
        this.idLineaGuiaRemision = idLineaGuiaRemision;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
}
