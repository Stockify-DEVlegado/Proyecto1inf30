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
    public OrdenVenta() {}

    // Constructor con parámetros
    public OrdenVenta(int idOrdenVenta, double total, Date fecha, Estado estado,
                      Empresa cliente, List<LineaOrdenVenta> lineas) {
        this.idOrdenVenta = idOrdenVenta;
        this.total = total;
        this.fecha = fecha;
        this.estado = estado;
        this.cliente = cliente;
        this.lineas = lineas;
    }

    // Getters y Setters
    public int getIdOrdenVenta() {
        return idOrdenVenta;
    }
}

