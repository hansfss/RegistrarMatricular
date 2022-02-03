/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queue;

import colaDinamica.Cola;

/**
 *
 * @author folke
 */
public class Queue<T> {
    private Cola<T> cola;
    
    public Queue(){
        cola= new Cola();
    }
    public Queue(int n){
        cola= new Cola(n);
    }
    public boolean add(T e){
        return cola.add(e);        
    }
    
    public T remove(){
        return cola.remove();
    }
    
    public boolean isEmpty(){
        return cola.isEmpty();
    }
    public String toString(){
        return cola.toString();
    }
}
