
package modelo.cuentas;



import modelo.abstractas.Cuenta;
import modelo.abstractas.Persona;
import modelo.excepciones.BancoRuntimeException;

public class CuentaCorriente extends Cuenta {

    private double limiteSobregiro;

    // CONSTRUCTOR
    public CuentaCorriente(String numeroCuenta, Persona titular, double limiteSobregiro) {
        super(numeroCuenta, titular);

        if (limiteSobregiro < 0) {
            throw new BancoRuntimeException("limiteSobregiro"+ limiteSobregiro);
        }

        this.limiteSobregiro = limiteSobregiro;
    }

    // DEPÓSITO
    @Override
    public void depositar(double monto) {
        if (monto <= 0) {
            throw new BancoRuntimeException("monto"+ monto);
        }

        saldo += monto;
    }

    // RETIRO (CON SOBREGIRO)
    @Override
    public void retirar(double monto) {
        if (monto <= 0) {
            throw new BancoRuntimeException("monto"+ monto);
        }

       
        if (saldo - monto < -limiteSobregiro) {
            throw new BancoRuntimeException("fondos insuficientes"+ monto);
        }

        saldo -= monto;
    }

    
    public double getLimiteSobregiro() {
        return limiteSobregiro;
    }
}

    

