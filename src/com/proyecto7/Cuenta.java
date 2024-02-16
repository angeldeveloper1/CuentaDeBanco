package com.proyecto7;

public class Cuenta {

    private String numeroCuenta;
    private String nombreCuenta;
    private double cantidadDinero;

    public Cuenta (String numeroCuenta, String nombreCuenta) {
        this.numeroCuenta = numeroCuenta;
        this.nombreCuenta = nombreCuenta;
        this.cantidadDinero = 0;
    }
    public String getNumeroCuenta() {
        return numeroCuenta;
    }
    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }
    public String getNombreCuenta () {
        return nombreCuenta;
    }
    public void setNombreCuenta(String nombreCuenta) {
        this.nombreCuenta = nombreCuenta;
    }
    public double getCantidadDinero() {
        return cantidadDinero;
    }
    public void setCantidadDinero(double cantidadDinero) {
        this.cantidadDinero = cantidadDinero;
    }
    @Override
    public String toString() {
        return "Numero de la cuenta: " +numeroCuenta + "\nNombre de la cuenta: " +nombreCuenta + "\nSaldo: $" + cantidadDinero;
    }
}
