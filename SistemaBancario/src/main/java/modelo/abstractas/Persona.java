
package modelo.abstractas;
import modelo.excepciones.BancoRuntimeException;
import java.time.LocalDate;
import java.time.Period;

public abstract class Persona {

    private String id;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private String email;

    public Persona(String id, String nombre, String apellido,
                   LocalDate fechaNacimiento, String email) {

        setId(id);
        this.nombre = nombre;
        this.apellido = apellido;
        setFechaNacimiento(fechaNacimiento);
        setEmail(email);
    }

  
    public abstract int calcularEdad();
    public abstract String obtenerTipo();
    public abstract String obtenerDocumentoIdentidad();


    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }


    public void setId(String id) {
        if (id == null || id.isEmpty()) {
            throw new BancoRuntimeException("id"+ id);
        }
        this.id = id;
    }

    public void setEmail(String email) {
        if (email == null || !email.contains("@")) {
            throw new BancoRuntimeException("email"+ email);
        }
        this.email = email;
    }

    public void setFechaNacimiento(LocalDate fecha) {
        if (fecha.isAfter(LocalDate.now())) {
            throw new BancoRuntimeException("fechaNacimiento"+ fecha);
        }
        this.fechaNacimiento = fecha;
    }

    public int calcularEdadBase() {
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }

    public String getId() {
        return id;
    }
}