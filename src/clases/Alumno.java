/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import utiles.Rut;

/**
 *
 * @author folke
 */
public class Alumno /*extends Carrera*/ {
    private Rut rutAlumno;
    private String nombre;
    private Patrocinador patrocinador;
    private Rut rutPatrocinador;
    private String codigoCarrera;
    private Beca beca;
    private int montoBeca;
    private int duracion;
    public FormaPago formaPago;
    
    public Alumno(){
        //super();
        this.rutAlumno = new Rut();
        this.nombre = "";
        this.patrocinador = Patrocinador.Tiene_Patrocinador;
        this.rutPatrocinador = new Rut();
        this.codigoCarrera = "";
        this.beca = Beca.No;
        this.montoBeca = 0;
        this.duracion = 0;
        this.formaPago = FormaPago.TarjetaCredito;
    }
    
    
    
    public Alumno(Rut rutA, String nombre, Patrocinador pat, Rut rutP, String codigo, Beca beca, int monto, int duracion, FormaPago pago){
        //super(codigo);
        this.rutAlumno = new Rut(rutA);
        this.nombre = nombre;
        this.patrocinador = pat;
        this.rutPatrocinador = new Rut(rutP);
        this.codigoCarrera = codigo;
        this.beca = beca;
        this.montoBeca = monto;
        this.duracion = duracion;
        this.formaPago = pago;
    }
    
    public Alumno(Rut rutA, String nombre, String pat, Rut rutP, String codigo, String beca, int monto, int duracion, String pago){
        //super(codigo);
        this.rutAlumno = new Rut(rutA);
        this.nombre = nombre;
        this.patrocinador = Patrocinador.valueOf(pat);
        this.rutPatrocinador = new Rut(rutP);
        this.codigoCarrera = codigo;
        this.beca = Beca.valueOf(beca);
        this.montoBeca = monto;
        this.duracion = duracion;
        this.formaPago = FormaPago.valueOf(pago);
    }      
    
    public Alumno(String rutA, String nombre, Patrocinador pat, String rutP, String codigo, Beca beca, int monto, int duracion, FormaPago pago){
        //super(codigo);
        this.rutAlumno = new Rut(rutA);
        this.nombre = nombre;
        this.patrocinador = pat;
        this.rutPatrocinador = new Rut(rutP);
        this.codigoCarrera = codigo;
        this.beca = beca;
        this.montoBeca = monto;
        this.duracion = duracion;
        this.formaPago = pago;
    }       
    
    public Alumno(String rutA, String nombre, String pat, String rutP, String codigo, String beca, int monto, int duracion, String pago){
        //super(codigo);
        this.rutAlumno = new Rut(rutA);
        this.nombre = nombre;
        this.patrocinador = Patrocinador.valueOf(pat);
        this.rutPatrocinador = new Rut(rutP);
        this.codigoCarrera = codigo;
        this.beca = Beca.valueOf(beca);
        this.montoBeca = monto;
        this.duracion = duracion;
        this.formaPago = FormaPago.valueOf(pago);
    }      
    
    public Alumno(String rutA, String nombre, String pat, String rutP, String codigo, String beca, String monto, String duracion, String pago){
        //super(codigo);
        this.rutAlumno = new Rut(rutA);
        this.nombre = nombre;
        this.patrocinador = Patrocinador.valueOf(pat);
        this.rutPatrocinador = new Rut(rutP);
        this.codigoCarrera = codigo;
        this.beca = Beca.valueOf(beca);
        this.montoBeca = Integer.parseInt(monto);
        this.duracion = Integer.parseInt(duracion);
        this.formaPago = FormaPago.valueOf(pago);
    }      
    
    public Alumno(Rut rutA, String nombre, String pat, Rut rutP, String codigo, String beca, String monto, String duracion, String pago){
        //super(codigo);
        this.rutAlumno = new Rut(rutA);
        this.nombre = nombre;
        this.patrocinador = Patrocinador.valueOf(pat);
        this.rutPatrocinador = new Rut(rutP);
        this.codigoCarrera = codigo;
        this.beca = Beca.valueOf(beca);
        this.montoBeca = Integer.parseInt(monto);
        this.duracion = Integer.parseInt(duracion);
        this.formaPago = FormaPago.valueOf(pago);
    }      
    
    public Alumno(String rutA, String nombre, String pat, String codigo, String beca, int monto, int duracion, String pago){
        //super(codigo);
        this.rutAlumno = new Rut(rutA);
        this.nombre = nombre;
        this.patrocinador = Patrocinador.valueOf(pat);
        this.codigoCarrera = codigo;
        this.beca = Beca.valueOf(beca);
        this.montoBeca = monto;
        this.duracion = duracion;
        this.formaPago = FormaPago.valueOf(pago);
    }     
    
    public Alumno(String rutA, String nombre, Patrocinador pat, String codigo, Beca beca, int monto, int duracion, FormaPago pago){
        //super(codigo);
        this.rutAlumno = new Rut(rutA);
        this.nombre = nombre;
        this.patrocinador = pat;
        this.codigoCarrera = codigo;
        this.beca = beca;
        this.montoBeca = monto;
        this.duracion = duracion;
        this.formaPago = pago;
    }     
    
    public Alumno(Rut rutA, String nombre, String pat, String codigo, String beca, int monto, int duracion, String pago){
        //super(codigo);
        this.rutAlumno = new Rut(rutA);
        this.nombre = nombre;
        this.patrocinador = Patrocinador.valueOf(pat);
        this.codigoCarrera = codigo;
        this.beca = Beca.valueOf(beca);
        this.montoBeca = monto;
        this.duracion = duracion;
        this.formaPago = FormaPago.valueOf(pago);
    }      
    
    public Alumno(Rut rutA, String nombre, String pat, String codigo, String beca, String monto, String duracion, String pago){
        //super(codigo);
        this.rutAlumno = new Rut(rutA);
        this.nombre = nombre;
        this.patrocinador = Patrocinador.valueOf(pat);
        this.codigoCarrera = codigo;
        this.beca = Beca.valueOf(beca);
        this.montoBeca = Integer.parseInt(monto);
        this.duracion = Integer.parseInt(duracion);
        this.formaPago = FormaPago.valueOf(pago);
    }     
    
    public Alumno(Rut rutA, String nombre, Patrocinador pat, String codigo, Beca beca, int monto, int duracion, FormaPago pago){
        //super(codigo);
        this.rutAlumno = new Rut(rutA);
        this.nombre = nombre;
        this.patrocinador = pat;
        this.codigoCarrera = codigo;
        this.beca = beca;
        this.montoBeca = monto;
        this.duracion = duracion;
        this.formaPago = pago;
    }      
    
    public Alumno(Rut rutA, String nombre, Patrocinador pat, String codigo, Beca beca, int duracion, FormaPago pago){
        //super(codigo);
        this.rutAlumno = new Rut(rutA);
        this.nombre = nombre;
        this.patrocinador = pat;
        this.codigoCarrera = codigo;
        this.beca = beca;
        this.duracion = duracion;
        this.formaPago = pago;
    }     
    
    public Alumno(Rut rutA, String nombre, Patrocinador pat, String codigo, String beca, int duracion, FormaPago pago){
        //super(codigo);
        this.rutAlumno = new Rut(rutA);
        this.nombre = nombre;
        this.patrocinador = pat;
        this.codigoCarrera = codigo;
        this.beca = Beca.valueOf(beca);
        this.duracion = duracion;
        this.formaPago = pago;
    }     
    
    public Alumno(Rut rutA, String nombre, String pat, String codigo, String beca, String duracion, String pago){
        //super(codigo);
        this.rutAlumno = new Rut(rutA);
        this.nombre = nombre;
        this.patrocinador = Patrocinador.valueOf(pat);
        this.codigoCarrera = codigo;
        this.beca = Beca.valueOf(beca);
        this.duracion = Integer.parseInt(duracion);
        this.formaPago = FormaPago.valueOf(pago);
    }     
    
    public Alumno(String rutA, String nombre, String pat, String codigo, String beca, int duracion, String pago){
        //super(codigo);
        this.rutAlumno = new Rut(rutA);
        this.nombre = nombre;
        this.patrocinador = Patrocinador.valueOf(pat);
        this.codigoCarrera = codigo;
        this.beca = Beca.valueOf(beca);
        this.duracion = duracion;
        this.formaPago = FormaPago.valueOf(pago);
    }     
    
    public Alumno(Rut rutA, String nombre, String pat, Rut rutP, String codigo, String beca, String duracion, String pago){
        //super(codigo);
        this.rutAlumno = new Rut(rutA);
        this.nombre = nombre;
        this.patrocinador = Patrocinador.valueOf(pat);
        this.rutPatrocinador = new Rut(rutP);
        this.codigoCarrera = codigo;
        this.beca = Beca.valueOf(beca);
        this.duracion = Integer.parseInt(duracion);
        this.formaPago = FormaPago.valueOf(pago);
    }     
    
    public Alumno(String rutA, String nombre, String pat, String rutP, String codigo, String beca, int duracion, String pago){
        //super(codigo);
        this.rutAlumno = new Rut(rutA);
        this.nombre = nombre;
        this.patrocinador = Patrocinador.valueOf(pat);
        this.rutPatrocinador = new Rut(rutP);
        this.codigoCarrera = codigo;
        this.beca = Beca.valueOf(beca);
        this.duracion = duracion;
        this.formaPago = FormaPago.valueOf(pago);
    }     
    
    public Alumno(Alumno a){
        //super(a.codigo/*, a.nombreCarrera, a.valor*/);
        this.rutAlumno = a.rutAlumno;
        this.nombre = a.nombre;
        this.patrocinador= a.patrocinador;
        this.rutPatrocinador = a.rutPatrocinador;
        this.codigoCarrera = a.codigoCarrera;
        this.beca = a.beca;
        this.montoBeca = a.montoBeca;
        this.duracion = a.duracion;
        this.formaPago = a.formaPago;
    }
    
    public Alumno(String linea){
        //super();
        String[] campos = linea.split(",");
        this.rutAlumno = new Rut(campos[0]);
        this.nombre = campos[1];
        this.patrocinador = Patrocinador.valueOf(campos[2]);
        if (Patrocinador.valueOf(campos[2]).equals(Patrocinador.Tiene_Patrocinador)){
            this.rutPatrocinador = new Rut(campos[3]);
            //this.codigo = campos[4];
            this.codigoCarrera = campos[4];
            this.beca = Beca.valueOf(campos[5]);
            if(Beca.valueOf(campos[5]).equals(Beca.Si)){
                this.montoBeca = Integer.parseInt(campos[6]);
                this.duracion = Integer.parseInt(campos[7]);
                this.formaPago = FormaPago.valueOf(campos[8]);
            }
            else{
                this.duracion = Integer.parseInt(campos[6]);
                this.formaPago = FormaPago.valueOf(campos[7]);
            }
        }
        else{
            this.codigoCarrera = campos[3];
            //this.codigo = campos[3];
            this.beca = Beca.valueOf(campos[4]);
            if(Beca.valueOf(campos[4]).equals(Beca.Si)){
                this.montoBeca = Integer.parseInt(campos[5]);
                this.duracion = Integer.parseInt(campos[6]);
                this.formaPago = FormaPago.valueOf(campos[7]);
            }
            else{
                this.duracion = Integer.parseInt(campos[5]);
                this.formaPago = FormaPago.valueOf(campos[6]); 
            }
        }
    }    
    
    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append(rutAlumno);
        s.append(",");
        s.append(nombre);
        s.append(",");
        s.append(patrocinador);
        s.append(",");
        if (patrocinador.equals(Patrocinador.Tiene_Patrocinador)){
            s.append(rutPatrocinador);
            s.append(",");
            s.append(codigoCarrera);
            //s.append(super.codigoToString());
            s.append(",");
            s.append(beca);
            s.append(",");
            if (beca.equals(Beca.Si)){
                s.append(montoBeca);
                s.append(",");
                s.append(duracion);
                s.append(",");
                s.append(formaPago);
            }
            else{
                s.append(duracion);
                s.append(",");
                s.append(formaPago);
            }
        }
        else{
            s.append(codigoCarrera);
            //s.append(super.codigoToString());
            s.append(",");
            s.append(beca);
            s.append(",");
            if (beca.equals(Beca.Si)){
                s.append(montoBeca);
                s.append(",");
                s.append(duracion);
                s.append(",");
                s.append(formaPago);
            }
            else{
                s.append(duracion);
                s.append(",");
                s.append(formaPago);
            }
        }
        return s.toString();
    }
    
    
    
    public String rutToString(){
        StringBuilder s = new StringBuilder();
        s.append(rutAlumno);
        return s.toString();
    }
    
    public boolean toSave(String archivo){
        boolean estaOk = false;
        try{
            FileWriter f = new FileWriter(archivo, true);
            PrintWriter p = new PrintWriter(f);
            p.println(this.toString());
            p.close();
            f.close();
            estaOk = true;
        }
        catch(IOException ex){
            estaOk = false;
        }
        
        
        return estaOk;
    }

    public Rut getRutAlumno() {
        return rutAlumno;
    }

    public void setRutAlumno(Rut rutAlumno) {
        this.rutAlumno = rutAlumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Patrocinador getPatrocinador() {
        return patrocinador;
    }

    public void setPatrocinador(Patrocinador patrocinador) {
        this.patrocinador = patrocinador;
    }

    public Rut getRutPatrocinador() {
        return rutPatrocinador;
    }

    public void setRutPatrocinador(Rut rutPatrocinador) {
        this.rutPatrocinador = rutPatrocinador;
    }

    public Beca getBeca() {
        return beca;
    }

    public void setBeca(Beca beca) {
        this.beca = beca;
    }

    public int getMontoBeca() {
        return montoBeca;
    }

    public void setMontoBeca(int montoBeca) {
        this.montoBeca = montoBeca;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public FormaPago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }

    public String getCodigoCarrera() {
        return codigoCarrera;
    }

    public void setCodigoCarrera(String codigoCarrera) {
        this.codigoCarrera = codigoCarrera;
    }
    
}
