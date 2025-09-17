/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.inf30.stockify.model.almacen;

import java.util.Date;
import pe.edu.pucp.inf30.stockify.model.personal.TipoUsuario;

public class Movimiento {
    private int idMovimiento;
    private TipoMovimiento tipoMovimiento;
    private Date fecha;
    private double precioUnitario;
    private double montoTotal;
    private String descripcion;
    private TipoUsuario operario;
    private Producto producto;

    public Movimiento() {
        this.fecha = new Date();
    }

    public Movimiento(int idMovimiento, TipoMovimiento tipoMovimiento,
                       double precioUnitario, double montoTotal, String descripcion,
                       TipoUsuario operario, Producto producto) {
        this.idMovimiento = idMovimiento;
        this.tipoMovimiento = tipoMovimiento;
        this.fecha = new Date();
        this.precioUnitario = precioUnitario;
        this.montoTotal = montoTotal;
        this.descripcion = descripcion;
        this.operario = operario;
        this.producto = producto;
    }

    public int getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(int idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public TipoMovimiento getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(TipoMovimiento tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoUsuario getOperario() {
        return operario;
    }

    public void setOperario(TipoUsuario operario) {
        this.operario = operario;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
