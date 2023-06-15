package ventana;

import model.Intranet;

import javax.swing.*;
import javax.swing.text.InternationalFormatter;
import java.awt.event.ActionEvent;

public class VentanaRegistrarEstudiante extends Ventana {
    private JLabel textoEncabezado, textoRut, textoNombre, textoApellido, textoMatricula;
    private JTextField campoRut, campoNombre, campoApellido, campoMatricula;
    private JButton botonRegistrar, botonCancelar;
    private Intranet intranet;


    public VentanaRegistrarEstudiante(Intranet intranet){
        super("Registro de cliente", 500, 520);
        this.intranet = intranet;
        generarElementosVentana();
    }
    private void generarElementosVentana() {
        generarEncabezado();
        generarBotonCancelar();
        generarBotonRegistrar();
        generarCampoNombre();
        generarCampoRut();
        generarCampoApellido();
        generarCampoMatricula();
    }
    private void generarEncabezado() {
        String textoCabecera = "Registro de estudiante";
        super.generarJLabelEncabezado(this.textoEncabezado, textoCabecera, 190, 10, 200, 50);

    }
    private void generarBotonRegistrar() {
        String textoBoton= "Registrar Estudiante";
        this.botonRegistrar = super.generarBoton(textoBoton, 75, 400, 150, 20);
        this.add(this.botonRegistrar);
        this.botonRegistrar.addActionListener(this);
    }
    private void generarBotonCancelar() {
        String textoBotonCancelar = "Cancelar";
        this.botonCancelar = super.generarBoton(textoBotonCancelar, 275, 400, 150, 20);
        this.add(this.botonCancelar);
        this.botonCancelar.addActionListener(this);
    }
    private void generarCampoNombre(){
        String textoNombre= "Nombre:";
        super.generarJLabel(this.textoNombre,textoNombre,20,50,150,20);
        this.campoNombre= super.generarJTextField(200,50,250,20);
        this.add(this.campoNombre);
    }

    private void generarCampoApellido(){
        String textoApellido= "Apellido:";
        super.generarJLabel(this.textoApellido,textoApellido,20,50,150,20);
        this.campoApellido= super.generarJTextField(200,50,250,20);
        this.add(this.campoApellido);
    }


    private void generarCampoRut(){
        String textoRut= "Rut:";
        super.generarJLabel(this.textoRut,textoRut,20,100,150,20);
        this.campoRut= super.generarJTextField(200,100,250,20);
        this.add(this.campoRut);
    }

    private void generarCampoMatricula(){
        String textoMatricula= "Matricula:";
        super.generarJLabel(this.textoMatricula,textoMatricula,20,100,150,20);
        this.campoMatricula= super.generarJTextField(200,100,250,20);
        this.add(this.campoMatricula);
    }


    private boolean registrarCliente(){
        return intranet.añadirEstudiante(this.campoRut.getText(),this.campoMatricula.getText(),this.campoApellido.getText(),this.campoNombre.getText());
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.botonRegistrar) {
            if(registrarCliente()) {
                JOptionPane.showMessageDialog(this,"Estudiante registrado correctamente");
                VentanaMenuBienvenida ventanaMenuBienvenida = new VentanaMenuBienvenida(intranet);
                this.dispose();
            }
            else{
                JOptionPane.showMessageDialog(this,"Ingrese un rut válido");
            }

        }
        if (e.getSource() == this.botonCancelar){
            VentanaMenuBienvenida ventanaMenuBienvenida = new VentanaMenuBienvenida(intranet);
            this.dispose();
        }

    }

}