package model;

public class Estudiante {
    private String rut;
    private String nombre;
    private String apellido;
    private String matricula;
    private Carrera carrera;

    public Estudiante() {
    }

    public Estudiante(String rut, String nombre, String apellido, String matricula, Carrera carrera) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
        this.carrera = carrera;
    }

    public String getRut() {
        return rut;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "rut='" + rut + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", matricula='" + matricula + '\'' +
                '}';
    }
}
