/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.inf30.stockify.model.almacen;

import java.util.Date;
import java.util.List;
import pe.edu.pucp.inf30.stockify.model.personal.Usuario;
import pe.edu.pucp.inf30.stockify.model.usuario.Empresa;

/**
 *
 * @author Diego
 */
public class GuiaRemision {
    private int idGuiaRemision;
    private double total;
    private Date fecha;
    private Estado estado;
    private Usuario responsable;
    private Empresa cliente;
    private List<LineaGuiaRemision> lineas;

    public GuiaRemision() {
        this.fecha = new Date();
    }
    
    public GuiaRemision(int idGuiaRemision, double total, Estado estado, Usuario responsable, Empresa cliente) {
        this.idGuiaRemision = idGuiaRemision;
        this.total = total;
        this.estado = estado;
        this.responsable = responsable;
        this.cliente = cliente;
        this.fecha = new Date();
    }
    
    
    
    public int getIdGuiaRemision() {
        return this.idGuiaRemision;
    }

    public void setIdGuiaRemision(int idGuiaRemision) {
        this.idGuiaRemision = idGuiaRemision;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Usuario getResponsable() {
        return responsable;
    }

    public void setResponsable(Usuario responsable) {
        this.responsable = responsable;
    }

    public Empresa getCliente() {
        return cliente;
    }

    public void setCliente(Empresa cliente) {
        this.cliente = cliente;
    }

//    public List<LineaGuiaRemision> getLineas() {
//        return lineas;
//    }
//
//    public void setLineas(List<LineaGuiaRemision> lineas) {
//        this.lineas = lineas;
//    }    
    
    
}
