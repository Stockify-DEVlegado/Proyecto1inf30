/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.inf30.stockify.model.almacen;

public class Existencias {
    private int idExistencia;
    private int idUnico;
    private String nombre;
    private double precio;
    private int stockActual;
    private int cantidad;
    private int cantidadUtilizada;

    public Existencias() {}

    public Existencias(int idExistencia, int idUnico, String nombre, double precio,
                       int stockActual, int cantidad, int cantidadUtilizada) {
        this.idExistencia = idExistencia;
        this.idUnico = idUnico;
        this.nombre = nombre;
        this.precio = precio;
        this.stockActual = stockActual;
        this.cantidad = cantidad;
        this.cantidadUtilizada = cantidadUtilizada;
    }

    public int getIdExistencia() {
        return idExistencia;
    }

    public void setIdExistencia(int idExistencia) {
        this.idExistencia = idExistencia;
    }

    public int getIdUnico() {
        return idUnico;
    }

    public void setIdUnico(int idUnico) {
        this.idUnico = idUnico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStockActual() {
        return stockActual;
    }

    public void setStockActual(int stockActual) {
        this.stockActual = stockActual;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCantidadUtilizada() {
        return cantidadUtilizada;
    }

    public void setCantidadUtilizada(int cantidadUtilizada) {
        this.cantidadUtilizada = cantidadUtilizada;
    }
}
