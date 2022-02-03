/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import utiles.Rut;

/**
 *
 * @author folke
 */
public class AlumnoAtendido {  
    public Rut rutAlumno;
    public String nombreCarrera;
    public int montoPagado;  
    public FormaPago formaPago;
    
    public AlumnoAtendido(){
        this.rutAlumno = new Rut();
        this.nombreCarrera = "";
        this.montoPagado = 0;
        this.formaPago = FormaPago.TarjetaCredito;
    }
    
    public AlumnoAtendido(Rut rut, String nombreCarrera, int montoPagado, FormaPago formaPago){
        this.rutAlumno = new Rut(rut);
        this.nombreCarrera = nombreCarrera;
        this.montoPagado = montoPagado;
        this.formaPago = formaPago;
    }
    
    public AlumnoAtendido(String rut, String nombreCarrera, int montoPagado, FormaPago formaPago){
        this.rutAlumno = new Rut(rut);
        this.nombreCarrera = nombreCarrera;
        this.montoPagado = montoPagado;
        this.formaPago = formaPago;
    }
    
    public AlumnoAtendido(Rut rut, String nombreCarrera, int montoPagado, String formaPago){
        this.rutAlumno = new Rut(rut);
        this.nombreCarrera = nombreCarrera;
        this.montoPagado = montoPagado;
        this.formaPago = FormaPago.valueOf(formaPago);
    }
    
    public AlumnoAtendido(String rut, String nombreCarrera, int montoPagado, String formaPago){
        this.rutAlumno = new Rut(rut);
        this.nombreCarrera = nombreCarrera;
        this.montoPagado = montoPagado;
        this.formaPago = FormaPago.valueOf(formaPago);
    }
    
    public AlumnoAtendido(AlumnoAtendido a){
        this.rutAlumno = new Rut(a.rutAlumno);
        this.nombreCarrera = a.nombreCarrera;
        this.montoPagado = a.montoPagado;
        this.formaPago = a.formaPago;
    }
    
    public AlumnoAtendido(String linea){
        String[] campos = linea.split(",");
        this.rutAlumno = new Rut(campos[0]);
        this.nombreCarrera = campos[1];
        this.montoPagado = Integer.parseInt(campos[2]);
        this.formaPago = FormaPago.valueOf(campos[3]);
    }
    
    public String toString(){
        StringBuilder s = new StringBuilder();
        
        s.append(rutAlumno);
        s.append(",");
        s.append(nombreCarrera);
        s.append(",");
        s.append(montoPagado);
        s.append(",");
        s.append(formaPago);
        
        return s.toString();
    }

    public Rut getRutAlumno() {
        return rutAlumno;
    }

    public void setRutAlumno(Rut rutAlumno) {
        this.rutAlumno = rutAlumno;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public int getMontoPagado() {
        return montoPagado;
    }

    public void setMontoPagado(int montoPagado) {
        this.montoPagado = montoPagado;
    }

    public FormaPago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }
    
    
}
