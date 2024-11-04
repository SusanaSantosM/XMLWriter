package com.Susana.Writer;

import com.Susana.Serializacion2.Producto;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Lector {

    public static ArrayList<Producto> deserealizacion(String archivo){
        ArrayList<Producto> productos = null;

        try{
            FileInputStream fis = new FileInputStream(archivo);
            ObjectInputStream oin = new ObjectInputStream(fis);

            //Leemos el ArrayList
            productos = (ArrayList<Producto>) oin.readObject();

            //Cerramos stream
            oin.close();

        } catch(Exception e){
            e.printStackTrace();
            System.out.println("Ha ocurrido un error.");
        }
        return productos;
    }

}