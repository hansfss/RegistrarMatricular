/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utiles;

/**
 *
 * @author folke
 */
public class Cliente {
    private Rut rut;
    private String nombre;
    
    public Cliente(){
        rut=new Rut();
        nombre="";
    }
    public Cliente(Rut r){
        rut= new Rut(r);
        nombre="";
    }
    public Cliente(String nombre){
        rut= new Rut();
        this.nombre=nombre;
    }
    public Cliente(Rut r, String n){
        rut= new Rut(r);
        nombre= n;
    }
    
    public Cliente(String r, String n){
        rut= new Rut(r);
        nombre= n;
    }
    
    public Cliente(Cliente c){
        rut= new Rut(c.rut);
        nombre= c.nombre;
    }
    public void setRut(Rut r){
        rut= new Rut(r);
    }
    public Rut getRut(){
        return rut;
    }
    public void setNombre(String nom){
        nombre=nom;
    }
    public String getNombre(){
        return nombre;
    }
    //Sobre-escritura de toString()
    @Override
    public String toString(){
        return rut.toString()+","+nombre;       
    }
}
