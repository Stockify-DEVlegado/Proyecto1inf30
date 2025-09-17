/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.inf30.stockify.model.gestion;

import java.util.Date;
import java.util.List;
import pe.edu.pucp.inf30.stockify.model.usuario.Empresa;

public class OrdenVenta {
    private int idOrdenVenta;
    private double total;
    private Date fecha;
    private Estado estado;
    private Empresa cliente;
    private List<LineaOrdenVenta> lineas;

    // Constructor vacío
    public OrdenVenta() {
        this.fecha = new Date();
    }

    // Constructor con parámetros
    public OrdenVenta(int idOrdenVenta, double total, Estado estado,
                      Empresa cliente, List<LineaOrdenVenta> lineas) {
        this.idOrdenVenta = idOrdenVenta;
        this.total = total;
        this.fecha = new Date();
        this.estado = estado;
        this.cliente = cliente;
        this.lineas = lineas;
    }

    // Getters y Setters
    public int getIdOrdenCompra() { return idOrdenVenta; }
    public void setIdOrdenCompra(int idOrdenVenta) { this.idOrdenVenta = idOrdenVenta; }

    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }

    public Date getFecha() { return fecha; }
    public void setFecha(Date fecha) { this.fecha = fecha; }

    public Estado getEstado() { return estado; }
    public void setEstado(Estado estado) { this.estado = estado; }

    public Empresa getCliente() { return cliente; }
    public void setCliente(Empresa cliente) { this.cliente = cliente; }

    public List<LineaOrdenVenta> getLineas() { return lineas; }
    public void setLineas(List<LineaOrdenVenta> lineas) { this.lineas = lineas; }
}

