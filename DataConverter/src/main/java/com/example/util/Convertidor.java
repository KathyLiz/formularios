/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.util;

import com.example.entities.Formulario;
import com.example.entities.FormularioData;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
/**
 *
 * @author Kathy
 */
public class Convertidor {
    private FormularioData frmData = FormularioData.getInstancia();
    public Convertidor(){}
    
    public void convertirJson (String data){
        Gson gson = new Gson();
        System.out.println("DATA " + data);
        Formulario formulario = gson.fromJson(data, Formulario.class);
        this.frmData.setFacultad(formulario.getFacultad());
        this.frmData.setCarrera(formulario.getCarrera());
        this.frmData.setNombres(formulario.getNombres());
        this.frmData.setApellidos(formulario.getApellidos());
        this.frmData.setDocumento(formulario.getDocumento());
        this.frmData.setPeriodo(formulario.getPeriodo());
        this.frmData.setFecha(formulario.getFecha());
        this.frmData.setTipo(formulario.getTipo());
        System.out.println("Objeto data "+  new Gson().toJson(this.frmData));
        try {
            this.generarReporte ();
            // return formulario;
        } catch (JRException ex) {
            Logger.getLogger(Convertidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void generarReporte () throws JRException{
        File f_aa_201 = new File("f_aa_201.jasper");
        HashMap map = new HashMap();
        map.put("UNIDAD_ACADEMICA",this.frmData.getFacultad()); 
        map.put("CARRERA",this.frmData.getCarrera()); 
        map.put("PERIODO",this.frmData.getPeriodo()); 
        map.put("IDENTIFICACION",this.frmData.getDocumento()); 
        map.put("NOMBRE",this.frmData.getNombres() + this.frmData.getApellidos()); 
        map.put("PAGO_PARTES",false); 
        map.put("PAGO_IECE",false); 
        map.put("EXTRAORDINARIA",false); 
        map.put("EXTRAORDINARIA_SR",false); 
        map.put("PRORROGA",false);
        map.put("TITULACION_ACTUAL",null);
        map.put("TITULACION_NUEVO",null);        
        map.put("ANULACION",true);
        map.put("ANULACION_MAT_MOD",false);        
        map.put("JUSTIFICACION",this.frmData.getFacultad());
        map.put("DOCUMENTO_ADJUNTO",this.frmData.getFacultad());
        JasperReport reporte = (JasperReport) JRLoader.loadObject(f_aa_201);
        JasperPrint print = JasperFillManager.fillReport(reporte, map, new JREmptyDataSource());
        JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, map, new JREmptyDataSource());
            
           // JRExporter exporter = new JRPdfExporter();
           JRDocxExporter exporter = new JRDocxExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("formularioPDF.docx"));
            exporter.exportReport();
        /*File pdf = null;
        try {
            pdf = File.createTempFile("/output.", ".pdf");
        } catch (IOException ex) {
            Logger.getLogger(Convertidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            JasperExportManager.exportReportToPdfStream(print, new FileOutputStream(pdf));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Convertidor.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
        System.out.println("termineó");

    }
    
}
