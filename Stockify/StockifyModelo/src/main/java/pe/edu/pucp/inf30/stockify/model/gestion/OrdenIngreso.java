/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.inf30.stockify.model.gestion;


import java.util.Date;
import java.util.List;
import pe.edu.pucp.inf30.stockify.model.personal.Usuario;

public class OrdenIngreso {
    private int idOrdenIngreso;
    private double total;
    private Date fecha;
    private Estado estado;
    private Usuario responsable;
    private List<LineaOrdenIngreso> lineas;

    public OrdenIngreso() {
        this.fecha = new Date();
    }

    public OrdenIngreso(int idOrdenIngreso, double total, Usuario responsable,
                        List<LineaOrdenIngreso> lineas) {
        this.idOrdenIngreso = idOrdenIngreso;
        this.total = total;
        this.fecha = new Date();   
        this.responsable = responsable;
        this.lineas = lineas;
    }

    public int getIdOrdenIngreso() { return idOrdenIngreso; }
    public void setIdOrdenIngreso(int idOrdenIngreso) { this.idOrdenIngreso = idOrdenIngreso; }

    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }

    public Date getFecha() { return fecha; }
    public void setFecha(Date fecha) { this.fecha = fecha; }
    
    public Estado getEstado() { return estado; }
    public void setEstado(Estado estado) { this.estado = estado; }

    public Usuario getResponsable() { return responsable; }
    public void setResponsable(Usuario responsable) { this.responsable = responsable; }

    public List<LineaOrdenIngreso> getLineas() { return lineas; }
    public void setLineas(List<LineaOrdenIngreso> lineas) { this.lineas = lineas; }
}
