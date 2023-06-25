package data;

import model.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.util.ArrayList;

public class GestorDatos {

    public static void guardarDatos(Intranet intranet) {

        guardarEstudiantes(intranet.getEstudiantes(), "estudiantes.json");

        guardarCarreras(intranet.getCarreras(), "carreras.json");
    }

    private static void guardarEstudiantes(ArrayList<Estudiante> estudiantes, String ruta) {
        JSONArray jsonArray = new JSONArray();

        for (Estudiante estudiante : estudiantes) {
            JSONObject estudianteJson = new JSONObject();
            estudianteJson.put("rut", estudiante.getRut());
            estudianteJson.put("nombre", estudiante.getNombre());
            estudianteJson.put("apellido", estudiante.getApellido());
            estudianteJson.put("matricula", estudiante.getMatricula());

            Carrera carrera = estudiante.getCarrera();
            if (carrera != null) {
                JSONObject carreraJson = new JSONObject();
                carreraJson.put("nombre", carrera.getNombre());
                carreraJson.put("codigo", carrera.getCodigo());
                carreraJson.put("cantidadSemestres", carrera.getCantidadSemestres());

                estudianteJson.put("carrera", carreraJson);
            }

            jsonArray.put(estudianteJson);
        }

        try (FileWriter fileWriter = new FileWriter(ruta)) {
            fileWriter.write(jsonArray.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void guardarCarreras(ArrayList<Carrera> carreras, String ruta) {
        JSONArray jsonArray = new JSONArray();

        for (Carrera carrera : carreras) {
            JSONObject carreraJson = new JSONObject();
            carreraJson.put("nombre", carrera.getNombre());
            carreraJson.put("codigo", carrera.getCodigo());
            carreraJson.put("cantidadSemestres", carrera.getCantidadSemestres());

            ArrayList<Estudiante> estudiantesCarrera = carrera.getEstudiantes();
            if (estudiantesCarrera != null && !estudiantesCarrera.isEmpty()) {
                JSONArray estudiantesArray = new JSONArray();
                for (Estudiante estudiante : estudiantesCarrera) {
                    JSONObject estudianteJson = new JSONObject();
                    estudianteJson.put("rut", estudiante.getRut());
                    estudianteJson.put("nombre", estudiante.getNombre());
                    estudianteJson.put("apellido", estudiante.getApellido());
                    estudianteJson.put("matricula", estudiante.getMatricula());

                    estudiantesArray.put(estudianteJson);
                }

                carreraJson.put("estudiantes", estudiantesArray);
            }

            jsonArray.put(carreraJson);
        }

        try (FileWriter fileWriter = new FileWriter(ruta)) {
            fileWriter.write(jsonArray.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static ArrayList<Estudiante> cargarDatosEstudiantes() {
        ArrayList<Estudiante> estudiantes = new ArrayList<>();

        try (FileReader fileReader = new FileReader("estudiantes.json")) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuilder stringBuilder = new StringBuilder();
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }

            JSONArray jsonArray = new JSONArray(stringBuilder.toString());

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                String rut = jsonObject.getString("rut");
                String nombre = jsonObject.getString("nombre");
                String apellido = jsonObject.getString("apellido");
                String matricula = jsonObject.getString("matricula");

                // Obtener los datos necesarios para crear una instancia de Carrera
                String nombreCarrera = jsonObject.getJSONObject("carrera").getString("nombre");
                String codigoCarrera = jsonObject.getJSONObject("carrera").getString("codigo");
                String semestresCarrera = jsonObject.getJSONObject("carrera").getString("cantidadSemestres");

                // Crear una instancia de Carrera con los datos extraídos
                Carrera carrera = new Carrera(nombreCarrera, codigoCarrera, semestresCarrera, null);

                // Crear una instancia de Estudiante con los valores extraídos del JSON
                Estudiante estudiante = new Estudiante(rut, nombre, apellido, matricula, carrera);

                estudiantes.add(estudiante);
            }
        } catch (IOException ex) {
            // El archivo no existe o no se puede leer
            System.out.println("No se pudo cargar el archivo estudiantes.json.");
            // Aquí puedes agregar lógica adicional, como crear un archivo vacío o mostrar un mensaje de error al usuario
        }

        return estudiantes;
    }


    public static ArrayList<Carrera> cargarDatosCarreras() {
        ArrayList<Carrera> carreras = new ArrayList<>();

        try (FileReader fileReader = new FileReader("carreras.json")) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuilder stringBuilder = new StringBuilder();
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }

            JSONArray jsonArray = new JSONArray(stringBuilder.toString());

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                String nombreCarrera = jsonObject.getString("nombre");
                String codigoCarrera = jsonObject.getString("codigo");
                String semestresCarrera = jsonObject.getString("cantidadSemestres");

                JSONArray estudiantesArray = jsonObject.getJSONArray("estudiantes");
                ArrayList<Estudiante> estudiantesCarrera = new ArrayList<>();

                for (int j = 0; j < estudiantesArray.length(); j++) {
                    JSONObject estudianteJson = estudiantesArray.getJSONObject(j);

                    String rut = estudianteJson.getString("rut");
                    String nombre = estudianteJson.getString("nombre");
                    String apellido = estudianteJson.getString("apellido");
                    String matricula = estudianteJson.getString("matricula");

                    // Crear una instancia de Estudiante con los valores extraídos del JSON
                    Estudiante estudiante = new Estudiante(rut, nombre, apellido, matricula, null);

                    estudiantesCarrera.add(estudiante);
                }

                // Crear una instancia de Carrera con los valores extraídos del JSON
                Carrera carrera = new Carrera(nombreCarrera, codigoCarrera, semestresCarrera, estudiantesCarrera);

                carreras.add(carrera);
            }
        } catch (IOException ex) {
            // El archivo no existe o no se puede leer
            System.out.println("No se pudo cargar el archivo carreras.json.");
            // Aquí puedes agregar lógica adicional, como crear un archivo vacío o mostrar un mensaje de error al usuario

        }

        return carreras;
    }
}










