/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colaDinamica;

import listaGenericaLLS.Nodo;

/**
 *
 * @author folke
 */
public class Cola<T> {
    private Nodo<T> ini;
    private Nodo<T> fin;
    
    public Cola(){
        ini= new Nodo(); //Nodo Basura
        fin= ini;
    }
    public Cola(int t){
        ini= new Nodo(); //Nodo Basura
        fin= ini;
    }
    
    public boolean add(T e){
        Nodo p= new Nodo();
        fin.setInfo(e); //en el Nodo Basura
        fin.setLink(p);
        fin= fin.getLink();
        return true; 
    }
    
    public boolean addFirst(T e){
        Nodo p= new Nodo();
        p.setInfo(e);
        p.setLink(ini);
        ini = p;
        //ini.setInfo(e); //en el Nodo Basura
        //p.setLink(ini);
        //ini = p.getLink();
        return true; 
    }
    
    public T remove(){
        T e= ini.getInfo();
        ini=ini.getLink();
        return e;
    }
    
    public T peek(){
        T e = ini.getInfo();
        return e;
    }
    
    public boolean isEmpty(){
        return ini==fin;
    }
    
    public String toString(){
        StringBuilder s= new StringBuilder();
        Nodo<T> p=ini;
        
        while (p!=fin){
            s.append(p.getInfo().toString()+"\n");
            p=p.getLink();
        } 
        return s.toString();
    }
    
    public int getTamaño(){
        Nodo<T> p;
        p = ini;
        int contador = 0;
        while (p != fin/*null*/){
            if (!p.getInfo().equals(null)){
                p = p.getLink();
                contador++;
            }
            else{
                break;
            }
        }
        return contador;
    }
}
