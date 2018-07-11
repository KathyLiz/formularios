/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.entities;

/**
 *
 * @author Kathy
 */
public class FormularioData {
     private String tipo;
    private String nombre;
    private String facultad;
    private String carrera;
    private String nombres;
    private String apellidos;
    private String documento;
    private String periodo;
    private String fecha;
    private String justificacion;
    private String adjuntos;
    private static FormularioData formulario = null;
    
   public  static FormularioData getInstancia() {
 
    if (formulario==null) {

    formulario = new FormularioData();
    }
    return formulario;
    }

    private FormularioData() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //Getters and Setters
    public String getTipo() {
        return tipo;
    }

    public String getNombre() {
        return nombre;
    }

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

    public String getFecha() {
        return fecha;
    }
    
    // Setters

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public static void setFormulario(FormularioData formulario) {
        FormularioData.formulario = formulario;
    }

    public String getJustificacion() {
        return justificacion;
    }

    public void setJustificacion(String justificacion) {
        this.justificacion = justificacion;
    }

    public String getAdjuntos() {
        return adjuntos;
    }

    public void setAdjuntos(String adjuntos) {
        this.adjuntos = adjuntos;
    }
    
    
    
    
}
