package com.proyecto7;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class CuentaDeBanco {

    private HashMap<String, Cuenta> cuentaBanco = new HashMap<>();
    private Scanner sc;

    public CuentaDeBanco(Scanner sc) {
        this.sc=sc;
    }

    public void crearCuentaBanco() {
        System.out.println("Ingrese el numero de la cuenta");
        String numeroCuenta = sc.nextLine();
        System.out.println("Ingrese el nombre de la cuenta");
        String nombreCuenta = sc.nextLine();
        Cuenta cuenta = new Cuenta(numeroCuenta,nombreCuenta);
        cuentaBanco.put(numeroCuenta,cuenta);
        System.out.println("Se creo la cuenta con exito.");
    }

    public synchronized void depositarDinero() {
        try {
            if (cuentaBanco.isEmpty()){
                System.out.println("No tiene ninguna cuenta, debe crearse una.");
            } else {
                System.out.println("Ingrese el numero de la cuenta que desea depositar");
                String numeroCuenta = sc.nextLine();
                if (cuentaBanco.containsKey(numeroCuenta)) {
                    System.out.println("Ingrese la cantidad de dinero que desea depositar");
                    double cantidadDinero = sc.nextDouble();
                    sc.nextLine();
                    if (cantidadDinero > 0) {
                        Cuenta cuenta = cuentaBanco.get(numeroCuenta);
                        cuenta.setCantidadDinero(cuenta.getCantidadDinero() + cantidadDinero);
                        System.out.println("Se deposito $" + cantidadDinero + " a la cuenta " +numeroCuenta + " exitosamente.");
                    } else {
                        System.out.println("No puede depositar esa cantidad.");
                    }
                } else {
                    System.out.println("El numero de la cuenta no existe.");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Error, hubo un error al ingresar los datos. Intente ingresar nuevamente y verifique bien los datos");
            System.out.println("Error: " + e.getMessage());
            sc.next();
        }
    }

    public synchronized void retirarDinero() {
        try {
            if (cuentaBanco.isEmpty()){
                System.out.println("No tiene ninguna cuenta, debe crearse una.");
            } else {
                System.out.println("Ingrese el numero de la cuenta que desea retirar");
                String numeroCuenta = sc.nextLine();
                if (cuentaBanco.containsKey(numeroCuenta)){
                    System.out.println("Ingrese la cantidad de dinero que desea retirar");
                    double cantidadDinero = sc.nextDouble();
                    sc.nextLine();
                    Cuenta cuenta = cuentaBanco.get(numeroCuenta);
                    if (cantidadDinero < 0 || cantidadDinero > cuenta.getCantidadDinero()) {
                        System.out.println("Cantidad de dinero invalido o insuficiente en la cuenta.");
                    } else {
                        cuenta.setCantidadDinero(cuenta.getCantidadDinero() - cantidadDinero);
                        System.out.println("Se retiro $" +cantidadDinero +" de la cuenta " +numeroCuenta + " exitosamente.");
                    }
                } else {
                    System.out.println("El numero de la cuenta no existe.");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Error, hubo un error al ingresar los datos. Intente ingresar nuevamente y verifique bien los datos");
            System.out.println("Error: " + e.getMessage());
            sc.next();
        }
    }

    public synchronized void transferirDinero() {
        try {
            System.out.println("Ingrese el numero de cuenta que se usara para transferir");
            String numeroCuenta1 = sc.nextLine();
            System.out.println("Ingrese el numero de cuenta que recibira la transaccion");
            String numeroCuenta2 = sc.nextLine();

            if (numeroCuenta1.equals(numeroCuenta2)) {
                System.out.println("No puedes hacer transaccion a la misma cuenta.");
            } else {
                if (cuentaBanco.containsKey(numeroCuenta1) && cuentaBanco.containsKey(numeroCuenta2)) {
                    System.out.println("Ingrese la cantidad que desea transferir");
                    double cantidad = sc.nextDouble();
                    sc.nextLine();
                    Cuenta cuenta1 = cuentaBanco.get(numeroCuenta1);
                    if (cantidad > 0 && cantidad <= cuenta1.getCantidadDinero()) {
                        cuenta1.setCantidadDinero(cuenta1.getCantidadDinero() - cantidad);
                        Cuenta cuenta2 = cuentaBanco.get(numeroCuenta2);
                        cuenta2.setCantidadDinero(cuenta2.getCantidadDinero() + cantidad);
                        System.out.println("Se transferio $" +cantidad +" de la cuenta " +numeroCuenta1 + " a la cuenta " +numeroCuenta2 + ".");
                    } else {
                        System.out.println("Cantidad de dinero invalido o insuficiente de la cuenta " +numeroCuenta1);
                    }
                } else {
                    System.out.println("Uno de los dos numeros de cuenta no existe o esta mal escrito, intente nuevamente.");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Error, hubo un error al ingresar los datos. Intente ingresar nuevamente y verifique bien los datos");
            System.out.println("Error: " + e.getMessage());
            sc.next();
        }
    }

    public synchronized void verSaldo() {
        if (cuentaBanco.isEmpty()) {
            System.out.println("No tiene ninguna cuenta, debe crearse una.");
        } else {
            for (Cuenta cb : cuentaBanco.values()) {
                System.out.println(cb);
                System.out.println();
            }
        }
    }

}
