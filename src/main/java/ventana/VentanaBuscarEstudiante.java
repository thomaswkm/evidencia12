package ventana;

import model.Estudiante;
import model.Intranet;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class VentanaBuscarEstudiante extends Ventana{

    private JLabel textoEncabezado, textoRut, textoCodigo;
    private JTextField campoRut, campoCodigo;
    private JButton botonBuscar, botonCancelar;
    private Intranet intranet;


    public VentanaBuscarEstudiante(Intranet intranet) {
        super("Menu Intranet", 500, 520);
        this.intranet=intranet;
        generarElementosVentana();
    }

    private void generarElementosVentana(){
        generarEncabezado();
        generarBotonBuscar();
        generarBotonCancelar();
        generarCampoRut();
        generarCampoCodigo();
    }

    private void generarEncabezado() {
        String textoCabecera = "Busqueda de Estudiante";
        super.generarJLabelEncabezado(this.textoEncabezado, textoCabecera, 190, 10, 200, 50);

    }

    private void generarBotonBuscar(){
        this.botonBuscar = super.generarBoton("Buscar", 75, 400, 150, 20);
        this.add(this.botonBuscar);
        this.botonBuscar.addActionListener(this);
    }

    private void generarBotonCancelar(){
        this.botonCancelar = super.generarBoton("Cancelar", 275, 400, 150, 20);
        this.add(this.botonCancelar);
        this.botonCancelar.addActionListener(this);
    }

    private void generarCampoRut(){
        String textoRut= "Rut estudiante:";
        super.generarJLabel(this.textoRut, textoRut, 20, 50, 150, 20);
        this.campoRut = super.generarJTextField(200, 50, 250, 20);
        this.add(this.campoRut);
    }

    private void generarCampoCodigo(){
        String textoCodigo= "Codigo:";
        super.generarJLabel(this.textoCodigo, textoCodigo, 20, 80, 150, 20);
        this.campoCodigo = super.generarJTextField(200, 80, 250, 20);
        this.add(this.campoCodigo);
    }

    private Estudiante buscarEstudiante() throws Exception {
        return intranet.buscarEstudiante(this.campoRut.getText(),this.campoCodigo.getText());
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.botonBuscar) {
            try {
                JOptionPane.showMessageDialog(this,"Estudiante: "+buscarEstudiante().toString());
                VentanaMenuBienvenida ventanaMenuBienvenida = new VentanaMenuBienvenida(intranet);
                this.dispose();
            } catch (Exception ex) {
                System.out.println("Error al buscar");
            }
        }
        if (e.getSource() == this.botonCancelar){
            VentanaMenuBienvenida ventanaMenuBienvenida = new VentanaMenuBienvenida(intranet);
            this.dispose();
        }

    }



}
