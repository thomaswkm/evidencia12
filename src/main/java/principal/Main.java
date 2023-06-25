package principal;

import data.GestorDatos;
import model.*;
import ventana.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Intranet intranet = new Intranet(GestorDatos.cargarDatosCarreras(),GestorDatos.cargarDatosEstudiantes());
        VentanaMenuBienvenida ventana = new VentanaMenuBienvenida(intranet);


    }
}
