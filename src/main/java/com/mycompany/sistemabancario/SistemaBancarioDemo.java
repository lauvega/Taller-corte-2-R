
package com.mycompany.sistemabancario;



import modelo.abstractas.Persona;
import modelo.cuentas.CuentaAhorros;
import modelo.cuentas.CuentaCorriente;
import modelo.cuentas.CuentaCredito;

import java.time.LocalDate;

public class SistemaBancarioDemo {

    public static void main(String[] args) {

        // Creamos una persona (cualquiera porque es abstracta)
        Persona persona = new Persona("123", "Juan", "Perez",
                LocalDate.of(2000, 1, 1), "juan@gmail.com") {

            @Override
            public int calcularEdad() {
                return calcularEdadBase();
            }

            @Override
            public String obtenerTipo() {
                return "Persona";
            }

            @Override
            public String obtenerDocumentoIdentidad() {
                return "123";
            }
        };

        // Cuenta Ahorros
        CuentaAhorros ahorro = new CuentaAhorros("001", persona, 0.05);
        ahorro.depositar(1000);
        ahorro.aplicarInteres();
        System.out.println("Saldo Ahorros: " + ahorro.getSaldo());

        //  Cuenta Corriente
        CuentaCorriente corriente = new CuentaCorriente("002", persona, 500);
        corriente.depositar(500);
        corriente.retirar(800);
        System.out.println("Saldo Corriente: " + corriente.getSaldo());

        // Cuenta Credito
        CuentaCredito credito = new CuentaCredito("003", persona, 1000);
        credito.retirar(300);
        credito.depositar(100);
        System.out.println("Deuda Credito: " + credito.getSaldo());
    }
}


    

