package principal;

import model.*;
import ventana.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Intranet intranet = new Intranet(new ArrayList<>(),new ArrayList<>());
        VentanaMenuBienvenida ventana = new VentanaMenuBienvenida(intranet);


    }
}
