package ventana;

import model.Intranet;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class VentanaRegistrarCarrera extends Ventana{
    private JLabel textoEncabezado, textoNombreCarrera, textoCodigo, textoCantidadSemestres;
    private JTextField campoNombreCarrera, campoCodigo, campoCantidadSemestres;
    private JButton botonRegistrar, botonCancelar;
    private Intranet intranet;

    public VentanaRegistrarCarrera(Intranet intranet){
        super("Registro de cliente", 500, 520);
        this.intranet = intranet;
        generarElementosVentana();
    }

    private void generarElementosVentana() {
        generarEncabezado();
        generarBotonCancelar();
        generarBotonRegistrar();
        generarCampoNombreCarrera();
        generarCampoCodigo();
        generarCampoCantidadSemestres();
    }

    private void generarEncabezado() {
        String textoCabecera = "Registro de Carrera";
        super.generarJLabelEncabezado(this.textoEncabezado, textoCabecera, 190, 10, 200, 50);

    }
    private void generarBotonRegistrar() {
        String textoBoton= "Registrar Carrera";
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
    private void generarCampoNombreCarrera(){
        String textoNombreCarrera= "Nombre carrera:";
        super.generarJLabel(this.textoNombreCarrera, textoNombreCarrera, 20, 50, 150, 20);
        this.campoNombreCarrera= super.generarJTextField(200, 50, 250, 20);
        this.add(this.campoNombreCarrera);
    }

    private void generarCampoCodigo(){
        String textoCodigo= "Codigo:";
        super.generarJLabel(this.textoCodigo, textoCodigo, 20, 80, 150, 20);
        this.campoCodigo= super.generarJTextField(200, 80, 250, 20);
        this.add(this.campoCodigo);
    }

    private void generarCampoCantidadSemestres(){
        String textoCantidadSemestres= "Cantidad de Semestres:";
        super.generarJLabel(this.textoCantidadSemestres, textoCantidadSemestres, 20, 110, 150, 20);
        this.campoCantidadSemestres= super.generarJTextField(200, 110, 250, 20);
        this.add(this.campoCantidadSemestres);
    }

    private boolean registrarCarrera(){
        return intranet.añadirCarrera(this.campoNombreCarrera.getText(),this.campoCodigo.getText(),this.campoCantidadSemestres.getText());
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.botonRegistrar) {
            if(registrarCarrera()) {
                JOptionPane.showMessageDialog(this,"Carrera registrada correctamente");
                VentanaMenuBienvenida ventanaMenuBienvenida = new VentanaMenuBienvenida(intranet);
                this.dispose();
            }
            else{
                JOptionPane.showMessageDialog(this,"Error al registrar.");
            }

        }
        if (e.getSource() == this.botonCancelar){
            VentanaMenuBienvenida ventanaMenuBienvenida = new VentanaMenuBienvenida(intranet);
            this.dispose();
        }

    }


}
