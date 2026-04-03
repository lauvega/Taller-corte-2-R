
package modelo.cuentas;



import modelo.abstractas.Cuenta;
import modelo.abstractas.Persona;
import modelo.excepciones.BancoRuntimeException;

public class CuentaCredito extends Cuenta {

    private double limiteCredito;

    // CONSTRUCTOR
    public CuentaCredito(String numeroCuenta, Persona titular, double limiteCredito) {
        super(numeroCuenta, titular);

        if (limiteCredito <= 0) {
            throw new BancoRuntimeException("limiteCredito"+ limiteCredito);
        }

        this.limiteCredito = limiteCredito;
    }

    

   
    @Override
    public void retirar(double monto) {
        if (monto <= 0) {
            throw new BancoRuntimeException("monto"+ monto);
        }

        if (saldo + monto > limiteCredito) {
            throw new BancoRuntimeException("limiteCredito excedido"+ monto);
        }

        saldo += monto; // deuda aumenta
    }

    // PAGAR DEUDA
    @Override
    public void depositar(double monto) {
        if (monto <= 0) {
            throw new BancoRuntimeException("monto"+ monto);
        }

        saldo -= monto; // deuda baja

        if (saldo < 0) {
            saldo = 0; // no deuda negativa
        }
    }

    public double getLimiteCredito() {
        return limiteCredito;
    }
}

    

