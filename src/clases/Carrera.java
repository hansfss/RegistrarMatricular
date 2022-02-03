/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import utiles.NombreCarrera;

/**
 *
 * @author folke
 */
public class Carrera {
    protected String codigo;
    protected String nombreCarrera;
    protected int valor;
    
    public Carrera(){
        this.codigo = "";
        this.nombreCarrera = "";
        this.valor = 0;
    }
    
    public Carrera(String codigo){
        this.codigo = codigo;
        this.nombreCarrera = "";
        this.valor = 0;
    }
    
    public Carrera(String nombre, int valor){
        this.codigo = "";
        this.nombreCarrera = nombre;
        this.valor = valor;
    }
    
    public Carrera(String nombre, String valor){
        this.codigo = "";
        this.nombreCarrera = nombre;
        this.valor = Integer.parseInt(valor);
    }
    
    public Carrera(String codigo, String nombre, int valor){
        this.codigo = codigo;
        this.nombreCarrera = nombre;
        this.valor = valor;
    }
    
    public Carrera(String codigo, String nombre, String valor){
        this.codigo = codigo;
        this.nombreCarrera = nombre;
        this.valor = Integer.parseInt(valor);
    }
    
    public Carrera(Carrera c){
        this.codigo = c.codigo;
        this.nombreCarrera = c.nombreCarrera;
        this.valor = c.valor;
    }
    
//    public Carrera(String c){
//        String[] campos = c.split(",");
//        this.codigo = campos[0];
//        this.nombreCarrera = campos[1];
//        this.valor = Integer.parseInt(campos[2]);
//    }
    
    public String toString(){
        StringBuilder s = new StringBuilder();

        s.append(codigo);
        s.append(",");
        s.append(nombreCarrera);
        s.append(",");
        s.append(valor);
        return s.toString();
    }
    
    public String codigoToString(){
        StringBuilder s = new StringBuilder();
        
        s.append(codigo);
        //s.append(",");
        return s.toString();
    }
    
    public String carreraToString(){
        StringBuilder s = new StringBuilder();
        
        s.append(nombreCarrera);
        //s.append(",");
        return s.toString();
    }
    
    public String valorToString(){
        StringBuilder s = new StringBuilder();
        
        s.append(valor);
        //s.append(",");
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    
    
}
