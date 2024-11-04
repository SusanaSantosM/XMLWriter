package com.Susana.Writer;

import com.Susana.Serializacion2.Producto;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DocumentoXML {
    static XMLOutputFactory xof = XMLOutputFactory.newInstance();
    static XMLStreamWriter xtw;

    public static void crearDocumento(String documento, ArrayList<Producto> productos) throws IOException, XMLStreamException {
        xtw = xof.createXMLStreamWriter(new FileWriter(documento));
        xtw.writeStartDocument("1.0");
        xtw.writeStartElement("productos");  // Apertura de etiqueta raíz

            for(Producto producto : productos){
                xtw.writeStartElement("producto");
                xtw.writeAttribute("codigo", producto.getCodigo());
                xtw.writeStartElement("descripcion");
                xtw.writeCharacters(producto.getDesc());
                xtw.writeEndElement();
                xtw.writeStartElement("precio");
                xtw.writeCharacters(String.valueOf(producto.getPrecio()));
                xtw.writeEndElement();
                xtw.writeEndElement();   // Cierre de producto

            }
        xtw.writeEndElement();  // Cierre de productos
        xtw. writeEndDocument();
        xtw.flush();
        xtw.close();

        System.out.println("Documento XML creado con éxito"+documento);
    }

}
