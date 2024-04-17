/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;


import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author juan
 */
public class MDatosPersonales {
        public static void generarFacturaPDF(String seleccion1, String seleccion2, String seleccion3) {
        // Define mapeos separados para cada JComboBox
        Map<String, String> opciones1 = new HashMap<>();
        opciones1.put("Cedula de ciudadanía", "Cedula de ciudadanía");
        opciones1.put("Cedula Extranjera", "Cedula Extranjera");
        opciones1.put("Tarjeta de identidad", "Tarjeta de identidad");
        opciones1.put("Nit", "Nit");

 
        String valor1 = opciones1.get(seleccion1);



        // Genera la factura en PDF
        generarFacturaPDFDocument(seleccion1, seleccion2, seleccion3);
    }

    private static void generarFacturaPDFDocument(String seleccion1, String seleccion2, String seleccion3) {
    Document documento = new Document();

    try {
        // Generar un nombre de archivo único basado en la marca de tiempo
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String fechaHora = sdf.format(new Date());
        String archivoPDF = "Turno_" + fechaHora + ".pdf"; // Nombre del archivo de factura único

        PdfWriter.getInstance(documento, new FileOutputStream(archivoPDF));
        documento.open();

        // Agregar contenido a la factura
        documento.add(new Paragraph("Datos del cliente "));
        documento.add(new Paragraph("Tipo de documento " + seleccion1));
        documento.add(new Paragraph("Numero de documento " + seleccion2));
        documento.add(new Paragraph("Numero de celular " + seleccion3));

        // Puedes agregar más información a la factura según tus necesidades

        // Cerrar el documento
        documento.close();

        JOptionPane.showMessageDialog(null, "Factura generada exitosamente en: " + archivoPDF, "Factura Generada", JOptionPane.INFORMATION_MESSAGE);
    } catch (DocumentException | IOException e) {
        e.printStackTrace();
    }
}
}
