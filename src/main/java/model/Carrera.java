package model;

import java.util.ArrayList;

public class Carrera {

    private String nombre;
    private String codigo;
    private String cantidadSemestres;
    private ArrayList<Estudiante> estudiantes;

    public Carrera(String nombre, String codigo, String cantidadSemestres, ArrayList<Estudiante> estudiantes) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.cantidadSemestres = cantidadSemestres;
        this.estudiantes = estudiantes;
    }

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public String getCodigo() {
        return codigo;
    }
}


