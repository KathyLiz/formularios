/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.entities;

import java.util.Date;

/**
 *
 * @author Kathy
 */
public class Formulario {
    private String facultad;
    private String carrera;
    private String nombres;
    private String apellidos;
    private String documento;
    private String periodo;
    private Date fecha;
    private static Formulario formulario;
    
   public  static Formulario getInstancia(String facultad, String carrera, String nombres, String apellidos, String documento, String periodo, Date fecha) {
 
    if (formulario==null) {

    formulario = new Formulario(facultad, carrera, nombres, apellidos, documento, periodo, fecha);
    }
    return formulario;
    }

    private Formulario(String facultad, String carrera, String nombres, String apellidos, String documento, String periodo, Date fecha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    // GETTERS

    public String getFacultad() {
        return facultad;
    }

    public String getCarrera() {
        return carrera;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getDocumento() {
        return documento;
    }

    public String getPeriodo() {
        return periodo;
    }

    public Date getFecha() {
        return fecha;
    }

    public static Formulario getFormulario() {
        return formulario;
    }
}
