package com.proyecto7;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CuentaDeBanco cuentaBanco = new CuentaDeBanco(scanner);

        boolean condicion = true;
        while (condicion) {
            System.out.println("Cuenta De Banco");
            System.out.println("1. Crear cuenta");
            System.out.println("2. Depositar dinero a la cuenta");
            System.out.println("3. Retirar dinero de la cuenta");
            System.out.println("4. Transferir dinero a la otra cuenta");
            System.out.println("5. Ver saldo de la cuenta");
            System.out.println("0. Salir");

            if (scanner.hasNextInt()) {
                int opcion = scanner.nextInt();
                scanner.nextLine();

                if (opcion < 0 || opcion > 5) {
                    System.out.println("Opcion invalida. Ingrese las opciones (1,2,3,4,5) o CERO (0) para salir");
                    continue;
                }

                if (opcion == 1) {
                    cuentaBanco.crearCuentaBanco();
                }
                if (opcion == 2) {
                    cuentaBanco.depositarDinero();
                }
                if (opcion == 3) {
                    cuentaBanco.retirarDinero();
                }
                if (opcion == 4) {
                    cuentaBanco.transferirDinero();
                }
                if (opcion == 5) {
                    cuentaBanco.verSaldo();
                }
                if (opcion == 0) {
                    System.out.println("Saliendo...");
                    System.out.println("Hasta pronto!");
                    condicion = false;
                }

                System.out.println();

            } else {
                System.out.println("No puede ingresar letras o caracteres. Ingrese las opciones (1,2,3,4,5) o CERO (0) para salir");
                scanner.next();
            }
        }
    }
}
