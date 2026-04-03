
package modelo.cuentas;


import modelo.abstractas.Cuenta;
import modelo.abstractas.Persona;
import modelo.excepciones.BancoRuntimeException;

public class CuentaAhorros extends Cuenta {

    private double tasaInteres;

    public CuentaAhorros(String numeroCuenta, Persona titular, double tasaInteres) {
        super(numeroCuenta, titular);

        if (tasaInteres < 0) {
            throw new BancoRuntimeException("tasaInteres"+ tasaInteres);
        }

        this.tasaInteres = tasaInteres;
    }

    @Override
    public void depositar(double monto) {
        if (monto <= 0) {
            throw new BancoRuntimeException("monto"+ monto);
        }

        saldo += monto;
    }

    @Override
    public void retirar(double monto) {
        if (monto <= 0 || monto > saldo) {
            throw new BancoRuntimeException("monto"+ monto);
        }

        saldo -= monto;
    }

    public void aplicarInteres() {
        saldo += saldo * tasaInteres;
    }

    public double getTasaInteres() {
        return tasaInteres;
    }
}
   
