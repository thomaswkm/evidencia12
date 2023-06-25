package model;

import java.util.ArrayList;

public class Intranet {
    private ArrayList<Carrera> carreras;
    private ArrayList<Estudiante> estudiantes;

    public Intranet() {
    }

    public Intranet(ArrayList<Carrera> carreras, ArrayList<Estudiante> estudiantes) {
        this.carreras = carreras;
        this.estudiantes = estudiantes;
    }

    public ArrayList<Carrera> getCarreras() {
        return carreras;
    }

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public boolean añadirEstudiante(String rut, String nombre, String apellido, String matricula, String codigoCarrera) {
        Estudiante estudiante = null;
        try {
            estudiante = new Estudiante(rut, nombre, apellido, matricula, buscarCarrera(codigoCarrera));
        } catch (Exception e) {
            System.out.println("Error al crear el estudiante");
        }
        if (!estudiantes.contains(estudiante)) {
            estudiantes.add(estudiante);
            añadirEstudianteACarrera(estudiante,estudiante.getCarrera());
            return true;
        } else {
            System.out.println("El estudiante ya esta registrado");
            return false;
        }

    }

    public boolean añadirEstudianteACarrera(Estudiante e, Carrera c){
        if(!c.getEstudiantes().contains(e)){
            c.getEstudiantes().add(e);
            return true;
        }else{
            System.out.println("El estudiante ya está registrado en la carrera");
            return false;
        }
    }

    public Estudiante buscarEstudiante(String rut, String codigo) throws Exception {
        Carrera c = buscarCarrera(codigo);
        for (Estudiante e: c.getEstudiantes()) {
            if(e.getRut().equals(rut)){
                return e;
            }
        }
        throw new Exception("Estudiante no encontrado");
    }

    public Carrera buscarCarrera(String codigo) throws Exception {
        for (Carrera c: this.carreras) {
            if(c.getCodigo().equals(codigo)){
                return c;
            }
        }
        throw new Exception("No se encontró ninguna carrera con ese código");
    }


    public boolean añadirCarrera(String nombre, String codigo, String cantidadSemestres) {
        for (Carrera c: this.carreras) {
            if(c.getCodigo().equals(codigo)){
                return false;
            }
        }
        this.carreras.add(new Carrera(nombre,codigo,cantidadSemestres,new ArrayList<>()));
        return true;
    }

}
