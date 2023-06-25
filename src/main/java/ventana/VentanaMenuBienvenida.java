package ventana;

import data.GestorDatos;
import model.Intranet;

import javax.swing.*;
import java.awt.event.*;

public class VentanaMenuBienvenida extends Ventana {

    private JLabel textoMenu;
    private JButton botonRegistrarEstudiante;
    private JButton botonSalida;
    private JButton botonRegistrarCarrera;
    private JButton botonBuscarEstudiante;
    private Intranet intranet;

    public VentanaMenuBienvenida(Intranet intranet) {
        super("Menu Intranet", 500, 520);
        this.intranet=intranet;
        generarElementosVentana();
    }

    private void generarElementosVentana() {
        generarMensajeMenu();
        generarBotonRegistrarEstudiante();
        generarBotonRegistrarCarrera();
        generarBotonBuscarEstudiante();
        generarBotonSalir();
    }

    private void generarMensajeMenu() {
        String textoBienvenida = "";
        super.generarJLabelEncabezado(this.textoMenu, textoBienvenida, 20, 30, 500, 30);
    }

    private void generarBotonRegistrarEstudiante() {
        String textoBoton = "Registrar Estudiante";
        this.botonRegistrarEstudiante = super.generarBoton(textoBoton, 150, 100, 200, 40);
        this.add(this.botonRegistrarEstudiante);
        this.botonRegistrarEstudiante.addActionListener(this);
    }
    private void generarBotonSalir() {
        String textoBoton = "Salir";
        this.botonSalida = super.generarBoton(textoBoton, 175, 420, 150, 40);
        this.add(this.botonSalida);
        this.botonSalida.addActionListener(this);
    }
    private void generarBotonRegistrarCarrera() {
        String textoBoton = "Registrar Carrera";
        this.botonRegistrarCarrera = super.generarBoton(textoBoton, 150, 180, 200, 40);
        this.add(this.botonRegistrarCarrera);
        this.botonRegistrarCarrera.addActionListener(this);
    }
    private void generarBotonBuscarEstudiante(){
        String textoBoton = "Buscar Estudiante";
        this.botonBuscarEstudiante=super.generarBoton(textoBoton, 150, 260, 200, 40);
        this.add(this.botonBuscarEstudiante);
        this.botonBuscarEstudiante.addActionListener(this);
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.botonRegistrarEstudiante) {
            VentanaRegistrarEstudiante ventanaRegistrarEstudiante = new VentanaRegistrarEstudiante(intranet);
            //Cierra la ventana actual
            this.dispose();
        }
        if(e.getSource() == this.botonRegistrarCarrera){
            VentanaRegistrarCarrera ventanaRegistrarCarrera= new VentanaRegistrarCarrera(intranet);
            this.dispose();
        }
        if(e.getSource() == this.botonBuscarEstudiante){
            VentanaBuscarEstudiante ventanaBuscarEstudiante= new VentanaBuscarEstudiante(intranet);
            this.dispose();
        }
        if(e.getSource() == this.botonSalida){
            GestorDatos.guardarDatos(this.intranet);
            this.dispose();
            System.exit(0);
        }

    }
}