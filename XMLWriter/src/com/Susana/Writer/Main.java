package com.Susana.Writer;

import com.Susana.Serializacion2.Producto;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Main {
    private static String archivoSerializado="../Serializacion2/archivo.txt";
    private static String archivoXML="productos.xml";

    public static void main(String[] args) throws IOException, XMLStreamException {
        // Crear una ruta relativa al archivo
        Path path = Paths.get(archivoSerializado);

        // Verificamos si el archivo existe
        if (Files.exists(path)) {
            // Deserealizamos los productos
            ArrayList<Producto> productos = Lector.deserealizacion(archivoSerializado);

            if(productos != null){
                // Escribimos el archivo XML
                DocumentoXML.crearDocumento(archivoXML, productos);
            } else {
                System.out.println("No se pudo deserealizar el archivo");
            }

        } else {
            System.out.println("El archivo no existe");
        }



    }
}