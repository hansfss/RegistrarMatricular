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
public class NombreCarrera {
    private String palabra1;
    private String palabra2;
    private String palabra3;
    private String palabra4;
    private String palabra5;
    private String palabra6;
    
    public NombreCarrera(){
        this.palabra1 = null;
        this.palabra2 = null;
        this.palabra3 = null;
        this.palabra4 = null;
        this.palabra5 = null;
        this.palabra6 = null;
    }
    
    public NombreCarrera(String p1, String p2){
        this.palabra1 = p1;
        this.palabra2 = p2;
        this.palabra3 = null;
        this.palabra4 = null;
        this.palabra5 = null;
        this.palabra6 = null;
    }
    
    public NombreCarrera(String p1, String p2, String p3){
        this.palabra1 = p1;
        this.palabra2 = p2;
        this.palabra3 = p3;
        this.palabra4 = null;
        this.palabra5 = null;
        this.palabra6 = null;
    }
    
    public NombreCarrera(String p1, String p2, String p3, String p4){
        this.palabra1 = p1;
        this.palabra2 = p2;
        this.palabra3 = p3;
        this.palabra4 = p4;
        this.palabra5 = null;
        this.palabra6 = null;
    }
    
    public NombreCarrera(String p1, String p2, String p3, String p4, String p5){
        this.palabra1 = p1;
        this.palabra2 = p2;
        this.palabra3 = p3;
        this.palabra4 = p4;
        this.palabra5 = p5;
        this.palabra6 = null;
    }
    
    public NombreCarrera(String p1, String p2, String p3, String p4, String p5, String p6){
        this.palabra1 = p1;
        this.palabra2 = p2;
        this.palabra3 = p3;
        this.palabra4 = p4;
        this.palabra5 = p5;
        this.palabra6 = p6;
    }
    
    public NombreCarrera(NombreCarrera n){
        this.palabra1 = n.palabra1;
        this.palabra2 = n.palabra2;
        this.palabra3 = n.palabra3;
        this.palabra4 = n.palabra4;
        this.palabra5 = n.palabra5;
        this.palabra6 = n.palabra6;
    }
    
    public NombreCarrera(String n){
        String[] campos = n.split(" ");
        this.palabra1 = campos[0];
        this.palabra2 = campos[1];
        this.palabra3 = campos[2];
        this.palabra4 = campos[3];
        this.palabra5 = campos[4];
        this.palabra6 = campos[5];
    }
    
    public String toString(){
        String s = palabra1 + " " + palabra2 + " " + palabra3 + " " + palabra4 + " " + palabra5 + " " + palabra6;
        return s;
    }
    
    public String toSave(String archivo){
        String s = palabra1 + "," + palabra2 + "," + palabra3 + "," + palabra4 + "," + palabra5 + "," + palabra6;
        return s;
    }
    
    public boolean equals(NombreCarrera n){
        if (palabra1.equals(n.palabra1) &&
            palabra2.equals(n.palabra2) && 
            palabra3.equals(n.palabra3) &&
            palabra4.equals(n.palabra4) &&
            palabra5.equals(n.palabra5) &&
            palabra6.equals(n.palabra6)){
            return true;
        }
        return false;
    }

    public String getPalabra1() {
        return palabra1;
    }

    public void setPalabra1(String palabra1) {
        this.palabra1 = palabra1;
    }

    public String getPalabra2() {
        return palabra2;
    }

    public void setPalabra2(String palabra2) {
        this.palabra2 = palabra2;
    }

    public String getPalabra3() {
        return palabra3;
    }

    public void setPalabra3(String palabra3) {
        this.palabra3 = palabra3;
    }

    public String getPalabra4() {
        return palabra4;
    }

    public void setPalabra4(String palabra4) {
        this.palabra4 = palabra4;
    }

    public String getPalabra5() {
        return palabra5;
    }

    public void setPalabra5(String palabra5) {
        this.palabra5 = palabra5;
    }

    public String getPalabra6() {
        return palabra6;
    }

    public void setPalabra6(String palabra6) {
        this.palabra6 = palabra6;
    }
    
    
}
