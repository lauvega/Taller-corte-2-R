
package modelo.abstractas;

import java.time.LocalDate;
import java.time.Period;

public abstract class Empleado extends Persona {

    private String legajo;
    private LocalDate fechaContratacion;
    protected double salarioBase;
    private boolean activo;

    public Empleado(String id, String nombre, String apellido,
                    LocalDate fechaNacimiento, String email,
                    String legajo, LocalDate fechaContratacion,
                    double salarioBase) {

        super(id, nombre, apellido, fechaNacimiento, email);

        this.legajo = legajo;
        this.fechaContratacion = fechaContratacion;
        this.salarioBase = salarioBase;
        this.activo = true;
    }

    //  Metodos Abstractatos
    public abstract double calcularSalario();
    public abstract double calcularBono();

    // Metodo concreto
    public int calcularAntiguedad() {
        return Period.between(fechaContratacion, LocalDate.now()).getYears();
    }

    public boolean isActivo() {
        return activo;
    }
}