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
public class Administrativo {
    public int tiempo;
    
    public Administrativo(){ 
        this.tiempo = 0;
    }
    
    public Administrativo(int tiempo){
        this.tiempo = tiempo;
    }
    
    public Administrativo(Administrativo a){
        this.tiempo = a.tiempo;
    }
    
    public Administrativo(String linea){
        String[] campos = linea.split(","); 
        this.tiempo = Integer.parseInt(campos[0]);
    }
    
    public String toString(){
        StringBuilder s = new StringBuilder();
        
        s.append(tiempo);
        
        return s.toString();
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }
}
