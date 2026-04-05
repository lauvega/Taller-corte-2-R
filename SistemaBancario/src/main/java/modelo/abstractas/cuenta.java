
package modelo.abstractas;
import modelo.excepciones.BancoRuntimeException;


public abstract class cuenta {
    private String numeroCuenta;
    protected double saldo;
    private Persona titular;
    private boolean activa;
    
     public cuenta(String numeroCuenta, Persona titular) {
        setNumeroCuenta(numeroCuenta);
        this.titular = titular;
        this.saldo = 0;
        this.activa = true;
    }
     
      public abstract void depositar(double monto);
    public abstract void retirar(double monto);
    
    public void setNumeroCuenta(String numeroCuenta) {
        if (numeroCuenta == null || numeroCuenta.isEmpty()) {
            throw new BancoRuntimeException("numeroCuenta"+ numeroCuenta);
        }
        this.numeroCuenta = numeroCuenta;
    }
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public Persona getTitular() {
        return titular;
    }

    public boolean isActiva() {
        return activa;
    }

    // MÉTODOS COMUNES
    public void activar() {
        activa = true;
    }

    public void desactivar() {
        activa = false;
    }
}

